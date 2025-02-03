package me.empleados.controller;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import me.empleados.service.EmpleadoServicio;
import me.empleados.model.Empleado;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexControlador {
    private static final Logger logger = 
        LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo) {
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado) -> logger.info(empleado.toString()));
        // Compartir modelo a vista
        // id, valor
        modelo.put("empleados", empleados);
        return "index";  // index.jsp
    }

    @RequestMapping(value = "/agregar", method=RequestMethod.GET)
    public String mostrarAgregar() {
        return "agregar"; // agregar.jsp
    }

    @RequestMapping(value = "/agregar", method=RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado) {
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";  // redirige al path "/"
    }

    @RequestMapping(value = "/editar", method=RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo) {
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        modelo.put("empleado", empleado);
        return "editar";  // editar.jsp	
    }

    @RequestMapping(value = "/editar", method=RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado) {
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";  // redirige a controlador "/" para recargar la vista (distinto de return "index";)
    }

    @RequestMapping(value = "/eliminar", method=RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado) {
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        empleadoServicio.eliminarEmpleado(empleado);
        return "redirect:/";  // redirige a controlador "/" para recargar la vista (distinto de return "index";)
    }

    
    
}
