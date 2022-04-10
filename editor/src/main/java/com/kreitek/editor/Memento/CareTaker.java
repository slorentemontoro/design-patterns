package com.kreitek.editor.Memento;


import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private static CareTaker instance;
    private final List<Memento> mementoList = new ArrayList<>();

    public static CareTaker getInstance(){
        if (instance == null) {
            instance = new CareTaker();

        }
        return instance;
    }

    public  void add(Memento memento){
        mementoList.add(memento);
    }

    public Memento get(){
        if (mementoList.size() > 0){
            int index = mementoList.size() - 1;
            Memento memento = mementoList.get(index);
            mementoList.remove(index);
            return memento;
        }
        return null;
    }
}
