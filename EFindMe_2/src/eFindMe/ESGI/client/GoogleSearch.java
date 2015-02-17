package eFindMe.ESGI.client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import eFindMe.ESGI.client.GoogleResults.Result;

public class GoogleSearch {
	
	private static final String GOOGLE = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	private static final String CHARSET = "UTF-8";
	
	
	public static List<String> search(String s)
	{
		 	URL url;
		 	List<String> links = new ArrayList<String>();
			try {
				url = new URL(GOOGLE + URLEncoder.encode(s, CHARSET));
				 Reader reader = new InputStreamReader(url.openStream(), CHARSET);
				    GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);
				    
				    if(results.getResponseData().getResults().size() > 10)
				    {
				    	for(int i = 0 ; i < 10; i++)
					    {
					    	 links.add(results.getResponseData().getResults().get(i).getUrl());
					    }
				    }
				    else
				    {
				    	 for(int i = 0 ; i < results.getResponseData().getResults().size(); i++)
						    {
						    	 links.add(results.getResponseData().getResults().get(i).getUrl());
						    }
				    }
				    
				   
				    
				    
				    return links;
			} catch (MalformedURLException | UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return links;
	}
	
	
	public static void searchReference(List<String> links,String url)
	{
		
		for (String s : links) {
			
			try {
				
				Document doc =  Jsoup.connect(s).get();
				Elements pageContent = doc.body().select("*");
				
				for (Element element : pageContent) {
					
					if(!element.hasText())
						continue;
					if(element.text().toLowerCase().contains(url.toLowerCase()))
					{
						//DO SOMETHING
						System.out.println();
					}
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


