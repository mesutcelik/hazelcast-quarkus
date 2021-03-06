package guides.hazelcast.quarkus;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class HazelcastClientConfig {

    @Produces
    HazelcastInstance createInstance() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().getKubernetesConfig().setEnabled(true);
        clientConfig.getNetworkConfig().getKubernetesConfig().setProperty("service-name","hz-hazelcast-enterprise");
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}
