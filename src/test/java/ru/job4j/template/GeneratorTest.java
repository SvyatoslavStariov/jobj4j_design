package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled
class GeneratorTest {

    @Test
    void whenTemplateGeneratedThenSuccess() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.ofEntries(
            entry("name", "Petr Arsentev"),
            entry("subject", "you")
        );
        String produce = generator.produce(template, args);
        assertThat(produce).isEqualTo("I am a Petr Arsentev, Who are you? ");
    }

    @Test
    void whenTemplateContainsKeyDoesNotMatchMapThenGetException() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("family", "Petr Arsentev");
        assertThatThrownBy(() -> generator.produce(template, args))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("The template contains a key that does not match the map");
    }

    @Test
    void whenMapContainsExtraKeyThenGetException() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.ofEntries(
            entry("name", "Petr Arsentev"),
            entry("subject", "you"),
            entry("test", "test")
        );
        assertThatThrownBy(() -> generator.produce(template, args))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("The map contains extra keys");
    }
}