@file:Suppress("NOTHING_TO_INLINE")

package io.foxcapades.lib.kjack

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.*
import java.math.BigDecimal
import java.math.BigInteger

object KJack {
  val Jackson = ObjectMapper()

  /**
   * Creates a new json object, configured by the given action.
   */
  inline fun objectNode(action: ObjectNode.() -> Unit): ObjectNode =
    Jackson.createObjectNode().apply(action)

  /**
   * Creates a new json array, configured by the given action.
   */
  inline fun arrayNode(size: Int = 1, action: ArrayNode.() -> Unit) =
    ArrayNode(Jackson.nodeFactory, size).apply(action)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun text(string: String) = TextNode(string)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun byte(byte: Byte) = IntNode(byte.toInt())

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun ubyte(uByte: UByte) = IntNode(uByte.toInt())

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun short(short: Short) = ShortNode(short)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun ushort(uShort: UShort) = IntNode(uShort.toInt())

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun int(int: Int) = IntNode(int)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun uint(uInt: UInt) = LongNode(uInt.toLong())

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun long(long: Long) = LongNode(long)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun ulong(uLong: ULong) =
    BigIntegerNode(BigInteger(uLong.toString()))

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun bigInteger(big: BigInteger) = BigIntegerNode(big)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun float(float: Float) = FloatNode(float)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun double(double: Double) = DoubleNode(double)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun bigDecimal(big: BigDecimal) = DecimalNode(big)

  /**
   * Creates a new json node wrapping the given value.
   */
  inline fun bool(boolean: Boolean) =
    if (boolean) BooleanNode.TRUE else BooleanNode.FALSE

  /**
   * Creates a new null json node.
   */
  inline fun nullNode() = NullNode.instance
}