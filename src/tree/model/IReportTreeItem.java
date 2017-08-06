package tree.model;

public interface IReportTreeItem {

	public String getUniqueId();

	public void setUniqueId(String uniqueId);

	public String getName();

	public void setName(String name);

	public String getToolTip();
	
	public void setToolTip(String toolTip);
	
	public void printDescription();
	
}
