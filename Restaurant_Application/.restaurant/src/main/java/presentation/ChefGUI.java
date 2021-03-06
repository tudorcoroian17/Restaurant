package presentation;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.Order;
import businessLogic.Restaurant;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Insets;

@SuppressWarnings("serial")
public class ChefGUI extends JFrame implements Observer{

	private JPanel contentPane;
	private Restaurant restaurant;
	JLabel lblNewLabel = new JLabel("");

	public void start(ChefGUI frame, Restaurant restaurant) {
		this.restaurant = restaurant;
		this.restaurant.addObserver(frame);
		frame.setVisible(false);
	}
	public ChefGUI() {
		super("Chef");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 0;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel lblTheChefIs = new JLabel("The chef is cooking");
		GridBagConstraints gbc_lblTheChefIs = new GridBagConstraints();
		gbc_lblTheChefIs.insets = new Insets(0, 0, 5, 5);
		gbc_lblTheChefIs.gridx = 1;
		gbc_lblTheChefIs.gridy = 0;
		panel.add(lblTheChefIs, gbc_lblTheChefIs);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 0;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 2;
		panel.add(verticalStrut, gbc_verticalStrut);
	}

	public void update(Observable arg0, Object arg1) {
		Order order = restaurant.orderList.get(restaurant.orderList.size() - 1);
		lblNewLabel.setText("Order " + String.valueOf(order.getOrderID() + " for table " + String.valueOf(order.getTable())));
		this.setVisible(true);
	}

}
