package Lapiseira;

import java.util.ArrayList;

public class Pencil {
    private final float calibre;
    private Lead lead; //lead da ponta
    private final ArrayList<Lead> tambor; //grafites no cano

    public Pencil(float calibre) {
        this.calibre = calibre;
        tambor = new ArrayList<>();
    }

    //insere um lead no barril
    public boolean insert(Lead lead) {
        if(calibre != lead.getCalibre()) {
            System.out.println("fail: calibre incompatível");
            return false;
        }
        tambor.add(lead);
        return true;
    }

    //remove e retorna o lead da ponta
    public Lead remove() {
        if(lead == null) {
            System.out.println("fail: nao existe grafite no bico");
            return null;
        }
        Lead backup = lead;
        lead = null;
        return backup;
    }

    // se a ponta estiver vazia, puxa o próximo lead do barril
    public boolean pull() {
        if (this.lead != null) {
            System.out.println("fail: ja existe grafite no bico");
            return false;
        }
//        if (this.tambor.isEmpty()) {
//            System.out.println("fail: nao existe grafite no barril");
//            return false;
//        }
        lead = tambor.remove(0);
        return true;
    }

    //se tiver grafite suficiente no bico, gaste e retorne true
    //lembre que os últimos 10mm não podem ser utilizados
    public void writePage() {
        if(lead == null) {
            System.out.println("fail: nao existe grafite no bico");
            return;
        }
        if (lead.getSize() == 10) {
            System.out.println("fail: tamanho insuficiente");
            return;
        }
        int diferenca = lead.getSize() - lead.usagePerSheet();
        if(diferenca >= 10) {
            lead.setSize(diferenca);
        } else {
            lead.setSize(10);
            System.out.println("fail: folha incompleta");
        }
    }
    
    @Override
    public String toString() {
        String saida = "calibre: " + calibre + ", bico: ";
        if (lead != null)
            saida += "[" + lead + "]";
        else
            saida += "[]";
        saida += ", tambor: {";
            for (Lead g : tambor)
                saida += "[" + g + "]";
        return saida + "}";
    }
}
