package org.brightworks.friflow.ticketing.service.reference;

import org.brightworks.friflow.ticketing.domain.user.CompanyName;
import org.brightworks.friflow.ticketing.domain.dto.CompanyNameDTO;
import org.brightworks.friflow.ticketing.mapper.OrikaBeanMapper;
import org.brightworks.friflow.ticketing.repo.CompanyNameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kyel
 */
@Service
@Transactional(readOnly = true)
public class RefereServiceImpl implements ReferenceService{

    @Autowired
    private CompanyNameRepo companyNameRepo;

    @Autowired
    private OrikaBeanMapper mapper;

    @Override
    public List<CompanyNameDTO> searchCompanyName(String term) {
        List<CompanyNameDTO> dtos = new ArrayList<>();
        List<CompanyName> companyNames = companyNameRepo.findByNameContainingIgnoreCase(term);
        for(CompanyName name : companyNames){
            dtos.add(mapper.map(name, CompanyNameDTO.class));
        }

        return dtos;
    }
}
