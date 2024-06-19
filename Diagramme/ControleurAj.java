
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class ControleurAj implements EventHandler<ActionEvent>{

    private VueJO vue;
    
    private Stage stage;


    public ControleurAj( VueJO vue){
        this.vue = vue;
       
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        Button o =(Button) actionEvent.getSource();
        String Textboutton = o.getText();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();


     
        if (Textboutton.equals("retour")) {
            this.vue.modeconsultation();
            
            this.vue.majAffichage(stage);

        }


        

    }
}


