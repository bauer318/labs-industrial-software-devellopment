package ru.rsreu.kibamba.lw1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.rsreu.kibamba.lw1.models.MedicinalHerb;
import ru.rsreu.kibamba.lw1.repositorys.MedicinalHerbRepository;

@SpringBootApplication
//@EnableAutoConfiguration
public class Lw1Application {

    public static void main(String[] args) {
        SpringApplication.run(Lw1Application.class, args);
    }
    @Bean
    CommandLineRunner run(MedicinalHerbRepository medicinalHerbRepository){
        return args->{
          medicinalHerbRepository.save(new MedicinalHerb(-1,"АвранАптекарский",
                  "Авран","Норичниковые","Ервазия",20,20.2,""));
            medicinalHerbRepository.save(new MedicinalHerb(-1,"АгаваАмериканская",
                    "Агава","Спаржевые","Америка",17,8.7,""));
            medicinalHerbRepository.save(new MedicinalHerb(-1,"Бадьян",
                    "Цветовый","Лимонниковые","СевернаяАмерика",18,12.5,""));
            medicinalHerbRepository.save(new MedicinalHerb(-1,"Басаби",
                    "Эвтрета","Канустные","Японя",35,20.2,""));
        };
    }

}
