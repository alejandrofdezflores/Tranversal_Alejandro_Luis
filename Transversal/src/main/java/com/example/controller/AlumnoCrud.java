package com.example.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.example.controller.*;
import com.example.controller.DAO.AlumnoDao;
import com.example.controller.DAO.ClaseDao;
import com.example.model.Alumno;
import com.example.model.Clase;
 
@Controller
@RequestMapping("/Alumno")
public class AlumnoCrud {
 

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
    public String crear(@ModelAttribute @Valid Alumno alumno,
            BindingResult bindingResult, Model mp){
        if(bindingResult.hasErrors()){
            return "/Alumno/nuevo";
        }else{
        	//clases = ClaseDao.getClaseById(clases.getId());
            AlumnoDao.saveAlumno(alumno);
            return "Alumno/creado";
        }
    }
 
    @RequestMapping(path="/creado", method = RequestMethod.POST)
    public String creado(@RequestParam("alumno") Alumno alumno){
        return "Alumno/creado";
    }
    
    @RequestMapping(path="/borrar", method=RequestMethod.GET)
    public String borrar(@RequestParam(name="id")String id, ModelMap mp){
    	int id2 = Integer.valueOf(id);
        AlumnoDao.deleteAlumno(id2);
        mp.put("alumnos", AlumnoDao.getAllAlumnos());
        return "Alumno/lista";
    }
    /**
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