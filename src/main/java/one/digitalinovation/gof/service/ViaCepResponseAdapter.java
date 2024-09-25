package one.digitalinovation.gof.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.gof.model.Address;
import one.digitalinovation.gof.model.ViaCepResponse;

@Service
public class ViaCepResponseAdapter {

    @Autowired
    private ViaCepService viaCepService;

    public Address getAdaptedAddress(String postalCode) {
        ViaCepResponse viaCepResponse = viaCepService.getAdressByPostalCode(postalCode);
        Address address = new Address(
                viaCepResponse.getCep(),
                viaCepResponse.getLogradouro(),
                viaCepResponse.getComplemento(),
                viaCepResponse.getBairro(),
                viaCepResponse.getLocalidade(),
                viaCepResponse.getUf());
        return address;
    };
}
