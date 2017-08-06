package tree.model;

public class ReportGroupTreeItem extends AReportTreeItem {

	private Long reportGroupId;
	
	private Long cycleId;

	public ReportGroupTreeItem(String uniqueId, String name) {
		super(uniqueId, name);
	}

	public ReportGroupTreeItem(String uniqueId, String name, String toolTip) {
		super(uniqueId, name, toolTip);
	}

	public Long getReportGroupId() {
		return reportGroupId;
	}

	public void setReportGroupId(Long reportGroupId) {
		this.reportGroupId = reportGroupId;
	}

	public Long getCycleId() {
		return cycleId;
	}

	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof ReportGroupTreeItem){
			ReportGroupTreeItem reportGroupItem = (ReportGroupTreeItem) obj;
			if(reportGroupItem.getCycleId() == this.reportGroupId)
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return Integer.valueOf(this.reportGroupId + "");
	}

}
