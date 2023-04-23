/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* SingleOperatorsManager sınıfımın test sınıfıdır
* </p>
*/

package pkt.business.operators.unit;

import org.junit.jupiter.api.DisplayName;

import pkt.business.AbstractManagerTest;
import pkt.business.abstracts.operators.SingleOperatorsService;
import pkt.business.concretes.operators.SingleOperatorsManager;

@DisplayName("Single Operators Test")
class SingleOperatorsManagerTest extends AbstractManagerTest<SingleOperatorsService> {

	@Override
	public SingleOperatorsService getServiceInstance() {
		return new SingleOperatorsManager(regexService);
	}

	@Override
	public int calculate(String expression) {
		return service.calculate(expression);
	}
}
