package com.example.supply_chain.model;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentPointer;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="style")
@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonIgnoreProperties(ignoreUnknown = true)
public class style{
	
	    @Id
        private String _id;
	    public Availability availability;

		//will create overhead in data returned since it is alread present in supplier

		// @WritingConverter
		// public class FacilitiesReferenceConverter implements Converter<Facilities, DocumentPointer<String>> {

		//     public DocumentPointer<String> convert(Facilities source) {
		//             return () -> source.get_id();
		//     }
		// }
		@DocumentReference(collection = "facilities",lazy = true)
		private Facilities facilityUid;
	    

	    private ArrayList<Material> materialComposition;
	    

	    private String requiredCertificate;
	    
	    private String season;
	    

	    private String styleName;
	    

	    private String styleNumber;


	    private String styleUid;
	    

		// @WritingConverter
		// public class SupplierReferenceConverter implements Converter<Suppliers, DocumentPointer<String>> {

		// 	public DocumentPointer<String> convert(Suppliers source) {
		// 			return () -> source.get_id();
		// 	}
		// }
		@DocumentReference(collection = "suppliers",lazy = true)
	    private Suppliers supplierUid;
	    
	    private String type;
	    private String year;
	    
	    
	    // public class Availability{
	    	
	    // 	@Getter
	    // 	@Setter
	    // 	private String amount;
	    // }   
	
}
