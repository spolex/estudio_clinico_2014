package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import pack.osakidetza.aux.EmailValidator;
import pack.osakidetza.controladoras.C_Administracion;
import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_FastIdent extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	private JTextField textUsuario;
	

	/**
	 * Create the frame. El parámetro pEmail_Historial se utiliza para el email del usuario a manipular (borrar) o el historial del paciente.
	 */
	
	public IU_FastIdent(final String pNom,final String pEmail_Historial,final boolean darDeBajaU,final boolean darDeBajaP) {
		setTitle("Verificar identidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(59, 67, 98, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(59, 129, 98, 15);
		contentPane.add(lblContrasea);
		
		pass = new JPasswordField();
		pass.setBounds(175, 127, 181, 19);
		contentPane.add(pass);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(175, 65, 181, 19);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancelar){
					dispose();
				}
			}
		});
		btnCancelar.setBounds(218, 237, 117, 25);
		contentPane.add(btnCancelar);
		
		final JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Dar de baja médico.
				if(e.getSource()==btnAceptar && darDeBajaU && !darDeBajaP  && pEmail_Historial!=null)
				{
					if(textUsuario.getText().length()>0 && pass.getPassword().length>0 && EmailValidator.validateEmail(textUsuario.getText()))
					{
						String rdo=C_Administracion.getMiAdmin().identificarseEmail(textUsuario.getText(), String.valueOf(pass.getPassword()));
						if(rdo!=null)
						{
							if(rdo.equals("1"))
							{
								if(C_Administracion.getMiAdmin().darDeBajaUsuario(pNom,pEmail_Historial)){
									JOptionPane.showMessageDialog(null, "Usuario dado de baja con éxito");
									dispose();
								}
								else{
									JOptionPane.showMessageDialog(null, "El usuario no está de alta en el sistema");
									dispose();
								}								
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Faltan campos por rellenar o el formato del email es incorrecto");
					}
				}
				//Dar de baja paciente.
				else if (e.getSource()==btnAceptar && !darDeBajaU && darDeBajaP)
				{
					if(textUsuario.getText().length()>0 && pass.getPassword().length>0 && EmailValidator.validateEmail(textUsuario.getText()))
					{
						String rdo=C_Administracion.getMiAdmin().identificarseEmail(textUsuario.getText(), String.valueOf(pass.getPassword()));
						if(rdo!=null)
						{						//Un medico solo tiene cuenta de medico, si además es administrador necesita cuenta una diferente.
							if(rdo.equals("0"))
							{
								boolean borrado = C_Doctor.getMiDoctor().borrarPaciente(pEmail_Historial);
								if(borrado){
									JOptionPane.showMessageDialog(null, "Paciente dado de baja con éxito");
									dispose();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "No ha sido posible dar de baja al paciente, usted no es médico");
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Faltan campos o el formato del email es incorrecto");
					}
				}
				//Actualizar datos de usuario.
				else if (e.getSource()==btnAceptar && !darDeBajaU && !darDeBajaP)
				{
					if(textUsuario.getText().length()>0 && pass.getPassword().length>0 && EmailValidator.validateEmail(textUsuario.getText()))
					{
						String rdo=C_Administracion.getMiAdmin().identificarseEmail(textUsuario.getText(), String.valueOf(pass.getPassword()));
						if(rdo!=null)
						{
							if(rdo.equals("1"))
							{
								Usuario user=C_Administracion.getMiAdmin().obtenerUsuario(pEmail_Historial);
								IU_FormMedico IU_FM = new IU_FormMedico(textUsuario.getText(), user.getNombre(), user.getEmail(), user.getEsp());
								IU_FM.setVisible(true);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "No ha sido actualizar los datos del usuario, usted no es administrador");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Faltan campos o el formato del email es incorrecto");
					}
				}
			}				
		});
		btnAceptar.setBounds(81, 237, 117, 25);
		contentPane.add(btnAceptar);
	}
}
