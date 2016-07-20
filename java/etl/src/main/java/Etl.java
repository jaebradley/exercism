import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Etl {

   public static EnumMap<ScrabbleTile, Integer> scrabbleTileValueMap = new EnumMap<ScrabbleTile, Integer>(ScrabbleTile.class);

   static {
      scrabbleTileValueMap.put(ScrabbleTile.A, 1);
      scrabbleTileValueMap.put(ScrabbleTile.B, 3);
      scrabbleTileValueMap.put(ScrabbleTile.C, 3);
   }

   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
      return null;
   }
}
