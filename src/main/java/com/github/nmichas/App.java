package com.github.nmichas;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class App {
	private static Conf conf;

	public App() throws IOException, NoSuchFieldException, IllegalAccessException {
		conf = Util.readConf("img2mqtt.conf");
	}

	private static class AppRouteBuilder extends RouteBuilder {
		private String auth = StringUtils.isNoneEmpty(conf.getMqttUsername()) ?
				"&userName=" + conf.getMqttUsername() +
						"&password=" + conf.getMqttPassword() : "";

		@Override
		public void configure() throws Exception {
			if (conf.isDebug()) {
				System.out.println("Poller frequency:\t" + conf.getPollerFreq());
				System.out.println("MQTT host:\t\t\t" + conf.getMqttHost());
				System.out.println("MQTT topic:\t\t\t" + conf.getMqttTopic());
				System.out.println("MQTT auth:\t\t\t" + auth);
			}
			from("timer:pollingTimer?period=" + conf.getPollerFreq())
					.bean("poller")
					.marshal().json(JsonLibrary.Jackson)
					.to("mqtt:polling?" +
							"clientId=Img2MQTT"
							+ "&publishTopicName=" + conf.getMqttTopic()
							+ "&host=" + conf.getMqttHost()
							+ auth);
		}
	}

	public static class Events extends MainListenerSupport {
		@Override
		public void afterStart(MainSupport main) {
			System.out.println("Starting poller.");
		}

		@Override
		public void beforeStop(MainSupport main) {
			System.out.println("Stopping poller.");
		}
	}

	public void boot() throws Exception {
		/* Create Camel context */
		Main main = new Main();

		/* Register beans */
		main.bind("poller", new Poller(conf));

		/* Create routes */
		main.addRouteBuilder(new AppRouteBuilder());

		/* Startup and Shutdown hooks */
		main.addMainListener(new Events());

		/* Start Camel context */
		main.run();
	}

	public static void main(String[] args) throws Exception {
		App app = new App();
		app.boot();
	}
}
