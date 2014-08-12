package pack.osakidetza.vistas;

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
import java.awt.Color;

public class IU_Doctor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Doctor frame = new IU_Doctor();
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
	public IU_Doctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		
		JLabel lblBienvenidoDoctor = new JLabel("Bienvenido Doctor");
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
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.setBounds(23, 262, 117, 25);
		contentPane.add(btnPacientes);
		
		JButton btnEstadsticas = new JButton("Estadísticas");
		btnEstadsticas.setBounds(172, 262, 146, 25);
		contentPane.add(btnEstadsticas);
		
		JButton btnVisitas = new JButton("Visitas");
		btnVisitas.setBounds(351, 262, 117, 25);
		contentPane.add(btnVisitas);
	}
}
