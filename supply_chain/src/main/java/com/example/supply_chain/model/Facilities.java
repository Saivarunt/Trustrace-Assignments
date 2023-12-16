package com.example.supply_chain.model;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Publisher;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentPointer;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="facilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facilities {
	
    @Id
	private String _id;
    
    private List<String> certifications;
    
    private String createdBy;
    
    private String facilitiesUid;
    
    private String facilityName;
    
    private String location;
    
    private String material;
    
    // @WritingConverter
    // public class SupplierReferenceConverter implements Converter<Suppliers, DocumentPointer<String>> {

    //     public DocumentPointer<String> convert(Suppliers source) {
    //             return () -> source.get_id();
    //     }
    // }
    // @DocumentReference(collection = "suppliers")

    // @DocumentReference(collection ="suppliers")
    // @Field("supplier_uid")
    // private Suppliers supplierUid;
}