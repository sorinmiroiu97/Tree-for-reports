package tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import tree.model.ReportTreeItemDescriptor;

public class FileParser {

	public List<ReportTreeItemDescriptor> parseFile() {
		
		List<ReportTreeItemDescriptor> lineDecriptors = new ArrayList<ReportTreeItemDescriptor>();
		
		try {

//			ReportTreeItemFactory factoryItem = new ReportTreeItemFactory();
			
//			ReportService serviceItem = new ReportService();
			
			String line;

			final String FILE_PATH = "src/tableline.txt";
			File file = new File(FILE_PATH);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

//			List<ReportTreeItemDescriptor> lineDecriptors = new ArrayList<ReportTreeItemDescriptor>();
			int uniqueId = 0;

			while ((line = bufferedReader.readLine()) != null) {

				// split file line
				String[] lineTokens = line.split(",");

				// crate descriptor for line
				ReportTreeItemDescriptor lineDescriptor = createDescriptor(lineTokens, uniqueId++);

				if (lineDescriptor.getUniqueId() == 0)
					continue;

				// collect descriptor
				lineDecriptors.add(lineDescriptor);

			} // --> end of while

			bufferedReader.close();

			
			
			// print all descriptors
//			for (ReportTreeItemDescriptor lineDescriptor : lineDecriptors) {
//				lineDescriptor.printDescriptorItem();
//			}
			//DONE

			
			
//			List<IReportTreeItem> treeItems = new ArrayList<IReportTreeItem>();
//
//			for (ReportTreeItemDescriptor lineDescriptor : lineDecriptors) {
//				IReportTreeItem item = factoryItem.createTreeItem(lineDescriptor);
//				treeItems.add(item);
//			}
			//DONE

			
			
//			List<IReportTreeItem> roots = serviceItem.rootItems(treeItems);
//
//			System.out.println("(Root)Cycle items: ");
//
//			for (IReportTreeItem cycle : roots) {
//				cycle.printDescription();
//			}
			//SKIPED(NOT DONE YET)

			
			
			
//			System.out.println("Report tree: ");
//			
//			List<IReportTreeItem> arrangedTreeItems = factoryItem.loadReportsTree(treeItems);
//
//			for (IReportTreeItem item : arrangedTreeItems) {
//
//				if (item instanceof CycleTreeItem) {
//					System.out.print("-");
//					item.printDescription();
//				}
//				if (item instanceof ReportGroupTreeItem) {
//					System.out.print("---");
//					item.printDescription();
//				}
//				if (item instanceof ReportTreeItem) {
//					System.out.print("-----");
//					item.printDescription();
//				}
//				
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lineDecriptors;
		
	}

	private ReportTreeItemDescriptor createDescriptor(String[] lineTokens, int uniqueId) {

		//TODO EDIT THE METHOD WITHOUT THE FOR LOOP
		
		ReportTreeItemDescriptor newDescriptor = new ReportTreeItemDescriptor();

		newDescriptor.setUniqueId(uniqueId);

		for (int i = 0; i <= lineTokens.length - 1; i++) {

			if (i == 0) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setCycleId(lineTokens[i]);
					continue;
				}
			}
			if (i == 1) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setCycleName(lineTokens[i]);
					continue;
				}
			}
			if (i == 2) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setCycleTooltip(lineTokens[i]);
					continue;
				}
			}
			if (i == 3) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setReportGroupId(lineTokens[i]);
					continue;
				}
			}
			if (i == 4) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setReportGroupName(lineTokens[i]);
					continue;
				}
			}
			if (i == 5) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setReportGroupTooltip(lineTokens[i]);
					continue;
				}
			}
			if (i == 6) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setReportId(lineTokens[i]);
					continue;
				}
			}
			if (i == 7) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setReportName(lineTokens[i]);
					continue;
				}
			}
			if (i == 8) {
				if (lineTokens[i].isEmpty())
					continue;
				else {
					newDescriptor.setReportTooltip(lineTokens[i]);
					continue;
				}
			}

		}

		return newDescriptor;
	}

}
