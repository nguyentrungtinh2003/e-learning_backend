package com.TrungTinhBackend.E_Learning_Backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Lesson name is required")
    private String lessonName;

    @NotBlank(message = "Description is required")
    private String description;

    @Pattern(regexp = "^(http|https)://.*$", message = "Image URL must be a valid URL")
    private String img;

    @Pattern(regexp = "^(http|https)://.*$", message = "Video URL must be a valid URL")
    private String video;

    private LocalDateTime date;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
