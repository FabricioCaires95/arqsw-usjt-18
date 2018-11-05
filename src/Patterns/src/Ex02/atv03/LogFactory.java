package Ex02.atv03;


public class LogFactory {
	
	public Log getLog(String log) {
		if (log.equals("arquivo")) {
			return new ArquivoLog();
		} else if (log.equals("console")) {
			return new ConsoleLog();
		}
		return null;
	}

}
