package service;

import org.springframework.stereotype.Service;

import dto.request.CreateRestaurantRequest;
import dto.request.UpdateRestaurantRequest;
import dto.response.RestaurantResponse;
import entity.Account;
import repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final AccountRepository accountRepository;

    public RestaurantService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createRestaurant(CreateRestaurantRequest request) {

        if (accountRepository.existsByAccountId(request.getAccountId())) {
            throw new RuntimeException("Account ID already exists");
        }

        Account account = new Account();
        account.setAccountId(request.getAccountId().toLowerCase());
        account.setAccountName(request.getAccountName());
        account.setNumberOfTables(request.getNumberOfTables());
        account.setLogoUrl(request.getLogoUrl());
        account.setIntroVideoUrl(request.getIntroVideoUrl()); // ✅ ADD
        account.setThemeSettings(request.getThemeSettings()); // ✅ ADD
        account.setTagline(request.getTagline());
        account.setDescription(request.getDescription());
        account.setActive(true);

        accountRepository.save(account);
    }

    public void updateRestaurant(Long id, UpdateRestaurantRequest request) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        account.setAccountName(request.getAccountName());
        account.setNumberOfTables(request.getNumberOfTables());
        account.setLogoUrl(request.getLogoUrl());
        account.setIntroVideoUrl(request.getIntroVideoUrl()); // ✅ ADD
        account.setThemeSettings(request.getThemeSettings()); // ✅ ADD
        account.setTagline(request.getTagline());
        account.setDescription(request.getDescription());

        accountRepository.save(account);
    }

    public void activateRestaurant(Long id, boolean active) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        account.setActive(active);
        accountRepository.save(account);
    }

    public List<RestaurantResponse> listRestaurants() {

        return accountRepository.findAll()
                .stream()
                .map(a -> new RestaurantResponse(
                        a.getId(),
                        a.getAccountId(),
                        a.getAccountName(),
                        a.getActive(),
                        a.getThemeSettings(),
                        a.getNumberOfTables(),
                        a.getLogoUrl(),
                        a.getIntroVideoUrl(),
                        a.getTagline(),
                        a.getDescription()))
                .collect(Collectors.toList());
    }
}
