package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
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

import pack.osakidetza.aux.MyFormatter;
import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Estudio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class I_Estudios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNHistorial;
	private JTextField txtTipoCancer;
	private HashMap<String, Estudio> estudios;
	private final ButtonGroup buttonGroup = new ButtonGroup();



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
		
		final JList list = new JList();
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
		final DefaultListModel model = new DefaultListModel();
		java.sql.Date pFecha = new java.sql.Date(0);
		pFecha = MyFormatter.parseSQLDate(fecha);
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
		buttonGroup.add(chckbxNuevo);
		chckbxNuevo.setBounds(22, 168, 129, 23);
		contentPane.add(chckbxNuevo);
		
		final JCheckBox chckbxEliminar = new JCheckBox("Eliminar");
		buttonGroup.add(chckbxEliminar);
		chckbxEliminar.setBounds(158, 168, 129, 23);
		contentPane.add(chckbxEliminar);
		
		final JCheckBox chckbxVer = new JCheckBox("Ver");
		buttonGroup.add(chckbxVer);
		chckbxVer.setBounds(291, 168, 129, 23);
		contentPane.add(chckbxVer);		
		
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
					if(list.isSelectionEmpty())
					{
						JOptionPane.showMessageDialog(null, "Seleccione el Estudio Patológico que desea borrar", "Control de Estudios patológicos", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						//Borrar estudio
						if(chckbxEliminar.isSelected())
						{
						
							java.sql.Date pFecha = new java.sql.Date(0);
							pFecha=MyFormatter.parseSQLDate(fecha);
							String seleccionado = list.getSelectedValue().toString();
							String[] key = seleccionado.split(";");
							if(C_Doctor.getMiDoctor().eliminarEstudio(estudios.get(key[0]), pFecha))
								{	
									JOptionPane.showMessageDialog(null, "Estudio Patológico seleccionado eliminado del sistema", "Control Estudios Patológicos", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Imposible borrar del sistema el Estudio Patológico seleccionado","Control Estudios Patológicos",JOptionPane.ERROR_MESSAGE);
								}
						}
						//Nuevo estudio
						if(chckbxNuevo.isSelected())
						{
							java.sql.Date pFecha =MyFormatter.parseSQLDate(fecha);
							IU_FormEstudio IU_Estudio = new IU_FormEstudio(pHistorial,tipo,pFecha, null);
							IU_Estudio.setVisible(true);
							dispose();
						}
						//ver estudio
						if(chckbxVer.isSelected())
						{
							java.sql.Date pFecha = new java.sql.Date(0);
							pFecha=MyFormatter.parseSQLDate(fecha);
							String seleccionado = list.getSelectedValue().toString();
							String[] key = seleccionado.split(";");
							Estudio estudio = estudios.get(key[0]);
							IU_FormEstudio IU_FE = new IU_FormEstudio(estudio.getPaciente(), estudio.getTipo().toString(), pFecha, estudio);
							IU_FE.setVisible(true);
						}
					}
				}	
			}
		});
		btnAceptar.setBounds(190, 237, 117, 25);
		contentPane.add(btnAceptar);	
	}	
}
