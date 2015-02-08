package be.rds.messaging;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import be.rds.messaging.api.IMessagingService;

public class Activator implements BundleActivator {

	private IMessagingService msgService;
	
	public void start(BundleContext bundleContext) throws Exception {
	
		registerMsgService(bundleContext);
		consumeMsgService();
	}

	private void registerMsgService(BundleContext bundleContext) {
		ServiceReference<IMessagingService> ref = 
				bundleContext.getServiceReference(IMessagingService.class);
		msgService = bundleContext.getService(ref);
	}
	
	private void consumeMsgService() {
		new Thread() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000*10);
						System.out.println("RDM TEST Consumer: " +  msgService.getHelloMsg());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.run();			
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}

}
