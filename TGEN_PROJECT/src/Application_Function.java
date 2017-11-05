import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report - Application
 *
 */
public class Application_Function implements Comparable<Application_Function> {
	
	private String name;
	private String component;
	private String part;
	private List<Access> accesses = new ArrayList<>();
	private List<Call> calls = new ArrayList<>();
	
	public Application_Function() {
		
	}
	
	public Application_Function(String name, String component, String part) {
		this();
		this.name = name;
		this.component = component;
		this.part = part;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getPart() {
		return part;
	}
	
	public Part getPart(TGEN_Report report) {
		return report.getApplication().getParts().stream().filter(e -> e.getSymbol().equals(part)).findFirst().orElse(null);
	}

	public void setPart(String part) {
		this.part = part;
	}
	
	public List<Access> getAccesses() {
		return accesses;
	}

	public void setAccesses(List<Access> accesses) {
		this.accesses = accesses;
	}

	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

	public void addAccess(Access access) {
		accesses.add(access);
	}
	
	public void addCall(Call call) {
		calls.add(call);
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
	    if (!(other instanceof Application_Function)) {
	    	return false;
	    }
	    Application_Function otherAppFunction = (Application_Function) other;
	    return this.name.equals(otherAppFunction.getName());
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(Application_Function other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("component=").append("\"").append(this.component).append("\"").append(", ");
		sb.append("part=").append("\"").append(this.part).append("\"").append(", ");
		sb.append("accesses:").append(this.accesses.size()).append(", ");
		sb.append("calls:").append(this.calls.size());
		sb.append("]");
		return sb.toString();
	}

}
