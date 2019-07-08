
package trabajo;


public class CamaraIp extends Productos {
    private String codigo;
    private String modelo;
    private int giro;
    private double megaPixeles;
    private double alcanceWifi;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getGiro() {
        return giro;
    }

    public void setGiro(int giro) {
        this.giro = giro;
    }

    public double getMegaPixeles() {
        return megaPixeles;
    }

    public void setMegaPixeles(double megaPixeles) {
        this.megaPixeles = megaPixeles;
    }

    public double getAlcanceWifi() {
        return alcanceWifi;
    }

    public void setAlcanceWifi(double alcanceWifi) {
        this.alcanceWifi = alcanceWifi;
    }


}
