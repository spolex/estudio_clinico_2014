package pack.osakidetza.prototipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.Box;

public class IU_Nuevo_Estudio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtNHistorial;
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
					IU_Nuevo_Estudio frame = new IU_Nuevo_Estudio();
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
	public IU_Nuevo_Estudio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(276, 426, 117, 25);
		contentPane.add(btnListar);
		
		JLabel lblEstudios = new JLabel("Estudios");
		lblEstudios.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblEstudios.setBounds(216, 12, 107, 46);
		contentPane.add(lblEstudios);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(12, 84, 70, 15);
		contentPane.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(108, 82, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(12, 128, 70, 15);
		contentPane.add(lblPaciente);
		
		txtNHistorial = new JTextField();
		txtNHistorial.setText("nº historial");
		txtNHistorial.setBounds(108, 126, 114, 19);
		contentPane.add(txtNHistorial);
		txtNHistorial.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 172, 70, 15);
		contentPane.add(lblTipo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 170, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSubtipo = new JLabel("Subtipo");
		lblSubtipo.setBounds(12, 225, 70, 15);
		contentPane.add(lblSubtipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ductal", "lobulillar", "mucinoso", "tubular", "otros"}));
		comboBox.setBounds(108, 220, 128, 25);
		contentPane.add(comboBox);
		
		JLabel lblReceptoresEstrognicos = new JLabel("Estrogénicos");
		lblReceptoresEstrognicos.setBounds(258, 84, 92, 15);
		contentPane.add(lblReceptoresEstrognicos);
		
		JLabel lblProgestagnicos = new JLabel("Progestagénicos");
		lblProgestagnicos.setBounds(258, 128, 120, 15);
		contentPane.add(lblProgestagnicos);
		
		JLabel lblCerbe = new JLabel("CerbE2");
		lblCerbe.setBounds(12, 271, 70, 15);
		contentPane.add(lblCerbe);
		
		JLabel lblKi = new JLabel("Ki67");
		lblKi.setBounds(12, 319, 70, 15);
		contentPane.add(lblKi);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "desconocido"}));
		comboBox_1.setBounds(108, 266, 128, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "desconocido"}));
		comboBox_3.setBounds(408, 79, 135, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "desconocido"}));
		comboBox_4.setBounds(408, 123, 135, 20);
		contentPane.add(comboBox_4);
		
		JLabel lblGradoHistolgico = new JLabel("Grado histológico");
		lblGradoHistolgico.setBounds(258, 172, 135, 15);
		contentPane.add(lblGradoHistolgico);
		
		JLabel lblEstidiajet = new JLabel("Estidiaje (T)");
		lblEstidiajet.setBounds(258, 225, 135, 15);
		contentPane.add(lblEstidiajet);
		
		JLabel lblEstidiajen = new JLabel("Estidiaje (N)");
		lblEstidiajen.setBounds(258, 271, 92, 15);
		contentPane.add(lblEstidiajen);
		
		JLabel lblEstidiajem = new JLabel("Estidiaje (M)");
		lblEstidiajem.setBounds(258, 319, 92, 15);
		contentPane.add(lblEstidiajem);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setMaximumRowCount(20);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"T1mi", "T1a", "T1b", "T1c", "T2", "T3", "T4a", "T4b", "T4c", "T4d", "Tx"}));
		comboBox_5.setBounds(408, 220, 135, 20);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"N0", "N1mi", "N1a", "N1b", "N1c", "N2a", "N2b", "N2c", "N3a", "N3b", "N3c", "Nx", ""}));
		comboBox_6.setMaximumRowCount(20);
		comboBox_6.setBounds(408, 266, 135, 20);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"M0", "M1", "desconocido"}));
		comboBox_7.setBounds(408, 314, 135, 20);
		contentPane.add(comboBox_7);
		
		textField_2 = new JTextField();
		textField_2.setBounds(108, 317, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"G1", "G2", "G3", "desconocido"}));
		comboBox_2.setBounds(408, 169, 135, 20);
		contentPane.add(comboBox_2);
		
		JButton btnAadirNuevo = new JButton("Añadir nuevo");
		btnAadirNuevo.setBounds(408, 346, 135, 25);
		contentPane.add(btnAadirNuevo);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		btnActualizar.setBounds(147, 426, 117, 25);
		contentPane.add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(426, 426, 117, 25);
		contentPane.add(btnBuscar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setEnabled(false);
		btnBorrar.setBounds(12, 426, 117, 25);
		contentPane.add(btnBorrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(426, 503, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 379, 70, 15);
		contentPane.add(lblFecha);
		
		textField_3 = new JTextField();
		textField_3.setText("12-12-2005");
		textField_3.setBounds(108, 377, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
