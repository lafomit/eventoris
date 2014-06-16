package eventoris.datatypes;

public class UserEventStatus {

	
	private boolean coming;
	private boolean maybeComing;
	
	public UserEventStatus(){
		coming = false;
		maybeComing = false;
	}

	public boolean isComing() {
		return coming;
	}

	public void setComing(boolean isComing) {
		this.coming = isComing;
	}

	public boolean isMaybeComing() {
		return maybeComing;
	}

	public void setMaybeComing(boolean isMaybeComing) {
		this.maybeComing = isMaybeComing;
	}
}
