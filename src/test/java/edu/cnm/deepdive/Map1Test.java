package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

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
        new HashMap<>(Map.of("a", "candy", "b", "dirt")),
        new HashMap<>(Map.of("a", "candy")),
        new HashMap<>(Map.of("a", "candy", "b", "carrot", "c", "meh")),
        new HashMap<>(Map.of("b", "carrot")),
        new HashMap<>(Map.of("c", "meh")),
        new HashMap<>(Map.of("a", "sparkle", "c", "meh"))
    ));
    List<Map<String, String>> mapBullyExpected = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("a", "", "b", "candy")),
        new HashMap<>(Map.of("a", "", "b", "candy")),
        new HashMap<>(Map.of("a", "", "b", "candy", "c", "meh")),
        new HashMap<>(Map.of("b", "carrot")),
        new HashMap<>(Map.of("c", "meh")),
        new HashMap<>(Map.of("a", "", "b", "sparkle", "c", "meh"))
    ));
    System.out.println("\nRUNNING mapBully() TEST...");
    for (int i = 0; i < mapBullyParams.size(); i++) {
      String param = mapBullyParams.get(i).toString();
      Map<String, String> expected = mapBullyExpected.get(i);
      Map<String, String> actual = map1.mapBully(mapBullyParams.get(i));
      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n",
          param, expected.toString(), actual.toString());
      assertEquals(actual, expected);
    }
  }

  @Test
  void mapShare() {
    List<Map<String, String>> mapShareParams = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("a", "aaa", "b", "bbb", "c", "ccc")),
        new HashMap<>(Map.of("b", "xyz", "c", "ccc")),
        new HashMap<>(Map.of("a", "aaa", "c", "meh", "d", "hi")),
        new HashMap<>(Map.of("a", "xyz", "b", "1234", "c", "yo", "z",
            "zzz")),
        new HashMap<>(Map.of("a", "xyz", "b", "1234", "c", "yo", "d",
            "ddd", "e", "everything"))
    ));
    List<Map<String, String>> mapShareExpected = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("a", "aaa", "b", "aaa")),
        new HashMap<>(Map.of("b", "xyz")),
        new HashMap<>(Map.of("a", "aaa", "b", "aaa", "d", "hi")),
        new HashMap<>(Map.of("a", "xyz", "b", "xyz", "z", "zzz")),
        new HashMap<>(Map.of("a", "xyz", "b", "xyz", "d", "ddd", "e",
            "everything"))
    ));
    System.out.println("\nRUNNING mapShare() TEST...");
    for (int i = 0; i < mapShareParams.size(); i++) {
      String param = mapShareParams.get(i).toString();
      Map<String, String> expected = mapShareExpected.get(i);
      Map<String, String> actual = map1.mapShare(mapShareParams.get(i));
      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n",
          param, expected.toString(), actual.toString());
      assertEquals(actual, expected);
    }
  }
}