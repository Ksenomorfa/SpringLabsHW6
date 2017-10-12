package lab.model.simple;

import lab.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleCountry implements Country {
    private int id;
    private String name;
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
    public void setCodeName(String name) {
        this.codeName = codeName;
    }
}
