package com.sauljohnson.backspin;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link BitInputStream} class.
 *
 * @version 1.0 17 May 2016
 * @author  Saul Johnson
 */
public class BitInputStreamTests extends TestCase {

    public void testSkipBytes() {
        // Create input stream with bits '0000000011111111' and skip first byte.
        BitInputStream subject = new BitInputStream(new byte[] {0, -1});
        subject.skipBytes(1);

        // We should be at position 8.
        assertEquals(8, subject.getPosition());

        // The next bit should be '1'.
        assertEquals(true, subject.read());
    }

    public void testGetPosition() {
        // Create input stream with bits '00000011' and skip first bit.
        BitInputStream subject = new BitInputStream(new byte[] {3});
        subject.read();

        // We should be at position 1.
        assertEquals(1, subject.getPosition());
    }

    public void testRead() {
        // Create input stream with bits '11111111'.
        BitInputStream subject = new BitInputStream(new byte[] {-1});

        // All bits should be '1'.
        for (int i = 0; i < 8; i++) {
            assertTrue(subject.read());
        }
    }
}
