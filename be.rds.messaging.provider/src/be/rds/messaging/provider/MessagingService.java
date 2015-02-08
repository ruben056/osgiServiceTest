package be.rds.messaging.provider;

import be.rds.messaging.api.IMessagingService;

public class MessagingService implements IMessagingService {

	@Override
	public String getHelloMsg() {
		return "Working osgi service!!";
	}

}
