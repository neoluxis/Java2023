# Enigma Machine Simulation with Java

[简体中文](./CN.md)

## How does an Enigma work

The real Enigma in WW2 is made with a keyboard, a set of wheels, 
many plugs and another keyboard made with lights. 

When you press a key, the light will be lit up 
and you just need to write the lighting alphabet. 

Usually, the alphabet you press is different with the alphabet lighting up. 
Once you press the key, an electric circuit is built. 
The current will flow through the switcher made with many plugs -- 
the plugs connect different alphabets 
so that while the current goes through the plugs, 
the alphabet will change once. 
But this change is unchangeable. 
You can't change it unless you change the order of the plugs. 

Then the current will go to the wheels. 
Usually, there are three wheels. 
One alphabet will go from A to B and then, go from B to A. 
That means the alphabet changes seven times. 
For example A -> J -> I -> O -> Q -> B -> G. 
Moreover, every time you press the key, the wheel will rotate, 
which made the order every time not the same. 
This time, A was turned to G, 
but the next time A will be turned to U for example. 

Finally, the current goes to the light and powers the light. 
The light is in the same place as the alphabet, 
so you need to record the alphabet lighting up. 
The encoding is now finished. 

## Simulation in Java Code

### Encoding

Now we don't have a GUI or multithread, 
so we encode after the user input a full sentence. 
The symbol and space won't be encrypted. 

What are in the package `components` are the components 
that will be used in both encoding and decoding.
The class `Keyboard` is to get the user's input. 
The `Switcher` class is to simulate the switcher made with plugs. 
Those plugs are viewed as a `Map` saved in `toolchain/Maps`. 
Every map is made with 2 arrays saving 26 alphabets. 
The `Wheel` class is the wheel in the enigma machine, 
and the `WheelGroup` class is the wheelset in the enigma machine. 

What are in the package `encode` are the classes used in the encoding. 
The package `decode` is the same. 

In the package `encode`, there is a class `ParaphraseGen` 
to generate the paraphrase to be input into the decoder. 
It will give a paraphrase 
that the encoder uses to encrypt the words 
and the decoder uses it to decode the encrypted words. 

In the package `toolchain`, there are tools used in code. 
The code here is not specified to be used in Enigma. 
They can be used anywhere. 

### Paraphrase

The paraphrase should have parts as follows:

1. The protocol name;

2. The map of the switcher;

3. The initializing data for every wheel in the wheel set.
It should include the map of the wheels, the initializing data of the wheels, 
and the return map of the last wheel.

Here's a valid example of the paraphrase:
> `NL-S?SA=F-D0&WG=M0I0,M0I0,M0I0,R49`


### Decoding

You should give the paraphrase, or the default one will be used. 
If the paraphrase is wrong, the result can't be right. 

The code for decoding is in the package `decode`. 

There is a class `ParaResolver` to resolve the paraphrase given. 
If the paraphrase is invalid, the default one will be used. 
If the format is valid, a decoder will be created based on the paraphrase given. 

Have resolved the paraphrase and created the decoder, it's just another encoder. 

### Scalability of The Enigma Machine

- You can add more maps in `toolchain/Maps` so that you can encrypt your words in more other ways. 

- You can also add more wheels in the wheel set, in this case the words will be encrypted more times.

- After the wheel set, you can add another switcher.
