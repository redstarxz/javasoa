package com.me.note.rpc.server;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;




/**
 * Hello world!
 *
 */
@SpringBootApplication
@ImportResource({ "classpath:spring-conf/spring-note-rpc-server.xml" })
public class App {
	/*
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class.getName());

    @Bean
    public NoteService nst ()
    {
    	return new NoteService();
    }
	
	public static void main(String[] args) {
		LOGGER.info("start application");
		ApplicationContext ctx = new SpringApplicationBuilder().sources(App.class).web(false).run(args);
		NoteService ns = ctx.getBean(NoteService.class);
		boolean add = ns.addNote();
		if (add) {
			System.out.println("add success!");
		} else {
			System.out.println("add failed!");
		}
	}
	*/
private static final Logger LOGGER = LoggerFactory.getLogger(App.class.getName());
	
    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }	
    
	public static void main(String[] args) {
		try {
						
			LOGGER.info("服务开始启动......");
			
			System.setProperty("dubbo.application.logger","slf4j");
			
	        ApplicationContext ctx = new SpringApplicationBuilder()
	                .sources(App.class)
	                .web(false)
	                .run(args);       
	        
	        ///< 注册个性化关闭hook
	        Runtime.getRuntime().addShutdownHook(new ShutDownHook(ctx));

	        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
	        closeLatch.await();			
			
			LOGGER.info("服务启动完成......");

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("服务器启动异常", e);
		}
	}

}
