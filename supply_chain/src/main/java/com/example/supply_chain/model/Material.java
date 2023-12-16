package com.example.supply_chain.model;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material{
    @DocumentReference(collection = "raw_material")
    private RawMaterial mid;
    private int composition;
}
