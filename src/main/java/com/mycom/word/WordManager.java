package com.mycom.word;
import java.util.Scanner;
public class WordManager {
    Scanner sc = new Scanner(System.in);
    WordCRUD wordCRUD;

    public WordManager() {
        wordCRUD = new WordCRUD(sc);
    }

    public int selectMenu() {
        System.out.print("********************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n" +
                "******************** \n" +
                "=> 원하는 메뉴는? ");
        return sc.nextInt();
    }
    public void start() {
        wordCRUD.loadFile();
        while(true) {
            int menu = selectMenu();
            switch (menu){
                case 0 : {
                    System.out.println("프로그램 종료! 다음에 만나요~");
                    return;
                }
                case 1 : {
                    //list
                    wordCRUD.listAll();
                    break;
                }
                case 2 : {
                    wordCRUD.searchLevel();
                    break;
                }
                case 3 : {
                    wordCRUD.searchWord();
                    break;
                }
                case 4 : {
                    wordCRUD.addItem();
                    break;
                }
                case 5 : {
                    wordCRUD.updateItem();
                    break;
                }
                case 6 : {
                    wordCRUD.deleteItem();
                    break;
                }
                case 7 : {
                    wordCRUD.saveFile();
                    break;
                }
                default :
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}