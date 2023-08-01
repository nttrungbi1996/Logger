package jp.co.marimogt.takken.batch.wirte;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class WirteError {
	
	private static Logger loggerError = Logger.getLogger(WirteError.class.getName());
	private static FileHandler fileHandler;

	public WirteError() {
	}

	static {
		try {
			fileHandler = new FileHandler("./log/error.log", true);
			loggerError.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			loggerError.setLevel(Level.INFO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logErrorMailData(String content) {
		String logMessage = String.format("メール送信中にエラーが発生しました。エラー: %s", content);

		loggerError.info(logMessage);
	}
}
