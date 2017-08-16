/*
This class designs the house managemer's work desk as well as several work functions.
*
* @author Qianyu.liu
* @XJTLUID 1201502
* @version 1.0 2nd March 2015
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class HouseManagerGUI extends JFrame implements ActionListener {

	private int picturenumber;
	private static final JPanel northPanel = null;

	private JPanel tablePanel = new JPanel();
	private JPanel southPanel = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon img = new ImageIcon(new ImageIcon("img/w6.jpg")
					.getImage().getScaledInstance(
							Toolkit.getDefaultToolkit().getScreenSize().width,
							Toolkit.getDefaultToolkit().getScreenSize().height,
							Image.SCALE_DEFAULT));
			;

			img.paintIcon(this, g, 0, 0);
		}
	};
	private final String[] Userinfor = { "User Name" };
	private final String[] HouseInfo = { "House Number", "Room type",
			"Address", "Telephone", "Picture Number" };
	private Object[][] HouseObject;
	private JTable houseinfortable; // a room table
	private JLabel username;
	private JScrollPane House;
	private JTextField userText, housenumberText, raText, aText, tText, pText; // room
																				// number
																				// and
																				// room
																				// name
																				// text
	private JButton addRoom, deleteRoom; // add and delete a room button
	private JButton login;
	private TableColumnModel Modeloftable;
	private DefaultTableModel Motable;
	Mysqlimplementation dao = new Mysqlimplementation();
	Houseinfor house = new Houseinfor();

	//
	// LAYOUT FRAME
	//
	public HouseManagerGUI() {

		try {

		} catch (Exception e) {

			e.printStackTrace();
		}

		getTableArray();
		// init1();
		init();
		Display();
		pack();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}

	public void Display() {
		setTitle("House Informarion manager server");
		setResizable(false);
		setSize(new Dimension(750, 500));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screensize.getWidth();
		int height = (int) screensize.getHeight();
		setLocation((width - 550) / 2, (height - 700) / 2);
		setVisible(true);
	}

	// layout the UI

	public void getTableArray() {

		try {
			HouseObject = new Object[dao.findallhouseinfor().size()][];
			for (int i = 0; i < dao.findallhouseinfor().size(); i++) {
				Object[] rowdata = {
						dao.findallhouseinfor().get(i).getHousenumber(),
						dao.findallhouseinfor().get(i).getRoom_type(),
						dao.findallhouseinfor().get(i).getAddress(),
						dao.findallhouseinfor().get(i).getTelephone(),
						dao.findallhouseinfor().get(i).getPicturenumber() };
				for (int j = 0; j < HouseObject.length; j++) {
					HouseObject[i] = rowdata;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void init() {

		userText = new JTextField(15);
		housenumberText = new JTextField(15);
		raText = new JTextField(15);
		aText = new JTextField(15);
		tText = new JTextField(15);
		pText = new JTextField(15);
		login = new JButton("Login");
		addRoom = new JButton("Add");
		deleteRoom = new JButton("Delete");
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		Motable = new DefaultTableModel(HouseObject, HouseInfo);
		houseinfortable = new JTable(Motable);
		username = new JLabel("Login");
		House = new JScrollPane(houseinfortable);
		houseinfortable.getTableHeader().setReorderingAllowed(false);
		houseinfortable.getTableHeader().setResizingAllowed(false);
		Modeloftable = houseinfortable.getColumnModel();
		Modeloftable.getColumn(0).setPreferredWidth(60);
		Modeloftable.getColumn(1).setPreferredWidth(60);
		houseinfortable.setEnabled(false);
		houseinfortable.setBackground(Color.GREEN);
		// / House.setPreferredSize(new Dimension(505, 130));
		tablePanel.add(House);
		southPanel.setLayout(new GridBagLayout());

		login.addActionListener(this);

		addItem(southPanel, new JLabel("House Number"), 0, 1, 1, 1,
				GridBagConstraints.CENTER);
		addItem(southPanel, this.housenumberText, 1, 1, 1, 1,
				GridBagConstraints.CENTER);
		addItem(southPanel, new JLabel("Room Type"), 0, 2, 1, 1,
				GridBagConstraints.CENTER);
		addItem(southPanel, this.raText, 1, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(southPanel, new JLabel("Address"), 0, 3, 1, 1,
				GridBagConstraints.CENTER);
		addItem(southPanel, this.aText, 1, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(southPanel, new JLabel("Telephone"), 0, 4, 1, 1,
				GridBagConstraints.CENTER);
		addItem(southPanel, this.tText, 1, 4, 1, 1, GridBagConstraints.CENTER);
		addItem(southPanel, new JLabel("Picture Number"), 0, 5, 1, 1,
				GridBagConstraints.CENTER);
		addItem(southPanel, this.pText, 1, 5, 1, 1, GridBagConstraints.CENTER);
		addItem(southPanel, this.addRoom, 0, 6, 1, 1, GridBagConstraints.CENTER);
		addItem(southPanel, this.deleteRoom, 1, 6, 1, 1,
				GridBagConstraints.CENTER);

		container.add(tablePanel, BorderLayout.CENTER);
		container.add(southPanel, BorderLayout.SOUTH);
		addRoom.addActionListener(this);
		deleteRoom.addActionListener(this);

	}

	private void addItem(JPanel p, JComponent c, int x, int y, int width,
			int height, int align) {
		GridBagConstraints gConstraints = new GridBagConstraints();
		gConstraints.gridx = x;
		gConstraints.gridy = y;
		gConstraints.weightx = width;
		gConstraints.gridheight = height;
		gConstraints.weightx = 50.0;
		gConstraints.weighty = 50.0;
		gConstraints.insets = new Insets(4, 4, 4, 4);
		gConstraints.anchor = align;
		gConstraints.fill = GridBagConstraints.NONE;
		p.add(c, gConstraints);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.addRoom) {
			house.setHousenumber(Integer.valueOf(housenumberText.getText())
					.intValue());
			house.setRoom_type(raText.getText());
			house.setAddress(aText.getText());
			house.setTelephone(Integer.valueOf(tText.getText()).intValue());
			house.setPicturenumber(Integer.valueOf(pText.getText()).intValue());

			try {
				dao.add(house);
				JOptionPane.showMessageDialog(this,
						"The house information has been added successfully!",
						null, JOptionPane.INFORMATION_MESSAGE);
				housenumberText.setText("");
				raText.setText("");
				aText.setText("");
				tText.setText("");
				pText.setText("");
				getTableArray();
				Motable.setDataVector(HouseObject, HouseInfo);
				Motable.fireTableDataChanged();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == this.deleteRoom) {

			picturenumber = Integer.valueOf(pText.getText()).intValue();

			try {
				dao.delete(picturenumber);
				housenumberText.setText("");
				raText.setText("");
				aText.setText("");
				tText.setText("");
				pText.setText("");
				getTableArray();
				Motable.setDataVector(HouseObject, HouseInfo);
				Motable.fireTableDataChanged();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this,
					"The house information has been deleted successfully!",
					null, JOptionPane.INFORMATION_MESSAGE);

		}

	}

	public static void main(String[] args) {

		new HouseManagerGUI();

	}

}
