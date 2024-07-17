package model;

public class student {
    private String name;
    private String std;
    private int rollNo;
    
	public student(String name, String std, int rollNo) {
		
		this.name = name;
		this.std = std;
		this.rollNo = rollNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
}
