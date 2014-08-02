package pack.osakidetza.prototipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class IU_Recuperar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField pwdJhnfkfvlflbfg;
	private JPasswordField pwdJkdshfajksdghfu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Recuperar frame = new IU_Recuperar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_Recuperar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnComoSeLlama = new JTextPane();
		txtpnComoSeLlama.setText("Como se llama mi perro");
		txtpnComoSeLlama.setBounds(12, 12, 424, 106);
		contentPane.add(txtpnComoSeLlama);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setBounds(22, 137, 138, 15);
		contentPane.add(lblRespuesta);
		
		textField = new JTextField();
		textField.setBounds(12, 164, 424, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(319, 336, 117, 25);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setEnabled(false);
		btnOk.setBounds(188, 336, 117, 25);
		contentPane.add(btnOk);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contraseña");
		lblNuevaContrasea.setBounds(12, 216, 189, 15);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contraseña");
		lblRepitaLaContrasea.setBounds(12, 274, 170, 15);
		contentPane.add(lblRepitaLaContrasea);
		
		pwdJhnfkfvlflbfg = new JPasswordField();
		pwdJhnfkfvlflbfg.setText("jhnfkfvlflbfg");
		pwdJhnfkfvlflbfg.setBounds(188, 214, 252, 17);
		contentPane.add(pwdJhnfkfvlflbfg);
		
		pwdJkdshfajksdghfu = new JPasswordField();
		pwdJkdshfajksdghfu.setText("jkdshfajksdghfñu");
		pwdJkdshfajksdghfu.setBounds(188, 272, 252, 17);
		contentPane.add(pwdJkdshfajksdghfu);
	}
}
