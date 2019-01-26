package com.agent.env;

import jade.core.ProfileImpl;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.ContainerController;

public class MainContainer {

	private ContainerController mainContainer;
	
	public MainContainer() {
		jade.core.Runtime rt = jade.core.Runtime.instance();
		Properties p = new ExtendedProperties();
		p.setProperty("gui","true");
		ProfileImpl profile = new ProfileImpl(p);
		this.mainContainer = rt.createMainContainer(profile);
	}
	
	public ContainerController getMainContainer() {
		return this.mainContainer;
	}
}
