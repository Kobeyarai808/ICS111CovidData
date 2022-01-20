import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OOP2 {
    private static HashMap<String,State> states = new HashMap<>(); // Abbreviations are keys and State objects are values
    private static ArrayList<DailyData> outputList = new ArrayList<>(); // Holds all the data resulting from a search on a date
    private static GUITest gui = new GUITest();
    private static JFrame frame = new JFrame();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        String target="GO"; // flag to control the input loop
        /*****************************/
        frame.add(gui.getTestPanel());
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        /*****************************/

        // Create a State instance for every abbreviation.
        // Add them all to the states ArrayList
        buildStateList(states);
        System.out.println(State.getNStates() + " state/territory objects were created.");
        /****/gui.setAmtStatesImported(State.getNStates() + " state/territory objects were created.");
        // Populate the state objects with data from file.
        fillStateList(states);
        // Loop to ask the user to enter a date.
        /*while (! target.toUpperCase().equals("STOP")) {
            System.out.print("\nDate (YYYY-MM-DD): ");
            target = in.nextLine();
            sortData(target);
        }*/
    }

    /**
    * Helper Functions!
    * */
    public static void buildStateList(HashMap<String, State> sMap){
        for (String i: State.getAllAbbrs()) { sMap.put(i,new State(i)); }
    }
    public static void fillStateList(HashMap<String,State> sMap) throws FileNotFoundException {
        Scanner data = new Scanner(new File("all-states-history.csv"));
        data.next(); //Skip header
        while(data.hasNext()) {
            String[] temp = data.next().split(",");
            sMap.get(temp[1]).addData(temp[0],Integer.parseInt(temp[21]),Integer.parseInt(temp[4]));
        }
    }
    public static ArrayList<DailyData> getDataOnDate(String target, HashMap<String, State> stateList) {
        ArrayList<DailyData> dataOnDate = new ArrayList<DailyData>();
        for (Map.Entry<String,State> state: stateList.entrySet()) {
            for(DailyData data: state.getValue().getData()) {
                if(data.getDate().equals(target)) {
                    dataOnDate.add(data);
                }
            }
        }
        return dataOnDate;
    }
    public static String listToString(ArrayList<DailyData> dailyData) {
        String result = String.format("%-25s %15s %15s\n","State","Cases","Deaths");
        for(DailyData data: dailyData){
            result += data + "\n";
        }
        return result;
    }
    public static State getState(String code, ArrayList<State> States) {
        for (State S: States) { if(S.getAbbr().equals(code)) return S; }
        return null;
    }
    /****/public static String convertToMultiline(String string) {
        return "<html><pre>" + string.replaceAll("\n", "<br>") + "</pre>";
    }
    /****/public static void sortData(String target){
        outputList = getDataOnDate(target,states);
        if (! target.toUpperCase().equals("STOP")) {
            if (outputList.size() > 0) {
                System.out.println("\n" + listToString(outputList));
                /****/gui.setResultsText(convertToMultiline(listToString(outputList)));
            }
            else {
                System.out.println("\"" + target + "\" is not a valid date or is out of range.");
                //testForm.setResultsText("\"" + target + "\" is not a valid date or is out of range.");
                JFrame error = new JFrame("ERROR!");
                JOptionPane.showMessageDialog(error, "\"" + target + "\" is not a valid date or is out of range.","ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            frame.setVisible(false);
            frame.dispose();
            in.close();
            System.out.println("Done.");
        }
    }
}