package com.example.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.example.controller.*;
import com.example.controller.DAO.AlumnoDao;
import com.example.controller.DAO.ClaseDao;
import com.example.model.Alumno;
 
@Controller
@RequestMapping("/Alumno")
public class ControladorCrud {
 

//    private UsuarioCrud uc;
 
    @RequestMapping(path="", method = RequestMethod.GET)
    public String listaUsuarios(ModelMap mp){
        mp.put("alumnos", AlumnoDao.getAllAlumnos());
        return "Alumno/lista";
    }
 
    @RequestMapping(path="/nuevo", method=RequestMethod.GET)
    public String nuevo(ModelMap mp){
        mp.put("alumno", new Alumno());
        mp.put("clases", ClaseDao.getAllClasesOrderByNombre());
        return "Alumno/nuevo";
    }
 
    @RequestMapping(path="/crear", method=RequestMethod.POST)
    public String crear(@Valid Alumno alumno,
            BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            return "Alumno/nuevo";
        }else{
            AlumnoDao.saveAlumno(alumno);
            mp.put("alumno", alumno);
            return "Alumno/creado";
        }
    }
 
    @RequestMapping(path="/creado", method = RequestMethod.POST)
    public String creado(@RequestParam("alumno") Alumno alumno){
        return "Alumno/creado";
    }/*
    
    @RequestMapping(path="/borrar/{id}", method=RequestMethod.GET)
    public String borrar(@PathVariable("id") long id, ModelMap mp){
    	Optional<Alumno> optionalUser = uc.findById(id);
    	Alumno user = optionalUser.get();
        uc.delete(user);
        mp.put("usuarios", uc.findAll());
        return "crud/lista";
    }
    
    @RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable("id") long id, ModelMap mp){
        mp.put("usuario", uc.findById(id));
        return "crud/editar";
    }
     
    @RequestMapping(path="/actualizar", method=RequestMethod.POST)
    public String actualizar(@Valid Alumno usuario, BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            mp.put("usuarios", uc.findAll());
        return "crud/lista";
        }
        Optional<Alumno> optionalUser = uc.findById(usuario.getId());
        Alumno user = optionalUser.get();
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setId(usuario.getId());
        uc.save(user);
        mp.put("usuario", user);
        return "crud/actualizado";
    }*/
 
}