package net.shiruba.codeparser.parser;

import net.shiruba.codeparser.parser.result.IParserResult;

public interface IParser extends Runnable {
	public IParserResult parse(String sourceFile);
}
