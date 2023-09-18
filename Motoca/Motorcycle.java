package Motoca;

class Motorcycle {
    private Person person;
    private int power;
    private int time;

    //inicia o atributo power, time com zero e person com null
    public Motorcycle(int power) {
        this.power = power;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    //comprar mais tempo
    public void buy(int time){
        this.time += time;
    }
    
    //Se estiver vazio, coloca a pessoa na moto e retorna true
    public boolean enter(Person person) {
        if(this.person == null){
            this.person = person;
            return true;
        }else{
            System.out.println("fail: busy motorcycle");
            return false;
        }
    }
    
    public Person leave() {
        if(person != null){
//            System.out.println(this.person);
            Person personV = person;
            personV = this.person;
            person = null;
            return personV;
        }
        return null;
    }
    
    public void drive(int time){
        if(this.time > 0){
            if(person != null){
                if(person.getAge() > 10){
                    System.out.println("fail: too old to drive");
                }else {
                    int diferenca = this.time - time;
                    if(diferenca < 0){
                        System.out.println("fail: time finished after " + -1 * diferenca + " minutes");
                        this.time = 0;
                        return;
                    }
                    this.time -= time;
                }
            }else System.out.println("fail: empty motorcycle");
        }else System.out.println("fail: buy time first");
    }
    
    //buzinar
    public void honk(){
        System.out.print("P");
        for(int i = 0; i < power; i++){
            System.out.print("e");
        }
        System.out.println("m");
    }
    
    public String toString(){
        String saida = "power:" + power + ", time:" + time + ", person:";
        if (person != null)
            saida += "(" + person + ")";
        else
            saida += "(empty)";
        return saida;
    }
}
