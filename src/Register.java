import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class Register extends JFrame {
    private JTextField TFfirst_name;
    private JTextField TFlast_name;
    private JTextField TF_register_email;
    private JPasswordField Register_Pass;
    private JCheckBox isPassVisible;
    private JButton RegisterButt;
    private JCheckBox AdminCheck;
    private JButton ClearButt;
    private JPasswordField Register_Pass2;
    private JPanel JP_Register;

    public Register() {
        setContentPane(JP_Register);
        setTitle("Register Page");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        isPassVisible.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Register_Pass.isVisible();
                Register_Pass2.isVisible();
            }
        });
        ClearButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TF_register_email.setText("");
                TFfirst_name.setText("");
                TFlast_name.setText("");
                Register_Pass.setText("");
                Register_Pass2.setText("");
            }
        });
    }
}
