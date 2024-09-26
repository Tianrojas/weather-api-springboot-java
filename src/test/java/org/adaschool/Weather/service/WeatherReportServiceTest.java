package org.adaschool.Weather.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherReport;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class WeatherReportServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherReportService weatherReportService;

    @Test
    void testGetWeatherReport() {
        WeatherApiResponse.Main mockMain = new WeatherApiResponse.Main();
        mockMain.setTemperature(25.5);
        mockMain.setHumidity(60.0);

        WeatherApiResponse mockResponse = new WeatherApiResponse();
        mockResponse.setMain(mockMain);

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=37.8267&lon=-122.4233&appid=aeb07a35fc7d2fc788ab33e2211664a9";
        when(restTemplate.getForObject(eq(url), eq(WeatherApiResponse.class))).thenReturn(mockResponse);

        WeatherReport report = weatherReportService.getWeatherReport(37.8267, -122.4233);

        assertNotNull(report);
        assertEquals(25.5, report.getTemperature(), 0.01);
        assertEquals(60.0, report.getHumidity(), 0.01);
    }
}