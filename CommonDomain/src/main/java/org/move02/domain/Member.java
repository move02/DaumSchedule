package org.move02.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="member_table", indexes = {
    @Index(name = "synology_id_unique", columnList = "synology_id", unique = true)
})
@Getter
@EqualsAndHashCode(of = {"id", "synologyId"}, callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 나중에 Tostring 지울것
@ToString
public class Member extends CommonDomainModel {
    @Column(name = "synology_id", length = 45, unique = true, nullable = false)
    private String synologyId;

    @Column(length = 45, nullable = false)
    private String name;

    // 직책? 개발자 디자이너 뭐 그런거..
    @Column(length = 4)
    @Setter
    private Integer position;

    // 부서
    @Column(length = 4)
    @Setter
    private Integer dept;

    // 직급
    @Column(length = 4)
    @Setter
    private Integer rank;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "member_project",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="member_id", referencedColumnName = "id"))
    private List<Project> projects;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "member_task",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="member_id", referencedColumnName = "id"))
    private List<Task> tasks;

    @Builder
    public Member(String synologyId, String name){
        this.synologyId = synologyId;
        this.name = name;
    }
}
