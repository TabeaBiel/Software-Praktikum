import java.util.ArrayList;
import java.util.List;

/**
 * For TGEN Report
 *
 */
public class Application{
	
	private List<Part> parts = new ArrayList<>();
	private List<Application_Function> applicationFunctions = new ArrayList<>();
	private List<Data> datas = new ArrayList<>();
	
	public Application() {
		
	}

	public Application(List<Part> parts, List<Application_Function> applicationFunctions, List<Data> datas) {
		this();
		this.parts = parts;
		this.applicationFunctions = applicationFunctions;
		this.datas = datas;
	}

	
	//------------------------------------------- Getters and Setters -------------------------------------------
	
	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	public List<Application_Function> getApplicationFunctions() {
		return applicationFunctions;
	}

	public void setApplicationFunctions(List<Application_Function> applicationFunctions) {
		this.applicationFunctions = applicationFunctions;
	}

	public List<Data> getDatas() {
		return datas;
	}

	public void setDatas(List<Data> datas) {
		this.datas = datas;
	}
	
	public void addPart(Part part) {
		parts.add(part);
	}
	
	public void addApplicationFunction(Application_Function function) {
		applicationFunctions.add(function);
	}
	
	public void addData(Data data) {
		datas.add(data);
	}
	
	
	//------------------------------------------- Override Functions -------------------------------------------
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[");
		sb.append("parts:").append(this.parts.size()).append(", ");
		sb.append("applicationFunctions:").append(this.applicationFunctions.size()).append(", ");
		sb.append("datas:").append(this.datas.size());
		sb.append("]");
		return sb.toString();
	}

}
