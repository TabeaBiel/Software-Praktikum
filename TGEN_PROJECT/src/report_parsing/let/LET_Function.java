package report_parsing.let;

import report_parsing.TGEN_Report;
import report_parsing.application.Application_Function;

/**
 * For TGEN Report - LET
 *
 */
public class LET_Function implements Comparable<LET_Function>{
	
	private String name;
	private int index;
	
	public LET_Function() {
		
	}
	
	public LET_Function(String name, int index) {
		this();
		this.name = name;
		this.index = index;
	}


	//------------------------------------------- Getters and Setters -------------------------------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public Application_Function getApplicationFunction(TGEN_Report report) {
		return report.getApplication().getApplicationFunctions().stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
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
	    if (!(other instanceof LET_Function)) {
	    	return false;
	    }
	    LET_Function otherFunction = (LET_Function) other;
	    return this.name.equals(otherFunction.getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(LET_Function other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("index=").append("\"").append(this.index).append("\"");
		sb.append("]");
		return sb.toString();
	}

}
