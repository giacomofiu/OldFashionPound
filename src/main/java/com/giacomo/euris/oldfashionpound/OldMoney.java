package com.giacomo.euris.oldfashionpound;

public class OldMoney {

	private Integer p;	//sterlina
	private Integer s;	//scellino
	private Integer d;	//penny
	
	public OldMoney() {}

	public OldMoney(Integer p, Integer s, Integer d) {
		this.p = p;
		this.s = s;
		this.d = d;
	}

	public Integer getP() {
		return p;
	}

	public void setP(Integer p) {
		this.p = p;
	}

	public Integer getS() {
		return s;
	}

	public void setS(Integer s) {
		this.s = s;
	}

	public Integer getD() {
		return d;
	}

	public void setD(Integer d) {
		this.d = d;
	}

}
