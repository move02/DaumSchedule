package org.move02.domain;

import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="task_table", indexes = {
        @Index(name = "id_unique", columnList = "id", unique = true),
        @Index(name = "title_index", columnList = "title"),
        @Index(name = "time_index", columnList = "createdAt, updatedAt")
})
@Getter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Task {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="title", nullable = false)
    @Setter
    private String title;

    @Lob
    @Column(name = "description")
    @Setter
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Task(String title, String description){
        this.title = title;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name="project_id")
    @Setter
    private Project project;

    @ManyToMany(mappedBy = "tasks")
    @Setter
    private List<Member> members;

}
