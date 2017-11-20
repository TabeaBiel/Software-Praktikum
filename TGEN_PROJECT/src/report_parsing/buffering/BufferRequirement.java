package report_parsing.buffering;

import report_parsing.TGEN_Report;
import report_parsing.application.Data;
import report_parsing.let.TDLTask;

/**
 * For TGEN Report - Buffering
 *
 */
public class BufferRequirement implements Comparable<BufferRequirement> {
	
	public String mappedTo;
	public String task;
	public String type;
	public String var;
	
	public BufferRequirement() {
		
	}

	public BufferRequirement(String mappedTo, String task, String type, String var) {
		this();
		this.mappedTo = mappedTo;
		this.task = task;
		this.type = type;
		this.var = var;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------

	public String getMappedTo() {
		return mappedTo;
	}
	
	public BufferImplementation getMappedTo(TGEN_Report report) {
		return report.getBuffering().getBufferImplementations().stream().filter(e -> e.getName().equals(mappedTo)).findFirst().orElse(null);
	}

	public void setMappedTo(String mappedTo) {
		this.mappedTo = mappedTo;
	}

	public String getTask() {
		return task;
	}
	
	public TDLTask getTask(TGEN_Report report) {
		return report.getLet().getTdlProgram().getTdlTasks().stream().filter(e -> e.getName().equals(task)).findFirst().orElse(null);
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVar() {
		return var;
	}
	
	public Data getVar(TGEN_Report report) {
		return report.getApplication().getDatas().stream().filter(e -> e.getName().equals(var)).findFirst().orElse(null);
	}

	public void setVar(String var) {
		this.var = var;
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
	    if (!(other instanceof BufferRequirement)) {
	    	return false;
	    }
	    BufferRequirement otherBufferRequirement = (BufferRequirement) other;
	    if (!this.mappedTo.equals(otherBufferRequirement.getMappedTo())) {
	    	return false;
	    }
	    if (!this.task.equals(otherBufferRequirement.getTask())) {
	    	return false;
	    }
	    if (!this.type.equals(otherBufferRequirement.getType())) {
	    	return false;
	    }
	    return this.var.equals(otherBufferRequirement.getVar());
	}

	@Override
	public int hashCode() {
		return (mappedTo + task + type + var).hashCode();
	}

	@Override
	public int compareTo(BufferRequirement other) {
		return this.mappedTo.compareTo(other.getMappedTo());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("mappedTo=").append("\"").append(this.mappedTo).append("\"").append(", ");
		sb.append("task=").append("\"").append(this.task).append("\"").append(", ");
		sb.append("type=").append("\"").append(this.type).append("\"").append(", ");
		sb.append("var=").append("\"").append(this.var).append("\"");
		sb.append("]");
		return sb.toString();
	}

}
