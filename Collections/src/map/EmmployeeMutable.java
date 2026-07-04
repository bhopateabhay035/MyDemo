package map;

import java.util.Map;

public class EmmployeeMutable {
	private  String name;
    private  int regNo;
    private  Map<String, String> metadata;
    
	public EmmployeeMutable(String name, int regNo, Map<String, String> metadata) {
		super();
		this.name = name;
		this.regNo = regNo;
		this.metadata = metadata;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public Map<String, String> getMetadata() {
		return metadata;
	}
	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}
	@Override
	public String toString() {
		return "EmmployeeMutable [name=" + name + ", regNo=" + regNo + ", metadata=" + metadata + "]";
	}

}
