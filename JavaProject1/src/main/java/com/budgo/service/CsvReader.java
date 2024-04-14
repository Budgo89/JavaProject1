package com.budgo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;


public class CsvReader {

    private final String[] HEADERS = {"id", "question", "rightAnswer", "answer1", "answer2", "answer3"};

    private Iterable<CSVRecord> records;


    public CsvReader(String path) {
        csvReader(path);
    }

    private void csvReader(String path) {
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .build();
        try {
            Reader in = new FileReader(path);
            records = csvFormat.parse(in);
        } catch (Exception e) {
            records = null;
            System.out.println(e);
        }
    }

    public Iterable<CSVRecord> getRecords() {
        return records;
    }
}
