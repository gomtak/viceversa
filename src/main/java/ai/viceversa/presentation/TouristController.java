package ai.viceversa.presentation;

import ai.viceversa.application.ports.TouristServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tourist")
public class TouristController {

    private final TouristServicePort searchService;
    @GetMapping("/search")
    public ResponseEntity find(@RequestParam String keyword, Pageable pageable) {
        return ResponseEntity.ok(searchService.find(keyword, pageable));
    }
}


