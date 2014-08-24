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
import javax.swing.JButton;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Paciente;
import pack.osakidetza.enumerados.Sexo;
import pack.osakidetza.enumerados.SiNo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class IU_FormPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textHist;
	private JTextField textCriteriosCI;
	private JTextField textNumFamilia;
	private JTextField textFieldAnovu;
	private JTextField textNombre;
	

	

	/**
	 * Create the frame.
	 * @param pacienteCurrent 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_FormPaciente(final Paciente pacienteCurrent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		
		
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
		
		textNombre = new JTextField();
		textNombre.setBounds(173, 86, 114, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);				
		
		final JComboBox comboBoxFamiliarCI = new JComboBox();
		comboBoxFamiliarCI.setModel(new DefaultComboBoxModel(new String[] {"no", "si"}));
		comboBoxFamiliarCI.setBounds(173, 323, 114, 24);
		comboBoxFamiliarCI.setSelectedIndex(-1);//Para no seleccionar ninguno por defecto.
		contentPane.add(comboBoxFamiliarCI);
		
		final JComboBox comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"hombre", "mujer"}));
		comboBoxSex.setBounds(173, 201, 114, 24);
		comboBoxSex.setSelectedIndex(-1);
		contentPane.add(comboBoxSex);
		
		textCriteriosCI = new JTextField();
		textCriteriosCI.setBounds(173, 237, 114, 19);
		contentPane.add(textCriteriosCI);
		textCriteriosCI.setColumns(10);
		
		textNumFamilia = new JTextField();
		textNumFamilia.setBounds(173, 277, 114, 19);
		contentPane.add(textNumFamilia);
		textNumFamilia.setColumns(10);
		
		
		
		final JComboBox comboBoxRelacionCI = new JComboBox();
		comboBoxRelacionCI.setModel(new DefaultComboBoxModel(new String[] {"ninguno", "herman@", "hij@", "padre", "madre", "prim@", "ti@", "familiar"}));
		comboBoxRelacionCI.setBounds(173, 366, 114, 24);
		comboBoxRelacionCI.setSelectedIndex(-1);
		contentPane.add(comboBoxRelacionCI);
		
		final JComboBox comboBoxLugarNace = new JComboBox();
		comboBoxLugarNace.setModel(new DefaultComboBoxModel(new String[] {"Araba/Álava", "Albacete", "Alicante/Alacant", "Almería", "Ávila", "Badajoz", "Balears (Illes)", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Castellón/Castelló", "Ciudad Real", "Córdoba", "Coruña (A)", "Cuenca", "Girona", "Granada", "Guadalajara", "Gipuzkoa", "Huelva", "Huesca", "Jaén", "León", "Lleida", "Rioja (La)", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Asturias", "Palencia", "Palmas (Las)", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Cantabria", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia/València", "Valladolid", "Bizkaia", "Zamora", "Zaragoza", "Ceuta", "Melilla"}));
		comboBoxLugarNace.setBounds(540, 83, 114, 24);
		comboBoxLugarNace.setSelectedIndex(-1);
		contentPane.add(comboBoxLugarNace);
		
		final JComboBox comboBoxMaterno = new JComboBox();
		comboBoxMaterno.setModel(new DefaultComboBoxModel(new String[] {"Araba/Álava", "Albacete", "Alicante/Alacant", "Almería", "Ávila", "Badajoz", "Balears (Illes)", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Castellón/Castelló", "Ciudad Real", "Córdoba", "Coruña (A)", "Cuenca", "Girona", "Granada", "Guadalajara", "Gipuzkoa", "Huelva", "Huesca", "Jaén", "León", "Lleida", "Rioja (La)", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Asturias", "Palencia", "Palmas (Las)", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Cantabria", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia/València", "Valladolid", "Bizkaia", "Zamora", "Zaragoza", "Ceuta", "Melilla"}));
		comboBoxMaterno.setBounds(540, 127, 114, 24);
		comboBoxMaterno.setSelectedIndex(-1);
		contentPane.add(comboBoxMaterno);
		
		final JComboBox comboBoxPaterno = new JComboBox();
		comboBoxPaterno.setModel(new DefaultComboBoxModel(new String[] {"Araba/Álava", "Albacete", "Alicante/Alacant", "Almería", "Ávila", "Badajoz", "Balears (Illes)", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Castellón/Castelló", "Ciudad Real", "Córdoba", "Coruña (A)", "Cuenca", "Girona", "Granada", "Guadalajara", "Gipuzkoa", "Huelva", "Huesca", "Jaén", "León", "Lleida", "Rioja (La)", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Asturias", "Palencia", "Palmas (Las)", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Cantabria", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia/València", "Valladolid", "Bizkaia", "Zamora", "Zaragoza", "Ceuta", "Melilla"}));
		comboBoxPaterno.setBounds(540, 163, 114, 24);
		comboBoxPaterno.setSelectedIndex(-1);
		contentPane.add(comboBoxPaterno);
		
		textFieldAnovu = new JTextField();
		textFieldAnovu.setBounds(540, 237, 114, 19);
		contentPane.add(textFieldAnovu);
		textFieldAnovu.setColumns(10);
		
		final JComboBox comboBoxNumGesta = new JComboBox();
		comboBoxNumGesta.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
		comboBoxNumGesta.setBounds(540, 279, 114, 24);
		comboBoxNumGesta.setSelectedIndex(0);
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
		
		final JComboBox comboBoxHistI = new JComboBox(C_Doctor.getMiDoctor().listarCasosIndice().toArray());
		comboBoxHistI.setBounds(173, 451, 122, 19);
		comboBoxHistI.setSelectedIndex(-1);
		contentPane.add(comboBoxHistI);
		
		final JComboBox comboBoxCI = new JComboBox();
		comboBoxCI.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getItem().toString().equals("si"))
				{
					comboBoxHistI.setSelectedIndex(-1);
					comboBoxHistI.setEnabled(false);
				}
			}
		});
		comboBoxCI.setModel(new DefaultComboBoxModel(new String[] {"no", "si"}));
		comboBoxCI.setBounds(173, 158, 114, 24);
		comboBoxCI.setSelectedIndex(-1);
		contentPane.add(comboBoxCI);
		
		
		if(pacienteCurrent!=null)
		{
			textNombre.setText(pacienteCurrent.getNombre());
			textHist.setText(pacienteCurrent.getHistorial());		
			comboBoxCI.setSelectedItem(pacienteCurrent.getCi().toString());
			comboBoxSex.setSelectedItem(pacienteCurrent.getSexo().toString());
			textCriteriosCI.setText(pacienteCurrent.getCriteriosCI());
			textNumFamilia.setText(pacienteCurrent.getNumFamilia());
			comboBoxFamiliarCI.setSelectedItem(pacienteCurrent.getFamiliarCI().toString());
			comboBoxRelacionCI.setSelectedItem(pacienteCurrent.getRelacionCI().toString());
			dateFNacimiento.setDate(pacienteCurrent.getFechaNace());
			if(pacienteCurrent.getHistorialCI()!=null && pacienteCurrent.getHistorialCI().length()>0){
				comboBoxHistI.setSelectedItem(pacienteCurrent.getHistorialCI());
			}
			comboBoxLugarNace.setSelectedItem(pacienteCurrent.getLugarNace());
			comboBoxMaterno.setSelectedItem(pacienteCurrent.getOrigenMaterno());
			comboBoxPaterno.setSelectedItem(pacienteCurrent.getOrigenPaterno());
			dateFechaSeg.setDate(pacienteCurrent.getFechaSeguimiento());
			textFieldAnovu.setText(pacienteCurrent.getAnovulatorios());
			comboBoxNumGesta.setSelectedItem(String.valueOf(pacienteCurrent.getNumGestaciones()));
			datePrimerEmbarazo.setDate(pacienteCurrent.getPrimerEmbarazo());
			dateMenopausia.setDate(pacienteCurrent.getMenopausia());
			dateMenarquia.setDate(pacienteCurrent.getMenarquia());
			
		}
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAceptar){
					if(!textHist.getText().isEmpty() && !textNombre.getText().isEmpty() && pacienteCurrent==null)
					{
						String pHist = textHist.getText();
						if(C_Doctor.getMiDoctor().buscarPaciente(pHist)==null)
						{
							String pNom = textNombre.getText();
							
							String CI = null;
							if(comboBoxCI.getSelectedItem()!=null) CI = comboBoxCI.getSelectedItem().toString();
							
							String sexo = null;
							if(comboBoxSex.getSelectedItem()!=null) sexo = comboBoxSex.getSelectedItem().toString();
							
							String familiarCi = null;
							if(comboBoxFamiliarCI.getSelectedItem()!=null) familiarCi = comboBoxFamiliarCI.getSelectedItem().toString();	
							
							String relacionCi = null;
							if(comboBoxRelacionCI.getSelectedItem()!=null) relacionCi = comboBoxRelacionCI.getSelectedItem().toString();
							
							String origenMaterno=null;
							if(comboBoxMaterno.getSelectedItem()!=null) origenMaterno = comboBoxMaterno.getSelectedItem().toString();
							
							String origenPaterno = null;
							if(comboBoxPaterno.getSelectedItem()!=null)origenPaterno=comboBoxPaterno.getSelectedItem().toString();
							
							String numGest=null;
							if(comboBoxNumGesta.getSelectedItem()!=null)numGest = comboBoxNumGesta.getSelectedItem().toString();
							
							String lugarNace = null;
							if(comboBoxLugarNace.getSelectedItem()!=null)lugarNace = comboBoxLugarNace.getSelectedItem().toString();
							
							String histCI = null;
							if(comboBoxHistI.getSelectedItem()!=null)histCI=comboBoxHistI.toString();			
							
							String criteriosCI = textCriteriosCI.getText();
							String numFamilia = textNumFamilia.getText();							
							String anovulatorios = textFieldAnovu.getText();
										
							Date fNacimiento=null;
							if(dateFNacimiento.getDate()!=null) fNacimiento =new Date(dateFNacimiento.getDate().getTime());
							
							Date fSeguimiento=null;;
							if(dateFechaSeg.getDate()!=null)fSeguimiento = new Date(dateFechaSeg.getDate().getTime());
							
							Date fPrimerEm=null;
							if(datePrimerEmbarazo.getDate()!=null)fPrimerEm = new Date(datePrimerEmbarazo.getDate().getTime());
							
							Date fMeno=null;
							if(datePrimerEmbarazo.getDate()!=null)fMeno = new Date(datePrimerEmbarazo.getDate().getTime());
							
							Date fMenar=null;
							if(dateMenarquia.getDate()!=null)fMenar = new Date(dateMenarquia.getDate().getTime());
							
							boolean añadido = C_Doctor.getMiDoctor().addPaciente(pNom,pHist,CI,sexo,histCI,criteriosCI,numFamilia,familiarCi,relacionCi,fNacimiento,
									lugarNace,origenMaterno,origenPaterno,fSeguimiento,anovulatorios,numGest,fPrimerEm,
									fMeno, fMenar);
							if(añadido){
								JOptionPane.showMessageDialog(null, "El paciente: "+pNom+" con el nº de historial: "+ pHist + " ha sido registrado en el sistema");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Error, imposible dar de alta al paciente en el sistema!!");
							}
						}
						else{
							
							JOptionPane.showMessageDialog(null, "El número de historial ya está registrado en el sistema");
						}
					}
					else if(pacienteCurrent!=null && textNombre.getText().length()>0){
						try{
								String historialOld=pacienteCurrent.getHistorial();
								pacienteCurrent.setHistorial(textHist.getText());
								pacienteCurrent.setNombre(textNombre.getText());
								if(comboBoxCI.getSelectedItem()!=null)pacienteCurrent.setCi(SiNo.valueOf(comboBoxCI.getSelectedItem().toString()));
								if(comboBoxSex.getSelectedItem()!=null)pacienteCurrent.setSexo(Sexo.valueOf(comboBoxSex.getSelectedItem().toString()));
								pacienteCurrent.setCriteriosCI(textCriteriosCI.getText());
								pacienteCurrent.setNumFamilia(textNumFamilia.getText());
								if(comboBoxFamiliarCI.getSelectedItem()!=null)pacienteCurrent.setFamiliarCI(SiNo.valueOf(comboBoxFamiliarCI.getSelectedItem().toString()));
								if(comboBoxRelacionCI.getSelectedItem()!=null)pacienteCurrent.setRelacionCI(comboBoxRelacionCI.getSelectedItem().toString());
								pacienteCurrent.setFechaNace(dateFNacimiento.getDate());
								if(comboBoxHistI.getSelectedItem()!=null)pacienteCurrent.setHistorialCI(comboBoxHistI.getSelectedItem().toString());
								pacienteCurrent.setLugarNace(comboBoxLugarNace.getSelectedItem().toString());
								if(comboBoxMaterno.getSelectedItem()!=null)pacienteCurrent.setOrigenMaterno(comboBoxMaterno.getSelectedItem().toString());
								if(comboBoxPaterno.getSelectedItem()!=null)pacienteCurrent.setOrigenPaterno(comboBoxPaterno.getSelectedItem().toString());
								pacienteCurrent.setFechaSeguimiento(dateFechaSeg.getDate());
								pacienteCurrent.setAnovulatorios(textFieldAnovu.getText());
								pacienteCurrent.setNumGestaciones(Integer.parseInt(comboBoxNumGesta.getSelectedItem().toString()));
								pacienteCurrent.setPrimerEmbarazo(datePrimerEmbarazo.getDate());
								pacienteCurrent.setMenopausia(dateMenopausia.getDate());
								pacienteCurrent.setMenarquia(dateMenarquia.getDate());
								C_Doctor.getMiDoctor().actualizarPaciente(pacienteCurrent,historialOld);
								JOptionPane.showMessageDialog(null, "Datos del paciente "+pacienteCurrent.getNombre()+" actualizados.");
								dispose();
							}
						catch(NullPointerException e1)
						{
							JOptionPane.showMessageDialog(null, "Error al intentar actualizar usuario, el sistema se cerrara");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Faltan campos obligatorios por rellenar");
					}
				}
			}
		});
		
		btnAceptar.setBounds(227, 498, 117, 25);
		contentPane.add(btnAceptar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 88, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblHistorialCi = new JLabel("Historial CI");
		lblHistorialCi.setBounds(12, 456, 85, 15);
		contentPane.add(lblHistorialCi);		
		
	}
}
