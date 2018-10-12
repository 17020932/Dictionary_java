package Dictionary1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DictionaryCommandline {

    DictionaryManagement dictionary_management = new DictionaryManagement();

        public void showAllWords(){
            dictionary_management.showAllWords();
        }

        public void dictionaryBasic() {
            dictionary_management.insertFromCommandline();
            showAllWords();
        }

        public void dictionaryAdvanced() {
            dictionary_management.insertFromFile();
            showAllWords();
        }

        public void cmdLookUp() {
            dictionary_management.dictionaryLookup();
        }

        public void cmdRemove() {
            dictionary_management.remove();
        }

        public void cmdAdd() {
            dictionary_management.add();
        }

        public void cmdRepair() {
            dictionary_management.repair();
        }

        public void cmdSearcher() {
            dictionary_management.dictionarySearcher();
        }

        public void cmdDictionaryExportToFile () {
            dictionary_management.dictionaryExportToFile();
        }

    public static void main (String[] agrs){
        DictionaryCommandline cmd = new DictionaryCommandline();
        cmd.dictionaryAdvanced();
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
//            System.out.println("1. thêm dữ liệu từ điển từ bàn phím và hiển thị dữ liệu");
            System.out.println("\t\t\t\tMenu");
            System.out.println("\t1. tra cuu tu dien bang dong lenh");
            System.out.println("\t2. them du lieu tu dien bang dong lenh");
            System.out.println("\t3. sua du lieu tu dien bang dong lenh");
            System.out.println("\t4. xoa du lieu tu dien bang dong lenh");
            System.out.println("\t5. tim kiem gan dung tra ve mot mang tu co bat dau bang chuoi nhap vao");
//            System.out.println("\t6. luu thay doi");
            System.out.println("\t6. thoat khoi chuong trinh");
            System.out.print("nhap vao lua chon cua ban : ");
            int i = scan.nextInt();
            switch (i) {
//                case 1 :
//                    cmd.dictionaryBasic();
//                    break;
//                case 2 :
//                    cmd.dictionaryAdvanced();
//                    break;
                case 1 :
                    cmd.cmdLookUp();
                    break;
                case 2 :
                    cmd.cmdAdd();
                    break;
                case 3 :
                    cmd.cmdRepair();
                    break;
                case 4 :
                    cmd.cmdRemove();
                    break;
                case 5 :
                    cmd.cmdSearcher();
                    break;
                case 6 :
                    cmd.cmdDictionaryExportToFile();
                    exit = true;
                    break;
//                case 7 :
//                    exit = true;
//                    break;
            }
        }

    }
}
