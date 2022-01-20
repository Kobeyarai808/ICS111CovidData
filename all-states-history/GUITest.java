import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITest {
    private JTextField dateInput;
    private JButton pressToSearchDateButton;
    private JPanel testPanel;
    private JLabel amtStatesImported;
    private JScrollPane resultsPane;
    private JLabel resultsText;
    private JLabel dateExample;

    public GUITest() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateIn = dateInput.getText();
                OOP2.sortData(dateIn);
            }
        };
        pressToSearchDateButton.addActionListener(action);
        dateInput.addActionListener(action);
    }
    public void setAmtStatesImported(String text){
        amtStatesImported.setText(text);
    }
    public void setResultsText(String text) {
        resultsText.setText(text);
    }
    public JPanel getTestPanel(){
        return testPanel;
    }
}
