/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.*;

/**
 *
 * @author Nguyen Thi Ngoc
 */
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
