package gestorAplicacion.Gestion;

public class Factura {
    //  Atributos
    private static int numeroFactura = 0;
    private int valor = 0;
    private String metodoPago;
    private boolean pagoPreconsumo;
    private Pedido pedido;
    private int propina;
    private boolean pagada;
    //  private Arraylist<String> platos = new ArrayList<String>();

    // Constructores
    public Factura(){};
    public Factura(Pedido pedido, String metodoPago, boolean pagoPreconsumo, int propina){
        this.pedido = pedido;
        this.metodoPago = metodoPago;
        this.pagoPreconsumo = pagoPreconsumo;
        this.propina = propina;
        this.pagada = false;
        numeroFactura++;
    }

    // Metodos
    public void pagar(){
        this.pagada = true;
    }
    public void agregarPlato(Plato plato){
        pedido.agregarPlato(plato);
    }
    public void setPropina(int propina){
        this.propina = propina;
    }
    public void setMetodoPago(String metodoPago){
        this.metodoPago = metodoPago;
    }
    public void setPagoPreconsumo(boolean pagoPreconsumo){
        this.pagoPreconsumo = pagoPreconsumo;
    }
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
    public String getMetodoPago(){
        return metodoPago;
    }
    public boolean getPagoPreconsumo(){
        return pagoPreconsumo;
    }
    public Pedido getPedido(){
        return pedido;
    }
    public int getPropina(){
        return propina;
    }
    public boolean getPagada(){
        return pagada;
    }
    public static int getNumeroFactura(){
        return numeroFactura;
    }
}
