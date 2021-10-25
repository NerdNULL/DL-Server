package com.nerdnull.donlate.server.controller;

import com.nerdnull.donlate.server.dto.PlanDto;
import com.nerdnull.donlate.server.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/plan")
@RestController// @Controller + @ResponseBody http 통신규격 + 알아서 json으로 변환해서 리턴시켜줌
public class PlanController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/details")
    public PlanDto getDetails(@RequestParam Long planId) {
        PlanDto plan = planService.getDetails(planId);
        logger.info("[INFO]Send plan details");
        return plan;
    }
}
