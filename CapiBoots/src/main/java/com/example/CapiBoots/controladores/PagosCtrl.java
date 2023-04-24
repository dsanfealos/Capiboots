package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Pagos;
import com.example.CapiBoots.servicios.PagosSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
//@RequestMapping("/pagos")
public class PagosCtrl {
    @Autowired
    private PagosSrvcImpls pagoSrvc;
//    @GetMapping({"", "/"})
//    public String pagos(Model modelo) {
//    modelo.addAttribute("titulo", "Pagos");
//    return "pagos";
//    }
    @GetMapping("/pago-id")
    public String pagoPorId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("pago_id", pagoSrvc.buscaId(id));
        return "listapagos";    //Mostrar pagos por id?
    }

    //Lista de Pagos
    @GetMapping("/lista-pagos")
    public String listaPagos(Model modelo) {
        modelo.addAttribute("listapagos", pagoSrvc.ListaPagos());
        return "/listas/lista-pagos";
    }
    // Crear, Guardar, Borrar y Editar

    @GetMapping("/pagos/nuevo-pago")
    public String nuevo(Model modelo) {
        modelo.addAttribute("pagos", new Pagos());
        return "/forms/nuevo-pagos";
    }
    @PostMapping("pagos/guardar")
    public String guardar(Pagos pag) {
        pagoSrvc.guardar(pag);
        return "redirect:/lista-pagos";
    }
    @GetMapping("/pagos/borrar/{id}")
    public String borrar(@PathVariable Long id){
        pagoSrvc.borrar(id);
        return "redirect:/lista-pagos";
    }
    @GetMapping("/pagos/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo){
        Optional<Pagos> pagOpt = pagoSrvc.buscaId(id);
        if(pagOpt.isPresent()){
            modelo.addAttribute("pagos", pagOpt.get());
        }
        else{
            //Si no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error";
        }
        return "/forms/nuevo-pagos";
    }
}

