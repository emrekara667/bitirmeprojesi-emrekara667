package com.emrekara.finalproject.app.user.service;

import com.emrekara.finalproject.app.gen.exceptions.GenBusinessException;
import com.emrekara.finalproject.app.user.converter.UsUserMapper;
import com.emrekara.finalproject.app.user.dto.UsUserDto;
import com.emrekara.finalproject.app.user.dto.UsUserSaveRequestDto;
import com.emrekara.finalproject.app.user.entity.UsUser;
import com.emrekara.finalproject.app.user.enums.UsrErrorMessage;
import com.emrekara.finalproject.app.user.service.entityservice.UsUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsUserService {

    private final UsUserEntityService usUserEntityService;

    public UsUserDto save(UsUserSaveRequestDto usUserSaveRequestDto) {

        UsUser usUser = UsUserMapper.INSTANCE.convertToUsUser(usUserSaveRequestDto);

        boolean isExistByUserName = usUserEntityService.existsUsUserByUserName(usUser.getUserName());

        if(!isExistByUserName){
            usUser = usUserEntityService.save(usUser);
        }else{
           throw new GenBusinessException(UsrErrorMessage.USERNAME_ALREADY_EXIST_ERROR);
        }
        UsUserDto usUserDto = UsUserMapper.INSTANCE.convertToUsUserDto(usUser);

        return usUserDto;
    }
}
