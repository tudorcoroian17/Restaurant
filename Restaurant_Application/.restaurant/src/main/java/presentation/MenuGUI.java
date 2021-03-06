package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.CompositeProduct;
import businessLogic.MenuItem;
import businessLogic.Restaurant;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MenuGUI extends JFrame {

	private JPanel contentPane;
	public Restaurant restaurant;
	
	private JList<String> list = new JList<String>();

	public void start(MenuGUI frame, Restaurant restaurant) {
		this.restaurant = restaurant;
		String[] stringBuilder = new String[100];
		int i = 0;
		for(MenuItem it : restaurant.getMenu()) {
			stringBuilder[i++] = it.getName();
		}
		list.setListData(stringBuilder);
		frame.setVisible(true);
	}

	public MenuGUI() {
		super("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 2;
		gbc_horizontalStrut_2.gridy = 0;
		contentPane.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		contentPane.add(horizontalStrut, gbc_horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 4;
		gbc_horizontalStrut_1.gridy = 1;
		contentPane.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(list);

		final JList<String> list_1 = new JList<String>();
		list.addMouseListener(new MouseListener() {

			String[] sb;
			public void mouseClicked(MouseEvent arg0) {
				sb = new String[100];
				String item = list.getSelectedValue();
				MenuItem product = null;
				for(MenuItem it : restaurant.getMenu()) {
					if (it.getName().contentEquals(item)) {
						product = it;
					}
				}
				if (product == null) return;
				if (product.getClass().toString().contentEquals("class businessLogic.BaseProduct")) {
					sb[0] = product.getName() + " is a BaseProduct.";
					list_1.setListData(sb);
					return;
				}
				int i = 0;
				for(MenuItem it : ((CompositeProduct)product).getProduct()) {
					sb[i++] = it.getName() + "----" + String.valueOf(it.getPrice()) + "Mons";
				}
				list_1.setListData(sb);
				return;
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 2;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		scrollPane_1.setViewportView(list_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 3;
		contentPane.add(verticalStrut, gbc_verticalStrut);
	}

}
