package components;

import static toolchain.Arrays.*;
import static toolchain.Maps.*;

/***
 * 
 * @author Neolux Lee
 * @author neolux.lee@gmail.com
 * 
 */
public class Switcher {
	/***
	 * whether use map or not.
	 */
	private boolean useMap;
	/***
	 * If use no map, mode will be the modification of the Caeser cipher. If use a
	 * map, mode will have no use.
	 */
	private int mode;
	/***
	 * If use no map, map[][] will have no use. If use a map, map[][] is the map.
	 */
	private char[][] map;
	/***
	 * The seed to generate the Switcher, or the map
	 */
	private int seed;

	/***
	 * Usually, you shouldn't change the <code>mode</code> value.
	 * 
	 * @param mode
	 */
	protected void setMode(int mode) {
		this.mode = mode;
	}

	/***
	 * 
	 * @param useMap A boolean value to make this Switcher whether a Caeser cipher
	 *               or Mapping cipher.
	 */
	protected void setMap(boolean useMap) {
		this.useMap = useMap;
	}

	/***
	 * From array of maps, set the map of this Switcher.
	 * 
	 * @param index An index to set map from the array
	 *              <code>Switcher.Map.maps</code>. If the <code>useMap</code> is
	 *              false, this method won't make any difference.
	 */
	protected void setMap(int index) {
		this.seed = index;
		this.map = getSwitcherMap(index);
	}

	/***
	 * To manually set the map of this Switcher.
	 * 
	 * @param map
	 */

	private void setMap(char[][] map) {
		this.map = map;
	}

	/***
	 * Given no parameter, the Switcher won't change the input character.
	 */
	public Switcher() {
		setMap(false);
		setMode(0);
	}

	/***
	 * Given an integer parameter, the <code>mode</code> will be viewed as the
	 * modification in the Caeser cipher.
	 * 
	 * @param mode
	 */
	public Switcher(int mode) {
		setMap(false);
		setMode(mode);
	}

	/***
	 * Given a boolean parameter, the boolean value will be viewed as
	 * <code>useMap</code>. And the <code>map</code> will be set to Map.maps[0].
	 * 
	 * @param useMap Whether to use a map or not.
	 */
	public Switcher(boolean useMap) {
		setMap(useMap);
		setMap(0);
	}

	/***
	 * Given a boolean and an integer, We will set useMap with the boolean and set
	 * the map with integer.
	 * 
	 * @param useMap Whether to use a map or not.
	 * @param index  To set the map to the index-th map in Map.maps
	 */
	public Switcher(boolean useMap, int index) {
		setMap(useMap);
		if (useMap) {
			setMap(index);
		}else {
			setMode(index);
		}
	}

	/***
	 * Given a boolean and a 2D char array, we'll set the useMap and the map.
	 * 
	 * @param useMap Whether to use a map or not.
	 * @param map    To set the map to map
	 */
	public Switcher(boolean useMap, char[][] map) {
		setMap(useMap);
		setMap(map);
	}

	/***
	 * Encrypt a character('a'-'z', 'A'-'Z') If the character is a special symbol,
	 * it won't be encrypted. Instead, this method will return the character itself.
	 * 
	 * @param c The character before encryption.
	 * @return Return the character after once encryption (Caeser or Mapping).
	 */
	public char encrypt(char c) {
		char ret;
		boolean flag = false;
		if (c >= 'A' && c <= 'Z') {
			c += 32;
			flag = true;
		}
		if (!useMap) {
			if (c <= 'z' - mode && c >= 'a') {
				ret = (char) (c + mode);
			} else if (c > 'z' - mode && c <= 'z') {
				ret = (char) (c + mode - 'z' + 'a');
			} else {
				ret = c;
			}
		} else {
			int ind = getIndexOfChar(c, map[0]);
			if (ind == -1)
				return c;
			ret = map[1][ind];
		}
		if (flag) {
			ret -= 32;
		}
		return ret;
	}

	/***
	 * Encrypt a string. All alphabets in the string will be encrypted but all
	 * symbols and numbers won't be encrypted.
	 * 
	 * @param str The string before the encryption.
	 * @return the char array of the once encrypted string
	 */
	public char[] encode(String str) {
		char[] ret = str.toCharArray();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = encrypt(ret[i]);
		}
		return ret;
	}

	/***
	 * Generate the seed to generate a Switcher.
	 * 
	 * @return a String containing all info to generate a Switcher.
	 */
	public String getSeed() {
		String ret = "";
		if (useMap) {
			ret += "T-";
		} else {
			ret += "F-";
		}
		ret += "D" + this.seed;
		return ret;
	}

	@Deprecated
	abstract class Map {

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

}
