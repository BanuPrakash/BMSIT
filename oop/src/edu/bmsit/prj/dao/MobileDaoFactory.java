package edu.bmsit.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
    private static String DAO_CLASS = "";

    // static block
    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config"); // config.properties
        DAO_CLASS = resourceBundle.getString("MOBILE_DAO").trim();
    }
    public static MobileDao getMobileDao() {
//        return new MobileDaoSqlImpl();
        try {
            return (MobileDao) Class.forName(DAO_CLASS).getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }
}
