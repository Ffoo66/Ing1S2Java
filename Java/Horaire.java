public class Horaire {
    private int heures;
    private int minutes;
    private int secondes;

    // Constructeur
    public Horaire(int heures, int minutes, int secondes) {
        this.heures = heures;
        this.minutes = minutes;
        this.secondes = secondes;
    }

    //  les getters
    public int getHeures() { return heures; }
    public int getMinutes() { return minutes; }
    public int getSecondes() { return secondes; }

    // les setters
    public void setHeures(int heures) { this.heures = heures; }
    public void setMinutes(int minutes) { this.minutes = minutes; }
    public void setSecondes(int secondes) { this.secondes = secondes; }

    // methode de affichage
    public String toString() {
        return String.format("%02d:%02d:%02d", heures, minutes, secondes);
    }
}
