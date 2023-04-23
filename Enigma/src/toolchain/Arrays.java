package toolchain;
/***
 * 
 * @author Neolux Lee
 * @author neolux.lee@gmail.com
 *
 */
public class Arrays {
	/***
	 * 
	 * @param c
	 * @param cs
	 * @return The index of c in cs[]. 
	 */
	public static int getIndexOfChar(char c, char[] cs) {
		if (c >= 'a' && c <= 'z') {
			for (int i = 0; i < cs.length; i++) {
				if (c == cs[i]) {
					return i;
				}
			}
		} else if (c >= 'A' && c <= 'Z') {
			c += ('a' - 'A');
			return getIndexOfChar(c, cs);
		}
		return -1;
	}
}
