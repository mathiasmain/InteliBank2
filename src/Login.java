import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login extends JFrame{
    private JButton RegisterButt;
    private JTextField TFEmail;
    private JButton LoginButt;
    private JPanel JP_Login;
    private JPasswordField TFPass;


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
                    Person p = SQLQuerries.SQLogin(foo, TFEmail.getText(), Arrays.toString(TFPass.getPassword()));
                    if( p != null)
                    {
                        MainPage mp = new MainPage(p);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Email/senha incorretos ou usuário não existe");
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Formato do email ou tamanho inválido, máximo de 80 caracteres!");
                }
            }
        });
        RegisterButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register r = new Register();
            }
        });
    }

}
