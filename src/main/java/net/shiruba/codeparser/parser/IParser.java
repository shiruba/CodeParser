package net.shiruba.codeparser.parser;

import net.shiruba.codeparser.parser.result.IParserResult;

public interface IParser {
	public void parse();
	public IParserResult getParsingResult();
}
