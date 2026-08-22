package edu.bmsit.prj.client;

import edu.bmsit.prj.entity.Book;
import edu.bmsit.prj.util.SQLUtil;

public class SQLClient {
    public static void main(String[] args) {
        String SQL = SQLUtil.generateCreateSQL(Book.class);
        System.out.println(SQL);
    }
}
