 
package interfaces;
import Fecha.Periodo;
import excepciones.PersistenciaException;
import java.util.List;
import objetonegocio.ArticuloED;
import objetonegocio.Cliente;
import objetonegocio.Renta;
import objetonegocio.VideoJuego;
public interface IPersistencia {

public VideoJuego obten(VideoJuego videojuego) throws PersistenciaException;
public Cliente obten(Cliente cliente)throws PersistenciaException;
public void agregar(VideoJuego videoJuego) throws PersistenciaException;
public void agregar(Cliente cliente) throws PersistenciaException;
public void actualizar(VideoJuego videoJuego) throws PersistenciaException ;
public void actualizar(Cliente cliente) throws PersistenciaException;
public void eliminar(VideoJuego videojuego) throws PersistenciaException;
public void eliminar(Cliente cliente) throws PersistenciaException;
public void inventariar(VideoJuego videoJuego,int cantidad) throws PersistenciaException;
public void desinventariar(VideoJuego videoJuego,int cantidad) throws PersistenciaException;
public void rentarVideoJuego(Renta renta) throws PersistenciaException ;
public void devolverVideoJuego(Renta renta) throws PersistenciaException;
public List<VideoJuego> consultarVideoJuegos() throws PersistenciaException;
public List<VideoJuego> consutaltarVideoJuegosGenero(String genero) throws PersistenciaException;
public List<VideoJuego> consultarVideoJuegosConsola(String consola) throws PersistenciaException;
public List<Cliente> consultarClientes() throws PersistenciaException;
public List<ArticuloED> consultarInventarioVideoJuegos() throws PersistenciaException;
public List<ArticuloED> consultarVideoJuegosRentados() throws PersistenciaException;
public List<ArticuloED> consultarVideoJuegosDisponibles() throws PersistenciaException;
public List<Renta> consultarRentasVideoJuegos() throws PersistenciaException;
public List<Renta> consultarRentasVideoJuegos(Cliente cliente) throws PersistenciaException;
public List<Renta> consultarRentasVideoJuegos(VideoJuego videoJuego) throws PersistenciaException;
public List<Renta> consultarRentasVideoJuegos(Periodo periodo) throws PersistenciaException;


}
