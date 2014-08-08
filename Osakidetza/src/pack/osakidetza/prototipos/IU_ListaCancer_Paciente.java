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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class IU_ListaCancer_Paciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtHistorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_ListaCancer_Paciente frame = new IU_ListaCancer_Paciente();
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
	public IU_ListaCancer_Paciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCncer = new JLabel("Cáncer");
		lblCncer.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblCncer.setBounds(27, 12, 127, 27);
		contentPane.add(lblCncer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 39, 399, 16);
		contentPane.add(separator);
		
		txtHistorial = new JTextField();
		txtHistorial.setEditable(false);
		txtHistorial.setText("Historial");
		txtHistorial.setBounds(322, 17, 114, 19);
		contentPane.add(txtHistorial);
		txtHistorial.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 69, 70, 15);
		contentPane.add(lblTipo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 67, 272, 76);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Trompa"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(213, 237, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(348, 237, 117, 25);
		contentPane.add(btnAceptar);
		
		JCheckBox chckbxEliminar = new JCheckBox("Eliminar");
		chckbxEliminar.setBounds(12, 151, 129, 23);
		contentPane.add(chckbxEliminar);
		
		JCheckBox chckbxAadir = new JCheckBox("Añadir");
		chckbxAadir.setBounds(160, 151, 129, 23);
		contentPane.add(chckbxAadir);
		
		JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		chckbxActualizar.setBounds(322, 151, 129, 23);
		contentPane.add(chckbxActualizar);
		
		JButton btnEstudios = new JButton("Estudios");
		btnEstudios.setBounds(12, 237, 117, 25);
		contentPane.add(btnEstudios);
	}
}
