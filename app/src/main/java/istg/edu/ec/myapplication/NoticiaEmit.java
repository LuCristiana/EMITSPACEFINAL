package istg.edu.ec.myapplication;

public class NoticiaEmit {

 private String titulo;
 private String detalle;
 private String fecha;
 private  String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public NoticiaEmit(String titulo, String detalle, String fecha, String picUrl) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = fecha;
        this.picUrl = picUrl;
    }
}
