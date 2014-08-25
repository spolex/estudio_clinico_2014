package pack.osakidetza.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import pack.osakidetza.controladoras.C_Doctor;
import pack.osakidetza.controladoras.Visita;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class IU_ListaVisitas extends JFrame {

	private JPanel contentPane;

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IU_ListaVisitas(final String pEmail, final String historial, Date fechaDesde, Date fechaHasta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblListaDeVisitas = new JLabel("Lista de visitas");
		lblListaDeVisitas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblListaDeVisitas.setBounds(26, 12, 271, 60);
		contentPane.add(lblListaDeVisitas);
		
		JScrollPane scrollPanevisit = new JScrollPane();
		scrollPanevisit.setBounds(26, 69, 259, 305);
		contentPane.add(scrollPanevisit);
		
		final JList listvisit = new JList();
		listvisit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		C_Doctor.getMiDoctor().resetVisitas();
		final DefaultListModel modelo= new DefaultListModel();
		Iterator<Visita> itr =null;
		if(fechaDesde==null && fechaHasta==null)
		{
			itr = C_Doctor.getMiDoctor().listarVisitas(pEmail);
		}
		else 
		{
			itr=C_Doctor.getMiDoctor().listarVisitasEntre(pEmail,new java.sql.Date(fechaDesde.getTime()),new java.sql.Date(fechaHasta.getTime()));
		}
		while(itr.hasNext()){
			Visita visita =itr.next();
			if(historial==null)
			{
				modelo.addElement(visita.getPaciente()+";"+visita.getMedico()+";"+visita.getFecha());
			}
			else
			{
				//para añadir sólo las correspondientes a un paciente, cuando viene de la interfaz de pacientes.
				if(visita.getPaciente().equals(historial))
				{
					modelo.addElement(visita.getPaciente()+";"+visita.getMedico()+";"+visita.getFecha());
				}
			}
		}
		listvisit.setModel(modelo);
		scrollPanevisit.setViewportView(listvisit);
		
		final JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnVolver){
					dispose();
					modelo.removeAllElements();
				}
			}
		});
		btnVolver.setBounds(278, 459, 117, 25);
		contentPane.add(btnVolver);
		
		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnEliminar){
					if(listvisit.getSelectedValue()!=null)
					{
						String visita= (String) listvisit.getSelectedValue();
						String[] pVisita = visita.split(";");
						java.util.Date fecha = new Date();
						try 
						{
							fecha = new SimpleDateFormat("yyyy-MM-dd").parse(pVisita[2]);
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(null, "Error en el formato de fecha", "Control de formato", ERROR);
						}
						Visita borraVisita = new Visita(pVisita[0], new java.sql.Date(fecha.getTime()), pVisita[1], pEmail);
						if(C_Doctor.getMiDoctor().eliminarVisita(borraVisita))
						{
							JOptionPane.showMessageDialog(null, "Visita borrada del sistema", "Control de visitas", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No ha sido posible borrar del sistema la visita", "Control de visitas", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Seleccione la visita que desea borrar", "Control de visitas", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnEliminar.setBounds(149, 459, 117, 25);
		contentPane.add(btnEliminar);
	}

}
