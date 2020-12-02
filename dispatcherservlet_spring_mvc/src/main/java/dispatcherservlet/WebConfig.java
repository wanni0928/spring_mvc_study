package dispatcherservlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Configuration
//@ComponentScan(useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
//    @Bean
//    public HandlerMapping handlerMapping() {
//        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
//        handlerMapping.setInterceptors();
//        handlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return handlerMapping;
//    }
//
//    @Bean
//    public HandlerAdapter handlerAdapter() {
//        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
//        List<HttpMessageConverter<?>> messageConverters = handlerAdapter.getMessageConverters();
//        return handlerAdapter;
//    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    // 이 방식은 빈으로 등록하는 것이 아니라, Servlet Dispatcher 의 InternalResourceViewResolver를 Override 해서 사용한다.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
    /**
     * 이렇게 WebMvcConfigurer를 implements하여 필요한 추상 메소드를 구현하는 것이. WebMvc를 스프링부트 없이 활용하는 방법이다.
     * */
}
