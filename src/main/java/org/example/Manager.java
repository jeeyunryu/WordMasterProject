package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Manager {
    void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        WordCRUD word = new WordCRUD();
        int count = word.loadFile();
        System.out.println("-> " + count + "개의 단어를 가져왔습니다");
        while(true) {

            System.out.print("----------------------\n" +
                    "영단어장\n"
                    + "1. 모든 단어 보기\n"
                    + "2. 수준별 단어 보기\n"
                    + "3. 단어 검색\n"
                    + "4. 단어 추가\n"
                    + "5. 단어 수정\n"
                    + "6. 단어 삭제\n"
                    + "7. 파일 저장\n"
                    + "0. 나가기\n"
                    + "----------------------\n"
                    + "-> 메뉴를 선택해주세요 : ");
            menu = sc.nextInt();
            if(menu == 0) break;
            else if(menu == 4) {
                word.AddWord(sc);
            }
            else if(menu == 1) {
                word.ListAll();
            }
            else if(menu == 5) {
                word.EditWord(sc);
            }
            else if(menu == 6) {
                word.DeleteItem(sc);
            }
            else if(menu == 7) {
                word.SaveToFile();
            }
            else if(menu == 3) {
                word.searchWord(sc);
            }
            else if(menu == 2) {
                word.searchLevel(sc);
            }

        }

    }

}
