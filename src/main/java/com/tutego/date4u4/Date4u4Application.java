package com.tutego.date4u4;

import com.tutego.date4u4.core.FileSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
@EnableCaching
public class Date4u4Application {
  
  public static void main( String[] args ) {
    System.out.println("###################################################");
   ApplicationContext ctx = SpringApplication.run(Date4u4Application.class, args);
    //for( String Name : ctx.getBeanDefinitionNames() ) {
    //  System.out.println(Name);
    //}
    //System.out.println("ctx.getBean(FileSystem.class): " + ctx.getBean(FileSystem.class));
   
   
    
    System.out.println("###################################################");
  }
  
}
