package org.move02.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="project_table", indexes = {
        @Index(name = "id_unique", columnList = "id", unique = true),
        @Index(name = "title_index", columnList = "title"),
        @Index(name = "time_index", columnList = "startAt, endAt")
})
@Getter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Project extends CommonDomainModel{
    @Column(name = "title", nullable = false)
    @Setter
    private String title;

    @Lob
    @Column(name = "description")
    @Setter
    private String description;

    @Column(name = "startAt")
    @Setter
    private LocalDate startAt;

    @Column(name = "endAt")
    @Setter
    private LocalDate endAt;

    @Column(name = "project_sequence", nullable = false)
    @Setter
    private int projectSequence = 0;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id", referencedColumnName = "parent_project_id")
    private Project parentProject;

    @OneToMany(mappedBy = "project")
    @Setter
    private List<Task> tasks;

    @ManyToMany(mappedBy = "projects")
    @Setter
    private List<Member> members;

    @Builder
    public Project(String title, String description){
        this.title = title;
        this.description = description;
    }
}
