import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report
 *
 */
public class Buffering {
	
	private List<BufferImplementation> bufferImplementations = new ArrayList<>();
	private List<BufferRequirement> bufferRequirements = new ArrayList<>();
	
	public Buffering() {
		
	}
	
	public Buffering(List<BufferImplementation> bufferImplementations, List<BufferRequirement> bufferRequirements) {
		this();
		this.bufferImplementations = bufferImplementations;
		this.bufferRequirements = bufferRequirements;
	}


	//------------------------------------------- Getters and Setters -------------------------------------------

	public List<BufferImplementation> getBufferImplementations() {
		return bufferImplementations;
	}

	public void setBufferImplementations(List<BufferImplementation> bufferImplementations) {
		this.bufferImplementations = bufferImplementations;
	}

	public List<BufferRequirement> getBufferRequirements() {
		return bufferRequirements;
	}

	public void setBufferRequirements(List<BufferRequirement> bufferRequirements) {
		this.bufferRequirements = bufferRequirements;
	}
	
	public void addBufferImplementation(BufferImplementation bufferImplementation) {
		bufferImplementations.add(bufferImplementation);
	}
	
	public void addBufferRequirement(BufferRequirement bufferRequirement) {
		bufferRequirements.add(bufferRequirement);
	}
	
	
	//------------------------------------------- Override Functions -------------------------------------------
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("bufferImplementations:").append(this.bufferImplementations.size()).append(", ");
		sb.append("bufferRequirements:").append(this.bufferRequirements.size());
		sb.append("]");
		return sb.toString();
	}

}
