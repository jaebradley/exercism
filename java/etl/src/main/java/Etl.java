import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Etl {

   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
      final Map<String, Integer> tileScoreMap = new HashMap<String, Integer>();
      for (Entry<Integer, List<String>> entry : old.entrySet()) {
         for (String s : entry.getValue()) {
            tileScoreMap.put(s.toLowerCase(), entry.getKey());
         }
      }
      return tileScoreMap;
   }
}
