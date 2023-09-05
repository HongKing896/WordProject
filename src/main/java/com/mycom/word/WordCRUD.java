package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner sc;
    /*
    => 난이도(1,2,3) & 새 단어 입력 : 1 driveway
    뜻 입력 : 차고 진입로
    새 단어가 단어장에 추가되었습니다 !!!
    */

    WordCRUD(Scanner sc) {
        list = new ArrayList<>();
        this.sc = sc;
    }

    @Override
    public Object add() {
        System.out.print(" => 난이도(1,2,3) & 새 단어 입력 :");
        
        return null;
    }

    @Override
    public int update(Object ob) {
        return 0;
    }

    @Override
    public int delete(Object ob) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
}
