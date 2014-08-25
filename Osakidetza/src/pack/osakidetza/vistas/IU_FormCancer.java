package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Cancer;
import pack.osakidetza.enumerados.Mama;
import pack.osakidetza.enumerados.TipoCancer;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

@SuppressWarnings("serial")
public class IU_FormCancer extends JFrame {

	private JPanel contentPane;
	private JTextField textHistorial;
	
	/**
	 * Create the frame.
	 * @param historial 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_FormCancer(final String pHistorial,final Cancer pCancer) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		
		JLabel lblCancer = new JLabel("Cancer");
		lblCancer.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblCancer.setBounds(15, 12, 158, 40);
		contentPane.add(lblCancer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 57, 421, 9);
		contentPane.add(separator);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(25, 81, 99, 15);
		contentPane.add(lblPaciente);
		
		textHistorial = new JTextField();
		textHistorial.setBounds(186, 78, 114, 19);
		contentPane.add(textHistorial);
		textHistorial.setColumns(10);
		textHistorial.setText(pHistorial);
		textHistorial.setEnabled(false);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(25, 121, 70, 15);
		contentPane.add(lblTipo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(25, 159, 70, 15);
		contentPane.add(lblFecha);
		
		final JComboBox comboBox_tipo_Mama = new JComboBox();
		comboBox_tipo_Mama.setModel(new DefaultComboBoxModel(new String[] {"izquierda", "derecha"}));	
		comboBox_tipo_Mama.setBounds(330, 116, 106, 24);
		comboBox_tipo_Mama.setSelectedIndex(-1);
		contentPane.add(comboBox_tipo_Mama);
		
		final JComboBox comboBoxtipo = new JComboBox();
		comboBoxtipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!e.getItem().equals("mama"))
				{	
					comboBox_tipo_Mama.setSelectedIndex(-1);
					comboBox_tipo_Mama.setVisible(false);					
				}	
				else
				{
					comboBox_tipo_Mama.setVisible(true);
				}
			}
		});
		comboBoxtipo.setModel(new DefaultComboBoxModel(new String[] {"trompa", "mama", "ovario", "otro"}));
		comboBoxtipo.setBounds(186, 116, 114, 20);
		comboBoxtipo.setSelectedIndex(-1);
		contentPane.add(comboBoxtipo);
		
		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setBounds(25, 258, 125, 15);
		contentPane.add(lblTratamiento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 285, 386, 66);
		contentPane.add(scrollPane);
		
		final JTextPane textTratamiento = new JTextPane();
		scrollPane.setViewportView(textTratamiento);
		
		final JDateChooser dateFecha = new JDateChooser();
		dateFecha.setBounds(186, 159, 114, 19);
		contentPane.add(dateFecha);
		
		if(pCancer!=null){
			textHistorial.setText(pCancer.getPaciente());
			comboBoxtipo.setSelectedItem(pCancer.getTipo().toString());
			comboBox_tipo_Mama.setSelectedItem(pCancer.getMama().toString());
			dateFecha.setDate(new java.util.Date(pCancer.getFecha().getTime()));
			textTratamiento.setText(pCancer.getTratamiento());
		}
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAceptar){					
					if(textHistorial.getText().length()>0 && textTratamiento.getText().length()>0 && comboBoxtipo.getSelectedItem()!=null)
					{
							if(pCancer==null)
							{
								java.sql.Date fecha=new java.sql.Date(0);
								if(dateFecha.getDate()!=null)
								{
									fecha=new java.sql.Date(dateFecha.getDate().getTime());
								}
								String mama=null;
								if(comboBox_tipo_Mama.getSelectedItem()!=null)
								{
									mama=comboBox_tipo_Mama.getSelectedItem().toString();
								}
								String tipo=null;
								if(comboBoxtipo.getSelectedItem()!=null)
								{
									tipo=comboBoxtipo.getSelectedItem().toString();
								}
								if(C_Doctor.getMiDoctor().obtenerCancer(pHistorial,fecha,tipo)==null)
								{
									boolean add=C_Doctor.getMiDoctor().addCancer(pHistorial,fecha,tipo,mama,textTratamiento.getText());
									if(add)
									{
										JOptionPane.showMessageDialog(null, "Añadido con éxito");
										dispose();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "No se ha podido añadir");
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "El cáncer ya existe en el sistema", "Control cáncer", JOptionPane.ERROR_MESSAGE);
								}
							}
							else
							{
								java.util.Date fecha=null;
								if(dateFecha.getDate()==null)
								{
									fecha=new Date();
								}
								else
								{
									fecha=dateFecha.getDate();
								}
								Mama mama=null;
								if(comboBox_tipo_Mama.getSelectedItem()!=null)
								{
									mama=Mama.valueOf(comboBox_tipo_Mama.getSelectedItem().toString());
								}
								TipoCancer tipo=null;
								if(comboBoxtipo.getSelectedItem()!=null)
								{
									tipo=TipoCancer.valueOf(comboBoxtipo.getSelectedItem().toString());
								}
			
								int actualizados = C_Doctor.getMiDoctor().actualizarCancer(pCancer,new Cancer(pHistorial, new java.sql.Date(fecha.getTime()), tipo, textTratamiento.getText(), mama));
								JOptionPane.showMessageDialog(null, "Se han actualizado "+actualizados+" campos");
								dispose();
								
							}
					}
					else
					{	
						JOptionPane.showMessageDialog(null, "Faltan campos obligatorios por rellenar.");
					}					
				}
			}
		});
		btnAceptar.setBounds(319, 368, 117, 25);
		contentPane.add(btnAceptar);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancelar){
					dispose();
				}
			}
		});
		btnCancelar.setBounds(183, 368, 117, 25);
		contentPane.add(btnCancelar);
		
		
	}
}
