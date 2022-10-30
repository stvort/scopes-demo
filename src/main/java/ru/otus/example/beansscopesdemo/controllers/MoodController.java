package ru.otus.example.beansscopesdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.example.beansscopesdemo.services.AppMoodService;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequiredArgsConstructor
@Controller
public class MoodController {

    private final AppMoodService appMoodService;

    @RequestMapping(value = "/mood", method = {GET, POST})
    public String moodIndicatorPage(Model model, String song) {
        model.addAttribute("songs", makeSongsList());
        model.addAttribute("moodLevel", appMoodService.getAppMoodLevel());
        if (nonNull(song)) {
            return "redirect:/mood";
        }
        appMoodService.decreaseAppMoodLevel();
        return "mood";
    }

    private List<String> makeSongsList() {
        var song = new ArrayList<String>();
        song.add("\"Клен\" (c) Синяя птица");
        song.add("\"Конь\" (c) Любэ");
        song.add("\"Белые розы\" (c) Ласковый май");
        song.add("\"Атас\" (c) Любэ");
        song.add("\"Всё! Теперь решено. Без возврата…\" (c) Монгол Шуудан");
        return song;
    }
}
