package org.json.junit;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.*;
import org.junit.Test;

public class XMLTest262 {

	@Test
	public void task2Test() throws IOException {
		String originalXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<!-- saved from url=(0014)about:internet -->\n" + "\n" + "\n" + "<letter>\n" + "\n" + "\n"
				+ "  <title maxlength=\"10\"> Quote Letter </title>\n" + "\n" + "\n"
				+ "  <salutation limit=\"40\">Dear Daniel,</salutation>\n" + "\n" + "\n"
				+ "  <text>Thank you for sending us the information on <emphasis>SDL Trados Studio 2009</emphasis>.\n"
				+ "\n" + "\n"
				+ "    We like your products and think they certainly represent the most powerful translation\n"
				+ "solution on the market.\n" + "\n" + "\n"
				+ "    We especially like the <component translate=\"yes\">XML Parser rules</component>\n"
				+ "options in the <component translate=\"no\">XML</component> filter.\n" + "\n" + "\n"
				+ "    It has helped us to set up support for our XML files in a flash.\n" + "\n" + "\n"
				+ "    We have already downloaded the latest version from your Customer Center.</text>\n" + "\n" + "\n"
				+ "   <title maxlength=\"40\"> Quote Details </title>\n" + "\n" + "\n"
				+ "    <text> We would like to order 50 licenses.\n" + "\n" + "\n"
				+ "    Please send us a quote. Keep up the good work!</text>\n" + "\n" + "\n" + "  \n" + "\n" + "\n"
				+ "  <greetings minlength=\"10\">Yours sincerely,</greetings>\n" + "\n" + "\n"
				+ "  <signature> Paul Smith</signature>\n" + "\n"
				+ "  <address translate=\"yes\">Smith &amp; Company Ltd.</address>\n" + "\n" + "\n"
				+ "  <address translate=\"no\">Smithtown</address>\n" + "\n" + "\n"
				+ "  <weblink>http://www.smith-company-ltd.com</weblink>\n" + "\n" + "\n"
				+ "  <logo alt=\"Logo of Smith and Company Ltd.\" address=\"http://www.smith-company-ltd.com/logo.jpg\"/>\n"
				+ "    <signature>Nina Vuong</signature>\n" + "</letter>\n" + "<letter1>\n" + "</letter1>";

		String expectedJsonString = "{\"signature\":[\"Paul Smith\",\"Nina Vuong\"]}";

		StringReader s = new StringReader(originalXml);
		JSONPointer jp = new JSONPointer("/letter/signature");

		JSONObject expectedJson = new JSONObject(expectedJsonString);
		JSONObject actualJson = XML.toJSONObject(s, jp);
		System.out.println(actualJson);
		Util.compareActualVsExpectedJsonObjects(actualJson, expectedJson);
	}

