import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControleurConsultation implements EventHandler<ActionEvent>{
        private VueJO vue;
    
        private Stage stage;


    public ControleurConsultation( VueJO vue){
        this.vue = vue;
       
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        Button o =(Button) actionEvent.getSource();
        String Textboutton = o.getText();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        if (Textboutton.equals("Se déconnecter")) {

            this.vue.popUpvous_deco().showAndWait();
            this.vue.modeAccueil();
            this.vue.majAffichage(stage);
            
           
        }

        if (Textboutton.equals("Ajouter un sport +")) {
            this.vue.modeajouter();
            
            this.vue.majAffichage(stage);

        }

        if (Textboutton.equals("Ajouter un epreuve +")) {
            this.vue.modeajouter();
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Ajouter un athlète +")) {
            this.vue.modeajouter();
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Ajouter une équipe +")) {
            this.vue.modeajouter();
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Ajouter un pays +")) {
            this.vue.modeajouter();
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Fichier")) {
            this.vue.modeajouter();
            this.vue.majAffichage(stage);
        }

        if (Textboutton.equals("Aide")) {
            this.vue.modeajouter();
            this.vue.majAffichage(stage);

        }
        
        System.out.println("joji");
    

}
}
