package pack.osakidetza.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import pack.osakidetza.aux.EmailValidator;
import pack.osakidetza.controladoras.C_Administracion;
import pack.osakidetza.controladoras.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Principal frame = new IU_Principal();
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
	public IU_Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);//Para evitar que se pueda maximizar.
		
		JLabel lblBienvenido = new JLabel("Bienvenido al sistema");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblBienvenido.setBounds(27, 12, 409, 23);
		contentPane.add(lblBienvenido);
		
		final JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnSalir){
					dispose();
				}
			}
		});
		btnSalir.setBounds(319, 237, 117, 25);
		contentPane.add(btnSalir);
		
		JLabel lblUsuario = new JLabel("Usuario/E-mail");
		lblUsuario.setBounds(27, 71, 101, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(27, 111, 107, 15);
		contentPane.add(lblContrasea);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(211, 69, 194, 19);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		passUsuario = new JPasswordField();
		passUsuario.setBounds(211, 110, 194, 17);
		contentPane.add(passUsuario);
		
		final JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()== btnEntrar)
				{					
					String pass = new String(passUsuario.getPassword());					
					String nombre = new String(textUsuario.getText().toString());
					String identificado = new String();
				    identificado = C_Administracion.getMiAdmin().identificarse(nombre, pass);				    
					if(identificado!=null)
					{
						Usuario userIdentified = new Usuario(nombre,  null, null);
					    userIdentified.setPass(pass);
					    passUsuario.setText("");
						if(identificado.equalsIgnoreCase("0"))
						{
							String pEmail=null;
							int cont = 3;
							while(pEmail==null && cont>0 && C_Administracion.getMiAdmin().obtenerUsuario(pEmail)==null)
							{
								pEmail = JOptionPane.showInputDialog(null, "Introduzca su email, le quedan "+cont+" intentos.");
								cont--;
							}
							if(pEmail!=null && EmailValidator.validateEmail(pEmail))
							{
								Usuario user =C_Administracion.getMiAdmin().obtenerUsuario(pEmail);
								if(user!=null)
								{
									if(user.getNombre().equals(userIdentified.getNombre()))
									{
										IU_Doctor IU_DR = new IU_Doctor(textUsuario.getText(),pEmail);
										IU_DR.setVisible(true);
									}
									else
									{
										JOptionPane.showMessageDialog(null, "El email introducido no corresponde con el usuario", "Control doctor", JOptionPane.ERROR_MESSAGE);
										dispose();
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Email no registrado en el sistema", "Control doctor", JOptionPane.ERROR_MESSAGE);
									dispose();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Email no valido", "Control doctor", JOptionPane.ERROR_MESSAGE);
								dispose();
							}							
						}
						else if (identificado.equalsIgnoreCase("1"))
						{
							IU_Admin IU_admin= new IU_Admin(textUsuario.getText());
							IU_admin.setVisible(true);
							passUsuario.setText("");
							dispose();
						}					
					}
					else{
						
						JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos, vuelva a intentarlo.");
					}					
				}
			}
		});
		btnEntrar.setBounds(27, 160, 219, 25);
		contentPane.add(btnEntrar);
		
		final JButton btnCambiarPass = new JButton("Cambiar contraseña");
		btnCambiarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCambiarPass){
					dispose();
					IU_CambiarPass IU_CP = new IU_CambiarPass();
					IU_CP.setVisible(true);
				}
			}
		});
		btnCambiarPass.setBounds(27, 197, 219, 25);
		contentPane.add(btnCambiarPass);
		/*
		 * Para restablecer la contraseña es necesario introducir el email de la cuenta con la que estamos registrados en el campo usuario.
		 */
		final JButton btnRecuperarPass = new JButton("¿Olvidaste tu contraseña?");
		btnRecuperarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRecuperarPass && EmailValidator.validateEmail(textUsuario.getText()))
				{
					String email = textUsuario.getText();
					String pregunta = C_Administracion.getMiAdmin().obtenerPregunta(email);
					if(pregunta!=null)
					{
						IU_Restablecer IU_R = new IU_Restablecer(pregunta,email);
						IU_R.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "El email no está registrado");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Formato de email no soportado");
				}
			}
		});
		btnRecuperarPass.setBounds(27, 237, 219, 25);
		contentPane.add(btnRecuperarPass);
	}
}
