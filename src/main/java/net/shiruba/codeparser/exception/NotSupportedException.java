/**
 * 
 */
package net.shiruba.codeparser.exception;

/**
 * TODO: Complete comments!
 *
 * CodeParser
 * @author Sascha Froehlich <sascha.froehlich@workdesk.eu>
 *
 */
public class NotSupportedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1964059849103433803L;
	
	private final static String exceptionMessage = "Not supported!";
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return exceptionMessage;
	}
}
