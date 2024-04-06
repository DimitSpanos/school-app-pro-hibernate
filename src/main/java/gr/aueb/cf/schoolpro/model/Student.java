package gr.aueb.cf.schoolpro.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Student extends AbstractEntity{

    @NonNull
    @Column
    private String firstname;

    @NonNull
    @Column
    private String lastname;

    @NonNull
    @Column
    private char gender;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "student")
    @Getter(AccessLevel.PROTECTED)
    private Set<Meeting> meetings = new HashSet<>();

    public Set<Meeting> getAllMeetings() {
        return Collections.unmodifiableSet(meetings);
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
        meeting.setStudent(this);
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
}
