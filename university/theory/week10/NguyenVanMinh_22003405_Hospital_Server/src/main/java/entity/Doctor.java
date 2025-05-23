package entity;

import lombok.*;

import java.io.Serializable;

@ToString(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends Person implements Serializable {
    private String speciality;

    @ToString.Exclude
    private transient Department department;

    public Doctor(String id, String name, String phone, String speciality) {
        super(id, name, phone);
        this.speciality = speciality;
    }
}
