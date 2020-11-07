import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BookShopManagementSystem {
	
private JFrame frame;
	
	private JTextField customer_name;
	private JTextField phone_number;
	private JTextField book_name;
	private JTextField writer_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookShopManagementSystem window = new BookShopManagementSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookShopManagementSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		File myfile=new File("CustomerDatabase.txt");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(432, 10, 445, 455);
		frame.getContentPane().add(textArea);
		
		
		
		JButton btnshowData = new JButton("Show Database");  
		btnshowData.addActionListener(new ActionListener() {  // this will show the entire file on the text Area
			public void actionPerformed(ActionEvent e) {
				
				try {
					String fileName=myfile.getAbsolutePath();
					FileReader read = new FileReader(fileName);
					BufferedReader brr = new BufferedReader(read);
					textArea.read(brr, null);
					brr.close();
					textArea.requestFocus();
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnshowData.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnshowData.setBounds(586, 475, 179, 38);
		frame.getContentPane().add(btnshowData);
		
		JLabel lblcustomerName = new JLabel("Customer Name");
		lblcustomerName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblcustomerName.setBounds(10, 55, 146, 38);
		frame.getContentPane().add(lblcustomerName);
		
		JLabel lblphoneNumber = new JLabel("Phone Number");
		lblphoneNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblphoneNumber.setBounds(10, 119, 146, 38);
		frame.getContentPane().add(lblphoneNumber);
		
		JLabel lblbookName = new JLabel("Book Name");
		lblbookName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblbookName.setBounds(10, 179, 146, 38);
		frame.getContentPane().add(lblbookName);
		
		JLabel lblwriterName = new JLabel("Writer Name");
		lblwriterName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblwriterName.setBounds(10, 239, 146, 38);
		frame.getContentPane().add(lblwriterName);
		
		customer_name = new JTextField();
		customer_name.setBounds(211, 55, 211, 38);
		frame.getContentPane().add(customer_name);
		customer_name.setColumns(10);
		
		phone_number = new JTextField();
		phone_number.setColumns(10);
		phone_number.setBounds(211, 119, 211, 38);
		frame.getContentPane().add(phone_number);
		
		book_name = new JTextField();
		book_name.setColumns(10);
		book_name.setBounds(211, 179, 211, 38);
		frame.getContentPane().add(book_name);
		
		writer_name = new JTextField();
		writer_name.setColumns(10);
		writer_name.setBounds(211, 239, 211, 38);
		frame.getContentPane().add(writer_name);
		
		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {  // This button create file and store data in the file
			public void actionPerformed(ActionEvent e) {
				
				String info=customer_name.getText()+" , "+phone_number.getText()+" , "+book_name.getText()+" , "+writer_name.getText();
				
				
				try {
					if(myfile.createNewFile()) {
						System.out.println("File created and file name is : "+myfile.getName());
					}
					else {
					
						System.out.println("The file already exist");
					}
				
				}catch(Exception e1) {
					System.out.println("An error occured");
				}
				

				if(myfile.exists()) {
					
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter("CustomerDatabase.txt",true));
						writer.newLine();
						writer.write(info);
						writer.close();
						customer_name.setText("");
						phone_number.setText("");
						book_name.setText("");
						writer_name.setText("");
						System.out.println("Customer data successfully added to file");
						
					}catch(IOException e1) {
						e1.printStackTrace();
					}
				}
				
				
				
			}
		});
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnadd.setBounds(307, 322, 115, 38);
		frame.getContentPane().add(btnadd);
		
		JButton btnReset = new JButton("Reset");  // this will clear the textField and textArea for reuse.
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				customer_name.setText("");
				phone_number.setText("");
				book_name.setText("");
				writer_name.setText("");
				textArea.setText("");
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(146, 322, 115, 38);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				JFrame frmLoginSystem = new JFrame("Exit"); // this button will exit the program properly.
				
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
					}
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setBounds(10, 475, 115, 38);
		frame.getContentPane().add(btnExit);
	}
}



