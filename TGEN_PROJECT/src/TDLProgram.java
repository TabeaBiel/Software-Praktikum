import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report - LET
 *
 */
public class TDLProgram implements Comparable<TDLProgram>{
	
	private String name;
	private List<TDLTask> tdlTasks = new ArrayList<>();
	private List<Module> modules = new ArrayList<>();
	
	public TDLProgram() {
		
	}
	
	public TDLProgram(String name) {
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

	public List<TDLTask> getTdlTasks() {
		return tdlTasks;
	}

	public void setTDLTasks(List<TDLTask> tdlTasks) {
		this.tdlTasks = tdlTasks;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public void addTDLTask(TDLTask task) {
		tdlTasks.add(task);
	}
	
	public void addModule(Module module) {
		modules.add(module);
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
	    if (!(other instanceof TDLProgram)) {
	    	return false;
	    }
	    TDLProgram otherTDLTask = (TDLProgram) other;
	    return this.name.equals(otherTDLTask.getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(TDLProgram other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("tdlTasks:").append(this.tdlTasks.size()).append(", ");
		sb.append("modules:").append(this.modules.size());
		sb.append("]");
		return sb.toString();
	}
	
}
