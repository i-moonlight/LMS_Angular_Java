package com.ula.faculty.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Faculty extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long universityId;

	private Long campusId;


	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String name;

	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String icon;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "faculty")
	private FacultyInformation information;

	@OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
	private Set<StudyProgram> studyPrograms;
}
