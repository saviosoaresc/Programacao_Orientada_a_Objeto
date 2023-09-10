package Cinema;

public class Cliente {
    private String id;
    private String fone;
    
    public Cliente (String id, String fone) {
        this.id = id;
        this.fone = fone;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
    @Override
    public String toString() {
        if("-".equals(id)){
            return id;
        }
        return id + ":" + fone;
    }
}
