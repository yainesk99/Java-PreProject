package jm.task.core.jdbc.util;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public  class FactoryProvider {

public static UserDao configure(String d){

        String hibernate = "hibernate";

        if(d.equals(hibernate)){
            return new UserDaoHibernateImpl();
        }else {
            return new UserDaoJDBCImpl();
        }


    }


}
