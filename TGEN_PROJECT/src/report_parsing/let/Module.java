package report_parsing.let;
import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report - LET
 *
 */
public class Module implements Comparable<Module>{
	
	private String name;
	private List<Mode> modes = new ArrayList<>();
	
	public Module() {
		
	}
	
	public Module(String name) {
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

	public List<Mode> getModes() {
		return modes;
	}

	public void setModes(List<Mode> modes) {
		this.modes = modes;
	}
	
	public void addModes(Mode mode) {
		modes.add(mode);
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
	    if (!(other instanceof Module)) {
	    	return false;
	    }
	    Module otherModule = (Module) other;
	    return this.name.equals(otherModule.getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(Module other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("modes:").append(this.modes.size());
		sb.append("]");
		return sb.toString();
	}
	

}
