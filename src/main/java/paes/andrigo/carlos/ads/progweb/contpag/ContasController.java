package paes.andrigo.carlos.ads.progweb.contpag;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContasController {

    
    @Autowired
    ContasRepository contasRepository;

    @GetMapping(value="/")
    public ModelAndView getIndex(){
        List<Contas> lista = new ArrayList<>();
        lista = contasRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }



    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id){
        Contas contas = new Contas();
        contas = contasRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detalhes");
        modelAndView.addObject("contas", contas);
        return modelAndView;
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id){
        Contas contas = new Contas();

        contas = contasRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("contas", contas);
        return modelAndView;
    }
    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro(){
        Contas contas = new Contas();
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("contas", contas);
        return modelAndView;
    }
    
    @PostMapping(value="/adicionar")
    public ModelAndView postAdicionar(Contas contas){
        contasRepository.save(contas);
        
        ModelAndView modelAndView = new ModelAndView("detalhes");
        modelAndView.addObject("contas", contas);
        
        return modelAndView;
    }

    @GetMapping(value="/apagar/{id}")
    public String getApagar(@PathVariable Long id){
        contasRepository.deleteById(id);
        return "redirect:/";
    }

    
}

