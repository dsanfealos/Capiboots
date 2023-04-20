package com.example.CapiBoots.modelos.metodos;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;


//Para convertir el Date en Datetime con formato yyyy-MM-dd HH:mm:ss
@Converter(autoApply = true)
public class TimeConverter implements AttributeConverter<LocalDateTime, String> {

    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").toFormatter();

    @Override
    public String convertToDatabaseColumn(LocalDateTime locDate) {
        return (locDate == null ? null : locDate.format(formatter));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String sqlDate) {
        return (sqlDate == null ? null : LocalDateTime.parse(sqlDate, formatter));
    }
}
