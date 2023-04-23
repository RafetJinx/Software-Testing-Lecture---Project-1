/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* FunctionManager sınıfımın entegrasyon testi yapıldığı sınıftır
* </p>
*/

package pkt.business.function;

import org.junit.jupiter.api.DisplayName;

import pkt.business.ManagerRegexIntegrationTests;
import pkt.business.abstracts.CalculateService;
import pkt.business.abstracts.regex.RegexManagerService;
import pkt.business.concretes.function.FunctionManager;
import pkt.business.concretes.regex.RegexManager;

@DisplayName("Function Manager - RegexManager Inregration Tests")
class FunctionManagerIntegrationTest extends ManagerRegexIntegrationTests<CalculateService>{

	@Override
	protected RegexManagerService initRegexService() {
		return new RegexManager();
	}

	@Override
	protected CalculateService initFunctionService() {
		return new FunctionManager(regexService);
	}

}
