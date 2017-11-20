package report_parsing;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import report_parsing.application.Access;
import report_parsing.application.Application;
import report_parsing.application.Application_Function;
import report_parsing.application.Call;
import report_parsing.application.Data;
import report_parsing.application.Part;
import report_parsing.buffering.BufferImplementation;
import report_parsing.buffering.BufferRequirement;
import report_parsing.buffering.Buffering;
import report_parsing.let.Core;
import report_parsing.let.CoreMapping;
import report_parsing.let.Invocation;
import report_parsing.let.LET;
import report_parsing.let.LET_Function;
import report_parsing.let.Mode;
import report_parsing.let.Module;
import report_parsing.let.TDLMapping;
import report_parsing.let.TDLProgram;
import report_parsing.let.TDLTask;
import report_parsing.let.Target;


public class ReportParser {
	
	// ------------------------------------------ Application ------------------------------------------
	private static final String XML_SECTION_APPLICATION = "Application";
	
	private static final String XML_SUB_SECTION_PARTS = "Parts";
	
	//private static final String XML_ITEM_PART = "Part";
	private static final String XML_ATTRIBUTE_PART_NAME = "name";
	private static final String XML_ATTRIBUTE_PART_STATUS = "status";
	private static final String XML_ATTRIBUTE_PART_SYMBOL = "symbol";
	
	private static final String XML_SUB_SECTION_FUNCTIONS = "Functions";
	
	//private static final String XML_ITEM_APPLICATION_FUNCTION = "Function";
	private static final String XML_ATTRIBUTE_APPLICATION_FUNCTION_NAME = "name";
	private static final String XML_ATTRIBUTE_APPLICATION_FUNCTION_COMPONENT = "component";
	private static final String XML_ATTRIBUTE_APPLICATION_FUNCTION_PART = "part";
	
	private static final String XML_ITEM_ACCESS = "Access";
	private static final String XML_ATTRIBUTE_ACCESS_NAME = "name";
	private static final String XML_ATTRIBUTE_ACCESS_ACCESSTYPE = "accessType";
	private static final String XML_ATTRIBUTE_ACCESS_MULTIPLICITY = "multiplicity";
	private static final String XML_ATTRIBUTE_ACCESS_PROTECTION = "protection";
	
	private static final String XML_ITEM_CALL = "Call";
	private static final String XML_ATTRIBUTE_CALL_NAME = "name";
	
	private static final String XML_SUB_SECTION_DATAS = "Datas";
	
	//private static final String XML_ITEM_DATA = "Data";
	private static final String XML_ATTRIBUTE_DATA_NAME = "name";
	private static final String XML_ATTRIBUTE_DATA_CATEGORY = "category";
	private static final String XML_ATTRIBUTE_DATA_NUM_DIMENSIONS = "numDimensions";
	private static final String XML_ATTRIBUTE_DATA_NUM_ELEMENTS = "numElements";
	private static final String XML_ATTRIBUTE_DATA_PART = "part";
	private static final String XML_ATTRIBUTE_DATA_SIZE = "size";
	private static final String XML_ATTRIBUTE_DATA_TYPE = "type";
	
	
	// ---------------------------------------------- LET ----------------------------------------------
	private static final String XML_SECTION_LET = "LET";
	
	private static final String XML_ITEM_TARGET = "Target";
	private static final String XML_ATTRIBUTE_TARGET_NAME = "name";
	private static final String XML_ATTRIBUTE_TARGET_CLOCK_FREQUENZ_MHZ = "clockFrequency_MHz";
	private static final String XML_ATTRIBUTE_TARGET_CORES = "cores";
	private static final String XML_ATTRIBUTE_TARGET_OS_TYPE = "osType";
	private static final String XML_ATTRIBUTE_TARGET_TYPE = "type";
	
	//private static final String XML_ITEM_CORE = "Core";
	private static final String XML_ATTRIBUTE_CORE_NAME = "name";
	private static final String XML_ATTRIBUTE_CORE_UNIT = "unit";
	
