
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class CControleurAjretour implements EventHandler<ActionEvent>{

    private VueJO vue;
    
    private Stage stage;

    //private Requetes req;


    public CControleurAjretour( VueJO vue){ //Requetes req){
        this.vue = vue;
        //this.req = req;
       
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        Button o =(Button) actionEvent.getSource();
        String Textboutton = o.getText();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        if (Textboutton.equals("Créer l'athlète")) {
            try {
            int id = 10;
            String nom = this.vue.getTextFieldNomA();
            String prenom = this.vue.getTextFieldPrenomA();
            char sexe = this.vue.getradiobouttonFA();
            int agilite = this.vue.getTextFieldAGilA();
            int endurance = this.vue.getTextFieldEndA();
            int force = this.vue.getTextFieldforcA();

            Athlete athlete = new Athlete(id, nom, prenom, sexe, agilite, endurance, force);//

            //this.req.ajouterAthlete(athlete);

            System.out.println(athlete);
            } catch (Exception e) { 
                System.err.println("nop");
                this.vue.popUpAthleteAlert().showAndWait();
            }
        }

        else if (Textboutton.equals("Créer le Sport")){
            System.out.println("aoui");
        }
     
        else if (Textboutton.equals("retour")) {
            this.vue.modeconsultation();
            this.vue.majAffichage(stage);

        }


        

    }
}


