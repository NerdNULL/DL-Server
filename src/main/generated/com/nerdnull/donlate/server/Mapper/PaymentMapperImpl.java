package com.nerdnull.donlate.server.mapper;

import com.nerdnull.donlate.server.domain.PaymentEntity;
import com.nerdnull.donlate.server.domain.PlanEntity;
import com.nerdnull.donlate.server.domain.PlanStateEntity;
import com.nerdnull.donlate.server.domain.UserEntity;
import com.nerdnull.donlate.server.dto.PaymentDto;
import com.nerdnull.donlate.server.dto.PlanDto;
import com.nerdnull.donlate.server.dto.PlanStateDto;
import com.nerdnull.donlate.server.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-10T11:06:20+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDto toDto(PaymentEntity e) {
        if ( e == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setPaymentId( e.getPaymentId() );
        paymentDto.setAmount( e.getAmount() );
        paymentDto.setDate( e.getDate() );
        paymentDto.setPlanState( planStateEntityToPlanStateDto( e.getPlanState() ) );

        return paymentDto;
    }

    @Override
    public PaymentEntity toEntity(PaymentDto d) {
        if ( d == null ) {
            return null;
        }

        PaymentEntity paymentEntity = new PaymentEntity();

        return paymentEntity;
    }

    protected List<PlanStateDto> planStateEntityListToPlanStateDtoList(List<PlanStateEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PlanStateDto> list1 = new ArrayList<PlanStateDto>( list.size() );
        for ( PlanStateEntity planStateEntity : list ) {
            list1.add( planStateEntityToPlanStateDto( planStateEntity ) );
        }

        return list1;
    }

    protected UserDto userEntityToUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId( userEntity.getUserId() );
        userDto.setPlanStateList( planStateEntityListToPlanStateDtoList( userEntity.getPlanStateList() ) );

        return userDto;
    }

    protected PlanDto planEntityToPlanDto(PlanEntity planEntity) {
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
        planDto.setPlanStateList( planStateEntityListToPlanStateDtoList( planEntity.getPlanStateList() ) );

        return planDto;
    }

    protected List<PaymentDto> paymentEntityListToPaymentDtoList(List<PaymentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PaymentDto> list1 = new ArrayList<PaymentDto>( list.size() );
        for ( PaymentEntity paymentEntity : list ) {
            list1.add( toDto( paymentEntity ) );
        }

        return list1;
    }

    protected PlanStateDto planStateEntityToPlanStateDto(PlanStateEntity planStateEntity) {
        if ( planStateEntity == null ) {
            return null;
        }

        PlanStateDto planStateDto = new PlanStateDto();

        planStateDto.setPlanStateId( planStateEntity.getPlanStateId() );
        planStateDto.setUser( userEntityToUserDto( planStateEntity.getUser() ) );
        planStateDto.setPlan( planEntityToPlanDto( planStateEntity.getPlan() ) );
        planStateDto.setLateState( planStateEntity.getLateState() );
        planStateDto.setPaymentList( paymentEntityListToPaymentDtoList( planStateEntity.getPaymentList() ) );

        return planStateDto;
    }
}
