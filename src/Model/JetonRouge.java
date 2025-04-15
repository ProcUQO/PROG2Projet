package Model;

public class JetonRouge extends Jeton {
    public JetonRouge(){
        super("Rouge");
    }
    @Override
    public String getCouleur() {
        return "rouge";
    }
}
