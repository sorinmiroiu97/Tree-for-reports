package tree.model;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

	private long uniqueID;
	private String nodeName;
	private String ToolTip;

	// parent: List<ITreeItems>
	// parent reportTreeItems

	// protected List<ReportTreeItems> children;

	List<IReportTreeItem> parent;
	List<IReportTreeItem> children;
	String value;

	public void setList(String value) {
		this.children = new ArrayList<>();
		this.value = value;
	}

	public void addChild(IReportTreeItem child) {
		children.add(child);
	}

	
	
	public void addItem(IReportTreeItem item) {

	}

	public void addItems(List<IReportTreeItem> listItems) {

	}

	public void printTree() {

	}

	
	
	public List<IReportTreeItem> rootItems(List<IReportTreeItem> treeItems) {

		List<IReportTreeItem> cycleItems = new ArrayList<IReportTreeItem>();

		for (IReportTreeItem item : treeItems) {

			if (item instanceof CycleTreeItem) {

				cycleItems.add(item);

			}
		}

		return cycleItems;
	}
	
	
	
	public void printTestTree() {
		
		ReportTreeItemFactory factoryItem = new ReportTreeItemFactory();
		
		List<IReportTreeItem> mapedTreeItemsList = factoryItem.loadReportsTree();

		for (IReportTreeItem item : mapedTreeItemsList) {

			if (item instanceof CycleTreeItem) {
				System.out.print("-");
				item.printDescription();
			}
			if (item instanceof ReportGroupTreeItem) {
				System.out.print("---");
				item.printDescription();
			}
			if (item instanceof ReportTreeItem) {
				System.out.print("-----");
				item.printDescription();
			}

		}

	}
	
	
	//TODO replace rootItems() method with generateRootNodes() method
//	public List<IReportTreeItem> generateRootNodes() {
//		//user file parser to generate descrpitors - adica fac asa
			//FileParser fileParse = new FileParser();
			//fileParse.parseFile();
//		//user Factory to create the list of tree items based on the descriptors
//		//extract and return only root items
//	}

}
