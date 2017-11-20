package report_parsing.application;

/**
 * For TGEN Report - Application
 *
 */
public class Part implements Comparable<Part>{
	
	private String name;
	private String status;
	private String symbol;
	
	
	public Part() {
		
	}
	
	public Part(String name, String status, String symbol) {
		this();
		this.name = name;
		this.status = status;
		this.symbol = symbol;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
	    if (!(other instanceof Part)) {
	    	return false;
	    }
	    Part otherPart = (Part) other;
	    return this.name.equals(otherPart.getName());
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(Part other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("status=").append("\"").append(this.status).append("\"").append(", ");
		sb.append("symbol=").append("\"").append(this.symbol).append("\"");
		sb.append("]");
		return sb.toString();
	}
	
}
