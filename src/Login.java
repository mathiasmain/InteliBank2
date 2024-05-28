import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JButton RegisterButt;
    private JTextField TFEmail;
    private JButton LoginButt;
    private JPanel JP_Login;


    public Login(Batadase foo)
    {
        setContentPane(JP_Login);
        setTitle("Login Page");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        LoginButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = TFEmail.getText();

                if(!email.isBlank() &&
                        email.length() < 81 &&
                        email.contains(String.valueOf('.'))&&
                        email.contains(String.valueOf('@')))
                {

                    if(SQlogin(foo, TFEmail.getText(), TFPass.getText()))
                    // LoginPass Lp = new LoginPass();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Email inválido");
                }
            }
        });
        RegisterButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
