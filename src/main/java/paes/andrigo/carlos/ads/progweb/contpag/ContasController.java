package paes.andrigo.carlos.ads.progweb.contpag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContasController {

    @Autowired
    ContasRepository contasRepository;

    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro(){
        ModelAndView modelAndView = new ModelAndView("cadastro");

        return modelAndView;
    }
    
    @PostMapping(value="/adicionar")
    public ModelAndView postAdicionar(@RequestParam String descricao, @RequestParam String valor, @RequestParam String mes_vcto, @RequestParam String ano_vcto){
        Contas contas = new Contas();
        contas.setDescricao(descricao);
        contas.setValor(valor);
        contas.setMes_vcto(mes_vcto);
        contas.setAno_vcto(ano_vcto);
        contasRepository.save(contas);
        
        ModelAndView modelAndView = new ModelAndView("detalhes");
        modelAndView.addObject("contas", contas);
        
        return modelAndView;
    }



}
