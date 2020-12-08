package net.mcheads.internal.utils;

import java.io.IOException;
import java.util.function.BiConsumer;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Utilities {

	public synchronized static String readURL(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				String result = EntityUtils.toString(entity);
				return result;
			}

		} finally {
			httpClient.close();
		}

		return null;
	}

	public synchronized static void doGet(String url, BiConsumer<HttpEntity, CloseableHttpClient> consumer) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			consumer.accept(entity, httpClient);
		}
		
	}

}
