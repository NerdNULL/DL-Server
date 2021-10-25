package com.nerdnull.donlate.server.service;

import com.nerdnull.donlate.server.mapper.PlanMapper;
import com.nerdnull.donlate.server.mapper.PlanStateMapper;
import com.nerdnull.donlate.server.domain.PlanEntity;
import com.nerdnull.donlate.server.dto.PlanDto;
import com.nerdnull.donlate.server.repository.PlanRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanService {

    private final PlanRepository planRepository;
    private final PlanMapper planMapper = Mappers.getMapper(PlanMapper.class);
    private final PlanStateMapper planStateMapper = Mappers.getMapper(PlanStateMapper.class);
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanDto getDetails(Long planId) {
        Optional<PlanEntity> maybePlan=  planRepository.findById(planId);
        if(maybePlan.isEmpty()) {
            logger.error("[ERROR] PlanService/getDetails -> Not exists plan");
            throw new IllegalArgumentException("PlanService/getDetails -> Not exists plan");
        }
        PlanDto plan = planMapper.toDto(maybePlan.get());
        plan.setPlanStateList(planStateMapper.toDtoList(maybePlan.get().getPlanStateList()));
        return plan;
    }
}
