package tree.model;

public class ReportTreeItem extends AReportTreeItem {

	private Long reportId;
	
	private Long reportGroupId;

	private Long cycleId;

	public ReportTreeItem(String uniqueId, String name) {
		super(uniqueId, name);
	}

	public ReportTreeItem(String uniqueId, String name, String toolTip) {
		super(uniqueId, name, toolTip);
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
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
