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

import pack.osakidetza.controladoras.C_Administracion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_Identificarse extends JFrame {

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
					IU_Identificarse frame = new IU_Identificarse();
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
	public IU_Identificarse() {
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
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(27, 71, 70, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(27, 111, 107, 15);
		contentPane.add(lblContrasea);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(133, 69, 194, 19);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		passUsuario = new JPasswordField();
		passUsuario.setBounds(133, 111, 194, 17);
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
						if(identificado.equalsIgnoreCase("0"))
						{
							IU_Doctor IU_DR = new IU_Doctor();
							IU_DR.setVisible(true);
						}
						else if (identificado.equalsIgnoreCase("1"))
						{
							IU_Administracion IU_admin= new IU_Administracion();
							IU_admin.setVisible(true);
						}
						
					}
					else{
						
						JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos, vuelva a intentarlo.");
					}					
				}
			}
		});
		btnEntrar.setBounds(27, 160, 194, 25);
		contentPane.add(btnEntrar);
		
		JButton btnCambiarPass = new JButton("Cambiar contraseña");
		btnCambiarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCambiarPass.setBounds(27, 197, 194, 25);
		contentPane.add(btnCambiarPass);
		
		JButton btnRecuperarPass = new JButton("Recuperar contraseña");
		btnRecuperarPass.setBounds(27, 237, 194, 25);
		contentPane.add(btnRecuperarPass);
	}
}
