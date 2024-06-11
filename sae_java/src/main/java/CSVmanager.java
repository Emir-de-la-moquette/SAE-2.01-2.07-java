import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVmanager {
    List<Athlete> lesAthletes;
    Athlete at;
    List<Equipe> lesEquipes;
    Equipe eq;
    List<Pays> lesPays;
    Pays pa;
    List<Sport> lesSports;
    Sport sp;
    List<Epreuve> lesEpreuves;
    Epreuve ep;
    List<JeuxOlympique> lesJO;
    JeuxOlympique jo;
    String statusLecture;

    public void csvToListe(String chemin){
        // List<Athlete> listeAthletes = new ArrayList<>();

        String ligne;
        String split =",";
        boolean previousInsert = false;
        
        try (BufferedReader line = new BufferedReader(new FileReader(chemin))){
            line.readLine();
            while ((ligne = line.readLine())!= null) {
                
                // tableau de String => String []
                String[] ligneElems = ligne.split(split);

                switch (ligneElems[0]) {
                    
                    case "> Sports":
                        statusLecture = "sport";
                        break;
                    case "> Athletes":
                        statusLecture = "athlete";
                        break;
                    case "> Equipes":
                        statusLecture = "equip";
                        break;
                    case "> Pays":
                        statusLecture = "pays";
                        break;
                    case "> Epreuves":
                        statusLecture = "epreuve";
                        break;
                    case "> Jeux Olympique":    
                        statusLecture = "JO";
                        break;
                    
                
                    default:
                        switch (statusLecture) {
                            case "JO":
                                
                                break;
                            case "epreuve":
                                
                                break;
                            case "pays":
                                
                                break;
                            case "equip":
                                if(!(ligneElems[0] == "> insert"))
                                    if(ligneElems.length == 1){

                                    }
                                    else System.err.println("Pas le bon insert");
                                else {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for(int i=1;i<ligneElems.length;i++)
                                    IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for(Athlete at : lesAthletes)
                                        if(IdAInsert.contains(at.getID())){
                                        eq.participer(at);
                                        IdAInsert.remove(at.getID());
                                        }
                                }
                                break;
                            case "athlete":
                                if(ligneElems.length == 6){

                                }
                                else System.err.println("Pas le bon insert");
                                break;
                            case "sport":
                                if(ligneElems.length == 5){

                                }
                                else if(ligneElems.length == 6){

                                }
                                else System.err.println("Pas le bon insert");
                                break;
                        
                            default:
                                break;
                        }
                }



                // if(ligneElems.length >=9){
                //     try {
                        
                //     String nom= ligneElems[0];
                //     String prenom= ligneElems[1];
                //     char sexe= ligneElems[2].charAt(0);
                //     String nomPays = ligneElems[3];
                //     if(!(this.lesAthletes.contains(mich)))
                //     Pays pays =  new Pays(nomPays);
                //     String sport= ligneElems[4];
                //     String epreuve = ligneElems[5];
                //     int force=  Integer.parseInt(ligneElems[6]);
                //     int endurance = Integer.parseInt(ligneElems[7]);
                //     int agilite=  Integer.parseInt(ligneElems[8]);
                    
                //     Athlete mich = new Athlete(nom,prenom,sexe,force,endurance,agilite);
                    
                //     // si athlete pas creee le cree, sinon l'add a une epreuve
                //     // incrire()
                //     if(!(this.lesAthletes.contains(mich))){
                //         this.lesAthletes.add(mich);
                //         pays
                        
                        
                //     }
                //     else{
                //         addPays(pays);
                //         addSport(sport);
                //         try {
                //             vraiEpreuve = (Epreuve<Athlete>) this.getEpreuve(epreuve);
                //             vraiEpreuve.inscrire(mich);    
                //         } catch (Exception e) {
                //             System.err.println("erreur inscription");
                //         }
                //     }
                // } catch (Exception e) {
                //     System.out.println("erreur format ligne : "+ligne);
                // }
                 
        //         }
                
            }
        }catch (Exception e) {
            e.printStackTrace();  
        }
    }
    
}
   
