package com.agent.agents;

import java.util.Random;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Consumer extends Agent {

	private Random rand;
	
	protected void setup() {
		System.out.println("Hi i'm the agent: "+this.getName()+" waiting for price");
		rand = new Random();
		this.addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage msg = myAgent.receive();
				if(msg != null) {
					String data = msg.getContent();					
					double price = Double.valueOf(data.split("_")[0]);
					int agentId = Integer.valueOf(getLocalName().split("_")[1]);
					double quantity = Math.min(agentId, price); // quantity
					
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.REQUEST);
					reply.setContent(String.valueOf(quantity));
					System.out.println(""+this.getAgent().getName()+ " QUANTITY IS: "+quantity);
					myAgent.send(reply);
				}else {
					System.out.println("AGENT "+this.getAgent().getName()+" NO PRICE YET FOUND !");
					block();
				}
			}
		}); // behaviour waiting for price comming from producer
	}
	
	protected void takeDown() {
		System.out.println("Agent "+this.getName()+" terminated ");
	}
}
