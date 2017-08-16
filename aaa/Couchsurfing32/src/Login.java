/*
This class designs the format of login page 
*
* @author Qianyu.liu
* @XJTLUID 1201502
* @version 1.0 2nd March 2015
*/

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
	private JFrame userform;
	private JLabel jlabel, jlabel1;
	private GridBagLayout gridbag;
	private GridBagConstraints constraints;
	private JTextField jtfield1;
	private JPasswordField jpfield1;
	private JButton jbutton1, jbutton2;
	private JPanel jpanel;
	private String username;
	private String password;
	private JLabel nonavaliable;

	public Login() {
		userform = new JFrame();
		jlabel = new JLabel();
		jlabel1 = new JLabel();
		jtfield1 = new JTextField();
		jpfield1 = new JPasswordField();
		gridbag = new GridBagLayout();
		jbutton1 = new JButton();
		jbutton2 = new JButton();
		nonavaliable = new JLabel();
		nonavaliable.setText("welcome to this ");
		init();
	}

	private void init() {

		userform.setTitle("LOGIN");

		jpanel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon img = new ImageIcon(
						new ImageIcon("img/w7.jpg").getImage()
								.getScaledInstance(
										Toolkit.getDefaultToolkit()
												.getScreenSize().width,
										Toolkit.getDefaultToolkit()
												.getScreenSize().height,
										Image.SCALE_DEFAULT));
				;

				img.paintIcon(this, g, 0, 0);
			}
		};

		jlabel.setText("User£º");
		jlabel1.setText("Password£º");
		jbutton1.setText("Login");
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);

		jbutton2.setText("  Exit  ");

		// set up login label and buttons
		userform.setUndecorated(true);
		userform.getGraphicsConfiguration().getDevice()
				.setFullScreenWindow(userform);

		
		jpanel.setOpaque(true);
		jpanel.setLayout(gridbag);

		// set up the layout of the frame
		constraints = getGridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						20, 0, 20, 0), 0, 0);

		gridbag.setConstraints(jlabel, constraints);
		jpanel.add(jlabel);

		// set up the format
		constraints = getGridBagConstraints(1, 0, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						20, 0, 20, 0), 200, 0);

		gridbag.setConstraints(jtfield1, constraints);
		jpanel.add(jtfield1);

		
		constraints = getGridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						20, 0, 20, 0), 0, 0);
		gridbag.setConstraints(jlabel1, constraints);
		jpanel.add(jlabel1);

		
		constraints = getGridBagConstraints(1, 1, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						20, 0, 20, 0), 200, 0);

		gridbag.setConstraints(jpfield1, constraints);
		jpanel.add(jpfield1);

		constraints = getGridBagConstraints(0, 2, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						20, 0, 20, 0), 0, 0);

		gridbag.setConstraints(jbutton1, constraints);
		jpanel.add(jbutton1);

		
		constraints = getGridBagConstraints(1, 2, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						20, 0, 20, 0), 0, 0);

		gridbag.setConstraints(jbutton2, constraints);
		jpanel.add(jbutton2);

		userform.add(jpanel);
		constraints = getGridBagConstraints(1, 3, 1, 1, 0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						20, 0, 20, 0), 0, 0);
		gridbag.setConstraints(nonavaliable, constraints);
		jpanel.add(nonavaliable);
	}

	private static GridBagConstraints getGridBagConstraints(int gridx,
			int gridy, int gridwidth, int gridheight, double weightx,
			double weighty, int anchor, int fill, Insets insets, int ipadx,
			int ipady) {

		return new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, insets, ipadx, ipady);
	}

	public void showMe() {
		userform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userform.setVisible(true);
	}

	public static void main(String[] args) {
		new Login().showMe();
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.jbutton1) {
			username = jtfield1.getText();
			password = jpfield1.getText();
			if (username.equals("Qianyu.Liu") && password.equals("lqy19940208")) {
				new HouseManagerGUI();
				userform.setVisible(false);
			} else {
				nonavaliable.setText("Nonavaliable!");
				// nonavaliable.setFont();
				nonavaliable.setSize(30, 50);
				jtfield1.setText("");
				jpfield1.setText("");

			}
		}
		if (e.getSource() == this.jbutton2) {
			System.exit(0);
		}
	}
}
