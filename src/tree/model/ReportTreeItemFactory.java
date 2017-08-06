package tree.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import tree.FileParser;

public class ReportTreeItemFactory {

	private IReportTreeItem createTreeItem(ReportTreeItemDescriptor descriptorItem) {
		
		//TODO sa fac aici punerea in mapuri si tot (mut logica din loadReportsTree() aici)
		
		if (descriptorItem.getCycleName() != null && descriptorItem.getCycleTooltip() != null
				&& descriptorItem.getReportGroupId() == null && descriptorItem.getReportId() == null) {
			return createCycleItem(descriptorItem);
		}

		if (descriptorItem.getCycleName() == null && descriptorItem.getCycleTooltip() == null
				&& descriptorItem.getCycleId() != null && descriptorItem.getReportId() == null
				&& descriptorItem.getReportGroupId() != null && descriptorItem.getReportGroupName() != null
				&& descriptorItem.getReportGroupTooltip() != null) {
			return createReportGroupItem(descriptorItem);
		}

		if (descriptorItem.getCycleName() == null && descriptorItem.getCycleTooltip() == null
				&& descriptorItem.getCycleId() != null && descriptorItem.getReportGroupId() != null
				&& descriptorItem.getReportGroupName() == null && descriptorItem.getReportGroupTooltip() == null
				&& descriptorItem.getReportId() != null && descriptorItem.getReportName() != null
				&& descriptorItem.getReportTooltip() != null) {
			return createReportItem(descriptorItem);
		}

		return null;

	}

	private CycleTreeItem createCycleItem(ReportTreeItemDescriptor descriptorItem) {

		String uniqueId = String.valueOf(descriptorItem.getUniqueId());

		CycleTreeItem cycleItem = new CycleTreeItem(uniqueId, descriptorItem.getCycleName(),
				descriptorItem.getCycleTooltip());

		Long cycleItemId = Long.valueOf(descriptorItem.getCycleId());

		cycleItem.setCycleId(cycleItemId);

		return cycleItem;

	}

	private ReportGroupTreeItem createReportGroupItem(ReportTreeItemDescriptor descriptorItem) {

		String uniqueId = String.valueOf(descriptorItem.getUniqueId());

		ReportGroupTreeItem reportGroupItem = new ReportGroupTreeItem(uniqueId, descriptorItem.getReportGroupName(),
				descriptorItem.getReportGroupTooltip());

		Long reportGroupItemId = Long.valueOf(descriptorItem.getReportGroupId());

		reportGroupItem.setReportGroupId(reportGroupItemId);

		Long cycleItemId = Long.valueOf(descriptorItem.getCycleId());

		reportGroupItem.setCycleId(cycleItemId);

		return reportGroupItem;

	}

	private ReportTreeItem createReportItem(ReportTreeItemDescriptor descriptorItem) {

		String uniqueId = String.valueOf(descriptorItem.getUniqueId());

		ReportTreeItem reportItem = new ReportTreeItem(uniqueId, descriptorItem.getReportName(),
				descriptorItem.getReportTooltip());

		Long reportItemId = Long.valueOf(descriptorItem.getReportId());

		reportItem.setReportId(reportItemId);

		Long reportGroupItemId = Long.valueOf(descriptorItem.getReportGroupId());

		reportItem.setReportGroupId(reportGroupItemId);

		Long cycleItemId = Long.valueOf(descriptorItem.getCycleId());

		reportItem.setCycleId(cycleItemId);

		return reportItem;

	}

