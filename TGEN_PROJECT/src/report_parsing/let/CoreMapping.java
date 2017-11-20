package report_parsing.let;

import report_parsing.TGEN_Report;

/**
 * For TGEN Report - LET
 *
 */
public class CoreMapping implements Comparable<CoreMapping>{
	
	private String core;
	private String modules;
	
	public CoreMapping() {
		
	}

	public CoreMapping(String core, String modules) {
		this();
		this.core = core;
		this.modules = modules;
	}
	

	//------------------------------------------- Getters and Setters -------------------------------------------

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public String getModules() {
		return modules;
	}

	public void setModules(String modules) {
		this.modules = modules;
	}
	
	public Module getModules(TGEN_Report report) {
		return report.getLet().getTdlProgram().getModules().stream().filter(e -> e.getName().equals(modules)).findFirst().orElse(null);
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
	    if (!(other instanceof CoreMapping)) {
	    	return false;
	    }
	    CoreMapping otherCoreMapping = (CoreMapping) other;
	    if (!this.core.equals(otherCoreMapping.getCore())) {
	    	return false;
	    }
	    return this.modules.equals(otherCoreMapping.getModules());
	}

	@Override
	public int hashCode() {
		return (this.core + this.modules).hashCode();
	}

	@Override
	public int compareTo(CoreMapping other) {
		return this.core.compareTo(other.getCore());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("core=").append("\"").append(this.core).append("\"").append(", ");
		sb.append("modules=").append("\"").append(this.modules).append("\"");
		sb.append("]");
		return sb.toString();
	}

}
