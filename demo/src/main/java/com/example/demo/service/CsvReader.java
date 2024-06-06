package com.example.demo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvReader {

    public CsvReader(){}

    public List<CSVRecord> csvReader(Resource resource, String[] HEADERS) {
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();
        Iterable<CSVRecord> records;

        try (InputStream inputStream = resource.getInputStream();
            Reader reader = new InputStreamReader(inputStream)){
            records = csvFormat.parse(reader);

            var recordList = new ArrayList<CSVRecord>();
            for(CSVRecord record : records ){
                recordList.add(record);
            }
            return recordList;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
