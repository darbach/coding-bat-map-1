package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class Map1Test {

  Map1 map1 = new Map1();

  @Test
  void mapBully() {
    List<Map<String, String>> mapBullyParams = new ArrayList<>(Arrays.asList(
        new HashMap<String, String>(Map.of("a", "candy", "b", "dirt")),
        new HashMap<String, String>(Map.of("a", "candy")),
        new HashMap<String, String>(Map.of("a", "candy", "b", "carrot", "c", "meh")),
        new HashMap<String, String>(Map.of("b", "carrot")),
        new HashMap<String, String>(Map.of("c", "meh")),
        new HashMap<String, String>(Map.of("a", "sparkle", "c", "meh"))
    ));
    List<Map<String, String>> mapBullyExpected = new ArrayList<>(Arrays.asList(
        new HashMap<String, String>(Map.of("a", "", "b", "candy")),
        new HashMap<String, String>(Map.of("a", "", "b", "candy")),
        new HashMap<String, String>(Map.of("a", "", "b", "candy", "c", "meh")),
        new HashMap<String, String>(Map.of("b", "carrot")),
        new HashMap<String, String>(Map.of("c", "meh")),
        new HashMap<String, String>(Map.of("a", "", "b", "sparkle", "c", "meh"))
    ));
    System.out.println("Running mapBully() test...");
    for (int i = 0; i < mapBullyParams.size(); i++) {
      String param = mapBullyParams.get(i).toString();
      Map<String, String> expected = mapBullyExpected.get(i);
      Map<String, String> actual = map1.mapBully(mapBullyParams.get(i));
      System.out.printf("Param: %s; Expected: %s; Actual %s%n",
          param, expected.toString(), actual.toString());
      assertTrue(expected.equals(actual));
    }
  }
}