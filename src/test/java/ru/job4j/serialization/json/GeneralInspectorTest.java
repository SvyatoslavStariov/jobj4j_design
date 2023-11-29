package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GeneralInspectorTest {
    @Test
    void testJsonEquals() {
        GeneralInspector generalInspector = new GeneralInspector(
                false,
                40,
                List.of("Вася, Петя, Саша"),
                new ZoneControl("Москва")
        );
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(generalInspector);
        String expectedJson = "{"
                + "\"isVacation\":false,"
                + "\"age\":40,"
                + "\"subdivision\":[\"Вася, Петя, Саша\"],"
                + "\"zoneControl\":{\"area\":\"Москва\"}"
                + "}";
        assertThat(json).isEqualTo(expectedJson);
        assertThat(generalInspector).isEqualTo(gson.fromJson(expectedJson, GeneralInspector.class));
    }

    @Test
    void testJsonObjectEquals() {
        GeneralInspector generalInspector = new GeneralInspector();
        ZoneControl zoneControl = new ZoneControl();
        zoneControl.setInspector(generalInspector);
        zoneControl.setArea("Москва");
        generalInspector.setAge(40);
        generalInspector.setVacation(false);
        generalInspector.setSubdivision(List.of("Вася, Петя, Саша"));
        generalInspector.setZoneControl(zoneControl);
        Map<String, Object> jsonMap = new JSONObject(generalInspector).toMap();
        Map<String, Object> expectedJsonMap = new JSONObject("{"
                + "\"vacation\":false,"
                + "\"age\":40,"
                + "\"subdivision\":[\"Вася, Петя, Саша\"],"
                + "\"zoneControl\":{\"area\":\"Москва\"}"
                + "}").toMap();
        assertThat(jsonMap).isEqualTo(expectedJsonMap);
    }
}