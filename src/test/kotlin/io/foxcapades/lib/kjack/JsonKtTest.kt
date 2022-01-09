package io.foxcapades.lib.kjack

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.math.BigInteger

internal class JsonKtTest {

  @Test
  fun requireArray() {
    val good = KJack.arrayNode {  }
    assertSame(good, good.requireArray())

    val bad = KJack.text("hello")
    assertThrows<IllegalStateException> { bad.requireArray() }
  }

  @Test
  fun testRequireArray() {
    val ar = KJack.arrayNode {  }
    assertSame(ar, ar.requireArray())

    val ex = Exception("foo")
    assertSame(ex, assertThrows<Exception> { KJack.text("hi").requireArray { ex } })
  }

  @Test
  fun requireBoolean() {
    val good = KJack.bool(true)
    assertTrue(good.requireBoolean())

    val bad = KJack.text("hello")
    assertThrows<IllegalStateException> { bad.requireBoolean() }
  }

  @Test
  fun testRequireBoolean() {
    val ar = KJack.bool(false)
    assertSame(ar.booleanValue(), ar.requireBoolean())

    val ex = Exception("foo")
    assertSame(ex, assertThrows<Exception> { KJack.text("hi").requireBoolean { ex } })
  }

  @Test
  fun requireByte() {
    val good = arrayOf(
      KJack.byte(2),
      KJack.short(2),
      KJack.int(2),
      KJack.long(2),
    )

    for (t in good)
      assertEquals(2, t.requireByte())

    val bad1 = KJack.int(-129)
    assertThrows<IllegalStateException> { bad1.requireByte() }

    val bad2 = KJack.int(128)
    assertThrows<IllegalStateException> { bad2.requireByte() }

    val bad3 = KJack.float(3f)
    assertThrows<IllegalStateException> { bad3.requireByte() }
  }

  @Test
  fun testRequireByte() {
    val ar = KJack.byte(5)
    assertEquals(5, ar.requireByte())

    val ex = Exception("foo")
    assertSame(ex, assertThrows<Exception> { KJack.text("hi").requireByte { ex } })
  }

  @Nested
  @DisplayName("require double with standard error")
  inner class RequireDouble {

    @Test
    @DisplayName("throws an IllegalStateException when the receiver node is not numeric")
    fun test1() {
      assertThrows<IllegalStateException> { KJack.text("hi").requireDouble() }
    }

    @Test
    @DisplayName("throws an IllegalStateException when the json value is too precise to be a double")
    fun test2() {
      assertThrows<IllegalStateException> {
        KJack.bigDecimal(BigDecimal("1.123456789123456789123456789123456789")).requireDouble()
      }
    }

    @Test
    @DisplayName("returns the double value for a valid double node")
    fun test3() {
      assertEquals(6.66, KJack.double(6.66).requireDouble())
    }
  }


  @Nested
  @DisplayName("require float with standard error")
  inner class RequireFloat {

    @Test
    @DisplayName("throws an IllegalStateException when the receiver node is not numeric")
    fun test1() {
      assertThrows<IllegalStateException> { KJack.text("hi").requireFloat() }
    }

    @Test
    @DisplayName("throws an IllegalStateException when the json value is too precise to be a float")
    fun test2() {
      assertThrows<IllegalStateException> {
        KJack.bigDecimal(BigDecimal("1.123456789123456789123456789123456789")).requireFloat()
      }
    }

    @Test
    @DisplayName("returns the float value for a valid float node")
    fun test3() {
      assertEquals(6.66f, KJack.float(6.66f).requireFloat())
    }
  }


  @Test
  fun requireInt() {
    val good = arrayOf(
      KJack.byte(2),
      KJack.short(2),
      KJack.int(2),
      KJack.long(2),
    )

    for (t in good)
      assertEquals(2, t.requireInt())

    val bad1 = KJack.long(-2_147_483_649)
    assertThrows<IllegalStateException> { bad1.requireInt() }

    val bad2 = KJack.long(2_147_483_648)
    assertThrows<IllegalStateException> { bad2.requireInt() }

    val bad3 = KJack.float(3f)
    assertThrows<IllegalStateException> { bad3.requireInt() }
  }

  @Test
  fun testRequireInt() {
    val ar = KJack.byte(5)
    assertEquals(5, ar.requireInt())

    val ex = Exception("foo")
    assertSame(ex, assertThrows<Exception> { KJack.text("hi").requireInt { ex } })
  }

  @Test
  fun requireLong() {
    val good = arrayOf(
      KJack.byte(2),
      KJack.short(2),
      KJack.int(2),
      KJack.long(2),
    )

    for (t in good)
      assertEquals(2, t.requireLong())

    val bad1 = KJack.bigInteger(BigInteger("-9223372036854775809"))
    assertThrows<IllegalStateException> { bad1.requireLong() }

    val bad2 = KJack.bigInteger(BigInteger("9223372036854775808"))
    assertThrows<IllegalStateException> { bad2.requireLong() }

    val bad3 = KJack.float(3f)
    assertThrows<IllegalStateException> { bad3.requireLong() }
  }

