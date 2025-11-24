package npk.socialMedia.app.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long  user_id;

    @Column(nullable=false,length = 100)
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Column(nullable=false,length = 100,unique = true)
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Column(nullable=false,length = 100)
    @NotBlank(message = "Password cannot be blank")
    private String password;

    @Column(nullable=false,length = 100)
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(nullable=true,length = 500)
    private String bio;

    @Column(name = "profile_picture_url")
    private String profilePicture;

    // Relationship mapping
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts; // Set of posts created by this user

}
