package az.atlacademy.soapexample.api;

import az.atlacademy.soapexample.gen.Country;
import az.atlacademy.soapexample.gen.Currency;
import az.atlacademy.soapexample.gen.GetCountryRequest;
import az.atlacademy.soapexample.gen.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.atlacademy.az/soapexample/gen";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public JAXBElement<GetCountryResponse> getCountryRequest(@RequestPayload JAXBElement<GetCountryRequest> request) {
        GetCountryResponse response = new GetCountryResponse();
        Country country = new Country();
        country.setName("Azerbaijan");
        country.setCurrency(Currency.EUR);
        country.setPopulation(10000000);
        country.setCapital("Baku");
        response.setCountry(country);
        return new JAXBElement<>(request.getName(), GetCountryResponse.class, response);
    }

}
