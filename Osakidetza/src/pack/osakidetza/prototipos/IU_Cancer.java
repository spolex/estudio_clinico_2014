package pack.osakidetza.prototipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class IU_Cancer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Cancer frame = new IU_Cancer();
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
	public IU_Cancer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCancer = new JLabel("Cancer");
		lblCancer.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblCancer.setBounds(5, 5, 158, 40);
		contentPane.add(lblCancer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 57, 421, 9);
		contentPane.add(separator);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(25, 81, 99, 15);
		contentPane.add(lblPaciente);
		
		textField = new JTextField();
		textField.setBounds(186, 78, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(25, 121, 70, 15);
		contentPane.add(lblTipo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(25, 159, 70, 15);
		contentPane.add(lblFecha);
		
		JLabel lblGenSecuenciado = new JLabel("Gen secuenciado");
		lblGenSecuenciado.setBounds(25, 201, 138, 15);
		contentPane.add(lblGenSecuenciado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Trompa", "Mama", "Ovario", "otros"}));
		comboBox.setBounds(186, 116, 114, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"izquierda", "derecha"}));
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(330, 116, 106, 24);
		contentPane.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 157, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"BRCA1", "BRCA2", "CHEK6"}));
		comboBox_2.setBounds(186, 196, 114, 24);
		contentPane.add(comboBox_2);
		
		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setBounds(25, 258, 125, 15);
		contentPane.add(lblTratamiento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 285, 386, 66);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(319, 368, 117, 25);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(183, 368, 117, 25);
		contentPane.add(btnCancelar);
	}
}
