package com.ula.exam.service.exam;

import com.ula.exam.api.v1.request.UpdateExamRequest;
import com.ula.exam.dto.model.ExamDTO;
import com.ula.exam.service.exception.*;

import java.util.List;

public interface ExamService
{
    List<ExamDTO> index();

    ExamDTO show(Long id)
    throws ExamNotFoundException;

    String store(ExamDTO examDTO)
    throws TakingExamNotFoundException, ExamTypeNotFoundException;

    String update(Long id, UpdateExamRequest updateExamRequest)
    throws ExamNotFoundException, ExamDoesNotHaveActiveEntryException, ExamDoesNotHaveEntry;

    String delete(Long id)
    throws ExamNotFoundException;
}
