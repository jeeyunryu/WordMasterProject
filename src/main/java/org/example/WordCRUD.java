package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD{

    ArrayList<WordSpec> alist = new ArrayList<WordSpec>();
    ArrayList<Integer> tmpList = new ArrayList<Integer>();
    private int count = 0;
    private int idx = 0;
    int level;
    String word;
    String meaning;

    public WordCRUD() {

    }
    public void Create(){

    }

    @Override
    public void Read() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Delete() {

    }

    public void AddWord(Scanner sc) {

        System.out.print("-> 레벨과 단어를 써주세요 : ");
        level = sc.nextInt();
        word = sc.next();
        System.out.print("-> 단어의 뜻을 적어주세요 : ");
        sc.nextLine();
        meaning = sc.nextLine();
        alist.add(new WordSpec(level, word, meaning));
        count++;
        System.out.println("단어가 성공적으로 추가되었습니다");

    }

    public void ListAll() {
        System.out.println("--------------------------------");
        for(int i = 0; i < count; i++) {
            System.out.print(i + 1 + " ");
            for(int s = 0; s < alist.get(i).getLevel(); s++) {
                System.out.print("*");
            }
            System.out.println(" " + alist.get(i).getWord() + " " + alist.get(i).getMeaning());
        }
        System.out.println("--------------------------------\n");
    }

    public void ListAll(int level) {
        System.out.println("--------------------------------");
        int j = 0;
        for(int i = 0; i < count; i++) {
            if(alist.get(i).getLevel() == level) {
                System.out.print(j + 1 + " ");
                for(int s = 0; s < alist.get(i).getLevel(); s++) {
                    System.out.print("*");
                }
                System.out.println(" " + alist.get(i).getWord() + " " + alist.get(i).getMeaning());
                j++;
            }
        }
        System.out.println("--------------------------------");
    }

    public void ListAll(String word) {

        System.out.println("--------------------------------");
        int j = 0;
        tmpList.clear();
        for(int i = 0; i < count; i++) {
            if(alist.get(i).getWord().contains(word)) {
                System.out.print(j + 1 + " ");
                for(int s = 0; s < alist.get(i).getLevel(); s++) {
                    System.out.print("*");
                }
                System.out.println(" " + alist.get(i).getWord() + " " + alist.get(i).getMeaning());
                j++;
                tmpList.add(i);
            }
        }
        System.out.println("--------------------------------");
    }

    public void EditWord(Scanner sc) {

        System.out.print("\n=> 수정할 단어 검색 : ");
        String word2Edit = sc.next();
        ListAll(word2Edit);
        System.out.print("=> 수정할 번호 검색 : ");
        idx = sc.nextInt();
        sc.nextLine();
        System.out.print("=> 뜻 입력 : ");
        meaning = sc.nextLine();
        alist.get(tmpList.get(idx - 1)).setMeaning(meaning);
        System.out.println("\n단어 수정이 성공적으로 되었습니다!!\n");


    }

    public void DeleteItem(Scanner sc) {
        String ans;

        System.out.print("\n=> 삭제할 단어 검색 : ");
        String word2Edit = sc.next();
        ListAll(word2Edit);
        System.out.print("=> 삭제할 번호 검색 : ");
        idx = sc.nextInt();
        sc.nextLine();
        System.out.print("=> 정말로 삭제하실래요?(Y/n) ");
        ans = sc.next();
        if(!ans.equalsIgnoreCase("y")) {
            return;
        }

        alist.remove((int)tmpList.get(idx - 1));
        count--;
        System.out.println("\n선택한 단어 삭제 완료 !!!\n");

    }

    public void SaveToFile() throws IOException {
        FileWriter myWriter = new FileWriter("WordList.txt");
        for(int i = 0; i < count; i++) {
            myWriter.write(alist.get(i).getLevel() + "|" + alist.get(i).getWord() + "|" + alist.get(i).getMeaning() + "\n");
        }
        myWriter.close();
        System.out.println("\n모든 단어 파일 저장 완료 !!!\n");

    }

    public int loadFile() {
        try {
            Scanner textReader = new Scanner(new File("WordList.txt"));
            while (textReader.hasNextLine()) {
                String data = textReader.nextLine();

                String[] dataArray = data.split("\\|");

                alist.add(new WordSpec(Integer.parseInt(dataArray[0]), dataArray[1], dataArray[2]));
                count++;
            }

        } catch (FileNotFoundException e) {

        }
        return count;

    }

    public void searchWord(Scanner sc) {
        String ans;

        System.out.print("\n=> 검색할 단어 입력 : ");
        String wordForSearch = sc.next();
        ListAll(wordForSearch);

    }

    public void searchLevel(Scanner sc) {
        String ans;
        System.out.print("\n=> 레벨(1:초급, 2:중급, 3:고급) 선택 : ");
        int levelForSearch = sc.nextInt();
        ListAll(levelForSearch);

    }
}
