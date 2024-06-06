package com.example.demo.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Locale;

@Data
@ConfigurationProperties(prefix = "app")
public class YamlProps {

    private Locale locale;
    private String [] headers;
    private String csvPath;
}
