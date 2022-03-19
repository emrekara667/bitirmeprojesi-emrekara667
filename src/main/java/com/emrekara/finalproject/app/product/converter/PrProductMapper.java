package com.emrekara.finalproject.app.product.converter;

import com.emrekara.finalproject.app.product.dto.PrProductDto;
import com.emrekara.finalproject.app.product.dto.PrProductSaveRequestDto;
import com.emrekara.finalproject.app.product.dto.PrProductUpdateRequestDto;
import com.emrekara.finalproject.app.product.entity.PrProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrProductMapper {

    PrProductMapper INSTANCE = Mappers.getMapper(PrProductMapper.class);

    PrProductDto convertToPrProductDto(PrProduct prProduct);

    PrProductSaveRequestDto convertToPrProductSaveRequestDto(PrProductUpdateRequestDto prProductUpdateRequestDto);
}