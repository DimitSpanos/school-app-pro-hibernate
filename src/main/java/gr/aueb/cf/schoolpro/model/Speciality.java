package gr.aueb.cf.schoolpro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "speciality")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Speciality extends AbstractEntity{

    @NotNull
    @Column
    private String speciality;

    @OneToMany(mappedBy = "speciality")
    @Getter(AccessLevel.PROTECTED)
    private Set<Teacher> teachers = new HashSet<>();

    public Set<Teacher> getAllTeachers() {
        return Collections.unmodifiableSet(teachers);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.setSpeciality(this);
    }
}
