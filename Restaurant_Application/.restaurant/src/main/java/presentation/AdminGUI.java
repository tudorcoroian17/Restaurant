package presentation;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLogic.BaseProduct;
import businessLogic.CompositeProduct;
import businessLogic.MenuItem;
import businessLogic.Restaurant;
import data.RestaurantSerializator;

import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class AdminGUI extends JFrame {

	public Restaurant restaurant;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public JButton btnUpdateItem;
	public JButton btnShow_2;
	public JButton btnDeleteItem;
	public JButton btnShow_1;
	public JButton btnAddIngredient;
	public JButton btnShow;
	public JButton btnAddItem;
	private JTable table;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JScrollPane scrollPane_3 = new JScrollPane();

	public void start(AdminGUI frame,Restaurant restaurant) {
		this.restaurant = restaurant;
		tabbedPane.addTab("Menu Table", null, scrollPane_3, null);
		frame.setVisible(true);
	}

	public AdminGUI() {
		super("Administrator");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add item", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblAddANew = new JLabel("Add a new item to the menu");
		GridBagConstraints gbc_lblAddANew = new GridBagConstraints();
		gbc_lblAddANew.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddANew.gridx = 1;
		gbc_lblAddANew.gridy = 0;
		panel.add(lblAddANew, gbc_lblAddANew);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 0;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 0;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel lblItemName = new JLabel("Item name");
		GridBagConstraints gbc_lblItemName = new GridBagConstraints();
		gbc_lblItemName.anchor = GridBagConstraints.WEST;
		gbc_lblItemName.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName.gridx = 0;
		gbc_lblItemName.gridy = 1;
		panel.add(lblItemName, gbc_lblItemName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.WEST;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 2;
		panel.add(lblPrice, gbc_lblPrice);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		btnAddItem = new JButton("Add item");
		GridBagConstraints gbc_btnAddItem = new GridBagConstraints();
		gbc_btnAddItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddItem.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddItem.gridx = 1;
		gbc_btnAddItem.gridy = 3;
		panel.add(btnAddItem, gbc_btnAddItem);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().contentEquals("")) {
					textField_1.setText("Please input item price.");
					return;
				}
				String itemName   = textField.getText();
				double price	  = Double.parseDouble(textField_1.getText());
				if(arg0.getSource() == btnAddItem) {
					if(itemName.contentEquals("")) textField.setText("Please input item name.");
					if(price == 0) textField_1.setText("Please input item price.");
					
					BaseProduct product = restaurant.createMenuItem(itemName, price);
					restaurant.addItemToMenu(product);
					RestaurantSerializator.serialize(restaurant);
					return;
					
				} else if(arg0.getSource() == btnAddIngredient) {
					MenuItem item = null;
					for(MenuItem it : restaurant.getMenu()) {
						if(it.getName().contentEquals(itemName)) {
							item = it;
						}
					}
					if(item == null) {
						textField_2.setText("Please input valid item.");
						return;
					}
				}
				
			}
		});

		final JList<String> list = new JList<String>();
		btnShow = new JButton("Show");
		GridBagConstraints gbc_btnShow = new GridBagConstraints();
		gbc_btnShow.insets = new Insets(0, 0, 5, 5);
		gbc_btnShow.gridx = 0;
		gbc_btnShow.gridy = 4;
		panel.add(btnShow, gbc_btnShow);
		btnShow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String[] stringBuilder = new String[100];
				int i = 0;
				for(MenuItem it : restaurant.getMenu()) {
					try {
						stringBuilder[i++] = it.getName() + "----" + String.valueOf(it.getPrice()) + "Mons";
					} catch (NullPointerException n) {
						stringBuilder[i++] = it.getName() + "----" + String.valueOf("0") + "Mons";
					}					
				}
				list.setListData(stringBuilder);
			}
			
		});
		
		JLabel lblCompleteOnlyIf = new JLabel("Complete only if adding a compound product");
		GridBagConstraints gbc_lblCompleteOnlyIf = new GridBagConstraints();
		gbc_lblCompleteOnlyIf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompleteOnlyIf.gridx = 1;
		gbc_lblCompleteOnlyIf.gridy = 4;
		panel.add(lblCompleteOnlyIf, gbc_lblCompleteOnlyIf);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		panel.add(scrollPane, gbc_scrollPane);
		
		scrollPane.setViewportView(list);
		
		JLabel lblIngredient = new JLabel("Ingredient");
		GridBagConstraints gbc_lblIngredient = new GridBagConstraints();
		gbc_lblIngredient.anchor = GridBagConstraints.WEST;
		gbc_lblIngredient.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngredient.gridx = 0;
		gbc_lblIngredient.gridy = 6;
		panel.add(lblIngredient, gbc_lblIngredient);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnAddIngredient = new JButton("Add ingredient");
		GridBagConstraints gbc_btnAddIngredient = new GridBagConstraints();
		gbc_btnAddIngredient.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddIngredient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddIngredient.gridx = 1;
		gbc_btnAddIngredient.gridy = 7;
		panel.add(btnAddIngredient, gbc_btnAddIngredient);
		btnAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().contentEquals("")) {
					textField_1.setText("Please input item price.");
					return;
				}
				String itemName   = textField.getText();
				double price	  = Double.parseDouble(textField_1.getText());
				String ingredient = textField_2.getText();
				if(arg0.getSource() == btnAddItem) {
					if(itemName.contentEquals("")) textField.setText("Please input item name.");
					if(price == 0) textField_1.setText("Please input item price.");
					
					BaseProduct product = restaurant.createMenuItem(itemName, price);
					restaurant.addItemToMenu(product);
					return;
					
				} else if(arg0.getSource() == btnAddIngredient) {
					MenuItem item = null;
					MenuItem ingredientC = null;
					for(MenuItem it : restaurant.getMenu()) {
						if(it.getName().contentEquals(itemName)) {
							item = it;
						}
					}
					for(MenuItem it : restaurant.getMenu()) {
						if(it.getName().contentEquals(ingredient)) {
							ingredientC = it;
						}
					}
					if(item == null) {
						textField.setText("Please input valid item.");
						return;
					}
					if(ingredientC == null) {
						textField_2.setText("Please input valid ingredient");
					}
					if(item.getClass().toString().contentEquals("class businessLogic.BaseProduct")) {
						item = new CompositeProduct(item.getName(), new ArrayList<MenuItem>());
						restaurant.deleteMenuItem(item.getName());
						restaurant.addItemToMenu((CompositeProduct)item);
						RestaurantSerializator.serialize(restaurant);
					}
					if(ingredientC.getClass().toString().contentEquals("class businessLogic.BaseProduct")) {
						restaurant.addItemToCompositeProduct((CompositeProduct)item, (BaseProduct)ingredientC);
						item.setPrice(item.computePrice());
						RestaurantSerializator.serialize(restaurant);
						return;
					}
					if(ingredientC.getClass().toString().contentEquals("class businessLogic.CompositeProduct")) {
						restaurant.addItemToCompositeProduct((CompositeProduct)item, (CompositeProduct)ingredientC);
						item.setPrice(item.computePrice());
						RestaurantSerializator.serialize(restaurant);
						return;
					}
					
				}
				
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 8;
		panel.add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 9;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Delete item", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblDeleteAnItem = new JLabel("Delete an item from the menu");
		GridBagConstraints gbc_lblDeleteAnItem = new GridBagConstraints();
		gbc_lblDeleteAnItem.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeleteAnItem.gridx = 1;
		gbc_lblDeleteAnItem.gridy = 0;
		panel_1.add(lblDeleteAnItem, gbc_lblDeleteAnItem);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 2;
		gbc_horizontalStrut_2.gridy = 0;
		panel_1.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_3.gridx = 3;
		gbc_horizontalStrut_3.gridy = 0;
		panel_1.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		JLabel lblItemName_1 = new JLabel("Item name");
		GridBagConstraints gbc_lblItemName_1 = new GridBagConstraints();
		gbc_lblItemName_1.anchor = GridBagConstraints.EAST;
		gbc_lblItemName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName_1.gridx = 0;
		gbc_lblItemName_1.gridy = 1;
		panel_1.add(lblItemName_1, gbc_lblItemName_1);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 1;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		
		btnDeleteItem = new JButton("Delete item");
		GridBagConstraints gbc_btnDeleteItem = new GridBagConstraints();
		gbc_btnDeleteItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeleteItem.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteItem.gridx = 1;
		gbc_btnDeleteItem.gridy = 2;
		panel_1.add(btnDeleteItem, gbc_btnDeleteItem);
		btnDeleteItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String item = textField_3.getText();
				if(item.contentEquals("")) {
					textField_3.setText("Please input the name of the item.");
				}
				MenuItem product = null;
				for(MenuItem it : restaurant.getMenu()) {
					if (it.getName().contentEquals(item)) {
						product = it;
					}
				}
				if (product == null) {
					textField_3.setText("Item not found.");
					return;
				}
				restaurant.deleteMenuItem(item);
				RestaurantSerializator.serialize(restaurant);
			}
			
		});

		final JList<String> list_1 = new JList<String>();
		btnShow_1 = new JButton("Show");
		GridBagConstraints gbc_btnShow_1 = new GridBagConstraints();
		gbc_btnShow_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShow_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnShow_1.gridx = 0;
		gbc_btnShow_1.gridy = 2;
		panel_1.add(btnShow_1, gbc_btnShow_1);
		btnShow_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String[] stringBuilder = new String[100];
				int i = 0;
				for(MenuItem it : restaurant.getMenu()) {
					stringBuilder[i++] = it.getName() + "----" + String.valueOf(it.getPrice()) + "Mons";
				}
				list_1.setListData(stringBuilder);
			}
			
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 3;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		scrollPane_1.setViewportView(list_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 4;
		panel_1.add(verticalStrut_2, gbc_verticalStrut_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 5;
		panel_1.add(verticalStrut_3, gbc_verticalStrut_3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update item", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblUpdateAnItem = new JLabel("Update an item from the menu");
		GridBagConstraints gbc_lblUpdateAnItem = new GridBagConstraints();
		gbc_lblUpdateAnItem.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpdateAnItem.gridx = 1;
		gbc_lblUpdateAnItem.gridy = 0;
		panel_2.add(lblUpdateAnItem, gbc_lblUpdateAnItem);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 2;
		gbc_horizontalStrut_4.gridy = 0;
		panel_2.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_5.gridx = 3;
		gbc_horizontalStrut_5.gridy = 0;
		panel_2.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		JLabel lblItemName_2 = new JLabel("Item name");
		GridBagConstraints gbc_lblItemName_2 = new GridBagConstraints();
		gbc_lblItemName_2.anchor = GridBagConstraints.WEST;
		gbc_lblItemName_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName_2.gridx = 0;
		gbc_lblItemName_2.gridy = 1;
		panel_2.add(lblItemName_2, gbc_lblItemName_2);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		panel_2.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewPrice = new JLabel("New price");
		GridBagConstraints gbc_lblNewPrice = new GridBagConstraints();
		gbc_lblNewPrice.anchor = GridBagConstraints.WEST;
		gbc_lblNewPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPrice.gridx = 0;
		gbc_lblNewPrice.gridy = 2;
		panel_2.add(lblNewPrice, gbc_lblNewPrice);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 2;
		panel_2.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewIngredient = new JLabel("New ingredient");
		GridBagConstraints gbc_lblNewIngredient = new GridBagConstraints();
		gbc_lblNewIngredient.anchor = GridBagConstraints.WEST;
		gbc_lblNewIngredient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewIngredient.gridx = 0;
		gbc_lblNewIngredient.gridy = 3;
		panel_2.add(lblNewIngredient, gbc_lblNewIngredient);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 3;
		panel_2.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		btnUpdateItem = new JButton("Update item");
		GridBagConstraints gbc_btnUpdateItem = new GridBagConstraints();
		gbc_btnUpdateItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUpdateItem.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateItem.gridx = 1;
		gbc_btnUpdateItem.gridy = 4;
		panel_2.add(btnUpdateItem, gbc_btnUpdateItem);
		btnUpdateItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String itemName   = textField_4.getText();
				double price	  = Double.parseDouble(textField_5.getText());
				String ingredient = textField_6.getText();
				
				MenuItem item = null;
				MenuItem ingredientC = null;
				for(MenuItem it : restaurant.getMenu()) {
					if(it.getName().contentEquals(itemName)) {
						item = it;
					}
				}
				for(MenuItem it : restaurant.getMenu()) {
					if(it.getName().contentEquals(ingredient)) {
						ingredientC = it;
					}
				}
				if(item == null) {
					textField.setText("Please input valid item.");
					return;
				}
				if(item.getClass().toString().contentEquals("class businessLogic.BaseProduct")) {
					if(ingredient.contentEquals("")) {
						restaurant.editMenuItem((BaseProduct)item, price);
						RestaurantSerializator.serialize(restaurant);
					} else {
						if(ingredientC == null) {
							textField_2.setText("Please input valid ingredient");
							return;
						}
						ArrayList<MenuItem> newIngredient = new ArrayList<MenuItem>();
						newIngredient.add(ingredientC);
						item = new CompositeProduct(item.getName(), newIngredient);
						restaurant.deleteMenuItem(item.getName());
						restaurant.addItemToMenu((CompositeProduct)item);
						item.setPrice(item.getPrice());
						RestaurantSerializator.serialize(restaurant);
						return;
					}
				} else {
					if(ingredientC == null) {
						textField_2.setText("Please input valid ingredient");
						return;
					}
					ArrayList<MenuItem> newIngredient = new ArrayList<MenuItem>();
					newIngredient.add(ingredientC);
					restaurant.editMenuItem(item.getName(), newIngredient, price);
					item.setPrice(item.computePrice());
					RestaurantSerializator.serialize(restaurant);
					return;
				}
			}
			
		});

		final JList<String> list_2 = new JList<String>();
		btnShow_2 = new JButton("Show");
		GridBagConstraints gbc_btnShow_2 = new GridBagConstraints();
		gbc_btnShow_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShow_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnShow_2.gridx = 0;
		gbc_btnShow_2.gridy = 4;
		panel_2.add(btnShow_2, gbc_btnShow_2);
		btnShow_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String[] stringBuilder = new String[100];
				int i = 0;
				for(MenuItem it : restaurant.getMenu()) {
					stringBuilder[i++] = it.getName() + "----" + String.valueOf(it.getPrice()) + "Mons";
				}
				list_2.setListData(stringBuilder);
			}
			
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 5;
		panel_2.add(scrollPane_2, gbc_scrollPane_2);
		
		scrollPane_2.setViewportView(list_2);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 6;
		panel_2.add(verticalStrut_4, gbc_verticalStrut_4);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 7;
		panel_2.add(verticalStrut_5, gbc_verticalStrut_5);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.NORTH);
		
		JButton btnUpdateMenuTable = new JButton("Update Menu Table");
		panel_3.add(btnUpdateMenuTable);
		btnUpdateMenuTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				updateTable(scrollPane_3);
			}
			
		});
	}
	
	public void updateTable(JScrollPane scrollPane_3) {

		table = new JTable(new DefaultTableModel(new Object[] {"Item name", "Item price"}, 0));
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for(MenuItem it : restaurant.getMenu()) { 
			model.addRow(new Object[] {it.getName(), String.valueOf(it.getPrice()) + " Mons"});
		}
		scrollPane_3.setViewportView(table);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
	}
	

}
