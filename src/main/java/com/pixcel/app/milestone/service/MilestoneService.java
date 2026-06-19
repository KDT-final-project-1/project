package com.pixcel.app.milestone.service;

public interface MilestoneService {
 String createMilestone(MilestoneCreateRequestDTO requestDTO);
 MilestoneDetailResponseDTO getMilestoneDetailResponseDTO(String milestoneId);
}
