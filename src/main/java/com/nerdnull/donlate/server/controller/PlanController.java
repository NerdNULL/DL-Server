package com.nerdnull.donlate.server.controller;

import com.nerdnull.donlate.server.domain.PlanEntity;
import com.nerdnull.donlate.server.dto.PlanDto;
import com.nerdnull.donlate.server.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/plan")
@RestController// + @ResponseBody http통신규격 + 알아서 json으로 변환해서 리턴시켜줌
public class PlanController {

    private PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/details")
    public PlanDto getDetails(@RequestParam Long planId) { //json을 변환해서 dto에 맞춰 요청받음
        PlanDto plan = planService.getDetails(planId);
        return plan;
    }
}
