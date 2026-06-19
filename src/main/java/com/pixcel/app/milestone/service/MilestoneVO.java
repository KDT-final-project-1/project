package com.pixcel.app.milestone.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 테이블 명, 컬럼 명, PK 지정, 연관관계 설정 등 구조 선언
 * */

@Entity                           						//이 클래스는 데이터베이스 테이블과 직접 매핑되는 객체
@Table(name = "MILESTONE")        						//엔티티 클래스 이름과 실제 DB 테이블 이름이 다를 경우
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) 	    //JPA 생성자 함수 + 안전장치(정의된 생성자만 사용해서 객체를 만듬)
@AllArgsConstructor                						//모든 필드를 인자로 받는 생성자
@Builder						   						//안전한 객체 생성 도구 Milestone.builder().title("제목").managerId(5L).startDate(date).build();
@EntityListeners(AuditingEntityListener.class)			//데이터 관리의 자동화
public class MilestoneVO {
	
	@Id													//기본키 선언							
	@Column(name = "MILESTONE_ID" , length =255)						//실제 데이터베이스 테이블의 컬럼명
	private String milestoneId;
	
	@Column(name = "VERSION_ID", nullable = false, length =255)
	private String versionId;
	
	@Column(name = "TITLE",nullable = false, length =255)
	private String title;
	
	@Column(name = "DESCRIPTION", nullable = false , length =255)
	private String description;
	
	@Column(name = "MANAGER_ID", nullable = false, length =255)
	private String managerId;
	
	@Column(name = "STATUS_CODE", nullable = false, length = 4)
	private String statusCode;
	
	@Column(name = "STATUS_NAME", nullable = false, length = 100)
	private String statusName;
	
	@Column(name = "START_DATE", nullable = false)
	private LocalDate startDate;
	
	@Column(name = "END_DATE", nullable = false)
	private LocalDate endDate;
	
	@CreatedDate
	@Column(name ="CREATE_AT", nullable = false, updatable = false)	//@CreatedDate를 사용시 자동 생성 *@EntityListeners 어노테이션 있어야함
	private LocalDateTime createdAt;					
	
	//상태 및 상태명 변경 메서드
	public void chageStatus(String statusCode, String statusName) {
		this.statusCode = statusCode;
		this.statusName = statusName;
	}
	
	//상세 내용 수정
	public void updateDescription(String description) {
	    this.description = description;
	}
	
	//제목 수정
	public void updateTitle(String title) {
		this.title = title;
	}
	
	//날짜 수정
	public void updateDate(LocalDate startDate, LocalDate endDate) {
		//시작일이 종료일 보다 늦으면 안됨
		if(startDate.isAfter(endDate)) {
			throw new IllegalArgumentException("시작일은 종료일 보다 이전이어야합니다"); //잘못된 데이터를 받았을시 알람
		}
		this.startDate = startDate;
		this.endDate =endDate;
	}
}
