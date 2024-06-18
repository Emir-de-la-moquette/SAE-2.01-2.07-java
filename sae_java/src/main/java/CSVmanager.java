import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVmanager<T> {
    static List<Athlete> lesAthletes;
    static List<Equipe> lesEquipes;
    static List<Pays> lesPays;
    static List<Sport> lesSports;
    static List<Epreuve> lesEpreuves;

    public static void csvToListe(String chemin) {

        lesAthletes = new ArrayList<>();
        lesEpreuves = new ArrayList<>();
        lesEquipes = new ArrayList<>();
        lesSports = new ArrayList<>();
        lesEpreuves = new ArrayList<>();

        HashMap<Integer, HashMap<Pays,Equipe>> inscriptionsEnAttente = new HashMap<>();

        String ligne;
        String split = ",";
        boolean firsttime = true;
        // Epreuve<Athlete> vraiEpreuve;

        try (BufferedReader line = new BufferedReader(new FileReader(chemin))) {
            
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

                        Pays lePaysPossess = null;
                        Sport leSportActuel = null;

                        for(Pays pay : lesPays){
                            if(pay.getNompays().equals(nomPays)){
                            lePaysPossess = pay;
                            break;}
                        }
                        if(lePaysPossess == null){
                            Pays newPays = new Pays(nomPays);
                            lePaysPossess = newPays;
                            lesPays.add(newPays);}

                        for(Sport sp : lesSports){
                            if(sp.getNomSport().equals(nomSport)){
                            leSportActuel = sp;
                            break;}
                        }
                        if(leSportActuel == null){
                            Sport newSport = new Sport(nomSport);
                            leSportActuel = newSport;
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
                                Equipe equipPays = epre.get(lePaysPossess);
                                if(equipPays!=null){
                                    if(equipPays.getTaille() > equipPays.getLesAthletes().size())
                                    epre.get(lePaysPossess).participer(ath);
                                    if(equipPays.estALaBonneTaille())
                                        for(Epreuve eprevuID : lesEpreuves)
                                            if(eprevuID.getID()==idEpreuve){
                                                eprevuID.participer(equipPays);
                                                equipPays=null;
                                                break;
                                            }
                                                                                
                                }
                                else {
                                    Equipe eqpx = new Equipe(Equipe.getNewId(), nbParticip, sexe);
                                    inscriptionsEnAttente.get(idEpreuve).put(lePaysPossess, eqpx);
                                    lesEquipes.add(eqpx);
                                }

                            } catch (Exception e) {
                                    System.err.println(e);
                            }
                        }
                        else{
                            try {
                                Equipe eqpx = new Equipe(Equipe.getNewId(), 1, sexe);
                                eqpx.participer(ath);
                                lesEquipes.add(eqpx);
                                for(Epreuve epreuvu : lesEpreuves){
                                    if(epreuvu.getID()==idEpreuve){
                                        epreuvu.participer(eqpx);
                                        break;
                                    }
                                    if(lesEpreuves.indexOf(epreuvu)==lesEpreuves.size()-1){
                                            Epreuve epx;
                                            if(typeEpreuve.equals("Duel")){
                                                epx = new Epreuve(idEpreuve, nomEpreuve, sexe, "A renseigner", typeEpreuve, leSportActuel, Math.random(), Math.random(), Math.random());}
                                                else{
                                                epx = new Epreuve(idEpreuve, nomEpreuve, sexe, "A renseigner", typeEpreuve, leSportActuel, moyenne, record, Math.random(), Math.random(), Math.random());}
                                            epx.participer(eqpx);
                                            lesEpreuves.add(epx);       
                                        }
                                }

                                
                            } catch (Exception e) {
                                System.err.println(e);
                            }
                        }
                        }
                       
                    catch (Exception e) {
                        System.out.println("erreur format ligne : " + ligne);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<Integer, HashMap<Pays,Equipe>> lesRestants = inscriptionsEnAttente;
        for(Map.Entry<Integer, HashMap<Pays,Equipe>> entry : lesRestants.entrySet()){
            for(Epreuve epr : lesEpreuves){
                if(epr.getID()==entry.getKey()){
                    Map<Pays,Equipe> lesEquipussy = entry.getValue();
                    for(Map.Entry<Pays, Equipe> equipussyPayussy : lesEquipussy.entrySet()){
                        System.out.println("Pour l'épreuve d'ID "+ epr.getID() + " pour le " + epr.getNomEpreuve() +" ,le Pays " + equipussyPayussy.getKey().getNompays() 
                        +" a ses athlètes suivants ne pas être inscrits par défaut du nombre de joueurs dans leur équipe \n" +equipussyPayussy.getValue().toString2());
                    }
                }
            }
        }

    }

    public static HashMap<String, List<? extends Data>> getData(){
        HashMap<String, List<? extends Data>> res = new HashMap<>();

        res.put("Sports", lesSports);
        res.put("Pays", lesPays);
        res.put("Athlete", lesAthletes);
        res.put("Equipe", lesEquipes);
        res.put("Epreuve", lesEpreuves);

        return res;
    }
}
