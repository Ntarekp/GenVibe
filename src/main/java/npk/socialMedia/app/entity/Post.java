package npk.socialMedia.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name ="user_post")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false,length = 500)
    private String content;

    @Column(nullable = false,length = 100)
    private String mediaType;

    @Column(nullable = false,length = 100)
    private String mediaURL;
    private LocalDateTime createdAt;

}
