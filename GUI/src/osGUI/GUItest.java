package osGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.Font;

public class GUItest extends JFrame {

	private JPanel contentPane;
	public static ImageIcon basket = new ImageIcon(GUItest.class.getResource("/osGUI/basket.png"));
	public static ImageIcon cubicle = new ImageIcon(GUItest.class.getResource("/osGUI/cubicle.png"));
	public static ImageIcon full_basket = new ImageIcon(GUItest.class.getResource("/osGUI/full_basket.png"));
	public static ImageIcon full_cubicle = new ImageIcon(GUItest.class.getResource("/osGUI/full_cubicle.png"));
	public static JLabel baskets[] = new JLabel[10];
	public static JLabel cubicles[] = new JLabel[5];
	public static JTextArea ta = new JTextArea();
	public static JScrollPane scrollPane = new JScrollPane(ta);
	public static int waiting_num;
	Demo d = new Demo();
	public static JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUItest frame = new GUItest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUItest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		waiting_num = 0;
		
		baskets[0] = new JLabel("");
		baskets[0].setIcon(basket);
		baskets[0].setBounds(35, 28, 100, 100);
		contentPane.add(baskets[0]);
		
		baskets[1] = new JLabel("");
		baskets[1].setIcon(basket);
		baskets[1].setBounds(145, 28, 100, 100);
		contentPane.add(baskets[1]);
		
		baskets[2] = new JLabel("");
		baskets[2].setIcon(basket);
		baskets[2].setBounds(255, 28, 100, 100);
		contentPane.add(baskets[2]);
		
		baskets[3] = new JLabel("");
		baskets[3].setIcon(basket);
		baskets[3].setBounds(365, 28, 100, 100);
		contentPane.add(baskets[3]);
		
		baskets[4] = new JLabel("");
		baskets[4].setIcon(basket);
		baskets[4].setBounds(475, 28, 100, 100);
		contentPane.add(baskets[4]);
		
		baskets[5] = new JLabel("");
		baskets[5].setIcon(basket);
		baskets[5].setBounds(585, 28, 100, 100);
		contentPane.add(baskets[5]);
		
		baskets[6] = new JLabel("");
		baskets[6].setIcon(basket);
		baskets[6].setBounds(695, 28, 100, 100);
		contentPane.add(baskets[6]);
		
		baskets[7] = new JLabel("");
		baskets[7].setIcon(basket);
		baskets[7].setBounds(805, 28, 100, 100);
		contentPane.add(baskets[7]);
		
		baskets[8] = new JLabel("");
		baskets[8].setIcon(basket);
		baskets[8].setBounds(915, 28, 100, 100);
		contentPane.add(baskets[8]);
		
		baskets[9] = new JLabel("");
		baskets[9].setIcon(basket);
		baskets[9].setBounds(1025, 28, 100, 100);
		contentPane.add(baskets[9]);
		
		cubicles[0] = new JLabel("");
		cubicles[0].setIcon(cubicle);
		cubicles[0].setBounds(35, 145, 100, 100);
		contentPane.add(cubicles[0]);
		
		cubicles[1] = new JLabel("");
		cubicles[1].setIcon(cubicle);
		cubicles[1].setBounds(145, 145, 100, 100);
		contentPane.add(cubicles[1]);
		
		cubicles[2] = new JLabel("");
		cubicles[2].setIcon(cubicle);
		cubicles[2].setBounds(255, 145, 100, 100);
		contentPane.add(cubicles[2]);
		
		cubicles[3] = new JLabel("");
		cubicles[3].setIcon(cubicle);
		cubicles[3].setBounds(365, 145, 100, 100);
		contentPane.add(cubicles[3]);
		
		cubicles[4] = new JLabel("");
		cubicles[4].setIcon(cubicle);
		cubicles[4].setBounds(475, 145, 100, 100);
		contentPane.add(cubicles[4]);
	
		
		JButton btn = new JButton("add 1");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){//避免畫面假死
					public void run(){
						d.add();
					}
				}.start();
			}
		});
		btn.setBounds(1265, 28, 87, 23);
		contentPane.add(btn);

		
		ta.setLineWrap(true);
		
		scrollPane.setBounds(1159, 62, 193, 633);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setFont(new Font("新細明體", Font.PLAIN, 26));
		textField.setBounds(924, 625, 225, 70);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("Waiting : " + waiting_num);
		
		
		
	}
	public static void basket_change(int i,boolean b){
		if(b){
			baskets[i].setIcon(full_basket);
		}
		else{
			baskets[i].setIcon(basket);
		}
	}
	public static void cubicle_change(int i,boolean b){
		if(b){
			cubicles[i].setIcon(full_cubicle);
		}
		else{
			cubicles[i].setIcon(cubicle);
		}
	}
}

