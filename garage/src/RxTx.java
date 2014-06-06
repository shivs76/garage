import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: S.Sankaranarayanan
 * Date: 1/21/14
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class RxTx {
    
    public static String FILE_NAME = "C:\\garage\\rxtx.csv";
    public Map<String,Double> rxTx = new TreeMap<String, Double>();
     
    
    public void  readLineByLine() throws Exception {
        FileReader fr = new FileReader(FILE_NAME)  ;
        BufferedReader br = new BufferedReader(fr);
        String aLine = "";
        System.out.println("About to read line by line");
        while(( aLine = br.readLine()) != null) {
           // System.out.println(aLine);
            decipher(aLine);
            
        }
    }
    
    public void decipher(String aLine) {
        StringTokenizer st = new StringTokenizer(aLine, ",");
       while(st.hasMoreTokens()) {
           String circuitId = st.nextToken();
           st.nextToken();st.nextToken();
           Double sum = Double.parseDouble(st.nextToken());
          // System.out.println("Circuit is " + circuitId + " sum " + sum);
           addToMap(circuitId, sum);
                  
       }
    }
    
    public void addToMap(String circuitId, Double sum) {
         
        if(rxTx.containsKey(circuitId)) {
           Double existingSum = rxTx.get(circuitId);
           Double newSum = sum + existingSum ;
            //String newSum = sum + existingSum;
           rxTx.put(circuitId, newSum);               
        } else {
            rxTx.put(circuitId,sum);
        }
    }
    
    public List<Map.Entry<String,Double>> doSorting() {
        Comparator<Map.Entry<String,Double>> double_comparator = 
                new Comparator<Map.Entry<String, Double>>() {
                    @Override
                    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                        return (o2.getValue().compareTo(o1.getValue()));
                    }
                };
        Set<Map.Entry<String,Double>> mapSet = rxTx.entrySet();
        List<Map.Entry<String,Double>> mapList = new ArrayList<Map.Entry<String, Double>>(mapSet);
        Collections.sort(mapList,double_comparator);
        return mapList;
    }
    
    

    public static void main(String[] args) throws Exception{
        RxTx a = new RxTx();
        a.readLineByLine();
        //System.out.println("The map is  " + a.rxTx);
        System.out.println("Map size is " + a.rxTx.size());
        List<Map.Entry<String, Double>> mapList = a.doSorting();
        System.out.println("The Map List size  " + mapList.size());
        for(Map.Entry<String,Double> anEntry : mapList) {
            System.out.println("Aip is " + anEntry.getKey() + " combined value " + anEntry.getValue());
        }
        
}
}
