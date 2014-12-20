package eFindMe.ESGI;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Application {
	
	public static void main(String[] args) {
		
		GoogleSearcher searcher = new GoogleSearcher();
		searcher.search("PS4");

		//WebCrawler crawler = new WebCrawler();
		//Elements elmts = crawler.getLinks("https://www.google.fr/#q=jerome+cambray","");
	
		/*
		for(Element e : elmts)
		{
			System.out.println(e.text());
			System.out.println("------------------");
		}
		*/
		
	}

}



