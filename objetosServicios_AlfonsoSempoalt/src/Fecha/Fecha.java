package Fecha;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Fecha extends GregorianCalendar {

    /**
     * Constructor que asigna valores de la maquina en día, mes y año pero en
     * segundos,horas y minutos los asigna a 0 igual que los milisegundos
     */
    public Fecha() {
        super.set(HOUR, 0);
        super.set(SECOND, 0);
     }
     

    /**
     * Asigna los parametros como fecha
     *
     * @param año primer parametro
     * @param mes segundo parametro
     * @param dia tercer parametro
     */
    public Fecha(int año, int mes, int dia) {
        super.set(año, mes, dia, 0, 0, 0);

    }

    /**
     * Constructor que clona una fecha
     *
     * @param fecha parametro
     * 
     */
    public Fecha (Fecha fecha) {   
        int año, mes, dia;
        año = fecha.get(Calendar.YEAR);
        mes= fecha.get(Calendar.MONTH);
        dia= fecha.get(Calendar.DAY_OF_MONTH);
        super.set(año, mes, dia);
    }

    /**
     * Convierte String en un Date o fecha
     *
     * @param s
     */
    public Fecha(String s) {
        try {
            Date date = new Date();
            SimpleDateFormat forma = new SimpleDateFormat("dd-MM-yyyy");

            date = forma.parse(s);
        } catch (ParseException e) {

        }
    }

    /**
     * Nos Regresa la fecha actual en String
     *
     * @return
     */
    @Override
    public String toString() {
        String dia, mes, año, fechaCompleta;
        dia = String.valueOf(super.get(DAY_OF_MONTH));
        mes = String.valueOf(super.get(MONTH));
        año = String.valueOf(super.get(YEAR));
        fechaCompleta = dia + "/" + mes + "/" + año;
        return fechaCompleta;
    }

    /**
     * Nos Retorna el día del mes
     *
     * @return
     */
    public int getDia() {
        return super.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Nos retorna el MES
     *
     * @return
     */
    public int getMes() {
        return super.get(Calendar.MONTH);
    }

    /**
     * Nos retorna el año
     *
     * @return
     */
    public int getAño() {
        return super.get(Calendar.YEAR);
    }

    /**
     * asigna el día del mes
     *
     * @param dia
     */
    public void setDia(int dia) {
        super.set(Calendar.DAY_OF_MONTH, dia);

    }

    /**
     * Asigna el año
     *
     * @param año
     */
    public void setAño(int año) {
        super.set(Calendar.YEAR, año);

    }

    /**
     * asigna el mes
     *
     * @param mes
     */
    public void setMes(int mes) {
        super.set(Calendar.MONTH, mes);
    }

    /**
     * Recibe parametros en los cuales son sumados para sacar una fecha de
     * vencimiento sobre la fecha actual
     *
     * @param dia
     * @param mes
     * @param año
     * @return
     */
    public Date vencimiento(int dia, int mes, int año) {
        int dias, mees, aaño;
        dias = super.get(Calendar.DAY_OF_MONTH) + dia;
        mees = super.get(Calendar.MONTH) + mes;
        aaño = super.get(Calendar.YEAR) + año;
        Fecha f = new Fecha();
        f.set(aaño, mees, dias);
        return f.getTime();
    }

    /**
     * Recibe los parametros y los suma a la fecha actual con lo cual saca la
     * fecha de vencimiento
     *
     * @param dia
     * @param mes
     * @return
     */
    public Date vencimiento(int dia, int mes) {
        int dias, mees;
        dias = super.get(Calendar.DAY_OF_MONTH) + dia;
        mees = super.get(Calendar.MONTH) + mes;
        Fecha f = new Fecha();
        f.set(mees, dias);
        return f.getTime();
    }

    /**
     * Recibe los dias que falta para vencer y son sumados a la fecha actual
     *
     * @param dia
     * @return
     */
    public Date vencimiento(int dia) {
        int dias, mees;
        dias = super.get(Calendar.DAY_OF_MONTH) + dia;
        Fecha f = new Fecha();
        f.set(Calendar.DAY_OF_MONTH, dias);
        return f.getTime();
    }

    /**
     * Asigna una fecha
     *
     * @param dia
     * @param mes
     * @param año
     */
    public void setFecha(int dia, int mes, int año) {
        super.set(año, mes, dia);
    }

    /**
     * saca el lapso de dias transcurrido de los transcurridos de un día a la
     * fecha actual
     *
     * @param desde
     * @return
     */
    public long lapso(Fecha desde) {
        Date date1 = new Date();
        Date date2 = new Date();
        date1 = super.getTime();
        date2 = desde.getTime();
        long dias = (date1.getTime() - date2.getTime()) / 86400000;
        return dias;
    }

}
