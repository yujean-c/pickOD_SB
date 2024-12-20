package com.smbt.pickod.controller.main;


import com.smbt.pickod.dto.festival.Criteria;
import com.smbt.pickod.dto.festival.FestivalDTO;
import com.smbt.pickod.dto.festival.Page;
import com.smbt.pickod.service.festival.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    private final FestivalService festivalService;



    @GetMapping("/main")
    public String mainPage(Criteria criteria,Model model) {
        Page festivalsPage = festivalService.getFestivals(criteria, "");

        List<FestivalDTO> festivals = festivalsPage.getFestivals();

        // 6개의 축제만 가져오기
        List<FestivalDTO> limitedFestivals = festivals.stream()
                .limit(6)  // 6개의 축제만 가져옴
                .collect(Collectors.toList());

        model.addAttribute("festivalList", limitedFestivals);

        return "main/main";
    }
}
