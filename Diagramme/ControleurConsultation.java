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

        if (Textboutton.equals("Se connecter")) {
            this.vue.modeconsultation();
            this.vue.majAffichage(stage);
            
        }
        
        System.out.println("joji");
    

}
}
