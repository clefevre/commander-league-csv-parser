package com.clefevre.commander.parser;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        callMethod();
    }

    public static void callMethod() {
        try {
            CsvToBeanBuilder<GameData> beanBuilder = new CsvToBeanBuilder<>(
                    new InputStreamReader(
                            new FileInputStream("/Users/DrowningRabbit/IdeaProjects/CsvCommanderReporter/resources/Formresponses.csv")
                    )
            );

            beanBuilder.withType(GameData.class);
            // build methods returns a list of Beans
            List<UserGameData> userData = beanBuilder.build().parse().stream().map(e -> {
                int questScore = e.firstBlood + e.winning + e.master + e.rest + e.locked + e.land + e.vanilla + e.remover + e.goBig + e.theThing + e.zone + e.command + e.friends + e.triple + e.ascension + e.valor + e.strength + e.wisdom + e.honor + e.killer + e.solRing + e.medic + e.infinite + e.done + e.neverHappen + e.heretic;

                return new UserGameData(e.discord,
                        questScore,
                        e.notDead,
                        e.noNeed,
                        e.straight,
                        e.safe,
                        e.beast);
            }).toList();

            List<String> userDiscords = userData.stream().map(e -> e.discord.toLowerCase()).distinct().toList();
            List<UserScore> output = new ArrayList<>();
            for (String userDiscord : userDiscords) {
                List<UserGameData> specificData = userData.stream().filter(e -> e.discord.toLowerCase().equals(userDiscord)).toList();
                int totalGames = specificData.size();
                List<Integer> userScore = specificData.stream().map(e -> e.questTotal).sorted().toList();
                int max;
                int max2 = 0;
                if (userScore.size() > 1) {
                    max = userScore.get(userScore.size() - 1);
                    max2 = userScore.get(userScore.size() - 2);
                } else {
                    max = userScore.get(userScore.size() - 1);
                }
                boolean notDead = specificData.stream().anyMatch(e -> e.notDead > 0);
                boolean noNeed = specificData.stream().anyMatch(e -> e.noNeed > 0);
                boolean straight = specificData.stream().anyMatch(e -> e.straight > 0);
                boolean safe = specificData.stream().anyMatch(e -> e.safe > 0);
                boolean beast = specificData.stream().anyMatch(e -> e.beast > 0);
                int totalScore = max + max2;
                if (notDead) totalScore += 5;
                if (noNeed) totalScore += 3;
                if (straight) totalScore += 3;
                if (safe) totalScore += 3;
                if (beast) totalScore += 6;
                output.add(new UserScore(userDiscord, totalScore, totalGames));
            }
            output.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.println(e.discord + ", " + e.score+", "+ e.totalGames));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    static class UserScore implements Comparable<UserScore> {
        String discord;
        int score;
        int totalGames;

        public UserScore(String discord, int score, int totalGames) {
            this.discord = discord;
            this.score = score;
            this.totalGames = totalGames;
        }

        @Override
        public int compareTo(UserScore other) {
            return Integer.compare(this.score, other.score);
        }
    }

    public record UserGameData(String discord,
                               int questTotal,
                               int notDead,
                               int noNeed,
                               int straight,
                               int safe,
                               int beast) {}
}
