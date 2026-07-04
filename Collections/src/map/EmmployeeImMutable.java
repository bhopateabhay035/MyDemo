package map;

import java.util.HashMap;
import java.util.Map;

public final class EmmployeeImMutable {

	private final String nname;
    private final int regNo;
    private final Map<String, String> metadata;
	
	public EmmployeeImMutable(String nname, int regNo, Map<String, String> metadata) {
		super();
		this.nname = nname;
		this.regNo = regNo;
		Map<String,String> temp = new HashMap<String, String>();
		for(Map.Entry<String,String> entry : metadata.entrySet()) {
			temp.put(entry.getKey(), entry.getValue());
		}
		this.metadata = temp;
	}
	
	public int getRegNo() {
		return regNo;
	}
	public Map<String, String> getMetadata() {
		return metadata;
	}
	public String getNname() {
		return nname;
	}

	@Override
	public String toString() {
		return "EmmployeeImMutable [nname=" + nname + ", regNo=" + regNo + ", metadata=" + metadata + "]";
	}
    
    
}