	@Test
	public void task5Test() throws IOException {
		String originalXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<!-- saved from url=(0014)about:internet -->\n" + "\n" + "\n" + "<letter>\n" + "\n" + "\n"
				+ "  <title maxlength=\"10\"> Quote Letter </title>\n" + "\n" + "\n"
				+ "  <salutation limit=\"40\">Dear Daniel,</salutation>\n" + "\n" + "\n"
				+ "  <text>Thank you for sending us the information on <emphasis>SDL Trados Studio 2009</emphasis>.\n"
				+ "\n" + "\n"
				+ "    We like your products and think they certainly represent the most powerful translation\n"
				+ "solution on the market.\n" + "\n" + "\n"
				+ "    We especially like the <component translate=\"yes\">XML Parser rules</component>\n"
				+ "options in the <component translate=\"no\">XML</component> filter.\n" + "\n" + "\n"
				+ "    It has helped us to set up support for our XML files in a flash.\n" + "\n" + "\n"
				+ "    We have already downloaded the latest version from your Customer Center.</text>\n" + "\n" + "\n"
				+ "   <title maxlength=\"40\"> Quote Details </title>\n" + "\n" + "\n"
				+ "    <text> We would like to order 50 licenses.\n" + "\n" + "\n"
				+ "    Please send us a quote. Keep up the good work!</text>\n" + "\n" + "\n" + "  \n" + "\n" + "\n"
				+ "  <greetings minlength=\"10\">Yours sincerely,</greetings>\n" + "\n" + "\n"
				+ "  <signature> Paul Smith</signature>\n" + "\n"
				+ "  <address translate=\"yes\">Smith &amp; Company Ltd.</address>\n" + "\n" + "\n"
				+ "  <address translate=\"no\">Smithtown</address>\n" + "\n" + "\n"
				+ "  <weblink>http://www.smith-company-ltd.com</weblink>\n" + "\n" + "\n"
				+ "  <logo alt=\"Logo of Smith and Company Ltd.\" address=\"http://www.smith-company-ltd.com/logo.jpg\"/>\n"
				+ "    <signature>Nina Vuong</signature>\n" + "</letter>\n" + "<letter1>\n" + "</letter1>";

		String expectedJsonString = "{\n" + "  \"letter\": {\n" + "    \"address\": [\n" + "      {\n"
				+ "        \"translate\": \"yes\",\n" + "        \"content\": \"Smith & Company Ltd.\"\n" + "      },\n"
				+ "      {\n" + "        \"translate\": \"no\",\n" + "        \"content\": \"Smithtown\"\n"
				+ "      }\n" + "    ],\n" + "    \"signature\": [\n" + "      \"Paul Smith\",\n"
				+ "      \"Nina Vuong\"\n" + "    ],\n" + "    \"weblink\": \"http://www.smith-company-ltd.com\",\n"
				+ "    \"logo\": {\n" + "      \"class\": \"11111111111111111\",\n" + "      \"map\": {\n"
				+ "        \"TestKey2\": \"22222TestValue22222\",\n" + "        \"TestKey1\": \"11111TestValue11111\"\n"
				+ "      }\n" + "    },\n" + "    \"salutation\": {\n" + "      \"limit\": 40,\n"
				+ "      \"content\": \"Dear Daniel,\"\n" + "    },\n" + "    \"text\": [\n" + "      {\n"
				+ "        \"component\": [\n" + "          {\n" + "            \"translate\": \"yes\",\n"
				+ "            \"content\": \"XML Parser rules\"\n" + "          },\n" + "          {\n"
				+ "            \"translate\": \"no\",\n" + "            \"content\": \"XML\"\n" + "          }\n"
				+ "        ],\n" + "        \"emphasis\": \"SDL Trados Studio 2009\",\n" + "        \"content\": [\n"
				+ "          \"Thank you for sending us the information on\",\n"
				+ "          \".\\n\\n\\n    We like your products and think they certainly represent the most powerful translation\\nsolution on the market.\\n\\n\\n    We especially like the\",\n"
				+ "          \"options in the\",\n"
				+ "          \"filter.\\n\\n\\n    It has helped us to set up support for our XML files in a flash.\\n\\n\\n    We have already downloaded the latest version from your Customer Center.\"\n"
				+ "        ]\n" + "      },\n"
				+ "      \"We would like to order 50 licenses.\\n\\n\\n    Please send us a quote. Keep up the good work!\"\n"
				+ "    ],\n" + "    \"greetings\": {\n" + "      \"minlength\": 10,\n"
				+ "      \"content\": \"Yours sincerely,\"\n" + "    },\n" + "    \"title\": [\n" + "      {\n"
				+ "        \"maxlength\": 10,\n" + "        \"content\": \"Quote Letter\"\n" + "      },\n"
				+ "      {\n" + "        \"maxlength\": 40,\n" + "        \"content\": \"Quote Details\"\n"
				+ "      }\n" + "    ]\n" + "  },\n" + "  \"letter1\": \"\"\n" + "}";
		StringReader s = new StringReader(originalXml);
		JSONPointer jp = new JSONPointer("/letter/logo");

		JSONObject expectedJson = new JSONObject(expectedJsonString);
		JSONObject replacement = new JSONObject();
		replacement.put("class", "11111111111111111");
		Map m = new LinkedHashMap(4);
		m.put("TestKey1", "11111TestValue11111");
		m.put("TestKey2", "22222TestValue22222");
		replacement.put("map", m);
		JSONObject actualJson = XML.toJSONObject(s, jp, replacement);
		System.out.println(actualJson);
		Util.compareActualVsExpectedJsonObjects(actualJson, expectedJson);
	}

