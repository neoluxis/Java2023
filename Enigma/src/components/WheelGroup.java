package components;

import java.util.ArrayList;
import java.util.Random;

import static toolchain.Arrays.*;

public class WheelGroup {
	/***
	 * Many wheels can form a wheel group. ArrayList wheels stores several wheels.
	 */
	private ArrayList<Wheel> wheels;
	/***
	 * The size of the wheel group. i.e. the number of wheels.
	 */
	private int size;
	/***
	 * After the encryption of the wheels in the group, the character should go back
	 * and have another time of encryption. The retMap is the map for the character
	 * when it goes from the last wheel to that wheel.
	 */
	private char[][] retMap;

	/***
	 * The seed to generate the return map
	 */
	private int retSeed;

	/***
	 * Given no parameter, generate a default wheel group with 3 wheels, with seed 0
	 * and init 0.
	 */
	public WheelGroup() {
		this(3);
	}

	/***
	 * Given an array of seeds
	 * 
	 * @param seeds Seeds list.
	 */
	public WheelGroup(int[] seeds) {
		this(seeds.length, seeds);
	}

	/***
	 * Given seeds list and inits list
	 * 
	 * @param seeds Seeds list
	 * @param inits Inits list
	 */
	public WheelGroup(int[] seeds, int[] inits) {
		this((seeds.length < inits.length ? seeds.length : inits.length), seeds, inits);
	}

	public WheelGroup(ArrayList<Integer> seeds, ArrayList<Integer> inits) {
		this((seeds.size() < inits.size() ? seeds.size() : inits.size()), seeds, inits);
	}

	public WheelGroup(ArrayList<Integer> seeds, ArrayList<Integer> inits, int ret) {
		this((seeds.size() < inits.size() ? seeds.size() : inits.size()), seeds, inits, ret);
	}

	/***
	 * Generate a group with <i>num</i> wheels
	 * 
	 * @param num
	 */
	public WheelGroup(int num) {
		setSize(num);
		for (int i = 0; i < num; i++) {
			addWheel(0, 0);
		}
		this.retMap = genRet(49);
	}

	/***
	 * Given num and seeds listm but only the first num seeds are active
	 * 
	 * @param num   How many wheels
	 * @param seeds seeds list
	 */
	public WheelGroup(int num, int[] seeds) {
		setSize(num);
		for (int i = 0; i < num; i++) {
			addWheel(seeds[i], 0);
		}
		this.retMap = genRet(50);
	}

	/***
	 * Given seeds list and inits list but only the first num are active.
	 * 
	 * @param num   How many wheels
	 * @param seeds Seeds list
	 * @param inits Inits list
	 */
	public WheelGroup(int num, int[] seeds, int[] inits) {
		this.size = num;
		for (int i = 0; i < num; i++) {
			addWheel(seeds[i], inits[i]);
		}
		this.retMap = genRet(50);
	}

	public WheelGroup(int num, ArrayList<Integer> seeds, ArrayList<Integer> inits) {
		this.size = num;
		for (int i = 0; i < num; i++) {
			addWheel(seeds.get(i), inits.get(i));
		}
		this.retMap = genRet(50);
	}

	public WheelGroup(int num, ArrayList<Integer> seeds, ArrayList<Integer> inits, int ret) {
		this.size = num;
		for (int i = 0; i < num; i++) {
			addWheel(seeds.get(i), inits.get(i));
		}
		this.retMap = genRet(ret);
	}

	/***
	 * Add a new wheel to the group
	 * 
	 * @param seed The seed for the new wheel
	 * @param init The init for the new wheel
	 */
	private void addWheel(int seed, int init) {
		if (wheels == null) {
			wheels = new ArrayList<Wheel>();
		}
		wheels.add(new Wheel(seed, init));
	}

	/***
	 * Set the size of the wheel group
	 * 
	 * @param num
	 */
	private void setSize(int num) {
		this.size = num;
	}

	/***
	 * Generate a random retMap with a given seed
	 * 
	 * @param seed The seed to generate the retMap
	 * @return return the retMap
	 */
	private char[][] genRet(int seed) {
		this.retSeed = seed;
		char[][] ret = { wheels.get(wheels.size() - 1).getMap()[0].clone(),
				wheels.get(wheels.size() - 1).getMap()[1].clone() };
		ret[0] = ret[1].clone();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random rand = new Random();
		int count = 0;
		rand.setSeed(seed);
		while (true) {
			int temp = rand.nextInt(26);
			if (arr.indexOf(temp) == -1) {
				arr.add(temp);
				count++;
				if (count == 26) {
					break;
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			ret[1][i] = ret[0][arr.get(i)];
		}
		return ret;
	}

	/***
	 * Rotate the group. When executing this method, only the first wheel will
	 * rotate. Then check whether the other wheels should turn.
	 */
	public void rotate() {
		wheels.get(0).rotate();
		checkDigit();
	}

	/***
	 * Check whether the next wheel and other wheels should rotate. If the first
	 * wheel turned one cycle, the next wheel should rotate once. And so on
	 */
	private void checkDigit() {
		int oo = 0;
		while (oo < size - 1) {
			if (wheels.get(oo).getCur() == 0) {
				wheels.get(oo + 1).rotate();
			} else
				;
			oo++;
		}
		if (wheels.get(oo).getCur() == 0)
			;
	}

	@Override
	public String toString() {
		String str = null;
		for (int i = 0; i < this.wheels.size(); i++) {
			str += this.wheels.get(i).toString() + "\n";
		}
		str += "The return map is like this: \n";
		for (int i = 0; i < retMap[1].length; i++) {
			str += retMap[0][i] + "->" + retMap[1][i] + ", ";
		}
		str += "\n";
		return str;
	}

	/***
	 * To encrypt a character
	 * 
	 * @param in Character before encryption
	 * @return After encryption
	 */
	public char switchChar(char in) {
		char out = in;
		// 1 to last
		for (int i = 0; i < wheels.size(); i++) {
			out = transform(out, wheels.get(i).getMap(), 0);
		}
		// last wheel, self transform
		out = transform(out, retMap, 0);
		// last to 1
		for (int i = wheels.size() - 1; i >= 0; i--) {
			out = transform(out, wheels.get(i).getMap(), 1);
		}
		rotate();
		return out;

	}

	/***
	 * Encryption once
	 * 
	 * @param c    Before encryption
	 * @param cs   Map
	 * @param mode The direction of encryption
	 * @return After once encryption
	 */
	private char transform(char c, char[][] cs, int mode) {
		char ret = c;
		int index;
		boolean flag = false;
		if (c >= 'A' && c <= 'Z') {
			ret += 32;
			flag = true;
		}
		switch (mode) {
		// 1 to 2
		case 0:
			index = getIndexOfChar(ret, cs[0]);
			if (index == -1) {
				return ret;
			}
			ret = cs[1][index];
			break;
		// 2 to 1
		case 1:
			index = getIndexOfChar(ret, cs[1]);
			if (index == -1) {
				return ret;
			}
			ret = cs[0][index];
			break;
		}
		if (flag) {
			ret -= 32;
		}
		return ret;
	}

	public String getSeed() {
		String seed = "";
		for (int index = 0; index < wheels.size(); index++) {
			seed += wheels.get(index).getSeed();
			seed += ",";
		}
		seed += "R" + retSeed;
		return seed;
	}

}
