package mod08.reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CitiesWebReader {
	
	public String readCities() throws IOException {
			URL url = new URL("http://en.wikipedia.org/wiki/List_of_cities_in_Georgia%2C_USA");
			BufferedReader in = new BufferedReader(
						new InputStreamReader(url.openStream()));
			String result = "";
			String line;
			while ((line = in.readLine()) != null) {
//				if (line == null) {
//                    continue;
//                }
				String parsedWord = parseLine( line );
				if (parsedWord != null) {
					result += parsedWord + System.getProperty("line.separator");
				}
			}
			in.close();
			return result;
	}

	private String parseLine(String line) {
	       if ( line != null ) {
	            Pattern pattern = Pattern.compile( "<li><a href=.*title=\".*,.*\">(.*)</a></li>" );
	            Matcher matcher = pattern.matcher( line );
	            boolean matchesPattern = matcher.find();
	            if (matchesPattern) {
	                return matcher.group(matcher.groupCount());
	            } 
	        }
	        return null; 
	 }
}
