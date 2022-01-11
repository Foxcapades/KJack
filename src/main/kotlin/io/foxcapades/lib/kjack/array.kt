@file:Suppress("NOTHING_TO_INLINE")
@file:OptIn(ExperimentalUnsignedTypes::class)

package io.foxcapades.lib.kjack

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.util.RawValue
import java.math.BigDecimal
import java.math.BigInteger

/**
 * Adds an object to the receiver node, configured by the given action.
 *
 * @param action Action that configures the newly created [ArrayNode].
 */
inline fun ArrayNode.addObject(action: ObjectNode.() -> Unit) {
  add(KJack.objectNode(action))
}

/**
 * Sets an object to the receiver node, configured by the given action.
 *
 * @param index  Index the new object should be set at (will overwrite any
 * existing value).
 * @param action Action that configures the newly created [ArrayNode].
 */
inline fun ArrayNode.setObject(index: Int, action: ObjectNode.() -> Unit) {
  set(index, KJack.objectNode(action))
}

/**
 * Adds an array to the receiver node, configured by the given action.
 *
 * @param size   Size to presize the newly created array to.
 * @param action Action that configures the newly created [ArrayNode].
 */
inline fun ArrayNode.addArray(size: Int = 1, action: ArrayNode.() -> Unit) {
  add(KJack.arrayNode(size, action))
}

/**
 * Sets an array to the receiver node, configured by the given action.
 *
 * @param index  Index the new array should be set at (will overwrite any
 * existing value).
 * @param size   Size to presize the newly created array to.
 * @param action Action that configures the newly created [ArrayNode].
 */
inline fun ArrayNode.setArray(
  index: Int,
  size: Int = 1,
  action: ArrayNode.() -> Unit,
) {
  set(index, KJack.arrayNode(size, action))
}

// region Add If Not Null

inline fun ArrayNode.addIfNN(value: Byte?) {
  if (value != null)
    add(value.toInt())
}

inline fun ArrayNode.addIfNN(value: UByte?) {
  if (value != null)
    add(value.toInt())
}

inline fun ArrayNode.addIfNN(value: Short?) {
  if (value != null)
    add(value.toInt())
}

inline fun ArrayNode.addIfNN(value: UShort?) {
  if (value != null)
    add(value.toInt())
}

inline fun ArrayNode.addIfNN(value: Int?) {
  if (value != null)
    add(value)
}

inline fun ArrayNode.addIfNN(value: UInt?) {
  if (value != null)
    add(value.toLong())
}

inline fun ArrayNode.addIfNN(value: Long?) {
  if (value != null)
    add(value)
}

inline fun ArrayNode.addIfNN(value: ULong?) {
  if (value != null)
    add(BigInteger(value.toString()))
}

inline fun ArrayNode.addIfNN(value: BigInteger?) {
  if (value != null)
    add(value)
}

inline fun ArrayNode.addIfNN(value: BigDecimal?) {
  if (value != null)
    add(value)
}

inline fun ArrayNode.addIfNN(value: Float?) {
  if (value != null)
    add(value)
}

inline fun ArrayNode.addIfNN(value: Double?) {
  if (value != null)
    add(value)
}

inline fun ArrayNode.addIfNN(value: Boolean?) {
  if (value != null)
    add(value)
}

inline fun ArrayNode.addIfNN(value: String?) {
  if (value != null)
    add(value)
}

inline fun ArrayNode.addIfNN(value: JsonNode?) {
  if (value != null)
    addRawValue(RawValue(value))
}

// endregion

// region Set If Not Null

inline fun ArrayNode.setIfNN(index: Int, value: Byte?) {
  if (value != null)
    set(index, value.toInt())
}

inline fun ArrayNode.setIfNN(index: Int, value: UByte?) {
  if (value != null)
    set(index, value.toInt())
}

inline fun ArrayNode.setIfNN(index: Int, value: Short?) {
  if (value != null)
    set(index, value.toInt())
}

inline fun ArrayNode.setIfNN(index: Int, value: UShort?) {
  if (value != null)
    set(index, value.toInt())
}

inline fun ArrayNode.setIfNN(index: Int, value: Int?) {
  if (value != null)
    set(index, value)
}

inline fun ArrayNode.setIfNN(index: Int, value: UInt?) {
  if (value != null)
    set(index, value.toLong())
}

inline fun ArrayNode.setIfNN(index: Int, value: Long?) {
  if (value != null)
    set(index, value)
}

inline fun ArrayNode.setIfNN(index: Int, value: ULong?) {
  if (value != null)
    set(index, BigInteger(value.toString()))
}

