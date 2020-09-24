package com.ula.teacher.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectSyllabusDTO
{
    private Long id;
    private Long subjectId;
    private String content;
}
