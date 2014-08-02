package pack.osakidetza.prototipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Estudio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Estudio frame = new IU_Estudio();
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
	public IU_Estudio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoDoctor = new JLabel("Bienvenido Doctor");
		lblBienvenidoDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoDoctor.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 21));
		lblBienvenidoDoctor.setBounds(149, 12, 380, 96);
		contentPane.add(lblBienvenidoDoctor);	
		
		
		JButton btnEstudio = new JButton("Estudios");
		btnEstudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEstudio.setBounds(35, 262, 117, 25);
		contentPane.add(btnEstudio);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(192, 99, 308, 103);
		contentPane.add(lblIcon);
		
		ImageIcon icon = new ImageIcon("resources/osak.jpg");
		
		Image imagen = icon.getImage();
		
		ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(308,103,Image.SCALE_AREA_AVERAGING));
		 
		lblIcon.setIcon(iconoEscalado);
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.setBounds(192, 262, 117, 25);
		contentPane.add(btnPacientes);
		
		JButton btnEstadsticas = new JButton("Estadísticas");
		btnEstadsticas.setBounds(514, 262, 146, 25);
		contentPane.add(btnEstadsticas);
		
		JButton btnDiagnosticos = new JButton("Diagnosticos");
		btnDiagnosticos.setBounds(349, 262, 138, 25);
		contentPane.add(btnDiagnosticos);
	}
}
