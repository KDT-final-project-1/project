package com.pixcel.app.milestone.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixcel.app.milestone.service.MilestoneVO;

/**
 * 마일스톤 엔티티를 관리하는 JPA 레포지토리 인터페이스입니다.
 * JpaRepository<엔티티타입, PK타입>을 상속받습니다.
 * Milestone: 우리가 만든 엔티티
 * String: PK인 milestoneId의 데이터 타입
 */
@Repository
public interface MilestoneRepository extends JpaRepository<MilestoneVO, String> {

	// 기본적으로 save(), findById(), findAll(), deleteById(), existsById() 등의
    // 강력한 CRUD 기능이 자동으로 제공됩니다.
    
    // 필요에 따라 아래와 같이 복잡한 쿼리나 조건 검색을 추가할 수 있습니다.{값을 작성}
    // 예: 마일스톤 ID 중 가장 큰 값을 가져와야 할 때 (채번 로직 구현 시)
    // @Query("SELECT MAX(m.milestoneId) FROM Milestone m")
    // String findMaxId();
}
