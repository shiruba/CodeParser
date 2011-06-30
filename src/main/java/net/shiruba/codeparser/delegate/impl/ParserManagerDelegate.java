/**
 * 
 */
package net.shiruba.codeparser.delegate.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.shiruba.codeparser.delegate.IParserManagerDelegate;
import net.shiruba.codeparser.parser.IParser;

/**
 * TODO: Complete comments!
 *
 * CodeParser
 * @author Sascha Froehlich <sascha.froehlich@workdesk.eu>
 *
 */
public class ParserManagerDelegate implements IParserManagerDelegate {
	
	/**
	 * 
	 */
	private ExecutorService pool = null;
	
	/**
	 * 
	 */
	public ParserManagerDelegate() {
		pool = Executors.newFixedThreadPool(10);
	}
	
	/* (non-Javadoc)
	 * @see net.shiruba.codeparser.delegate.IParserManagerDelegate#addParser(net.shiruba.codeparser.parser.IParser)
	 */
	@Override
	public void addParser(IParser parser) {
		pool.execute(parser);
	}

	/* (non-Javadoc)
	 * @see net.shiruba.codeparser.delegate.IParserManagerDelegate#stop()
	 */
	@Override
	public void stop() {
		if (pool != null)
			pool.shutdown();
		
		while(pool.isTerminated() == false) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
