package com.fastrelay.comments.domain.comment;

import com.fastrelay.comments.commons.UuidBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_comment")
public class Comment extends UuidBaseEntity {
    @Column(name = "c_title")
    private String title;
    @Column(name = "c_content")
    private String content;
}
