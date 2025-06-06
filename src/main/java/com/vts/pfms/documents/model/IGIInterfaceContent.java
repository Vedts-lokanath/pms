package com.vts.pfms.documents.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder //srikant
@Data
@NoArgsConstructor //srikant
@AllArgsConstructor //srikant
@Entity
@Table(name="pfms_igi_interface_content")
public class IGIInterfaceContent implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long InterfaceContentId;
	private Long InterfaceTypeId;
	private String InterfaceContent;
	private String InterfaceContentCode;
	private String IsDataCarrying; // srikant
	private String CreatedBy;
	private String CreatedDate;
	private String ModifiedBy;
	private String ModifiedDate;
	private int IsActive;

}
