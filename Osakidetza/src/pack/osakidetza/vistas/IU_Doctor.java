package pack.osakidetza.vistas;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IU_Doctor extends JFrame {

	private JPanel contentPane;
	private String email;


	/**
	 * Create the frame.
	 */
	public IU_Doctor(final String nombre, final String pEmail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		setResizable(false);
		this.email=pEmail;
		
		JLabel lblBienvenidoDoctor = new JLabel("Bienvenido Dr/a. "+nombre);
		lblBienvenidoDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoDoctor.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 21));
		lblBienvenidoDoctor.setBounds(60, 12, 380, 96);
		contentPane.add(lblBienvenidoDoctor);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBackground(Color.RED);
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(94, 105, 308, 103);
		contentPane.add(lblIcon);
		
		ImageIcon icon = new ImageIcon("resources/osak.jpg");
		
		Image imagen = icon.getImage();
		
		ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(308,103,Image.SCALE_AREA_AVERAGING));
		 
		lblIcon.setIcon(iconoEscalado);		
		final JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==btnPacientes){
						IU_Pacientes IU_P = new IU_Pacientes(IU_Doctor.this.email);
						IU_P.setVisible(true);
					}
			}
		});
		btnPacientes.setBounds(23, 262, 117, 25);
		contentPane.add(btnPacientes);
		
		final JButton btnEstadsticas = new JButton("Estadísticas");
		btnEstadsticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==btnEstadsticas)
				{
					IU_Estadisticas IU_E = new IU_Estadisticas();
					IU_E.setVisible(true);
				}
			}
		});
		btnEstadsticas.setBounds(172, 262, 146, 25);
		contentPane.add(btnEstadsticas);
		
		JButton btnVisitas = new JButton("Visitas");
		btnVisitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_FormVisita IU_FV = new IU_FormVisita(nombre,IU_Doctor.this.email,null);
				IU_FV.setVisible(true);
			}
		});
		btnVisitas.setBounds(351, 262, 117, 25);
		contentPane.add(btnVisitas);
	}
}
