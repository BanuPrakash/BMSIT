package edu.bmsit.prj.dao;

import edu.bmsit.prj.entity.Mobile;

public class MobileDaoSqlImpl implements MobileDao {
    @Override
    public void addMobile(Mobile m) {
        System.out.println(m.getName() + " stored in DB!!!");
    }
}
