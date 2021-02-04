package giacomo.euris.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import giacomo.euris.oldfashionpound.*;

public class OldFashionPoundTest {

	private OperationsOldPoundImpl operationsOldPoundImpl = new OperationsOldPoundImpl();
	private List<OldMoney> listMoney;
	private OldMoney oldPrice1;
	private OldMoney oldPrice2;
	private OldMoney oldPrice3;
	private Integer by;
	
    @BeforeEach                                         
    public void setUp() throws Exception {
        listMoney = new ArrayList<OldMoney>();
        oldPrice1 = new OldMoney(5, 17, 8);
        oldPrice2 = new OldMoney(3, 4, 10);
        oldPrice3 = new OldMoney(18, 16, 1);
        listMoney.add(oldPrice1);
        listMoney.add(oldPrice2);        
    }
	
    @Test                                               
    @DisplayName("Addition with old pounds")   
    public void testSum() {
    	OldMoney resultMoney = operationsOldPoundImpl.sum(listMoney);
        Assertions.assertEquals(9, resultMoney.getP(), "Pounds should be the same");
        Assertions.assertEquals(2, resultMoney.getS(), "Shillings should be the same");
        Assertions.assertEquals(6, resultMoney.getD(), "Pennies should be the same");
    }
    
    @Test                                               
    @DisplayName("Difference with old pounds")   
    public void testDifference() {
    	OldMoney resultMoney = operationsOldPoundImpl.difference(listMoney);
        Assertions.assertEquals(2, resultMoney.getP(), "Pounds should be the same");
        Assertions.assertEquals(12, resultMoney.getS(), "Shillings should be the same");
        Assertions.assertEquals(10, resultMoney.getD(), "Pennies should be the same");
    }

    @Test                                               
    @DisplayName("Multiplication with old pounds")   
    public void testMultiplication() {
        //factor to multiply or divide by
        by = 2;
    	OldMoney resultMoney = operationsOldPoundImpl.multiplication(oldPrice1, by);
        Assertions.assertEquals(11, resultMoney.getP(), "Pounds should be the same");
        Assertions.assertEquals(15, resultMoney.getS(), "Shillings should be the same");
        Assertions.assertEquals(4, resultMoney.getD(), "Pennies should be the same");
    }
    
    @Test                                               
    @DisplayName("Division with old pounds")   
    public void testDivision() {
        //factor to multiply or divide by
        by = 3;
    	List<OldMoney> resultMoney = operationsOldPoundImpl.division(oldPrice1, by);
        Assertions.assertEquals(1, resultMoney.get(0).getP(), "Pounds should be the same");
        Assertions.assertEquals(5, resultMoney.get(0).getS(), "Shillings should be the same");
        Assertions.assertEquals(2, resultMoney.get(0).getD(), "Pennies should be the same");
        
        Assertions.assertEquals(2, resultMoney.get(1).getP(), "Remainder pounds should be the same");
        Assertions.assertEquals(2, resultMoney.get(1).getS(), "Remainder shillings should be the same");
        Assertions.assertEquals(2, resultMoney.get(1).getD(), "Remainder pennies should be the same");        
    }
    
    @Test                                               
    @DisplayName("Division with old pounds")   
    public void testDivision2() {
        //factor to multiply or divide by
        by = 15;
    	List<OldMoney> resultMoney = operationsOldPoundImpl.division(oldPrice3, by);
        Assertions.assertEquals(1, resultMoney.get(0).getP(), "Pounds should be the same");
        Assertions.assertEquals(1, resultMoney.get(0).getS(), "Shillings should be the same");
        Assertions.assertEquals(0, resultMoney.get(0).getD(), "Pennies should be the same");
        
        Assertions.assertEquals(3, resultMoney.get(1).getP(), "Remainder pounds should be the same");
        Assertions.assertEquals(1, resultMoney.get(1).getS(), "Remainder shillings should be the same");
        Assertions.assertEquals(1, resultMoney.get(1).getD(), "Remainder pennies should be the same");        
    }
}
