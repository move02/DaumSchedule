package org.move02.common.member;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class Member {
    @Id
    private String id;
    private String name;
}
