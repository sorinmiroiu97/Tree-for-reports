package tree;

public enum HEADER {
	CYCLE_ID("cycleID",0), CYCLE_DATE("cycleDate",1), CYCLE_TOOLT_IP("cycleTooltip",2), 
	REPORT_GROUP_ID("reportGroupID",3), REPORT_GROUP_NAME("ReportGroupName",4), REPORT_GROUP_TOOLTIP("ReportGroupTooltip",5), 
	REPORT_ID("ReportId",6), REPORT_NAME("ReportName",7), REPORT_TOOLTIP("ReportTooltip",8);
	
	protected String headerName;
	protected int index;
	
	
	private HEADER(String headerName, int index){
		this.setHeaderName(headerName);
		this.setHeaderIndex(index);
	}
	
	private HEADER(String headerName){
		this.setHeaderName(headerName);
	}
	
	private HEADER(int index){
		this.index = index;
	}


	public String getHeaderName() {
		return headerName;
	}


	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	
	public void setHeaderIndex(int index){
		this.index = index;
	}
	
	public int getHeaderIndex(){
		return index;
	}
	
	
	
}