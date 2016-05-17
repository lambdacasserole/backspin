package com.sauljohnson.backspin;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link BitOutputStream} class.
 *
 * @version 1.0 17 May 2016
 * @author  Saul Johnson
 */
public class BitOutputStreamTests extends TestCase {

    public void testWrite() {
        // Create stream and call both overloads.
        BitOutputStream subject = new BitOutputStream();
        subject.write(true);
        subject.write(BitSequence.fromBitString("000000011111111"));

        // Array should be of length 2.
        byte[] bytes = subject.toArray();
        assertEquals(2, bytes.length);

        // First byte should be '10000000' or -128.
        assertEquals(-128, bytes[0]);

        // Second byte should be '11111111' or -1.
        assertEquals(-1, bytes[1]);
    }

    public void testGetLength() {
        // Create stream and write 3 bits '101'.
        BitOutputStream subject = new BitOutputStream();
        subject.write(true);
        subject.write(false);
        subject.write(true);

        // Check length is 3.
        assertEquals(3, subject.getLength());
    }

    public void testToArray() {
        // Create stream and write bit sequence containing bytes 0 and -1.
        BitOutputStream subject = new BitOutputStream();
        subject.write(BitSequence.fromBitString("0000000011111111"));

        // Array should be of length 2.
        byte[] bytes = subject.toArray();
        assertEquals(2, bytes.length);

        // First byte should be '00000000' or 0.
        assertEquals(0, bytes[0]);

        // Second byte should be '11111111' or -1.
        assertEquals(-1, bytes[1]);
    }
}
