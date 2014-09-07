package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import pack.osakidetza.controladoras.C_Administracion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_Restablecer extends JFrame {

	private JPanel contentPane;
	private JTextField textResp;
	private JPasswordField passNueva;
	private JPasswordField passRepite;

	
	public IU_Restablecer(String pregunta,final String pEmail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JTextPane txtPreg = new JTextPane();
		txtPreg.setText(pregunta);
		txtPreg.setBounds(12, 12, 424, 106);
		contentPane.add(txtPreg);
		txtPreg.setEditable(false);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setBounds(22, 137, 138, 15);
		contentPane.add(lblRespuesta);
		
		textResp = new JTextField();
		textResp.setBounds(12, 164, 424, 19);
		contentPane.add(textResp);
		textResp.setColumns(10);
		
		final JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancel){
					dispose();
					IU_Principal IU_P = new IU_Principal();
					IU_P.setVisible(true);					
				}
			}
		});
		btnCancel.setBounds(319, 336, 117, 25);
		contentPane.add(btnCancel);
		
		final JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnOk)
				{
					String passN = new String(passNueva.getPassword());
					String passR = new String (passRepite.getPassword());
					if(passN.equals(passR))
					{
						if(C_Administracion.getMiAdmin().restablecerPass(pEmail,textResp.getText() , passN))
						{
							JOptionPane.showMessageDialog(null, "Contraseña restablecida con éxito");
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"La respuesta no es correcta");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
					}
				}
				
			}
		});
		btnOk.setBounds(188, 336, 117, 25);
		contentPane.add(btnOk);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contraseña");
		lblNuevaContrasea.setBounds(12, 216, 189, 15);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contraseña");
		lblRepitaLaContrasea.setBounds(12, 274, 170, 15);
		contentPane.add(lblRepitaLaContrasea);
		
		passNueva = new JPasswordField();
		passNueva.setBounds(188, 214, 252, 17);
		contentPane.add(passNueva);
		
		passRepite = new JPasswordField();
		passRepite.setBounds(188, 272, 252, 17);
		contentPane.add(passRepite);
	}
	
}
