
/**
 * For TGEN Report - Buffering
 *
 */
public class BufferImplementation implements Comparable<BufferImplementation> {
	
	private String name;
	private String category;
	private boolean needsDirtyFlag;
	private int numDimensions;
	private int numElements;
	private String part;
	private int size;
	private String type;
	
	public BufferImplementation() {
		
	}

	public BufferImplementation(String name, String category, boolean needsDirtyFlag, int numDimensions,
			int numElements, String part, int size, String type) {
		this();
		this.name = name;
		this.category = category;
		this.needsDirtyFlag = needsDirtyFlag;
		this.numDimensions = numDimensions;
		this.numElements = numElements;
		this.part = part;
		this.size = size;
		this.type = type;
	}
	
	
	//------------------------------------------- Getters and Setters -------------------------------------------


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isNeedsDirtyFlag() {
		return needsDirtyFlag;
	}

	public void setNeedsDirtyFlag(boolean needsDirtyFlag) {
		this.needsDirtyFlag = needsDirtyFlag;
	}

	public int getNumDimensions() {
		return numDimensions;
	}

	public void setNumDimensions(int numDimensions) {
		this.numDimensions = numDimensions;
	}

	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	    if (!(other instanceof BufferImplementation)) {
	    	return false;
	    }
	    BufferImplementation otherBufferImplementation = (BufferImplementation) other;
	    return this.name.equals(otherBufferImplementation.getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public int compareTo(BufferImplementation other) {
		return this.name.compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("name=").append("\"").append(this.name).append("\"").append(", ");
		sb.append("category=").append("\"").append(this.category).append("\"").append(", ");
		sb.append("needsDirtyFlag=").append("\"").append(this.needsDirtyFlag).append("\"").append(", ");
		sb.append("numDimensions=").append("\"").append(this.numDimensions).append("\"").append(", ");
		sb.append("numElements=").append("\"").append(this.numElements).append("\"").append(", ");
		sb.append("part=").append("\"").append(this.part).append("\"").append(", ");
		sb.append("size=").append("\"").append(this.size).append("\"").append(", ");
		sb.append("type=").append("\"").append(this.type).append("\"");
		sb.append("]");
		return sb.toString();
	}
	
}