	public List<IReportTreeItem> loadReportsTree() {
		
		CycleTreeItem cycleTreeItem;
		ReportGroupTreeItem reportGroupTreeItem;
		ReportTreeItem reportTreeItem;
			
		List<IReportTreeItem> mapedTreeItemsList = new ArrayList<IReportTreeItem>();

//		Map<CycleTreeItem, Map<ReportGroupTreeItem, ReportGroupTreeItem>> cycleItemsMap = new HashMap<CycleTreeItem, Map<ReportGroupTreeItem, ReportGroupTreeItem>>();
//		Map<ReportGroupTreeItem, HashSet<ReportTreeItem>> reportGroupItemsMap = new HashMap<ReportGroupTreeItem, HashSet<ReportTreeItem>>();
//		HashSet<ReportTreeItem> reportItemsMap = new HashSet<ReportTreeItem>();
		
		//testing map
		Map<Long, Object> treeItemsMap = new HashMap<Long, Object>();
		
		FileParser parseFile = new FileParser();
		List<ReportTreeItemDescriptor> lineDecriptors = parseFile.parseFile();
		
		List<IReportTreeItem> treeItems = new ArrayList<IReportTreeItem>();
		
		for (ReportTreeItemDescriptor lineDescriptor : lineDecriptors) {
			IReportTreeItem item = createTreeItem(lineDescriptor);
			treeItems.add(item);
		}

		Map<CycleTreeItem, Map<ReportGroupTreeItem, HashSet<ReportTreeItem>>> cycleItemsMap = new HashMap<CycleTreeItem, Map<ReportGroupTreeItem, HashSet<ReportTreeItem>>>();
		 
		 //Map<ReportGroupTreeItem, HashSet<ReportTreeItem>> reportGroupItemsMap = new HashMap<ReportGroupTreeItem, HashSet<ReportTreeItem>>();
		 //HashSet<ReportTreeItem> reportItemsMap = new HashSet<ReportTreeItem>();
		 
		for (IReportTreeItem item : treeItems) {

			if (item instanceof CycleTreeItem) {
				cycleTreeItem = (CycleTreeItem) item;
				
				Map<ReportGroupTreeItem, HashSet<ReportTreeItem>> reportGroupItemsMap = new HashMap<ReportGroupTreeItem, HashSet<ReportTreeItem>>();

				cycleItemsMap.put(cycleTreeItem, reportGroupItemsMap);
			}

			if (item instanceof ReportGroupTreeItem) {
				reportGroupTreeItem = (ReportGroupTreeItem) item;

				CycleTreeItem dummyCicleItem = new CycleTreeItem(String.valueOf(reportGroupTreeItem.getCycleId()),"dummy");

				Map<ReportGroupTreeItem, HashSet<ReportTreeItem>> reportGroupItemsMap = cycleItemsMap.get(dummyCicleItem);

				HashSet<ReportTreeItem> reportItemsMap = new HashSet<ReportTreeItem>();

				reportGroupItemsMap.put(reportGroupTreeItem, reportItemsMap);
			}

			if (item instanceof ReportTreeItem) {

				reportTreeItem = (ReportTreeItem) item;
				
				CycleTreeItem dummyCicleItem = new CycleTreeItem(String.valueOf(reportGroupTreeItem.getCycleId()),"dummy");

				Map<ReportGroupTreeItem, HashSet<ReportTreeItem>> reportGroupItemsMap = cycleItemsMap.get(dummyCicleItem);

				ReportGroupTreeItem dummyRepGroupItem = new ReportGroupTreeItem(String.valueOf(reportTreeItem.getReportGroupId()), "dummy");

				HashSet<ReportTreeItem> reportItemsMap = reportGroupItemsMap.get(dummyRepGroupItem);

				reportItemsMap.add(reportTreeItem);

			}

		} // end of for

		
		List<Object> sortedList = new ArrayList<Object>();
		
		for(CycleTreeItem elem : cycleItemsMap.keySet()) {
			
		}
		
//			for (Long cycleElement : cycleItemsMap.keySet()) {
////				System.out.println("-" + cycleItemsMap.get(cycleElement).getName() + " "
////						+ cycleItemsMap.get(cycleElement).getToolTip());
//				cycleItemsMap.get(cycleElement).;
//				for (Long repGroupElement : reportGroupItemsMap.keySet()) {
//					if (cycleItemsMap.get(cycleElement).getCycleId() == reportGroupItemsMap.get(repGroupElement)
//							.getCycleId()) {
//						mapedTreeItemsList.add(reportGroupItemsMap.get(repGroupElement));
////						System.out.println("---" + reportGroupItemsMap.get(repGroupElement).getName() + " "
////								+ reportGroupItemsMap.get(repGroupElement).getToolTip());
//					}
//					for (Long reportElement : reportItemsMap.keySet()) {
//						if (cycleItemsMap.get(cycleElement).getCycleId() == reportGroupItemsMap.get(repGroupElement)
//								.getCycleId()
//								&& reportGroupItemsMap.get(repGroupElement).getCycleId() == reportItemsMap
//										.get(reportElement).getCycleId()
//								&& reportGroupItemsMap.get(repGroupElement).getReportGroupId() == reportItemsMap
//										.get(reportElement).getReportGroupId()) {
//							mapedTreeItemsList.add(reportItemsMap.get(reportElement));
////							System.out.println("-----" + reportItemsMap.get(reportElement).getName()
////									+ reportItemsMap.get(reportElement).getToolTip());
//						}
//					}
//				}
//			} // end of for
			
		
		
		
		return mapedTreeItemsList;
		
	}
	
}
