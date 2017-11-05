import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report - LET
 *
 */
public class Target {
	
	private String name;
	private int clockFrequency_MHz;
	private int cores;
	private String osType;
	private String type;
	private List<Core> coresList = new ArrayList<>();

	public Target() {
		
	}

	public Target(String name, int clockFrequency_MHz, int cores, String osType, String type) {
		this();
		this.name = name;
		this.clockFrequency_MHz = clockFrequency_MHz;
		this.cores = cores;
		this.osType = osType;
		this.type = type;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClockFrequency_MHz() {
		return clockFrequency_MHz;
	}

	public void setClockFrequency_MHz(int clockFrequency_MHz) {
		this.clockFrequency_MHz = clockFrequency_MHz;
	}

	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Core> getCoresList() {
		return coresList;
	}

	public void setCoresList(List<Core> coresList) {
		this.coresList = coresList;
	}
	
	public void addCore(Core core) {
		coresList.add(core);
	}
	
	
	//------------------------------------------- Override Functions -------------------------------------------

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
	    if (other == this) {
	    	return true;
	    }
	    if (!(other instanceof Target)) {
	    	return false;
	    }
	    Target otherTarget = (Target) other;
	    return this.name.equals(otherTarget.getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("clockFrequency_MHz=").append("\"").append(this.clockFrequency_MHz).append("\"").append(", ");
		sb.append("cores=").append("\"").append(this.cores).append("\"").append(", ");
		sb.append("osType=").append("\"").append(this.osType).append("\"").append(", ");
		sb.append("type=").append("\"").append(this.type).append("\"").append(", ");
		sb.append("coresList:").append(this.coresList.size());
		sb.append("]");
		return sb.toString();
	}
}
