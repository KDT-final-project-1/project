package com.pixcel.app.project.service;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectVO {
	private String projectId;			// PK
	private String ownerId;				// FK
	private String projectName;			// 프로젝트 명
	private String identifier;			// 식별자 명칭
	private String description;			// 설명
	private String projectUrl;			// 프로젝트 URL
	private String statusCode;			// 공통코드(상태)
	private Date startDate;				// 시작일
	private Date endDate;				// 완료일
	private Date createdAt;				// 등록일자
	private String gitUrl;				// github URL
	
	private List<String> moduleCodes;	// 화면에서 넘어오는 모듈 코드 배열
	private List<String> moduleNames;	// 화면에서 넘어오는 모듈 이름 배열
}
