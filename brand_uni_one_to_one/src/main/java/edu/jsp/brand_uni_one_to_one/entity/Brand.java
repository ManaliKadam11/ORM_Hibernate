package edu.jsp.brand_uni_one_to_one.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Brand {
	@Id
	private int brandid;
	private String brandname;
	private String logocolor;
	private int rate;

	@OneToOne
	private Stores stores;

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getLogocolor() {
		return logocolor;
	}

	public void setLogocolor(String logocolor) {
		this.logocolor = logocolor;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public Stores getStores() {
		return stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	public Brand() {
		super();
	}

}
