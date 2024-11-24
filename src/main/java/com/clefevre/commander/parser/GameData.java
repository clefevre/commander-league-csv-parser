package com.clefevre.commander.parser;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor( access = PRIVATE)
@NoArgsConstructor
public class GameData {

    @CsvBindByName(column="Your Discord Name")
    public String discord = "";

    @CsvBindByName(column="FIRST BLOOD (1 point)")
    public int firstBlood = 0;

    @CsvBindByName(column="#WINNING (1 point)")
    public int winning = 0;

    @CsvBindByName(column="MASTER OF DISASTER (1 point)")
    public int master;

    @CsvBindByName(column="REST IN PRIZES (1 point)")
    public int rest;

    @CsvBindByName(column="LOCKED ARCHIVES (1 point)")
    public int locked;

    @CsvBindByName(column="THIS LAND IS YOUR LAND (1 point)")
    public int land;

    @CsvBindByName(column="SO VANILLA! (1 point)")
    public int vanilla;

    @CsvBindByName(column="REMOVER (1 point)")
    public int remover;

    @CsvBindByName(column="GO BIG (1 point)")
    public int goBig;

    @CsvBindByName(column="I DID THE THING (1 point)")
    public int theThing;

    @CsvBindByName(column="IT CAME FROM THE ZONE (1 point)")
    public int zone;

    @CsvBindByName(column="FULL COMMAND OF THE BATTLEFIELD (1 point)")
    public int command;

    @CsvBindByName(column="FRIENDS (1 point)")
    public int friends;

    @CsvBindByName(column="TRIPLE PLAY (1 point)")
    public int triple;

    @CsvBindByName(column="ASCENSION (1 point)")
    public int ascension;

    @CsvBindByName(column="VALOR (2 points)")
    public int valor;

    @CsvBindByName(column="STRENGTH (2 points)")
    public int strength;

    @CsvBindByName(column="WISDOM (2 points)")
    public int wisdom;

    @CsvBindByName(column="HONOR (3 points)")
    public int honor;

    @CsvBindByName(column="KILLER (1 point)")
    public int killer;

    @CsvBindByName(column="SOL RING (1 point)")
    public int solRing;

    @CsvBindByName(column="MEDIC (1 point)")
    public int medic;

    @CsvBindByName(column="NOT SO INFINITE (-2 points)")
    public int infinite;

    @CsvBindByName(column="I AM NOT DONE YET!  (-2 point per instance)")
    public int done;

    @CsvBindByName(column="I SWEAR THIS NEVER HAPPENS TO ME (-2 points)")
    public int neverHappen;

    @CsvBindByName(column="Heretical Halo (-1 point)")
    public int heretic;

    @CsvBindByName(column="I AM NOT DEAD YET (5 points)")
    public int notDead;

    @CsvBindByName(column="I DID NOT NEED IT ANYWAY (3 points)")
    public int noNeed;

    @CsvBindByName(column="I HAVE A STRAIGHT (3 points)")
    public int straight;

    @CsvBindByName(column="THOUGHT YOU WERE SAFE (3 points)")
    public int safe;

    @CsvBindByName(column="MARK OF THE BEAST (6 points)")
    public int beast;

    @CsvBindByName(column="Any Feedback?")
    public String feedback;
}