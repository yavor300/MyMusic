package app.mymusic.web.controllers;

import app.mymusic.domain.models.view.AlbumAllViewModel;
import app.mymusic.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String home(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        } else {
            model.addAttribute("totalSumOfCopies", albumService.getTotalCopiesSum());
            model.addAttribute("albums", albumService.getAllOrdered().stream().map(a -> modelMapper.map(a, AlbumAllViewModel.class)).collect(Collectors.toList()));
            return "home";
        }
    }
}
