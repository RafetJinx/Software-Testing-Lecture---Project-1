/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Business'ta yer alan Manager sınıflarımın Regex ile entegre bir şekilde 
* çalıştığının kontrol edildiği test sınıfıdır.
* </p>
*/

package pkt.business;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pkt.business.abstracts.CalculateService;
import pkt.business.abstracts.regex.RegexManagerService;

@DisplayName("Manager - RegexManager Inregration Tests")
public abstract class ManagerRegexIntegrationTests<T extends CalculateService> {
	protected RegexManagerService regexService;
	protected T service;
	
	@BeforeEach
    void setUp() {
        regexService = initRegexService();
        service = initFunctionService();
    }

    protected abstract RegexManagerService initRegexService();
    protected abstract T initFunctionService();
    
    @Test
    @DisplayName("Entegration Test between Manager and RegexManager")
    void testIntegrationBetweenManagerAndRegexManager() {
        String fileContent = "public static int faktoriyel(int n) {\r\n" +
                "    if (n == 0) {\r\n" +
                "        return 1;\r\n" +
                "    } else {\r\n" +
                "        return n * faktoriyel(n - 1);\r\n" +
                "    }\r\n" +
                "}";
        regexService.setFileContent(fileContent);
        int result = service.calculate("return");
        assertEquals(2, result);
    }
}
