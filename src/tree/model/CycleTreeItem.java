package tree.model;

public class CycleTreeItem extends AReportTreeItem{
	
	private Long cycleId;
	
	public CycleTreeItem(String uniqueId, String name) {
		super(uniqueId, name);
	}
	
	public CycleTreeItem(String uniqueId, String name, String toolTip){
		super(uniqueId, name, toolTip);
	}
	
	public Long getCycleId() {
		return cycleId;
	}
	
	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof CycleTreeItem){
			CycleTreeItem cycleItem = (CycleTreeItem) obj;
			if(cycleItem.getCycleId() == this.cycleId)
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return Integer.valueOf(this.cycleId + "");
	}
	
}
