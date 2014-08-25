package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ListSelectionModel;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Cancer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

@SuppressWarnings({"serial" })
public class IU_ListaCancer extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 * @param pHistorial 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_ListaCancer(final String pHistorial) {
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
		
		final JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		if(pHistorial!=null){
			
			Iterator<Cancer> itr =C_Doctor.getMiDoctor().listarCancer(pHistorial);
			DefaultListModel modelo = new DefaultListModel();
			while(itr.hasNext()){
				Cancer cancer = itr.next();
				modelo.addElement(cancer.getTipo()+";"+cancer.getFecha());
			}
			list.setModel(modelo);
			list.setSelectedIndex(-1);
		}
		
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
					//añadir cancer
					if(chckbxAadir.isSelected()){
						IU_FormCancer IU_FC = new IU_FormCancer(pHistorial,null);
						IU_FC.setVisible(true);
					}
					//Actualizar cancer
					else if(chckbxActualizar.isSelected())
					{
						Iterator<Cancer> itr = C_Doctor.getMiDoctor().listarCancer(pHistorial);
						boolean enc = false;
						boolean seleccion = false;
						while(itr.hasNext()&& !enc && !seleccion)
						{
							try
							{
								String cancer= (String) list.getSelectedValue();
								Cancer pCancer=itr.next();
								String[] cancerAux = cancer.split(";");
								if(cancerAux[0].equals(pCancer.getTipo().toString()) && cancerAux[1].equals(pCancer.getFecha().toString())){
									enc=true;
									IU_FormCancer IU_FC= new IU_FormCancer(pHistorial, pCancer);
									IU_FC.setVisible(true);
								}
							}
							catch(NullPointerException n)
							{
								JOptionPane.showMessageDialog(null, "No ha seleccionado ningún cáncer para actualizar", "Control cáncer", JOptionPane.ERROR_MESSAGE);
								seleccion=true;
							}
						}
						if(!enc && !seleccion)
						{
							JOptionPane.showMessageDialog(null, "El cancer seleccionado no se encuentra en el sistema", "Control cáncer", JOptionPane.ERROR_MESSAGE);
						}
					}
					else if(chckbxEliminar.isSelected())
					{
						boolean enc = false;
						boolean eliminado=false;
						if(list.isSelectionEmpty())
						{
							JOptionPane.showMessageDialog(null, "Seleccione el cáncer que desea eliminar", "Control cáncer", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							//Comprobamos que existe 
							
							if(list.isSelectionEmpty())
							{
								JOptionPane.showMessageDialog(null, "Seleccione el cáncer que desea eliminar", "Control cáncer", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								Iterator<Cancer> itr = C_Doctor.getMiDoctor().listarCancer(pHistorial);
							
								while(itr.hasNext()&&!enc){
									String cancer= (String) list.getSelectedValue();
									Cancer pCancer=itr.next();
									String[] cancerAux = cancer.split(";");
									if(cancerAux[0].equals(pCancer.getTipo().toString()) && cancerAux[1].equals(pCancer.getFecha().toString())){
										eliminado = C_Doctor.getMiDoctor().eliminarCancer(pCancer);
										enc=true;
									}
								}
							}
							if(eliminado){
								JOptionPane.showMessageDialog(null, "Eliminado con éxito");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "No ha sido posible eliminar");

							}
						}
					}
				}
			}
		});
		btnAceptar.setBounds(348, 237, 117, 25);
		contentPane.add(btnAceptar);		
		
		final JButton btnEstudios = new JButton("Estudios");
		btnEstudios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==btnEstudios)
				{
					if(list.isSelectionEmpty())
					{
						JOptionPane.showMessageDialog(null, "Seleccione el cáncer del que desea visualizar los Estudios patológicos", "Control cáncer", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						String item = (String) list.getSelectedValue();
						String[] seleccionado = item.split(";");
						I_Estudios I_E= new I_Estudios(pHistorial,seleccionado[0],seleccionado[1]);
						I_E.setVisible(true);
					}					
				}
			}
		});
		btnEstudios.setBounds(12, 237, 117, 25);
		contentPane.add(btnEstudios);
		
		JLabel lblHistorial = new JLabel("");
		lblHistorial.setBounds(309, 19, 127, 15);
		contentPane.add(lblHistorial);
	}
}
