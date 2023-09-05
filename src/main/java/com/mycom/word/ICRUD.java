package com.mycom.word;

public interface ICRUD {
    public Object add();
    public int update(Object ob);
    public int delete(Object ob);
    public void selectOne(int id);
}
