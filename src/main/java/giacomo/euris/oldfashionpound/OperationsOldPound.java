package giacomo.euris.oldfashionpound;

import java.util.List;

public interface OperationsOldPound {

	OldMoney sum(List<OldMoney> listMoney);
	OldMoney difference(List<OldMoney> listMoney);
	
	OldMoney multiplication(OldMoney price, Integer n);
	List<OldMoney> division(OldMoney price, Integer n);
}
