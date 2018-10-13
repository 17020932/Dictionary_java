package com;


public class Word {
    private String wordTarget;
    private String wordExplain;

    public  Word(String wordTarget, String wordExplain){
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public String getWordTarget() {
        return wordTarget;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public void printWord(){
        System.out.printf("%c%-25s%c%-20s\n",'|' , wordTarget,'|' , wordExplain);
    }
}
