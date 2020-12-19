package net.mcheads.internal.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.Consumer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Utilities {

	public synchronized static void doGet(String url, Consumer<InputStream> consumer, String contentType) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setRequestProperty("Content-Type", contentType);
			connection.setRequestMethod("GET");
			consumer.accept(connection.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void doJsonGet(String url, Consumer<JsonObject> consumer) {
		doGet(url,
				inStream -> consumer.accept(JsonParser.parseReader(new InputStreamReader(inStream)).getAsJsonObject()),
				"text/json");
	}

}
