package report_parsing.application;
/**
 * For TGEN Report - Application
 *
 */
public class Access implements Comparable<Access>{
	
	private String name;
	private String accessType;
	private int multiplicity;
	private String protection;
	
	public Access() {
		
	}

	public Access(String name, String accessType, int multiplicity, String protection) {
		this();
		this.name = name;
		this.accessType = accessType;
		this.multiplicity = multiplicity;
		this.protection = protection;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public int getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(int multiplicity) {
		this.multiplicity = multiplicity;
	}

	public String getProtection() {
		return protection;
	}

	public void setProtection(String protection) {
		this.protection = protection;
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
	    if (!(other instanceof Access)) {
	    	return false;
	    }
	    Access otherAccess = (Access) other;
	    return this.name.equals(otherAccess.getName());
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(Access other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("accessType=").append("\"").append(this.accessType).append("\"").append(", ");
		sb.append("multiplicity=").append("\"").append(this.multiplicity).append("\"").append(", ");
		sb.append("protection=").append("\"").append(this.protection).append("\"");
		sb.append("]");
		return sb.toString();
	}

}
