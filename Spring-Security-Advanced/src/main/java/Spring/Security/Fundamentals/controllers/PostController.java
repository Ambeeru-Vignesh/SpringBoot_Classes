package Spring.Security.Fundamentals.controllers;

import Spring.Security.Fundamentals.dto.PostDto;
import Spring.Security.Fundamentals.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    @Secured("@postSecurity.isOwnerOfPost(#postId)")
    public PostDto getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto inputPost) {
        return postService.createNewPost(inputPost);
    }
}
