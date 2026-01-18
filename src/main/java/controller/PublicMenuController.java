package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.response.PublicCategoryResponse;
import service.PublicMenuService;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class PublicMenuController {

    private final PublicMenuService publicMenuService;

    public PublicMenuController(PublicMenuService publicMenuService) {
        this.publicMenuService = publicMenuService;
    }

    // QR-based menu API
    @GetMapping
    public ResponseEntity<List<PublicCategoryResponse>> getMenu(
            @RequestParam String accountId) {

        return ResponseEntity.ok(
                publicMenuService.getMenu(accountId)
        );
    }
}