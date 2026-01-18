package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.request.CreateRestaurantRequest;
import dto.request.UpdateRestaurantRequest;
import dto.response.RestaurantResponse;
import service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/admin/restaurants")
public class RestaurantAdminController {

    private final RestaurantService restaurantService;

    public RestaurantAdminController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateRestaurantRequest request) {
        restaurantService.createRestaurant(request);
        return ResponseEntity.ok("Restaurant created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody UpdateRestaurantRequest request) {
        restaurantService.updateRestaurant(id, request);
        return ResponseEntity.ok("Restaurant updated successfully");
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<String> activate(
            @PathVariable Long id,
            @RequestParam boolean active) {
        restaurantService.activateRestaurant(id, active);
        return ResponseEntity.ok("Restaurant status updated");
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> list() {
        return ResponseEntity.ok(restaurantService.listRestaurants());
    }
}