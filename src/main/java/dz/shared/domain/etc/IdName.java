package dz.shared.domain.etc;

import dz.shared.domain.ddd.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdName implements ValueObject {
    //
    private String id;
    private String name;

    public String toString() {
        //
        return toJson();
    }

    @Override
    public boolean equals(Object target) {
        //
        if (this == target) {
            return true;
        }

        if (target == null || getClass() != target.getClass()) {
            return false;
        }

        IdName idName = (IdName)target;
        return Objects.equals(this.id, idName.id)
                && Objects.equals(this.name, idName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id+name);
    }
}
