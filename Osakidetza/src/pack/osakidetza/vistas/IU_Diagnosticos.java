package pack.osakidetza.vistas;

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
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class IU_Diagnosticos extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_Diagnosticos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDiagnsticos = new JLabel("Diagnósticos genéticos\n");
		lblDiagnsticos.setBounds(12, 12, 166, 15);
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
		btnNuevo.setBounds(288, 352, 117, 25);
		contentPane.add(btnNuevo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(417, 352, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblGenSecuenciado = new JLabel("Gen secuenciado");
		lblGenSecuenciado.setBounds(12, 120, 161, 15);
		contentPane.add(lblGenSecuenciado);
		
		JLabel lblTipoCancer = new JLabel("Tipo mutación");
		lblTipoCancer.setBounds(12, 163, 133, 15);
		contentPane.add(lblTipoCancer);
		
		JLabel lblObservaciones = new JLabel("Observaciones :");
		lblObservaciones.setBounds(12, 233, 114, 15);
		contentPane.add(lblObservaciones);
		
		JTextPane txtpnNoClaro = new JTextPane();
		txtpnNoClaro.setEnabled(false);
		txtpnNoClaro.setEditable(false);
		txtpnNoClaro.setText("No claro");
		txtpnNoClaro.setBounds(121, 257, 298, 83);
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
		buttonGroup.add(chckbxNuevo);
		chckbxNuevo.setBounds(418, 121, 129, 23);
		contentPane.add(chckbxNuevo);
		
		JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		buttonGroup.add(chckbxActualizar);
		chckbxActualizar.setBounds(418, 159, 129, 23);
		contentPane.add(chckbxActualizar);
		
		JCheckBox chckbxBorrar = new JCheckBox("Borrar");
		buttonGroup.add(chckbxBorrar);
		chckbxBorrar.setBounds(417, 195, 129, 23);
		contentPane.add(chckbxBorrar);
	}
}
