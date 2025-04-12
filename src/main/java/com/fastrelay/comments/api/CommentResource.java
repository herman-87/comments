package com.fastrelay.comments.api;


import com.fastrelay.comment.api.CommentApi;
import com.fastrelay.comment.dto.CommentDTO;
import com.fastrelay.comment.dto.CommentIdDTO;
import com.fastrelay.comment.dto.CreateCommentDTO;
import com.fastrelay.comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CommentResource implements CommentApi {

    private final CommentService commentService;

    @Override
    public ResponseEntity<CommentIdDTO> createComment(CreateCommentDTO createCommentDTO) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.addComment(createCommentDTO));
    }

    @Override
    public ResponseEntity<List<CommentDTO>> getAllComment() {
        return null;
    }

    @Override
    public ResponseEntity<CommentDTO> getCommentById(UUID commentId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> postComment(UUID commentId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removeComment(UUID commentId) {
        return null;
    }
}
