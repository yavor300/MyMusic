package app.mymusic.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
}
