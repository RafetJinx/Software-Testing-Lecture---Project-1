/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* RelationalOperatorsManager sınıfımın test sınıfıdır
* </p>
*/

package pkt.business.operators.unit;

import org.junit.jupiter.api.DisplayName;

import pkt.business.AbstractManagerTest;
import pkt.business.abstracts.operators.RelationalOperatorsService;
import pkt.business.concretes.operators.RelationalOperatorsManager;

@DisplayName("Relational Operators Test")
class RelationalOperatorsManagerTest extends AbstractManagerTest<RelationalOperatorsService> {

	@Override
	public RelationalOperatorsService getServiceInstance() {
		return new RelationalOperatorsManager(regexService);
	}

	@Override
	public int calculate(String expression) {
		return service.calculate(expression);
	}

}
