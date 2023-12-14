package com.example.supply_chain.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection="style")
@Data
public class style{
	
	    @Id
        private String _id;
	    public Availability availability;

		//will create overhead in data returned since it is alread present in supplier
		@DocumentReference(collection = "facilities")
		private Facilities facilityUid;
	    

	    private ArrayList<Material> materialComposition;
	    

	    private String requiredCertificate;
	    
	    private String season;
	    

	    private String styleName;
	    

	    private String styleNumber;


	    private String styleUid;
	    
		@DocumentReference(collection = "suppliers")
	    private Suppliers supplierUid;
	    
	    private String type;
	    private String year;
	    
	    
	    public class Availability{
	    	
	    	@Getter
	    	@Setter
	    	private String amount;
	    }   
	    
	    @Data
	    public class Material{
			@DocumentReference(collection = "raw_material")
	    	private RawMaterial mid;
	    	private int composition;
	    }
}
