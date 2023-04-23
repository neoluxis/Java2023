import java.util.Scanner;

import encode.Encoder;

public class Main {

	public static void main(String[] args) {
		try {
		Object en = new Object();
		if (args.length != 0) {
			switch (args[0]) {
			case "e":
			case "encode":
				en = new Encoder();
				((Encoder) en).run();
				break;
			case "d":
			case "decode":
				break;
			}
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.print("Select mode: encode(e), decode(d): ");
			while (true) {
				String str = sc.next();
				if (str.toCharArray()[0] == 'e') {
					en = new Encoder();
					((Encoder) en).run();
					break;
				} else if (str.toCharArray()[0] == 'd') {
					break;
				} else {
					System.out.print("Please input 'e', or 'd'! \nTry again: ");
					continue;
				}
			}
			sc.close();
		}}catch (Exception e) {
			System.out.println("OOPS! An Error Occured! ");
		}
	}
}
