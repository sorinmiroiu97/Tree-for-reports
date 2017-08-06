package tree.model;

public abstract class AReportTreeItem implements IReportTreeItem {

	private String uniqueId;
	private String name;
	private String toolTip;

	public AReportTreeItem(String uniqueId, String name) {
		this.uniqueId = uniqueId;
		this.name = name;
	}

	public AReportTreeItem(String uniqueId, String name, String toolTip) {
		// super(uniqueId, name);
		this.uniqueId = uniqueId;
		this.name = name;
		this.toolTip = toolTip;
	}

	@Override
	public String getUniqueId() {
		return uniqueId;
	}

	@Override
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getToolTip() {
		return toolTip;
	}

	@Override
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	@Override
	public void printDescription() {
		System.out.println(" Name: " + name + " Tooltip: " + toolTip);

	}

}
