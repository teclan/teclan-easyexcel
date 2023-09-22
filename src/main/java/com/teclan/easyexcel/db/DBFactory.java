package com.teclan.easyexcel.db;

import com.teclan.easyexcel.config.CommonConfig;
import com.typesafe.config.Config;
import org.javalite.activejdbc.DB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBFactory.class);

    private static   String DRIVER_CLASS = "";
    private static   String URL = "";
    private static   String USER = "";
    private static   String PASSWORD = "";
    private static String dbName = "default";

    private static DB db;

    static {
        Config config = CommonConfig.getConfig();
        Config jdbc = config.getConfig("jdbc");
        DRIVER_CLASS = jdbc.getString("driver");
        URL = jdbc.getString("url");
        USER = jdbc.getString("username");
        PASSWORD = jdbc.getString("password");
    }



    public static DB getDb() {
        return getDb(dbName);
    }

    public static DB getDb(String dbName) {

        if (db == null) {
            db = new DB(dbName);
        }
        return db;
    }


    public static void open(String dbName) {
        getDb(dbName).open(DRIVER_CLASS, URL, USER, PASSWORD);
        LOGGER.info("\n打开数据库成功...");
    }

    public static void close(String dbName){
        getDb(dbName).close();
        LOGGER.info("\n关闭数据库成功...");
    }


    public static void open() {
        getDb().open(DRIVER_CLASS, URL, USER, PASSWORD);
        LOGGER.info("\n打开数据库成功...");
    }

    public static void close(){
        getDb().close();
        LOGGER.info("\n关闭数据库成功...");
    }

}
