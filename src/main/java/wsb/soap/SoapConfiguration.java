package wsb.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        // ścieżka do wygenerowanych klas - podawana też w pom.xml
        marshaller.setContextPath("wsb.soap.client");

        return marshaller;
    }

    @Bean
    public SoapClient countryClient(Jaxb2Marshaller marshaller) {
        SoapClient client = new SoapClient();

        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

}
