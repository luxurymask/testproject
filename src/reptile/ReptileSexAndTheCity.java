package reptile;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReptileSexAndTheCity {
	public static void main(String[] args){
		Document document = null;
		try {
			document = Jsoup.connect("http://cn163.net/archives/2200/").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element entry = document.getElementById("entry");
		Elements links = entry.getElementsByTag("a");
		for(Element link : links){
			String linkHref = link.attr("href");
			String linkText = link.text();
			String pattern = "^ed2k.*";
			if(Pattern.matches(pattern, linkHref)){
				System.out.println(linkHref);
			}
		}
	}
}
