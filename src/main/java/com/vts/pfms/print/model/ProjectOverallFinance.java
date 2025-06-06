package com.vts.pfms.print.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="pfms_overall_finance")
public class ProjectOverallFinance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProjectFinanceId;
	private String LabCode;
	private Long ProjectId;
	private String ProjectCode;
	private String BudgetHead;
	private Double SanctionCostFE;
	private Double SanctionCostRE;
	private Double ExpenditureFE;
	private Double ExpenditureRE;
	private Double OutCommitmentFE;
	private Double OutCommitmentRE;
	private Double DiplFE;
	private Double DiplRE;
	private Double BalanceFE;
	private Double BalanceRE;
	private Double NotaionalBalFE;
	private Double NotaionalBalRE;
	private String CreatedBy;
	private String CreatedDate;
	private String ModifiedBy;
	private String ModifiedDate;
	private int IsActive;
}
