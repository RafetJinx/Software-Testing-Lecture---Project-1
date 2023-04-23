/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* OperandManager sınıfımın entegrasyon testi yapıldığı sınıftır
* </p>
*/

package pkt.business.operand;

import pkt.business.ManagerRegexIntegrationTests;
import pkt.business.abstracts.CalculateService;
import pkt.business.abstracts.regex.RegexManagerService;
import pkt.business.concretes.operand.OperandManager;
import pkt.business.concretes.regex.RegexManager;

class OperandManagerIntegrationTest extends ManagerRegexIntegrationTests<CalculateService>{

	@Override
	protected RegexManagerService initRegexService() {
		return new RegexManager();
	}

	@Override
	protected CalculateService initFunctionService() {
		return new OperandManager(regexService);
	}

}
