package api;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	public static String DATA_PATH = "./input/";

	public static List<String> getLines(String filePath) {
		List<String> result = new ArrayList<String>();
		java.io.FileReader fr = null;
		try {
			fr = new java.io.FileReader(new File(DATA_PATH + filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(fr);
		    String line;
		    while ((line = br.readLine()) != null) {
		       result.add(line);
		    }
		    br.close();
		} catch (Exception e) {e.printStackTrace();}
		while (result.size() > 0 && "".equals(result.get(result.size() - 1))) {
			result.remove(result.size() - 1);
		}
		return result;
	}
}
