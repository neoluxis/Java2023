package toolchain;

import java.util.ArrayList;
import java.util.Random;

public class Maps {

	public static char[][] getSwitcherMap(int index) {

		return SwitcherMap.maps[index];
	}

	public static char[][] getWheelMap(int seed) {

		return WheelMap.genMap(seed);
	}

	abstract class SwitcherMap {

		/***
		 * QWERTY -> QWERTY
		 */
		private static char[][] map0 = {
				{ 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z',
						'x', 'c', 'v', 'b', 'n', 'm' },
				{ 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z',
						'x', 'c', 'v', 'b', 'n', 'm' }, };

		/***
		 * QWERTY -> COLMAK
		 */
		private static char[][] map1 = {
				{ 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z',
						'x', 'c', 'v', 'b', 'n', 'm' },
				{ 'q', 'w', 'f', 'p', 'g', 'j', 'l', 'u', 'y', 'a', 'r', 's', 't', 'd', 'h', 'n', 'e', 'i', 'o', 'z',
						'x', 'c', 'v', 'b', 'k', 'm', } };

		/***
		 * unusable currently
		 */
		private static char[][] map2 = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g',
				'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' }, {} };

		/***
		 * unusable currently
		 */
		private static char[][] map3 = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g',
				'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' }, {} };

		/***
		 * built-in maps, including 4 maps.
		 */
		public static char[][][] maps = { map0, map1, map2, map3 };

	}

	class WheelMap {
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
