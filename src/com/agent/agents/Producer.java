package com.agent.agents;

import java.util.ArrayList;
import java.util.List;

import com.agent.env.JadeContainer;
import com.agent.env.MainContainer;

import FIPA.FipaMessage;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Producer extends Agent {

	private ProducerGUI gui;
	private List<AgentController> consumers;
	public static ContainerController container;
	AgentController consumer;
	private int index = 0;
	
	protected void setup() {
		System.out.println("Agent producer created !");
		// lunch the GUI
		gui = new ProducerGUI();
		gui.setProducer(this);
		gui.setVisible(true);
		this.addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage msg = myAgent.receive();
				if(msg != null) {
					double quantity = Double.valueOf(msg.getContent());
					double price = gui.getPrice();
					double cost = gui.getCost();
					double profit = quantity * (price - cost);
					
					double total_q = quantity + Double.parseDouble(gui.quantity.getText());
					double total_p = profit + Double.parseDouble(gui.profit.getText());
					gui.quantity.setText(String.valueOf(total_q));
					gui.profit.setText(String.valueOf(total_p));
				}else {
					System.out.println("AGENT PRODUCER NO QUANTITY YET!");
					block();
				}
			}
		}); // recieve quantity from consumers	
	}
	
	protected void takeDown() {
		System.out.println("Agent producer terminated ");
	}
	
	public void advertise(double price, String productName) {
		this.addBehaviour(new OneShotBehaviour() {
			
			@Override
			public void action() {
				ACLMessage cfp = new ACLMessage(ACLMessage.INFORM);
				for (int j=1 ;j<=index; j++) {
					AID aid = new AID("Consumer_"+j, AID.ISLOCALNAME);
					cfp.addReceiver(aid);
				}
				//System.out.println(price);
				//cfp.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
				cfp.setContent(String.valueOf(price)+"_"+productName);
				myAgent.send(cfp);
			}
		});
//		ACLMessage cfp = new ACLMessage(ACLMessage.INFORM);
//		for (int j=1 ;j<=index; j++) {
//			AID aid = new AID("Consumer"+j, AID.ISLOCALNAME);
//			cfp.addReceiver(aid);
//		}
//		//System.out.println(price);
//		cfp.setContent(String.valueOf(price));
//		this.send(cfp);
	}
	
	public void createConsumer() {
		try {
			int number = Integer.valueOf(gui.consumers.getText());
			for(int i=1; i<=number; i++) {
				consumer = container.createNewAgent("Consumer_"+i, "com.agent.agents.Consumer", null);
				//consumers.add(consumer);
				consumer.start(); // start the agent				
			}
			index = number;
//			index++;
//			consumer = container.createNewAgent("Consumer_"+index, "com.agent.agents.Consumer", null);
//			//consumers.add(consumer);
//			consumer.start(); // start the agent
			//gui.consumers.setText(String.valueOf(index));
		} catch (StaleProxyException e) {
			System.out.println("Create Consumer EXCEPTION: "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			ContainerController mainContainer = new MainContainer().getMainContainer();
			container = new JadeContainer().getContainer();
			AgentController producer = container.createNewAgent("Producer", "com.agent.agents.Producer", null);
			producer.start();
		} catch (Exception e) {
			System.out.println("EXCEPTION IS : "+e.getMessage());
		}
	}
	
	
}
