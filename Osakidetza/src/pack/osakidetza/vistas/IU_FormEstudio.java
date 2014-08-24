package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Estudio;
import pack.osakidetza.enumerados.EstidiajeM;
import pack.osakidetza.enumerados.EstidiajeN;
import pack.osakidetza.enumerados.EstidiajeT;
import pack.osakidetza.enumerados.Grado;
import pack.osakidetza.enumerados.Subtipo;
import pack.osakidetza.enumerados.TipoCancer;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class IU_FormEstudio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField txtNHistorial;
	private JTextField textFieldTipo;
	private JTextField textki67;
	private Estudio estudio;

	
	/**
	 * Create the frame.
	 * @param tipo 
	 * @param pHistorial 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_FormEstudio(String pHistorial, String tipo, final java.sql.Date pFecha) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		estudio= new Estudio();
		
		JLabel lblEstudios = new JLabel("Estudio patológico");
		lblEstudios.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblEstudios.setBounds(24, 12, 212, 24);
		contentPane.add(lblEstudios);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(12, 84, 70, 15);
		contentPane.add(lblCdigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(108, 82, 114, 19);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(12, 128, 70, 15);
		contentPane.add(lblPaciente);
		
		txtNHistorial = new JTextField();
		txtNHistorial.setText("nº historial");
		txtNHistorial.setBounds(108, 126, 114, 19);
		contentPane.add(txtNHistorial);
		txtNHistorial.setColumns(10);
		txtNHistorial.setText(pHistorial);
		txtNHistorial.setEnabled(false);
		estudio.setPaciente(pHistorial);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 172, 70, 15);
		contentPane.add(lblTipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(108, 170, 114, 19);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		textFieldTipo.setText(tipo);
		textFieldTipo.setEnabled(false);
		estudio.setTipo(TipoCancer.valueOf(tipo));
		
		JLabel lblSubtipo = new JLabel("Subtipo");
		lblSubtipo.setBounds(12, 225, 70, 15);
		contentPane.add(lblSubtipo);
		
		final JComboBox comboBoxSubtipo = new JComboBox();
		comboBoxSubtipo.setModel(new DefaultComboBoxModel(new String[] {"ductal", "lobulillar", "mucinoso", "tubular", "otros"}));
		comboBoxSubtipo.setBounds(108, 220, 128, 25);
		contentPane.add(comboBoxSubtipo);
		comboBoxSubtipo.setSelectedIndex(-1);
		
		JLabel lblReceptoresEstrognicos = new JLabel("Estrogénicos");
		lblReceptoresEstrognicos.setBounds(258, 84, 92, 15);
		contentPane.add(lblReceptoresEstrognicos);
		
		JLabel lblProgestagnicos = new JLabel("Progestagénicos");
		lblProgestagnicos.setBounds(258, 128, 120, 15);
		contentPane.add(lblProgestagnicos);
		
		JLabel lblCerbe = new JLabel("CerbE2");
		lblCerbe.setBounds(12, 271, 70, 15);
		contentPane.add(lblCerbe);
		
		JLabel lblKi = new JLabel("Ki67");
		lblKi.setBounds(12, 319, 70, 15);
		contentPane.add(lblKi);
		
		final JComboBox comboBoxCerbE2 = new JComboBox();
		comboBoxCerbE2.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "desconocidos"}));
		comboBoxCerbE2.setBounds(108, 266, 128, 25);
		contentPane.add(comboBoxCerbE2);
		comboBoxCerbE2.setSelectedIndex(-1);
		
		final JComboBox comboBoxestrogenicos = new JComboBox();
		comboBoxestrogenicos.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "desconocido"}));
		comboBoxestrogenicos.setBounds(408, 79, 135, 20);
		contentPane.add(comboBoxestrogenicos);
		comboBoxestrogenicos.setSelectedIndex(-1);
		
		final JComboBox comboBoxProgestagenicos = new JComboBox();
		comboBoxProgestagenicos.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "desconocido"}));
		comboBoxProgestagenicos.setBounds(408, 123, 135, 20);
		contentPane.add(comboBoxProgestagenicos);
		comboBoxProgestagenicos.setSelectedIndex(-1);
		
		JLabel lblGradoHistolgico = new JLabel("Grado histológico");
		lblGradoHistolgico.setBounds(258, 172, 135, 15);
		contentPane.add(lblGradoHistolgico);
		
		JLabel lblEstidiajet = new JLabel("Estidiaje (T)");
		lblEstidiajet.setBounds(258, 225, 135, 15);
		contentPane.add(lblEstidiajet);
		
		JLabel lblEstidiajen = new JLabel("Estidiaje (N)");
		lblEstidiajen.setBounds(258, 271, 92, 15);
		contentPane.add(lblEstidiajen);
		
		JLabel lblEstidiajem = new JLabel("Estidiaje (M)");
		lblEstidiajem.setBounds(258, 319, 92, 15);
		contentPane.add(lblEstidiajem);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(108, 370, 114, 24);
		contentPane.add(dateChooser);
		
		final JComboBox comboBoxT = new JComboBox();
		comboBoxT.setMaximumRowCount(20);
		comboBoxT.setModel(new DefaultComboBoxModel(new String[] {"T1mi", "T1a", "T1b", "T1c", "T2", "T3", "T4a", "T4b", "T4c", "T4d", "Tx"}));
		comboBoxT.setBounds(408, 220, 135, 20);
		contentPane.add(comboBoxT);
		comboBoxT.setSelectedIndex(-1);
		
		final JComboBox comboBoxN = new JComboBox();
		comboBoxN.setModel(new DefaultComboBoxModel(new String[] {"N0", "N1mi", "N1a", "N1b", "N1c", "N2a", "N2b", "N2c", "N3a", "N3b", "N3c", "Nx"}));
		comboBoxN.setMaximumRowCount(20);
		comboBoxN.setBounds(408, 266, 135, 20);
		contentPane.add(comboBoxN);
		comboBoxN.setSelectedIndex(-1);
		
		final JComboBox comboBoxM = new JComboBox();
		comboBoxM.setModel(new DefaultComboBoxModel(new String[] {"M0", "M1", "desconocido"}));
		comboBoxM.setBounds(408, 314, 135, 20);
		contentPane.add(comboBoxM);
		comboBoxM.setSelectedIndex(-1);
		
		textki67 = new JTextField();
		textki67.setBounds(108, 317, 114, 19);
		contentPane.add(textki67);
		textki67.setColumns(10);
		
		final JComboBox comboBoxGrado = new JComboBox();
		comboBoxGrado.setModel(new DefaultComboBoxModel(new String[] {"G1", "G2", "G3", "desconocido"}));
		comboBoxGrado.setBounds(408, 169, 135, 20);
		contentPane.add(comboBoxGrado);
		comboBoxGrado.setSelectedIndex(-1);
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==btnAceptar)
				{
					if(textFieldCodigo.getText().length()>0)
					{
						estudio.setCode(textFieldCodigo.getText());
						if(comboBoxSubtipo.getSelectedItem()!=null)estudio.setSubHistologico(Subtipo.valueOf(comboBoxSubtipo.getSelectedItem().toString()));
						if(comboBoxGrado.getSelectedItem()!=null)estudio.setgHistologico(Grado.valueOf(comboBoxGrado.getSelectedItem().toString()));
						if(comboBoxCerbE2.getSelectedItem()!=null)estudio.setCerbE2(comboBoxCerbE2.getSelectedItem().toString());
						if(comboBoxestrogenicos.getSelectedItem()!=null)estudio.setReceptoresEstrogenicos(comboBoxestrogenicos.getSelectedItem().toString());
						if(comboBoxProgestagenicos.getSelectedItem()!=null)estudio.setReceptoresProstagenicos(comboBoxProgestagenicos.getSelectedItem().toString());
						if(comboBoxT.getSelectedItem()!=null)estudio.setT(EstidiajeT.valueOf(comboBoxT.getSelectedItem().toString()));
						if(comboBoxN.getSelectedItem()!=null)estudio.setN(EstidiajeN.valueOf(comboBoxN.getSelectedItem().toString()));
						if(comboBoxM.getSelectedItem()!=null)estudio.setM(EstidiajeM.valueOf(comboBoxM.getSelectedItem().toString()));
						if(Integer.parseInt(textki67.getText())>=0 && Integer.parseInt(textki67.getText())<=100)
						{
							estudio.setKi676(Integer.parseInt(textki67.getText()));
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Debe introducir un porcentaje entre 1 y 100 en el campo Ki67", "Control Estudios patológicos", JOptionPane.ERROR_MESSAGE);
						}
						if(dateChooser.getDate()!=null)
						{
							estudio.setFecha(new java.sql.Date(dateChooser.getDate().getTime()));
						}
						if(C_Doctor.addEstudio(estudio,pFecha))
						{
							JOptionPane.showMessageDialog(null, "Estudio Patológico añadido con éxito al sistema", "Control Estudioa Patológicos", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Imposible añadir Estudio Patológico al sistema", "Control Estudios Patológicos", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "El campo código es obligatorio", "Control Estudio patológico", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAceptar.setBounds(298, 415, 117, 25);
		contentPane.add(btnAceptar);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver)dispose();
			}
		});
		btnVolver.setBounds(437, 415, 117, 25);
		contentPane.add(btnVolver);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 379, 70, 15);
		contentPane.add(lblFecha);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 39, 515, 24);
		contentPane.add(separator);		
		
	}
}
