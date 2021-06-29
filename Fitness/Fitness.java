import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Fitness {

	private JFrame frmFitness;
	private JTextField txtEnterHeight;
	private JTextField txtEnterWeight;

	/**
	 * @author iriis
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fitness window = new Fitness();
					window.frmFitness.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Fitness() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmFitness = new JFrame();
		frmFitness.setTitle("Fitness");
		frmFitness.setBounds(100, 100, 249, 156);
		frmFitness.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtEnterHeight = new JTextField();
		txtEnterHeight.setColumns(10);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double weight = Double.parseDouble(txtEnterHeight.getText())/100.0;
				double height = Double.parseDouble(txtEnterWeight.getText());
				weight = weight*weight;
				
				String res=Double.toString(height/weight);
				res=res.substring(0,4);
				
				JOptionPane.showMessageDialog(frmFitness,"your BMI is : "+res,"BMI Calculated",JOptionPane.WARNING_MESSAGE);
			}
		});
		
		txtEnterWeight = new JTextField();
		txtEnterWeight.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Height(cms) :");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		
		JLabel lblEnterWeight = new JLabel("Enter Weight(kg)  :");
		lblEnterWeight.setFont(new Font("Verdana", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(frmFitness.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEnterWeight, GroupLayout.PREFERRED_SIZE, 86, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEnterHeight, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
								.addComponent(txtEnterWeight, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEnterHeight, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEnterWeight, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(lblEnterWeight))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frmFitness.getContentPane().setLayout(groupLayout);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
