package koschei.config;

import koschei.models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "koschei")
public class AppConfig {

    @Bean
    public static Island2 getIsland(Wood3 wood) {
        return new Island2(wood);
    }

    @Bean
    public static Egg6 getEgg(Needle7 needle7){return new Egg6(needle7);}

    @Bean
    public static Needle7 getNeedle(Deth8 deth8){return new Needle7(deth8);}

    @Bean
    public static Deth8 getDeth(){return new Deth8();}
}
