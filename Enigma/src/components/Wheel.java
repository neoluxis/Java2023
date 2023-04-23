package components;

import java.util.ArrayList;
import java.util.Random;
import static toolchain.Maps.*;

public class Wheel {
	/***
	 * Variable init is a variable used to initiate the wheel, which means that the
	 * wheel should rotate for init times at the beginning.
	 */
	private int init;
	/***
	 * Variable cur is such a variable that it can mark the scale of this wheel, and
	 * it can record the times the wheel rotated.
	 */
	private int cur;
	/***
	 * The map of a wheel is to encrypt the characters.
	 */
	private char[][] map;
	
	/***
	 * The seed to generate map
	 */
	private int mapSeed;

	/***
	 * set the map according to a given seed
	 * 
	 * @param seed the seed to generate a random map for the wheel
	 */
	private void setMap(int seed) {
		this.mapSeed = seed;
		this.map = getWheelMap(seed);
	}

	/***
	 * If needed, the map of the wheel is accessible.
	 * 
	 * @return Return a clone of the map of this wheel.
	 */
	protected char[][] getMap() {
		return map.clone();
	}

	/***
	 * The cur should always be updated after a rotation.
	 */
	private void updateCur() {
		cur++;
		if (cur >= map[0].length) {
			cur = 0;
		}
	}

	/***
	 * Get cur to see how many times the wheel had rotated.
	 * 
	 * @return <code>this.cur</code>
	 */
	public int getCur() {
		return cur;
	}

	/***
	 * To generate a wheel with the seed. If only a seed is given, this method will
	 * call another method with another 0 added.
	 * 
	 * @param seed The seed to generate wheel.
	 */
	public Wheel(int seed) {
		this(seed, 0);
	}

	/***
	 * Generate a wheel.
	 * 
	 * @param seed The seed to generate wheel.
	 * @param init The beginning senario.
	 */
	public Wheel(int seed, int init) {
		this.init = init;
		cur = this.init;
		setMap(seed);
		rotate(init);
	}

	/**
	 * Rotate the wheel and update the cur once.
	 */
	public void rotate() {
		char t2 = map[1][0];
		for (int i = 0; i < map[1].length - 1; i++) {
			map[1][i] = map[1][i + 1];
		}
		map[1][map[1].length - 1] = t2;
		updateCur();
	}

	/***
	 * Rotate for several times.
	 * 
	 * @param times The wheel will rotate for <code>times<code> times
	 */
	private void rotate(int times) {
		for (int i = 0; i < times; i++) {
			rotate();
		}
	}
	
	public String getSeed() {
		String seed;
		seed = "M" + this.mapSeed + "I" + this.init;
		return seed;
	}

	@Override
	public String toString() {
		String ret = "Currently, the alphabets on this wheel is like this: \n";
		for (int i = 0; i < map[1].length - 1; i++) {
			ret += (map[0][i] + "->" + map[1][i] + ", ");
		}
		ret += map[0][map[1].length - 1] + "->" + map[1][map[1].length - 1];
		return ret;
	}

	@Deprecated
	class Map {
		/***
		 * Generate a map with a given seed
		 * 
		 * @param seed The seed used to create map.
		 * @return the generated map
		 */
		static char[][] genMap(int seed) {
			char[][] ret = {
					{ 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
							'z', 'x', 'c', 'v', 'b', 'n', 'm' },
					{ 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
							'z', 'x', 'c', 'v', 'b', 'n', 'm' }, };
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
	}
}
