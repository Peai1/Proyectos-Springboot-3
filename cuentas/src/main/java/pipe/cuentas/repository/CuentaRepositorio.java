package pipe.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pipe.cuentas.model.Cuenta;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Integer> {

}
