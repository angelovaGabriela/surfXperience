package b.softuni.surfApp.config;

import b.softuni.surfApp.repository.UserRolesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
    public class AppConfig {

        @Bean
        public DataSourceInitializer dataSourceInitializer(DataSource dataSource,
                                                           UserRolesRepository userRolesRepository,
                                                           ResourceLoader resourceLoader) {
            DataSourceInitializer initializer =  new DataSourceInitializer();
            initializer.setDataSource(dataSource);

            if (userRolesRepository.count() == 0) {
                ResourceDatabasePopulator populator = new ResourceDatabasePopulator();

                populator.addScript(resourceLoader.getResource("classpath:data.sql"));

                initializer.setDatabasePopulator(populator);
            }


        return initializer;
        }


        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }

    }

