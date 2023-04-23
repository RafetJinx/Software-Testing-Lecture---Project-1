/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* RegexManager sınıfımın test sınıfıdır.
* Test edilmesi gereken birçok hesaplama uygulanmaya çalışılmıştır.
* </p>
*/

package pkt.business.regex;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.github.javafaker.Faker;

import pkt.business.abstracts.regex.RegexManagerService;
import pkt.business.concretes.regex.RegexManager;

@DisplayName("RegexManager Test")
@TestMethodOrder(MethodOrderer.DisplayName.class)
class RegexManagerTest {
	
	private RegexManagerService regexManager;
	
	private Faker faker;
	
	
	@BeforeEach
	void setUp() {
		regexManager = new RegexManager();
	}
	
	/* Unit Tests - Count : 8 */
	
	@Test
	@DisplayName("CalculateCount Test")
	void testCalculateCount() {
		String fileContent = "This is a sample file content."
				+ " ifeda ";
		regexManager.setFileContent(fileContent);
		
		String expression = "(?s).*";
		int expectedCount = 2;
		
		int actualCount = regexManager.calculateCount(expression);
		
		assertEquals(expectedCount, actualCount);
	}
	
	@Test
	@DisplayName("CalculateCount With Empty Expression Test")
	void testCalculateCountWithEmptyExpression() {
		String fileConent = "Hello";
		regexManager.setFileContent(fileConent);
		
		assertEquals(fileConent.length(), regexManager.calculateCount(""));
	}
	
	@Test
	@DisplayName("CalculateCount With Null Expression Test")
	void testCalculateCountWithNullExpression() {
		assertThrows(NullPointerException.class, 
				() -> regexManager.calculateCount(null));
	}
	
	@Test
	@DisplayName("RemoveCommets With Single Line Comment")
	void testRemoveCommentsWithSingleLineComment() {
		String input = "This is a sample file content.\n"
				+ "// this is a single line comment\n"
				+ "This is another line.";
		
		String expectedOutput = "This is a sample file content.\n"
				+ "\n"
				+ "This is another line.";
		
		assertEquals(expectedOutput, regexManager.removeComments(input));
	}
	
	@Test
	@DisplayName("RemoveCommets With Multi Line Comment")
	void testRemoveCommentsWithMultiLineComment() {
		String input = "This is a sample file content.\n"
				+ "/* this is a multiple\n"
				+ "line comment */\n"
				+ "This is another line.";
		
		String expectedOutput = "This is a sample file content.\n"
				+ "\n"
				+ "This is another line.";
		
		assertEquals(expectedOutput, regexManager.removeComments(input));
	}

	@Test
	@DisplayName("RemoveCommets With Javadoc Comment")
	void testRemoveCommentsWithJavadocComment() {
		String input = "This is a sample file content.\n"
				+ "/** this is a javadoc\n"
				+ "comment */\n"
				+ "This is another line.";
		
		String expectedOutput = "This is a sample file content.\n"
				+ "\n"
				+ "This is another line.";
		
		assertEquals(expectedOutput, regexManager.removeComments(input));
	}
	
	@Test
	@DisplayName("RemoveCommets With No Comment")
	void testRemoveCommentsWithNoComment() {
		String input = "This is a sample file content.\n"
				+ "This is another line.";
		
		String expectedOutput = "This is a sample file content.\n"
				+ "This is another line.";
		
		assertEquals(expectedOutput, regexManager.removeComments(input));
	}

	@Test
	@DisplayName("SetFileContent Test")
	void testSetFileContent() {
	    String expectedFileContent = "Hello World";
	    regexManager.setFileContent(expectedFileContent);
	    
	    // Reflection kullanarak private field'a erisim saglaniyor
	    Field privateField;
	    try {
	        privateField = RegexManager.class.getDeclaredField("fileContent");
	        privateField.setAccessible(true);
	        String actualFileContent = (String) privateField.get(regexManager);
	        
	        assertEquals(expectedFileContent, actualFileContent);
	    } catch (NoSuchFieldException | IllegalAccessException e) {
	        e.printStackTrace();
	    }
	}
	
	
	/* Performance Tests - 4 && Parameterized Tests - 1 */
	
	@ParameterizedTest(name = "CalculateCount Performance Test with {0} expressions")
	@ValueSource(ints = {1, 10, 100, 1000, 10000})
	void testCalculateCountPerformanceWithExpressions(int numOfExpressions) {
	    String fileContent = "This is a sample file content.";
	    regexManager.setFileContent(fileContent);
	    
	    // Test verisi oluşturun
	    List<String> expressions = new ArrayList<>();
	    for (int i = 1; i <= numOfExpressions; i++) {
	        expressions.add(".*" + i + ".*");
	    }
	    
	    // hesaplama süresini baslatiyoruz
	    long startTime = System.currentTimeMillis();
	    
	    for (String expression : expressions) {
	        regexManager.calculateCount(expression);
	    }
	    
	    // hesaplama süresini bitiriyoruz 
	    long endTime = System.currentTimeMillis();
	    
	    // toplam hesaplama süresini buluyoruz
	    long totalTime = endTime - startTime;
	    
	    assertTrue(totalTime < 10000);
	}
	
