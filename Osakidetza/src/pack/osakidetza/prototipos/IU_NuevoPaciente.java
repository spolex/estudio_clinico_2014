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

public class IU_NuevoPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_NuevoPaciente frame = new IU_NuevoPaciente();
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
	public IU_NuevoPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblPaciente.setBounds(12, 12, 113, 28);
		contentPane.add(lblPaciente);
		
		JLabel lblCi = new JLabel("Ci");
		lblCi.setBounds(12, 100, 70, 15);
		contentPane.add(lblCi);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(12, 137, 70, 15);
		contentPane.add(lblSexo);
		
		JLabel lblHistorial = new JLabel("Historial");
		lblHistorial.setBounds(12, 64, 70, 15);
		contentPane.add(lblHistorial);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 52, 403, 15);
		contentPane.add(separator);
		
		JLabel lblCriteriosci = new JLabel("Criterios_Ci");
		lblCriteriosci.setBounds(12, 176, 113, 15);
		contentPane.add(lblCriteriosci);
		
		JLabel lblNumeroFamilia = new JLabel("Numero familia");
		lblNumeroFamilia.setBounds(12, 216, 113, 15);
		contentPane.add(lblNumeroFamilia);
		
		JLabel lblFamiliarCi = new JLabel("Familiar Ci");
		lblFamiliarCi.setBounds(12, 265, 113, 15);
		contentPane.add(lblFamiliarCi);
		
		JLabel lblRelacinCi = new JLabel("Relación CI");
		lblRelacinCi.setBounds(12, 308, 102, 15);
		contentPane.add(lblRelacinCi);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(12, 352, 160, 15);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblLugarDeNacimiento = new JLabel("Lugar de nacimiento");
		lblLugarDeNacimiento.setBounds(355, 64, 160, 15);
		contentPane.add(lblLugarDeNacimiento);
		
		JLabel lblOrigenMaterno = new JLabel("Origen materno");
		lblOrigenMaterno.setBounds(355, 100, 149, 15);
		contentPane.add(lblOrigenMaterno);
		
		JLabel lblOrigenPaterno = new JLabel("Origen paterno");
		lblOrigenPaterno.setBounds(355, 137, 129, 15);
		contentPane.add(lblOrigenPaterno);
		
		JLabel lblFechaDeSeguimiento = new JLabel("Fecha de seguimiento");
		lblFechaDeSeguimiento.setBounds(355, 176, 178, 15);
		contentPane.add(lblFechaDeSeguimiento);
		
		JLabel lblConsumoAnovulatorios = new JLabel("Consumo Anovulatorios");
		lblConsumoAnovulatorios.setBounds(355, 216, 202, 15);
		contentPane.add(lblConsumoAnovulatorios);
		
		JLabel lblNmeroDeGestaciones = new JLabel("Número de gestaciones");
		lblNmeroDeGestaciones.setBounds(355, 265, 168, 15);
		contentPane.add(lblNmeroDeGestaciones);
		
		JLabel lblPrimerEmbarazo = new JLabel("Primer embarazo");
		lblPrimerEmbarazo.setBounds(355, 308, 178, 15);
		contentPane.add(lblPrimerEmbarazo);
		
		JLabel lblMenopausia = new JLabel("Menopausia");
		lblMenopausia.setBounds(355, 352, 149, 15);
		contentPane.add(lblMenopausia);
		
		textField = new JTextField();
		textField.setBounds(173, 62, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		comboBox.setBounds(173, 260, 114, 24);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		comboBox_1.setBounds(173, 138, 114, 24);
		contentPane.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 174, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 214, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		comboBox_2.setBounds(173, 95, 114, 24);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"hemano/a", "hijo/a", "padre/madrprimo/a", "tio/a", "familiar"}));
		comboBox_3.setBounds(173, 303, 114, 24);
		contentPane.add(comboBox_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 350, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Bizkaia", "Guipuzkoa", "Albacete", "otros"}));
		comboBox_4.setBounds(540, 59, 114, 24);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Guipuzkoa", "Tarragona", "otros"}));
		comboBox_5.setBounds(540, 95, 114, 24);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Bizkaia ", "Navarra"}));
		comboBox_6.setBounds(540, 132, 114, 24);
		contentPane.add(comboBox_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(540, 174, 114, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(540, 214, 114, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
		comboBox_7.setBounds(541, 256, 114, 24);
		contentPane.add(comboBox_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(540, 306, 114, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(540, 350, 114, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
	}
}
