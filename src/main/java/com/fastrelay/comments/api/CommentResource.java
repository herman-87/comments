package com.fastrelay.comments.api;


import com.fastrelay.comment.api.CommentApi;
import com.fastrelay.comment.dto.AddCommentDTO;
import com.fastrelay.comment.dto.CommentDTO;
import com.fastrelay.comment.dto.CommentIdDTO;
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
    public ResponseEntity<CommentIdDTO> addComment(AddCommentDTO addCommentDTO) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.addComment(addCommentDTO));
    }

    @Override
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.getAllComments());
    }

    @Override
    public ResponseEntity<CommentDTO> getCommentById(UUID commentId) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.getById(commentId));
    }

    @Override
    public ResponseEntity<Void> postComment(UUID commentId) {
        commentService.postComment(commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Void> removeComment(UUID commentId) {
        commentService.removeComment(commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
