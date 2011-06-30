package net.shiruba.codeparser.parser.result.impl;

import java.util.HashMap;
import java.util.Map;

import net.shiruba.codeparser.parser.EParserResultType;
import net.shiruba.codeparser.parser.result.IParserResult;

/**
 * TODO: Complete comments!
 * 
 * @author Sascha Froehlich <sascha.froehlich@workdesk.eu>
 * 
 */
public class ParserResult implements IParserResult {

	private HashMap<String, EParserResultType> parsingResults = new HashMap<String, EParserResultType>();
	
	@Override
	public Map<?, ?> getParsingResult() {
		return parsingResults;
	}
	
	public void putResult(String key, EParserResultType value) {
		parsingResults.put(key, value);
	}

}
