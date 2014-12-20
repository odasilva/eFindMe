package eFindMe.ESGI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearcher {
	
	
	private final static String google = "http://www.google.com/search?q=";
	private final static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.68 Safari/534.24";
	private final static String charset = "UTF-8";
	
	
	public List<String> search(String keyWords)
	{
		try {
			Document doc = Jsoup.connect(google + URLEncoder.encode(keyWords, charset) + "&num=5").userAgent(userAgent).get();
			Elements links = doc.select("[href]");
			//Elements links = doc.select("li[class=g]").select("span[class=st]");
			for(Element link : links)
			{
			    System.out.println(link.text());   
			}
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
