package com.verizon.profile.model;

import java.util.List;

public class Profile {

	private CustomerDetails customerDetails;

	private List<EquipmentDetails> equipmentDetailsList;

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public List<EquipmentDetails> getEquipmentDetailsList() {
		return equipmentDetailsList;
	}

	public void setEquipmentDetailsList(List<EquipmentDetails> equipmentDetailsList) {
		this.equipmentDetailsList = equipmentDetailsList;
	}

}
