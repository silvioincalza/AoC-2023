package me.incalza.aoc2023.days._2;

import me.incalza.aoc2023.days.LineParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ElfiCubeConundrumDecoderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElfiCubeConundrumDecoderTest.class);


    @Test
    void testPart1Simple() throws Exception {
        ElfiCubeConundrumDecoder decoder = new ElfiCubeConundrumDecoder(new LineParser() {
            @Override
            public String parse(String line) {
                return "";
            }
        });
        int decode = doDecode(decoder, getClass().getResource("simple1.txt"));
        Assertions.assertThat(decode).isEqualTo(142);
    }


    private int doDecode(ElfiCubeConundrumDecoder decoder, URL resource) throws Exception {
        int decode = decoder.decode(Path.of(resource.toURI()));
        LOGGER.info("Decoded: {}", decode);
        return decode;
    }


}