
public class TGEN_Report {
	
	private Application application;
	private LET let;
	private Buffering buffering;
	
	public TGEN_Report() {
		
	}

	public TGEN_Report(Application application, LET let, Buffering buffering) {
		this();
		this.application = application;
		this.let = let;
		this.buffering = buffering;
	}

	
	//------------------------------------------- Getters and Setters -------------------------------------------
	
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public LET getLet() {
		return let;
	}

	public void setLet(LET let) {
		this.let = let;
	}

	public Buffering getBuffering() {
		return buffering;
	}

	public void setBuffering(Buffering buffering) {
		this.buffering = buffering;
	}
	
	
	//------------------------------------------- Override Functions -------------------------------------------

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append("[").append("\n");
		sb.append("\t").append("application: ").append(this.application.toString()).append(", ").append("\n");
		sb.append("\t").append("let: ").append(this.let.toString()).append(", ").append("\n");
		sb.append("\t").append("buffering: ").append(this.buffering.toString()).append("\n");
		sb.append("]");
		return sb.toString();
	}
	

}
