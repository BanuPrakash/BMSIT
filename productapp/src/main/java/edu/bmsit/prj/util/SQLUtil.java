package edu.bmsit.prj.util;

import edu.bmsit.prj.annotation.Column;
import edu.bmsit.prj.annotation.Table;

import java.lang.reflect.Method;

// String is immutable
// Avoid String s = "Hello";
// s += "World";
// s += "123";
public class SQLUtil {
    StringBuilder builder = new StringBuilder(); // Thread Safe // Methods are synchronized
    // Book.class, Employee.class, Product.class
    public static String generateCreateSQL(Class<?> clazz) {
        StringBuffer buffer = new StringBuffer();
        Table table = clazz.getAnnotation(Table.class);
        if(table != null) {
            buffer.append("create table ");
            buffer.append(table.name());
            buffer.append("("); // create table BOOK_TABLE(
            Method[] methods = clazz.getDeclaredMethods(); // not inherited
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    Column col = m.getAnnotation(Column.class);
                    if(col != null) {
                        buffer.append(col.name());
                        buffer.append(" ");
                        buffer.append(col.type());
                        buffer.append(","); // create table BOOK_TABLE( BOOK_ISBN VARCHAR(255),

                    }
                }
            }
        }
        buffer.setCharAt(buffer.lastIndexOf(","), ')');
        return buffer.toString();
    }
}
