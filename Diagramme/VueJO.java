import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class VueJO extends Application {
    Scene mainScene;
    Scene tabscene;
    BorderPane root;
    BorderPane fenetreAccueil;
    BorderPane fenetreinscription;
    TabPane fenetre_ajoute;
    //TabPane fenetre_ajoutev2;
    BorderPane Consultation;
    FXMLLoader loader;
    //private ModelJO jo;
  
    @Override
    public void init(){    
    }
    
    @Override
    public void start(Stage stage) throws IOException {

        loader = new FXMLLoader(this.getClass().getResource("Acceuil-FX.fxml"));
        fenetreAccueil = loader.load();
        this.mainScene = new Scene(fenetreAccueil);
        
        ControleurAcc ctrac = new ControleurAcc(this);

        try{
        Button identconnexe = (Button) this.mainScene.lookup("#connecter");
        Button motconnexe = (Button) this.mainScene.lookup("#pascompte");

        identconnexe.setOnAction(ctrac);
        motconnexe.setOnAction(ctrac);
        }
        catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("problem");
        }



        stage.setScene(this.mainScene);
        stage.setTitle("Consultation");
        stage.setResizable(true);
        stage.show();

        //Button btest = (Button) mainScene.lookup("#monBouton");

        // Appeler ici votre controler !
        //btest.setOnAction(Event -> {btest.setText("Coucou, ça marche !");});}
    }


    private Scene fenetreAccueil() throws IOException{

        loader = new FXMLLoader(this.getClass().getResource("Acceuil-FX.fxml"));
        fenetreAccueil = loader.load();
        this.mainScene = new Scene(fenetreAccueil);
        
        ControleurAcc ctrac = new ControleurAcc(this);

        try{
        Button identconnexe = (Button) this.mainScene.lookup("#connecter");
        Button motconnexe = (Button) this.mainScene.lookup("#pascompte");

        identconnexe.setOnAction(ctrac);
        motconnexe.setOnAction(ctrac);
        }
        catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("problem");
        }

        return this.mainScene;
    }

     private Scene fenetreinscription() throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("Inscription-FX.fxml"));
        fenetreinscription = loader.load();
        this.mainScene = new Scene(fenetreinscription);

        Controleurincrp ctrinc = new Controleurincrp(this);

        try{
        Button bouttonretour = (Button) this.mainScene.lookup("#Bretour");
        Button boutton_nouveau_compte = (Button) this.mainScene.lookup("#nouveau_compte");

        bouttonretour.setOnAction(ctrinc);
        boutton_nouveau_compte.setOnAction(ctrinc);
        }
        catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("problem");
        }

        return this.mainScene;
     }


    private Scene fenetre_ajoute()  throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("Ajouter-FX.fxml"));
        this.fenetre_ajoute = loader.load();
        //this.fenetre_ajoutev2 =loader.load();
        this.mainScene = new Scene(fenetre_ajoute);
        

        ControleurAjretour ctraj = new ControleurAjretour(this);

        try{

            // bouton retour
            Button bouttonretour1 = (Button) this.mainScene.lookup("#retour");
            Button bouttonretour2 = (Button) this.mainScene.lookup("#retour1");
            Button bouttonretour3 = (Button) this.mainScene.lookup("#retour2");
            Button bouttonretour4 = (Button) this.mainScene.lookup("#retour3");
            Button bouttonretour5 = (Button) this.mainScene.lookup("#retour4");

            bouttonretour1.setOnAction(ctraj);
            bouttonretour2.setOnAction(ctraj);
            bouttonretour3.setOnAction(ctraj);
            bouttonretour4.setOnAction(ctraj);
            bouttonretour5.setOnAction(ctraj);
            //______________________________________________________
            // partie ajouter athlete
            TextField textFieldNomA = (TextField) this.mainScene.lookup("#textFieldNomA");
            TextField textFieldprenomA = (TextField) this.mainScene.lookup("#textFieldprenomA");

            TextField textFieldAGilA = (TextField) this.mainScene.lookup("#textFieldAGilA");
            TextField textFieldEndA = (TextField) this.mainScene.lookup("#textFieldEndA"); //textfield
            TextField textFieldforcA = (TextField) this.mainScene.lookup("#textFieldforcA");

            Slider slideragA = (Slider) this.mainScene.lookup("#slideragA");
            Slider sliderendA = (Slider) this.mainScene.lookup("#sliderendA"); //slider
            Slider sliderForA = (Slider) this.mainScene.lookup("#sliderForA");

            Button bCreerA = (Button) this.mainScene.lookup("#bCreerA");

            //creer les toggle boutton et relier les radio boutton
            RadioButton radiobouttonHA = (RadioButton) this.mainScene.lookup("#radiobouttonHA");
            RadioButton radiobouttonFA = (RadioButton) this.mainScene.lookup("#radiobouttonFA");
            
            //______________________________________________________
            // partie ajouter sport
            TextField textfieldSport = (TextField) this.mainScene.lookup("#textfieldSport");
            Button BCreerSP = (Button) this.mainScene.lookup("#BCreerSP");

            //______________________________________________________
            // partie ajouter equipe

            TextField textFieldnbjoueurmax = (TextField) this.mainScene.lookup("#textFieldnbjoueurmax");
            Button BcreerEQ = (Button) this.mainScene.lookup("#BcreerEQ");
            Button BajouAdansEQ = (Button) this.mainScene.lookup("#BajouAdansEQ");
            

            //creer les toggle boutton et relier les radio boutton
            RadioButton radiobouttonHE = (RadioButton) this.mainScene.lookup("#radiobouttonHE");
            RadioButton radiobouttonFE = (RadioButton) this.mainScene.lookup("#radiobouttonFE");
            //______________________________________________________
            // partie ajouter Epreuve 
            TextField textFieldNomEP = (TextField) this.mainScene.lookup("#textFieldNomEP");

            ChoiceBox choix_Sport_Ass = (ChoiceBox) this.mainScene.lookup("#choix_Sport_Ass");

            //creer les toggle boutton et relier les radio boutton p1
            Button radiobouttonHEP = (Button) this.mainScene.lookup("#radiobouttonHEP");
            Button radiobouttonFEP = (Button) this.mainScene.lookup("#radiobouttonFEP");


            TextField textFieldCaractEP = (TextField) this.mainScene.lookup("#textFieldCaractEP");

             //creer les toggle boutton et relier les radio boutton p2
             RadioButton radiobouttonFPaff = (RadioButton) this.mainScene.lookup("#radiobouttonFPaff");
             RadioButton radiobouttonFPMscore = (RadioButton) this.mainScene.lookup("#radiobouttonFPMscore");


             //demande agil endu force textfield
             TextField textFieldDemandeAGIL = (TextField) this.mainScene.lookup("#textFieldDemandeAGIL");
             TextField textFieldDemandeEND = (TextField) this.mainScene.lookup("#textFieldDemandeEND");
             TextField textFieldDemandeFORC = (TextField) this.mainScene.lookup("#textFieldDemandeFORC");


            //creer les toggle boutton et relier les radio boutton p3
            RadioButton radiobouttonRPnon = (RadioButton) this.mainScene.lookup("#radiobouttonRPnon");
            RadioButton radiobouttonRPVscoreatt = (RadioButton) this.mainScene.lookup("#radiobouttonRPVscoreatt");
            RadioButton radiobouttonRPVecartscore = (RadioButton) this.mainScene.lookup("#radiobouttonRPVecartscore");


             Button BcreerEP = (Button) this.mainScene.lookup("#BcreerEP");

             //______________________________________________________
            // partie ajouter Pays
            TextField textFieldNomP = (TextField) this.mainScene.lookup("#textFieldNomP");


            Button BchoisirHymne = (Button) this.mainScene.lookup("#BchoisirHymne");
            Button Bplay = (Button) this.mainScene.lookup("#Bplay");
            Button Bchoisirdrap = (Button) this.mainScene.lookup("#Bchoisirdrap");

            ImageView imageDrapeauP = (ImageView) this.mainScene.lookup("#imageDrapeauP");

            Button BCreerP = (Button) this.mainScene.lookup("#BCreerP");


            }
            catch (NullPointerException e) {
                // TODO: handle exception
                System.out.println("problem");
            }


        

        return this.mainScene;
     }

     /* 
     public Scene choisir_le_bon_tab_dans_ajoute(int number){

        this.fenetre_ajoutev2.getSelectionModel().select(number);
        this.mainScene = new Scene(fenetre_ajoutev2);
        return this.mainScene;
     }
*/
/* 
    private Scene fenetre_idk() throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("idk.fxml"));
        fenetre_creer_Pays = loader.load();
        this.mainScene = new Scene(fenetre_creer_Pays);

        return this.mainScene;
    }*/


    private Scene fenetre_consultation() throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("Consultation-FX.fxml"));
        Consultation = loader.load();
        this.mainScene = new Scene(Consultation);
        
        ControleurConsultation ctrinc = new ControleurConsultation(this);

        try{
            Button bouttondeco = (Button) this.mainScene.lookup("#SEDECO");
            Button ajoutersport = (Button) this.mainScene.lookup("#ajSport");
            Button ajouterepreuve = (Button) this.mainScene.lookup("#ajEpreue");
            Button ajouterATHE = (Button) this.mainScene.lookup("#ajAthletes");
            Button ajouterEquipe = (Button) this.mainScene.lookup("#ajEquipe");
            Button ajouterpays = (Button) this.mainScene.lookup("#ajPays");
    
            bouttondeco.setOnAction(ctrinc);
            ajoutersport.setOnAction(ctrinc);
            ajouterepreuve.setOnAction(ctrinc);
            ajouterATHE.setOnAction(ctrinc);
            ajouterEquipe.setOnAction(ctrinc);
            ajouterpays.setOnAction(ctrinc);



            
            }
            catch (NullPointerException e) {
                // TODO: handle exception
                System.out.println("problem");
            }

        return this.mainScene;
     }




    public void modeAccueil()  {
        try{
            this.fenetreAccueil();
        }
        
        catch(IOException e){
            System.out.println("error");
        }
    }

    public void modeajouter()  {
        try{
            this.fenetre_ajoute();
        }
        
        catch(IOException e){
            System.out.println("error");
        }
    }

    public void modeconsultation()  {
        try{
            this.fenetre_consultation();
        }
        
        catch(IOException e){
            System.out.println("error");
        }
    }
   
    
    public void modeinscription() throws IOException {

        // A implementer
        try{
        this.fenetreinscription();
        }
            
        catch(IOException e){
            System.out.println("error");
        }
    }
    



    public void majAffichage(Stage stage){
        // A implementer
               System.out.println("MARCG");
               stage.setScene(this.mainScene);
               stage.setTitle("Consultation");
               stage.show();

    }


    public Alert popUpvous_deco(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"vous aller vous deconecter\n Etes-vous sûr vous deconecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
       
    public Alert poppcompte_enregistrer(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("compte enregistrer");
        alert.setHeaderText("compte valider");
        alert.setContentText("votre compte est bien enregistrer");
        return alert;
    }


 

    public static void main(String[] args) {
        launch(args);

    

}

}