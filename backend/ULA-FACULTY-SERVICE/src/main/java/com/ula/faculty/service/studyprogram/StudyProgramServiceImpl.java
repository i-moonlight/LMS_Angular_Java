package com.ula.faculty.service.studyprogram;

import com.ula.faculty.domain.model.Faculty;
import com.ula.faculty.domain.model.StudyProgram;
import com.ula.faculty.domain.repository.FacultyRepository;
import com.ula.faculty.domain.repository.StudyProgramRepository;
import com.ula.faculty.dto.model.StudyProgramDTO;
import com.ula.faculty.dto.model.StudyProgramWithNumberOfPagesDTO;
import com.ula.faculty.dto.model.StudyProgramWithYearsOfStudyDTO;
import com.ula.faculty.mapper.StudyProgramMapper;
import com.ula.faculty.mapper.StudyProgramWithSubjectsMapper;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import com.ula.faculty.service.exception.StudyProgramNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramServiceImpl implements StudyProgramService
{

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudyProgramRepository studyProgramRepository;


    @Override
    public StudyProgramWithNumberOfPagesDTO index(Long facultyId, Pageable pageable) throws FacultyNotFoundException
    {
        Faculty faculty = facultyRepository.findById(facultyId).orElseThrow(
                () -> new FacultyNotFoundException(
                String.format("Faculty with id:%s does not exist", facultyId)));

        Page<StudyProgram> studyPrograms = studyProgramRepository.findAllByFacultyId(faculty.getId(), pageable);
        int totalPages = studyPrograms.getTotalPages();

        List<StudyProgramDTO> studyProgramDTOS = StudyProgramMapper.map(studyPrograms);

        return new StudyProgramWithNumberOfPagesDTO()
                    .setStudyPrograms(studyProgramDTOS)
                    .setTotalPages(totalPages-1);

    }

    @Override
    public StudyProgramDTO show(Long id) throws StudyProgramNotFoundException
    {
        return StudyProgramMapper.map(this.studyProgramRepository.findById(id)
                .orElseThrow(() -> new StudyProgramNotFoundException(String.format("Study program with id: %s not found", id))));
    }


    @Override
    public List<StudyProgramDTO> search(String searchTerm)
    {
        return StudyProgramMapper.map(studyProgramRepository.findStudyProgramByNameContains(searchTerm));
    }

    @Override
    public StudyProgramWithYearsOfStudyDTO subjects(Long id) throws StudyProgramNotFoundException
    {
        return StudyProgramWithSubjectsMapper.map(this.studyProgramRepository.findById(id)
                .orElseThrow(() -> new StudyProgramNotFoundException(String.format("Study program with id: %s not found", id))));
    }
}
