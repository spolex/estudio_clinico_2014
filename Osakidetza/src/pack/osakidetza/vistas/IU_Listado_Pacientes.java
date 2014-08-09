package pack.osakidetza.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;

public class IU_Listado_Pacientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtNHistorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Listado_Pacientes frame = new IU_Listado_Pacientes();
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
	public IU_Listado_Pacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblPacientes.setBounds(157, 12, 117, 31);
		contentPane.add(lblPacientes);
		
		JLabel lblCasondice = new JLabel("Caso índice");
		lblCasondice.setBounds(24, 67, 117, 15);
		contentPane.add(lblCasondice);
		
		textField = new JTextField();
		textField.setBounds(157, 65, 234, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(24, 118, 70, 15);
		contentPane.add(lblFecha);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 116, 234, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnListar = new JButton("Aceptar");
		btnListar.setBounds(290, 370, 117, 25);
		contentPane.add(btnListar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(419, 370, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblPacientes_1 = new JLabel("Pacientes");
		lblPacientes_1.setBounds(157, 198, 70, 15);
		contentPane.add(lblPacientes_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 225, 242, 99);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(24, 169, 70, 15);
		contentPane.add(lblPaciente);
		
		txtNHistorial = new JTextField();
		txtNHistorial.setText("nº historial");
		txtNHistorial.setBounds(160, 167, 234, 19);
		contentPane.add(txtNHistorial);
		txtNHistorial.setColumns(10);
		
		JCheckBox chckbxDiagnsticos = new JCheckBox("Diagnósticos");
		chckbxDiagnsticos.setBounds(24, 243, 129, 23);
		contentPane.add(chckbxDiagnsticos);
		
		JCheckBox chckbxVisitas = new JCheckBox("Visitas");
		chckbxVisitas.setBounds(24, 270, 129, 23);
		contentPane.add(chckbxVisitas);
		
		JCheckBox chckbxNuevo = new JCheckBox("Añadir nuevo");
		chckbxNuevo.setBounds(407, 243, 129, 23);
		contentPane.add(chckbxNuevo);
		
		JCheckBox chckbxEliminar = new JCheckBox("Eliminar");
		chckbxEliminar.setBounds(407, 270, 129, 23);
		contentPane.add(chckbxEliminar);
		
		JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		chckbxActualizar.setBounds(407, 297, 129, 23);
		contentPane.add(chckbxActualizar);
		
		JCheckBox chckbxCncer = new JCheckBox("Cáncer");
		chckbxCncer.setBounds(24, 297, 129, 23);
		contentPane.add(chckbxCncer);
	}
}
