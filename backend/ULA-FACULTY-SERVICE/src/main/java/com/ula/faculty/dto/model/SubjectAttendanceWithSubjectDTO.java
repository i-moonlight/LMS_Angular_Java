package com.ula.faculty.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectAttendanceWithSubjectDTO
{
    private Long id;
    private Long studentId;
    private SubjectWithRealizationIdDTO subject;
    private Integer finalGrade;
}
