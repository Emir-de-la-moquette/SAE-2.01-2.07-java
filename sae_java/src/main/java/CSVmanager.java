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

    /**
     * @param chemin
     */
    public void csvToListe(String chemin) {
        // List<Athlete> listeAthletes = new ArrayList<>();

        String ligne;
        String split = ",";
        boolean previousInsert = false;

        try (BufferedReader line = new BufferedReader(new FileReader(chemin))) {
            line.readLine();
            while ((ligne = line.readLine()) != null) {

                // tableau de String => String []
                String[] ligneElems = ligne.split(split);

                switch (ligneElems[0]) {
                    case "":
                        break;

                    case "<classe> Sports":
                        statusLecture = "sport";
                        break;
                    case "<classe> Athletes":
                        statusLecture = "athlete";
                        break;
                    case "<classe> Equipes":
                        statusLecture = "equip";
                        break;
                    case "<classe> Pays":
                        statusLecture = "pays";
                        break;
                    case "<classe> Epreuves":
                        statusLecture = "epreuve";
                        break;
                    case "<classe> Jeux Olympique":
                        statusLecture = "JO";
                        break;

                    default:
                        switch (statusLecture) {
                            case "JO":
                                if (!(ligneElems[0] == "> insert pays") && !(ligneElems[0] == "> insert epreuve"
                                        && !(ligneElems[0] == "> insert sport")))
                                    if (ligneElems.length == 2) {

                                    } else
                                        System.err.println("Pas le bon insert");
                                else if (ligneElems[0] == "> insert pays") {
                                    List<String> PaysAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        PaysAInsert.add(ligneElems[i]);
                                    for (Pays p : lesPays)
                                        if (PaysAInsert.contains(p.getNompays())) {
                                            jo.ajoutePays(p);
                                            PaysAInsert.remove(p.getNompays());
                                        }
                                } else if (ligneElems[0] == "> insert epreuve") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Epreuve e : lesEpreuves)
                                        if (IdAInsert.contains(e.getID())) {
                                            jo.ajouteEpreuve(e);
                                            IdAInsert.remove(a.getID());
                                        }
                                }

                                else if (ligneElems[0] == "> insert sport") {
                                    List<Integer> SportAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        SportAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Sport a : lesSports)
                                        if (SportAInsert.contains(s.getNomSport())) {
                                            jo.ajouteSport(a);
                                            SportAInsert.remove(a.getID());
                                        }

                                }
                                break;
                            case "epreuve":
                                if (!(ligneElems[0] == "> insert equipe") && !(ligneElems[0] == "> insert athlete"))
                                    if (ligneElems.length == 6) {

                                    } else if (ligneElems.length == 8) {

                                    } else
                                        System.err.println("Pas le bon insert");
                                else if (ligneElems[0] == "> insert equipe") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Equipe e : lesEquipes)
                                        if (IdAInsert.contains(e.getID())) {
                                            pa.participer(e);
                                            IdAInsert.remove(e.getID());
                                        }
                                } else if (ligneElems[0] == "> insert athlete") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Athlete a : lesAthletes)
                                        if (IdAInsert.contains(a.getID())) {
                                            for (Equipe e : lesEquipes) {
                                                if (e.getTaille() == 1 && e.getLesAthletes().contains(a)) {
                                                    ep.participer(e);
                                                    IdAInsert.remove(a.getID());
                                                    break;
                                                }
                                            }

                                        }
                                }
                                break;
                            case "pays":
                                if (!(ligneElems[0] == "> insert equipe") && !(ligneElems[0] == "> insert athlete"))
                                    if (ligneElems.length == 1) {

                                    } else
                                        System.err.println("Pas le bon insert");
                                else if (ligneElems[0] == "> insert equipe") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Equipe e : lesEquipes)
                                        if (IdAInsert.contains(e.getID())) {
                                            pa.participer(e);
                                            IdAInsert.remove(e.getID());
                                        }
                                } else if (ligneElems[0] == "> insert athlete") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Athlete a : lesAthletes)
                                        if (IdAInsert.contains(a.getID())) {
                                            boolean existe = false;
                                            for (Equipe e : lesEquipes) {
                                                if (e.getTaille() == 1 && e.getLesAthletes().contains(a)) {
                                                    pa.participer(e);
                                                    IdAInsert.remove(a.getID());
                                                    existe = true;
                                                    break;
                                                }
                                            }
                                            if (!existe) {
                                                Equipe equ = new Equipe(Equipe.getNewId(), 1).participer(a);
                                                lesEquipes.add(equ);
                                                pa.participer(equ);
                                                IdAInsert.remove(a.getID());
                                            }

                                        }
                                }
                                break;
                            case "equip":
                                if (!(ligneElems[0] == "> insert"))
                                    if (ligneElems.length == 2) {
                                        try {
                                            int id = Integer.parseInt(ligneElems[0]);
                                            int taille = Integer.parseInt(ligneElems[1]);
                                            try {
                                                at = new Equipe(id, taille);
                                                lesAthletes.add(at);
                                            } catch (Exception x) {
                                                System.err.println(x);
                                            }
                                        } catch (Exception e) {
                                            System.err.println(e);
                                        }
                                    } else
                                        System.err.println("Pas le bon insert");
                                else if (ligneElems[0] == "> insert") {
                                    List<Integer> IdAInsert = new ArrayList<>();
                                    for (int i = 1; i < ligneElems.length; i++)
                                        IdAInsert.add(Integer.parseInt(ligneElems[i]));
                                    for (Athlete a : lesAthletes)
                                        if (IdAInsert.contains(a.getID())) {
                                            eq.participer(a);
                                            IdAInsert.remove(a.getID());
                                        }
                                }
                                break;
                            case "athlete":
                                if (ligneElems.length == 7) {
                                    try {
                                        int id = Integer.parseInt(ligneElems[0]);
                                        String nom = ligneElems[1];
                                        String prenom = ligneElems[2];
                                        char sexe = ligneElems[3].charAt(0);
                                        int agili = Integer.parseInt(ligneElems[4]);
                                        int endur = Integer.parseInt(ligneElems[5]);
                                        int force = Integer.parseInt(ligneElems[6]);
                                        try {
                                            at = new Athlete(id, nom, prenom, sexe, agili, endur, force);
                                            lesAthletes.add(at);
                                        } catch (Exception x) {
                                            System.err.println(x);
                                        }
                                    } catch (Exception e) {
                                        System.err.println(e);
                                    }

                                } else
                                    System.err.println("Pas le bon insert");
                                break;
                            case "sport":
                                if (ligneElems.length == 5) {
                                    try {
                                        String nom = ligneElems[0];
                                        int nb = Integer.parseInt(ligneElems[1]);
                                        Double agili = Double.parseDouble(ligneElems[2]);
                                        Double endur = Double.parseDouble(ligneElems[3]);
                                        Double force = Double.parseDouble(ligneElems[4]);
                                        try {
                                            sp = new Sport(nom, nb, agili, endur, force);
                                            lesSports.add(sp);
                                        } catch (Exception x) {
                                            System.err.println(x);
                                        }
                                    } catch (Exception e) {
                                        System.err.println(e);
                                    }

                                } else if (ligneElems.length == 6) {
                                    try {
                                        String nom = ligneElems[0];
                                        int nb = Integer.parseInt(ligneElems[1]);
                                        Double agili = Double.parseDouble(ligneElems[2]);
                                        Double endur = Double.parseDouble(ligneElems[3]);
                                        Double force = Double.parseDouble(ligneElems[4]);
                                        int rec = Integer.parseInt(ligneElems[5]);
                                        try {
                                            sp = new Sport(nom, nb, agili, endur, force, rec);
                                            lesSports.add(sp);
                                        } catch (Exception x) {
                                            System.err.println(x);
                                        }
                                    } catch (Exception e) {
                                        System.err.println(e);
                                    }
                                } else
                                    System.err.println("Pas le bon insert");
                                break;

                            default:
                                break;
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
