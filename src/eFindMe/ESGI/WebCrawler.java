package eFindMe.ESGI;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {
	
	private Document processPage(String pageURL)
	{
		try {
			return Jsoup.connect(pageURL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Elements getLinks(String pageURL, String filter)
	{
		Document page = processPage(pageURL);
		
		if(page == null)
			return new Elements();
		
		Elements links = page.select("a[href]");
		Elements interestingLinks = new Elements();
		for(Element link : links)
		{
			if(link.text().contains(filter))
				interestingLinks.add(link);
		}
		return interestingLinks;
		
	}

}
