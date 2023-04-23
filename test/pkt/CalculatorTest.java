/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Library'im olan Calculator sınıfının test sınıfıdır
* </p>
*/

package pkt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.github.javafaker.Faker;

import pkt.business.abstracts.regex.RegexManagerService;
import pkt.business.concretes.regex.RegexManager;
import pkt.dosya.abstracts.IDosya;
import pkt.dosya.concretes.Dosya;

@DisplayName("Calculator Test")
class CalculatorTest {
	
	private Calculator calculator;
	
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	private Faker faker;
	
	@BeforeEach
    void setUp() {
        try {
            calculator = new Calculator("myJavaFile.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setOut(new PrintStream(outputStreamCaptor));
    }
	
	
	/* Unit Tests - Count : 9 & Mock Objects - Count : 1 */
	
	@Test
    @DisplayName("Test creatingCalculator method")
    public void testCreatingCalculator() throws IOException {
        String fileContent = "int a = 5; // bu bir yorum\n" +
                "int b = 7;\n" +
                "int c = a + b;";
    	
    	Dosya dosya = mock(Dosya.class);
        when(dosya.getFileContent()).thenReturn(fileContent);

        RegexManagerService regexManagerService = mock(RegexManagerService.class);
        when(regexManagerService.removeComments(fileContent)).thenReturn("int a = 5; \n"
        		+ "int b = 7;\n"
        		+ "int c = a + b;");
        
        
        // Calculator sınıfı mock nesneleri ile oluşturuluyor

        Calculator mockCalculator = new Calculator(dosya, regexManagerService);

        
        // entity ve manager nesnelerinin oluşturulduğu kontrol ediliyor
        assertNotNull(mockCalculator.getEntities()[0], "SingleOperators entity should not be null");
        assertNotNull(mockCalculator.getEntities()[1], "BinaryOperators entity should not be null");
        assertNotNull(mockCalculator.getEntities()[2], "ArithmeticOperators entity should not be null");
        assertNotNull(mockCalculator.getEntities()[3], "RelationalOperators entity should not be null");
        assertNotNull(mockCalculator.getEntities()[4], "LogicalOperators entity should not be null");
        assertNotNull(mockCalculator.getEntities()[5], "Operand entity should not be null");
        assertNotNull(mockCalculator.getEntities()[6], "Function entity should not be null");
        
        assertNotNull(mockCalculator.getManagers()[0], "FunctionManager should not be null");
        assertNotNull(mockCalculator.getManagers()[1], "OperandManager should not be null");
        assertNotNull(mockCalculator.getManagers()[2], "ArithmeticOperatorsManager should not be null");
        assertNotNull(mockCalculator.getManagers()[3], "RelationalOperatorsManager should not be null");
        assertNotNull(mockCalculator.getManagers()[4], "LogicalOperatorsManager should not be null");
        assertNotNull(mockCalculator.getManagers()[5], "BinaryOperatorsManager should not be null");
        assertNotNull(mockCalculator.getManagers()[6], "SingleOperatorsManager should not be null");

        mockCalculator.doCalculate();
        
        // count dizisi elemanlarının doğru hesaplandığı doğrulanıyor
        int[] expectedCounts = {0, 4, 4, 0, 0, 37, 0};
        assertArrayEquals(expectedCounts, mockCalculator.getCounts(), "Counts should match the expected values");
    }
	
	@Test
	@DisplayName("Test for Invalid File Path")
	void testIOExceptionForInvalidFilePath() {
	    assertThrows(IOException.class, () -> new Calculator("nonexistentFile.java"));
	}

	@Test
	@DisplayName("Test Empty File")
	void testEmptyFile() throws IOException{
		File emptyFile = createTempFileWithContent("");
		Calculator newCalculator = new Calculator(emptyFile);
		
		int[] expectedCounts = {0, 0, 0, 0, 0, 0, 0 };
		
		assertArrayEquals(expectedCounts, newCalculator.getCounts());
	}

	@Test
	@DisplayName("Test Invalid Code File")
	void testInvalidCode() throws IOException {
		String invalidCode = "this is not a valid Java code";
	    File invalidFile = createTempFileWithContent(invalidCode);
	    
	    Calculator newCalculator = new Calculator(invalidFile);
	    
	    int[] expectedCounts = {0, 0, 0, 0, 0, 31, 0};
	    assertArrayEquals(expectedCounts, newCalculator.getCounts());
	}
	
	@Test
	@DisplayName("Test code with loops and conditionals")
	void testCodeWithLoopsAndConditionals() throws IOException {
	    String codeWithLoopsAndConditionals = "int sum = 0;\n" +
	                                          "for (int i = 0; i < 10; i++) {\n" +
	                                          "    if (i % 2 == 0) {\n" +
	                                          "        sum += i;\n" +
	                                          "    }\n" +
	                                          "}\n";
	    File testFile = createTempFileWithContent(codeWithLoopsAndConditionals);
	    Calculator calculator = new Calculator(testFile);
	    calculator.printResults();
	    int[] expectedCounts = {1, 6, 7, 2, 0, 98, 0};
	    assertArrayEquals(expectedCounts, calculator.getCounts());
	}

	@Test
	@DisplayName("Test Create Entity Objects")
    void testCreateEntityObjects() {
        calculator.createEntityObjects();
        assertNotNull(calculator.getEntities()[0], "SingleOperators entity should not be null");
        assertNotNull(calculator.getEntities()[1], "BinaryOperators entity should not be null");
        assertNotNull(calculator.getEntities()[2], "ArithmeticOperators entity should not be null");
        assertNotNull(calculator.getEntities()[3], "RelationalOperators entity should not be null");
        assertNotNull(calculator.getEntities()[4], "LogicalOperators entity should not be null");
        assertNotNull(calculator.getEntities()[5], "Operand entity should not be null");
        assertNotNull(calculator.getEntities()[6], "Function entity should not be null");
    }

    @Test
	@DisplayName("Test Create Manager Objects")
    void testCreateManagerObjects() {
        calculator.createManagerObjects();
        assertNotNull(calculator.getManagers()[0], "FunctionManager should not be null");
        assertNotNull(calculator.getManagers()[1], "OperandManager should not be null");
        assertNotNull(calculator.getManagers()[2], "ArithmeticOperatorsManager should not be null");
        assertNotNull(calculator.getManagers()[3], "RelationalOperatorsManager should not be null");
        assertNotNull(calculator.getManagers()[4], "LogicalOperatorsManager should not be null");
        assertNotNull(calculator.getManagers()[5], "BinaryOperatorsManager should not be null");
        assertNotNull(calculator.getManagers()[6], "SingleOperatorsManager should not be null");
    }
    
    @Test
    @DisplayName("Test Do Calculate")
    void testDoCalculate() {
        calculator.doCalculate();
        int[] expectedCounts = {1, 8, 7, 1, 1, 452, 1};
        assertArrayEquals(expectedCounts, calculator.getCounts(), "Counts should match the expected values");
    }
    
    @ParameterizedTest
    @CsvSource({"1, 8, 7, 1, 1, 452, 1"})
    void testDoCalculateParameterized(int expSingleOps, int expBinaryOps, int expArithOps, int expRelOps, int expLogOps, int expOperands, int expFunctions) {
    	int[] expectedCount = {expSingleOps, expBinaryOps, expArithOps, expRelOps, expLogOps, expOperands, expFunctions};
    	assertArrayEquals(expectedCount, calculator.getCounts());
    }
    
    
    @Test
    @DisplayName("Test Print Results")
    void testPrintResults() {
        calculator.printResults();
        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.contains("Tekli operator sayisi:     1"));
        assertTrue(output.contains("Ikili operator sayisi:     8"));
        assertTrue(output.contains("Sayisal operator sayisi:   7"));
        assertTrue(output.contains("İliskisel operator sayisi: 1"));
        assertTrue(output.contains("Mantiksal operator sayisi: 1"));
        assertTrue(output.contains("Toplam operand sayisi:     452"));
        assertTrue(output.contains("Toplam fonksiyon sayisi:   1"));
    }
    
    @Test
    @DisplayName("Test doCalculate To All Entity Types")
    void testDoCalculateAllEntityTypes() throws IOException {
        String testFileContent = "int a = 10;\n"+
                "int b = 5;\n" +
                "int c = a + b;\n" +
                "if (a > b) {\n"+
                "    c++;\n" +
                "}\n"  ;

        File tempFile = createTempFileWithContent(testFileContent);
        Calculator calculator = new Calculator(tempFile);
        int[] expectedCounts = {1, 5, 5, 1, 0, 68, 0};
        assertArrayEquals(expectedCounts, calculator.getCounts());
    }

    
    /* Repeated Tests - Count : 1 */
    
    @RepeatedTest(100)
    @DisplayName("Test DoCalculate Repeatedly (100 Times)")
    void testDoCalculateRepeatedly() {
        calculator.doCalculate();

        int[] expectedCounts = {1, 8, 7, 1, 1, 452, 1}; // Adjust these values based on the test file content

        int[] actualCounts = calculator.getCounts();
        for (int i = 0; i < expectedCounts.length; i++) {
            assertEquals(expectedCounts[i], actualCounts[i]);
        }
    }
    
    
    /* Parameterized Tests - Count : 2 */
    
    @ParameterizedTest
    @CsvSource({"myJavaFile.java, 1, 8, 7, 1, 1, 452, 1"})
    void testPrintResults(String testFilePath, int expSingleOps, int expBinaryOps, int expArithOps, int expRelOps, int expLogOps, int expOperands, int expFunctions) throws IOException {
        Calculator calculator = new Calculator(testFilePath);
        calculator.doCalculate();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        calculator.printResults();
        System.setOut(originalOut);

        String[] expectedOutput = {
                "Tekli operator sayisi:     " + expSingleOps,
                "Ikili operator sayisi:     " + expBinaryOps,
                "Sayisal operator sayisi:   " + expArithOps,
                "İliskisel operator sayisi: " + expRelOps,
                "Mantiksal operator sayisi: " + expLogOps,
                "Toplam operand sayisi:     " + expOperands,
                "Toplam fonksiyon sayisi:   " + expFunctions
        };
        
        String[] actualOutput = outputStream.toString().split(System.lineSeparator());

        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], actualOutput[i], "Incorrect output for index " + i);
        }
    }
    
    @ParameterizedTest
    @CsvSource({"myJavaFile.java, 1, 8, 7, 1, 1, 452, 1"})
    void testDoCalculate(String testFilePath, int expSingleOps, int expBinaryOps, int expArithOps, int expRelOps, int expLogOps, int expOperands, int expFunctions) throws IOException {
        Calculator calculator = new Calculator(testFilePath);
        calculator.doCalculate();

        int[] expectedCounts = {expSingleOps, expBinaryOps, expArithOps, expRelOps, expLogOps, expOperands, expFunctions};

        int[] actualCounts = calculator.getCounts();
        for (int i = 0; i < expectedCounts.length; i++) {
            assertEquals(expectedCounts[i], actualCounts[i]);
        }
    }
 
    
    /* Faker Tests - Count : 4 */
    @Test
    @DisplayName("testCalculator Test With Faker")
    public void testCalculatorWithFaker() throws IOException {
    	faker = new Faker();
        // Rastgele verilerle dolu geçici bir dosya oluşturun
        File tempFile = File.createTempFile("temp-file", ".txt");
        FileWriter fileWriter = new FileWriter(tempFile);
        for (int i = 0; i < 10; i++) {
            fileWriter.write(faker.lorem().sentence() + System.lineSeparator());
        }
        fileWriter.close();

        // Calculator sınıfını geçici dosya ile test ediyoruz
        assertDoesNotThrow(() -> new Calculator(tempFile));
    }
    
    @Test
    @DisplayName("testCalculator Test With File Content Containing Random Code Created By Faker")
    public void testCalculatorWithFileContentContainingRandomCode() throws IOException {
    	faker = new Faker();
    	
        // Rastgele kod satırlarıyla dolu geçici bir dosya oluşturun
        File tempFile = File.createTempFile("temp-file", ".txt");
        FileWriter fileWriter = new FileWriter(tempFile);
        for (int i = 0; i < 10; i++) {
            fileWriter.write(faker.code().isbn10() + System.lineSeparator());
        }
        fileWriter.close();

        // Calculator sınıfını geçici dosyayla test edin
        IDosya dosya = new Dosya(tempFile);
        RegexManagerService regexManagerService = new RegexManager();
        assertDoesNotThrow(() -> new Calculator(dosya, regexManagerService));
    }
    
    @Test
    @DisplayName("testCalculator Test With File Content Containing Random Expressions Created By Faker")
    public void testCalculatorWithFileContentContainingRandomExpressions() throws IOException {
    	faker = new Faker();
    	
        // Rastgele matematiksel ifadelerle dolu geçici bir dosya oluşturun
        File tempFile = File.createTempFile("temp-file", ".txt");
        FileWriter fileWriter = new FileWriter(tempFile);
        for (int i = 0; i < 10; i++) {
            fileWriter.write(faker.expression("a + b * c / d") + System.lineSeparator());
        }
        fileWriter.close();

        // Calculator sınıfını geçici dosyayla test edin
        IDosya dosya = new Dosya(tempFile);
        RegexManagerService regexManagerService = new RegexManager();
        assertDoesNotThrow(() -> new Calculator(dosya, regexManagerService));
    }
    
    @Test
    @DisplayName("testCalculator Test With File Content Containing Random Variables Created By Faker")
    public void testCalculatorWithFileContentContainingRandomVariables() throws IOException {
    	faker = new Faker();
    	
        // Rastgele değişken adlarıyla dolu geçici bir dosya oluşturun
        File tempFile = File.createTempFile("temp-file", ".txt");
        FileWriter fileWriter = new FileWriter(tempFile);
        for (int i = 0; i < 10; i++) {
            fileWriter.write(faker.expression("int #{name.firstName} = #{number.numberBetween(1, 100)};") + System.lineSeparator());
        }
        fileWriter.close();

        // Calculator sınıfını geçici dosyayla test edin
        IDosya dosya = new Dosya(tempFile);
        RegexManagerService regexManagerService = new RegexManager();
        assertDoesNotThrow(() -> new Calculator(dosya, regexManagerService));
    }
    
    
    /* Normal Functions */
    
    File createTempFileWithContent(String content) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
        File tempFile = File.createTempFile("tempFile", ".java");
        tempFile.deleteOnExit();

        try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
        
        return tempFile;
    }

}
