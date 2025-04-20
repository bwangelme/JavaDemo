package com.bwangel.headfirstjava.player;

import javax.sound.midi.*;

public class Player {
    public void play() {
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(timing, 4);
            Track t = seq.createTrack();
            t.add(myMidiEvent1);
            player.setSequence(seq);
            player.start();
        } catch (MidiUnavailableException ex) {
            System.out.println("Bummer");
        }
    }

    public static void main(String []args) {
        Player p = new Player();
        p.play();
    }
}
