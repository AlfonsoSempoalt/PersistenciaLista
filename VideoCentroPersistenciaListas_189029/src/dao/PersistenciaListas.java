/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Fecha.Periodo;
import excepciones.PersistenciaException;
import interfaces.IPersistencia;
import java.util.ArrayList;
import java.util.List;
import objetonegocio.ArticuloED;
import objetonegocio.Cliente;
import objetonegocio.Renta;
import objetonegocio.VideoJuego;

/**
 *
 * @author Alfonso Sempoalt
 */
public class PersistenciaListas implements IPersistencia {

    private VideoJuegos catalogoVideoJuegos;
    private Clientes catalogoClientes;
    private ArticulosED inventarioVideoJuegos;
    private Rentas rentasVideoJuegos;

    public PersistenciaListas() {
        catalogoVideoJuegos = new VideoJuegos();
        catalogoClientes = new Clientes();
        inventarioVideoJuegos = new ArticulosED();
        rentasVideoJuegos = new Rentas();
    }

    @Override
    public VideoJuego obten(VideoJuego vj) throws PersistenciaException {
        return catalogoVideoJuegos.obten(vj);
    }

    @Override
    public Cliente obten(Cliente clnt) throws PersistenciaException {
        return catalogoClientes.obten(clnt);
    }

