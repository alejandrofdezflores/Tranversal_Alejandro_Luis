package com.example.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Alumno;

 
@Controller
@RequestMapping("/crud")
public class ControladorCrud {
 
    @Autowired
    private AlumnoDao alumno;
 
    // Mostrar todos los alumnos
    @RequestMapping(value="", method = RequestMethod.GET)
    public String listaUsuarios(ModelMap mp){
        mp.put("usuarios", alumno.getAllAlumnos());
        return "crud/lista";
    }
 
    
    @RequestMapping(value="/nuevo", method=RequestMethod.GET)
    public String nuevo(ModelMap mp){
        mp.put("alumno", new Alumno());
        return "crud/nuevo";
    }
 
    @RequestMapping(value="/crear", method=RequestMethod.POST)
    public String crear(@Valid Alumno a,
            BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            return "/crud/nuevo";
        }else{
            alumno.saveAlumno(a);
            mp.put("alumno", a);
            return "crud/creado";
        }
    }
 
    @RequestMapping(value="/creado", method = RequestMethod.POST)
    public String creado(@RequestParam("alumno") Alumno a){
        return "/crud/creado";
    }
    
  /*  @RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
    public String borrar(@PathVariable("id") long id, ModelMap mp){
    	Optional<Alumno> optionalUser = alumno.findById(id);
    	Usuario user = optionalUser.get();
        uc.delete(user);
        mp.put("usuarios", uc.findAll());
        return "crud/lista";
    }
    */
    /*
    @RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable("id") long id, ModelMap mp){
        mp.put("usuario", uc.findById(id));
        return "crud/editar";
    }
     */
    
    /*
    @RequestMapping(value="/actualizar", method=RequestMethod.POST)
    public String actualizar(@Valid Alumno usuario, BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            mp.put("alumno", alumno.getAllAlumnos());
        return "crud/lista";
        }
        Optional<Alumno> optionalUser = alumno.getAllAlumnos(usuario.getId());
        Alumno a = optionalUser.get();
        user.setNombre(usuario.getNombre());
        user.setPassword(usuario.getPassword());
        user.setEmail(usuario.getEmail());
        uc.save(user);
        mp.put("usuario", user);
        return "crud/actualizado";
    }
    */
 
}