package one.digitalinovation.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinovation.gof.model.ViaCepResponse;

@Service
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{postalCode}/json/")
    ViaCepResponse getAdressByPostalCode(@PathVariable("postalCode") String postalCode);
}
