package encode;

import components.Switcher;
import components.WheelGroup;

public class ParaphraseGen {

	Switcher swa;
	WheelGroup wg;
	Switcher swb;
	String paraphrase;

	public ParaphraseGen(Switcher swa, WheelGroup wg) {
		this.swa = swa;
		this.wg = wg;
		initPass();
	}

	public ParaphraseGen(Switcher swa, WheelGroup wg, Switcher swb) {
		this.swa = swa;
		this.wg = wg;
		this.swb = swb;
		initPass();
	}

	private void initPass() {
		String psw = "NL-S";
		psw += "?";
		psw += "SA=";
		psw += swa.getSeed();
		psw += "&";
		psw += "WG=";
		psw += wg.getSeed();
		if(swb != null) {
			psw += "&";
			psw += swb.getSeed();
		}
		this.paraphrase = psw;
	}

	public String getPass() {
		return paraphrase;
	}

}
