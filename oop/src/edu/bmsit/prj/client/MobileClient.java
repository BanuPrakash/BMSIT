package edu.bmsit.prj.client;

import edu.bmsit.prj.dao.MobileDao;
import edu.bmsit.prj.dao.MobileDaoFactory;
//import edu.bmsit.prj.dao.MobileDaoMongoImpl;
//import edu.bmsit.prj.dao.MobileDaoSqlImpl;
import edu.bmsit.prj.entity.Mobile;

public class MobileClient {
    public static void main(String[] args) {
//        MobileDao mobileDao = new MobileDaoMongoImpl();
//        MobileDao mobileDao = new MobileDaoSqlImpl(); // switch to different strategy
        MobileDao mobileDao = MobileDaoFactory.getMobileDao();
        Mobile mobile = new Mobile(34, "iPhone 17", 98000.00, "5G");
        mobileDao.addMobile(mobile);
    }
}
