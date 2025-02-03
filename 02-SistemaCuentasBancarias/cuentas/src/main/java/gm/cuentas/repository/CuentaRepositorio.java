package gm.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gm.cuentas.model.Cuenta;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Integer> {
}