	@Test
	public void task4Test() throws IOException {
		String originalXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<!-- saved from url=(0014)about:internet -->\n" + "\n" + "\n" + "<letter>\n" + "\n" + "\n"
				+ "  <title maxlength=\"10\"> Quote Letter </title>\n" + "\n" + "\n"
				+ "  <salutation limit=\"40\">Dear Daniel,</salutation>\n" + "\n" + "\n"
				+ "  <text>Thank you for sending us the information on <emphasis>SDL Trados Studio 2009</emphasis>.\n"
				+ "\n" + "\n"
				+ "    We like your products and think they certainly represent the most powerful translation\n"
				+ "solution on the market.\n" + "\n" + "\n"
				+ "    We especially like the <component translate=\"yes\">XML Parser rules</component>\n"
				+ "options in the <component translate=\"no\">XML</component> filter.\n" + "\n" + "\n"
				+ "    It has helped us to set up support for our XML files in a flash.\n" + "\n" + "\n"
				+ "    We have already downloaded the latest version from your Customer Center.</text>\n" + "\n" + "\n"
				+ "   <title maxlength=\"40\"> Quote Details </title>\n" + "\n" + "\n"
				+ "    <text> We would like to order 50 licenses.\n" + "\n" + "\n"
				+ "    Please send us a quote. Keep up the good work!</text>\n" + "\n" + "\n" + "  \n" + "\n" + "\n"
				+ "  <greetings minlength=\"10\">Yours sincerely,</greetings>\n" + "\n" + "\n"
				+ "  <signature> Paul Smith</signature>\n" + "\n"
				+ "  <address translate=\"yes\">Smith &amp; Company Ltd.</address>\n" + "\n" + "\n"
				+ "  <address translate=\"no\">Smithtown</address>\n" + "\n" + "\n"
				+ "  <weblink>http://www.smith-company-ltd.com</weblink>\n" + "\n" + "\n"
				+ "  <logo alt=\"Logo of Smith and Company Ltd.\" address=\"http://www.smith-company-ltd.com/logo.jpg\"/>\n"
				+ "    <signature>Nina Vuong</signature>\n" + "</letter>\n" + "<letter1>\n" + "</letter1>";

        String expectedJsonString = "{\"262_letter\":{\"262_text\":[{\"262_content\":[\"Thank you for sending us the information on\",\".    We like your products and think they certainly represent the most powerful translationsolution on the market.    We especially like the\",\"options in the\",\"filter.    It has helped us to set up support for our XML files in a flash.    We have already downloaded the latest version from your Customer Center.\"],\"262_component\":{\"262_translate\":\"no\",\"262_content\":\"XML\"},\"262_emphasis\":\"SDL Trados Studio 2009\"},\"We would like to order 50 licenses.    Please send us a quote. Keep up the good work!\"],\"262_weblink\":\"http://www.smith-company-ltd.com\",\"262_salutation\":{\"262_content\":\"Dear Daniel,\",\"262_limit\":40},\"262_title\":{\"262_maxlength\":40,\"262_content\":\"Quote Details\"},\"262_greetings\":{\"262_minlength\":10,\"262_content\":\"Yours sincerely,\"},\"262_logo\":{\"262_alt\":\"Logo of Smith and Company Ltd.\",\"262_address\":\"http://www.smith-company-ltd.com/logo.jpg\"},\"262_address\":{\"262_translate\":\"no\",\"262_content\":\"Smithtown\"},\"262_signature\":[\"Paul Smith\",\"Nina Vuong\"]}}\n";
        StringReader s = new StringReader(originalXml);

        XML.func keyTransformer = (String str) -> {
            return "262_" + str;
       };
        JSONObject expectedJson = new JSONObject(expectedJsonString);

		long startTime = System.currentTimeMillis();
        JSONObject actualJson = XML.toJSONObject(s, keyTransformer);
		long finishTime = System.currentTimeMillis();
        System.out.println(expectedJson.toString());
        System.out.println(actualJson.toString());
		System.out.println("That took: " + (finishTime - startTime) + " ms");
		Util.compareActualVsExpectedJsonObjects(actualJson, expectedJson);
    }

	@Test
	public void milestone4Test() throws IOException {
		String originalXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<!-- saved from url=(0014)about:internet -->\n" + "\n" + "\n" + "<letter>\n" + "\n" + "\n"
				+ "  <title maxlength=\"10\"> Quote Letter </title>\n" + "\n" + "\n"
				+ "  <salutation limit=\"40\">Dear Daniel,</salutation>\n" + "\n" + "\n"
				+ "  <text>Thank you for sending us the information on <emphasis>SDL Trados Studio 2009</emphasis>.\n"
				+ "\n" + "\n"
				+ "    We like your products and think they certainly represent the most powerful translation\n"
				+ "solution on the market.\n" + "\n" + "\n"
				+ "    We especially like the <component translate=\"yes\">XML Parser rules</component>\n"
				+ "options in the <component translate=\"no\">XML</component> filter.\n" + "\n" + "\n"
				+ "    It has helped us to set up support for our XML files in a flash.\n" + "\n" + "\n"
				+ "    We have already downloaded the latest version from your Customer Center.</text>\n" + "\n" + "\n"
				+ "   <title maxlength=\"40\"> Quote Details </title>\n" + "\n" + "\n"
				+ "    <text> We would like to order 50 licenses.\n" + "\n" + "\n"
				+ "    Please send us a quote. Keep up the good work!</text>\n" + "\n" + "\n" + "  \n" + "\n" + "\n"
				+ "  <greetings minlength=\"10\">Yours sincerely,</greetings>\n" + "\n" + "\n"
				+ "  <signature> Paul Smith</signature>\n" + "\n"
				+ "  <address translate=\"yes\">Smith &amp; Company Ltd.</address>\n" + "\n" + "\n"
				+ "  <address translate=\"no\">Smithtown</address>\n" + "\n" + "\n"
				+ "  <weblink>http://www.smith-company-ltd.com</weblink>\n" + "\n" + "\n"
				+ "  <logo alt=\"Logo of Smith and Company Ltd.\" address=\"http://www.smith-company-ltd.com/logo.jpg\"/>\n"
				+ "    <262signature>Nina Vuong</262signature>\n" + "</letter>\n" + "<letter1>ABC\n" + "</letter1>";

		JSONObject obj = XML.toJSONObject(originalXml);
		JSONPointer jp = new JSONPointer("/logo");

		obj.toStream().filter(node -> (node.getValue() instanceof JSONObject))
				.forEach(node -> System.out.println( ((JSONObject) node.getValue()).query(jp) )  );

//		List<String> titles = obj.toStream().filter(node -> (node.getValue() instanceof JSONObject))
//				.flatMap(node -> Arrays.stream((String[]) ((JSONArray)((JSONObject) node.getValue()).query(jp)).toList()    ) )
//				.collect(Collectors.toList());
//		for (String title:
//			 titles) {
//			System.out.println(title);
//		}
	}

}
