package br.edu.unoesc.exemplo_JSP;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class IndexController {
@RequestMapping(value = "/login", method = RequestMethod.GET)
public String mostarTelaLogin(ModelMap model ) {
	return "login";
}
@RequestMapping(value = "/login", method = RequestMethod.POST)
public String MostarTelaBemVindo(ModelMap model, @RequestParam String nome,@RequestParam String senha) {
if(!(nome.equals("unoesc") && senha.equals("dev-ti"))) {
	model.put("erro", "Dados inválidos");
	return "login";
}
model.put("nome",nome);
model.put("Senha", senha);
return "bemvindo";
}

	
@RequestMapping("/tl")
String tl (Model model) {
model.addAttribute("Mensagem", "informação armazenada no modelo");

Produto p1 = new Produto ("Mesa",10, new BigDecimal("3.33"));
Produto p2 = new Produto ("Cadeira",20, new BigDecimal("37.33"));

List<Produto> produtos =  new ArrayList<Produto>();
produtos.add(p1);
produtos.add(p2);

model.addAttribute("produtos",p1);
model.addAttribute("produtos",produtos);



return "index";
}
}
