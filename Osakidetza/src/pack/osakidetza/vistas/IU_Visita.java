package pack.osakidetza.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Visita extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHist;
	private JTextField textFieldDesde;
	private JTextField textFieldHasta;
	private JTextField textFieldFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Visita frame = new IU_Visita();
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
	public IU_Visita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVisitas = new JLabel("Visitas");
		lblVisitas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblVisitas.setBounds(168, 12, 70, 15);
		contentPane.add(lblVisitas);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(12, 47, 70, 15);
		contentPane.add(lblPaciente);
		
		textFieldHist = new JTextField();
		textFieldHist.setBounds(114, 45, 114, 19);
		contentPane.add(textFieldHist);
		textFieldHist.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(12, 84, 105, 15);
		contentPane.add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 111, 504, 72);
		contentPane.add(textPane);
		
		JButton btnIntroducir = new JButton("Aceptar");
		btnIntroducir.setBounds(399, 310, 117, 25);
		contentPane.add(btnIntroducir);
		
		JLabel lblFechaInicial = new JLabel("Fecha desde");
		lblFechaInicial.setBounds(12, 266, 117, 15);
		contentPane.add(lblFechaInicial);
		
		textFieldDesde = new JTextField();
		textFieldDesde.setBounds(133, 264, 114, 19);
		contentPane.add(textFieldDesde);
		textFieldDesde.setColumns(10);
		
		JLabel lblFechaHasta = new JLabel("Fecha hasta");
		lblFechaHasta.setBounds(265, 266, 105, 15);
		contentPane.add(lblFechaHasta);
		
		textFieldHasta = new JTextField();
		textFieldHasta.setBounds(380, 264, 114, 19);
		contentPane.add(textFieldHasta);
		textFieldHasta.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(282, 47, 70, 15);
		contentPane.add(lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(380, 45, 114, 19);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JButton btnModificar = new JButton("Buscar"
				+ "");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(377, 210, 117, 25);
		contentPane.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(249, 210, 117, 25);
		contentPane.add(btnBorrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(265, 310, 117, 25);
		contentPane.add(btnVolver);
	}

}
