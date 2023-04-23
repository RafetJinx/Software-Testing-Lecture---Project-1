/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Varlıklarımdan biri olan Function'un tanımlandığı sınıftır.
* </p>
*/

package pkt.entities.concretes.function;

import pkt.entities.abstracts.function.IFunction;

public class Function implements IFunction{
	private int count;
	private static final String FUNCTION_REGEX = "(?s)(?<modifiers>private|public|protected)?\\s*(?<static>static)?\\s*(?<final>final)?\\s*(?<type>[a-zA-Z]+\\w*[\\w\\<\\>\\[\\]]*)\\s+(?<name>[a-zA-Z]+\\w*)\\s*\\((?<parameters>[^(),]*?)\\)\\s*(throws\\s+[\\w\\.,\\s]+)?\\{(?<body>.*?)\\}(?=\\s*(public|private|protected|static|final)?\\s*[a-zA-Z]+\\w*[\\w\\<\\>\\[\\]]*\\s+[a-zA-Z]+\\w*\\s*\\(|$)";
	
	public Function() {
		super();
		this.count = 0;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void setCounts(int count) {
		this.count = count;
	}

	@Override
	public String getRegex() {
		return FUNCTION_REGEX;
	}
}
