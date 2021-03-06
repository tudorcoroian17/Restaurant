package presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.Restaurant;
import data.RestaurantSerializator;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	public Restaurant restaurant = new Restaurant();
	private JPanel contentPane;

	public void start() {
		MainGUI frame = new MainGUI();
		frame.setVisible(true);
	}

	public MainGUI() {
		super("Restaurant");
		restaurant = RestaurantSerializator.deserialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblChooseTheMethod = new JLabel("Choose the method of logging in");
		GridBagConstraints gbc_lblChooseTheMethod = new GridBagConstraints();
		gbc_lblChooseTheMethod.insets = new Insets(0, 0, 5, 0);
		gbc_lblChooseTheMethod.gridx = 0;
		gbc_lblChooseTheMethod.gridy = 0;
		panel.add(lblChooseTheMethod, gbc_lblChooseTheMethod);
		
		JButton btnAdministrator = new JButton("Administrator");
		GridBagConstraints gbc_btnAdministrator = new GridBagConstraints();
		gbc_btnAdministrator.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdministrator.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdministrator.gridx = 0;
		gbc_btnAdministrator.gridy = 1;
		panel.add(btnAdministrator, gbc_btnAdministrator);
		btnAdministrator.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				AdminGUI frame = new AdminGUI();
				frame.start(frame, restaurant);
			}
			
		});
		
		JButton btnWaiter = new JButton("Waiter");
		GridBagConstraints gbc_btnWaiter = new GridBagConstraints();
		gbc_btnWaiter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWaiter.insets = new Insets(0, 0, 5, 0);
		gbc_btnWaiter.gridx = 0;
		gbc_btnWaiter.gridy = 2;
		panel.add(btnWaiter, gbc_btnWaiter);
		btnWaiter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				WaiterGUI frame = new WaiterGUI();
				frame.start(frame, restaurant);
			}
			
		});
		
		JButton btnShowMenu = new JButton("Show Menu");
		GridBagConstraints gbc_btnShowMenu = new GridBagConstraints();
		gbc_btnShowMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShowMenu.gridx = 0;
		gbc_btnShowMenu.gridy = 3;
		panel.add(btnShowMenu, gbc_btnShowMenu);
		btnShowMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				MenuGUI frame = new MenuGUI();
				frame.start(frame, restaurant);
			}
			
		});
	}

}
