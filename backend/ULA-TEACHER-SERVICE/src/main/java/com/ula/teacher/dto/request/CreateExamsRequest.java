package com.ula.teacher.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ula.teacher.dto.ExamDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateExamsRequest
{
    // Validation is done in Exam Service
    private List<Long> subjectAttendanceIds;
    private ExamDTO examDTO;

}
