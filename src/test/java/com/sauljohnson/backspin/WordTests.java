package com.sauljohnson.backspin;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link Word} class.
 *
 * @version 1.0 17 May 2016
 * @author  Saul Johnson
 */
public class WordTests extends TestCase {

    public void testSetBit() {
        // Starting binary of 00000001.
        byte value = 1;
        Word subject = new Word(value);

        // Flip bit at index 6 to make 00000011.
        subject.setBit(6, true);

        // Decimal value should be 3
        assertEquals(3, subject.getValue());
    }

    public void testGetBit() {
        // Starting binary of 00000001.
        byte value = 1;
        Word subject = new Word(value);

        // Bit at index 7 should be on.
        assertTrue(subject.getBit(7));
    }

    public void testAnd() {
        // Starting binary of 00000011.
        byte value = 3;
        Word subject = new Word(value);

        // Apply 00000010 with bitwise AND.
        subject.and((byte) 2);
        assertEquals(2, subject.getValue());

        // Apply 00000001 with bitwise AND.
        subject.and(new Word(1));
        assertEquals(0, subject.getValue());
    }

    public void testOr() {
        // Starting binary of 00000000.
        byte value = 0;
        Word subject = new Word(value);

        // Apply 00000001 with bitwise OR.
        subject.or((byte) 1);
        assertEquals(1, subject.getValue());

        // Apply 00000010 with bitwise OR.
        subject.or(new Word(2));
        assertEquals(3, subject.getValue());
    }

    public void testXor() {
        // Starting binary of 00000111.
        byte value = 7;
        Word subject = new Word(value);

        // Apply 00001111 with bitwise XOR.
        subject.xor((byte) 15);
        assertEquals(8, subject.getValue());

        // Apply 00001111 with bitwise XOR.
        subject.xor(new Word(15));
        assertEquals(7, subject.getValue());
    }

    public void testToBitString() {
        // Starting binary of 01111111.
        byte value = 127;
        Word subject = new Word(value);

        // Check bit string generation.
        assertEquals("01111111", subject.toBitString());
    }

    public void testEquals() {
        // Compare words with identical values.
        Word x = new Word(-128);
        Word y = new Word(-128);
        assertTrue(x.equals(y));
    }
}
