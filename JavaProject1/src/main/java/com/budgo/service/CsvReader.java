package com.budgo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@PropertySource("classpath:CsvConfig.properties")
@Service
public class CsvReader {

    private final String[] HEADERS = {"id", "question", "rightAnswer", "answer1", "answer2", "answer3"};

    private Iterable<CSVRecord> records;

    public CsvReader(@Value("classpath:questData.csv") Resource resource) {
        csvReader(resource);
    }

    private void csvReader(Resource resource) {
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();
        try {
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            records = csvFormat.parse(reader);
        } catch (Exception e) {
            records = null;
            System.out.println(e);
        }
    }

    public Iterable<CSVRecord> getRecords() {
        return records;
    }
}
