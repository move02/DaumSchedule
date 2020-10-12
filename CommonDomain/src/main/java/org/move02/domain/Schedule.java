package org.move02.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="schedule_table", indexes = {
        @Index(name = "id_unique", columnList = "id", unique = true),
        @Index(name = "title_index", columnList = "title"),
        @Index(name = "time_index", columnList = "createdAt, updatedAt")
})
@Getter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Schedule extends CommonDomainModel {
    // 이걸 어떻게 한다...

}
