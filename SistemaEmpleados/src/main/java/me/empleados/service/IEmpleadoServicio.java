package me.empleados.service;

import java.util.List;

import me.empleados.model.Empleado;

public interface IEmpleadoServicio {
    
    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorId(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
