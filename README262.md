# Milestone 3:
run the file test in JSON-java/src/test/java/org.json.junit/XMLTest262.java

@Test
taskTest4 to test new function that input as String and return another String that is the transformation of the key.

Performance implications of doing this inside the library is much better (faster) than doing it in client code in Milestone1
After use System.currentTimeMillis(); to calculate the performance time. 
That just took 9ms to run for Milestone3. But took 22ms to run for Milestone1


# Milestone 4: 
run the file test in JSON-java/src/test/java/org.json.junit/XMLTest262.java

@Test
milestone4Test1 : test new function that using obj.toStream().forEach(node -> do some transformation, possibly based on the path of the node);

milestone4Test2 : test new function that using List<String> titles = obj.toStream().map(node -> extract value for key "title").collect(Collectors.toList());
  
milestone4Test3 : test new function that using obj.toStream().filter(node -> node with certain properties).forEach(node -> do some transformation);



