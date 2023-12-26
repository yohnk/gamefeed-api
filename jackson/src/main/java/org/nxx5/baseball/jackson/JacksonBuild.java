package org.nxx5.baseball.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.nxx5.baseball.records.BoxScorePlayer;
import org.nxx5.baseball.records.BoxScorePlayers;
import org.nxx5.baseball.records.Person;
import org.nxx5.baseball.records.Players;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class JacksonBuild {

    public static Builder builder(Builder builder) {
        builder.addModule(new JavaTimeModule());
        builder.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Players.class, new PlayersDeserializer());
        module.addDeserializer(BoxScorePlayers.class, new BoxScorePlayersDeserializer());
        builder.addModule(module);
        return builder;
    }

    public static Builder builder() {
        return builder(JsonMapper.builder());
    }

    private static class PlayersDeserializer extends StdDeserializer<Players> {

        private static final ObjectMapper mapper = builder().build();

        public PlayersDeserializer() {
            this(null);
        }

        public PlayersDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Players deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Players players = new Players();
            TreeNode treeNode = jsonParser.readValueAsTree();
            for (Iterator<String> it = treeNode.fieldNames(); it.hasNext();) {
                String key = it.next();
                TreeNode player = treeNode.get(key);
                Person p = mapper.readValue(player.traverse(), Person.class);
                players.put(p.id(), p);
            }
            return players;
        }

    }

    private static class BoxScorePlayersDeserializer extends StdDeserializer<BoxScorePlayers> {

        private static final ObjectMapper mapper = builder().build();

        public BoxScorePlayersDeserializer() {
            this(null);
        }

        public BoxScorePlayersDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public BoxScorePlayers deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            BoxScorePlayers players = new BoxScorePlayers();
            TreeNode treeNode = jsonParser.readValueAsTree();
            for (Iterator<String> it = treeNode.fieldNames(); it.hasNext();) {
                String key = it.next();
                TreeNode player = treeNode.get(key);
                BoxScorePlayer p = mapper.readValue(player.traverse(), BoxScorePlayer.class);
                if(Objects.nonNull(p) && Objects.nonNull(p.person())) {
                    players.put(p.person().id(), p);
                }
            }
            return players;
        }

    }

}
