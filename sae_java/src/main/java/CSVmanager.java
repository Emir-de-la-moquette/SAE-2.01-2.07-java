import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVmanager {
    List<Athlete> lesAthletes;
    List<Equipe> lesEquipes;
    List<Pays> lesPays;
    List<Sport> lesSports;
    List<Epreuve> lesEpreuves;

    public void csvToListe(String chemin) {

        String ligne;
        String split = ",";
        boolean firsttime = true;
        // Epreuve<Athlete> vraiEpreuve;

        try (BufferedReader line = new BufferedReader(new FileReader(chemin))) {
            HashMap<Integer, HashMap<Pays,Equipe>> inscriptionsEnAttente = new HashMap<>();
            
            line.readLine();
            while ((ligne = line.readLine()) != null) {

                // tableau de String => String []
                String[] ligneElems = ligne.split(split);
              
                if (ligneElems.length != 14) {
                    if(!firsttime)
                    try {
                        firsttime = false;
                        String nom = ligneElems[0];
                        String prenom = ligneElems[1];
                        char sexe = ligneElems[2].charAt(0);
                        String nomPays = ligneElems[3];
                        Pays pays = new Pays(nomPays);
                        String nomEpreuve = ligneElems[4];
                        int idEpreuve = Integer.parseInt(ligneElems[5]);
                        String nomSport = ligneElems[6];
                        String typeEpreuve = ligneElems[7];
                        int nbParticip = Integer.parseInt(ligneElems[8]);
                        double record = Double.parseDouble(ligneElems[9]);
                        double moyenne = Double.parseDouble(ligneElems[10]);
                        int force = Integer.parseInt(ligneElems[11]);
                        int endurance = Integer.parseInt(ligneElems[12]);
                        int agilite = Integer.parseInt(ligneElems[13]);

                        Athlete ath = new Athlete(Athlete.getNewId(), nom, prenom, sexe, force, endurance, agilite);
                        lesAthletes.add(ath);

                        Pays lePaysPossess;
                        Sport leSportActuel;

                        for(Pays pay : lesPays){
                            if(pay.getNompays().equals(nomPays))
                            lePaysPossess = pay;
                            break;
                            Pays newPays = new Pays(nomPays);
                            lesPays.add(newPays);
                        }

                        for(Sport sp : lesSports){
                            if(sp.getNomSport().equals(nomSport))
                            leSportActuel = sp;
                            break;
                            Sport newSport = new Sport(nomSport);
                            lesSports.add(newSport);
                        }

                        if(nbParticip > 1){
                            try {
                                HashMap<Pays, Equipe> epre = inscriptionsEnAttente.get(idEpreuve);
                                if(epre==null) {
                                    Epreuve epx;
                                    if(typeEpreuve.equals("Duel")){
                                    epx = new Epreuve(idEpreuve, nomEpreuve, sexe, "A renseigner", typeEpreuve, leSportActuel, Math.random(), Math.random(), Math.random());}
                                    else{
                                    epx = new Epreuve(idEpreuve, nomEpreuve, sexe, "A renseigner", typeEpreuve, leSportActuel, moyenne, record, Math.random(), Math.random(), Math.random());}
                                    lesEpreuves.add(epx);
                                    HashMap<Pays, Equipe> participants = new HashMap<>();
                                    inscriptionsEnAttente.put(idEpreuve, participants);
                                }
                                if(epre.get(lePaysPossess)!=null){
                                    epre.get(lePaysPossess).participer(ath);
                                }
                                else {
                                    inscriptionsEnAttente.get(idEpreuve).put(lePaysPossess, new Equipe(Equipe.getNewId(), nbParticip, sexe));
                                }

                            } catch (Exception e) {
                                // TODO: handle exception
                            }
                        }
                        //Equipe eqSolo = new Equipe(Equipe.getNewId(), 1, sexe); // a voir
                        //eqSolo.participer(ath);
                        lesEquipes.add(eqSolo);

                        for(Pays pa : lesPays){
                            if(pa.getNompays().equals(nomPays)){
                                pays.participer(eqSolo);
                                lesPays.add(pays);
                                break;
                            }
                            lesPays.get(lesPays.indexOf(pays)).participer(eqSolo);
                        }


                        if(lesSports.contains(nomSport)){
                            Sport sp = lesSports.get(lesSports.indexOf(nomSport));
                                if (sp.getNbJoueur() == 1)
                                    for (Epreuve ep : lesEpreuves) {
                                        if (ep.getID()==idEpreuve) {
                                            ep.participer(eqSolo);
                                            break;
                                        }
                                        if(lesEpreuves.indexOf(ep)==lesEpreuves.size()-1){
                                        Epreuve newEP = new Epreuve(Epreuve.getNewId(), "nom Epreuve", sexe, "inconnue",
                                                "score", sp, 5.0, 5.0, 5.0);
                                        System.out.println("Veuillez configurer l'épreuve");
                                        newEP.participer(eqSolo);
                                        lesEpreuves.add(newEP);}

                                    }
                                else {
                                    System.err.println("Le sport indiqué n'est pas fait pour les athletes seuls");
                                }
                                
                            }
                        else{
                            Sport newSport = new Sport(nomSport, 1, 1);
                            lesSports.add(newSport);
                            Epreuve newEP = new Epreuve(Epreuve.getNewId(), "nom Epreuve", sexe, "inconnue",
                                                "score", newSport, 5.0, 5.0, 5.0);
                            System.out.println("Veuillez configurer l'épreuve");
                            newEP.participer(eqSolo);
                            lesEpreuves.add(newEP);}
                        }
                       
                    catch (Exception e) {
                        System.out.println("erreur format ligne : " + ligne);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
