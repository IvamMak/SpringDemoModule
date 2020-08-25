package ru.makarovie.jarSoftDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.makarovie.jarSoftDemo.exception.NoContentException;
import ru.makarovie.jarSoftDemo.model.Banner;
import ru.makarovie.jarSoftDemo.repository.BannerRepository;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerRepository bannerRepository;

    @GetMapping
    public List<Banner> getAllBanners() {
        return bannerRepository.findAll().stream()
                .filter(banner -> !banner.isDeleted())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banner> getBannerById(@PathVariable("id") long id) {
        Banner banner = getBanner(id);
        return ResponseEntity.ok(banner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banner> updateBanner(@PathVariable("id") long id,
                                               @RequestBody Banner bannerData) {
        Banner banner = getBanner(id);
        banner.setName(bannerData.getName());
        banner.setPrice(bannerData.getPrice());
        banner.setContent(bannerData.getContent());
        banner.setDeleted(bannerData.isDeleted());

        Banner updateBanner = bannerRepository.save(banner);
        return ResponseEntity.ok(updateBanner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Banner> deleteBanner(@PathVariable("id") Long id){
        Banner banner = getBanner(id);

        banner.setDeleted(true);
        bannerRepository.save(banner);
        return ResponseEntity.ok(banner);
    }

    @PostMapping
    public Banner createBanner(@RequestBody Banner banner) {
        return bannerRepository.save(banner);
    }

    private Banner getBanner(long id) {
        Banner banner = null;
        try {
            banner = bannerRepository.findById(id).orElseThrow(() ->
                    new NoContentException("Banner with id: " + id + " not exist"));
        } catch (NoContentException e) {
            e.printStackTrace();
        }
        return banner;
    }

}
