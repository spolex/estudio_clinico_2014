package pack.osakidetza.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import pack.osakidetza.controladoras.C_Administracion;
import pack.osakidetza.controladoras.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_FastIdent extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	private JTextField textUsuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_FastIdent frame = new IU_FastIdent(null,null,false);
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
	public IU_FastIdent(final String pNom,final String pEmail,final boolean darDeBaja) {
		setTitle("Verificar identidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				if(e.getSource()==btnAceptar && darDeBaja){
					if(textUsuario.getText().length()!=0 && pass.getPassword().length!=0){
						String rdo=C_Administracion.getMiAdmin().identificarse(textUsuario.getText(), String.valueOf(pass.getPassword()));
						if(rdo!=null && rdo.equals("1")){
								if(C_Administracion.getMiAdmin().darDeBajaUsuario(pNom,pEmail)){
									JOptionPane.showMessageDialog(null, "Usuario dado de baja con éxito");
									dispose();
								}
								else{
									JOptionPane.showMessageDialog(null, "El usuario no está de alta en el sistema");
									dispose();
								}								
						}
						else{
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
					}
				}
				else if (e.getSource()==btnAceptar && !darDeBaja){
					Usuario user=C_Administracion.getMiAdmin().obtenerUsuario(pEmail);
					IU_FormMedico IU_FM = new IU_FormMedico(textUsuario.getText(), user.getNombre(), user.getEmail(), user.getEsp());
					IU_FM.setVisible(true);
					dispose();
				}
			}
		});
		btnAceptar.setBounds(81, 237, 117, 25);
		contentPane.add(btnAceptar);
	}
	
}