	private static final String XML_ITEM_TLD_PROGRAM = "TDLProgram";
	private static final String XML_ATTRIBUTE_TLD_PROGRAM_NAME= "name";
	
	private static final String XML_ITEM_TLD_TASK = "TDLTask";
	private static final String XML_ATTRIBUTE_TLD_TASK_NAME= "name";
	
	//private static final String XML_ITEM_TLD_FUNCTION = "Function";
	private static final String XML_ATTRIBUTE_TLD_FUNCTION_NAME = "name";
	private static final String XML_ATTRIBUTE_TLD_FUNCTION_INDEX = "index";
	
	private static final String XML_ITEM_MODULE = "Module";
	private static final String XML_ATTRIBUTE_MODULE_NAME = "name";
	
	//private static final String XML_ITEM_MODE = "Mode";
	private static final String XML_ATTRIBUTE_MODE_NAME = "name";
	private static final String XML_ATTRIBUTE_MODE_INITIAL = "initial";
	private static final String XML_ATTRIBUTE_MODE_PERIOD = "period";
	private static final String XML_ATTRIBUTE_MODE_UNIT= "unit";
	
	//private static final String XML_ITEM_INVOCATION = "Invocation";
	private static final String XML_ATTRIBUTE_INVOCATION_LET = "LET";
	private static final String XML_ATTRIBUTE_INVOCATION_OFFSET = "offset";
	private static final String XML_ATTRIBUTE_INVOCATION_PERIOD = "period";
	private static final String XML_ATTRIBUTE_INVOCATION_TASK = "task";
	
	private static final String XML_ITEM_TDL_MAPPING = "TDLMapping";
	private static final String XML_ATTRIBUTE_TLD_MAPPING_PROGRAM = "program";
	private static final String XML_ATTRIBUTE_TLD_MAPPING_TARGET = "target";
	
	//private static final String XML_ITEM_CORE_MAPPING= "CoreMapping";
	private static final String XML_ATTRIBUTE_CORE_MAPPING_CORE = "core";
	private static final String XML_ATTRIBUTE_CORE_MAPPING_MODULES = "modules";
	
	
	// ------------------------------------------- Buffering -------------------------------------------
	private static final String XML_SECTION_BUFFERING = "Buffering";
	
	private static final String XML_SUB_SECTION_BUFFER_IMPLEMENTATIONS = "BufferImplementations";
	
	//private static final String XML_ITEM_BUFFER_IMPLEMENTATION = "BufferImplementation";
	private static final String XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_NAME = "name";
	private static final String XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_CATEGORY = "category";
	private static final String XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_NEEDS_DIRTY_FLAG = "needsDirtyFlag";
	private static final String XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_NUM_DIMENSIONS = "numDimensions";
	private static final String XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_NUM_ELEMENTS = "numElements";
	private static final String XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_PART = "part";
	private static final String XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_SIZE = "size";
	private static final String XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_TYPE = "type";
	
	private static final String XML_SUB_SECTION_BUFFER_REQUIREMENTS = "BufferRequirements";
	
	//private static final String XML_ITEM_BUFFER_REQUIREMENT = "BufferRequirement";
	private static final String XML_ATTRIBUTE_BUFFER_REQUIREMENT_MAPPED_TO = "mappedTo";
	private static final String XML_ATTRIBUTE_BUFFER_REQUIREMENT_TASK = "task";
	private static final String XML_ATTRIBUTE_BUFFER_REQUIREMENT_TYPE = "type";
	private static final String XML_ATTRIBUTE_BUFFER_REQUIREMENT_VAR = "var";
	
	
	//---------------------------------------------- Parse Report ---------------------------------------------
	
	public static TGEN_Report parseReport(String path) throws SAXException, IOException, ParserConfigurationException {
		TGEN_Report report = new TGEN_Report();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File(path));
		Element root = doc.getDocumentElement();
		
