package edu.cnm.deepdive;

import java.util.Map;

/**
 * CodingBat's first set of Java exercises for the Map class.
 *
 * https://codingbat.com/java/Map-1
 *
 * @author Daniel Arbach
 * @version 1.0
 * @since 2021-02-19
 */
public class Map1 {

  /**
   * Modify and return the given map as follows: if the key "a" has a value, set the key "b" to
   * have that value, and set the key "a" to have the value "". Basically "b" is a bully, taking
   * the value and replacing it with the empty string.
   *
   * mapBully({"a": "candy", "b": "dirt"}) → {"a": "", "b": "candy"}
   * mapBully({"a": "candy"}) → {"a": "", "b": "candy"}
   * mapBully({"a": "candy", "b": "carrot", "c": "meh"}) → {"a": "", "b": "candy", "c": "meh"}
   *
   * @param map A Map<String, String>
   * @return Modified map
   */
  public Map<String, String> mapBully(Map<String, String> map) {
    if (map.containsKey("a")) {
      map.put("b", map.get("a"));
      map.put("a", "");
    }
    return map;
  }

  /**
   * Modify and return the given map as follows: if the key "a" has a value, set the key "b"
   * to have that same value. In all cases remove the key "c", leaving the rest of the map
   * unchanged.
   *
   * mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
   * mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
   * mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
   *
   * @param map A Map<String, String>
   * @return Modified map
   */
  public Map<String, String> mapShare(Map<String, String> map) {
    if (map.containsKey("a")) {
      map.put("b", map.get("a"));
    }
    map.remove("c");
    return map;
  }

  /**
   * Modify and return the given map as follows: for this problem the map may or may not contain
   * the "a" and "b" keys. If both keys are present, append their 2 string values together and
   * store the result under the key "ab".
   *
   * mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
   * mapAB({"a": "Hi"}) → {"a": "Hi"}
   * mapAB({"b": "There"}) → {"b": "There"}
   *
   * @param map A Map<String, String>
   * @return Modified map
   */
  public Map<String, String> mapAB(Map<String, String> map) {
    if (map.containsKey("a") && map.containsKey("b")) {
      map.put("ab", (map.get("a") + map.get("b")));
    }
    return map;
  }
}
