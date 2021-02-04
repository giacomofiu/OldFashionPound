package com.giacomo.euris.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.giacomo.euris.oldfashionpound.OldMoney;
import com.giacomo.euris.oldfashionpound.OperationsOldPound;
import com.giacomo.euris.oldfashionpound.OperationsOldPoundImpl;
import com.giacomo.euris.oldfashionpound.OtherInput;

public class MainOldFashionPound {

	public static final String sum = "+";
	public static final String minus = "-";
	public static final String multiplication = "*";
	public static final String division = "/";

	
	public static void main(String[] args) {
		
		System.out.println("Operazioni su sistema monetario inglese antecedente al 1970");
		System.out.println("p = sterlina (pound)");
		System.out.println("s = scellino (shilling)");
		System.out.println("d = pence (penny)");
		System.out.println("");
		System.out.println("Valore:");
		System.out.println("1 scellino (s) = 12 pennies");
		System.out.println("1 sterlina (s) = 20 scellini");
		
		System.out.println("");
		
		List<OldMoney> listMoney = new ArrayList<OldMoney>();
		List<OldMoney> listMoneyResult;
		//otherInput.operation = operation; otherInput.factor = factor to multiply or divide by
		OtherInput otherInput = new OtherInput();
		getUserInput(listMoney, otherInput);
		
		OperationsOldPound operationsOldPound = new OperationsOldPoundImpl();
		OldMoney result;
		
		switch(otherInput.getOperation()) {
		
		case sum:
			result = operationsOldPound.sum(listMoney);
			printResult(result);
			break;
		case minus:
			result = operationsOldPound.difference(listMoney);
			printResult(result);
			break;
		case multiplication:
			result = operationsOldPound.multiplication(listMoney.get(0), otherInput.getFactor());
			printResult(result);
			break;
		case division:
			listMoneyResult = operationsOldPound.division(listMoney.get(0), otherInput.getFactor());
			printResultDivision(listMoneyResult);
			break;	
		}
			
		
	}//main
	
	public static void printResult(OldMoney result) {
		System.out.println("");
		System.out.println("Risultato:");
		System.out.println(result.getP() + "p " + result.getS() + "s " + result.getD() + "d");
	}

	public static void printResultDivision(List<OldMoney> listMoneyResult) {
		System.out.println("");
		System.out.println("Risultato:");
		System.out.println(listMoneyResult.get(0).getP() + "p " + listMoneyResult.get(0).getS() + "s " + listMoneyResult.get(0).getD() + "d " + " (" + listMoneyResult.get(1).getP() + "p " + listMoneyResult.get(1).getS() + "s " + listMoneyResult.get(1).getD() + "d)");
	}	
	
	public static void getUserInput(List<OldMoney> listMoney, OtherInput otherInput) {
		
		System.out.println("Inserisci un valore");
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		OldMoney oldMoney = new OldMoney();
		Integer money;
		Integer factor;
		
		System.out.println("sterline: ");
		money = getMoneyInput(buffReader);		
		oldMoney.setP(money);
		
		System.out.println("scellini: ");
		money = getMoneyInput(buffReader);
		oldMoney.setS(money);
		
		System.out.println("penny: ");
		money = getMoneyInput(buffReader);
		oldMoney.setD(money);
		
		listMoney.add(oldMoney);
		
		System.out.println("");
		System.out.println("Inserisci una operazione:");
		System.out.println("+, -, *, /");
		
		String operation = getOperationInput(buffReader);
		otherInput.setOperation(operation);
		
		if(operation.equalsIgnoreCase(sum) || operation.equalsIgnoreCase(minus)) {
			System.out.println("Inserisci il secondo valore");
			oldMoney = new OldMoney();
			System.out.println("sterline: ");
			money = getMoneyInput(buffReader);		
			oldMoney.setP(money);
			
			System.out.println("scellini: ");
			money = getMoneyInput(buffReader);
			oldMoney.setS(money);
			
			System.out.println("penny: ");
			money = getMoneyInput(buffReader);
			oldMoney.setD(money);
			
			listMoney.add(oldMoney);
			System.out.println("Hai inserito: ");
			System.out.println(listMoney.get(0).getP() + "p " + listMoney.get(0).getS() + "s " + listMoney.get(0).getD() + "d" + "  " + operation);
			System.out.println(listMoney.get(1).getP() + "p " + listMoney.get(1).getS() + "s " + listMoney.get(1).getD() + "d");
		} else if(operation.equalsIgnoreCase(multiplication) || operation.equalsIgnoreCase(division)){
			System.out.println("Inserisci un fattore");
			factor = getMoneyInput(buffReader);
			otherInput.setFactor(factor);
			System.out.println("Hai inserito: ");
			System.out.println(listMoney.get(0).getP() + "p " + listMoney.get(0).getS() + "s " + listMoney.get(0).getD() + "d" + "  " + operation + " " + factor);
		}	
	}

	//also used for multiply or divide factor input
	public static Integer getMoneyInput(BufferedReader buffReader) {
		String money = MainOldFashionPound.getInput(buffReader);
		Integer moneyInt;
		if (checkInput(money)) {
			return Integer.parseInt(money);
		} else {
			System.out.println("inserisci un nuovo valore: ");
			moneyInt = getMoneyInput(buffReader);
		}
		return moneyInt;
	}
	
	public static String getInput(BufferedReader buffReader) {
		String s = "";
		try {
			s = buffReader.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return s;
	}
	
	//to insert operation
	public static String getOperationInput(BufferedReader buffReader) {
		String operation = getInput(buffReader);
		
		if(checkOperationSymbol(operation)) {
			return operation;
		} else {
			System.out.println("Operazione non valida");
			System.out.println("Inserisci una operazione:");
			operation = getOperationInput(buffReader);
		}
		
		return operation;
	}

	public static Boolean checkInput(String money) {
		if(money.charAt(0) == '-') {
			System.out.println("Per favore inserisci solo numeri positivi senza segno");
			return false;
		}
		try {
			Integer.parseInt(money);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("Numero non valido");
			return false;
		}
	}
	
	public static Boolean checkOperationSymbol(String operation) {
		if( !(operation.equalsIgnoreCase(sum) || operation.equalsIgnoreCase(minus) || operation.equalsIgnoreCase(multiplication) 
				|| operation.equalsIgnoreCase(division)) ) {
			return false;
		}
		return true;
	}

}
