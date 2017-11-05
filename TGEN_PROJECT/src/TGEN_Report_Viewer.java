import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TGEN_Report_Viewer {
	
	public TGEN_Report_Viewer() throws SAXException, IOException, ParserConfigurationException {
		TGEN_Report report = ReportParser.parseReport("report.xml");
		
		
		System.out.println(report);
	}
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		new TGEN_Report_Viewer();
	}

}
