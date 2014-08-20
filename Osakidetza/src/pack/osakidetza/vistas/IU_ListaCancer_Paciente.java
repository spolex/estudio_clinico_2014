package pack.osakidetza.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({"serial" })
public class IU_ListaCancer_Paciente extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_ListaCancer_Paciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblCncer = new JLabel("Cáncer");
		lblCncer.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblCncer.setBounds(27, 12, 127, 27);
		contentPane.add(lblCncer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 39, 399, 16);
		contentPane.add(separator);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 69, 70, 15);
		contentPane.add(lblTipo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 67, 272, 76);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		final JCheckBox chckbxEliminar = new JCheckBox("Eliminar");
		buttonGroup.add(chckbxEliminar);
		chckbxEliminar.setBounds(12, 151, 129, 23);
		contentPane.add(chckbxEliminar);
		
		final JCheckBox chckbxAadir = new JCheckBox("Añadir");
		buttonGroup.add(chckbxAadir);
		chckbxAadir.setBounds(160, 151, 129, 23);
		contentPane.add(chckbxAadir);
		
		final JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		buttonGroup.add(chckbxActualizar);
		chckbxActualizar.setBounds(322, 151, 129, 23);
		contentPane.add(chckbxActualizar);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancelar)dispose();
			}
		});
		btnCancelar.setBounds(213, 237, 117, 25);
		contentPane.add(btnCancelar);
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAceptar){
					if(chckbxAadir.isSelected()){
						IU_FormCancer IU_FC = new IU_FormCancer();
						IU_FC.setVisible(true);
					}
					else if(chckbxActualizar.isSelected()){
						
					}
					else if(chckbxEliminar.isSelected()){
						
					}
				}
			}
		});
		btnAceptar.setBounds(348, 237, 117, 25);
		contentPane.add(btnAceptar);		
		
		JButton btnEstudios = new JButton("Estudios");
		btnEstudios.setBounds(12, 237, 117, 25);
		contentPane.add(btnEstudios);
		
		JLabel lblHistorial = new JLabel("");
		lblHistorial.setBounds(309, 19, 127, 15);
		contentPane.add(lblHistorial);
	}
}
