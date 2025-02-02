package me.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.empleados.model.Empleado;

// en esta interfaz se hereda de JpaRepository, se le pasa el tipo de dato que se va a manejar y el tipo de dato de la llave primaria
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {}