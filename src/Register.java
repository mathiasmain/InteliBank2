import javax.swing.*;

import static com.sun.org.apache.xerces.internal.util.DOMUtil.setVisible;

public class Register extends JFrame {
    private JTextField TFfirst_name;
    private JTextField TFlast_name;
    private JTextField TF_register_email;
    private JPasswordField Register_Pass;
    private JCheckBox isPassVisible;
    private JButton RegisterButt;
    private JCheckBox AdminCheck;
    private JButton ClearButt;
    private JPasswordField RegisterPass2;
    private JPanel JP_Register;

    public Register() {
        setContentPane(JP_Register);
        setTitle("Register Page");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
