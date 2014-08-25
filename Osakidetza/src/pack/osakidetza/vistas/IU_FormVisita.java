package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Visita;

@SuppressWarnings("serial")
public class IU_FormVisita extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHist;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	/**
	 * Create the frame.
	 * @param pEmail 
	 */
	public IU_FormVisita(final String nombre, final String pEmail, Visita pVisita) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblVisitas = new JLabel("Visitas");
		lblVisitas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblVisitas.setBounds(22, 25, 70, 15);
		contentPane.add(lblVisitas);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(12, 78, 70, 15);
		contentPane.add(lblPaciente);
		
		textFieldHist = new JTextField();
		textFieldHist.setBounds(114, 76, 114, 19);
		contentPane.add(textFieldHist);
		textFieldHist.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(12, 141, 105, 15);
		contentPane.add(lblObservaciones);
		
		final JCheckBox chckbxBuscar = new JCheckBox("Buscar");
		buttonGroup.add(chckbxBuscar);
		chckbxBuscar.setBounds(266, 268, 129, 23);
		contentPane.add(chckbxBuscar);
		
		final JCheckBox chckbxNueva = new JCheckBox("Nueva");
		buttonGroup.add(chckbxNueva);
		chckbxNueva.setBounds(399, 268, 129, 23);
		contentPane.add(chckbxNueva);
				
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 168, 504, 72);
		contentPane.add(textPane);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(366, 78, 104, 19);
		contentPane.add(dateChooser);
		
		final JDateChooser dateDesde = new JDateChooser();
		dateDesde.setBounds(145, 320, 104, 19);
		contentPane.add(dateDesde);
		
		final JDateChooser dateHasta = new JDateChooser();
		dateHasta.setBounds(412, 320, 104, 19);
		contentPane.add(dateHasta);
		
		if(pVisita!=null)
		{
			textFieldHist.setText(pVisita.getPaciente());
			textFieldHist.setEnabled(false);
			dateChooser.setDate(new java.util.Date(pVisita.getFecha().getTime()));
			dateChooser.setEnabled(false);
			textPane.setText(pVisita.getObservaciones());
			textPane.setEnabled(false);
		}
		
		final JButton btnIntroducir = new JButton("Aceptar");
		btnIntroducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNueva.isSelected() && e.getSource()==btnIntroducir)
				{
					if(textFieldHist.getText().length()>0 && dateChooser.getDate()!=null)
					{
						if(C_Doctor.getMiDoctor().buscarPaciente(textFieldHist.getText())!=null)
						{
							Visita visita = new Visita(textFieldHist.getText(),new java.sql.Date(dateChooser.getDate().getTime()),nombre,pEmail,textPane.getText());
							 if(C_Doctor.getMiDoctor().addVisita(visita))
							 {
								 JOptionPane.showMessageDialog(null, "Visita añadida con éxito al sistema", "Control de visitas", JOptionPane.INFORMATION_MESSAGE);
							 }
							 else
							 {
								 JOptionPane.showMessageDialog(null, "Imposible añadir la visita", "Control de visitas", JOptionPane.ERROR_MESSAGE);
							 }							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El paciente no se encuentra registrado en el sistema, compruebe el nº historial");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Introduzca el número de historial del paciente o la fecha");
					}
				}
				else if(chckbxBuscar.isSelected())
				{							
					if(dateDesde.getDate()==null && dateHasta.getDate()==null)
					{
						IU_ListaVisitas IU_LV = new IU_ListaVisitas(pEmail,null,null,null);
						IU_LV.setVisible(true);
					}
					else
					{
						if(dateDesde.getDate()==null || dateHasta.getDate()==null)
						{
							JOptionPane.showMessageDialog(null, "Debe seleccionar las fechas entre las que desea obtener las visitas", "Control visitas", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							IU_ListaVisitas IU_LV = new IU_ListaVisitas(pEmail,null,dateDesde.getDate(),dateHasta.getDate());
							IU_LV.setVisible(true);
						}
					}				
				}
			}
		});
		btnIntroducir.setBounds(399, 369, 117, 25);
		contentPane.add(btnIntroducir);
		
		JLabel lblFechaInicial = new JLabel("Fecha desde");
		lblFechaInicial.setBounds(10, 320, 117, 15);
		contentPane.add(lblFechaInicial);
		
		JLabel lblFechaHasta = new JLabel("Fecha hasta");
		lblFechaHasta.setBounds(267, 320, 105, 15);
		contentPane.add(lblFechaHasta);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(278, 78, 70, 15);
		contentPane.add(lblFecha);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver)dispose();
			}
		});
		btnVolver.setBounds(270, 369, 117, 25);
		contentPane.add(btnVolver);
						
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 41, 504, 25);
		contentPane.add(separator);
	}
}
