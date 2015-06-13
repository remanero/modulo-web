package br.com.unifor.pim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.pim.model.entity.ListaRestricao;
import br.com.unifor.pim.model.entity.Restricao;
import br.com.unifor.pim.model.service.RestricaoService;

@RestController
@RequestMapping("/service/restricao")
public class RestricaoControllerRest {
	
	@Autowired
	RestricaoService restricaoService;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	@ResponseBody
	public ListaRestricao listarRestricao(){
		List<Restricao> restricoes = restricaoService.listarTodos();
		ListaRestricao listaRestricao = new ListaRestricao(restricoes);		
		return listaRestricao;
	}
	
}
