package net.shiruba.codeparser.parser.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.shiruba.codeparser.helper.ReportWriterHelper;
import net.shiruba.codeparser.helper.SourceUrlHelper;
import net.shiruba.codeparser.parser.EParserType;
import net.shiruba.codeparser.parser.IParser;
import net.shiruba.codeparser.parser.IRegularExpressionPattern;
import net.shiruba.codeparser.parser.result.IParserResult;
import net.shiruba.codeparser.parser.result.impl.ParserResult;

/**
 * TODO: Complete comments!
 * @author sascha
 *
 */
public class PhpParser implements IParser {
	
	/**
	 * 
	 */
	private File subPackage = null;
	
	public PhpParser(File subPackage) {
		this.subPackage = subPackage;
	}
	
	@Override
	public IParserResult parse(String sourceFile) {
		IParserResult result = new ParserResult(sourceFile, null);
		
		try {
			String data = readFile(sourceFile);
			Pattern startOfFile = Pattern.compile(IRegularExpressionPattern.REGEX_PATTERN_NEW_FILE);
			Matcher matcher = startOfFile.matcher(data);
			
			
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		IParserResult result = null;
		String[] sourceFiles = SourceUrlHelper.getActualSourceFiles(subPackage, EParserType.PHP);
		
		if (sourceFiles != null) {
			for (String sourceFile : sourceFiles) {
				result = parse(sourceFile);
				ReportWriterHelper.writeReport(result.getKey(), result.getResult());
			}
		}
	}
	
	private String readFile(String sourceFile) throws IOException {
		File file = new File(sourceFile);
		byte[] buffer = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(buffer);
		return new String(buffer);
	}
}
