package components;

import java.util.Scanner;

public class Keyboard {

	/***
	 * Get user input
	 * @return the input string
	 */
	public String getInput() {
		String ret;
		Scanner scnr = new Scanner(System.in);
		ret = scnr.nextLine();
		scnr.close();
		return ret;
	}
	/***
	 * Give a prompt and get input
	 * @param str The prompt
	 * @return The input string
	 */
	public String getInput(String str) {
		String ret;
		System.out.print(str);
		Scanner scnr = new Scanner(System.in);
		ret = scnr.nextLine();
		scnr.close();
		return ret;
	}

}

