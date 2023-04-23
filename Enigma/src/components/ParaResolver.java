package components;

import java.util.ArrayList;

public class ParaResolver {

	private String paraphrase;

	private Switcher swa;

	private Switcher swb;

	private WheelGroup wg;

	public ParaResolver() {
		this("NL-S?SA=F-D0&WG=M0I0,M0I0,M0I0,R49"); //default Paraphrase
	}

	public ParaResolver(String paraphrase) {
		this.paraphrase = new String(paraphrase);
		Resolve();
	}

	private void Resolve() {
		String[] generalData = {};
		if (paraphrase.startsWith("NL-S")) {
			generalData = paraphrase.split("\\?|\\&");
			/*
			 * generalData: Protocol: "NL-S", Switcher A: "SA=F-D0", WheelGroup:
			 * "WG=M0I0,M0I0,M0I0,R49", Switcher B*: "SB=T-D1",*
			 */
		} // TODO other protocol
		for (String singleData : generalData) {
			String[] sData = singleData.split("=");
			if(singleData.startsWith("SA=")) {
				String[] swData = sData[1].split("\\-D");
				boolean useMap = swData[0].equals("T");
				int num = Integer.parseInt(swData[1]);
				swa = new Switcher(useMap, num);
			}else if(singleData.startsWith("WG=")) {
				String[] wgData = sData[1].split(",");
				/*
				 * wgData: M0I0,M0I0,M0I0,R49
				 */
				String[] perData;
				ArrayList<Integer> seeds = new ArrayList<Integer>();
				ArrayList<Integer> inits = new ArrayList<Integer>();
				int ret = Integer.parseInt(wgData[wgData.length-1].split("R")[1]);
				for(int i=0; i<wgData.length-1;i++) {
					perData = wgData[i].split("M|I");
					seeds.add(Integer.parseInt(perData[1]));
					inits.add(Integer.parseInt(perData[2]));
				}
				wg = new WheelGroup(seeds, inits, ret);
			}else if(singleData.startsWith("SB=")) {
				String[] swData = sData[1].split("\\-D");
				boolean useMap = swData[0].equals("T");
				int num = Integer.parseInt(swData[1]);
				swb = new Switcher(useMap, num);
			}
		}
	}

	public Switcher getSwa() {
		return this.swa;
	}

	public Switcher getSwb() {
		return swb;
	}
	
	public Switcher getSwb(char m) {
		if(swb==null) {
			if(m=='t' || m == 'T') {
			System.out.println("You have only one switcher! ");
			}
		}
		return this.swb;
	}

	public WheelGroup getWg() {
		return this.wg;
	}

	public String getParaphrase() {
		return this.paraphrase;
	}
}
