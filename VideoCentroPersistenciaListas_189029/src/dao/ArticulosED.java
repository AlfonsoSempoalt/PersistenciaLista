package dao;

import excepciones.DaoException;
import java.util.ArrayList;
import java.util.List;
import objetonegocio.ArticuloED;

public class ArticulosED {
    
    private List<ArticuloED> articulosED;
    
    public ArticulosED() {
        articulosED = new ArrayList<>();
    }
    
    public ArticuloED obten(ArticuloED articuloED) {    
       int pos= articulosED.indexOf(articuloED);
        if (pos>=0) {
            return articulosED.get(pos);
        }
//        for (ArticuloED art:articulosED) {
//            if (art==articuloED) {
//                return art;
//            }
//        }
        return null;
    }
    
    public void agregar(ArticuloED artED) {
        articulosED.add(artED);
    }
    
    public void actualiza(ArticuloED articuloED) {
        boolean comp = true;
        for (ArticuloED art : articulosED) {
            if (art.getArticulo().getNumCatalogo().equals(art.getArticulo().getNumCatalogo())) {
                art = articuloED;
                comp = false;
            }
        }
        if (comp) {
            try {
                throw new DaoException("No se ha encontrado el articulo");
            } catch (DaoException e) {
               e.printStackTrace();
            }
        }
    }
    
    public void elimina(ArticuloED art) {
        if (articulosED.contains(art)) {
            articulosED.remove(art);
        } else {
            try {
                throw new DaoException("No se ha encontrado el videojuego");
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<ArticuloED> lista() {
         return articulosED;
    }
    
    public List<ArticuloED> listaRentadas() {
        List<ArticuloED> lis = new ArrayList<>();
        for (ArticuloED art : articulosED) {
            if (art.getDisponibilidad() == 0) {
                lis.add(art);
            }
        }
        return lis;
    }

    public List<ArticuloED> listaDisponibles() {
        List<ArticuloED> lis = new ArrayList<>();
        for (ArticuloED art : articulosED) {
            if (art.getDisponibilidad() >= 1) {
                lis.add(art);
            }
        }
        return lis;
    }
    
}
