/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* LogicalOperatorsManager sınıfımın test sınıfıdır
* </p>
*/

package pkt.business.operators.unit;

import org.junit.jupiter.api.DisplayName;

import pkt.business.AbstractManagerTest;
import pkt.business.abstracts.operators.LogicalOperatorsService;
import pkt.business.concretes.operators.LogicalOperatorsManager;

@DisplayName("Logical Operators Test")
class LogicalOperatorsManagerTest extends AbstractManagerTest<LogicalOperatorsService>{

	@Override
	public LogicalOperatorsService getServiceInstance() {
		return new LogicalOperatorsManager(regexService);
	}

	@Override
	public int calculate(String expression) {
		return service.calculate(expression);
	}

}
