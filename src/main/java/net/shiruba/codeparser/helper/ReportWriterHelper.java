/**
 * 
 */
package net.shiruba.codeparser.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.shiruba.codeparser.parser.EParserResultType;

/**
 * TODO: Complete comments!
 * 
 * CodeParser
 * 
 * @author Sascha Froehlich <sascha.froehlich@workdesk.eu>
 * 
 */
public class ReportWriterHelper {

	private final static String REPORT_FILE_PATH = System.getProperty("java.io.tmpdir");

	public static synchronized void writeReport(String key, EParserResultType resultType) {
		BufferedWriter writer = null;

		try {
			FileWriter file = new FileWriter(REPORT_FILE_PATH + File.separator 
					+ "CodeParser-" + Thread.currentThread().getName() + ".txt", true);
			writer = new BufferedWriter(file);
			writer.append(key + ": " + resultType.toString());
			writer.newLine();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
}