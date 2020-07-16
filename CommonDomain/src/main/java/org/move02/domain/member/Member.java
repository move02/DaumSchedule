package org.move02.domain.member;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="member_table", indexes = {
    @Index(name = "synology_id_unique", columnList = "synology_id", unique = true)
})
@Getter
@EqualsAndHashCode(of = {"id", "synology_id"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 나중에 Tostring 지울것
@ToString
public class Member {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Member(String synologyId, String name){
        this.synologyId = synologyId;
        this.name = name;
    }
}
