package pack.osakidetza.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_Estadisticas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_Estadisticas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblEstadisticas = new JLabel("Estadisticas");
		lblEstadisticas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblEstadisticas.setBounds(12, 12, 192, 31);
		contentPane.add(lblEstadisticas);
		
		JLabel lblTipoDeCancer = new JLabel("Tipo de cancer");
		lblTipoDeCancer.setBounds(22, 66, 112, 15);
		contentPane.add(lblTipoDeCancer);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mama", "Ovario", "Trompa", "Otros"}));
		comboBox.setBounds(152, 61, 98, 20);
		contentPane.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(309, 282, 117, 25);
		contentPane.add(btnAceptar);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver)dispose();
			}
		});
		btnVolver.setBounds(180, 282, 117, 25);
		contentPane.add(btnVolver);
		
		JRadioButton rdbtnCasosEnBizkaia = new JRadioButton("Casos en Bizkaia");
		buttonGroup.add(rdbtnCasosEnBizkaia);
		rdbtnCasosEnBizkaia.setBounds(12, 100, 149, 23);
		contentPane.add(rdbtnCasosEnBizkaia);
		
		JRadioButton rdbtnCasosFueraDe = new JRadioButton("Casos fuera de BIzkaia");
		buttonGroup.add(rdbtnCasosFueraDe);
		rdbtnCasosFueraDe.setBounds(12, 140, 192, 23);
		contentPane.add(rdbtnCasosFueraDe);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(266, 102, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(266, 142, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnGestaciones = new JRadioButton("Gestaciones");
		buttonGroup.add(rdbtnGestaciones);
		rdbtnGestaciones.setBounds(12, 183, 149, 23);
		contentPane.add(rdbtnGestaciones);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(266, 185, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnEdadMedia = new JRadioButton("Edad media");
		buttonGroup.add(rdbtnEdadMedia);
		rdbtnEdadMedia.setBounds(12, 229, 149, 23);
		contentPane.add(rdbtnEdadMedia);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(266, 231, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}

}
