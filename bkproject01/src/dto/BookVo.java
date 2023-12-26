package dto;

public class BookVo {
	
	private String title;
	private int bkSeq;
	private String bkCategory;
	private int orCount;
	private int bkAge;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBkSeq() {
		return bkSeq;
	}
	public void setBkSeq(int bkSeq) {
		this.bkSeq = bkSeq;
	}
	public String getBkCategory() {
		return bkCategory;
	}
	public void setBkCategory(String bkCategory) {
		this.bkCategory = bkCategory;
	}
	public int getOrCount() {
		return orCount;
	}
	@Override
	public String toString() {
		return "BookVo [title=" + title + ", bkSeq=" + bkSeq + ", bkCategory=" + bkCategory + ", orCount=" + orCount
				+ ", bkAge=" + bkAge + ", getTitle()=" + getTitle() + ", getBkSeq()=" + getBkSeq()
				+ ", getBkCategory()=" + getBkCategory() + ", getOrCount()=" + getOrCount() + ", getBkAge()="
				+ getBkAge() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public void setOrCount(int orCount) {
		this.orCount = orCount;
	}
	public int getBkAge() {
		return bkAge;
	}
	public void setBkAge(int bkAge) {
		this.bkAge = bkAge;
	}
	public void setBkAge(BookVo age1) {
		
	}
	
		
}