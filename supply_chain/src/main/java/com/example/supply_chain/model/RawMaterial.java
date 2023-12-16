package com.example.supply_chain.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="raw_material")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterial {

	@Id
	private String _id;

	private String rmSupplierName;
	
	private Availability availability;
	
	//will create overhead in data returned since it is alread present in supplier
	@DocumentReference(collection = "facilities")
    private ArrayList<Facilities> facilitiesUid;
	
    private ArrayList<String> materialComposition;
	
	private String materialNumber;
	
	private String materialUid;
	
	private String name;
	private String number;
	
	private ArrayList<String> requiredCertificate;
	
	@DocumentReference(collection = "suppliers")
    private ArrayList<Suppliers> supplierUid;
	// @Field("supplier_material_name")
	// private String supplierMaterialName;
	
	private String type;
	private String year;
}
