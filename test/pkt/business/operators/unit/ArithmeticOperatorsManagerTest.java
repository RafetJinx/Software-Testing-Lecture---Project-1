/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* ArithmeticOperatorsManager sınıfımın test sınıfıdır
* </p>
*/

package pkt.business.operators.unit;

import org.junit.jupiter.api.DisplayName;

import pkt.business.AbstractManagerTest;
import pkt.business.abstracts.operators.ArithmeticOperatorsService;
import pkt.business.concretes.operators.ArithmeticOperatorsManager;

@DisplayName("Arithmetic Operators Test")
class ArithmeticOperatorsManagerTest extends AbstractManagerTest<ArithmeticOperatorsService>{

	@Override
	public ArithmeticOperatorsService getServiceInstance() {
		return new ArithmeticOperatorsManager(regexService);
	}

	@Override
	public int calculate(String expression) {
		return service.calculate(expression);
	}

}
