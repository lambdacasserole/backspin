# Backspin
Bit flipping/manipulation Maven package for Java.

When it comes to getting down and dirty with ones and zeroes, it's easy to get lost in a sea of bitwise operators. Backspin is a minimal bit manipulation library that allows you to deal in raw binary digits without ever typing '&' or '|' (unless you want to, of course).

Using this library, you can literally write booleans to a stream to output data bit-by-bit:

```
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
```

Perhaps you're writing your own Huffman compression stuff and you need to deal with bit sequences, perhaps you're dealing with an obscure [P4 type portable bitmap file](https://en.wikipedia.org/wiki/Netpbm_format) or maybe you just want to get your binary arithmetic on. Changes are, backspin has what you need.

## Contributing
For most intents and purposes, Backspin is considered to fulfil its original use case. Bug fixes and suggestions are welcome, however, from any member of the community.

## Acknowlegements
This suite of classes was isolated from the [the Denobo codebase](https://github.com/lambdacasserole/denobo) because [James Healey](https://github.com/JamesHealey94) used it like a badass to squeeze simple images into under 1KB when he put together [his app Wisecrack](http://jameshealey.me/). Cheers boi.
