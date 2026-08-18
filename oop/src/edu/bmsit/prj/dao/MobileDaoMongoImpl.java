package edu.bmsit.prj.dao;

import edu.bmsit.prj.entity.Mobile;

public class MobileDaoMongoImpl implements  MobileDao{

    @Override
    public void addMobile(Mobile m) {
        System.out.println(m.getName() + " stored in MongoDB!!!");
    }
}