	@Test
	@DisplayName("CalculateCount Performance Test with 10MB file")
	void testCalculateCountPerformanceWith10MBFile() {
	    // Test verisi oluşturun
	    byte[] bytes = new byte[10485760]; // 10MB boyutunda bir dizi oluşturuyoruz
	    new Random().nextBytes(bytes); // rastgele verilerle dolduruyoruz
	    String fileContent = new String(bytes);
	    regexManager.setFileContent(fileContent);
	    
	    // hesaplama süresini baslatiyoruz
	    long startTime = System.currentTimeMillis();
	    
	    String expression = "(<=|>=|<|>|==|!=)";
	    regexManager.calculateCount(expression);
	    
	    // hesaplama süresini bitiriyoruz 
	    long endTime = System.currentTimeMillis();
	    
	    // toplam hesaplama süresini buluyoruz
	    long totalTime = endTime - startTime;
	    
	    assertTrue(totalTime < 1000);
	}
	
	@Test
	@DisplayName("CalculateCount Performance Test with 100MB file")
	void testCalculateCountPerformanceWith100MBFile() {
	    byte[] bytes = new byte[104857600]; // 100MB boyutunda bir dizi oluşturuyoruz
	    new Random().nextBytes(bytes); // rastgele verilerle dolduruyoruz
	    String fileContent = new String(bytes);
	    regexManager.setFileContent(fileContent);
	    
	    // hesaplama süresini baslatiyoruz
	    long startTime = System.currentTimeMillis();
	    
	    String expression = "(<=|>=|<|>|==|!=)";
	    regexManager.calculateCount(expression);
	    
	    // hesaplama süresini bitiriyoruz 
	    long endTime = System.currentTimeMillis();
	    
	    // toplam hesaplama süresini buluyoruz
	    long totalTime = endTime - startTime;
	    
	    assertTrue(totalTime < 10000);
	}

	@Test
	@DisplayName("CalculateCount Performance Test with 500MB file")
	void testCalculateCountPerformanceWith500MBFile() {
	    byte[] bytes = new byte[536870912]; // 500MB boyutunda bir dizi oluşturuyoruz
	    new Random().nextBytes(bytes); // rastgele verilerle dolduruyoruz
	    String fileContent = new String(bytes);
	    regexManager.setFileContent(fileContent);
	    
	    // hesaplama süresini baslatiyoruz
	    long startTime = System.currentTimeMillis();
	    
	    String expression = "(<=|>=|<|>|==|!=)";
	    regexManager.calculateCount(expression);
	    
	    // hesaplama süresini bitiriyoruz 
	    long endTime = System.currentTimeMillis();
	    
	    // toplam hesaplama süresini buluyoruz
	    long totalTime = endTime - startTime;
	    
	    assertTrue(totalTime < 30000);
	}
	

	/* Integration Tests - Count : 1 */
	
	@Test
	@DisplayName("Integration Test for RegexManager")
	void testRegexManagerIntegration() {
	    // Dosya içeriği
	    String fileContent = "This is a sample file content.\n"
	            + "// this is a single line comment\n"
	            + "This is another line.\n"
	            + "/* this is a multi-line comment\n"
	            + "    that spans multiple lines */\n"
	            + "This is the last line.";

	    // RegexManager örneği oluşturulur
	    RegexManagerService regexManager = new RegexManager();
	    regexManager.setFileContent(fileContent);

	    // calculateCount metodu test edilir
	    String expression = "(?s).*";
	    int expectedCount = 2;
	    int actualCount = regexManager.calculateCount(expression);
	    assertEquals(expectedCount, actualCount);

	    // removeComments metodu test edilir
	    String expectedOutput = "This is a sample file content.\n"
	            + "\n"
	            + "This is another line.\n"
	            + "\n"
	            + "This is the last line.";
	    String actualOutput = regexManager.removeComments(fileContent);
	    assertEquals(expectedOutput, actualOutput);
	}
	
	
	
	/* Repeated Tests - Count : 2 */
	
	@RepeatedTest(value = 1000)
	@DisplayName("Calculate Count Test Repeatedly (1000 Times")
	void calculateCount() {
		regexManager.setFileContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		
		int count = regexManager.calculateCount("ipsum");
		
		assertEquals(1, count);
		
	}
	
	@RepeatedTest(value = 500, name = "{currentRepetition}/{totalRepetitions}")
	@DisplayName("RemoveComments Test method Repeatedly (500 Times)")
	void testRemoveComments() {
	    // given
	    regexManager = new RegexManager();
	    String input = "This is a sample text /* comment */ with some // comments";
	    
	    // when
	    String result = regexManager.removeComments(input);

	    // then
	    assertFalse(result.contains("/**"));
	    assertFalse(result.contains("/*"));
	    assertFalse(result.contains("*/"));
	    assertFalse(result.contains("//"));
	}

	/* Faker Tests - Count : 2*/
	@Test
	@DisplayName("testCalculateCount With Random Strings Created By Faker")
    public void testCalculateCountWithRandomStrings() {
		faker = new Faker();
		
        String randomText = faker.lorem().paragraph();
        regexManager.setFileContent(randomText);

        String randomWord = faker.lorem().word();
        int expectedCount = countOccurrences(randomText, randomWord);

        int actualCount = regexManager.calculateCount(randomWord);
        assertEquals(expectedCount, actualCount);
    }
	
	@Test
	@DisplayName("testRemoveComments With Random Comments Created By Faker")
    public void testRemoveCommentsWithRandomComments() {
		faker = new Faker();
		
        String singleLineComment = "// " + faker.lorem().sentence();
        String multiLineComment = "/* " + faker.lorem().paragraph() + " */";
        String javaDocComment = "/** " + faker.lorem().paragraph() + " */";
        String stringWithComments = singleLineComment + multiLineComment + javaDocComment;

        String result = regexManager.removeComments(stringWithComments);
        assertEquals("", result);
    }

    private int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
