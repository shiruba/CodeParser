package net.shiruba.codeparser.parser.result.impl;

import net.shiruba.codeparser.parser.EParserResultType;
import net.shiruba.codeparser.parser.result.IParserResult;

/**
 * TODO: Complete comments!
 * 
 * @author Sascha Froehlich <sascha.froehlich@workdesk.eu>
 * 
 */
public class ParserResult implements IParserResult {

	private String key = null;
	private EParserResultType resultType = null;

	public ParserResult(String key, EParserResultType resultType) {
		this.key = key;
		this.resultType = resultType;
	}
	
	/* (non-Javadoc)
	 * @see net.shiruba.codeparser.parser.result.IParserResult#setKey(java.lang.String)
	 */
	@Override
	public void setKey(String key) {
		this.key = key;
	}
	
	/* (non-Javadoc)
	 * @see net.shiruba.codeparser.parser.result.IParserResult#getKey()
	 */
	@Override
	public String getKey() {
		return key;
	}
	
	/* (non-Javadoc)
	 * @see net.shiruba.codeparser.parser.result.IParserResult#setResult(net.shiruba.codeparser.parser.EParserResultType)
	 */
	@Override
	public void setResult(EParserResultType resultType) {
		this.resultType = resultType;
	}
	
	/* (non-Javadoc)
	 * @see net.shiruba.codeparser.parser.result.IParserResult#getResult()
	 */
	@Override
	public EParserResultType getResult() {
		return resultType;
	}
}
