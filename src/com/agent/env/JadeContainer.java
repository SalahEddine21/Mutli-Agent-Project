package com.agent.env;

import jade.core.ProfileImpl;
import jade.wrapper.ContainerController;

public class JadeContainer {
	
	private ContainerController container;

	public JadeContainer() {
		jade.core.Runtime rt = jade.core.Runtime.instance();
		ProfileImpl profile = new ProfileImpl(false);
		profile.setParameter(ProfileImpl.MAIN_HOST, "localhost") ;
		profile.setParameter(ProfileImpl.CONTAINER_NAME, "Market") ;
		this.container = rt.createAgentContainer(profile);
	}
	
	public ContainerController getContainer() {
		return this.container;
	}
}
