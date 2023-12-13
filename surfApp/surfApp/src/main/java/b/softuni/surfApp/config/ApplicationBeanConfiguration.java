package b.softuni.surfApp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

    @Component
    public class ApplicationBeanConfiguration {

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

