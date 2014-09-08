package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.JSeparator;
import javax.swing.JTextField;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Cancer;
import pack.osakidetza.controladoras.Diagnostico;
import pack.osakidetza.enumerados.Gen;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

@SuppressWarnings("serial")
public class IU_Diagnosticos extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textMutacion;

	
	/**
	 * Create the frame.
	 * @param historial 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_Diagnosticos(final String pHistorial) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblDiagnsticos = new JLabel("Diagnósticos genéticos\n");
		lblDiagnsticos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDiagnsticos.setBounds(12, 12, 236, 22);
		contentPane.add(lblDiagnsticos);
		
		JScrollPane scrollDiagnosticos = new JScrollPane();
		scrollDiagnosticos.setBounds(127, 69, 298, 75);
		contentPane.add(scrollDiagnosticos);
		
		JLabel lblGenSecuenciado = new JLabel("Gen secuenciado");
		lblGenSecuenciado.setBounds(12, 189, 161, 15);
		contentPane.add(lblGenSecuenciado);
		
		JLabel lblObservaciones = new JLabel("Observaciones :");
		lblObservaciones.setBounds(12, 287, 114, 15);
		contentPane.add(lblObservaciones);
		
		final JComboBox comboBoxGen = new JComboBox();
		comboBoxGen.setModel(new DefaultComboBoxModel(new String[] {"BRCA1","BRCA2","BRCA1_BRCA2","CHEK2","CDKN2A","CDH1","OTROS"}));
		comboBoxGen.setBounds(168, 184, 143, 25);
		comboBoxGen.setSelectedIndex(-1);
		contentPane.add(comboBoxGen);
		
		final JCheckBox chckbxNuevo = new JCheckBox("Nuevo");
		buttonGroup.add(chckbxNuevo);		
		chckbxNuevo.setBounds(441, 69, 129, 23);
		contentPane.add(chckbxNuevo);
		
		final JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		buttonGroup.add(chckbxActualizar);
		chckbxActualizar.setBounds(441, 121, 129, 23);
		contentPane.add(chckbxActualizar);
		
		final JCheckBox chckbxBorrar = new JCheckBox("Borrar");
		buttonGroup.add(chckbxBorrar);
		chckbxBorrar.setBounds(441, 94, 129, 23);
		contentPane.add(chckbxBorrar);
		
		JScrollPane scrollPaneObservaciones = new JScrollPane();
		scrollPaneObservaciones.setBounds(74, 316, 496, 75);
		contentPane.add(scrollPaneObservaciones);
		
		final JTextPane textObservaciones = new JTextPane();
		scrollPaneObservaciones.setViewportView(textObservaciones);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 245, 70, 15);
		contentPane.add(lblFecha);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(168, 245, 143, 25);
		contentPane.add(dateChooser);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 39, 602, 22);
		contentPane.add(separator);
		
		textMutacion = new JTextField();
		textMutacion.setBounds(471, 248, 143, 22);
		contentPane.add(textMutacion);
		textMutacion.setColumns(10);		
		
		final JList listDiagnosticos = new JList();		
		if(pHistorial!=null)
		{
		    DefaultListModel modelo= new DefaultListModel();	
			Iterator<Diagnostico>itr = C_Doctor.getMiDoctor().listarDiagnosticos(pHistorial);
			while(itr.hasNext())
			{
				Diagnostico diag =itr.next();
				modelo.addElement(diag.getPaciente()+";"+diag.getFecha()+";"+diag.getGenSecuenciado());
			}
			listDiagnosticos.setModel(modelo);
		}
		scrollDiagnosticos.setViewportView(listDiagnosticos);	
		
		final JButton btnNuevo = new JButton("Aceptar");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==btnNuevo)
				{
					//añadir diagnostico.
					//Sólo se podran añadir diagnósticos para pacientes o cánceres ya existentes en el sistema para cumplir las restricciones de integridad.
					if(chckbxNuevo.isSelected())
					{						
						Gen genSecuenciado=null;
						if(comboBoxGen.getSelectedItem()!=null)
						{
							genSecuenciado = Gen.valueOf(comboBoxGen.getSelectedItem().toString());
						}
						
						java.sql.Date fechaDiag = new Date(0);
						if(dateChooser.getDate()!=null)
						{
							fechaDiag = new java.sql.Date (dateChooser.getDate().getTime());
						}
						
						Diagnostico nuevo = new Diagnostico(pHistorial, genSecuenciado, textMutacion.getText(), textObservaciones.getText(),
								fechaDiag);
						if(C_Doctor.getMiDoctor().addDiagnostico(nuevo))
						{
							JOptionPane.showMessageDialog(null, "Diagnóstico genético añadido con éxito al sistema", "Control diagnóstico genético", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Error al intentar añadir el diagnóstico genético", "Control diagnóstico genético", JOptionPane.ERROR_MESSAGE);
						}
					}
					//borrar diagnostico.
					if(chckbxBorrar.isSelected())
					{
						if(!listDiagnosticos.isSelectionEmpty())
						{
							Iterator<Diagnostico> itr = C_Doctor.getMiDoctor().listarDiagnosticos(pHistorial);
							String seleccionado = (String) listDiagnosticos.getSelectedValue();
							String[] diagnostico = seleccionado.split(";");
							boolean enc=false;
							while(itr.hasNext() && !enc)
							{
								Diagnostico diag =itr.next();
								
								String gen = "";
								if(diag.getGenSecuenciado()!=null)gen = diag.getGenSecuenciado().toString();
								
								java.sql.Date fecha = new Date(0);
								try 
								{
									fecha = new java.sql.Date (new SimpleDateFormat("yyyy-MM-dd").parse(diagnostico[1]).getTime());
								} 
								catch (ParseException e1) 
								{
									JOptionPane.showMessageDialog(null, "Error en el formato de la fecha", "Control de diagnósticos", JOptionPane.ERROR_MESSAGE);
								}
								java.sql.Date fechaDiag = new Date(0);
								if(diag.getFecha()!=null)fechaDiag=diag.getFecha();								

								if(pHistorial.equals(diag.getPaciente()) && diagnostico[2].equals(gen) && fecha.equals(fechaDiag))
								{
									enc=true;
									if(C_Doctor.getMiDoctor().eliminarDiagnostico(diag))
									{
										JOptionPane.showMessageDialog(null, "Diagnóstico genético eliminado!!", "Control de diagnósticos genéticos", JOptionPane.INFORMATION_MESSAGE);
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Imposible eliminar diagnóstico genético", "Control diagnósticos genéticos", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
							if(!enc)JOptionPane.showMessageDialog(null, "El diagnóstico genético no se encuentra registrado en el sistema", "Control diagnósticos genéticos", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Seleccione el diagnóstico genético que desea borrar", "Control diagnósticos genéticos", JOptionPane.ERROR_MESSAGE);
						}
					}
					//actualizar diagnóstico.
					if(chckbxActualizar.isSelected())
					{
						Diagnostico diag1 = null;
						if(!listDiagnosticos.isSelectionEmpty())
						{
							Iterator<Diagnostico> itrDiagnostico = C_Doctor.getMiDoctor().listarDiagnosticos(pHistorial);
							String seleccionado = (String) listDiagnosticos.getSelectedValue();
							String[] diagnostico = seleccionado.split(";");
							boolean enc=false;
							while(itrDiagnostico.hasNext() && !enc)
							{
							     diag1 =itrDiagnostico.next();
								
								String gen = "";
								if(diag1.getGenSecuenciado()!=null)gen = diag1.getGenSecuenciado().toString();
								
								java.sql.Date fecha = new Date(0);
								try 
								{
									fecha = new java.sql.Date (new SimpleDateFormat("yyyy-MM-dd").parse(diagnostico[1]).getTime());
								} 
								catch (ParseException e1) 
								{
									JOptionPane.showMessageDialog(null, "Error en el formato de la fecha", "Control de diagnósticos", JOptionPane.ERROR_MESSAGE);
								}
								java.sql.Date fechaDiag = new Date(0);
								if(diag1.getFecha()!=null)fechaDiag=diag1.getFecha();								

								if(pHistorial.equals(diag1.getPaciente()) && diagnostico[2].equals(gen) && fecha.equals(fechaDiag))
								{
									Iterator <Cancer> itrCancer = C_Doctor.getMiDoctor().listarCancer(pHistorial);
									while(itrCancer.hasNext())
									{
										Cancer cancer = itrCancer.next();
										comboBoxGen.setSelectedItem(gen);										
										dateChooser.setDate(fechaDiag);
										textMutacion.setText(diag1.getMutacion());
										textObservaciones.setText(diag1.getResultado());										
									}
									//listener key Enter para actualizar.
									final Diagnostico diagOld=diag1;
									KeyListener	keyListen =new KeyAdapter(){
										public void keyPressed(KeyEvent key){
											if(key.getKeyCode() == KeyEvent.VK_ENTER){
																								
												Gen genSecuenciado=null;
												if(comboBoxGen.getSelectedItem()!=null)
												{
													genSecuenciado = Gen.valueOf(comboBoxGen.getSelectedItem().toString());
												}
												
												java.sql.Date fechaDiag = new Date(0);
												if(dateChooser.getDate()!=null)
												{
													fechaDiag = new java.sql.Date (dateChooser.getDate().getTime());
												}
												
												Diagnostico actualizado = new Diagnostico(pHistorial, genSecuenciado, textMutacion.getText(), textObservaciones.getText(),
														fechaDiag);
											    
												if(C_Doctor.getMiDoctor().actualizarDiagnostico(diagOld,actualizado))
												{
													JOptionPane.showMessageDialog(null, "Diagnóstico genético actualizado con éxito", "Control diagnóstico genético", JOptionPane.INFORMATION_MESSAGE);
													dispose();
												}
												else
												{
													JOptionPane.showMessageDialog(null, "Imposible actualizar el diagnóstico genético", "Control diagnóstico genético", JOptionPane.ERROR_MESSAGE);
												}
											}
										}
									};
									btnNuevo.addKeyListener(keyListen);
									chckbxActualizar.addKeyListener(keyListen);
									addKeyListener(keyListen);
									textObservaciones.addKeyListener(keyListen);
									textMutacion.addKeyListener(keyListen);
									comboBoxGen.addKeyListener(keyListen);
									listDiagnosticos.addKeyListener(keyListen);
									
									enc=true;
								}									
							}
							if(!enc)JOptionPane.showMessageDialog(null, "El diagnóstico genético no se encuentra registrado en el sistema", "Control diagnósticos genéticos", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Seleccione el diagnóstico genético que desea actualizar", "Control diagnósticos genéticos", JOptionPane.ERROR_MESSAGE);
						}																
					}
				}
			}
		});
		btnNuevo.setBounds(182, 430, 117, 25);
		contentPane.add(btnNuevo);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver)dispose();
			}
		});
		btnVolver.setBounds(332, 430, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblMutacon = new JLabel("Mutación");
		lblMutacon.setBounds(332, 255, 70, 15);
		contentPane.add(lblMutacon);	
		
	}
}
