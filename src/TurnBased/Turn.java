package TurnBased;

public class Turn {
    public boolean tourJoueur1 = true;

    public boolean setTourJoueur1(boolean sonTour)
    {
        this.tourJoueur1 = sonTour;
        return tourJoueur1;
    }
    public void ChangeTurn(){
        if(tourJoueur1 == true){
            setTourJoueur1(false);
        } else if (tourJoueur1 == false) {
            setTourJoueur1(true);
        }
    }
}
