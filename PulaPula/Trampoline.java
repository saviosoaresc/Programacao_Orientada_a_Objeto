package PulaPula;

import java.util.Iterator;
import java.util.LinkedList;

public class Trampoline {
    private final LinkedList<Kid> waiting = new LinkedList<>();
    private final LinkedList<Kid> playing = new LinkedList<>();

    Trampoline() {
    }

    public void arrive(Kid kid) {
        waiting.addFirst(kid);
    }

    public void enter() {
        if (!waiting.isEmpty()) {
            playing.addFirst(waiting.removeLast());
        } else {
            waiting.clear();
        }
    }

    public void leave() {
        if (!playing.isEmpty()) {
            waiting.addFirst(playing.removeLast());
        } else {
            playing.clear();
        }
    }


    public Kid removeKid(String name) {
        for (int i = 0; i < waiting.size(); i++) {
            if(waiting.get(i).getName().equals(name)){
                Kid kid = waiting.get(i);
                waiting.remove(i);
                return kid;
            }
        }
        
        for (int i = 0; i < playing.size(); i++) {
            if(playing.get(i).getName().equals(name)){
                Kid kid = playing.get(i);
                playing.remove(i);
                return kid;
            }
        }
        
//        Iterator<Kid> iteratorP = playing.iterator();
//        while (iteratorP.hasNext()) {
//            Kid kid = iteratorP.next();
//            if (kid.getName().equals(name)) {
//                iteratorP.remove();
//                return kid;
//            }
//        }
//        
//        Iterator<Kid> iteratorW = waiting.iterator();
//        while (iteratorW.hasNext()) {
//            Kid kid = iteratorW.next();
//            if (kid.getName().equals(name)) {
//                iteratorW.remove();
//                return kid;
//            }
//        }
        return null;
    }

    @Override
    public String toString() {
        String saida = waiting + " => " + playing;
        return saida;
    }
}
