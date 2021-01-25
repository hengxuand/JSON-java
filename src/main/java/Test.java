import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;

public class Test {
	public static void main(String args[]) throws IOException {
<<<<<<< HEAD

		JSONPointer jp = new JSONPointer("/letter/signature");

		FileReader r = new FileReader("sample2.xml");
		JSONObject newJo = XML.toJSONObject(r, jp);
=======
		JSONPointer jp = new JSONPointer("#/letter/logo");
//		System.out.println(System.getProperty("user.dir"));
		FileReader r = new FileReader("/Users/shaun/UCIGD/21Winter/SWE262P/JSON-java/src/main/java/sample2.xml");
		JSONObject replacement = new JSONObject();
		replacement.put("class", "11111111111111111");

		Map m = new LinkedHashMap(4);
		m.put("abc", "2222222222222222222");
		m.put("qwe", "777777777777777");
		replacement.put("map", m);
		JSONObject newJo = XML.toJSONObject(r, jp, replacement);
>>>>>>> 0a19b09d8a2ffffbc70f57897f28413b90cc24fb
		System.out.println(newJo.toString());
		r.close();
	}
}
