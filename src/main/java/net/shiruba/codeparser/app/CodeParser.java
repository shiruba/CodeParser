package net.shiruba.codeparser.app;

import java.net.MalformedURLException;
import java.net.URL;

import net.shiruba.codeparser.delegate.IParserDelegate;
import net.shiruba.codeparser.delegate.impl.ParserDelegate;
import net.shiruba.codeparser.exception.NotYetImplementedException;
import net.shiruba.codeparser.parser.EParserActionType;
import net.shiruba.codeparser.parser.EParserType;

/**
 * TODO: Complete comments!
 * @author sascha
 *
 */
public class CodeParser {

	private final static String ACTION_RUN = "run";
	private final static String ACTION_TEST = "test";
	private final static String TYPE_PHP = "php";
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) 
			throws Exception {
		checkApplicationArguments(args);
		createParsingDelegate(args);
	}

	private static void checkApplicationArguments(String[] args) {
		if (args.length < 2) {
			System.out.println("This application requires three arguments (java CodeParser.class action type source target):");
			System.out.println("\taction: [run|test]");
			System.out.println("\ttype: currently, only php is supported");
			System.out.println("\tsource: the source folder");
			System.out.println("\ttarget: the target folder");
			System.out.println("i.e.: java CodeParser.class run php /home/foo/bar/src /home/foo/bar/target");
		}
	}

	private static void createParsingDelegate(String[] args)
			throws Exception {
		EParserActionType action = checkAction(args[0]);
		EParserType type = checkType(args[1]);
		URL sourceUrl = checkURL(args[2]);
		URL targetUrl = checkURL(args[3]);
		
		IParserDelegate parsingDelegate = new ParserDelegate(action, type, sourceUrl, targetUrl);
		parsingDelegate.delegate();
	}

	private static EParserActionType checkAction(String possibleAction)
			throws RuntimeException, NotYetImplementedException {
		if (possibleAction.equalsIgnoreCase(ACTION_RUN)) {
			return EParserActionType.RUN;
		} 
		else if (possibleAction.equalsIgnoreCase(ACTION_TEST)) {
			// return EParserActionType.TEST;
			throw new NotYetImplementedException();
		}
		else {
			throw new RuntimeException("This application requires the argument \"action\" to be one of [run|test], but it was: " + possibleAction);
		}
	}
	
	private static EParserType checkType(String possibleType) 
		throws RuntimeException {
		if (possibleType.equalsIgnoreCase(TYPE_PHP)) {
			return EParserType.PHP;
		}
		else {
			throw new RuntimeException("This application requires the argument \"type\" to be php, but it was: " + possibleType);
		}
	}

	private static URL checkURL(String possibleUrl)
			throws MalformedURLException {
		return new URL(possibleUrl);
	}

}