  @Test
  fun testRequireLong() {
    val ar = KJack.byte(5)
    assertEquals(5, ar.requireLong())

    val ex = Exception("foo")
    assertSame(ex, assertThrows<Exception> { KJack.text("hi").requireLong { ex } })
  }

  @Test
  fun requireObject() {
    val good = KJack.objectNode {  }
    assertSame(good, good.requireObject())

    val bad = KJack.text("hello")
    assertThrows<IllegalStateException> { bad.requireObject() }
  }

  @Test
  fun testRequireObject() {
    val ar = KJack.objectNode {  }
    assertSame(ar, ar.requireObject())

    val ex = Exception("foo")
    assertSame(ex, assertThrows<Exception> { KJack.text("hi").requireObject { ex } })
  }

  @Test
  fun requireShort() {
    val good = arrayOf(
      KJack.byte(2),
      KJack.short(2),
      KJack.int(2),
      KJack.long(2),
    )

    for (t in good)
      assertEquals(2, t.requireShort())

    val bad1 = KJack.int(-32_769)
    assertThrows<IllegalStateException> { bad1.requireShort() }

    val bad2 = KJack.int(32_768)
    assertThrows<IllegalStateException> { bad2.requireShort() }

    val bad3 = KJack.float(3f)
    assertThrows<IllegalStateException> { bad3.requireShort() }
  }

  @Test
  fun testRequireShort() {
    val ar = KJack.byte(5)
    assertEquals(5, ar.requireShort())

    val ex = Exception("foo")
    assertSame(ex, assertThrows<Exception> { KJack.text("hi").requireShort { ex } })
  }

  @Test
  fun requireString() {
    val good = KJack.text("nope")
    assertSame("nope", good.requireString())

    val bad = KJack.int(56)
    assertThrows<IllegalStateException> { bad.requireString() }
  }

  @Test
  fun testRequireString() {
    val ex = Exception("foo")
    assertSame(ex, assertThrows { KJack.int(42).requireString { ex } })
  }

  @Test
  fun requireUByte() {
    val good = arrayOf(
      KJack.byte(2),
      KJack.short(2),
      KJack.int(2),
      KJack.int(255),
      KJack.long(2),
    )

    for (t in good)
      assertEquals(t.intValue().toUByte(), t.requireUByte())

    val bad = arrayOf(
      KJack.int(-1),
      KJack.int(256),
      KJack.float(3f),
    )

    for (t in bad)
      assertThrows<IllegalStateException> { t.requireUByte() }
  }

  @Test
  fun testRequireUByte() {
    val ex = Exception("foo")
    assertSame(ex, assertThrows { KJack.text("hi").requireUByte { ex } })
  }

  @Test
  fun requireUInt() {
    val good = arrayOf(
      KJack.byte(2),
      KJack.short(2),
      KJack.int(2),
      KJack.long(4_294_967_295),
      KJack.long(2),
    )

    for (t in good)
      assertEquals(t.intValue().toUInt(), t.requireUInt())

    val bad = arrayOf(
      KJack.int(-1),
      KJack.long(4_294_967_296),
      KJack.float(3f),
    )

    for (t in bad)
      assertThrows<IllegalStateException> { t.requireUInt() }
  }

  @Test
  fun testRequireUInt() {
    val ex = Exception("foo")
    assertSame(ex, assertThrows { KJack.text("hi").requireUInt { ex } })
  }

  @Test
  fun requireULong() {
    val good = arrayOf(
      KJack.byte(2),
      KJack.short(2),
      KJack.int(2),
      KJack.ulong(18_446_744_073_709_551_615u),
      KJack.long(2),
    )

    for (t in good)
      assertEquals(t.bigIntegerValue().toString(10).toULong(), t.requireULong())

    val bad = arrayOf(
      KJack.int(-1),
      KJack.bigInteger(BigInteger("18446744073709551616")),
      KJack.float(3f),
    )

    for (t in bad)
      assertThrows<IllegalStateException> { t.requireULong() }
  }

  @Test
  fun testRequireULong() {
    val ex = Exception("foo")
    assertSame(ex, assertThrows { KJack.text("hi").requireULong { ex } })
  }

  @Test
  fun requireUShort() {
    val good = arrayOf(
      KJack.byte(2),
      KJack.short(2),
      KJack.int(2),
      KJack.int(65535),
      KJack.long(2),
    )

    for (t in good)
      assertEquals(t.intValue().toUShort(), t.requireUShort())

    val bad = arrayOf(
      KJack.int(-1),
      KJack.int(65536),
      KJack.float(3f),
    )

    for (t in bad)
      assertThrows<IllegalStateException> { t.requireUShort() }
  }

  @Test
  fun testRequireUShort() {
    val ex = Exception("foo")
    assertSame(ex, assertThrows { KJack.text("hi").requireUShort { ex } })
  }
}