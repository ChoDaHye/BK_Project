package dto;

// user 클래스의 정보를 DB에 저장 및 로드하기 위한 매개 클래스

public class UserVo {
	private String id;
	private int age;
	private boolean order;
	private int orderRecord;

	
	// user 기본 생성자
	 public void user(String id, int age) {
	        this.id = id;
	        this.age = age;
	  
	    }

  //각 필드의 Getter, Setter
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isOrder() {
		return order;
	}


	public void setOrder(boolean order) {
		this.order = order;
	}


	public int getOrderRecord() {
		return orderRecord;
	}


	public void setOrderRecord(int orderRecord) {
		this.orderRecord = orderRecord;
	}
	public void setAge(String age) {
		
	}


	 
}