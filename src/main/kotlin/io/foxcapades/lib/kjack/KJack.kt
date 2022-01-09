package io.foxcapades.lib.kjack

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.*
import java.math.BigDecimal
import java.math.BigInteger

object KJack {
  val Jackson = ObjectMapper()

  inline fun objectNode(action: ObjectNode.() -> Unit): ObjectNode =
    Jackson.createObjectNode().apply(action)

  inline fun arrayNode(size: Int = 1, action: ArrayNode.() -> Unit) =
    ArrayNode(Jackson.nodeFactory, size).apply(action)

  inline fun text(string: String) = TextNode(string)

  inline fun byte(byte: Byte) = IntNode(byte.toInt())

  inline fun ubyte(uByte: UByte) = IntNode(uByte.toInt())

  inline fun short(short: Short) = ShortNode(short)

  inline fun ushort(uShort: UShort) = IntNode(uShort.toInt())

  inline fun int(int: Int) = IntNode(int)

  inline fun uint(uInt: UInt) = LongNode(uInt.toLong())

  inline fun long(long: Long) = LongNode(long)

  inline fun ulong(uLong: ULong) =
    BigIntegerNode(BigInteger(uLong.toString()))

  inline fun bigInteger(big: BigInteger) = BigIntegerNode(big)

  inline fun float(float: Float) = FloatNode(float)

  inline fun double(double: Double) = DoubleNode(double)

  inline fun bigDecimal(big: BigDecimal) = DecimalNode(big)

  inline fun bool(boolean: Boolean) =
    if (boolean) BooleanNode.TRUE else BooleanNode.FALSE

  inline fun nullNode() = NullNode.instance
}