package Contato;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String name;
    private boolean favorited = false;
    private List<Fone> fones;

    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
        this.favorited = false;
        this.fones = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Fone> getFones() {
        return fones;
    }

    public void addFone(String id, String number) {
        Fone fone = new Fone(id, number);
        if(fone.isValid(number)){
            fones.add(new Fone(id, number));            
        }else System.out.println("fail: invalid number");
    }

    public void rmFone(int index) {
        if (index >= 0 && index < fones.size()) {
            fones.remove(index);
        }else System.out.println("fail: invalid index");
    }

    public void toggleFavorited() {
        favorited = !favorited;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public String toString() {
        String saida = "";
        if(isFavorited()) saida += "@ ";
        else saida += "- ";
        
        saida +=  name + " " + fones;        
        return saida;
    }
}

