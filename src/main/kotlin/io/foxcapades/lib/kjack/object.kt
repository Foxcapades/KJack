@file:Suppress("NOTHING_TO_INLINE")

package io.foxcapades.lib.kjack

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import java.math.BigDecimal
import java.math.BigInteger


/**
 * Adds an object to the receiver node, configured by the given action.
 *
 * @param key    Key that the new object will be set to.
 * @param action Action that configures the newly created [ObjectNode].
 */
inline fun ObjectNode.addObject(key: String, action: ObjectNode.() -> Unit) {
  set<ObjectNode>(key, KJack.objectNode(action))
}

/**
 * Adds an array to the receiver node, configured by the given action.
 *
 * @param key    Key that the new array will be set to.
 * @param size   Size to presize the newly created array to.
 * @param action Action that configures the newly created [ArrayNode].
 */
inline fun ObjectNode.addArray(
  key: String,
  size: Int = 1,
  action: ArrayNode.() -> Unit,
) {
  set<ArrayNode>(key, KJack.arrayNode(size, action))
}

/**
 * Appends the given [JsonNode] to this object.
 *
 * This method has a different name to avoid collision with the deprecated
 * `ObjectNode.put(String, JsonNode)` method.
 *
 * @param key  Key that the given node will be set to.
 * @param node Json node to append to the receiver object.
 */
inline fun ObjectNode.append(key: String, node: JsonNode) {
  set<ObjectNode>(key, node)
}

// region Put If

/**
 * Puts the given byte in the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Byte value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: Byte) {
  if (condition)
    put(key, value.toInt())
}

/**
 * Sets the given ubyte value on the receiver object only if [condition] is
 * `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: UByte) {
  if (condition)
    put(key, value.toInt())
}

/**
 * Sets the given short value on the receiver object only if [condition] is
 * `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: Short) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: UShort) {
  if (condition)
    put(key, value.toInt())
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: Int) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: UInt) {
  if (condition)
    put(key, value.toLong())
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: Long) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: ULong) {
  if (condition)
    put(key, BigInteger(value.toString()))
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(
  condition: Boolean,
  key: String,
  value: BigInteger,
) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: Float) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: Double) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(
  condition: Boolean,
  key: String,
  value: BigDecimal,
) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: Boolean) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: String) {
  if (condition)
    put(key, value)
}

/**
 * Sets the given value on the receiver object only if [condition] is `true`.
 *
 * @param condition Condition controlling whether the value will be set on the
 * receiver object.
 * @param key       Key that the given value will be set to.
 * @param value     Value to set.
 */
inline fun ObjectNode.putIf(condition: Boolean, key: String, value: JsonNode) {
  if (condition)
    set<ObjectNode>(key, value)
}

inline fun ObjectNode.putIf(
  condition: Boolean,
  key: String,
  provider: () -> Any,
) {
  if (condition)
    when (val v = provider()) {
      is String     -> put(key, v)
      is Int        -> put(key, v)
      is Boolean    -> put(key, v)
      is Double     -> put(key, v)
      is Long       -> put(key, v)
      is JsonNode   -> append(key, v)
      is Byte       -> put(key, v)
      is Float      -> put(key, v)
      is Short      -> put(key, v)
      is BigDecimal -> put(key, v)
      is BigInteger -> put(key, v)
      is UInt       -> put(key, v)
      is ULong      -> put(key, v)
      is UShort     -> put(key, v)
      is UByte      -> put(key, v)
      else          -> putPOJO(key, v)
    }
}

inline fun ObjectNode.putNullIf(condition: Boolean, key: String) {
  if (condition)
    putNull(key)
}

// endregion

inline fun ObjectNode.putStringIf(
  condition: Boolean,
  key: String,
  provider: () -> String
) {
  if (condition)
    put(key, provider())
}

// region Put If Not Null

inline fun ObjectNode.putIfNN(key: String, value: Byte?) {
  if (value != null)
    put(key, value.toInt())
}

inline fun ObjectNode.putIfNN(key: String, value: UByte?) {
  if (value != null)
    put(key, value.toInt())
}

inline fun ObjectNode.putIfNN(key: String, value: Short?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: UShort?) {
  if (value != null)
    put(key, value.toInt())
}

inline fun ObjectNode.putIfNN(key: String, value: Int?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: UInt?) {
  if (value != null)
    put(key, value.toLong())
}

inline fun ObjectNode.putIfNN(key: String, value: Long?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: ULong?) {
  if (value != null)
    put(key, BigInteger(value.toString()))
}

inline fun ObjectNode.putIfNN(key: String, value: BigInteger?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: Float?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: Double?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: BigDecimal?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: Boolean?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: String?) {
  if (value != null)
    put(key, value)
}

inline fun ObjectNode.putIfNN(key: String, value: JsonNode?) {
  if (value != null)
    set<ObjectNode>(key, value)
}

// endregion

inline fun ObjectNode.put(key: String, value: Byte) {
  put(key, value.toInt())
}

inline fun ObjectNode.put(key: String, value: UByte) {
  put(key, value.toInt())
}

inline fun ObjectNode.put(key: String, value: UShort) {
  put(key, value.toInt())
}

inline fun ObjectNode.put(key: String, value: UInt) {
  put(key, value.toLong())
}

inline fun ObjectNode.put(key: String, value: ULong) {
  put(key, BigInteger(value.toString()))
}