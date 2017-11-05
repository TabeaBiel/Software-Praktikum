
/**
 * For TGEN Report - LET
 *
 */
public class Core implements Comparable<Core>{
	
	private String name;
	private String unit;
	
	public Core() {
		
	}
	
	public Core(String name, String unit) {
		this();
		this.name = name;
		this.unit = unit;
	}


	//------------------------------------------- Getters and Setters -------------------------------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
	    if (!(other instanceof Core)) {
	    	return false;
	    }
	    Core otherCore = (Core) other;
	    return this.name.equals(otherCore.getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(Core other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("unit=").append("\"").append(this.unit).append("\"");
		sb.append("]");
		return sb.toString();
	}

}
