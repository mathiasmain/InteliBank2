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
    private JButton RegisterButt;
    private JCheckBox AdminCheck;
    private JButton ClearButt;
    private JPasswordField Register_Pass2;
    private JPanel JP_Register;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;

    public Register() {
        setContentPane(JP_Register);
        setTitle("Register Page");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

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

        Boolean isAdmin=false;
        AdminCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isAdmin = true;
            }
        });

        RegisterButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Checar valor em branco, quantidade maior que o permitido (20) e (80).

                String[] str = {String.valueOf(TFfirst_name), String.valueOf(TFlast_name),
                        String.valueOf(TF_register_email), String.valueOf(Register_Pass), String.valueOf(Register_Pass2)};

                for( int i = 0; i < 5; i++ )
                {
                    switch(i)
                    {
                        case 0:
                            if(str[i].isBlank() || str[i].length() > 20 || str[i].matches("[a-zA-Z]")) {
                                JOptionPane.showMessageDialog(null, "O primeiro nome não pode " +
                                        "passar de 20 caracteres, além disto, deve conter somente letras.");
                                return;
                            }
                            break;
                        case 1:
                            if(str[i].isBlank() || str[i].length() > 20 || str[i].matches("[a-zA-Z]")) {
                                JOptionPane.showMessageDialog(null, "O último nome não pode " +
                                        "passar de 20 caracteres, além disto, deve conter somente letras.");
                                return;
                            }
                            break;
                        case 2:
                            if(str[i].isBlank() || str[i].length() > 80 || !str[i].contains("@") || !str[i].contains(".") ) {
                                JOptionPane.showMessageDialog(null, "O email nome não pode " +
                                        "passar de 80 caracteres.");
                                return;
                            }
                            break;
                        case 3:
                            if(str[i].isBlank() || str[i].length() > 20) {
                                JOptionPane.showMessageDialog(null, "A senha nome não pode " +
                                        "passar de 20 caracteres.");
                                return;
                            }
                            break;
                        case 4:
                            if(str[i].isBlank() || str[i].length() > 20 || !str[i].equals(str[i-1])) {
                                JOptionPane.showMessageDialog(null, "A senha nome não pode " +
                                        "passar de 20 caracteres e deve ser idêntica ao primeiro campo de senha.");
                                return;
                            }
                            break;
                    }
                }

                // Verifica o check de admin.
                if(isAdmin)
                {
                    Person p = new Person(EUser.toEnumUser("ADMIN"), str[0], str[1], , );
                    MainPage mp = new MainPage();
                    JOptionPane.showMessageDialog(null, "Usuário administrador criado com sucesso!");
                }
            }
        });

    }
}
