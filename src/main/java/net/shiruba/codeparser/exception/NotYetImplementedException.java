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
public class NotYetImplementedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3321962878488990886L;
	
	private final static String exceptionMessage = "Not yet implemented!";
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return exceptionMessage;
	}
}
