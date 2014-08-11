package pack.osakidetza.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class IU_FormMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_FormMedico frame = new IU_FormMedico();
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
	public IU_FormMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoMedico = new JLabel("Nuevo medico");
		lblNuevoMedico.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblNuevoMedico.setBounds(15, 12, 438, 28);
		contentPane.add(lblNuevoMedico);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 45, 421, 12);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(72, 91, 70, 15);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(196, 87, 181, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setBounds(72, 122, 70, 15);
		contentPane.add(lblPass);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 120, 181, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(72, 162, 106, 15);
		contentPane.add(lblEspecialidad);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 160, 181, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(319, 237, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(190, 237, 117, 25);
		contentPane.add(btnAceptar);
	}
}