inline fun ArrayNode.setIfNN(index: Int, value: BigInteger?) {
  if (value != null)
    set(index, value)
}

inline fun ArrayNode.setIfNN(index: Int, value: BigDecimal?) {
  if (value != null)
    set(index, value)
}

inline fun ArrayNode.setIfNN(index: Int, value: Float?) {
  if (value != null)
    set(index, value)
}

inline fun ArrayNode.setIfNN(index: Int, value: Double?) {
  if (value != null)
    set(index, value)
}

inline fun ArrayNode.setIfNN(index: Int, value: Boolean?) {
  if (value != null)
    set(index, value)
}

inline fun ArrayNode.setIfNN(index: Int, value: String?) {
  if (value != null)
    set(index, value)
}

inline fun ArrayNode.setIfNN(index: Int, value: JsonNode?) {
  if (value != null)
    setRawValue(index, RawValue(value))
}

// endregion

// region Add All

inline fun ArrayNode.addAll(vararg values: Byte) {
  values.forEach { add(it.toInt()) }
}

inline fun ArrayNode.addAll(vararg values: Short) {
  values.forEach { add(it) }
}

inline fun ArrayNode.addAll(vararg values: Int) {
  values.forEach { add(it) }
}

inline fun ArrayNode.addAll(vararg values: Long) {
  values.forEach { add(it) }
}

inline fun ArrayNode.addAll(vararg values: UByte) {
  values.forEach { add(it.toInt()) }
}

inline fun ArrayNode.addAll(vararg values: UShort) {
  values.forEach { add(it.toInt()) }
}

inline fun ArrayNode.addAll(vararg values: UInt) {
  values.forEach { add(it.toLong()) }
}

inline fun ArrayNode.addAll(vararg values: ULong) {
  values.forEach { add(BigInteger(it.toString())) }
}

inline fun ArrayNode.addAll(vararg values: Float) {
  values.forEach { add(it) }
}

inline fun ArrayNode.addAll(vararg values: Double) {
  values.forEach { add(it) }
}

inline fun ArrayNode.addAll(vararg values: BigDecimal) {
  values.forEach { add(it) }
}

inline fun ArrayNode.addAll(vararg values: JsonNode) {
  values.forEach { add(it) }
}

inline fun ArrayNode.addAll(vararg values: Boolean) {
  values.forEach { add(it) }
}

inline fun ArrayNode.addAll(vararg values: String) {
  values.forEach { add(it) }
}

// endregion

// region Add Mixins

inline fun ArrayNode.add(value: Byte) {
  add(value.toInt())
}

inline fun ArrayNode.add(value: UByte) {
  add(value.toInt())
}

inline fun ArrayNode.add(value: UShort) {
  add(value.toInt())
}

inline fun ArrayNode.add(value: UInt) {
  add(value.toLong())
}

inline fun ArrayNode.add(value: ULong) {
  add(BigInteger(value.toString()))
}

inline fun ArrayNode.add(value: Any) {
  when (value) {
    is String     -> add(value)
    is Int        -> add(value)
    is Boolean    -> add(value)
    is Double     -> add(value)
    is Long       -> add(value)
    is JsonNode   -> add(value)
    is BigInteger -> add(value)
    is BigDecimal -> add(value)
    is Byte       -> add(value)
    is Short      -> add(value)
    is Float      -> add(value)
    is Unit       -> addNull()
    else          -> addPOJO(value)
  }
}

// endregion

// region Set Mixins

inline fun ArrayNode.set(index: Int, value: Byte) {
  set(index, value.toInt())
}

inline fun ArrayNode.set(index: Int, value: UByte) {
  set(index, value.toInt())
}

inline fun ArrayNode.set(index: Int, value: UShort) {
  set(index, value.toInt())
}

inline fun ArrayNode.set(index: Int, value: UInt) {
  set(index, value.toLong())
}

inline fun ArrayNode.set(index: Int, value: ULong) {
  set(index, BigInteger(value.toString()))
}

inline fun ArrayNode.set(index: Int, value: Any) {
  when (value) {
    is String     -> set(index, value)
    is Int        -> set(index, value)
    is Boolean    -> set(index, value)
    is Double     -> set(index, value)
    is Long       -> set(index, value)
    is JsonNode   -> set(index, value)
    is BigInteger -> set(index, value)
    is BigDecimal -> set(index, value)
    is Byte       -> set(index, value)
    is Short      -> set(index, value)
    is Float      -> set(index, value)
    is Unit       -> setNull(index)
    else          -> setPOJO(index, value)
  }
}

// endregion