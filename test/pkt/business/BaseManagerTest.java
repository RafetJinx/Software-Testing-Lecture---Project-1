/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Business'ın altında yer alan manager sınıflarımın 
* RegexService ile düzgün çalıştığının mock ile test
* edildiği sınıftır
* </p>
*/

package pkt.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pkt.business.abstracts.regex.RegexService;
import pkt.business.concretes.BaseManager;

@DisplayName("BaseManager Test")
class BaseManagerTest {

	@Test
	@DisplayName("Testing getRegexService")
	void testGetRegexService() {
		RegexService regexService = mock(RegexService.class);
		BaseManager baseManager = new BaseManager(regexService);
		
		assertEquals(regexService, baseManager.getRegexService());
	}

}