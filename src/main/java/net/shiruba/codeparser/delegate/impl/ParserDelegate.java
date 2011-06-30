package net.shiruba.codeparser.delegate.impl;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import net.shiruba.codeparser.delegate.IParserDelegate;
import net.shiruba.codeparser.delegate.IParserManagerDelegate;
import net.shiruba.codeparser.exception.NotSupportedException;
import net.shiruba.codeparser.helper.SourceUrlHelper;
import net.shiruba.codeparser.parser.EParserActionType;
import net.shiruba.codeparser.parser.EParserType;
import net.shiruba.codeparser.parser.IParser;
import net.shiruba.codeparser.parser.impl.PhpParser;

/**
 * TODO: Complete comments!
 * @author sascha
 *
 */
public class ParserDelegate implements IParserDelegate {
	
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
	private IParserManagerDelegate parserManager = null;
	
	/**
	 * 
	 */
	private URL targetUrl = null;
	
	/**
	 * 
	 */
	private ArrayList<File> subPackages = null;
	
	/**
	 * 
	 * @param action
	 * @param type
	 * @param sourceUrl
	 * @param targetUrl
	 */
	public ParserDelegate(EParserActionType action, EParserType type, URL sourceUrl, URL targetUrl) {
		this.action = action;
		this.type = type;
		this.sourceUrl = sourceUrl;
		this.targetUrl = targetUrl;
		this.parserManager = new ParserManagerDelegate();
		organiseFolders();
	}
	
	public void delegate() throws NotSupportedException {
		switch(type) {
			case PHP:
				for (File subPackage : subPackages) {
					IParser parser = new PhpParser(subPackage);
					parserManager.addParser(parser);
				}
				break;
			default:
				throw new NotSupportedException();
		}
		parserManager.stop();
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
	
	private void organiseFolders() {
		try {
			subPackages = SourceUrlHelper.getSubPackageFolders(sourceUrl, 1);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
