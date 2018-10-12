package com.company;
import java.util.*;

public class Dictionary {
    private List <Word> newWord = new ArrayList<Word>();

    public void setNewWord(List<Word> newWord) {
        for(int i=0; i<newWord.size(); i++){
            this.newWord.add(newWord.get(i));
        }
    }

    public List<Word> getNewWord() {
        return newWord;
    }
}
