package wsb.soap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wsb.soap.client.GetBankResponseType;

@RestController
public class SoapClientController {

    final SoapClient soapClient;

    public SoapClientController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @GetMapping("/{blz}")
    GetBankResponseType blz(@PathVariable String blz) {
        return soapClient.getBank(blz);
    }
}
