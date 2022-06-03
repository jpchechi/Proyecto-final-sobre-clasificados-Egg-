/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados.Controller;

import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Idiomas;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Nacionalidad;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Nivel;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Oficio;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Provincia;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.Remoto;
import arg.cuarteto.Proyecto_clasificados.Enumeraciones.estadoCivil;
import arg.cuarteto.Proyecto_clasificados.ErrorService.ErrorService;
import arg.cuarteto.Proyecto_clasificados.Service.FormUsuarioService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nnahu
 */
@Controller
@RequestMapping("/")
public class FormUsuarioController {
    
    @Autowired
    private FormUsuarioService FormUsuarioService;
    
    @GetMapping("/Formulario-Usuario") 
    public String exito(ModelMap modelo) {
        modelo.addAttribute("Idiomas", Idiomas.values());
        modelo.addAttribute("Nacionalidad", Nacionalidad.values());
        modelo.addAttribute("Nivel", Nivel.values());
        modelo.addAttribute("Oficios", Oficio.values());
        modelo.addAttribute("Provincia", Provincia.values());
        modelo.addAttribute("Remoto", Remoto.values());
        modelo.addAttribute("EstadoCivil", estadoCivil.values());
        return "exito.html"; // falta vista html
    }
    
    @PostMapping("/Cargar-Formulario-Usuario") // metodo registrar para la pagina registro,
            //carga en la base de datos lo solicitado
    public String crearPublicacion(ModelMap modelo,
         MultipartFile archivo, 
         @RequestParam (required = false) String nombre,
         @RequestParam (required = false) String apellido,
         @RequestParam (required = false) String email,
         @RequestParam (required = false) Oficio oficio,
         @RequestParam (required = false) String edad,
         @RequestParam (required = false) String dni,
         @RequestParam (required = false) estadoCivil estadoCivil,
         @RequestParam (required = false) Nacionalidad nacionalidad ,
         @RequestParam (required = false) Provincia provincia,
         @RequestParam (required = false) String ciudad,
         @RequestParam (required = false) String direccion,
         @RequestParam (required = false) String telefono,
         @RequestParam (required = false) String instagram,
         @RequestParam (required = false) String facebook,
         @RequestParam (required = false) String linkedin,
         @RequestParam (required = false) String miWeb,
         @RequestParam (required = false) String educacion,
         @RequestParam (required = false) Date anioInicio,
         @RequestParam (required = false) Date anioFin,
         @RequestParam (required = false) String descripcion,
         @RequestParam (required = false) String instituciones,
         @RequestParam (required = false) Provincia provinciaEducacion,
         @RequestParam (required = false) Idiomas idiomas,
         @RequestParam (required = false) Nivel nivel,
         @RequestParam (required = false) String trabajo,
         @RequestParam (required = false) String puesto,
         @RequestParam (required = false) Date anioInicio2,
         @RequestParam (required = false) Date anioFin2,
         @RequestParam (required = false) String descripcion2,
         @RequestParam (required = false) Remoto remoto){        
        try {   
            
            FormUsuarioService.guardarForm(archivo, nombre, apellido, email, oficio, edad, dni,
                    estadoCivil, nacionalidad, provincia, ciudad, direccion, telefono, instagram,
                    facebook, linkedin, miWeb, educacion, anioInicio, anioFin, descripcion, instituciones, provinciaEducacion,
                    idiomas, nivel, trabajo, puesto, anioInicio2, anioFin2, descripcion2, remoto);
        } catch (ErrorService ex) {  
                modelo.put("Error", ex.getMessage()); 
                modelo.put("Foto:", archivo);
                modelo.put("nombre:", nombre);
                modelo.put("apellido:", apellido);
                modelo.put("email:", email);                
                modelo.put("oficio:", oficio);
                modelo.put("edad:", edad);
                modelo.put("dni:", dni);
                modelo.put("estadoCivil:", estadoCivil);
                modelo.put("nacionalidad:", nacionalidad);
                modelo.put("provincia", provincia);
                modelo.put("ciudad", ciudad);
                modelo.put("direccion", direccion);
                modelo.put("telefono", telefono);
                modelo.put("instagram", instagram);
                modelo.put("facebook", facebook);
                modelo.put("linkedin", linkedin);
                modelo.put("miWeb", miWeb);
                modelo.put("anioInicio", anioInicio);
                modelo.put("anioFin", anioFin);
                modelo.put("descripcion", descripcion);
                modelo.put("instituciones", instituciones);
                modelo.put("provinciaEducacion", provinciaEducacion);
                modelo.put("idiomas", idiomas);
                modelo.put("trabajo", trabajo);
                modelo.put("puesto", puesto);
                modelo.put("anioInicio2", anioInicio2);
                modelo.put("anioFin2", anioFin2);
                modelo.put("descripcion2", descripcion2);
                modelo.put("remoto", remoto);
              
       
                return "formularioClasificados.html"; // falta vista html
        } 
           
            return "index.html";     // retorna ala vista publicacion clasificados 
    }
}
