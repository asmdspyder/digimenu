package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.request.CreateTagRequest;
import dto.request.UpdateTagRequest;
import dto.response.TagResponse;
import service.TagService;

import java.util.List;

@RestController
@RequestMapping("/admin/tags")
public class TagAdminController {

    private final TagService tagService;

    public TagAdminController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateTagRequest request) {
        tagService.createTag(request);
        return ResponseEntity.ok("Tag created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody UpdateTagRequest request) {
        tagService.updateTag(id, request);
        return ResponseEntity.ok("Tag updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.ok("Tag deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<TagResponse>> list() {
        return ResponseEntity.ok(tagService.listTags());
    }
}