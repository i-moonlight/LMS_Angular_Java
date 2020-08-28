package com.ula.faculty.service.faculty;

import com.ula.faculty.domain.model.Faculty;
import com.ula.faculty.domain.repository.FacultyRepository;
import com.ula.faculty.domain.repository.StudyProgramRepository;
import com.ula.faculty.dto.model.AddressDTO;
import com.ula.faculty.dto.model.FacultyDTO;
import com.ula.faculty.dto.model.LocationDTO;
import com.ula.faculty.feign.UniversityFeignClient;
import com.ula.faculty.mapper.AddressMapper;
import com.ula.faculty.mapper.FacultyMapper;
import com.ula.faculty.mapper.LocationMapper;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService
{

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudyProgramRepository studyProgramRepository;


    @Autowired
    private UniversityFeignClient universityFeignClient;

    @Override
    public List<FacultyDTO> index()
    {
        List<Faculty> faculties = facultyRepository.findAll();

        return FacultyMapper.map(faculties);
    }


    @Override
    public FacultyDTO show(Long id) throws FacultyNotFoundException
    {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException(String.format("Faculty with provided id: %s not found", id)));

        // Maps payload to AddressDTO object
        AddressDTO addressDTO = AddressMapper.map(universityFeignClient.getAddress(faculty.getInformation().getAddressId()).getPayload());

        LocationDTO locationDTO = LocationMapper.map(universityFeignClient.getLocation(faculty.getInformation().getLocationId()).getPayload());

        return FacultyMapper.map(faculty, addressDTO, locationDTO);
    }
}
