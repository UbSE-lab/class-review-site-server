package org.classreviewsite.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(nullable = false, length = 8, unique = true)
    private int userNumber;

    @Column(nullable = false, length = 45, unique = false)
    private String password;

    @Column(nullable = false, length = 45, unique = false)
    private String userName;

    @Column(nullable = false, length = 45, unique = false)
    private String department;

    @Column(nullable = false, length = 200, unique = true)
    private String nickname;
}
