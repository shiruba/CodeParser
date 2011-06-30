/**
 * 
 */
package net.shiruba.codeparser.delegate;

import net.shiruba.codeparser.parser.IParser;

/**
 * TODO: Complete comments!
 *
 * CodeParser
 * @author Sascha Froehlich <sascha.froehlich@workdesk.eu>
 *
 */
public interface IParserManagerDelegate {
	public void addParser(IParser parser);
	public void stop();
}