		NodeList nl = root.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			if (n.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			
			if (n.getNodeName().equals(XML_SECTION_APPLICATION)) {
				Application application = parseApplication(n);
				report.setApplication(application); 
			} else if (n.getNodeName().equals(XML_SECTION_LET)) {
				LET let = parseLET(n);
				report.setLet(let);
			} else if (n.getNodeName().equals(XML_SECTION_BUFFERING)) {
				Buffering buffering = parseBuffering(n);
				report.setBuffering(buffering);
			}
		}
		
		return report;
	}
	
	
	//------------------------------------------- Parse Application -------------------------------------------
	
	private static Part parsePart(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_PART_NAME).getNodeValue();
		String status = n.getAttributes().getNamedItem(XML_ATTRIBUTE_PART_STATUS).getNodeValue();
		String symbol = n.getAttributes().getNamedItem(XML_ATTRIBUTE_PART_SYMBOL).getNodeValue();
		
		return new Part(name, status, symbol);
	}
	
	private static Access parseAccess(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_ACCESS_NAME).getNodeValue();
		String accessType = n.getAttributes().getNamedItem(XML_ATTRIBUTE_ACCESS_ACCESSTYPE).getNodeValue();
		int multiplicity = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_ACCESS_MULTIPLICITY).getNodeValue());
		String protection = n.getAttributes().getNamedItem(XML_ATTRIBUTE_ACCESS_PROTECTION).getNodeValue();
		
		return new Access(name, accessType, multiplicity, protection);
	}
	
	private static Call parseCall(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_CALL_NAME).getNodeValue();
		
		return new Call(name);
	}
	
	private static Application_Function parseApplicationFunction(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_APPLICATION_FUNCTION_NAME).getNodeValue();
		String component = n.getAttributes().getNamedItem(XML_ATTRIBUTE_APPLICATION_FUNCTION_COMPONENT).getNodeValue();
		String part = n.getAttributes().getNamedItem(XML_ATTRIBUTE_APPLICATION_FUNCTION_PART).getNodeValue();
		Application_Function function = new Application_Function(name, component, part);
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			
			if (sub_node.getNodeName().equals(XML_ITEM_ACCESS)) {
				Access access = parseAccess(sub_node);
				function.addAccess(access);
				
			} else if (sub_node.getNodeName().equals(XML_ITEM_CALL)) {
				Call call = parseCall(sub_node);
				function.addCall(call);
			}
		}
		return function;
	}
	
	private static Data parseData(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_DATA_NAME).getNodeValue();
		String category = n.getAttributes().getNamedItem(XML_ATTRIBUTE_DATA_CATEGORY).getNodeValue();
		int numDimensions = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_DATA_NUM_DIMENSIONS).getNodeValue());
		int numElements = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_DATA_NUM_ELEMENTS).getNodeValue());
		String part = n.getAttributes().getNamedItem(XML_ATTRIBUTE_DATA_PART).getNodeValue();
		int size = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_DATA_SIZE).getNodeValue());
		String type = n.getAttributes().getNamedItem(XML_ATTRIBUTE_DATA_TYPE).getNodeValue();
		
		return new Data(name, category, numDimensions, numElements, part, size, type);
	}
	
	private static Application parseApplication(Node n) {
		
		Application application = new Application();
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			if (sub_node.getNodeName().equals(XML_SUB_SECTION_PARTS)) { //Parse Parts
				NodeList nl_p = sub_node.getChildNodes();
				for (int j = 0; j < nl_p.getLength(); j++) {
					Node part_node = nl_p.item(j);
					if (part_node.getNodeType() != Node.ELEMENT_NODE) {
						continue;
					}
					Part part = parsePart(part_node);
					application.addPart(part);
				}
			} else if (sub_node.getNodeName().equals(XML_SUB_SECTION_FUNCTIONS)) { //Parse Functions
				NodeList nl_f = sub_node.getChildNodes();
				for (int j = 0; j < nl_f.getLength(); j++) {
					Node function_node = nl_f.item(j);
					if (function_node.getNodeType() != Node.ELEMENT_NODE) {
						continue;
					}
					Application_Function function = parseApplicationFunction(function_node);
					application.addApplicationFunction(function);
				}
			} else if (sub_node.getNodeName().equals(XML_SUB_SECTION_DATAS)) { //Parse Datas
				NodeList nl_d = sub_node.getChildNodes();
				for (int j = 0; j < nl_d.getLength(); j++) {
					Node data_node = nl_d.item(j);
					if (data_node.getNodeType() != Node.ELEMENT_NODE) {
						continue;
					}
					Data data = parseData(data_node);
					application.addData(data);
				}
			}
		}
		
		return application;
	}
	
	
	//------------------------------------------------ Parse LET ------------------------------------------------
	
	private static Core parseCore(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_CORE_NAME).getNodeValue();
		String unit = n.getAttributes().getNamedItem(XML_ATTRIBUTE_CORE_UNIT).getNodeValue();
		
		return new Core(name, unit);
	}
	
	private static Target parseTarget(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_TARGET_NAME).getNodeValue();
		int clockFrequency_MHz = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_TARGET_CLOCK_FREQUENZ_MHZ).getNodeValue());
		int cores = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_TARGET_CORES).getNodeValue());
		String osType = n.getAttributes().getNamedItem(XML_ATTRIBUTE_TARGET_OS_TYPE).getNodeValue();
		String type = n.getAttributes().getNamedItem(XML_ATTRIBUTE_TARGET_TYPE).getNodeValue();
		Target target = new Target(name, clockFrequency_MHz, cores, osType, type);
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			Core core = parseCore(sub_node);
			target.addCore(core);
		}
		
		return target;
	}
	
	private static LET_Function parseLetFunction(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_TLD_FUNCTION_NAME).getNodeValue();
		int index = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_TLD_FUNCTION_INDEX).getNodeValue());
		
		return new LET_Function(name, index);
	}
	
	private static TDLTask parseTdlTask(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_TLD_TASK_NAME).getNodeValue();
		TDLTask task = new TDLTask(name);
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			LET_Function function = parseLetFunction(sub_node);
			task.addFunction(function);
		}
		
		return task;
	}
	
	private static TDLProgram parseTdlProgram(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_TLD_PROGRAM_NAME).getNodeValue();
		TDLProgram program = new TDLProgram(name);
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			if (sub_node.getNodeName().equals(XML_ITEM_TLD_TASK)) {
				TDLTask task = parseTdlTask(sub_node);
				program.addTDLTask(task);
			} else if (sub_node.getNodeName().equals(XML_ITEM_MODULE)) {
				Module module = parseModule(sub_node);
				program.addModule(module);
			}
		}
		
		return program;
	}
	
	private static Invocation parseInvocation(Node n) {
		int let = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_INVOCATION_LET).getNodeValue());
		int offset = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_INVOCATION_OFFSET).getNodeValue());
		int period = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_INVOCATION_PERIOD).getNodeValue());
		String task = n.getAttributes().getNamedItem(XML_ATTRIBUTE_INVOCATION_TASK).getNodeValue();
		
		return new Invocation(let, offset, period, task);
	}
	
	private static Mode parseMode(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_MODE_NAME).getNodeValue();
		boolean initial = Boolean.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_MODE_INITIAL).getNodeValue());
		int period = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_MODE_PERIOD).getNodeValue());
		String unit = n.getAttributes().getNamedItem(XML_ATTRIBUTE_MODE_UNIT).getNodeValue();
		Mode mode = new Mode(name, initial, period, unit);
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			Invocation invocation = parseInvocation(sub_node);
			mode.addInvocation(invocation);
		}
		
		return mode;
	}
	
	private static Module parseModule(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_MODULE_NAME).getNodeValue();
		Module module = new Module(name);
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			Mode mode = parseMode(sub_node);
			module.addModes(mode);
		}
		
		return module;
	}
	
	private static CoreMapping parseCoreMapping(Node n) {
		String core = n.getAttributes().getNamedItem(XML_ATTRIBUTE_CORE_MAPPING_CORE).getNodeValue();
		String modules = n.getAttributes().getNamedItem(XML_ATTRIBUTE_CORE_MAPPING_MODULES).getNodeValue();
		
		return new CoreMapping(core, modules);
	}
	
	private static TDLMapping parseTdlMapping(Node n) {
		String program = n.getAttributes().getNamedItem(XML_ATTRIBUTE_TLD_MAPPING_PROGRAM).getNodeValue();
		String target = n.getAttributes().getNamedItem(XML_ATTRIBUTE_TLD_MAPPING_TARGET).getNodeValue();
		TDLMapping mapping = new TDLMapping(program, target);
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			CoreMapping coreMapping = parseCoreMapping(sub_node);
			mapping.addCoreMapping(coreMapping);
		}
		
		return mapping;
	}
	
	private static LET parseLET(Node n) {
		LET let = new LET();
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			if (sub_node.getNodeName().equals(XML_ITEM_TARGET)) {
				Target target = parseTarget(sub_node);
				let.setTarget(target);
			} else if (sub_node.getNodeName().equals(XML_ITEM_TLD_PROGRAM)) {
				TDLProgram program = parseTdlProgram(sub_node);
				let.setTdlProgram(program);
			} else if (sub_node.getNodeName().equals(XML_ITEM_TDL_MAPPING)) {
				TDLMapping mapping = parseTdlMapping(sub_node);
				let.setTdlMapping(mapping);
			}
		}
		return let;
	}
	
	//----------------------------------------------- Buffering -----------------------------------------------
	

	private static BufferImplementation parseBufferImplementation(Node n) {
		String name = n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_NAME).getNodeValue();
		String category = n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_CATEGORY).getNodeValue();
		boolean needsDirtyFlag = Boolean.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_NEEDS_DIRTY_FLAG).getNodeValue());
		int numDimensions = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_NUM_DIMENSIONS).getNodeValue());
		int numElements = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_NUM_ELEMENTS).getNodeValue());
		String part = n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_PART).getNodeValue();
		int size = Integer.valueOf(n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_SIZE).getNodeValue());
		String type = n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_IMPLEMENTATION_TYPE).getNodeValue();
		
		return new BufferImplementation(name, category, needsDirtyFlag, numDimensions, numElements, part, size, type);
	}
	
	private static BufferRequirement parseBufferRequirement(Node n) {
		String mappedTo = n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_REQUIREMENT_MAPPED_TO).getNodeValue();
		String task = n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_REQUIREMENT_TASK).getNodeValue();
		String type = n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_REQUIREMENT_TYPE).getNodeValue();
		String var = n.getAttributes().getNamedItem(XML_ATTRIBUTE_BUFFER_REQUIREMENT_VAR).getNodeValue();
		
		return new BufferRequirement(mappedTo, task, type, var);
	}
	
	private static Buffering parseBuffering(Node n) {
		Buffering buffering = new Buffering();
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node sub_node = nl.item(i);
			if (sub_node.getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			
			if (sub_node.getNodeName().equals(XML_SUB_SECTION_BUFFER_IMPLEMENTATIONS)) {
				NodeList nl_bi = sub_node.getChildNodes();
				for (int j = 0; j < nl_bi.getLength(); j++) {
					Node bi_node = nl_bi.item(j);
					if (bi_node.getNodeType() != Node.ELEMENT_NODE) {
						continue;
					}
					BufferImplementation bi = parseBufferImplementation(bi_node);
					buffering.addBufferImplementation(bi);
				}
			} else if (sub_node.getNodeName().equals(XML_SUB_SECTION_BUFFER_REQUIREMENTS)) {
				NodeList nl_br = sub_node.getChildNodes();
				for (int j = 0; j < nl_br.getLength(); j++) {
					Node br_node = nl_br.item(j);
					if (br_node.getNodeType() != Node.ELEMENT_NODE) {
						continue;
					}
					BufferRequirement br = parseBufferRequirement(br_node);
					buffering.addBufferRequirement(br);
				}
			}
		}
		
		return buffering;
	}
	

}
