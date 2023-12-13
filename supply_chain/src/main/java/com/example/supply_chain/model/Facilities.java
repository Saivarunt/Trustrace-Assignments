package com.example.supply_chain.model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection="facilities")
@Data
@AllArgsConstructor
public class Facilities {
	
    @Id
	private String _id;
    
    private ArrayList<String> certifications;
    
    @Field("created_by")
    private String createdBy;
    
    @Field("facilities_uid")
    private String facilitiesUid;
    
    @Field("facility_name")
    private String facilityName;
    
    private String location;
    
    private String material;
    
    @DocumentReference(lazy = true)
    @Field("supplier_uid")
    private ObjectId supplierUid;
    
}
