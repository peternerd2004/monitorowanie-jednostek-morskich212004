package pl.koty.monitorowaniejednostekmorskich21;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.koty.monitorowaniejednostekmorskich21.model.TrackService;


@Controller
public class MapController {

    private final TrackService trackService;

    public MapController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public String getMap(Model model) {
        model.addAttribute("tracks", trackService.getTracks());
        return "map21";
    }



}
