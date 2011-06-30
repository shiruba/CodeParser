package net.shiruba.codeparser.delegate.impl;

import java.net.URL;

import net.shiruba.codeparser.delegate.IParserDelegate;
import net.shiruba.codeparser.exception.NotSupportedException;
import net.shiruba.codeparser.parser.EParserActionType;
import net.shiruba.codeparser.parser.EParserType;
import net.shiruba.codeparser.parser.IParser;
import net.shiruba.codeparser.parser.impl.PhpParser;

/**
 * TODO: Complete comments!
 * @author sascha
 *
 */
public class ParsingDelegate implements IParserDelegate {
	
	/**
	 * 
	 */
	private EParserActionType action = null;
	
	/**
	 * 
	 */
	private EParserType type = null;
	
	/**
	 * 
	 */
	private URL sourceUrl = null;
	
	/**
	 * 
	 */
	private URL targetUrl = null;
	
	public ParsingDelegate(EParserActionType action, EParserType type, URL sourceUrl, URL targetUrl) {
		this.action = action;
		this.type = type;
		this.sourceUrl = sourceUrl;
		this.targetUrl = targetUrl;
	}
	
	public void delegate() throws NotSupportedException {
		switch(type) {
			case PHP:
				IParser parser = new PhpParser();
				parser.parse();
				break;
			default:
				throw new NotSupportedException();
		}
	}

	public EParserActionType getAction() {
		return action;
	}

	public void setAction(EParserActionType action) {
		this.action = action;
	}

	public EParserType getType() {
		return type;
	}

	public void setType(EParserType type) {
		this.type = type;
	}

	public URL getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(URL sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public URL getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(URL targetUrl) {
		this.targetUrl = targetUrl;
	}
}
