package report_parsing.application;
/**
 * For TGEN Report - Application
 *
 */
public class Call implements Comparable<Call>{
	
	private String name;
	
	public Call() {
		
	}
	
	public Call(String name) {
		this();
		this.name = name;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	    if (!(other instanceof Call)) {
	    	return false;
	    }
	    Call otherCall = (Call) other;
	    return this.name.equals(otherCall.getName());
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(Call other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"");
		sb.append("]");
		return sb.toString();
	}

}
