package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import pack.osakidetza.controladoras.C_Administracion;
import pack.osakidetza.controladoras.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

@SuppressWarnings("serial")
public class IU_Admin extends JFrame {

	private JPanel contentPane;
	private String doctor;
	private String emailDoctor;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Admin frame = new IU_Admin("Admin");
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
	public IU_Admin(final String pNomAdmin) {
		this.doctor=null;
		this.emailDoctor=null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblPanelDeAdministracin = new JLabel("Panel de Administración");
		lblPanelDeAdministracin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblPanelDeAdministracin.setBounds(32, 12, 382, 22);
		contentPane.add(lblPanelDeAdministracin);
		
		final JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSalir){
					dispose();
				}
			}
		});
		btnSalir.setBounds(402, 381, 117, 25);
		contentPane.add(btnSalir);
		
		JScrollPane scrollPaneMedicos = new JScrollPane();
		scrollPaneMedicos.setBounds(12, 89, 507, 197);
		contentPane.add(scrollPaneMedicos);
		

		final JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBorrar){					
					if(IU_Admin.this.doctor != null && IU_Admin.this.emailDoctor != null){
						IU_FastIdent IU_FI= new IU_FastIdent(IU_Admin.this.doctor,IU_Admin.this.emailDoctor,true, false);					
						IU_FI.setVisible(true);									
					}
				}
			}
		});
		btnBorrar.setBounds(145, 311, 117, 25);
		contentPane.add(btnBorrar);
		
		final JList listMedicos = new JList();
		listMedicos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					String medico= (String) listMedicos.getSelectedValue();
					String[] doctorAux = medico.split(";");
					IU_Admin.this.doctor=doctorAux[0];
					IU_Admin.this.emailDoctor=doctorAux[1];
				}
			}
		});
		listMedicos.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneMedicos.setViewportView(listMedicos);
		
		final JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnListar){
					ArrayList<Usuario> medicos=C_Administracion.getMiAdmin().listarMedicos();
					Iterator<Usuario> itr = medicos.iterator();
					DefaultListModel modelo = new DefaultListModel();
					while(itr.hasNext())
					{
						Usuario medico=itr.next();
						String item = medico.getNombre()+";"+medico.getEmail();						
						modelo.addElement(item);
					}
					listMedicos.setModel(modelo);
				}
			}
		});
		btnListar.setBounds(12, 311, 117, 25);
		contentPane.add(btnListar);
		
		final JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNuevo){
					IU_FormMedico IU_NM = new IU_FormMedico(pNomAdmin,"","","");
					IU_NM.setVisible(true);
				}
			}
		});
		btnNuevo.setBounds(274, 311, 117, 25);
		contentPane.add(btnNuevo);
		
		final JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnActualizar){
					if(IU_Admin.this.doctor != null && IU_Admin.this.emailDoctor != null){
						IU_FastIdent IU_FI= new IU_FastIdent(IU_Admin.this.doctor,IU_Admin.this.emailDoctor,false,false);					
						IU_FI.setVisible(true);									
					}
				}
			}
		});
		btnActualizar.setBounds(402, 311, 117, 25);
		contentPane.add(btnActualizar);
		
		JLabel lblMedicos = new JLabel("Medicos");
		lblMedicos.setBounds(12, 64, 70, 15);
		contentPane.add(lblMedicos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 45, 507, 22);
		contentPane.add(separator);
	}
}
