package com.mycom.word;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner sc;
    final String fname = "Dictionary.txt";
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
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = sc.nextInt();
        String word = sc.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = sc.nextLine();

        return new Word(0,level,word,meaning );
    }

    public void addItem(){
        Word newOne = (Word)add();
        list.add(newOne);
        System.out.println("새 단어가 단어장에 추가되었습니다 !!!");
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

    public void listAll(){
        if(list.isEmpty()) {
            System.out.println("저장된 단어가 없습니다.");
            return;
        }
        System.out.println("--------------------------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.print(i+1 + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }
    public ArrayList<Integer> listAll(String keyword) {

        ArrayList<Integer> idList = new ArrayList<>();
        int j = 0;
        System.out.println("--------------------------------");
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i).getWord();
            if (!word.contains(keyword)) continue;
            System.out.print(j + 1 + " ");
            System.out.println(list.get(i).toString());
            idList.add(i);
            j++;
        }
        if (j == 0) System.out.println("검색된 단어가 없습니다.");
        System.out.println("--------------------------------");

        return idList;
    }
    public void listAll(int level) {
        int j = 0;
        System.out.println("--------------------------------");
        for (int i = 0; i < list.size(); i++) {
            int ilevel = list.get(i).getLevel();
            if (ilevel != level) continue;
            System.out.print(j + 1 + " ");
            System.out.println(list.get(i).toString());
            j++;
        }
        if (j == 0) System.out.println("검색된 단어가 없습니다.");
        System.out.println("--------------------------------");
    }

    public void updateItem(){
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = sc.next();
        ArrayList<Integer> idList = this.listAll(keyword);
        if(idList.isEmpty()) return;
        System.out.print("=> 수정할 번호 선택 : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("=> 뜻 입력 : ");
        String meaning = sc.nextLine();
        Word word = list.get(idList.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다.");
    }

    public void deleteItem(){
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = sc.next();
        ArrayList<Integer> idList = this.listAll(keyword);
        if(idList.isEmpty()) return;
        System.out.print("=> 삭제할 번호 선택 : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("=> 정말로 삭제하실래요?(Y/n)");
        String ans = sc.next();
        if(ans.equalsIgnoreCase("y")) {
            list.remove((int)idList.get(id-1));
            System.out.println("단어가 삭제되었습니다.");
        } else
            System.out.println("취소되었습니다.");
    }

    public void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;

            while(true) {
                line = br.readLine();
                if (line == null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0,level,word,meaning));
                count++;
            }
            br.close();
            System.out.println("==> " + count + "개 로딩 완료!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("test.txt"));
            for(Word one : list) {
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("모든 단어 파일 저장 완료 !!! \n");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void searchLevel(){
        System.out.print("=> 레벨(1:초급, 2:중급, 3:고급) 선택 : ");
        int level = sc.nextInt();
        listAll(level);
    }

    public void searchWord() {
         System.out.print("=> 검색할 단어 입력 : ");
         String search = sc.next();
         listAll(search);
    }
}
