package com.nerdnull.donlate.server.mapper;

import com.nerdnull.donlate.server.domain.PlanEntity;
import com.nerdnull.donlate.server.dto.PlanDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-10T11:06:19+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class PlanMapperImpl implements PlanMapper {

    @Override
    public PlanDto toDto(PlanEntity planEntity) {
        if ( planEntity == null ) {
            return null;
        }

        PlanDto planDto = new PlanDto();

        planDto.setPlanId( planEntity.getPlanId() );
        planDto.setAdmin( planEntity.getAdmin() );
        planDto.setDeposit( planEntity.getDeposit() );
        planDto.setLatePercent( planEntity.getLatePercent() );
        planDto.setAbsentPercent( planEntity.getAbsentPercent() );
        planDto.setTitle( planEntity.getTitle() );
        planDto.setLocation( planEntity.getLocation() );
        planDto.setDetailLocation( planEntity.getDetailLocation() );
        planDto.setDate( planEntity.getDate() );
        planDto.setDone( planEntity.getDone() );

        return planDto;
    }

    @Override
    public PlanEntity toEntity(PlanDto planDto) {
        if ( planDto == null ) {
            return null;
        }

        PlanEntity planEntity = new PlanEntity();

        return planEntity;
    }
}
