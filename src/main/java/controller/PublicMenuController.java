package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.response.PublicMenuResponse;
import service.PublicMenuService;

@RestController
@RequestMapping("/menu")
public class PublicMenuController {

    private final PublicMenuService publicMenuService;

    public PublicMenuController(PublicMenuService publicMenuService) {
        this.publicMenuService = publicMenuService;
    }

    @GetMapping
    public ResponseEntity<PublicMenuResponse> getMenu(
            @RequestParam String accountId) {

        return ResponseEntity.ok(
                publicMenuService.getMenu(accountId));
    }
}