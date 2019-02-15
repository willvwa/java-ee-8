package cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;

@SessionScoped
public class SessionBean implements Serializable {

    public static Integer contador = 0;

    public SessionBean() {

        contador++;
    }

    public String getContador() {

        return contador.toString();
    }

    @PostConstruct
    private void init() {

        System.out.println("SessionBean foi criada: " + LocalDateTime.now());
    }

    @PreDestroy
    private void end() {

        System.out.println("SessionBean foi destruída: " + LocalDateTime.now());
    }
}
