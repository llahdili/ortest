package com.ortest.common.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static com.ortest.common.utils.Statu.*;

@Converter(autoApply = true)
public class CustomerLeadTypeConverter implements AttributeConverter<Statu, String> {
    @Override
    public String convertToDatabaseColumn(Statu attribute) {
        if (DONE.equals(attribute)) {
            return "DONE";
        } else if (CANCELED.equals(attribute)) {
            return "CANCELED";
        } else if (PROCESSING.equals(attribute)) {
            return "PROCESSING";
        }
        throw new IllegalArgumentException("Unknown" + attribute);
    }
    @Override
    public Statu convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "DONE":
                return DONE;
            case "CANCELED":
                return CANCELED;
            case "PROCESSING":
                return PROCESSING;
            default:
                throw new IllegalArgumentException("Unknown" + dbData);
    }
    }
}