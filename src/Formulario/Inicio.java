package Formulario;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clase.Contactos;


public class Inicio extends JFrame {
	ArrayList Agenda = new ArrayList();

	private JPanel contentPane;
	private static JTextField textNombre;
	private static JTextField textApellido;
	private static JTextField textDireccion;
	private static JTextField textEmail;
	private static JTextField textTelefono;
	private JTextField textBuscar;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(47, 72, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(47, 132, 46, 14);
		contentPane.add(lblApellido);

		JLabel lblDireccion = new JLabel("Direcccion");
		lblDireccion.setBounds(47, 185, 66, 14);
		contentPane.add(lblDireccion);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(47, 241, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(47, 320, 66, 14);
		contentPane.add(lblTelefono);

		textNombre = new JTextField();
		textNombre.setBounds(152, 69, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setBounds(152, 129, 86, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);

		textDireccion = new JTextField();
		textDireccion.setBounds(152, 182, 221, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(152, 238, 221, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setText("");
		textTelefono.setBounds(152, 317, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		JLabel lblNewLabel = new JLabel("Agenda Telefonica");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(108, 25, 178, 33);
		contentPane.add(lblNewLabel);

		JButton btnGuargar = new JButton("Guardar");
		btnGuargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String n = textNombre.getText();
				String a = textApellido.getText();
				String d = textDireccion.getText();
				String e = textEmail.getText();
				String t = textTelefono.getText();

				if (!n.isEmpty()) {
					if (!a.isEmpty()) {
						if (!d.isEmpty()) {
							if (!e.isEmpty()) {
								if (!t.isEmpty()) {

									Contactos con = new Contactos(n, a, d, e, t);
									Agenda.add(con);
									JOptionPane.showMessageDialog(null, "El contacto ha sido añadido correctamente");
									textNombre.setText("");
									textApellido.setText("");
									textDireccion.setText("");
									textEmail.setText("");
									textTelefono.setText("");

								} else {
									JOptionPane.showMessageDialog(null, "El campo Telefono esta vacio");
								}
							} else {
								JOptionPane.showMessageDialog(null, "El campo Email esta vacio");
							}
						} else {
							JOptionPane.showMessageDialog(null, "El campo Dirrecion esta vacio");
						}

					} else {
						JOptionPane.showMessageDialog(null, "El campo Apellido esta vacio");
					}

				} else {
					JOptionPane.showMessageDialog(null, "El campo Nombre esta vacio");
				}

			}
		});
		btnGuargar.setBounds(284, 381, 89, 23);
		contentPane.add(btnGuargar);
		CrearModelo();

		JButton btnmostrar = new JButton("Mostrar");
		btnmostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o[] = null;
				for (int i = 0; i < Agenda.size(); i++) {
					Contactos c = (Contactos) Agenda.get(i);
					M.addRow(o);
					M.setValueAt(c.getNombre(), i, 0);
					M.setValueAt(c.getApellido(), i, 1);
					M.setValueAt(c.getDireccion(), i, 2);
					M.setValueAt(c.getEmail(), i, 3);
					M.setValueAt(c.getTelefono(), i, 4);
				}
			}
		});
		btnmostrar.setBounds(359, 34, 89, 23);
		contentPane.add(btnmostrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(468, 72, 541, 426);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(M);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Buscar = textBuscar.getText();
				textBuscar.setText("");
				buscar(Buscar);
			}
		});
		btnBuscar.setBounds(458, 34, 89, 23);
		contentPane.add(btnBuscar);

		textBuscar = new JTextField();
		textBuscar.setBounds(585, 35, 270, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNombre.setText("");
				textApellido.setText("");
				textDireccion.setText("");
				textEmail.setText("");
				textTelefono.setText("");
			}
		});
		btnLimpiar.setBounds(284, 443, 89, 23);
		contentPane.add(btnLimpiar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(24, 456, 89, 23);
		contentPane.add(btnSalir);

	}

	public static void cargarDatos(Contactos con) {
		textNombre.setText(con.getNombre());
		textApellido.setText(con.getApellido());
		textDireccion.setText(con.getDireccion());
		textEmail.setText(con.getEmail());
		textTelefono.setText(con.getTelefono());

	}

	DefaultTableModel M;



	private void CrearModelo() {
		try {
			M = (new DefaultTableModel(null, new String[] { "Nombre", "Apellido", "Direccion", "Email", "Telefono" }) {
			});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}



	public void buscar(String bus) {
		for (int i = 0; i < Agenda.size(); i++) {
			Contactos c = (Contactos) Agenda.get(i);
			if (c.getEmail().equalsIgnoreCase(bus)) {
				Inicio.cargarDatos(c);
			} else if ((c.getTelefono()).equalsIgnoreCase(bus)) {
				Inicio.cargarDatos(c);
			}


			if (bus.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Por favor ingrese un numero de telefono o un email para la busqueda");
			}
		}

	}
}
