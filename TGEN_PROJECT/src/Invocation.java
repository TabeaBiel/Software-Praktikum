/**
 * For TGEN Report - LET
 *
 */
public class Invocation implements Comparable<Invocation>{
	
	private int let;
	private int offset;
	private int period;
	private String task;
	
	public Invocation() {
		
	}
	
	public Invocation(int let, int offset, int period, String task) {
		this();
		this.let = let;
		this.offset = offset;
		this.period = period;
		this.task = task;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------

	public int getLet() {
		return let;
	}

	public void setLet(int let) {
		this.let = let;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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
	    if (!(other instanceof Invocation)) {
	    	return false;
	    }
	    Invocation otherInvocation = (Invocation) other;
	    if (this.getLet() != otherInvocation.getLet()) {
	    	return false;
	    }
	    if (this.getOffset() != otherInvocation.getOffset()) {
	    	return false;
	    }
	    if (this.getPeriod() != otherInvocation.getPeriod()) {
	    	return false;
	    }
	    return this.task.equals(otherInvocation.getTask());
	}

	@Override
	public int hashCode() {
		return (this.let + this.offset + this.period + this.task).hashCode();
	}

	@Override
	public int compareTo(Invocation other) {
		return Integer.compare(this.let, other.let);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("let=").append("\"").append(this.let).append("\"").append(", ");
		sb.append("offset=").append("\"").append(this.offset).append("\"").append(", ");
		sb.append("period=").append("\"").append(this.period).append("\"").append(", ");
		sb.append("task=").append("\"").append(this.task).append("\"");
		sb.append("]");
		return sb.toString();
	}

}
