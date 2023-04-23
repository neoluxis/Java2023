package encode;

import java.util.Scanner;

import components.Keyboard;
import components.Switcher;
import components.WheelGroup;

public class Encoder {

	/***
	 * Keyboard
	 */
	Keyboard kbd;
	/***
	 * Switcher
	 */
	Switcher sw;
	/***
	 * Wheel Group
	 */
	WheelGroup wg;

	/***
	 * Initiate the keyboard, switcher, wheel group without any parameter.
	 */
	public Encoder() {
		kbd = new Keyboard();
		sw = new Switcher();
		wg = new WheelGroup();
	}

	/***
	 * Initiate wheel group with 3 parameters.
	 */
	public Encoder(int a, int b, int c) {
		kbd = new Keyboard();
		sw = new Switcher();
		int[] is = { a, b, c };
		wg = new WheelGroup(is);
	}

	/***
	 * Run the Enigma machine
	 */
	public void run() {
		System.out.print("Please select mode: 1. Continuous input(Coming soon...); 2. Single word/sentence input. ");
		Scanner sc = new Scanner(System.in);
		char option = sc.nextLine().toCharArray()[0];
		char[] res;
		switch (option) {
		case '1':
			// TODO: Continuous input
		case '2':
			res = encrypt();
			System.out.print("After encryption: ");
			System.out.println(res);
			System.out.println("Seed(Please save the seed well, or you'll possess no ability or chance to decode):");
			System.out.println("\t" + getSeed());
			System.out.println("-----------\nEnd. ");
			break;
		default:
			System.out.println("Unknown option! The program will end...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("OOPS! An error occurred!");
			}
			System.out.println("Quitting...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("OOPS! An error occurred!");
			}
		}
		sc.close();
	}

	/***
	 * Encrypt a string
	 * @return The char array of encrypted string
	 */
	private char[] encrypt() {
		String in = kbd.getInput("Input the text: ");
		char[] out;
		out = sw.encode(in);
		for (int i = 0; i < out.length; i++) {
			out[i] = wg.switchChar(out[i]);
		}
		return out;
	}
	
	/***
	 * Generate a seed to create an Enigma 
	 * @return a String containing all data to form an Enigma
	 */
	public String getSeed() {
		ParaphraseGen psw = new ParaphraseGen(this.sw, this.wg);
		String ret="";
		ret += psw.getPass();
		return ret;
	}
}
