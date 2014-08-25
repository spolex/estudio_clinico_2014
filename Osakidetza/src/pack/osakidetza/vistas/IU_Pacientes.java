package pack.osakidetza.vistas;

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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class IU_Pacientes extends JFrame {

	private JPanel contentPane;
	private JTextField textCI;
	private JTextField txtNHistorial;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String historial;

	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_Pacientes(final String pEmail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		historial=new String();
		
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblCasondice = new JLabel("Caso índice");
		
		textCI = new JTextField();
		textCI.setColumns(10);
		
		txtNHistorial = new JTextField();
		txtNHistorial.setColumns(10);
		
		JPanel funcionalidadesPanel = new JPanel();
		
		
		final JCheckBox chckbxDiagnosticos = new JCheckBox("Diagnósticos");
		buttonGroup.add(chckbxDiagnosticos);
		
		final JCheckBox chckbxVisitas = new JCheckBox("Visitas");
		buttonGroup.add(chckbxVisitas);
		
		final JCheckBox chckbxCancer = new JCheckBox("Cancer\n");
		buttonGroup.add(chckbxCancer);
		
		final JCheckBox chckbxNuevo = new JCheckBox("Añadir nuevo");
		buttonGroup.add(chckbxNuevo);
		final JCheckBox chckbxBuscar = new JCheckBox("Buscar");
		buttonGroup.add(chckbxBuscar);
		
		final JCheckBox chckbxEliminar = new JCheckBox("Eliminar");
		buttonGroup.add(chckbxEliminar);
		
		final JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		buttonGroup.add(chckbxActualizar);
		GroupLayout gl_funcionalidadesPanel = new GroupLayout(funcionalidadesPanel);
		gl_funcionalidadesPanel.setHorizontalGroup(
			gl_funcionalidadesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_funcionalidadesPanel.createSequentialGroup()
					.addGroup(gl_funcionalidadesPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_funcionalidadesPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(chckbxBuscar))
						.addGroup(gl_funcionalidadesPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(chckbxNuevo)))
					.addGap(3))
				.addGroup(gl_funcionalidadesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxEliminar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(40))
				.addGroup(gl_funcionalidadesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxActualizar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(25))
		);
		gl_funcionalidadesPanel.setVerticalGroup(
			gl_funcionalidadesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_funcionalidadesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxNuevo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxBuscar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxEliminar, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxActualizar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(15))
		);
		funcionalidadesPanel.setLayout(gl_funcionalidadesPanel);
		
		
		JScrollPane scrollPane = new JScrollPane();

		final JList listPacientes = new JList();
		listPacientes.setSelectedIndex(-1);
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
				if(e.getSource()==btnAceptar)
				{
					//Añadir paciente
					if(chckbxNuevo.isSelected()){
						IU_FormPaciente IU_FP= new IU_FormPaciente(null);
						IU_FP.setVisible(true);
					}
					//borrar paciente
					if(chckbxEliminar.isSelected()){
						if(!listPacientes.isSelectionEmpty()){
							IU_FastIdent IU_FI= new IU_FastIdent("",historial,false,true,null);					
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
							else{
								JOptionPane.showMessageDialog(null, "El paciente con el nº de historial "+txtNHistorial.getText()+" no se encuentra registrado en el sistema", "Control de pacientes", JOptionPane.ERROR_MESSAGE);
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
					//actualizar paciente
					else if(chckbxActualizar.isSelected()){	
						if(listPacientes.getSelectedValue()!=null)
						{							
							Paciente pacienteCurrent = C_Doctor.getMiDoctor().obtenerPaciente(historial);
							IU_FormPaciente IU_FP= new IU_FormPaciente(pacienteCurrent);
							IU_FP.setVisible(true);	
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Seleccione el paciente que desea actualizar.");
						}
					}
					//listar cáncer dado paciente.
					else if(chckbxCancer.isSelected()){						
						if(!listPacientes.isSelectionEmpty()){
							IU_ListaCancer IU_Lista= new IU_ListaCancer(historial);		
							IU_Lista.setVisible(true);	
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No ha escogido un paciente para consultar");
						}
						
					}
					//listar diagnosticos paciente
					else if(chckbxDiagnosticos.isSelected())
					{
						if(!listPacientes.isSelectionEmpty())
						{
						    IU_Diagnosticos IU_D = new IU_Diagnosticos(historial);
							IU_D.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Debe elegir un paciente");
						}
					}
					//listar visitas dado un paciente
					else if(chckbxVisitas.isSelected())
					{
						if(listPacientes.isSelectionEmpty())
						{
							JOptionPane.showMessageDialog(null, "Seleccione el paciente del que desea consultar las visitas", "Control PAciente", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							IU_ListaVisitas IU_LV = new IU_ListaVisitas(pEmail,historial,null,null);
							IU_LV.setVisible(true);
						}
					}
					else if(buttonGroup.getSelection()==null)
					{
						JOptionPane.showMessageDialog(null, "Seleccione la funcionalidad que desea ejecutar", "Control Paciente", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver)dispose();
			}
		});
		
		JLabel lblPacientes_1 = new JLabel("Pacientes");
		
		
		JLabel lblPaciente = new JLabel("Paciente");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(152)
					.addComponent(lblPacientes, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(269))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblCasondice, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(16)
					.addComponent(textCI, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addGap(152))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblPaciente, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(63)
					.addComponent(txtNHistorial, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
					.addGap(152))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(152)
					.addComponent(lblPacientes_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(316))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxDiagnosticos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chckbxVisitas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(44))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chckbxCancer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(43)))
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(funcionalidadesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(7))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(285)
					.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(7))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblPacientes, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCasondice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(2))
						.addComponent(textCI))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblPaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(2))
						.addComponent(txtNHistorial))
					.addGap(29)
					.addComponent(lblPacientes_1, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chckbxDiagnosticos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(17)
							.addComponent(chckbxVisitas, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(chckbxCancer, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addGap(7))
						.addComponent(funcionalidadesPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(7))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
