package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.PagosSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pagos")
public class PagosCtrl {

    @Autowired
    private PagosSrvcImpls pagoSrvc;

    @GetMapping({"","/"})
    public String pagos(Model modelo) {
        modelo.addAttribute("titulo", "Pagos");
        return "pagos";
    }

    @GetMapping("/lista-pagos")
    public String listaPagos (Model modelo){
        modelo.addAttribute("listapagos",pagoSrvc.listaPagos());
        return "lista-pagos";
    }

    @GetMapping("/pago-id")
    public String pagoPorId (@PathVariable Long id, Model modelo){
        modelo.addAttribute("pago_id",pagoSrvc.buscaId(id));
        return "listapagos";    //Mostrar pagos por id?
    }

}
