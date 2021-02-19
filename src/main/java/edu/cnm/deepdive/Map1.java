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
    String aValue = map.get("a");
    if (aValue != null) {
      map.put("b", aValue);
      map.put("a", "");
    }
    return map;
  }
}
