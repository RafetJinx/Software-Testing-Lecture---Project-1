/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Business'ın altında yer alan manager sınıfların kullanacak olduğu
* testCalculate metodunun tek bir alanda yazılıp diğer sınıflarda da
* kullanmasına imkan tanıyan AbstractmanagerTEst sınıfım
* </p>
*/

package pkt.business;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pkt.business.abstracts.regex.RegexManagerService;
import pkt.business.concretes.regex.RegexManager;

public abstract class AbstractManagerTest<T> {
	protected RegexManagerService regexService;
	protected T service;
	
	
	@BeforeEach
	void setUp() {
		regexService = new RegexManager();
		service = getServiceInstance();
	}
	
	public abstract T getServiceInstance();
	
	@Test
	@DisplayName("Calculate Test With Valid Expression")
    void testCalculateMethodWithValidExpression() {
		regexService.setFileContent("public static int faktoriyel(int n) {\r\n"
                + "    if (n == 0) {\r\n"
                + "        return 1;\r\n"
                + "    } else {\r\n"
                + "        return n * faktoriyel(n - 1);\r\n"
                + "    }\r\n"
                + "}");

        int result = calculate("return");
        assertEquals(2, result);

    }
	
	@Test
	@DisplayName("Calculate Test With Invalid Expression")
	void testCalculateMethodWithInvalidExpression() {
		regexService.setFileContent("public static int faktoriyel(int n) {\r\n"
                + "    if (n == 0) {\r\n"
                + "        return 1;\r\n"
                + "    } else {\r\n"
                + "        return n * faktoriyel(n - 1);\r\n"
                + "    }\r\n"
                + "}");

        int result = calculate("returnnnnn");
        assertEquals(0, result);
	}
	
	@Test
	@DisplayName("Calculate Test With Empty Expression")
	void testCalculateMethodWithEmptyExpression() {
		String fileContent = "test content";
		
		regexService.setFileContent(fileContent);

        int result = calculate("");
        
        assertEquals(fileContent.length(), result);
	}
	
	@Test
	@DisplayName("Calculate Test With Null Expression")
	void testCalculateMethodWithNullExpression() {
		assertThrows(NullPointerException.class, 
				() -> {calculate(null);});
	}
	
	
    public abstract int calculate(String expression);
	
}
