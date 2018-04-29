package tk.bghgu.security.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ds on 2018-04-29.
 */

@Data
@Entity
public class USER implements Serializable {

    private static final long serialVersionUID = -5199866395624764940L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String pw;
    private String name;
    private Integer type;
}
