package xyz.mon0mon.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
/**
 * NOTE
 * @Configuration 내부에는 @Component 어노테이션이 존재하기 때문에, 스프링의 @ComponentScan의 대상이 됨
 * 따라서 기존의 AppConfig는 @ComponentScan의 대상이 되지 않도록, 예외처리
 */
public class AutoAppConfig {

}

