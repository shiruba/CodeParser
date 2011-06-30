/**
 * 
 */
package net.shiruba.codeparser.helper;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import net.shiruba.codeparser.parser.EParserType;
import net.shiruba.codeparser.parser.filter.PhpFilenameFilter;

/**
 * TODO: Complete comments!
 *
 * CodeParser
 * @author Sascha Froehlich <sascha.froehlich@workdesk.eu>
 *
 */
public class SourceUrlHelper {
	public static File getPackageFolder(URL target) throws URISyntaxException {
		return new File(target.toURI());
	}
	
	public static ArrayList<File> getSubPackageFolders(URL target, int depth) throws URISyntaxException {
		ArrayList<File> subPackageList = null;
		if (depth == 1) {
			File parent = new File(target.getFile());
			subPackageList = new ArrayList<File>();
			
			if (parent.exists() && parent.listFiles() != null) {
				for (File file : parent.listFiles())
					if (file.isDirectory())
						subPackageList.add(file);
			}
		}
		return subPackageList;
	}
	
	public static String[] getActualSourceFiles(File file, EParserType type) {
		String[] fileNames = null;
		switch(type) {
			case PHP:
				fileNames = file.list(new PhpFilenameFilter());
				break;
			default:
				break;
		}
		return fileNames;
	}
}
