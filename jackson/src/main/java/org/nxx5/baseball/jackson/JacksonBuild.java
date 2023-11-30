package org.nxx5.baseball.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonBuild {

    public static Builder builder(Builder builder){
        return builder.addModule(new JavaTimeModule()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static Builder builder(){
        return builder(JsonMapper.builder());
    }


}
