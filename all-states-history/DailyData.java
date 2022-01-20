public class DailyData {
    String date;
    String state;
    int cases;
    int deaths;
    public DailyData(String s1, String s2, int c, int d){
        date = s1;
        state = State.getStateName(s2);
        cases = c;
        deaths = d;
    }
    public String getDate(){return date;}
    public String getState(){ return state;}
    public int getNCases(){return cases;}
    public int getNDeaths(){return deaths;}
    public String toString(){
        return String.format("%-25s %15s %15s",getState(),getNCases(),getNDeaths());
    }
}
