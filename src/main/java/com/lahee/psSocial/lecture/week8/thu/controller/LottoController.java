package com.lahee.psSocial.lecture.week8.thu.controller;

import com.lahee.psSocial.lecture.week8.thu.service.LottoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/week8/wed")
//@RequiredArgsConstructor
public class LottoController {
    private final LottoService lottoService; //하나의 객체만 선언되도록
//    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @GetMapping("/hits")
    public String hits(Model model) {
        model.addAttribute("hitsCnt", lottoService.addHit());
        return "/week8/wed/hits";
    }

    @GetMapping("/lotto")
    public String lotto(Model model) {
        model.addAttribute("lotto", lottoService.getLotto());
        return "/week8/wed/lotto";
    }

    @GetMapping("/history")
    public String lottoHistory(Model model) {
        model.addAttribute("lottoHistory", lottoService.getLottoHistory());
        return "/week8/wed/history";
    }
}
