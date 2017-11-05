import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report - LET
 *
 */
public class TDLMapping implements Comparable<TDLMapping>{
	
	private String program;
	private String target;
	private List<CoreMapping> coreMappings = new ArrayList<>();
	
	public TDLMapping() {
		
	}

	public TDLMapping(String program, String target) {
		this();
		this.program = program;
		this.target = target;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<CoreMapping> getCoreMappings() {
		return coreMappings;
	}

	public void setCoreMappings(List<CoreMapping> coreMappings) {
		this.coreMappings = coreMappings;
	}
	
	public void addCoreMapping(CoreMapping mapping) {
		coreMappings.add(mapping);
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
	    if (!(other instanceof TDLMapping)) {
	    	return false;
	    }
	    TDLMapping otherTDLMapping = (TDLMapping) other;
	    if (!this.program.equals(otherTDLMapping.getProgram())) {
	    	return false;
	    }
	    return this.target.equals(otherTDLMapping.getTarget());
	}

	@Override
	public int hashCode() {
		return (this.program + this.target).hashCode();
	}

	@Override
	public int compareTo(TDLMapping other) {
		return this.program.compareTo(other.getProgram());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("program=").append("\"").append(this.program).append("\"").append(", ");
		sb.append("target=").append("\"").append(this.target).append("\"").append(", ");
		sb.append("coreMappings:").append(this.coreMappings.size());
		sb.append("]");
		return sb.toString();
	}
	

}
