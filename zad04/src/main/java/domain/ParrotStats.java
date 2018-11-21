package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParrotStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nickName;
    private int timesSold;
    private String color;
}
