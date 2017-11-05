
/**
 * For TGEN Report
 *
 */
public class LET {
	
	private Target target;
	private TDLProgram tdlProgram;
	private TDLMapping tdlMapping;
	
	public LET() {
		
	}

	public LET(Target target, TDLProgram tdlProgram, TDLMapping tdlMapping) {
		super();
		this.target = target;
		this.tdlProgram = tdlProgram;
		this.tdlMapping = tdlMapping;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------
	
	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public TDLProgram getTdlProgram() {
		return tdlProgram;
	}

	public void setTdlProgram(TDLProgram tdlProgram) {
		this.tdlProgram = tdlProgram;
	}

	public TDLMapping getTdlMapping() {
		return tdlMapping;
	}

	public void setTdlMapping(TDLMapping tdlMapping) {
		this.tdlMapping = tdlMapping;
	}
	
	
	//------------------------------------------- Override Functions -------------------------------------------

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("target:").append(this.target.toString()).append(", ");
		sb.append("tdlProgram:").append(this.tdlProgram.toString()).append(", ");
		sb.append("tdlMapping:").append(this.tdlMapping.toString());
		sb.append("]");
		return sb.toString();
	}
	
}