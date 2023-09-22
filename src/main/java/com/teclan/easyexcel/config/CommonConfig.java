package com.teclan.easyexcel.config;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class CommonConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(CommonConfig.class);
    private final static String filePath = "conf/application.json";
    private final static String base = System.getProperty("user.dir");
    public   static Config config = ConfigFactory.parseFile(new File(base + File.separator + filePath));

    public  static Config getConfig(){
        return config;
    }
}
