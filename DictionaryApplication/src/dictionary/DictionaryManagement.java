/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nguyen Thi Ngoc
 */
public class DictionaryManagement {
    
    Dictionary dictionary = new Dictionary();
    Scanner scan = new Scanner(System.in);
    //nhập dữ liệu từ bàn phím
    public void insertFromCommandline() {

        for(int i=0; i<3; i++){
            Word w = new Word(scan.nextLine(), scan.nextLine());
            dictionary.getNewWord().add(w);
        }
    }

    // nhập dữ liệu từ file
    public void insertFromFile(){

        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary1.txt"), "UTF-8"));
            String str = input.readLine();
            while (str != null){
                if(str.indexOf("\t") == -1){
                    str = input.readLine();
                    continue;
                }
                String[] part = str.trim().split("\t");
                if(part.length == 2) {
                Word w = new Word(part[0].toLowerCase(), part[1].toLowerCase());
                dictionary.getNewWord().add(w);}
                str = input.readLine();
            }
        }
        catch (IOException e){
            System.out.println("fail");
        }
        dictionarySort();
    }

    //hiển thị toàn bộ từ có trong danh sách
    public void showAllWords() {
        System.out.printf("%-4s%c%-25s%c%-20s\n", "No", '|', "English",'|', "VietNamese");
        int i = 1;
        for(Word element : dictionary.getNewWord()){
            System.out.printf("%-4d", i);
            element.printWord();
            i++;
        }
    }


    //sắp xếp các từ trong từ điển theo thứ tự
    public void dictionarySort() {
        Comparator<Word> check = new Comparator<Word>() {
            public int compare(Word o1, Word o2) {
                return o1.getWord_target().compareTo(o2.getWord_target());
            }
        };

        Collections.sort(dictionary.getNewWord(), check);
    }

    //tìm kiếm nhị phân trong từ điển trả về vị trí của từ cần tìm
    public int LookUp(String str) {
        Comparator<Word> check = new Comparator<Word>() {
            public int compare(Word o1, Word o2) {
                return o1.getWord_target().compareTo(o2.getWord_target());
            }
        };

        Collections.sort(dictionary.getNewWord(), check);

        int result = Collections.binarySearch(dictionary.getNewWord(), new Word(str.trim(), null), check);

        if(result < 0 ) return -1;
        else            return result;
    }

    //tìm kiếm từ một cách chính xác in ra nghĩa của từ cần tìm
    public void dictionaryLookup(){
        System.out.print("Nhap tu can tim : " );
        String str_find = scan.nextLine().trim();
        int index = LookUp(str_find);
        if(index >= 0)  System.out.println("Nghia cua tu can tim : " + dictionary.getNewWord().get(index).getWord_explain());
        else            System.out.println("Tu ban vua nhap chua duoc cap nhat trong tu dien " + str_find);
    }

    //thêm từ mới vào từ điển
    public void add() {
        System.out.println("Nhap tu muon them va nghia cua tu (tren 2 dong khac nhau): ");
        String add_target = scan.nextLine();
        String add_explain = scan.nextLine();
        Word w = new Word(add_target, add_explain);
        int index = LookUp(add_target);
        if(index >= 0)   System.out.println("Tu vua nhap da co trong tu dien");
        else    dictionary.getNewWord().add(w);
        dictionarySort();
    }

    //xóa từ khỏi từ điển
    public void remove(){
        System.out.print("Nhap vao tu muon xoa : ");
        String remove_target = scan.nextLine();
        int index = LookUp(remove_target);
        if(index < 0)   System.out.println("Khong tim thay " + remove_target +" trong tu dien");
        else            dictionary.getNewWord().remove(index);

    }

    //sửa từ
    public void repair() {
        System.out.print("Nhap vao tu muon sua : ");
        String repair_word = scan.nextLine();
        int index = LookUp(repair_word);
        if(index >= 0) {
            System.out.print("nhap vao nghia moi cua tu : ");
            dictionary.getNewWord().get(index).setWord_explain(scan.nextLine());
        }
        else    System.out.println(repair_word + " chua co trong tu dien");
    }

    //tìm kiếm gần đúng trả về một mảng
    public void dictionarySearcher() {
        List<Word> wordSearch = new ArrayList<Word>();
        System.out.print("Nhap vao chuoi muon tim : ");
        String str_search = scan.next().trim();
        for(int i=0; i<dictionary.getNewWord().size(); i++) {
            if(dictionary.getNewWord().get(i).getWord_target().indexOf(str_search) == 0) {
                wordSearch.add(dictionary.getNewWord().get(i));
            }
        }

        for(int i=0; i<wordSearch.size(); i++) {
            wordSearch.get(i).printWord();
        }
    }

    //xuất dữ liệu ra file(ghi đè file cũ)
    public void dictionaryExportToFile() {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dictionary1.txt"), "UTF-8"));
            for (Word element : dictionary.getNewWord()) {
                output.write(element.getWord_target() + "\t" + element.getWord_explain());
                output.newLine();
            }
            output.close();
        }
        catch (IOException ex) {
            System.out.println("fail");
        }
    }

    
}
