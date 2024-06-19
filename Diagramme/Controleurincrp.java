
    import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class Controleurincrp implements EventHandler<ActionEvent>{

    private VueJO vue;
    
    private Stage stage;


    public Controleurincrp( VueJO vue){
        this.vue = vue;
       
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        Button o =(Button) actionEvent.getSource();
        String Textboutton = o.getText();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        if (Textboutton.equals("retour")) {

            this.vue.modeAccueil();
            this.vue.majAffichage(stage);
        }
           
        

        if (Textboutton.equals("Créer un nouveau compte")) {
            this.vue.poppcompte_enregistrer().showAndWait();
            this.vue.modeAccueil();
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Ajouter un sport +")) {
        }
        if (Textboutton.equals("Ajouter un epreuve +")) {
        }
        if (Textboutton.equals("Ajouter un athlète +")) {
        }
        if (Textboutton.equals("Ajouter une équipe +")) {
        }
        if (Textboutton.equals("Ajouter un pays +")) {
        }
        if (Textboutton.equals("Fichier")) {
        }
        if (Textboutton.equals("Aide")) {
        }

        

    }
}


