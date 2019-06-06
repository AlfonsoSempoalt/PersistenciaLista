package dao;

import Fecha.Fecha;
import Fecha.Periodo;
import excepciones.DaoException;
import java.util.ArrayList;
import java.util.List;
import objetonegocio.Articulo;
import objetonegocio.Cliente;
import objetonegocio.Renta;

public class Rentas {

    private List<Renta> rentas;

    public Rentas() {
        rentas = new ArrayList<>();
    }

    public Renta obten(Renta renta) {
        int pos=rentas.indexOf(renta);
        if (pos>=0) {
            return rentas.get(pos);
        }
        return null;
    }

    public void agrega(Renta renta) {
        rentas.add(renta);
    }

    public void actualiza(Renta renta) {
        boolean comp = true;
        for (Renta ren : rentas) {
            if (ren.getCliente().getNumCredencial().equals(renta.getCliente().getNumCredencial()) && ren.getArticulo().getNumCatalogo().equals(renta.getArticulo().getNumCatalogo())) {
                ren = renta;
                comp = false;
            }
        }
        if (comp) {
            try {
                throw new DaoException("No se ha encontrado la renta");
            } catch (DaoException e) {

            }
        }
    }

    public void elimina(Renta renta) {
        if (rentas.contains(renta)) {
            rentas.remove(renta);
        } else {
            try {
                throw new DaoException("No se ha encontrado la renta");
            } catch (DaoException e) {

            }
        }
    }

    public List<Renta> lista() {
        return rentas;
    }

    public List<Renta> listaCliente(Cliente cliente) {
        List<Renta> lista = new ArrayList<>();
        for (Renta ren : rentas) {
            if (ren.getCliente().getNumCredencial().equals(cliente.getNumCredencial())) {
                lista.add(ren);
            }
        }
        return lista;
    }

    public List<Renta> listaArticulo(Articulo articulo) {
        List<Renta> lista = new ArrayList<>();
        for (Renta ren : rentas) {
            if (ren.getArticulo().getNumCatalogo().equals(articulo.getNumCatalogo())) {
                lista.add(ren);
            }
        }
        return lista;
    }

    public List<Renta> lista(Periodo periodo) {
        List<Renta> lista = new ArrayList<>();
        for (Renta ren: rentas) {
            if (periodo.cotiene(ren.getFechaRenta())) {
                lista.add(ren);
            }
        }
        
     return lista;   
    }

}
