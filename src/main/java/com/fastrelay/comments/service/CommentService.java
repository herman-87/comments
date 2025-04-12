package com.fastrelay.comments.service;


import com.fastrelay.comment.dto.AddCommentDTO;
import com.fastrelay.comment.dto.CommentDTO;
import com.fastrelay.comment.dto.CommentIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    public CommentIdDTO addComment(AddCommentDTO addCommentDTO) {
        return null;
    }

    public List<CommentDTO> getAllComments() {
        return null;
    }

    public void postComment(UUID commentId) {

    }

    public void removeComment(UUID commentId) {

    }

    public CommentDTO getById(UUID feeId) {
        return null;
    }
}
