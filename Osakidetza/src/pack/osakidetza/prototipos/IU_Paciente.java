package pack.osakidetza.prototipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class IU_Paciente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Paciente frame = new IU_Paciente();
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
	public IU_Paciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDiagnsticos = new JLabel("Diagnósticos");
		lblDiagnsticos.setBounds(12, 23, 143, 15);
		contentPane.add(lblDiagnsticos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 33, 298, 75);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1315;BRCA1;12/05/2001", "1315;BRCA1;05/05/2003"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(302, 327, 117, 25);
		contentPane.add(btnNuevo);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(168, 327, 117, 25);
		contentPane.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(28, 327, 117, 25);
		contentPane.add(btnActualizar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(431, 327, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblGenSecuenciado = new JLabel("Gen secuenciado");
		lblGenSecuenciado.setBounds(12, 120, 161, 15);
		contentPane.add(lblGenSecuenciado);
		
		JLabel lblTipoCancer = new JLabel("Tipo Cancer");
		lblTipoCancer.setBounds(12, 163, 133, 15);
		contentPane.add(lblTipoCancer);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setEnabled(false);
		lblObservaciones.setBounds(12, 248, 105, 15);
		contentPane.add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(121, 248, 298, 52);
		contentPane.add(textPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mama", "Ovario", "Trompa", "Otros"}));
		comboBox.setBounds(168, 163, 140, 25);
		contentPane.add(comboBox);
		
		JLabel lblTipoMama = new JLabel("Tipo Mama");
		lblTipoMama.setBounds(348, 147, 117, 15);
		contentPane.add(lblTipoMama);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"izquierda", "derecha"}));
		comboBox_2.setEnabled(false);
		comboBox_2.setBounds(348, 163, 117, 25);
		contentPane.add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setText("1315");
		textField_1.setBounds(171, 217, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnEstudio = new JRadioButton("Estudio");
		rdbtnEstudio.setBounds(12, 213, 149, 23);
		contentPane.add(rdbtnEstudio);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BRCA1", "BRCA2", "CHEK6"}));
		comboBox_1.setBounds(168, 120, 143, 25);
		contentPane.add(comboBox_1);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(316, 221, 70, 15);
		contentPane.add(lblPaciente);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("1212");
		textField.setBounds(404, 217, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
