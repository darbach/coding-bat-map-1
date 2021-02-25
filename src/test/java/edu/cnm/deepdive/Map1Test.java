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

  @Test
  void mapAB() {
    List<Map<String, String>> mapABParams = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("a", "Hi", "b", "There")),
        new HashMap<>(Map.of("a", "Hi")),
        new HashMap<>(Map.of("b", "There")),
        new HashMap<>(Map.of("c", "meh")),
        new HashMap<>(Map.of("a", "aaa", "ab", "nope", "b", "bbb", "c", "ccc")),
        new HashMap<>(Map.of("ab", "nope", "b", "bbb", "c", "ccc"))
    ));
    List<Map<String, String>> mapABExepcted = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("a", "Hi", "ab", "HiThere", "b", "There")),
        new HashMap<>(Map.of("a", "Hi")),
        new HashMap<>(Map.of("b", "There")),
        new HashMap<>(Map.of("c", "meh")),
        new HashMap<>(Map.of("a", "aaa", "ab", "aaabbb", "b", "bbb", "c", "ccc")),
        new HashMap<>(Map.of("ab", "nope", "b", "bbb", "c", "ccc"))
    ));
    System.out.println("\nRUNNING mapAB() TEST...");
    for (int i = 0; i < mapABParams.size(); i++) {
      String param = mapABParams.get(i).toString();
      Map<String, String> expected = mapABExepcted.get(i);
      Map<String, String> actual = map1.mapAB(mapABParams.get(i));
      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n",
          param, expected.toString(), actual.toString());
      assertEquals(actual, expected);
    }
  }

  @Test
  void topping1() {
    List<Map<String, String>> topping1Params = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("ice cream", "peanuts")),
        new HashMap<>(Map.of()),
        new HashMap<>(Map.of("pancake", "syrup")),
        new HashMap<>(Map.of("bread", "dirt", "ice cream", "strawberries")),
        new HashMap<>(Map.of("bread", "jam", "ice cream", "strawberries",
            "salad", "oil"))
    ));
    List<Map<String, String>> topping1Expected = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("bread", "butter", "ice cream", "cherry")),
        new HashMap<>(Map.of("bread", "butter")),
        new HashMap<>(Map.of("bread", "butter", "pancake", "syrup")),
        new HashMap<>(Map.of("bread", "butter", "ice cream", "cherry")),
        new HashMap<>(Map.of("bread", "butter", "ice cream", "cherry", "salad", "oil"))
    ));
    System.out.println("\nRUNNING topping1() TEST...");
    for (int i = 0; i < topping1Params.size(); i++) {
      String param = topping1Params.get(i).toString();
      Map<String, String> expected = topping1Expected.get(i);
      Map<String, String> actual = map1.topping1(topping1Params.get(i));
      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n",
          param, expected.toString(), actual.toString());
      assertEquals(actual, expected);
    }
  }

  @Test
  void topping2() {
    List<Map<String, String>> topping2Params = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("ice cream", "cherry")),
        new HashMap<>(Map.of("spinach", "dirt", "ice cream", "cherry")),
        new HashMap<>(Map.of("yogurt", "salt")),
        new HashMap<>(Map.of("yogurt", "salt", "bread", "butter")),
        new HashMap<>(Map.of()),
        new HashMap<>(Map.of("ice cream", "air", "salad", "oil"))
    ));
    List<Map<String, String>> topping2Expected = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("yogurt", "cherry", "ice cream", "cherry")),
        new HashMap<>(Map.of("yogurt", "cherry", "spinach", "nuts", "ice cream", "cherry")),
        new HashMap<>(Map.of("yogurt", "salt")),
        new HashMap<>(Map.of("yogurt", "salt", "bread", "butter")),
        new HashMap<>(Map.of()),
        new HashMap<>(Map.of("yogurt", "air", "ice cream", "air", "salad", "oil"))
    ));
    System.out.println("\nRUNNING topping2() TEST...");
    for (int i = 0; i < topping2Params.size(); i++) {
      String param = topping2Params.get(i).toString();
      Map<String, String> expected = topping2Expected.get(i);
      Map<String, String> actual = map1.topping2(topping2Params.get(i));
      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n",
          param, expected.toString(), actual.toString());
      assertEquals(actual, expected);
    }
  }

  @Test
  void topping3() {
    List<Map<String, String>> topping3Params = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("potato", "ketchup")),
        new HashMap<>(Map.of("potato", "butter")),
        new HashMap<>(Map.of("salad", "oil", "potato", "ketchup")),
        new HashMap<>(Map.of("toast", "butter", "salad", "oil", "potato", "ketchup")),
        new HashMap<>(Map.of()),
        new HashMap<>(Map.of("salad", "pepper", "fries", "salt"))
    ));
    List<Map<String, String>> topping3Expected = new ArrayList<>(Arrays.asList(
        new HashMap<>(Map.of("potato", "ketchup", "fries", "ketchup")),
        new HashMap<>(Map.of("potato", "butter", "fries", "butter")),
        new HashMap<>(
            Map.of("spinach", "oil", "salad", "oil", "potato", "ketchup", "fries", "ketchup")),
        new HashMap<>(
            Map.of("toast", "butter", "spinach", "oil", "salad", "oil", "potato", "ketchup",
                "fries", "ketchup")),
        new HashMap<>(Map.of()),
        new HashMap<>(Map.of("spinach", "pepper", "salad", "pepper", "fries", "salt"))
    ));
    System.out.println("\nRUNNING topping3() TEST...");
    for (int i = 0; i < topping3Params.size(); i++) {
      String param = topping3Params.get(i).toString();
      Map<String, String> expected = topping3Expected.get(i);
      Map<String, String> actual = map1.topping3(topping3Params.get(i));
      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n",
          param, expected.toString(), actual.toString());
      assertEquals(actual, expected);
    }
  }
}