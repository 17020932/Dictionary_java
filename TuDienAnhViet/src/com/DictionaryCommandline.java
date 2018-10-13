package com;

import java.util.Scanner;

public class DictionaryCommandline {

    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public static void main (String[] agrs){
        DictionaryCommandline cmd = new DictionaryCommandline();
        cmd.dictionaryManagement.insertFromFile();
        cmd.dictionaryManagement.editWord();
    }
}
