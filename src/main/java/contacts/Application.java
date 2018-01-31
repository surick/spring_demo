package contacts;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *demo
 *
 *@author w24164
 *@create 2018-01-31 15:48
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args){
       SpringApplication.run(Application.class,args);
    }
}
