package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.servicios.AccesosSrvcImpls;
import com.example.CapiBoots.servicios.UsuarioSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainCtrl {

    @Autowired
    private AccesosSrvcImpls accessSrvc;
    @Autowired
    private UsuarioSrvcImpls usuSrvc;


    //Validación cuando se ha hecho login
    @GetMapping({"","/","/inicio","/home"})
    String index(Principal principal, Model modelo) {
        if (principal != null){
            //De esta forma, obtenemos el usuario en cuestión que está viendo Moviebox
            String usuID = principal.getName();
            Usuario user =  usuSrvc.buscaPorNombre(usuID);
            Long id = user.getId();
            //Usando la ID del usuario, buscamos sus pendientes
            List<Contenidos> a = accessSrvc.buscaPendientes(id);
            ArrayList<Contenidos> l = new ArrayList<>();
            //Añadimos la lista de pendientes a un arraylist (en orden inverso para
            // que aparezcan los elementos más recientes)
            for (int i = 1; i <= a.size(); i++){
                l.add(a.get(a.size() - i));
            }
            //Dividimos la ArrayList en 3 grupos de 4 como máximo,
            //dejando fuera el resto.
            ArrayList<Contenidos> l1 = new ArrayList<>();
            ArrayList<Contenidos> l2 = new ArrayList<>();
            ArrayList<Contenidos> l3 = new ArrayList<>();
            //1º conjunto
            if (l.size() > 3) {
                for (int i = 1; i <= 4; i++) {
                    l1.add(l.get(i - 1));
                }
            }else{
                //Si el tamaño del array no llega al máximo del conjunto:
                for (int i = 1; i <= l.size(); i++) {
                    l1.add(l.get(i - 1));
                }
            }
            //2º conjunto
            if (l.size() > 7) {
                for (int i = 5; i <= 8; i++) {
                    l2.add(l.get(i - 1));
                }
            }else{
                for (int i = 5; i <= l.size(); i++) {
                    l2.add(l.get(i - 1));
                }
            }
            //3º conjunto
            if (l.size() > 11) {
                for (int i = 9; i < 12; i++) {
                    l3.add(l.get(i - 1));
                }
            }else{
                for (int i = 9; i <= l.size(); i++) {
                    l3.add(l.get(i - 1));
                }
            }
            modelo.addAttribute("pend1",l1);
            modelo.addAttribute("pend2",l2);
            modelo.addAttribute("pend3",l3);
            modelo.addAttribute("titulo", "Home");
        }
        return principal != null ? "home" : "inicio";
    }
}
