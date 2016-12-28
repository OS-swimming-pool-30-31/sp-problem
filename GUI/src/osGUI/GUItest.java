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

public class GUItest extends JFrame {

	private JPanel contentPane;

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
		
		JLabel basket1 = new JLabel("");
		basket1.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket1.setBounds(35, 28, 100, 100);
		contentPane.add(basket1);
		
		JLabel basket2 = new JLabel("");
		basket2.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket2.setBounds(145, 28, 100, 100);
		contentPane.add(basket2);
		
		JLabel basket3 = new JLabel("");
		basket3.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket3.setBounds(255, 28, 100, 100);
		contentPane.add(basket3);
		
		JLabel basket4 = new JLabel("");
		basket4.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket4.setBounds(365, 28, 100, 100);
		contentPane.add(basket4);
		
		JLabel basket5 = new JLabel("");
		basket5.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket5.setBounds(475, 28, 100, 100);
		contentPane.add(basket5);
		
		JLabel basket6 = new JLabel("");
		basket6.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket6.setBounds(585, 28, 100, 100);
		contentPane.add(basket6);
		
		JLabel basket7 = new JLabel("");
		basket7.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket7.setBounds(695, 28, 100, 100);
		contentPane.add(basket7);
		
		JLabel basket8 = new JLabel("");
		basket8.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket8.setBounds(805, 28, 100, 100);
		contentPane.add(basket8);
		
		JLabel basket9 = new JLabel("");
		basket9.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket9.setBounds(915, 28, 100, 100);
		contentPane.add(basket9);
		
		JLabel basket10 = new JLabel("");
		basket10.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/basket.png")));
		basket10.setBounds(1025, 28, 100, 100);
		contentPane.add(basket10);
		
		JLabel door1 = new JLabel(""){
			@Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.rotate(Math.toRadians(90),50,50);
                super.paintComponent(g);
            }
		};
		door1.setVerticalAlignment(SwingConstants.BOTTOM);
		door1.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/door.png")));
		door1.setBounds(35, 595, 100, 100);
		//((Graphics2D)door1.getGraphics()).rotate(Math.toRadians(90));
		contentPane.add(door1);
		
		JLabel door2 = new JLabel("");
		door2.setVerticalAlignment(SwingConstants.BOTTOM);
		door2.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/door.png")));
		door2.setBounds(145, 595, 100, 100);
		contentPane.add(door2);
		
		JLabel door3 = new JLabel("");
		door3.setVerticalAlignment(SwingConstants.BOTTOM);
		door3.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/door.png")));
		door3.setBounds(255, 595, 100, 100);
		contentPane.add(door3);
		
		JLabel door4 = new JLabel(""){
			@Override
            public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(Math.toRadians(90),50,50);
            super.paintComponent(g);
        }};
		door4.setVerticalAlignment(SwingConstants.BOTTOM);
		door4.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/door.png")));
		door4.setBounds(365, 595, 100, 100);
		contentPane.add(door4);
		
		JLabel door5 = new JLabel(""){
			/*@Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.rotate(Math.toRadians(90),100,90);
                super.paintComponent(g);
            }*/
		};
		door5.setVerticalAlignment(SwingConstants.BOTTOM);
		door5.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/door.png")));
		door5.setBounds(475, 595, 100, 100);
		contentPane.add(door5);
		
		JLabel pool_door = new JLabel("");
		pool_door.setIcon(new ImageIcon(GUItest.class.getResource("/osGUI/door.png")));
		pool_door.setBounds(1103, 685, 100, 10);
		contentPane.add(pool_door);
	}
	
}

