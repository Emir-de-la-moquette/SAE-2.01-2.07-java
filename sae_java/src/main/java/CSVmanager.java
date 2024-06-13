import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
        // Epreuve<Athlete> vraiEpreuve;

        try (BufferedReader line = new BufferedReader(new FileReader(chemin))) {
            line.readLine();
            while ((ligne = line.readLine()) != null) {

                // tableau de String => String []
                String[] ligneElems = ligne.split(split);
              
                if (ligneElems.length >= 9) {
                    try {

                        String nom = ligneElems[0];
                        String prenom = ligneElems[1];
                        char sexe = ligneElems[2].charAt(0);
                        String nomPays = ligneElems[3];
                        Pays pays = new Pays(nomPays);
                        String nomSport = ligneElems[4];
                        String nomEpreuve = ligneElems[5];
                        int force = Integer.parseInt(ligneElems[6]);
                        int endurance = Integer.parseInt(ligneElems[7]);
                        int agilite = Integer.parseInt(ligneElems[8]);

                        Athlete ath = new Athlete(Athlete.getNewId(), nom, prenom, sexe, force, endurance, agilite);
                        lesAthletes.add(ath);
                        Equipe eqSolo = new Equipe(Equipe.getNewId(), 1, sexe); // a voir
                        eqSolo.participer(ath);
                        lesEquipes.add(eqSolo);

                        if (!(lesPays.contains(pays))) {
                            pays.participer(eqSolo);
                            lesPays.add(pays);
                        } else
                            lesPays.get(lesPays.indexOf(pays)).participer(eqSolo);

                        for (Sport sp : lesSports) {
                            if (sp.getNomSport().equals(nomSport)) {
                                if (sp.getNbJoueur() == 1)
                                    for (Epreuve ep : lesEpreuves) {
                                        if (ep.getNomEpreuve().equals(nomEpreuve)) {
                                            ep.participer(eqSolo);
                                            break;
                                        }
                                        Epreuve newEP = new Epreuve(Epreuve.getNewId(), nomEpreuve, sexe, "inconnue",
                                                "inconnue", sp);
                                        newEP.participer(eqSolo);
                                        lesEpreuves.add(newEP);

                                    }
                                else {
                                    System.err.println("Le sport indiqué n'est pas fait pour les athletes seuls");
                                }
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

    }
}
