package com.me.note.rpc.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

/**  
 * 类描述： 系统关闭钩子，用于关闭Spring资源 
 * @author Suoron
 * 
 */
public class ShutDownHook extends Thread {

    private Log logger = LogFactory.getLog(getClass());

    private ApplicationContext applicationContext;

    public ShutDownHook(ApplicationContext applicationContext ){
        super();
        this.applicationContext = applicationContext;
    }

    @Override  
    public void run() {
        logger.info("Start clean the login info.");
        //关机前的个性化descory       
        logger.info("Socket server shutdown");
    }
}

