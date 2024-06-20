import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cache<T> {

    public static HashMap<String, List<Data>> DONNEES = new HashMap<>();

    public static List<Data> getDATA(String nom){
        if(DONNEES.get(nom) != null) return DONNEES.get(nom);
        else return new ArrayList<>();
    }

    public static <T extends Data> List<T> getDATAAs(String nom, Class<T> type) {
        List<Data> rawDataList = DONNEES.get(nom);
        List<T> typedDataList = new ArrayList<>();
        
        if (rawDataList != null) {
            for (Data data : rawDataList) {
                if (type.isInstance(data)) {
                    typedDataList.add(type.cast(data));
                }
            }
        }
        return typedDataList;
    }

    public static void setDATA(String nom, Data data){
        if(!DONNEES.containsKey(nom)){
            DONNEES.put(nom, new ArrayList<Data>());
        }
        DONNEES.get(nom).add(data);
    }

    public static boolean containDATA(String nom, Data data){
        if(!DONNEES.containsKey(nom)){
            if(DONNEES.get(nom).contains(data)) return true;
        }
        return false;
    }
}