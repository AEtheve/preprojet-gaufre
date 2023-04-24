package Structures;

public class Couple<E, T> {
    E first;
    T second;

    public Couple(E first, T second) {
        this.first = first;
        this.second = second;
    }

    public E GetFirst(){
        return first;
    }

    public T GetSecond(){
        return second;
    }

    public void SetFirst(E first){
        this.first = first;
    }

    public void SetSecond(T second){
        this.second = second;
    }
}