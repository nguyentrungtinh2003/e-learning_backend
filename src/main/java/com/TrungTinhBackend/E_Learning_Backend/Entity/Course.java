package com.TrungTinhBackend.E_Learning_Backend.Entity;

import com.TrungTinhBackend.E_Learning_Backend.Enum.CourseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course name is required")
    private String courseName;

    @NotBlank(message = "Description is required")
    private String description;

    @Pattern(regexp = "^(http|https)://.*$", message = "Image URL must be a valid URL")
    private String img;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean isDeleted;

    @ManyToMany(mappedBy = "courses")
    private List<User> users;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;
}
