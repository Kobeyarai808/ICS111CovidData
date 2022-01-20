import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class State {
    private static int nStates;
    private static HashMap<String,String> stateNames = new HashMap<String,String>();
    private String abbr;
    private ArrayList<DailyData> dailyData = new ArrayList<DailyData>();

    public State(String abbr){
        nStates++;
        this.abbr = abbr;
    }
    public static int getNStates() { return nStates; }
    public static Set<String> getAllAbbrs() {
        buildStatesMap();
        return stateNames.keySet();
    }
    public String getAbbr(){ return abbr; }
    public void addData(String date, int cases, int deaths){
        dailyData.add(new DailyData(date, abbr, cases, deaths));
    }
    public ArrayList<DailyData> getData(){ return dailyData; }
    private static void buildStatesMap(){
        stateNames.put("AL","Alabama");
        stateNames.put("AK","Alaska");
        stateNames.put("AZ","Arizona");
        stateNames.put("AR","Arkansas");
        stateNames.put("AS","American Samoa");
        stateNames.put("CA","California");
        stateNames.put("CO","Colorado");
        stateNames.put("CT","Connecticut");
        stateNames.put("DE","Delaware");
        stateNames.put("DC","District of Columbia");
        stateNames.put("FL","Florida");
        stateNames.put("GA","Georgia");
        stateNames.put("GU","Guam");
        stateNames.put("HI","Hawaii");
        stateNames.put("ID","Idaho");
        stateNames.put("IL","Illinois");
        stateNames.put("IN","Indiana");
        stateNames.put("IA","Iowa");
        stateNames.put("KS","Kansas");
        stateNames.put("KY","Kentucky");
        stateNames.put("LA","Louisiana");
        stateNames.put("ME","Maine");
        stateNames.put("MD","Maryland");
        stateNames.put("MA","Massachusetts");
        stateNames.put("MI","Michigan");
        stateNames.put("MN","Minnesota");
        stateNames.put("MS","Mississippi");
        stateNames.put("MO","Missouri");
        stateNames.put("MP","Northern Mariana Islands");
        stateNames.put("MT","Montana");
        stateNames.put("NE","Nebraska");
        stateNames.put("NV","Nevada");
        stateNames.put("NH","New Hampshire");
        stateNames.put("NJ","New Jersey");
        stateNames.put("NM","New Mexico");
        stateNames.put("NY","New York");
        stateNames.put("NC","North Carolina");
        stateNames.put("ND","North Dakota");
        stateNames.put("OH","Ohio");
        stateNames.put("OK","Oklahoma");
        stateNames.put("OR","Oregon");
        stateNames.put("PA","Pennsylvania");
        stateNames.put("PR","Puerto Rico");
        stateNames.put("RI","Rhode Island");
        stateNames.put("SC","South Carolina");
        stateNames.put("SD","South Dakota");
        stateNames.put("TN","Tennessee");
        stateNames.put("TX","Texas");
        stateNames.put("VI","U.S. Virgin Islands");
        stateNames.put("UT","Utah");
        stateNames.put("VT","Vermont");
        stateNames.put("VA","Virginia");
        stateNames.put("WA","Washington");
        stateNames.put("WV","West Virginia");
        stateNames.put("WI","Wisconsin");
        stateNames.put("WY","Wyoming");
    }
    public static String getStateName(String abbr){
        return stateNames.get(abbr);
    }
}
