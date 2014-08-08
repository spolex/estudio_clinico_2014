package pack.osakidetza.prototipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class IU_Cambiar_contraseña extends JFrame {

	private JPanel contentPane;
	private JTextField textResp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Cambiar_contraseña frame = new IU_Cambiar_contraseña();
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
	public IU_Cambiar_contraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 26, 70, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(12, 65, 95, 15);
		contentPane.add(lblContrasea);
		
		JLabel lblContraseaNueva = new JLabel("Contraseña nueva");
		lblContraseaNueva.setBounds(12, 109, 158, 15);
		contentPane.add(lblContraseaNueva);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contraseña");
		lblRepitaLaContrasea.setBounds(12, 146, 158, 15);
		contentPane.add(lblRepitaLaContrasea);
		
		JLabel lblPreguntaDeSeguridad = new JLabel("Pregunta de seguridad");
		lblPreguntaDeSeguridad.setBounds(12, 213, 210, 15);
		contentPane.add(lblPreguntaDeSeguridad);
		
		JTextPane textPaneAsk = new JTextPane();
		textPaneAsk.setBounds(12, 240, 357, 65);
		contentPane.add(textPaneAsk);
		
		JLabel lblRepuesta = new JLabel("Repuesta");
		lblRepuesta.setBounds(12, 317, 70, 15);
		contentPane.add(lblRepuesta);
		
		textResp = new JTextField();
		textResp.setBounds(12, 344, 357, 19);
		contentPane.add(textResp);
		textResp.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(49, 375, 117, 25);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(190, 375, 117, 25);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(176, 24, 193, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 63, 193, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 107, 193, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(176, 144, 193, 19);
		contentPane.add(textField_3);
	}
}