    @Override
    public void agregar(VideoJuego vj) throws PersistenciaException {
        List<VideoJuego> lista = new ArrayList<>();
        lista = catalogoVideoJuegos.lista();
        if (!lista.contains(vj)) {
            catalogoVideoJuegos.agregar(vj);
        } else {
            try {
                throw new PersistenciaException("Ese objeto ya existe");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void agregar(Cliente clnt) throws PersistenciaException {
        List<Cliente> lista = new ArrayList<>();
        lista = catalogoClientes.Lista();
        if (!lista.contains(clnt)) {
            catalogoClientes.agrega(clnt);
        } else {
            try {
                throw new PersistenciaException("Ese cliente ya existe");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void actualizar(VideoJuego vj) throws PersistenciaException {
        List<VideoJuego> lista = new ArrayList<>();
        boolean tr = true;
        if (obten(vj) != null) {
            lista = catalogoVideoJuegos.lista();
            for (VideoJuego v : lista) {
                if (v.getNumCatalogo().equals(vj.getNumCatalogo())) {
                    catalogoVideoJuegos.actualizar(vj);
                }
            }
        }
        if (obten(vj) == null) {
            try {
                throw new PersistenciaException("No existe ese objeto y no se puede actualizar");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void actualizar(Cliente clnt) throws PersistenciaException {
        List<Cliente> lista = new ArrayList<>();
        if (lista.contains(clnt)) {
            catalogoClientes.actualiza(clnt);
        } else {
            try {

            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    @Override
    public void eliminar(VideoJuego vj) throws PersistenciaException {
        List<VideoJuego> lista = new ArrayList<>();
        lista = catalogoVideoJuegos.lista();
        if (lista.contains(vj)) {
            catalogoVideoJuegos.eliminar(vj);
        } else {
            try {
                throw new PersistenciaException("El objeto a eliminar no existe");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void eliminar(Cliente clnt) throws PersistenciaException {
        List<Cliente> lista = new ArrayList<>();
        lista = catalogoClientes.Lista();
        if (lista.contains(clnt)) {
            catalogoClientes.elimina(clnt);
        } else {
            try {
                throw new PersistenciaException("El cliente a eliminar no existe");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void rentarVideoJuego(Renta renta) throws PersistenciaException {
        Renta ren = rentasVideoJuegos.obten(renta);
        VideoJuego v= obten(new VideoJuego(renta.getArticulo().getNumCatalogo()));
        ArticuloED art = inventarioVideoJuegos.obten(new ArticuloED(renta.getArticulo()));
        if (v == null) {
            try {
                throw new PersistenciaException("No existe ese juego");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        } 
        if (ren!=null) {
              try {
                throw new PersistenciaException("Ese juego ya ha sido rentado por el cliente");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        }
        if (ren == null) {
         rentasVideoJuegos.agrega(renta);
         ArticuloED s = inventarioVideoJuegos.obten(new ArticuloED(renta.getArticulo()));
            if (s!=null) {
                s.setDisponibilidad(s.getDisponibilidad()-1);
            }
          inventarioVideoJuegos.actualiza(s);
        }
        
    }

    @Override
    public void devolverVideoJuego(Renta renta) throws PersistenciaException {
        List<ArticuloED> listaArED = inventarioVideoJuegos.lista();
        boolean bo = true;
        for (ArticuloED lis : listaArED) {
            bo = lis.getArticulo().equals(renta.getArticulo());
        }
        if (bo == false) {
            try {
                throw new PersistenciaException("no existe en inventario");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        }
        if (bo == true) {
            for (ArticuloED lis : listaArED) {
                lis.setDisponibilidad(lis.getDisponibilidad() + 1);
            }
            rentasVideoJuegos.elimina(renta);
        }
    }

    @Override
    public List<VideoJuego> consultarVideoJuegos() throws PersistenciaException {
        return catalogoVideoJuegos.lista();
    }

    @Override
    public List<VideoJuego> consutaltarVideoJuegosGenero(String string) throws PersistenciaException {
        return catalogoVideoJuegos.listaGenero(string);
    }

    @Override
    public List<VideoJuego> consultarVideoJuegosConsola(String string) throws PersistenciaException {
        return catalogoVideoJuegos.listaConsola(string);
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenciaException {
        return catalogoClientes.Lista();
    }

    @Override
    public List<ArticuloED> consultarInventarioVideoJuegos() throws PersistenciaException {
        return inventarioVideoJuegos.lista();
    }

    @Override
    public List<ArticuloED> consultarVideoJuegosRentados() throws PersistenciaException {
        return inventarioVideoJuegos.listaRentadas();
    }

    @Override
    public List<ArticuloED> consultarVideoJuegosDisponibles() throws PersistenciaException {
        return inventarioVideoJuegos.listaDisponibles();
    }

    @Override
    public List<Renta> consultarRentasVideoJuegos() throws PersistenciaException {
        return rentasVideoJuegos.lista();
    }

    @Override
    public List<Renta> consultarRentasVideoJuegos(Cliente clnt) throws PersistenciaException {
        return rentasVideoJuegos.listaCliente(clnt);
    }

    @Override
    public List<Renta> consultarRentasVideoJuegos(VideoJuego vj) throws PersistenciaException {
        return rentasVideoJuegos.listaArticulo(vj);
    }

    @Override
    public List<Renta> consultarRentasVideoJuegos(Periodo prd) throws PersistenciaException {
        return rentasVideoJuegos.lista(prd);
    }

    @Override
    public void inventariar(VideoJuego vj, int i) throws PersistenciaException {
        List<ArticuloED> lista = new ArrayList<>();
        lista = inventarioVideoJuegos.lista();
        if (inventarioVideoJuegos.obten(new ArticuloED(vj, i, i)) != null) {
            int pos = lista.indexOf(new ArticuloED(vj, i, i));
            if (pos >= 0) {
                ArticuloED ar = lista.get(pos);
                ar.setDisponibilidad(ar.getDisponibilidad() + i);
                ar.setExistencia(ar.getExistencia() + i);
                ar.setArticulo(vj);
                inventarioVideoJuegos.actualiza(ar);
            }
        } else if (inventarioVideoJuegos.obten(new ArticuloED(vj)) == null) {
            inventarioVideoJuegos.agregar(new ArticuloED(vj, i, i));
        }
    }

    @Override
    public void desinventariar(VideoJuego vj, int i) throws PersistenciaException {
        List<ArticuloED> lista = new ArrayList<>();
        lista = inventarioVideoJuegos.lista();
        boolean b = true;
        for (ArticuloED ar : lista) {
            if (ar.getArticulo().equals(vj)) {
                ar.setDisponibilidad(ar.getDisponibilidad() - i);
                ar.setExistencia(ar.getExistencia() - i);
                b = false;
                if (ar.getExistencia() <= 0) {
                    inventarioVideoJuegos.elimina(ar);
                }
            }
        }
        if (b) {
            try {
                throw new PersistenciaException("No existe ese objeto");
            } catch (PersistenciaException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
