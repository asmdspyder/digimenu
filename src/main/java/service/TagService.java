package service;

import org.springframework.stereotype.Service;

import dto.request.CreateTagRequest;
import dto.request.UpdateTagRequest;
import dto.response.TagResponse;
import entity.Tag;
import repository.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void createTag(CreateTagRequest request) {

        if (tagRepository.existsByTagNameIgnoreCase(request.getTagName())) {
            throw new RuntimeException("Tag already exists");
        }

        Tag tag = new Tag();
        tag.setTagName(request.getTagName());
        tag.setTagColor(request.getTagColor());

        tagRepository.save(tag);
    }

    public void updateTag(Long id, UpdateTagRequest request) {

        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found"));

        tag.setTagName(request.getTagName());
        tag.setTagColor(request.getTagColor());

        tagRepository.save(tag);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    public List<TagResponse> listTags() {

        return tagRepository.findAll()
                .stream()
                .map(t -> new TagResponse(
                        t.getId(),
                        t.getTagName(),
                        t.getTagColor()
                ))
                .collect(Collectors.toList());
    }
}