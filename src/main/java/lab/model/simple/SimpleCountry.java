package lab.model.simple;

import lab.model.Country;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "country")
@Entity
public class SimpleCountry implements Country {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column(name = "code_name")
    private String codeName;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

}
