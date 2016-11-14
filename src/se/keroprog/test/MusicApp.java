package se.keroprog.test;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicApp implements ActionListener {
    JButton button;

    public static void main(String[] args) {

        MusicApp mini = new MusicApp();
        mini.play();


        mini.go();





        // write your code here
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Click me!");
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);


    }



    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,43,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,43,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

    }

    public void changeIt(JButton button){

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        button.setText("Button Clicked!!");
    }
}
