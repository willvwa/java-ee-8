package cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.time.LocalDateTime;

@ApplicationScoped
public class ApplicationBean implements Serializable {

    public static Integer contador = 0;

    public ApplicationBean() {

        contador++;
    }

    public String getContador() {

        return contador.toString();
    }

    @PostConstruct
    private void init() {

        System.out.println("ApplicationBean foi criada: " + LocalDateTime.now());
    }

    @PreDestroy
    private void end() {

        System.out.println("ApplicationBean foi destruída: " + LocalDateTime.now());
    }
}
