package com.business.smartslot.service;

import com.business.smartslot.dto.BusinessDto;
import com.business.smartslot.exception.BusinessException;

public interface BusinessService {

    BusinessDto registerBusiness(BusinessDto businessDto) throws BusinessException;
}
