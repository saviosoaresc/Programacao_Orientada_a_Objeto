package Grafite;

public class Pencil {
    private float thickness;
    private Lead tip;

    public Pencil(float thickness) {
        this.thickness = thickness;
    }
    
    public float getThickness() {
        return thickness;
    }

    public void setThickness(float value) {
        this.thickness = value;
    }

    public boolean hasGrafite() {
        if(tip != null) return true;
        else return false;
    }

    public boolean insert(Lead grafite) {
        if(!hasGrafite()){
            if(grafite.getThickness() != this.thickness){
                System.out.println("fail: calibre incompativel");
                return false;
            }else{
                tip = grafite;
                return true;            
            }            
        }else System.out.println("fail: ja existe grafite");
        return false;
    }

    public Lead remove() {
        if(hasGrafite()){
            Lead leadV = tip;
            leadV = this.tip;
            tip = null;
            return leadV;
        }else return null;
    }

    public void writePage() {
        if(hasGrafite()){
            int diferenca = tip.getSize() - tip.usagePerSheet();
            if(tip.getSize() == 10 && diferenca < 10){
                System.out.println("fail: tamanho insuficiente");
                tip.setSize(10);
            }else if(tip.getSize() > 10 && diferenca < 10){
                System.out.println("fail: folha incompleta");
                tip.setSize(10);
            }else tip.setSize(diferenca);            
        }else System.out.println("fail: nao existe grafite");
    }
    
    public String toString() {
        String saida = "calibre: " + thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}
