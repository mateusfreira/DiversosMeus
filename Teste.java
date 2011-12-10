package com.teknisa.setforms.mobile.communication.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.teknisa.setforms.mobile.communication.exception.SetFormsConnectionException;

public class HttpRequest {
	static HttpClient client = new DefaultHttpClient();

	public String get(String url) throws Exception {
		try {
			BufferedReader in = null;
			StringBuffer sb = new StringBuffer("");
			try {

				HttpGet request = new HttpGet();
				request.setURI(new URI(url));
				HttpResponse response = client.execute(request);
				in = new BufferedReader(new InputStreamReader(response
						.getEntity().getContent()));
				String line = "";
				String NL = System.getProperty("line.separator");
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}
				in.close();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return sb.toString();
		} catch (Exception e) {
			throw new SetFormsConnectionException(e);
		}
	}

	public String post(String url, Hashtable<String, String> params)
			throws Exception {
		try {
			BufferedReader in = null;
			StringBuffer sb = new StringBuffer("");
			try {
				HttpPost request = new HttpPost();
				request.setURI(new URI(url));
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				for (String nameValuePair : params.keySet()) {
					nameValuePairs.add(new BasicNameValuePair(nameValuePair,
							params.get(nameValuePair)));
				}
				request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response = client.execute(request);
				in = new BufferedReader(new InputStreamReader(response
						.getEntity().getContent()));
				String line = "";
				String NL = System.getProperty("line.separator");
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}
				in.close();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return sb.toString();
		} catch (Exception e) {
			throw e;
		}
	}

}
