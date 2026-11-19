package dam.castellet2627;

public class Atleta {
    private int id;
    private String nombre;
    private int codDeporte; // ID спорта, к которому привязан атлет

    public Atleta(int id, String nombre, int codDeporte) {
        this.id = id;
        this.nombre = nombre;
        this.codDeporte = codDeporte;
    }

    public Atleta(String nombre, int codDeporte) {
        this.nombre = nombre;
        this.codDeporte = codDeporte;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCodDeporte() { return codDeporte; }
    public void setCodDeporte(int codDeporte) { this.codDeporte = codDeporte; }

    @Override
    public String toString() {
        return "Atleta: " + nombre + " (ID спорт: " + codDeporte + ")";
    }
}