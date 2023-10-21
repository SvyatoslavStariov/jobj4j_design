package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isNull();
    }

    @Test
    void whenPairWrongComment() {
        String path = "./data/pair_miltu_equals_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key")).isEqualTo("value=1=2");
        assertThat(config.value("key2")).isEqualTo("value=");
    }

    @Test
    void whenEqualsCommentOnLineOne() {
        String path = "./data/just_equals_comment.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).isEqualTo("wrong pattern, key and value is blank, on line 1");
    }

    @Test
    void whenEqualsWithKeyOnLineTwoComment() {
        String path = "./data/equals_and_key_comment.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).contains("wrong pattern, key", "without value, on line 2");
    }

    @Test
    void whenEqualsWithValueOnLineTwoComment() {
        String path = "./data/equals_and_value_comment.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).contains("wrong pattern, value", "without key, on line 2");
    }
}