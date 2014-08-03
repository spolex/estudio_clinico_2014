package pack.osakidetza.prototipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class ModificarVisita extends JFrame {

	private JPanel contentPane;
	private JTextField txtd;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarVisita frame = new ModificarVisita();
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
	public ModificarVisita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificarVisita = new JLabel("Modificar Visita");
		lblModificarVisita.setBounds(12, 12, 196, 15);
		contentPane.add(lblModificarVisita);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(12, 49, 70, 15);
		contentPane.add(lblPaciente);
		
		txtd = new JTextField();
		txtd.setEditable(false);
		txtd.setText("145875d");
		txtd.setBounds(100, 47, 114, 19);
		contentPane.add(txtd);
		txtd.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(243, 51, 70, 15);
		contentPane.add(lblFecha);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("14/05/2005");
		textField_1.setBounds(322, 49, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(12, 98, 135, 15);
		contentPane.add(lblObservaciones);
		
		JTextPane txtpnElPacientePresenta = new JTextPane();
		txtpnElPacientePresenta.setText("\nel paciente presenta dolor difuso en la zona intercostal derecha.");
		txtpnElPacientePresenta.setBounds(12, 125, 424, 108);
		contentPane.add(txtpnElPacientePresenta);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(189, 261, 117, 25);
		contentPane.add(btnVolver);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(329, 261, 117, 25);
		contentPane.add(btnNewButton);
	}

}
