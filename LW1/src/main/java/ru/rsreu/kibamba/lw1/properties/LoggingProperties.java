package ru.rsreu.kibamba.lw1.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.logging")
@Data
public class LoggingProperties {
    private boolean enabled = true;
}