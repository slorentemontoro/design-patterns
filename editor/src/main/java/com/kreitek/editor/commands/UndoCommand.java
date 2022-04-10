package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.Memento.CareTaker;
import com.kreitek.editor.Memento.Memento;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private final CareTaker commandCareTaker = CareTaker.getInstance();

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.clear();
        Memento memento = commandCareTaker.get();
        if (memento != null){
            documentLines.addAll(memento.getState());
        }else{
            documentLines = new ArrayList<>();
        }
    }

    public Memento setState(ArrayList<String> state){
        return new Memento(state);
    }

}
