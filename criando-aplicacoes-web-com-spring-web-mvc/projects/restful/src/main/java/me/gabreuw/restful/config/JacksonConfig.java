package me.gabreuw.restful.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import me.gabreuw.restful.domain.enums.Tribe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static com.fasterxml.jackson.core.json.PackageVersion.VERSION;
import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(FAIL_ON_EMPTY_BEANS, false);
        mapper.enable(ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(tribeModuleMapper());

        return mapper;
    }

    public SimpleModule tribeModuleMapper() {
        SimpleModule module = new SimpleModule("JSONTribeModule", VERSION);

        module.addSerializer(Tribe.class, new TribeSerializer());
        module.addDeserializer(Tribe.class, new TribeDeserializer());

        return module;
    }

    class TribeSerializer extends StdSerializer<Tribe> {

        protected TribeSerializer() {
            super(Tribe.class);
        }

        @Override
        public void serialize(Tribe value, JsonGenerator generator, SerializerProvider provider) throws IOException {
            generator.writeString(value.getName());
        }

    }

    class TribeDeserializer extends StdDeserializer<Tribe> {

        protected TribeDeserializer() {
            super(Tribe.class);
        }

        @Override
        public Tribe deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            return Tribe.of(parser.getText());
        }

    }

}
