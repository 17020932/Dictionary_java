package com;

import java.util.*;
import java.io.*;
import java.util.Comparator;

public class DictionaryManagement {

    Dictionary dictionary = new Dictionary();
    Scanner scan = new Scanner(System.in);
    public void insertFromFile(){

        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), "UTF-8"));
            String str = input.readLine();
            while (str != null){
                if(str.indexOf("\t") == -1){
                    str = input.readLine();
                    continue;
                }
                String[] part = str.trim().split("\t");
                if( part.length == 2){
                    Word w = new Word(part[0], part[1]);
                    dictionary.getNewWord().add(w);
                }
                str = input.readLine();
            }
        }
        catch (IOException e){
            System.out.println("fail");
        }
    }

    public void showAllWords() {
        Comparator<Word> a = new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWordTarget().compareTo(o2.getWordTarget());
            }
        };
        Collections.sort(dictionary.getNewWord(),a);
        System.out.printf("%-4s%c%-25s%c%-20s\n", "No", '|', "English",'|', "VietNamese");
        int i = 1;
        for(Word ele : dictionary.getNewWord()){
            System.out.printf("%-4d", i);
            ele.printWord();
            i++;
        }
    }
    public int LookUp(String find){
        Comparator<Word> a = new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWordTarget().compareTo(o2.getWordTarget());
            }
        };
        Collections.sort(dictionary.getNewWord(),a);
        int result = Collections.binarySearch(dictionary.getNewWord(),new Word(find, null),a);
        if(result < 0) return  -1;
        else return result;


    }
    public void dictionaryLookup() {
        String find = scan.nextLine().trim();
        int result = LookUp(find);
        if(result <0){
            System.out.println("Khong tim thay tu can tra!!!");
        }
        else System.out.println(dictionary.getNewWord().get(result).getWordExplain());
    }
    public void addWord () {
        String addTarget = scan.nextLine().trim();
        String addExplain = scan.nextLine();
        Word w = new Word(addTarget, addExplain);
        int a = LookUp(addTarget);
        if (a <0 ) {
            dictionary.getNewWord().add(w);

        } else System.out.println("Tu vua nhap da co trong danh sach!!!");
    }

    public void deleteWord() {
        String removeTarget = scan.nextLine().trim();
        int m = 0;
        for (int i = 0; i < dictionary.getNewWord().size(); i++) {
            if (dictionary.getNewWord().get(i).getWordTarget().trim().equals(removeTarget.trim())) {
                dictionary.getNewWord().remove(dictionary.getNewWord().get(i));
                m = m + 1;
            }
        }
        if (m == 0) System.out.println("Khong tim thay tu ban muon xoa!!!");
    }
    public void dictionarySearcher(){
        String find = scan.nextLine().trim();
        System.out.println(dictionary.getNewWord().size());
        for(int i = 0; i <dictionary.getNewWord().size(); i++){
            if(dictionary.getNewWord().get(i).getWordTarget().indexOf(find)== 0){
                dictionary.getNewWord().get(i).printWord();
            }
        }
    }
    public void updateDictionary(){
        String upTarget = scan.nextLine().trim();
        int a = LookUp(upTarget);
        if(a>0) {
            String upExplain = scan.nextLine();
            Word U = new Word(upTarget, upExplain);
            dictionary.getNewWord().remove(dictionary.getNewWord().get(a));
            dictionary.getNewWord().add(U);
        }
        else System.out.println("Khong tim thay tu can sua!!!");
    }
    public static void Menu(){
        System.out.println("\t\tDICTIONARY");
        System.out.println("\t1: Show Dictionary");
        System.out.println("\t2: Dictionary Lookup");
        System.out.println("\t3: DictionarySearcher");
        System.out.println("\t4: Add Word");
        System.out.println("\t5: Delete Word");
        System.out.println("\t6: Change Word");
        System.out.println("\t7: Export to File");
        System.out.println("\t8: Exit");
    }
    public void  editWord()
    {
        while(true)
        {
            Menu();
            int choice ;
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice)
            {
                case 1:
                    showAllWords();
                    break;
                case 2:
                    System.out.println("Nhap tu ban muon tra: ");
                    dictionaryLookup();
                    break;
                case 3 :
                    System.out.println("Ban muon tra nhung tu bat dau bang: ");
                    dictionarySearcher();
                    break;
                case 4 :
                    System.out.println("Nhap tu ban muon them(tieng anh va nghia tren 2 dong) ");
                    addWord();
                    break;
                case 5 :
                    System.out.println("Nhap tu ban muon xoa: ");
                    deleteWord();
                    break;

                case 6 :
                    System.out.println("Nhap tu ban muon sua( word_target and new word_explain): ");
                    updateDictionary();
                    break;
                case 7:
                    dictionaryExportToFile();
                case 8 :
                    System.exit(0);
                    break;
            }
        }
    }
    public void dictionaryExportToFile() {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dictionary.txt"), "UTF-8"));
            for (Word element : dictionary.getNewWord()) {
                output.write(element.getWordTarget() + "\t" + element.getWordExplain());
                output.newLine();
            }
            output.close();
        }
        catch (IOException ex) {
            System.out.println("fail");
        }
    }

}
