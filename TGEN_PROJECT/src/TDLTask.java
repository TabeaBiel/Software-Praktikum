import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report - LET
 *
 */
public class TDLTask implements Comparable<TDLTask>{
	
	private String name;
	private List<LET_Function> functions = new ArrayList<>();
	
	public TDLTask() {
		
	}
	
	public TDLTask(String name) {
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

	public List<LET_Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<LET_Function> functions) {
		this.functions = functions;
	}

	public void addFunction(LET_Function function) {
		functions.add(function);
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
	    if (!(other instanceof TDLTask)) {
	    	return false;
	    }
	    TDLTask otherTDLTask = (TDLTask) other;
	    return this.name.equals(otherTDLTask.getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(TDLTask other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("functions:").append(this.functions.size());
		sb.append("]");
		return sb.toString();
	}
	
}
