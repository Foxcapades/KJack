@file:Suppress("NOTHING_TO_INLINE")

package io.foxcapades.lib.kjack

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import java.math.BigDecimal
import java.math.BigInteger


/**
 * Ensures the receiver value is an [ArrayNode] and then returns that value cast
 * to [ArrayNode].
 *
 * If the receiver is not an [ArrayNode] an [IllegalStateException] will be
 * thrown.
 *
 * @receiver Json value to check and cast.
 *
 * @throws IllegalStateException If the receiver value is not a json array.
 */
inline fun JsonNode.requireArray() =
  requireArray { IllegalStateException("JsonNode was not an array.") }

/**
 * Ensures the receiver value is an [ArrayNode] and then returns that value cast
 * to [ArrayNode].
 *
 * If the receiver is not an [ArrayNode] the [Exception] returned by the param
 * [err] will be thrown.
 *
 * @receiver Json value to check and cast.
 *
 * @param err Exception provider providing the exception to throw if the
 * receiver value is not an [ArrayNode]
 */
inline fun JsonNode.requireArray(err: () -> Exception) =
  if (isArray)
    this as ArrayNode
  else
    throw err()


/**
 * Ensures the receiver value is a number, then returns that value as a
 * [BigDecimal].
 *
 * If the value is not a number, this method will throw an
 * [IllegalStateException]
 *
 * @receiver Json value to check and cast.
 */
inline fun JsonNode.requireBigDecimal() =
  requireBigDecimal {
    IllegalStateException("JsonNode was not a BigDecimal value.")
  }

/**
 * Ensures the receiver value is a number, then returns that value as a
 * [BigDecimal].
 *
 * If the value is not a number, this method will throw the [Exception] returned
 * by the given provider.
 *
 * @receiver Json value to check and cast.
 *
 * @param err Exception provider.
 */
inline fun JsonNode.requireBigDecimal(err: () -> Exception): BigDecimal =
  if (isNumber)
    decimalValue()
  else
    throw err()


inline fun JsonNode.requireBigInteger() =
  requireBigInteger {
    IllegalStateException("JsonNode was not a BigInteger value.")
  }

inline fun JsonNode.requireBigInteger(err: () -> Exception): BigInteger =
  if (isIntegralNumber)
    bigIntegerValue()
  else
    throw err()


inline fun JsonNode.requireBoolean() =
  requireBoolean { IllegalStateException("JsonNode was not a boolean value.") }

inline fun JsonNode.requireBoolean(err: () -> Exception) =
  if (isBoolean)
    booleanValue()
  else
    throw err()


inline fun JsonNode.requireByte() =
  requireByte { IllegalStateException("JsonNode was not a byte value.") }

inline fun JsonNode.requireByte(err: () -> Exception) =
  if (!isIntegralNumber)
    throw err()
  else
    with(intValue()) {
      if (this !in Byte.MIN_VALUE .. Byte.MAX_VALUE) throw err()
      toByte()
    }


inline fun JsonNode.requireDouble() =
  requireDouble { IllegalStateException("JsonNode was not a valid double value.") }

inline fun JsonNode.requireDouble(err: () -> Exception) =
  when {
    !isNumber -> throw err()
    else      -> with(BigDecimal(asText().trimDecimal())) {
      if (BigDecimal(doubleValue().toString().trimDecimal()) != this)
        throw err()
      toDouble()
    }
  }


inline fun JsonNode.requireFloat() =
  requireFloat { IllegalStateException("JsonNode was not a float value.") }

inline fun JsonNode.requireFloat(err: () -> Exception) =
  if (!isNumber)
    throw err()
  else
    with(BigDecimal(asText().trimDecimal())) {
      if (BigDecimal(floatValue().toString()) != this)
        throw err()
      toFloat()
    }


inline fun JsonNode.requireInt() =
  requireInt { IllegalStateException("JsonNode was not an int value.") }

inline fun JsonNode.requireInt(err: () -> Exception) =
  if (!isIntegralNumber)
    throw err()
  else
    with(longValue()) {
      if (this > Int.MAX_VALUE) throw err()
      if (this < Int.MIN_VALUE) throw err()
      toInt()
    }


inline fun JsonNode.requireLong() =
  requireLong { IllegalStateException("JsonNode was not a long value.") }

inline fun JsonNode.requireLong(err: () -> Exception): Long =
  if (!isIntegralNumber)
    throw err()
  else
    with(bigIntegerValue()) {
      if (this > BigInteger.valueOf(Long.MAX_VALUE)) throw err()
      if (this < BigInteger.valueOf(Long.MIN_VALUE)) throw err()
      longValue()
    }


inline fun JsonNode.requireObject() =
  requireObject { IllegalStateException("JsonNode was not an object.") }

inline fun JsonNode.requireObject(err: () -> Exception) =
  if (!isObject)
    throw err()
  else
    this as ObjectNode


inline fun JsonNode.requireShort() =
  requireShort { IllegalStateException("JsonNode was not a short value.") }

inline fun JsonNode.requireShort(err: () -> Exception) =
  if (!isIntegralNumber)
    throw err()
  else
    with(intValue()) {
      if (this > Short.MAX_VALUE) throw err()
      if (this < Short.MIN_VALUE) throw err()
      toShort()
    }


inline fun JsonNode.requireString() =
  requireString { IllegalStateException("JsonNode was not a string value.") }

inline fun JsonNode.requireString(err: () -> Exception): String =
  if (!isTextual)
    throw err()
  else
    textValue()


inline fun JsonNode.requireUByte() =
  requireUByte { IllegalStateException("JsonNode was not a ubyte value.") }

inline fun JsonNode.requireUByte(err: () -> Exception) =
  if (!isIntegralNumber)
    throw err()
  else
    with(intValue()) {
      if (this !in 0 .. 255)
        throw err()
      toUByte()
    }


inline fun JsonNode.requireUInt() =
  requireUInt { IllegalStateException("JsonNode was not a ubyte value.") }

inline fun JsonNode.requireUInt(err: () -> Exception) =
  if (!isIntegralNumber)
    throw err()
  else
    with(longValue()) {
      if (this !in 0 .. UInt.MAX_VALUE.toLong())
        throw err()
      toUInt()
    }


inline fun JsonNode.requireULong() =
  requireULong { IllegalStateException("JsonNode was not a ubyte value.") }

inline fun JsonNode.requireULong(err: () -> Exception) =
  if (!isIntegralNumber)
    throw err()
  else
    with(bigIntegerValue()) {
      if (this !in BigInteger.ZERO .. BigInteger(ULong.MAX_VALUE.toString()))
        throw err()
      toString(10).toULong()
    }


inline fun JsonNode.requireUShort() =
  requireUShort { IllegalStateException("JsonNode was not a ubyte value.") }

inline fun JsonNode.requireUShort(err: () -> Exception) =
  if (!isIntegralNumber)
    throw err()
  else
    with(intValue()) {
      if (this !in 0 .. UShort.MAX_VALUE.toInt())
        throw err()
      toUShort()
    }


inline fun String.trimDecimal() =
  if (endsWith(".0"))
    substring(0 .. length - 3)
  else
    this