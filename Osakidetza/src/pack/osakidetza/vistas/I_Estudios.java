package pack.osakidetza.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;

public class I_Estudios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNHistorial;
	private JTextField txtTipoCancer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					I_Estudios frame = new I_Estudios();
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
	public I_Estudios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstudios = new JLabel("Estudios");
		lblEstudios.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblEstudios.setBounds(12, 12, 233, 32);
		contentPane.add(lblEstudios);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 42, 424, 15);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 54, 414, 88);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"12", "13", "15", "16", "19", "136", "1444"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		txtNHistorial = new JTextField();
		txtNHistorial.setEditable(false);
		txtNHistorial.setText("nº historial");
		txtNHistorial.setBounds(322, 20, 114, 19);
		contentPane.add(txtNHistorial);
		txtNHistorial.setColumns(10);
		
		txtTipoCancer = new JTextField();
		txtTipoCancer.setEditable(false);
		txtTipoCancer.setText("tipo cancer");
		txtTipoCancer.setBounds(158, 20, 114, 19);
		contentPane.add(txtTipoCancer);
		txtTipoCancer.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(319, 237, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(190, 237, 117, 25);
		contentPane.add(btnAceptar);
		
		JCheckBox chckbxNuevo = new JCheckBox("Nuevo");
		chckbxNuevo.setBounds(22, 168, 129, 23);
		contentPane.add(chckbxNuevo);
		
		JCheckBox chckbxEliminar = new JCheckBox("Eliminar");
		chckbxEliminar.setBounds(158, 168, 129, 23);
		contentPane.add(chckbxEliminar);
		
		JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		chckbxActualizar.setBounds(291, 168, 129, 23);
		contentPane.add(chckbxActualizar);
	}
}
