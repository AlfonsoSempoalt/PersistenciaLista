package dao;

import excepciones.DaoException;
import java.util.ArrayList;
import java.util.List;
import objetonegocio.VideoJuego;

/**
 *
 * @author Alfonso Sempoalt
 */
public class VideoJuegos {

    private List<VideoJuego> videojuegos;

    public VideoJuegos() {
        videojuegos = new ArrayList<>();
    }

    public VideoJuego obten(VideoJuego vj) {
        int pos = videojuegos.indexOf(vj);
        if (pos >= 0) {
            return videojuegos.get(pos);
        }
        return null;
    }

    public void agregar(VideoJuego vj) {
       videojuegos.add(vj);
    }

    public void actualizar(VideoJuego vj) throws DaoException{
        boolean comp = true;
        for (VideoJuego juego : videojuegos) {
            if (vj.getNumCatalogo().equals(juego.getNumCatalogo())) {
                juego = vj;
                comp = false;
                break;
            }
        }
        if (comp) {
            try {
                throw new DaoException("No se ha encontrado el videojuego");
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
 
    }

    public void eliminar(VideoJuego vj) throws DaoException {
        if (videojuegos.contains(vj)) {
            videojuegos.remove(vj);
        } else {
            try {
                throw new DaoException("No se ha encontrado el videojuego");
            } catch (DaoException e) {

            }
        }
    }

    public List<VideoJuego> lista() {
        return videojuegos;
    }

    public List<VideoJuego> listaGenero(String genero) {
        List<VideoJuego> list = new ArrayList<>();
        for (VideoJuego v : videojuegos) {
            if (v.getGenero().equalsIgnoreCase(genero)) {
                list.add(v);
            }
        }
        return list;
    }

    public List<VideoJuego> listaConsola(String consola) {
        List<VideoJuego> list = new ArrayList<>();
        for (VideoJuego v : videojuegos) {
            if (v.getConsola().equalsIgnoreCase(consola)) {
                list.add(v);
            }
        }
        return list;
    }

}
