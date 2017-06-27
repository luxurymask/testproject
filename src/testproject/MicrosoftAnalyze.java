package testproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class MicrosoftAnalyze {
	public static void main(String[] args){
		File file = new File("/Users/liuxl/Desktop/sitemaps");
		Set<String> set = new HashSet<String>();
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if(tempString.matches(".*zh-cn.*")){
					System.out.println(tempString);
					set.add(tempString);
				}
			}
			reader.close();
		} catch (Exception e) {

		}
		
		int i = 0;
		for(String url : set){
			String name = url.substring(37);
			i++;
			HttpURLConnection con = null;  
	        BufferedReader br = null;  
	        FileOutputStream os = null;  
	        try {  
	            URL realUrl = null;  
	            realUrl = new URL(url);  
	            con = (HttpURLConnection) realUrl.openConnection();  
	            
	            con.setRequestProperty("Content-Type", "text/xml");  
	            con.connect();  
	            InputStream is = con.getInputStream();
	            File outputFile = new File("/Users/liuxl/Desktop/zhcnxmls/" + name); 
				if (!outputFile.exists()) {
					outputFile.createNewFile();
				}
	            os = new FileOutputStream(outputFile);
	            byte buf[] = new byte[1024];  
	            int count = 0;  
	            while ((count = is.read(buf)) != -1) {  
	                os.write(buf, 0, count);  
	            }  
	            os.flush();  
	        } catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }
		}
	}
}
