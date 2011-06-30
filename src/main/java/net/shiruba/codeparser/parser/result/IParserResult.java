package net.shiruba.codeparser.parser.result;

import net.shiruba.codeparser.parser.EParserResultType;

public interface IParserResult {
	public void setResult(EParserResultType resultType);
	public EParserResultType getResult();
	public void setKey(String key);
	public String getKey();
}
