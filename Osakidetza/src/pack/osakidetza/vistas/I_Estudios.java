package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Estudio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class I_Estudios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNHistorial;
	private JTextField txtTipoCancer;
	private HashMap<String, Estudio> estudios;



	/**
	 * Create the frame.
	 * @param seleccionado 
	 * @param pHistorial 
	 * @param fecha 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public I_Estudios(final String pHistorial, final String tipo, final String fecha) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		estudios = new HashMap<String, Estudio>(); 
		
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
			String[] values = new String[] {};
			public int getSize() 
			{
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		DefaultListModel model = new DefaultListModel();
		java.sql.Date pFecha = new java.sql.Date(0);
		try 
		{
			pFecha = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(fecha).getTime());
		} 
		catch (ParseException e) 
		{
			JOptionPane.showMessageDialog(null, "Incompatibilidad en el formato de fechas", "Control Estudios patológicos", JOptionPane.ERROR_MESSAGE);
		}
		Iterator <Estudio> itr = C_Doctor.getMiDoctor().listarEstudios(pHistorial,tipo, pFecha);
		while(itr.hasNext())
		{
			Estudio estudio = itr.next();
			model.addElement(estudio.getCode()+";"+estudio.getFecha().toString());
			estudios.put(estudio.getCode(), estudio);
		}
		list.setModel(model);
		scrollPane.setViewportView(list);
		
		txtNHistorial = new JTextField();
		txtNHistorial.setEditable(false);
		txtNHistorial.setText("nº historial");
		txtNHistorial.setBounds(322, 20, 114, 19);
		contentPane.add(txtNHistorial);
		txtNHistorial.setColumns(10);
		txtNHistorial.setText(pHistorial);
		
		txtTipoCancer = new JTextField();
		txtTipoCancer.setEditable(false);
		txtTipoCancer.setText("tipo cancer");
		txtTipoCancer.setBounds(158, 20, 114, 19);
		contentPane.add(txtTipoCancer);
		txtTipoCancer.setColumns(10);
		txtTipoCancer.setText(tipo);
		
		final JCheckBox chckbxNuevo = new JCheckBox("Nuevo");
		chckbxNuevo.setBounds(22, 168, 129, 23);
		contentPane.add(chckbxNuevo);
		
		final JCheckBox chckbxEliminar = new JCheckBox("Eliminar");
		chckbxEliminar.setBounds(158, 168, 129, 23);
		contentPane.add(chckbxEliminar);
		
		final JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		chckbxActualizar.setBounds(291, 168, 129, 23);
		contentPane.add(chckbxActualizar);
		
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancelar)dispose();
			}
		});
		btnCancelar.setBounds(319, 237, 117, 25);
		contentPane.add(btnCancelar);
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (e.getSource()==btnAceptar)
				{
					//Actualizar estudio
					if(chckbxActualizar.isSelected())
					{
						
					}
					//Borrar estudio
					if(chckbxEliminar.isSelected())
					{
						
					}
					//Nuevo estudio
					if(chckbxNuevo.isSelected())
					{
						java.sql.Date pFecha = new java.sql.Date(0);
						try 
						{
							pFecha = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(fecha).getTime());
						} 
						catch (ParseException e1) 
						{
							JOptionPane.showMessageDialog(null, "Incompatibilidad en el formato de fechas", "Control Estudios patológicos", JOptionPane.ERROR_MESSAGE);
						}
						IU_FormEstudio IU_Estudio = new IU_FormEstudio(pHistorial,tipo,pFecha);
						IU_Estudio.setVisible(true);
					}
					
				}
			}
		});
		btnAceptar.setBounds(190, 237, 117, 25);
		contentPane.add(btnAceptar);
		
		
	}
}
