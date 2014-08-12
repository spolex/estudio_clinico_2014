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
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import pack.osakidetza.aux.EmailValidator;
import pack.osakidetza.controladoras.C_Administracion;

@SuppressWarnings("serial")
public class IU_FormMedico extends JFrame {

	private JPanel contentPane;
	private JTextField texNom;
	private JTextField textEsp;
	private JPasswordField pass;
	private JPasswordField passRep;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_FormMedico frame = new IU_FormMedico("Admin");
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
	public IU_FormMedico(final String pNomAdmin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoMedico = new JLabel("Nuevo medico");
		lblNuevoMedico.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblNuevoMedico.setBounds(15, 12, 438, 28);
		contentPane.add(lblNuevoMedico);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 45, 421, 12);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(72, 96, 70, 15);
		contentPane.add(lblNombre);
		
		texNom = new JTextField();
		lblNombre.setLabelFor(texNom);
		texNom.setBounds(196, 94, 181, 19);
		contentPane.add(texNom);
		texNom.setColumns(10);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setBounds(72, 176, 70, 15);
		contentPane.add(lblPass);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(72, 255, 106, 15);
		contentPane.add(lblEspecialidad);
		
		textEsp = new JTextField();
		lblEspecialidad.setLabelFor(textEsp);
		textEsp.setBounds(196, 253, 181, 19);
		contentPane.add(textEsp);
		textEsp.setColumns(10);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancelar){
					dispose();
				}
			}
		});
		btnCancelar.setBounds(318, 305, 117, 25);
		contentPane.add(btnCancelar);
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAceptar){
					if(pass.getPassword().length!=0 && passRep.getPassword().length!=0 
							&& texNom.getText().length()!=0 && 
							textEmail.getText().length()!=0 && textEsp.getText().length() != 0){
						if(String.valueOf(pass.getPassword()).equals(String.valueOf(passRep.getPassword()))){
							if(EmailValidator.validateEmail(textEmail.getText())){
								if(C_Administracion.getMiAdmin().addUsuario(texNom.getText(),textEmail.getText(),textEsp.getText(), String.valueOf(pass.getPassword()),"1", pNomAdmin)){
									JOptionPane.showMessageDialog(null, "Usuario añadido");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "No ha sido posible añadir usuario nuevo");
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "El formato del email no está soportado por el sistema");
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
					}
				}
			}
		});
		btnAceptar.setBounds(196, 305, 117, 25);
		contentPane.add(btnAceptar);
		
		pass = new JPasswordField();
		lblPass.setLabelFor(pass);
		pass.setBounds(196, 174, 181, 19);
		contentPane.add(pass);
		
		JLabel lblRepitaPass = new JLabel("Repita pass");
		lblRepitaPass.setBounds(72, 214, 106, 15);
		contentPane.add(lblRepitaPass);
		
		passRep = new JPasswordField();
		lblRepitaPass.setLabelFor(passRep);
		passRep.setBounds(196, 212, 181, 19);
		contentPane.add(passRep);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(72, 139, 70, 15);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(196, 137, 181, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
	}
}
