package pack.osakidetza.prototipos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Administracion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Administracion frame = new IU_Administracion();
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
	public IU_Administracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPanelDeAdministracin = new JLabel("Panel de Administración");
		lblPanelDeAdministracin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblPanelDeAdministracin.setBounds(32, 12, 382, 22);
		contentPane.add(lblPanelDeAdministracin);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(250, 46, 21, 240);
		contentPane.add(separator);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(402, 381, 117, 25);
		contentPane.add(btnSalir);
		
		JRadioButton rdbtnMedicos = new JRadioButton("Medicos");
		rdbtnMedicos.setBounds(8, 49, 149, 23);
		contentPane.add(rdbtnMedicos);
		
		JRadioButton rdbtnCancer = new JRadioButton("Cancer");
		rdbtnCancer.setBounds(313, 46, 149, 23);
		contentPane.add(rdbtnCancer);
		
		JScrollPane scrollPaneMedicos = new JScrollPane();
		scrollPaneMedicos.setBounds(12, 89, 190, 197);
		contentPane.add(scrollPaneMedicos);
		
		JList listMedicos = new JList();
		listMedicos.setModel(new AbstractListModel() {
			String[] values = new String[] {"Dr.Garcia Lobato", "Dra. Lopez Menendez"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneMedicos.setViewportView(listMedicos);
		
		JScrollPane scrollPaneCancer = new JScrollPane();
		scrollPaneCancer.setBounds(313, 89, 190, 197);
		contentPane.add(scrollPaneCancer);
		
		JList listCancer = new JList();
		listCancer.setModel(new AbstractListModel() {
			String[] values = new String[] {"Mama", "Ovario", "Trompa", "Otros"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneCancer.setViewportView(listCancer);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(12, 311, 117, 25);
		contentPane.add(btnListar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(145, 311, 117, 25);
		contentPane.add(btnBorrar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setBounds(274, 311, 117, 25);
		contentPane.add(btnNuevo);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(402, 311, 117, 25);
		contentPane.add(btnActualizar);
	}
}
