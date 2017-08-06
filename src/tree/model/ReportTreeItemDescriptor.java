package tree.model;

public class ReportTreeItemDescriptor {

	private int uniqueId;

	private String cycleId;
	private String cycleName;
	private String cycleTooltip;

	private String reportGroupId;
	private String reportGroupName;
	private String reportGroupTooltip;

	private String reportId;
	private String reportName;
	private String reportTooltip;

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getCycleId() {
		return cycleId;
	}

	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
	}

	public String getCycleName() {
		return cycleName;
	}

	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}

	public String getCycleTooltip() {
		return cycleTooltip;
	}

	public void setCycleTooltip(String cycleTooltip) {
		this.cycleTooltip = cycleTooltip;
	}

	public String getReportGroupId() {
		return reportGroupId;
	}

	public void setReportGroupId(String reportGroupId) {
		this.reportGroupId = reportGroupId;
	}

	public String getReportGroupName() {
		return reportGroupName;
	}

	public void setReportGroupName(String reportGroupName) {
		this.reportGroupName = reportGroupName;
	}

	public String getReportGroupTooltip() {
		return reportGroupTooltip;
	}

	public void setReportGroupTooltip(String reportGroupTooltip) {
		this.reportGroupTooltip = reportGroupTooltip;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportTooltip() {
		return reportTooltip;
	}

	public void setReportTooltip(String reportTooltip) {
		this.reportTooltip = reportTooltip;
	}

	public void printDescriptorItem() {

		System.out.print("UniqueID= " + this.getUniqueId());

		System.out.println(" Cycleid= " + getCycleId() + " CycleName= " + getCycleName() + " CycleTooltip= "
				+ getCycleTooltip() + "ReportGroupId= " + getReportGroupId() + " ReportGroupName= "
				+ getReportGroupName() + " ReportGroupTooltip= " + getReportGroupTooltip() + "ReportId= "
				+ getReportId() + " ReportName= " + getReportName() + " ReportTooltip= " + getReportTooltip());
	}

}
