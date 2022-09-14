package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD{

    ArrayList<WordSpec> alist = new ArrayList<WordSpec>();
    private int count = 0;
    private int idx = 0;
    String level;
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
        level = sc.next();
        word = sc.next();
        System.out.print("-> 단어의 뜻을 적어주세요 : ");
        meaning = sc.next();
        alist.add(new WordSpec(level, word, meaning));
        count++;
        System.out.println("단어가 성공적으로 추가되었습니다");

    }

    public void ListAll() {
        for(int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + alist.get(i).getLevel() + "|" +
                    alist.get(i).getWord() + "|" +
                    alist.get(i).getMeaning());
        }
    }

    public void EditWord(Scanner sc) {
        ListAll();
        System.out.println("-> 어떤 단어를 수정하시겠습니까? : ");
        idx = sc.nextInt();
        System.out.print("-> 레벨과 단어를 써주세요 : ");
        level = sc.next();
        word = sc.next();
        System.out.print("-> 단어의 뜻을 적어주세요 : ");
        meaning = sc.next();
        alist.get(idx - 1).setLevel(level);
        alist.get(idx - 1).setWord(word);
        alist.get(idx - 1).setMeaning(meaning);


    }

    public void DeleteItem(Scanner sc) {
        String ans;
        ListAll();
        System.out.print("-> 어떤 단어를 삭제하시겠습니까? : ");
        idx = sc.nextInt();
        System.out.print("-> 진짜 삭제하시겠습니까? (y/n) : ");
        ans = sc.next();
        if(ans.compareToIgnoreCase("y") != 0) {
            return;
        }
        alist.remove(idx - 1);
        count--;
        System.out.println("-> 성공적으로 삭제되었습니다");

    }

    public void SaveToFile() throws IOException {
        FileWriter myWriter = new FileWriter("WordList.txt");
        for(int i = 0; i < count; i++) {
            myWriter.write(alist.get(i).getLevel() + "|" + alist.get(i).getWord() + "|" + alist.get(i).getMeaning() + "\n");
        }
        myWriter.close();
        System.out.println("-> 파일에 안전하게 저장되었습니다");

    }

    public int loadFile() {
        try {
            Scanner textReader = new Scanner(new File("WordList.txt"));
            while (textReader.hasNextLine()) {
                String data = textReader.nextLine();

                String[] dataArray = data.split("\\|");

                alist.add(new WordSpec(dataArray[0], dataArray[1], dataArray[2]));
                count++;
            }

        } catch (FileNotFoundException e) {

        }
        return count;

    }

    public void searchWord(Scanner sc) {
        String ans;
        ListAll();
        System.out.print("-> 어떤 단어를 검색하시겠습니까? : ");
        String wordForSearch = sc.next();
        int j = 0;
        for(int i = 0; i < count; i++) {
            if(alist.get(i).getWord().contains(wordForSearch)) {
                System.out.println((j + 1) + ". " + alist.get(i).getLevel() + "|" +
                        alist.get(i).getWord() + "|" +
                        alist.get(i).getMeaning());
                j++;
            }
        }
    }

    public void searchLevel(Scanner sc) {
        String ans;
        ListAll();
        System.out.print("-> 어떤 단어를 검색하시겠습니까? : ");
        String levelForSearch = sc.next();
        int j = 0;
        for(int i = 0; i < count; i++) {
            if(alist.get(i).getLevel().contains(levelForSearch)) {
                System.out.println((j + 1) + ". " + alist.get(i).getLevel() + "|" +
                        alist.get(i).getWord() + "|" +
                        alist.get(i).getMeaning());
                j++;
            }
        }
    }
}
