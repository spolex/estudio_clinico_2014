package pack.osakidetza.vistas;

import java.awt.EventQueue;

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
import javax.swing.JButton;

import pack.osakidetza.controladoras.C_Doctor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IU_FormPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textHist;
	private JTextField textCriteriosCI;
	private JTextField textNumFamilia;
	private JTextField textFieldAnovu;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_FormPaciente frame = new IU_FormPaciente();
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
	public IU_FormPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblPaciente.setBounds(12, 12, 113, 28);
		contentPane.add(lblPaciente);
		
		JLabel lblCi = new JLabel("Ci");
		lblCi.setBounds(12, 163, 70, 15);
		contentPane.add(lblCi);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(12, 200, 70, 15);
		contentPane.add(lblSexo);
		
		JLabel lblHistorial = new JLabel("Historial");
		lblHistorial.setBounds(12, 127, 70, 15);
		contentPane.add(lblHistorial);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 52, 403, 15);
		contentPane.add(separator);
		
		JLabel lblCriteriosci = new JLabel("Criterios_Ci");
		lblCriteriosci.setBounds(12, 239, 113, 15);
		contentPane.add(lblCriteriosci);
		
		JLabel lblNumeroFamilia = new JLabel("Numero familia");
		lblNumeroFamilia.setBounds(12, 279, 113, 15);
		contentPane.add(lblNumeroFamilia);
		
		JLabel lblFamiliarCi = new JLabel("Familiar Ci");
		lblFamiliarCi.setBounds(12, 328, 113, 15);
		contentPane.add(lblFamiliarCi);
		
		JLabel lblRelacinCi = new JLabel("Relación CI");
		lblRelacinCi.setBounds(12, 371, 102, 15);
		contentPane.add(lblRelacinCi);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(12, 415, 160, 15);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblLugarDeNacimiento = new JLabel("Lugar de nacimiento");
		lblLugarDeNacimiento.setBounds(355, 88, 160, 15);
		contentPane.add(lblLugarDeNacimiento);
		
		JLabel lblOrigenMaterno = new JLabel("Origen materno");
		lblOrigenMaterno.setBounds(355, 127, 149, 15);
		contentPane.add(lblOrigenMaterno);
		
		JLabel lblOrigenPaterno = new JLabel("Origen paterno");
		lblOrigenPaterno.setBounds(355, 163, 129, 15);
		contentPane.add(lblOrigenPaterno);
		
		JLabel lblFechaDeSeguimiento = new JLabel("Fecha de seguimiento");
		lblFechaDeSeguimiento.setBounds(355, 206, 178, 15);
		contentPane.add(lblFechaDeSeguimiento);
		
		JLabel lblConsumoAnovulatorios = new JLabel("Consumo Anovulatorios");
		lblConsumoAnovulatorios.setBounds(355, 239, 202, 15);
		contentPane.add(lblConsumoAnovulatorios);
		
		JLabel lblNmeroDeGestaciones = new JLabel("Número de gestaciones");
		lblNmeroDeGestaciones.setBounds(355, 279, 168, 15);
		contentPane.add(lblNmeroDeGestaciones);
		
		JLabel lblPrimerEmbarazo = new JLabel("Primer embarazo");
		lblPrimerEmbarazo.setBounds(355, 328, 178, 15);
		contentPane.add(lblPrimerEmbarazo);
		
		JLabel lblMenopausia = new JLabel("Menopausia");
		lblMenopausia.setBounds(355, 371, 149, 15);
		contentPane.add(lblMenopausia);
		
		textHist = new JTextField();
		textHist.setBounds(173, 125, 114, 19);
		contentPane.add(textHist);
		textHist.setColumns(10);
		
		final JComboBox comboBoxFamiliarCI = new JComboBox();
		comboBoxFamiliarCI.setModel(new DefaultComboBoxModel(new String[] {"no", "si"}));
		comboBoxFamiliarCI.setBounds(173, 323, 114, 24);
		contentPane.add(comboBoxFamiliarCI);
		
		final JComboBox comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		comboBoxSex.setBounds(173, 201, 114, 24);
		contentPane.add(comboBoxSex);
		
		textCriteriosCI = new JTextField();
		textCriteriosCI.setBounds(173, 237, 114, 19);
		contentPane.add(textCriteriosCI);
		textCriteriosCI.setColumns(10);
		
		textNumFamilia = new JTextField();
		textNumFamilia.setBounds(173, 277, 114, 19);
		contentPane.add(textNumFamilia);
		textNumFamilia.setColumns(10);
		
		final JComboBox comboBoxCI = new JComboBox();
		comboBoxCI.setModel(new DefaultComboBoxModel(new String[] {"no", "si"}));
		comboBoxCI.setBounds(173, 158, 114, 24);
		contentPane.add(comboBoxCI);
		
		final JComboBox comboBoxRelacionCI = new JComboBox();
		comboBoxRelacionCI.setModel(new DefaultComboBoxModel(new String[] {"ninguno", "herman@", "hij@", "padre", "madre", "prim@", "ti@", "familiar"}));
		comboBoxRelacionCI.setBounds(173, 366, 114, 24);
		contentPane.add(comboBoxRelacionCI);
		
		final JComboBox comboBoxLugarNace = new JComboBox();
		comboBoxLugarNace.setModel(new DefaultComboBoxModel(new String[] {"Araba/Álava", "Albacete", "Alicante/Alacant", "Almería", "Ávila", "Badajoz", "Balears (Illes)", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Castellón/Castelló", "Ciudad Real", "Córdoba", "Coruña (A)", "Cuenca", "Girona", "Granada", "Guadalajara", "Gipuzkoa", "Huelva", "Huesca", "Jaén", "León", "Lleida", "Rioja (La)", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Asturias", "Palencia", "Palmas (Las)", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Cantabria", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia/València", "Valladolid", "Bizkaia", "Zamora", "Zaragoza", "Ceuta", "Melilla"}));
		comboBoxLugarNace.setBounds(540, 83, 114, 24);
		contentPane.add(comboBoxLugarNace);
		
		final JComboBox comboBoxMaterno = new JComboBox();
		comboBoxMaterno.setModel(new DefaultComboBoxModel(new String[] {"Araba/Álava", "Albacete", "Alicante/Alacant", "Almería", "Ávila", "Badajoz", "Balears (Illes)", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Castellón/Castelló", "Ciudad Real", "Córdoba", "Coruña (A)", "Cuenca", "Girona", "Granada", "Guadalajara", "Gipuzkoa", "Huelva", "Huesca", "Jaén", "León", "Lleida", "Rioja (La)", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Asturias", "Palencia", "Palmas (Las)", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Cantabria", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia/València", "Valladolid", "Bizkaia", "Zamora", "Zaragoza", "Ceuta", "Melilla"}));
		comboBoxMaterno.setBounds(540, 127, 114, 24);
		contentPane.add(comboBoxMaterno);
		
		final JComboBox comboBoxPaterno = new JComboBox();
		comboBoxPaterno.setModel(new DefaultComboBoxModel(new String[] {"Araba/Álava", "Albacete", "Alicante/Alacant", "Almería", "Ávila", "Badajoz", "Balears (Illes)", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Castellón/Castelló", "Ciudad Real", "Córdoba", "Coruña (A)", "Cuenca", "Girona", "Granada", "Guadalajara", "Gipuzkoa", "Huelva", "Huesca", "Jaén", "León", "Lleida", "Rioja (La)", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Asturias", "Palencia", "Palmas (Las)", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Cantabria", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia/València", "Valladolid", "Bizkaia", "Zamora", "Zaragoza", "Ceuta", "Melilla"}));
		comboBoxPaterno.setBounds(540, 163, 114, 24);
		contentPane.add(comboBoxPaterno);
		
		textFieldAnovu = new JTextField();
		textFieldAnovu.setBounds(540, 237, 114, 19);
		contentPane.add(textFieldAnovu);
		textFieldAnovu.setColumns(10);
		
		final JComboBox comboBoxNumGesta = new JComboBox();
		comboBoxNumGesta.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
		comboBoxNumGesta.setBounds(540, 279, 114, 24);
		contentPane.add(comboBoxNumGesta);
		
		final JDateChooser dateFNacimiento = new JDateChooser();
		dateFNacimiento.setBounds(173, 415, 122, 19);
		contentPane.add(dateFNacimiento);
		
		final JDateChooser dateFechaSeg = new JDateChooser();
		dateFechaSeg.setBounds(540, 202, 122, 19);
		contentPane.add(dateFechaSeg);
		
		final JDateChooser datePrimerEmbarazo = new JDateChooser();
		datePrimerEmbarazo.setBounds(540, 328, 122, 19);
		contentPane.add(datePrimerEmbarazo);
		
		final JDateChooser dateMenopausia = new JDateChooser();
		dateMenopausia.setBounds(540, 371, 122, 19);
		contentPane.add(dateMenopausia);
		

		final JDateChooser dateMenarquia = new JDateChooser();
		dateMenarquia.setBounds(540, 415, 122, 19);
		contentPane.add(dateMenarquia);
		
		JLabel lblMenarquia = new JLabel("Menarquia");
		lblMenarquia.setBounds(355, 415, 102, 15);
		contentPane.add(lblMenarquia);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancelar)dispose();
			}
		});
		btnCancelar.setBounds(367, 498, 117, 25);
		contentPane.add(btnCancelar);
		
		final JComboBox comboBoxCasosI = new JComboBox(C_Doctor.getMiDoctor().listarCasosIndice().toArray());
		comboBoxCasosI.setBounds(173, 451, 122, 19);
		contentPane.add(comboBoxCasosI);
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAceptar){
					if(!textHist.getText().isEmpty() && !textNombre.getText().isEmpty())
					{
						String pHist = textHist.getText();
						if(C_Doctor.getMiDoctor().buscarPaciente(pHist)==null)
						{
							String pNom = textNombre.getText();
							String CI = comboBoxCI.getSelectedItem().toString();
							String sexo = comboBoxSex.getSelectedItem().toString();
							String criteriosCI = textCriteriosCI.getText();
							String numFamilia = textNumFamilia.getText();
							String familiarCi = comboBoxFamiliarCI.getSelectedItem().toString();
							String relacionCi = comboBoxRelacionCI.getSelectedItem().toString();
							//Para dar formato a la fecha
							String fechaNacimiento="";
							if(dateFNacimiento.getDate()!=null)fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").format(dateFNacimiento.getDate());
							String lugarNace = comboBoxLugarNace.getSelectedItem().toString();
							String origenMaterno = comboBoxMaterno.getSelectedItem().toString();
							String origenPaterno = comboBoxPaterno.getSelectedItem().toString();
							String fechaSeguimiento="";
							if(dateFechaSeg.getDate()!=null)fechaSeguimiento = new SimpleDateFormat("yyyy-MM-dd").format(dateFechaSeg.getDate());
							String anovulatorios = textFieldAnovu.getText();
							String numGest = comboBoxNumGesta.getSelectedItem().toString();
							String fechaPrimerEmbarazo="";
							if(datePrimerEmbarazo.getDate()!=null)fechaPrimerEmbarazo = new SimpleDateFormat("yyyy-MM-dd").format(datePrimerEmbarazo.getDate());
							String fechaMenopausia="";
							if(dateMenopausia.getDate()!=null)fechaMenopausia = new SimpleDateFormat("yyyy-MM-dd").format(dateMenopausia.getDate());
							String fechaMenarquia="";
							if(dateMenarquia.getDate()!=null)fechaMenarquia = new SimpleDateFormat("yyyy-MM-dd").format(dateMenarquia.getDate());
							String histCI = comboBoxCasosI.getSelectedItem().toString();
							
							boolean añadido = C_Doctor.getMiDoctor().addPaciente(pNom,pHist,CI,sexo,histCI,criteriosCI,numFamilia,familiarCi,relacionCi,fechaNacimiento,lugarNace,origenMaterno,origenPaterno
								,fechaSeguimiento,anovulatorios,numGest,fechaPrimerEmbarazo,fechaMenopausia, fechaMenarquia);
							if(añadido){
								JOptionPane.showMessageDialog(null, "El paciente: "+pNom+" con el nº de historial: "+ pHist + " ha sido registrado en el sistema");
							}
							else{
								JOptionPane.showMessageDialog(null, "Error, imposible dar de alta al paciente en el sistema!!");
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "El número de historial ya está registrado en el sistema");
						}
					}
				}
			}
		});
		btnAceptar.setBounds(227, 498, 117, 25);
		contentPane.add(btnAceptar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 88, 70, 15);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(173, 86, 114, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);		
		
		JLabel lblHistorialCi = new JLabel("Historial CI");
		lblHistorialCi.setBounds(12, 456, 85, 15);
		contentPane.add(lblHistorialCi);		
		
	}
}
