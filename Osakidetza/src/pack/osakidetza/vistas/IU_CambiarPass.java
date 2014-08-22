package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import pack.osakidetza.controladoras.C_Administracion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class IU_CambiarPass extends JFrame {

	private JPanel contentPane;
	private JTextField textResp;
	private JTextField textUser;
	private JPasswordField passOld;
	private JPasswordField passNew;
	private JPasswordField passRepite;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_CambiarPass frame = new IU_CambiarPass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public IU_CambiarPass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 26, 70, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(12, 65, 95, 15);
		contentPane.add(lblContrasea);
		
		JLabel lblContraseaNueva = new JLabel("Contraseña nueva");
		lblContraseaNueva.setBounds(12, 109, 158, 15);
		contentPane.add(lblContraseaNueva);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contraseña");
		lblRepitaLaContrasea.setBounds(12, 146, 158, 15);
		contentPane.add(lblRepitaLaContrasea);
		
		JLabel lblPreguntaDeSeguridad = new JLabel("Pregunta de seguridad");
		lblPreguntaDeSeguridad.setBounds(12, 213, 210, 15);
		contentPane.add(lblPreguntaDeSeguridad);
		
		final JTextPane textPaneAsk = new JTextPane();
		textPaneAsk.setBounds(12, 240, 357, 65);
		contentPane.add(textPaneAsk);
		
		JLabel lblRepuesta = new JLabel("Repuesta");
		lblRepuesta.setBounds(12, 317, 70, 15);
		contentPane.add(lblRepuesta);
		
		textResp = new JTextField();
		textResp.setBounds(12, 344, 357, 57);
		contentPane.add(textResp);
		textResp.setColumns(10);
		
		final JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==btnOk && passNew.getPassword().length != 0 && passOld.getPassword().length != 0 && passRepite.getPassword().length != 0
						&& textUser.getText().length() != 0 && textPaneAsk.getText().length()!=0 && textResp.getText().length()!=0){
					boolean changed = false;					
					String passNueva = String.valueOf(passNew.getPassword());
					String passNuevaR =String.valueOf(passRepite.getPassword());
					if(passNueva.equals(passNuevaR)){
						String passOld1 = String.valueOf(passOld.getPassword());
						changed = C_Administracion.getMiAdmin().cambiarPass(textUser.getText(), passOld1, passNueva, textPaneAsk.getText(), textResp.getText());
						if(changed){
							JOptionPane.showMessageDialog(null, "Contraseña actualizada con éxito");
							dispose();
							IU_Principal IU_P = new IU_Principal();
							IU_P.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(null, "Imposible actualizar la contraseña, intentelo de nuevo");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, intentelo de nuevo.");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Algunos campos necesarios están vacíos");
				}
			}
		});
		btnOk.setBounds(53, 424, 117, 25);
		contentPane.add(btnOk);
		
		final JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnCancel){
					dispose();
					IU_Principal IU_P = new IU_Principal();
					IU_P.setVisible(true);
				}
			}
		});
		btnCancel.setBounds(192, 424, 117, 25);
		contentPane.add(btnCancel);
		
		textUser = new JTextField();
		textUser.setBounds(176, 24, 193, 19);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		passOld = new JPasswordField();
		passOld.setBounds(176, 63, 193, 19);
		contentPane.add(passOld);
		
		passNew = new JPasswordField();
		passNew.setBounds(176, 107, 193, 19);
		contentPane.add(passNew);
		
		passRepite = new JPasswordField();
		passRepite.setBounds(176, 144, 193, 19);
		contentPane.add(passRepite);
	}
}
