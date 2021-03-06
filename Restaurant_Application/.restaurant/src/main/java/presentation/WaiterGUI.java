package presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLogic.MenuItem;
import businessLogic.Order;
import businessLogic.Restaurant;
import data.RestaurantSerializator;
import data.WriteFile;

import java.awt.GridBagLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class WaiterGUI extends JFrame {
	
	public Restaurant restaurant;
	public ChefGUI chef;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JScrollPane scrollPane_2 = new JScrollPane();

	public void start(WaiterGUI frame, Restaurant restaurant) {
		this.restaurant = restaurant;
		chef = new ChefGUI();
		chef.start(chef,restaurant);
		tabbedPane.addTab("Orders", null, scrollPane_2, null);
		frame.setVisible(true);
	}

	public WaiterGUI() {
		super("Waiter");	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Create order", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 0;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblCreateANew = new JLabel("Create a new order");
		GridBagConstraints gbc_lblCreateANew = new GridBagConstraints();
		gbc_lblCreateANew.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateANew.gridx = 1;
		gbc_lblCreateANew.gridy = 1;
		panel.add(lblCreateANew, gbc_lblCreateANew);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 2;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel lblTable = new JLabel("Table:");
		GridBagConstraints gbc_lblTable = new GridBagConstraints();
		gbc_lblTable.anchor = GridBagConstraints.WEST;
		gbc_lblTable.insets = new Insets(0, 0, 5, 5);
		gbc_lblTable.gridx = 0;
		gbc_lblTable.gridy = 3;
		panel.add(lblTable, gbc_lblTable);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblItems = new JLabel("Items:");
		GridBagConstraints gbc_lblItems = new GridBagConstraints();
		gbc_lblItems.anchor = GridBagConstraints.WEST;
		gbc_lblItems.insets = new Insets(0, 0, 5, 5);
		gbc_lblItems.gridx = 0;
		gbc_lblItems.gridy = 4;
		panel.add(lblItems, gbc_lblItems);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 5;
		panel.add(lblDate, gbc_lblDate);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnCreateOrder = new JButton("Create order");
		GridBagConstraints gbc_btnCreateOrder = new GridBagConstraints();
		gbc_btnCreateOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateOrder.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateOrder.gridx = 1;
		gbc_btnCreateOrder.gridy = 6;
		panel.add(btnCreateOrder, gbc_btnCreateOrder);
		btnCreateOrder.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String table = textField.getText();
				String items = textField_1.getText();
				String date  = textField_3.getText();
				if(table.contentEquals("")) {
					textField.setText("Please input table number.");
					return;
				}
				if(items.contentEquals("")) {
					textField_1.setText("Please input items.");
					return;
				}
				if(date.contentEquals("")) {
					textField_3.setText("Please input date.");
					return;
				}
				int tableNo = Integer.parseInt(table);
				String[] products = items.split(", ");
				String[] dateS = date.split("/");
				if(dateS.length == 0) {
					textField_3.setText("Invalid date format. Try DD/MM/YYYY.");
					return;
				}
				int day = Integer.parseInt(dateS[0]);
				int month = Integer.parseInt(dateS[1]);
				int year = Integer.parseInt(dateS[2]);
				ArrayList<MenuItem> orderedItems = new ArrayList<MenuItem>();
				for(String it : products) {
					for(MenuItem it2 : restaurant.getMenu()) {
						if(it2.getName().contentEquals(it)) {
							orderedItems.add(it2);
						}
					}
				}
				if(orderedItems.size() == 0) {
					textField_1.setText("Invalid items.");
					return;
				}
				Order order = restaurant.createOrder(restaurant.id, day, month, year, tableNo, orderedItems);
				restaurant.id++;
				restaurant.addOrder(order, orderedItems);
				RestaurantSerializator.serialize(restaurant);
			}
			
		});
		
				final JList<Integer> list_1 = new JList<Integer>();
				
				JButton btnShowAllOrders = new JButton("Show all orders");
				GridBagConstraints gbc_btnShowAllOrders = new GridBagConstraints();
				gbc_btnShowAllOrders.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnShowAllOrders.insets = new Insets(0, 0, 5, 5);
				gbc_btnShowAllOrders.gridx = 1;
				gbc_btnShowAllOrders.gridy = 7;
				panel.add(btnShowAllOrders, gbc_btnShowAllOrders);
				btnShowAllOrders.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						Integer[] orderIDs = new Integer[100];
						int i = 0;
						for(Order it : restaurant.orderList) {
							orderIDs[i++] = it.getOrderID();
						}
						list_1.setListData(orderIDs);
					}
					
				});
				
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 8;
				panel.add(scrollPane, gbc_scrollPane);
				
				scrollPane.setViewportView(list_1);
				list_1.addMouseListener(new MouseListener() {

					public void mouseClicked(MouseEvent arg0) {
						Integer id = list_1.getSelectedValue();
						textField.setText(String.valueOf(restaurant.orderList.get(id).getTable()));
						String items = new String();
						for(MenuItem it : restaurant.orders.get(restaurant.orderList.get(id))) {
							if(items.contentEquals("")) {
								items = items.concat(it.getName());
							} else {
								items = items.concat(", ").concat(it.getName());
							}
						}
						textField_1.setText(items);
						String date = String.valueOf(restaurant.orderList.get(id).getOrderDate().getDay()) + "/" +
									  String.valueOf(restaurant.orderList.get(id).getOrderDate().getMonth()) + "/" +
									  String.valueOf(restaurant.orderList.get(id).getOrderDate().getYear());
						textField_3.setText(date);
						textField_4.setText(String.valueOf(id));
					}

					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				JLabel lblOrderId = new JLabel("Order id:");
				GridBagConstraints gbc_lblOrderId = new GridBagConstraints();
				gbc_lblOrderId.insets = new Insets(0, 0, 5, 5);
				gbc_lblOrderId.anchor = GridBagConstraints.WEST;
				gbc_lblOrderId.gridx = 0;
				gbc_lblOrderId.gridy = 9;
				panel.add(lblOrderId, gbc_lblOrderId);
				
				textField_4 = new JTextField();
				GridBagConstraints gbc_textField_4 = new GridBagConstraints();
				gbc_textField_4.insets = new Insets(0, 0, 5, 5);
				gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_4.gridx = 1;
				gbc_textField_4.gridy = 9;
				panel.add(textField_4, gbc_textField_4);
				textField_4.setColumns(10);
				
				JButton btnPrice = new JButton("Price:");
				GridBagConstraints gbc_btnPrice = new GridBagConstraints();
				gbc_btnPrice.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnPrice.insets = new Insets(0, 0, 5, 5);
				gbc_btnPrice.gridx = 0;
				gbc_btnPrice.gridy = 10;
				panel.add(btnPrice, gbc_btnPrice);
				btnPrice.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						Integer id = Integer.parseInt(textField_4.getText());
						Order order = null;
						for(Order it : restaurant.orderList) {
							if(it.getOrderID() == id) {
								order = it;
							}
						}
						if(order == null) {
							textField_4.setText("Invalid order id.");
							return;
						}
						double price = restaurant.computePrice(order);
						textField_2.setText(String.valueOf(price));
					}
					
				});
				
				textField_2 = new JTextField();
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 1;
				gbc_textField_2.gridy = 10;
				panel.add(textField_2, gbc_textField_2);
				textField_2.setColumns(10);
				
				JButton btnBill = new JButton("Bill");
				GridBagConstraints gbc_btnBill = new GridBagConstraints();
				gbc_btnBill.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnBill.insets = new Insets(0, 0, 5, 5);
				gbc_btnBill.gridx = 0;
				gbc_btnBill.gridy = 11;
				panel.add(btnBill, gbc_btnBill);
				btnBill.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						String name = new String();
						name = "Bill_" + textField_4.getText() + "_table_" + textField.getText() + ".txt";
						try {
							WriteFile writer = new WriteFile(name);
							String[] data = new String[20];
							data[0] = "Generated bill for order with id: " + textField_4.getText();
							int i = 1;
							for(MenuItem it : restaurant.orders.get(restaurant.orderList.get(Integer.parseInt(textField_4.getText())))) {
								data[i] = "Product " + it.getName() + " priced at " + String.valueOf(it.getPrice());
								i++;
							}
							double price = restaurant.computePrice(restaurant.orderList.get(Integer.parseInt(textField_4.getText())));
							data[i] = "Total of: " + String.valueOf(price);
							writer.setDataWritten(data);
							writer.setLines(++i);
							writer.write();
							writer.myWriter.close();
							textField_5.setText(name + " was generated.");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
				
				textField_5 = new JTextField();
				GridBagConstraints gbc_textField_5 = new GridBagConstraints();
				gbc_textField_5.insets = new Insets(0, 0, 5, 5);
				gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_5.gridx = 1;
				gbc_textField_5.gridy = 11;
				panel.add(textField_5, gbc_textField_5);
				textField_5.setColumns(10);
				
						final JList<String> list = new JList<String>();
						JButton btnShowMenu = new JButton("Show menu");
						GridBagConstraints gbc_btnShowMenu = new GridBagConstraints();
						gbc_btnShowMenu.fill = GridBagConstraints.HORIZONTAL;
						gbc_btnShowMenu.insets = new Insets(0, 0, 5, 5);
						gbc_btnShowMenu.gridx = 1;
						gbc_btnShowMenu.gridy = 12;
						panel.add(btnShowMenu, gbc_btnShowMenu);
						btnShowMenu.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								String[] stringBuilder = new String[100];
								int i = 0;
								for(MenuItem it : restaurant.getMenu()) {
									stringBuilder[i++] = it.getName() + "----" + String.valueOf(it.getPrice()) + "Mons";
								}
								list.setListData(stringBuilder);
							}
							
						});
						
						JScrollPane scrollPane_1 = new JScrollPane();
						GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
						gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
						gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
						gbc_scrollPane_1.gridx = 1;
						gbc_scrollPane_1.gridy = 13;
						panel.add(scrollPane_1, gbc_scrollPane_1);
						
						scrollPane_1.setViewportView(list);
						
						Component verticalStrut = Box.createVerticalStrut(20);
						GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
						gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
						gbc_verticalStrut.gridx = 1;
						gbc_verticalStrut.gridy = 14;
						panel.add(verticalStrut, gbc_verticalStrut);
						
						Component verticalStrut_1 = Box.createVerticalStrut(20);
						GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
						gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
						gbc_verticalStrut_1.gridx = 1;
						gbc_verticalStrut_1.gridy = 15;
						panel.add(verticalStrut_1, gbc_verticalStrut_1);
		
						
						JPanel panel_1 = new JPanel();
						contentPane.add(panel_1, BorderLayout.NORTH);
						
						JButton btnUpdateOrderTable = new JButton("Update order table");
						panel_1.add(btnUpdateOrderTable);
						btnUpdateOrderTable.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								updateTable(scrollPane_2);
							}
							
						});
	}
	
	public void updateTable(JScrollPane scrollPane_2) {
		table = new JTable(new DefaultTableModel(new Object[] {"Order id", "Table", "Date", "Total"}, 0));
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for(Order it : restaurant.orderList) { 
			model.addRow(new Object[] {it.getOrderID(), it.getTable(), 
									   it.getOrderDate().getDay() + "/" + it.getOrderDate().getMonth() + "/" + it.getOrderDate().getYear(),
									   round(restaurant.computePrice(it), 2)});
		}
		scrollPane_2.setViewportView(table);
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
