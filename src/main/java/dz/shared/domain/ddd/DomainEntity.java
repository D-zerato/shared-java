package dz.shared.domain.ddd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dz.shared.util.json.JsonSerializable;
import lombok.Setter;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class DomainEntity implements JsonSerializable {
    //
    private static final long serialVersionUID = 805201038388117274L;
    private String id;
    @JsonIgnore
    private long entityVersion;

    protected DomainEntity() {
        //
        this.id = UUID.randomUUID().toString();
    }

    protected DomainEntity(String id) {
        //
        this.id = id;
    }

    protected DomainEntity(DomainEntity domainEntity) {
        //
        this.id = domainEntity.getId();
        this.entityVersion = domainEntity.getEntityVersion();
    }

    public boolean equals(Object target) {
        //
        if (this == target) {
            return true;
        }

        if (target == null || getClass() != target.getClass()) {
            return false;
        }

        DomainEntity entity = (DomainEntity) target;

        return Objects.equals(id, entity.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        //
        return toJson();
    }
}
