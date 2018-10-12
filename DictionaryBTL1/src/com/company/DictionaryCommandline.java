package com.company;

import java.util.Scanner;

public class DictionaryCommandline {

    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public void showAllWords(){
        dictionaryManagement.showAllWords();
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();
        showAllWords();
        dictionaryManagement.dictionaryLookup();
    }

    public static void main (String[] agrs){
        DictionaryCommandline cmd = new DictionaryCommandline();
//        cmd.dictionaryManagement.insertFromFile();
//        cmd.dictionaryManagement.showAllWords();
//        cmd.dictionaryManagement.updateDictionary();
//        cmd.dictionaryManagement.showAllWords();
        cmd.dictionaryManagement.insertFromFile();
        cmd.dictionaryManagement.editWord();
    }
}
