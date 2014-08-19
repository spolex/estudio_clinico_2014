package pack.osakidetza.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import com.toedter.calendar.JDateChooser;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

@SuppressWarnings("serial")
public class IU_Pacientes extends JFrame {

	private JPanel contentPane;
	private JTextField textCI;
	private JTextField txtNHistorial;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String historial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Pacientes frame = new IU_Pacientes();
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
	public IU_Pacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		historial=new String();
		
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblPacientes.setBounds(157, 12, 117, 31);
		contentPane.add(lblPacientes);
		
		JLabel lblCasondice = new JLabel("Caso índice");
		lblCasondice.setBounds(24, 67, 117, 15);
		contentPane.add(lblCasondice);
		
		textCI = new JTextField();
		textCI.setBounds(157, 65, 234, 19);
		contentPane.add(textCI);
		textCI.setColumns(10);
		
		txtNHistorial = new JTextField();
		txtNHistorial.setBounds(160, 167, 234, 19);
		contentPane.add(txtNHistorial);
		txtNHistorial.setColumns(10);			
		
		JLabel lblFecha = new JLabel("Fecha alta");
		lblFecha.setBounds(24, 118, 74, 15);
		contentPane.add(lblFecha);		
		
		JCheckBox chckbxDiagnosticos = new JCheckBox("Diagnósticos");
		buttonGroup.add(chckbxDiagnosticos);
		chckbxDiagnosticos.setBounds(24, 243, 117, 23);
		contentPane.add(chckbxDiagnosticos);
		
		final JCheckBox chckbxNuevo = new JCheckBox("Añadir nuevo");
		buttonGroup.add(chckbxNuevo);
		chckbxNuevo.setBounds(407, 243, 129, 23);
		contentPane.add(chckbxNuevo);
		
		final JCheckBox chckbxEliminar = new JCheckBox("Eliminar");
		buttonGroup.add(chckbxEliminar);
		chckbxEliminar.setBounds(407, 270, 129, 23);
		contentPane.add(chckbxEliminar);
		
		final JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		buttonGroup.add(chckbxActualizar);
		chckbxActualizar.setBounds(407, 297, 129, 23);
		contentPane.add(chckbxActualizar);
		
		JCheckBox chckbxVisitas = new JCheckBox("Visitas");
		buttonGroup.add(chckbxVisitas);
		chckbxVisitas.setBounds(24, 274, 73, 23);
		contentPane.add(chckbxVisitas);
		
		JCheckBox chckbxCancer = new JCheckBox("Cancer\n");
		buttonGroup.add(chckbxCancer);
		chckbxCancer.setBounds(24, 301, 74, 23);
		contentPane.add(chckbxCancer);
		final JCheckBox chckbxBuscar = new JCheckBox("Buscar");
		buttonGroup.add(chckbxBuscar);
		chckbxBuscar.setBounds(407, 223, 129, 23);
		contentPane.add(chckbxBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 225, 242, 99);
		contentPane.add(scrollPane);		

		final JList listPacientes = new JList();
		listPacientes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					historial = (String) listPacientes.getSelectedValue();
				}
			}
		});
		scrollPane.setViewportView(listPacientes);
		listPacientes.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAceptar){
					//Añadir paciente
					if(chckbxNuevo.isSelected()){
						IU_FormPaciente IU_FP= new IU_FormPaciente(null);
						IU_FP.setVisible(true);
					}
					//borrar paciente
					if(chckbxEliminar.isSelected()){
						if(!listPacientes.isSelectionEmpty()){
							IU_FastIdent IU_FI= new IU_FastIdent("",historial,false,true);					
							IU_FI.setVisible(true);	
						}
						else{
							JOptionPane.showMessageDialog(null, "No ha escogido un paciente para eliminar");
						}
					}
					//obtener pacientes
					if(chckbxBuscar.isSelected())
					//Buscar paciente dado historial
					{
					    if(txtNHistorial.getText().length()>0){
					    	String paciente = C_Doctor.getMiDoctor().buscarPaciente(txtNHistorial.getText());
							if(paciente!=null){
								DefaultListModel encontrado = new DefaultListModel();
								encontrado.addElement(paciente);
								listPacientes.setModel(encontrado);
							}
					    }
					//listar pacientes dado ci
					    else if(textCI.getText().length()>0){
					    	String CI = textCI.getText();
					    	ArrayList<String> listaPacientesDCI = C_Doctor.getMiDoctor().listarPacientesDado(CI);
					    	java.util.Iterator<String> itr = listaPacientesDCI.iterator();
							DefaultListModel modelo = new DefaultListModel();
					    	while(itr.hasNext()){
					    		modelo.addElement(itr.next());
					    	}
					    	listPacientes.setModel(modelo);
					    }
					//listar pacientes
					    else{	
					    	ArrayList<String> listaPacientes = C_Doctor.getMiDoctor().listarPacientes();
					    	java.util.Iterator<String> itr = listaPacientes.iterator();
					    	DefaultListModel modelo =new DefaultListModel();
					    	while(itr.hasNext()){
					    		modelo.addElement(itr.next());
					    	}
					    	listPacientes.setModel(modelo);
					    }
				    }
					if(chckbxActualizar.isSelected()){
						
						Paciente pacienteCurrent = C_Doctor.getMiDoctor().obtenerPaciente(historial);
						IU_FormPaciente IU_FP= new IU_FormPaciente(pacienteCurrent);
						IU_FP.setVisible(true);
						
					}
				}
			}
		});
		btnAceptar.setBounds(290, 370, 117, 25);
		contentPane.add(btnAceptar);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver)dispose();
			}
		});
		btnVolver.setBounds(419, 370, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblPacientes_1 = new JLabel("Pacientes");
		lblPacientes_1.setBounds(157, 198, 70, 15);
		contentPane.add(lblPacientes_1);		
		
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(24, 169, 70, 15);
		contentPane.add(lblPaciente);		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(157, 118, 242, 19);
		contentPane.add(dateChooser);
		
		
	}
}
