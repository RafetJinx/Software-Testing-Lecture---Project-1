/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* OperandManagerTest sınıfımın test sınıfıdır
* </p>
*/

package pkt.business.operand;

import org.junit.jupiter.api.DisplayName;

import pkt.business.AbstractManagerTest;
import pkt.business.abstracts.operand.OperandService;
import pkt.business.concretes.operand.OperandManager;

@DisplayName("Operand Manager Test")
class OperandManagerTest extends AbstractManagerTest<OperandService>{

	@Override
	public OperandService getServiceInstance() {
		return new OperandManager(regexService);
	}

	@Override
	public int calculate(String expression) {
		return service.calculate(expression);
	}

}
