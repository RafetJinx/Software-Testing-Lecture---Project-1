/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Arayüzü olan RegexManagerService'i implemente eden ve
* bütün regex işlemlerini gerçekleştirecek olan
* RegexManager sınıfım.
* </p>
*/

package pkt.business.concretes.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pkt.business.abstracts.regex.RegexManagerService;

public class RegexManager implements RegexManagerService{

	private String fileContent;

	private Pattern pattern;
	private Matcher matcher;
	
	@Override
	public int calculateCount(String expression) {
		if(expression.isEmpty()) {
			return fileContent.length();
		}
		
		
		int count = 0;
		
		pattern = Pattern.compile(expression);
		matcher = pattern.matcher(fileContent);
		
		
		while(matcher.find()) {
			count++;
		}

		return count;
	}

	@Override
	public String removeComments(String input) {
		input = input.replaceAll("(?s)/\\*\\*.*?\\*/|/\\*.*?\\*/|//[^\\n]*", "");
	    return input;
	}

	@Override
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	@Override
	public String getFileContent() {
		return fileContent;
	}


}
