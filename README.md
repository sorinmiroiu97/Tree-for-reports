Reports tree project

The code basically reads a .txt file and creates a tree containig 3 items (a cycle item, a report group item and a report item).
The cycle items represents a node that contains a list of report group items nodes that contains a report items nodes.
I stored everything in a single map, this one: Map<CycleTreeItem, Map<ReportGroupTreeItem, HashSet<ReportTreeItem>>> cycleItemsMap.
The map has an key of CycleTreeItem type with a map (Map<ReportGroupTreeItem, HashSet<ReportTreeItem>> reportGroupItemsMap) as value, which map has as value a hashset (HashSet<ReportTreeItem> reportItemsMap).
I've overriden the equals and the hashcode methods in order for this trick to work.
