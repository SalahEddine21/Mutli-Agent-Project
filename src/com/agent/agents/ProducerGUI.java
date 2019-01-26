package com.agent.agents;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class ProducerGUI extends JFrame {

	private JPanel contentPane;
	
	private Producer producer;
	private JTextField name;
	private JTextField unitPrice;
	private JTextField unitCost;
	public JTextField quantity;
	public JTextField profit;
	public JTextField consumers;
		
	public void setProducer(Producer p) {
		this.producer = p;
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProducerGUI frame = new ProducerGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ProducerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblProductGui = new JLabel("Product GUI");
		lblProductGui.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblProductGui, "10, 4");
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblProductName, "4, 8");
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblQuantity, "12, 8");
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(name, "4, 10, fill, default");
		name.setColumns(10);
		
		quantity = new JTextField();
		quantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		quantity.setEditable(false);
		quantity.setText("0");
		contentPane.add(quantity, "12, 10, 11, 1, fill, default");
		quantity.setColumns(10);
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblUnitPrice, "4, 12");
		
		JLabel lblProfit = new JLabel("Profit");
		lblProfit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblProfit, "12, 12");
		
		unitPrice = new JTextField();
		unitPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(unitPrice, "4, 14, fill, default");
		unitPrice.setColumns(10);
		
		profit = new JTextField();
		profit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profit.setEditable(false);
		profit.setText("0");
		contentPane.add(profit, "12, 14, 11, 1, fill, default");
		profit.setColumns(10);
		
		JLabel lblUnitCost = new JLabel("Unit Cost");
		lblUnitCost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblUnitCost, "4, 16");
		
		JLabel lblConsumersNumber = new JLabel("Consumers");
		lblConsumersNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblConsumersNumber, "12, 16");
		
		unitCost = new JTextField();
		unitCost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(unitCost, "4, 18, fill, default");
		unitCost.setColumns(10);
		
		consumers = new JTextField();
		consumers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		consumers.setText("0");
		contentPane.add(consumers, "12, 18, 11, 1, fill, default");
		consumers.setColumns(10);
		
		JSeparator separator = new JSeparator();
		contentPane.add(separator, "1, 22, 26, 1");
		
		JButton btnAdvertise = new JButton("Advertise");
		btnAdvertise.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(btnAdvertise, "4, 24");
		btnAdvertise.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				producer.advertise(Double.parseDouble(unitPrice.getText()), name.getText());				
			}
		});
		
		JButton btncreate = new JButton("Create Consumer Agent");
		btncreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btncreate, "12, 24, 13, 1");
		btncreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				producer.createConsumer();
				System.out.println("Consumer Created");
			}
		});
	}

	public double getPrice() {
		return Double.parseDouble(this.unitPrice.getText());
	}
	
	public double getCost() {
		return Double.parseDouble(this.unitCost.getText());
	}
}
