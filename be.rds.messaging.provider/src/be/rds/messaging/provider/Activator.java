package be.rds.messaging.provider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import be.rds.messaging.api.IMessagingService;

public class Activator implements BundleActivator {

	
	public void start(BundleContext bundleContext) throws Exception {
		registerMessagingServiceImpl(bundleContext);

	}

	private void registerMessagingServiceImpl(BundleContext bundleContext) {
		bundleContext.registerService(
				IMessagingService.class.getName(), 
				new MessagingService(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

}
