package hstd.model;

import javax.persistence.Entity;

@Entity
public class Customer {
	public String ten;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	
}
