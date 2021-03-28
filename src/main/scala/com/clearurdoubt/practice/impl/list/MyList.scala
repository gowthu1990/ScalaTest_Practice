package com.clearurdoubt.practice.impl.list

import scala.annotation.tailrec

trait MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean

  def +[B >: A](elem: B): MyList[B]
  def ++[B >: A](another: MyList[B]): MyList[B]

  def map[B >: A](func: A => B): MyList[B]
  def flatMap[B >: A](func: A => MyList[B]): MyList[B]
  def filter(func: A => Boolean): MyList[A]
  def foreach(func: A => Unit): Unit
}

object EmptyList extends MyList[Nothing] {

  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def +[B >: Nothing](elem: B): MyList[B] = new NonEmptyList(elem, EmptyList)

  override def ++[B >: Nothing](another: MyList[B]): MyList[B] = another

  override def map[B >: Nothing](func: Nothing => B): MyList[B] = EmptyList

  override def flatMap[B >: Nothing](func: Nothing => MyList[B]): MyList[B] = EmptyList

  override def filter(func: Nothing => Boolean): MyList[Nothing] = EmptyList

  override def foreach(func: Nothing => Unit): Unit = ()

  override def toString: String = "MyList()"
}

class NonEmptyList[A](h: A, t: MyList[A]) extends MyList[A] {

  def head: A = h
  def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def +[B >: A](elem: B): MyList[B] = new NonEmptyList[B](h = elem, this)

  override def ++[B >: A](another: MyList[B]): MyList[B] = new NonEmptyList[B](h, this ++ another)

  override def map[B >: A](func: A => B): MyList[B] = (t map func) + func(h)

  override def flatMap[B >: A](func: A => MyList[B]): MyList[B] = (t flatMap func) ++ func(h)

  override def filter(predicate: A => Boolean): MyList[A] = {
    val filteredTail = t filter predicate

    if(predicate(h)) filteredTail + h
    else filteredTail
  }

  override def foreach(func: A => Unit): Unit = {
    t foreach func
    func(h)
  }
  override def toString: String = {
    @tailrec
    def elementsAsAString(myList: MyList[A], acc: String): String =
      if(myList.isEmpty) acc
      else
        elementsAsAString(myList.tail,
          if(acc.isEmpty) myList.head.toString
          else myList.head + ", " + acc
        )

    "MyList(" + elementsAsAString(this, "") + ")"
  }
}

object MyList {
  def apply[A](elements: A*): MyList[A] = {
    @tailrec
    def buildList(elementsSeq: Seq[A], acc: MyList[A]): MyList[A] =
      if(elementsSeq.isEmpty) acc
      else buildList(elementsSeq.tail, acc + elementsSeq.head)

    buildList(elements.toSeq, EmptyList)
  }
}