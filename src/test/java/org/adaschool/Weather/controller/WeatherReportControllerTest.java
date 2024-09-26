package org.adaschool.Weather.controller;

import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class WeatherReportControllerTest {

    @InjectMocks
    private WeatherReportController weatherReportController;

    @Mock
    private WeatherReportService weatherReportService;

    @Test
    public void testGetWeatherReport() {
        double latitude = 37.8267;
        double longitude = -122.4233;
        WeatherReport mockReport = new WeatherReport();
        mockReport.setTemperature(15.0);
        mockReport.setHumidity(80.0);

        Mockito.when(weatherReportService.getWeatherReport(latitude, longitude)).thenReturn(mockReport);

        WeatherReport response = weatherReportController.getWeatherReport(latitude, longitude);

        assertEquals(mockReport, response);
    }
}