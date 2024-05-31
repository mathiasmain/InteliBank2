import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    private JButton StartPageButton;
    private JButton MoneyButton;
    private JButton cryptoButton;
    private JButton configuraçõesButton;
    private JButton logoutButton;
    private JPanel JP_Mainpage;

    public MainPage(Person p) {
        setContentPane(JP_Mainpage);
        setTitle("Login Page");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        StartPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
