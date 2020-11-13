package com.cognizant.service;

import java.io.IOException;

import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.config.DroolsBeanFactory;
import com.cognizant.model.Cliente;
import com.cognizant.model.VeiculoSugerido;

@RestController
public class ClienteService {

	
	@PostMapping("/veiculo")
	public VeiculoSugerido sugerirVeiculo(@RequestBody Cliente applicant)
			throws IOException {
	
		KieSession kieSession = new DroolsBeanFactory().getKieSession();
		
		VeiculoSugerido veiculoSugerido = new VeiculoSugerido();
		
		kieSession.insert(applicant);
		kieSession.setGlobal("veiculoSugerido", veiculoSugerido);
		kieSession.fireAllRules();
		System.out.println(veiculoSugerido.getNome() + " - " + veiculoSugerido.getVeiculo());
		
		
		
		return veiculoSugerido;

	}
	
	public static void main(String[] args) throws IOException {
		
		ClienteService clienteService = new ClienteService();
		clienteService.sugerirVeiculo(new Cliente("Jo�o", 32, "Masculino", 12000.0));
		clienteService.sugerirVeiculo(new Cliente("Mariana", 35, "Feminino", 11000));
		clienteService.sugerirVeiculo(new Cliente("Carla", 20, "Feminino", 5000.0));
		
	}

}
