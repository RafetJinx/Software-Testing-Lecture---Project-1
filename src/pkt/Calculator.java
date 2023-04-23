/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Kütüphanem olan Calculator sınıfıdır.
* 
* Sınıf oluşturulduğu zaman kendi ihtiyaç duyduğu objeleri oluşturuyor
* ve kendisine gönderilen java dosyası içerisinde bulunan:
* 	Tekli Operatör Sayısı
* 	İkili operatör sayısı
* 	Sayısal operatör sayısı
* 	İlişkisel operatör sayısı
* 	Mantıksal operatör sayısı
* 	Toplam operand sayısı
*	Toplam fonksiyon sayısı'nı hesaplıyor ve console'a çıktı olarak veriyor.
* </p>
*/

package pkt;

import java.io.File;
import java.io.IOException;

import pkt.business.abstracts.CalculateService;
import pkt.business.abstracts.regex.RegexManagerService;
import pkt.business.concretes.function.FunctionManager;
import pkt.business.concretes.operand.OperandManager;
import pkt.business.concretes.operators.ArithmeticOperatorsManager;
import pkt.business.concretes.operators.BinaryOperatorsManager;
import pkt.business.concretes.operators.LogicalOperatorsManager;
import pkt.business.concretes.operators.RelationalOperatorsManager;
import pkt.business.concretes.operators.SingleOperatorsManager;
import pkt.business.concretes.regex.RegexManager;
import pkt.dosya.abstracts.IDosya;
import pkt.dosya.concretes.Dosya;
import pkt.entities.abstracts.IEntities;
import pkt.entities.concretes.function.Function;
import pkt.entities.concretes.operand.Operand;
import pkt.entities.concretes.operators.ArithmeticOperators;
import pkt.entities.concretes.operators.BinaryOperators;
import pkt.entities.concretes.operators.LogicalOperators;
import pkt.entities.concretes.operators.RelationalOperators;
import pkt.entities.concretes.operators.SingleOperators;

public class Calculator {
	
	private String fileContent;
	
	private IDosya dosya;
	
	private RegexManagerService regexManager;

	private IEntities singleOperators;
	private IEntities binaryOperators;
	private IEntities arithmeticOperators;
	private IEntities relationalOperators;
	private IEntities logicalOperators;
	private IEntities _operand;
	private IEntities _function;
	
	private IEntities[] entities = {
			singleOperators,
			binaryOperators,
			arithmeticOperators,
			relationalOperators,
			logicalOperators,
			_operand,
			_function,
	};
	
	public void createEntityObjects() {
		getEntities()[0] = new SingleOperators();
		getEntities()[1] = new BinaryOperators();
		getEntities()[2] = new ArithmeticOperators();
		getEntities()[3] = new RelationalOperators();
		getEntities()[4] = new LogicalOperators();
		getEntities()[5] = new Operand();
		getEntities()[6] = new Function();
	}
	
	
	private CalculateService singleOperatorsManager;
	private CalculateService binaryOperatorsManager;
	private CalculateService arithmeticManager;
	private CalculateService relationalOperatorsManager;
	private CalculateService logicalOperatorsManager;
	private CalculateService operandManager;
	private CalculateService functionManager;
	
	private CalculateService[] managers = {
			singleOperatorsManager,
			binaryOperatorsManager,
			arithmeticManager,
			relationalOperatorsManager,
			logicalOperatorsManager,
			operandManager,
			functionManager,
	};
	
	public void createManagerObjects() {
		getManagers()[6] = new SingleOperatorsManager(regexManager);
		getManagers()[3] = new BinaryOperatorsManager(regexManager);
		getManagers()[2] = new ArithmeticOperatorsManager(regexManager);
		getManagers()[5] = new RelationalOperatorsManager(regexManager);
		getManagers()[4] = new LogicalOperatorsManager(regexManager);
		getManagers()[1] = new OperandManager(regexManager);
		getManagers()[0] = new FunctionManager(regexManager);
	}
	
	private int[] counts = {0, 0, 0, 0, 0, 0, 0};
	
	
	public Calculator(String filePath) throws IOException {
		dosya = new Dosya(filePath);
		creatingCalculator();
	}
	
	public Calculator(File file) throws IOException {
		dosya = new Dosya(file);
		creatingCalculator();
	}
	
	public Calculator(IDosya dosya, RegexManagerService regexManagerService) {
        this.dosya = dosya;
        this.regexManager = regexManagerService;
        creatingCalculator();
    }
	
	private void creatingCalculator() {
		regexManager = new RegexManager();
		
		// dosya icerigi alindi
		fileContent = dosya.getFileContent();
		
		// yorumlar silindi
		fileContent = regexManager.removeComments(fileContent);
		
		regexManager.setFileContent(fileContent);
		
		// entity'ler olusturuldu
		createEntityObjects();
		
		// manager'lar olusturuldu
		createManagerObjects();
		
		doCalculate();
		
		printResults();
	}

	public void doCalculate() {
		for(int i = 0; i < getEntities().length; i++) {
			getCounts()[i] = getManagers()[i].calculate(getEntities()[i].getRegex());
		}
	}
	
	public void printResults() {
		System.out.println("Tekli operator sayisi:     " + getCounts()[0]);
		System.out.println("Ikili operator sayisi:     " + getCounts()[1]);
		System.out.println("Sayisal operator sayisi:   " + getCounts()[2]);
		System.out.println("İliskisel operator sayisi: " + getCounts()[3]);
		System.out.println("Mantiksal operator sayisi: " + getCounts()[4]);
		System.out.println("Toplam operand sayisi:     " + getCounts()[5]);
		System.out.println("Toplam fonksiyon sayisi:   " + getCounts()[6]);
	}
	
	public String getFileContent() {
		return fileContent;
	}

	public IEntities[] getEntities() {
		return entities;
	}

	public void setEntities(IEntities[] entities) {
		this.entities = entities;
	}

	public CalculateService[] getManagers() {
		return managers;
	}

	public void setManagers(CalculateService[] managers) {
		this.managers = managers;
	}

	public int[] getCounts() {
		return counts;
	}

	public void setCounts(int[] counts) {
		this.counts = counts;
	}
	
}
