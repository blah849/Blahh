package adventure.things.interactive;

import adventure.things.Thing;

public class Journal extends Thing {
    private int numberOfNotes;

    public Journal() {
        this.shortName = "Journal";
        this.fullName = "Journal";
        this.description = "This is your detective journal" +
                " where you can take notes as you investigate " +
                "the crime scene and solve the case.";
    }

    public void addNote(String note) {
        description += "\nEntry " + numberOfNotes + ": " + note;
        numberOfNotes++;
    }
}
