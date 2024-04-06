package gr.aueb.cf.schoolpro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class City extends AbstractEntity{

    private String city;

    @OneToMany(mappedBy = "city")
    @Getter(AccessLevel.PROTECTED)
    private Set<Student> students = new HashSet<>();

    public Set<Student> getAllStudent() {
        return Collections.unmodifiableSet(students);
    }

    public void setStudent(Student student) {
        students.add(student);
        student.setCity(this);
    }
}
