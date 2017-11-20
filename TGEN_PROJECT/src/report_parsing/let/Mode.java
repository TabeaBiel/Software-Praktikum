package report_parsing.let;
import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report - LET
 *
 */
public class Mode implements Comparable<Mode>{
	
	private String name;
	private boolean initial;
	private int period;
	private String unit;
	private List<Invocation> invocations = new ArrayList<>();
	
	public Mode() {
		
	}

	public Mode(String name, boolean initial, int period, String unit) {
		this();
		this.name = name;
		this.initial = initial;
		this.period = period;
		this.unit = unit;
	}
	
	//------------------------------------------- Getters and Setters -------------------------------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInitial() {
		return initial;
	}

	public void setInitial(boolean initial) {
		this.initial = initial;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public List<Invocation> getInvocations() {
		return invocations;
	}

	public void setInvocations(List<Invocation> invocations) {
		this.invocations = invocations;
	}
	
	public void addInvocation(Invocation invocation) {
		invocations.add(invocation);
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
	    if (!(other instanceof Mode)) {
	    	return false;
	    }
	    Mode otherMode = (Mode) other;
	    return this.name.equals(otherMode.getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(Mode other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("initial=").append("\"").append(this.initial).append("\"").append(", ");
		sb.append("period=").append("\"").append(this.period).append("\"").append(", ");
		sb.append("unit=").append("\"").append(this.unit).append("\"").append(", ");
		sb.append("invocations:").append(this.invocations.size());
		sb.append("]");
		return sb.toString();
	}

}
