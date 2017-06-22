package com.you.webapp.vo.request;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;


import io.swagger.annotations.ApiModelProperty;

public class Batparam implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("��Ʒ���ͣ�0��ǩ��Ʒ 1����Э���Ʒ")
	private int productType;

	@ApiModelProperty("SRM��Ӧ�̱��")
	@NotBlank(message="SRM��Ӧ�̱�Ų���Ϊ��!")
	private String supplierCode;
	

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}



	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	

	
	
	
}