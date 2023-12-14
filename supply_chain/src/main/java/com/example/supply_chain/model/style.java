package com.example.supply_chain.model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection="style")
@Data
public class style{
	
	    @Id
        private String _id;
	    public Availability availability;

		@DocumentReference(lazy = true)
		private Facilities facility_uid;
	    
	    @Field("material_composition")
	    private ArrayList<Material> materialComposition;
	    
	    @Field("required_certificate")
	    private String requiredCertificate;
	    
	    private String season;
	    
	    @Field("style_name")
	    private String styleName;
	    
	    @Field("style_number")
	    private String styleNumber;

	    @Field("style_uid")
	    private String styleUid;
	    
		@DocumentReference(lazy = true)
	    private Suppliers supplier_uid;
	    
	    private String type;
	    private String year;
	    
	    
	    public class Availability{
	    	
	    	@Getter
	    	@Setter
	    	private String amount;
	    }   
	    
	    @Data
	    public class Material{
			@DocumentReference(lazy = true)
	    	@Field("m_id")
	    	private String mid;
	    	private int composition;
	    }
}
