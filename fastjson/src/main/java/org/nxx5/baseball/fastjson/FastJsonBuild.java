package org.nxx5.baseball.fastjson;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.modules.ObjectReaderModule;
import com.alibaba.fastjson2.reader.ObjectReader;
import org.nxx5.baseball.records.Players;

import java.lang.reflect.Type;
import java.util.function.Function;

public class FastJsonBuild {

    public static void register(){
        JSON.register(Players.class, new PlayersDeserializer());
    }

    private static class PlayersDeserializer implements ObjectReader<Players> {
        @Override
        public Players readObject(JSONReader jsonReader, Type type, Object o, long l) {
            return null;
        }

        @Override
        public Function getBuildFunction() {
            return null;
        }

    }

}
