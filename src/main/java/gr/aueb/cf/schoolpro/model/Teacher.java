package gr.aueb.cf.schoolpro.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="teachers")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Teacher extends AbstractEntity{

    @NonNull  //auto einai tou lombok
    @Column(length = 10, unique = true, nullable = false)
    private String ssn;

    @NonNull
    @Column
    private String firstname;

    @NonNull
    @Column
    private String lastname;

    @OneToMany(mappedBy = "teacher")  //enas teacher polla meetings
    @Getter(AccessLevel.PROTECTED)
    private Set<Meeting> meetings = new HashSet<>();

    public Set<Meeting> getAllMeetings() {
        return Collections.unmodifiableSet(meetings);
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
        meeting.setTeacher(this);
    }

    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    private Speciality speciality;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
