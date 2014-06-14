package eventoris.datatypes;

public class CommentInfo {

	int eventId;
	int posterId;
	int commentId;
	String comment;
	String dateAdded;
	String ownerName;
	String ownerFamily;

	public String getOwnerFamily() {
		return ownerFamily;
	}

	public void setOwnerFamily(String ownerFamily) {
		this.ownerFamily = ownerFamily;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getPosterId() {
		return posterId;
	}

	public void setPosterId(int posterId) {
		this.posterId = posterId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder(this.getClass().getCanonicalName());
		builder.append("[comment=").append(getComment());
		builder.append(";commentId=").append(getCommentId());
		builder.append(";dateAdded=").append(getDateAdded());
		builder.append(";eventId=").append(getEventId());
		builder.append(";ownerFamily=").append(getOwnerFamily());
		builder.append(";ownerName=").append(getOwnerName());
		builder.append(";posterId=").append(getPosterId());
		builder.append("]");
		return builder.toString();
	}
	
}
