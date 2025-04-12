package com.fastrelay.comments.api;

import com.fastrelay.comment.dto.AddCommentDTO;
import com.fastrelay.comment.dto.CommentDTO;
import com.fastrelay.comment.dto.CommentIdDTO;
import com.fastrelay.comments.commons.BaseControllerTest;
import com.fastrelay.comments.service.CommentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class FeeControllerTest extends BaseControllerTest {

    @InjectMocks
    private CommentResource objectUnderTest;
    @Mock
    private CommentService commentService;

    @Test
    void createFeeTest() {
        AddCommentDTO addCommentDTO = new AddCommentDTO();
        CommentIdDTO expectedResult = new CommentIdDTO();

        when(commentService.addComment(addCommentDTO)).thenReturn(expectedResult);

        CommentIdDTO resultUnderTest = webTestClient.post()
            .uri("/comment")
            .bodyValue(addCommentDTO)
            .exchange()
            .expectStatus().isCreated()
            .expectBody(CommentIdDTO.class)
            .returnResult()
            .getResponseBody();

        assertThat(resultUnderTest).isEqualTo(expectedResult);
    }

    @Test
    void getAllFeeTest() {
        CommentDTO commentDTO1 = new CommentDTO();
        CommentDTO commentDTO2 = new CommentDTO();

        when(commentService.getAllComments()).thenReturn(List.of(commentDTO1, commentDTO2));

        List<CommentDTO> resultUnderTest = webTestClient.get()
            .uri(uriBuilder -> uriBuilder.path("/comment").build())
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(CommentDTO.class)
            .returnResult()
            .getResponseBody();

        assertThat(resultUnderTest).containsExactly(commentDTO1, commentDTO2);
    }

    @Test
    void postCommentTest() {
        UUID commentId = UUID.randomUUID();
        webTestClient.put()
            .uri(
                uriBuilder -> uriBuilder.path("/comment/{commentId}/post")
                    .build(Map.of("commentId", commentId))
            )
            .exchange()
            .expectStatus().isNoContent();

        verify(commentService).postComment(commentId);
    }

    @Test
    void removeCommentTest() {
        UUID commentId = UUID.randomUUID();
        webTestClient.put()
            .uri(
                uriBuilder -> uriBuilder.path("/comment/{commentId}/remove")
                    .build(Map.of("commentId", commentId))
            )
            .exchange()
            .expectStatus().isNoContent();

        verify(commentService).removeComment(commentId);
    }

    @Test
    void getCommentByIdTest() {
        CommentDTO expected = new CommentDTO();
        UUID feeId = UUID.randomUUID();

        when(commentService.getById(feeId)).thenReturn(expected);

        CommentDTO resultUnderTest = webTestClient.get()
            .uri(
                uriBuilder -> uriBuilder.path("/comment/{commentId}")
                    .build(Map.of("commentId", feeId))
            )
            .exchange()
            .expectStatus().isOk()
            .expectBody(CommentDTO.class)
            .returnResult()
            .getResponseBody();

        assertThat(resultUnderTest).isEqualTo(expected);
    }

    @Override
    public Object getControllerInstanceToTest() {
        return objectUnderTest;
    }
}