package pack.osakidetza.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class IU_ListaVisitas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_ListaVisitas frame = new IU_ListaVisitas();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_ListaVisitas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeVisitas = new JLabel("Lista de visitas");
		lblListaDeVisitas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblListaDeVisitas.setBounds(26, 12, 271, 60);
		contentPane.add(lblListaDeVisitas);
		
		JScrollPane scrollPanevisit = new JScrollPane();
		scrollPanevisit.setBounds(26, 69, 259, 305);
		contentPane.add(scrollPanevisit);
		
		JList listvisit = new JList();
		listvisit.setModel(new AbstractListModel() {
			String[] values = new String[] {"1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02", "1315;15/10/02"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPanevisit.setViewportView(listvisit);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(278, 459, 117, 25);
		contentPane.add(btnVolver);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(149, 459, 117, 25);
		contentPane.add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(26, 459, 117, 25);
		contentPane.add(btnActualizar);
	}

}
