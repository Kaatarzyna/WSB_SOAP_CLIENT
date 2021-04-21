package wsb.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import wsb.soap.client.GetBankResponseType;
import wsb.soap.client.GetBankType;
import wsb.soap.client.ObjectFactory;

import javax.xml.bind.JAXBElement;

public class SoapClient extends WebServiceGatewaySupport {

    // działający kod banku: 54691200

    public static final String SERVICE_URL = "http://www.thomas-bayer.com/axis2/services/BLZService";

    @SuppressWarnings("unchecked")
    public GetBankResponseType getBank(String blz) {

        GetBankType getBankRequest = new GetBankType();
        getBankRequest.setBlz(blz);

        ObjectFactory factory = new ObjectFactory();
        JAXBElement<GetBankType> request = factory.createGetBank(getBankRequest);

        JAXBElement<GetBankResponseType> response = (JAXBElement<GetBankResponseType>) getWebServiceTemplate()
                .marshalSendAndReceive(SERVICE_URL, request);

        return response.getValue();
    }
}
