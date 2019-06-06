package dao;

import excepciones.DaoException;
import java.util.ArrayList;
import java.util.List;
import objetonegocio.Cliente;

public class Clientes {

    private List<Cliente> clientes;

    public Clientes() {
        clientes = new ArrayList<>();
    }

    public Cliente obten(Cliente cliente) {
        int pos= clientes.indexOf(cliente);
        if (pos>=0) {
            return clientes.get(pos);
        }
        return null;
    }

    public void agrega(Cliente cliente) {
        clientes.add(cliente);
    }

    public void actualiza(Cliente cliente) {
        boolean comp = true;
        for (Cliente cli : clientes) {
            if (cli.getNumCredencial().equals(cliente.getNumCredencial())) {
                cli = cliente;
                comp = false;
            }
        }
        if (comp) {
            try {
                throw new DaoException("No se ha encontrado el cliente");
            } catch (DaoException e) {
            }
        }
    }

    public void elimina(Cliente cliente) {

        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
        } else {
            try {
                throw new DaoException("No se ha encontrado el cliente");
            } catch (DaoException e) {

            }
        }
    }
    
    public List<Cliente> Lista(){
         return clientes;
    }

}
