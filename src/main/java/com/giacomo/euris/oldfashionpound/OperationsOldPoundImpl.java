package com.giacomo.euris.oldfashionpound;

import java.util.ArrayList;
import java.util.List;

public class OperationsOldPoundImpl implements OperationsOldPound{

	private final Integer D_MODULE = 12;
	private final Integer S_MODULE = 20;
	
	public OldMoney sum(List<OldMoney> listMoney) {

		OldMoney resultMoney = new OldMoney();
		OldMoney price1 = listMoney.get(0);
		OldMoney price2 = listMoney.get(1);
		Integer d, s, p, carryOver;
		carryOver = 0;
		
		d = price1.getD() + price2.getD();
		resultMoney.setD(d % D_MODULE);
		carryOver = d/D_MODULE;
		
		s = price1.getS() + price2.getS() + carryOver;
		resultMoney.setS(s % S_MODULE);
		
		carryOver = s/S_MODULE;
		
		p = price1.getP() + price2.getP();
		resultMoney.setP(p + carryOver);
				
		return resultMoney;
	}

	public OldMoney difference(List<OldMoney> listMoney) {
		
		OldMoney resultMoney = new OldMoney();
		OldMoney price1 = listMoney.get(0);
		OldMoney price2 = listMoney.get(1);
		Integer d, s, p, carryOver;
		
		carryOver = 0;
		
		d = price1.getD() - price2.getD();
		//System.out.println("d % 12 = " + (d%D_MODULE + D_MODULE)%D_MODULE );
		resultMoney.setD((d%D_MODULE + D_MODULE) % D_MODULE);
		if(d < 0) {
			carryOver = -1;
			carryOver = carryOver + (d/D_MODULE);
		}else {
			carryOver = d/D_MODULE;
		}
		
		s = price1.getS() - price2.getS() + carryOver;
		resultMoney.setS((s%S_MODULE + S_MODULE) % S_MODULE);
		
		carryOver = 0;
		if(s < 0) {
			carryOver = -1;
			carryOver = carryOver + (s/S_MODULE);
		}else {
			carryOver = s/S_MODULE;
		}

		p = price1.getP() - price2.getP();
		resultMoney.setP(p + carryOver);
				
		return resultMoney;
	}

	
	public OldMoney multiplication(OldMoney price, Integer n) {
		
		OldMoney result = new OldMoney();
		Integer d, s, p, carryOver;
		
		d = price.getD() * n;
		result.setD(d % D_MODULE);
		carryOver = d/D_MODULE;
		
		s = (price.getS() * n) + carryOver;
		result.setS(s % S_MODULE);
		carryOver = s / S_MODULE;
		
		p = (price.getP() * n) + carryOver;
		result.setP(p);
		
		return result;
	}

	public List<OldMoney> division(OldMoney price, Integer n) {
		
		OldMoney result = new OldMoney();
		OldMoney remainder = new OldMoney();
		List<OldMoney> listResults = new ArrayList<OldMoney>();
		Integer d, s, p, carryOver;
		
		
		d = price.getD() / n;
		result.setD(d % D_MODULE);
		remainder.setD(price.getD() % n);
		carryOver = d / D_MODULE;
		
		s = (price.getS() / n) + carryOver;
		result.setS(s % S_MODULE);
		remainder.setS( (price.getS() % n));
		carryOver = s / S_MODULE;
		
		p = (price.getP() / n) + carryOver;
		result.setP(p);
		remainder.setP(price.getP() % n); 
		
		listResults.add(result);
		listResults.add(remainder);
		
		return listResults;
	}

}
