package pack.osakidetza.vistas;

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
import javax.swing.JCheckBox;

public class IU_Diagnosticos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Diagnosticos frame = new IU_Diagnosticos();
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
	public IU_Diagnosticos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 415);
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
		
		JButton btnNuevo = new JButton("Aceptar");
		btnNuevo.setBounds(302, 327, 117, 25);
		contentPane.add(btnNuevo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(431, 327, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblGenSecuenciado = new JLabel("Gen secuenciado");
		lblGenSecuenciado.setBounds(12, 120, 161, 15);
		contentPane.add(lblGenSecuenciado);
		
		JLabel lblTipoCancer = new JLabel("Tipo mutación");
		lblTipoCancer.setBounds(12, 163, 133, 15);
		contentPane.add(lblTipoCancer);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(12, 210, 105, 15);
		contentPane.add(lblObservaciones);
		
		JTextPane txtpnNoClaro = new JTextPane();
		txtpnNoClaro.setEnabled(false);
		txtpnNoClaro.setEditable(false);
		txtpnNoClaro.setText("No claro");
		txtpnNoClaro.setBounds(121, 232, 298, 83);
		contentPane.add(txtpnNoClaro);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BRCA1", "BRCA2", "CHEK6"}));
		comboBox_1.setBounds(168, 120, 143, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Si", "Ninguna"}));
		comboBox.setBounds(167, 158, 144, 24);
		contentPane.add(comboBox);
		
		JCheckBox chckbxNuevo = new JCheckBox("Nuevo");
		chckbxNuevo.setBounds(358, 121, 129, 23);
		contentPane.add(chckbxNuevo);
		
		JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		chckbxActualizar.setBounds(358, 159, 129, 23);
		contentPane.add(chckbxActualizar);
		
		JCheckBox chckbxBorrar = new JCheckBox("Borrar");
		chckbxBorrar.setBounds(358, 202, 129, 23);
		contentPane.add(chckbxBorrar);
	}
}
