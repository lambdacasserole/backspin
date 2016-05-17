package com.sauljohnson.backspin;

import junit.framework.TestCase;

public class BitSequenceTests extends TestCase {

    public void testGetBit() {
        // Create a bit sequence with one '1' bit.
        BitSequence subject = new BitSequence();
        subject.append(true);

        // Check that the sequence starts with a '1' bit.
        assertTrue(subject.getBit(0));
    }

    public void testSetBit() {
        // Create a bit sequence '10'.
        BitSequence subject = new BitSequence();
        subject.append(true);
        subject.append(false);

        // Set bit at index 1 to '1'.
        subject.setBit(1, true);

        // Check bit at index 1 is '1'.
        assertTrue(subject.getBit(1));
    }

    public void testGetWord() {
        // Create a bit sequence '00001010'
        BitSequence subject = new BitSequence();
        subject.appendWord(new Word((byte) 10), 8);

        // Check word is still equal to 10.
        assertEquals(10, subject.getWord(0).getValue());
    }

    public void testAppendWord() {
        // Create a bit sequence '00010000'
        BitSequence subject = new BitSequence();
        subject.appendWord(new Word((byte) 16), 8);

        // Check word is still equal to 16.
        assertEquals(16, subject.getWord(0).getValue());
    }

    public void testAppend() {
        // Create a bit sequence with one '1' bit between two '0' bits.
        BitSequence x = new BitSequence();
        x.append(false);
        x.append(true);
        x.append(false);

        // Check that we can get the '1' bit at index 1.
        assertTrue(x.getBit(1));

        // Create bit sequence to append.
        BitSequence y = new BitSequence();
        y.append(false);
        y.append(false);
        y.append(false);

        // Append sequences
        x.append(y);

        // Check bit sequence appended correctly.
        assertEquals("010000", x.toBitString());
    }

    public void testToBitString() {
        // Create a bit sequence '00010000'
        BitSequence subject = new BitSequence();
        subject.appendWord(new Word((byte) 16), 8);

        // Check that bit sequence works out.
        assertEquals("00010000", subject.toBitString());
    }

    public void testGetLength() {
        // Create a bit sequence '10'.
        BitSequence subject = new BitSequence();
        subject.append(true);
        subject.append(false);

        // Check bit sequence is of length 2.
        assertEquals(2, subject.getLength());
    }

    public void testGetLengthInWords() {
        // Create 16-bit sequence of '1' bits.
        BitSequence subject = new BitSequence();
        for (int i = 0; i < 16; i++) {
            subject.append(true);
        }

        // Check that bit sequence is 2 words long.
        assertEquals(2, subject.getLengthInWords());
    }

    public void testToArray() {
        // Create 32-bit sequence of '1' bits.
        BitSequence subject = new BitSequence();
        for (int i = 0; i < 32; i++) {
            subject.append(true);
        }

        // 32-bits equate to 4 bytes.
        byte[] bytes = subject.toArray();
        assertEquals(4, bytes.length);

        // Check all bytes are -1.
        for (byte current : bytes) {
            assertEquals(-1, current);
        }
    }

    public void testGetWords() {
        // Create 32-bit sequence of '1' bits.
        BitSequence subject = new BitSequence();
        for (int i = 0; i < 32; i++) {
            subject.append(true);
        }

        // 32-bits equate to 4 words.
        Word[] words = subject.getWords();
        assertEquals(4, words.length);

        // Check all words are -1.
        for (Word current : words) {
            assertEquals(-1, current.getValue());
        }
    }

    public void testEquals() {
        // Create 32-bit sequence of '1' bits.
        BitSequence x = new BitSequence();
        for (int i = 0; i < 32; i++) {
            x.append(true);
        }

        // Create another 32-bit sequence of '1' bits.
        BitSequence y = new BitSequence();
        for (int i = 0; i < 32; i++) {
            y.append(true);
        }

        // These bit sequences are equal.
        assertTrue(x.equals(y));
    }

    public void testFromBitString() {
        // Create bit sequence and check first '1' bit.
        BitSequence subject = BitSequence.fromBitString("01001110010");
        assertTrue(subject.getBit(1));
    }

    public void testReverse() {
        // Create bit sequence and reverse it.
        BitSequence x = BitSequence.fromBitString("01001110010");
        BitSequence y = BitSequence.reverse(x);

        // Check reversed value.
        assertEquals("01001110010", y.toBitString());
    }
}
