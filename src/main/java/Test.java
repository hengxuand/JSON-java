import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;

public class Test {
	public static void main(String args[]) throws IOException {
//		JSONObject jo = new JSONObject("{ \"abc\" : \"def\" }");
//		System.out.println(jo.toString());
		JSONPointer jp = new JSONPointer("/letter/address");
		FileReader r = new FileReader("sample2.xml");
		JSONObject newJo = XML.toJSONObject(r, jp);
		System.out.println(newJo.toString());
	}
}
