/**
 * 
 */
package net.shiruba.codeparser.parser.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * CodeParser
 * @author Sascha Froehlich <sascha.froehlich@workdesk.eu>
 *
 */
public class PhpFilenameFilter implements FilenameFilter {

	private final static String PHP_SUFFIX = ".php";
	
	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		if (name.endsWith(PHP_SUFFIX))
			return true;
		else
			return false;
	}

}
