/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* LogicalOperatorsManager sınıfımın entegrasyon testi yapıldığı sınıftır
* </p>
*/

package pkt.business.operators.integration;

import org.junit.jupiter.api.DisplayName;

import pkt.business.ManagerRegexIntegrationTests;
import pkt.business.abstracts.CalculateService;
import pkt.business.abstracts.regex.RegexManagerService;
import pkt.business.concretes.operators.LogicalOperatorsManager;
import pkt.business.concretes.regex.RegexManager;

@DisplayName("Logical Operators Manager - RegexManager Inregration Tests")
class LogicalOperatorsManagerIntegrationTest extends ManagerRegexIntegrationTests<CalculateService>{

	@Override
	protected RegexManagerService initRegexService() {
		return new RegexManager();
	}

	@Override
	protected CalculateService initFunctionService() {
		return new LogicalOperatorsManager(regexService);
	}

}
