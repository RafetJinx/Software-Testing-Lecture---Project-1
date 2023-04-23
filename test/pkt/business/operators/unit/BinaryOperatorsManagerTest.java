/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* BinaryOperatorsManager sınıfımın test sınıfıdır
* </p>
*/

package pkt.business.operators.unit;

import org.junit.jupiter.api.DisplayName;

import pkt.business.AbstractManagerTest;
import pkt.business.abstracts.operators.BinaryOperatorsService;
import pkt.business.concretes.operators.BinaryOperatorsManager;

@DisplayName("Binary Operators Test")
class BinaryOperatorsManagerTest extends AbstractManagerTest<BinaryOperatorsService> {

	@Override
	public BinaryOperatorsService getServiceInstance() {
		return new BinaryOperatorsManager(regexService);
	}

	@Override
	public int calculate(String expression) {
		return service.calculate(expression);
	}

}
