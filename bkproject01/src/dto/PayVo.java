package dto;

public class PayVo {
	private int orderNumer;
	private int bkSeq;
	private String date;
	private int price;
	private String id;
	public int getOrderNumer() {
		return orderNumer;
	}
	@Override
	public String toString() {
		return "PayVo [orderNumer=" + orderNumer + ", bkSeq=" + bkSeq + ", date=" + date + ", price=" + price + ", id="
				+ id + ", getOrderNumer()=" + getOrderNumer() + ", getBkSeq()=" + getBkSeq() + ", getDate()="
				+ getDate() + ", getPrice()=" + getPrice() + ", getId()=" + getId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public void setOrderNumer(int orderNumer) {
		this.orderNumer = orderNumer;
	}
	public int getBkSeq() {
		return bkSeq;
	}
	public void setBkSeq(int bkSeq) {
		this.bkSeq = bkSeq;
	}
	public String getDate() {
		return date;
	}
	public String setDate(String date) {
		return this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
