import java.sql.*;

public class Requetes {
    private ConnexionMySQL connexion;
    private Statement st;

    public Requetes() throws ClassNotFoundException, SQLException {
        this.connexion = new ConnexionMySQL();
        this.connexion.connecter();
    }

    public void ajouterAthlete(Athlete athlete) throws SQLException {

        supprimerAthlete(athlete.getID());
        
        PreparedStatement ps = this.connexion.prepareStatement("insert into Athlete(id_Athlete, NomAt, PrenomAT, SexeAT, stats_Force, stats_Endurance, stats_agilite) values (?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, athlete.getID());
        ps.setString(2, athlete.getNomA());
        ps.setString(3, athlete.getPrenomA());
        ps.setString(4, String.valueOf(athlete.getSexeA()));
        ps.setInt(5, athlete.getForce());
        ps.setInt(6, athlete.getEndurance());
        ps.setInt(7, athlete.getAgilite());

        ps.executeUpdate();
    }

    public void ajouterEquipe(Equipe equipe) throws SQLException {
        supprimerEquipe(equipe.getID());

        PreparedStatement ps = this.connexion.prepareStatement("insert into Equipe(id_Equipe, taille_equipe, medEquipe_or, medEquipe_arent, medEquipe_bronze, sexe_equipe) values (?, ?, ?, ?, ?, ?)");
        ps.setInt(1, equipe.getID());
        ps.setInt(2, equipe.getTaille());
        ps.setInt(3, equipe.getNbMedailleOr());
        ps.setInt(4, equipe.getNbMedailleArgent());
        ps.setInt(5, equipe.getNbMedailleBronze());
        ps.setString(6, String.valueOf(equipe.getSexeEquipe()));

        ps.executeUpdate();
    }

    public void ajouterEpreuve(Epreuve epreuve) throws SQLException {
        supprimerEpreuve(epreuve.getID());

        PreparedStatement ps = this.connexion.prepareStatement("insert into Epreuve(id_Epreuve, nom_sport, nomEpreuve, categorieEpreuve, typeEpreuve, sexEpreuve, coefForce, coefEndurance, coefAgilite) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, epreuve.getID());
        ps.setString(2, epreuve.getLeSports().getNomSport());
        ps.setString(3, epreuve.getNomEpreuve());
        ps.setString(4, epreuve.getCategorieEpreuve());
        ps.setString(5, epreuve.getTypeEpreuve());
        ps.setString(6, String.valueOf(epreuve.getSexeEpreuve()));
        ps.setFloat(7, epreuve.getValeurForce().floatValue());
        ps.setFloat(8, epreuve.getValeurEndurance().floatValue());
        ps.setFloat(9, epreuve.getValeurAgilite().floatValue());
        
        ps.executeUpdate();
    }

    public void ajouterPays(Pays pays) throws SQLException {
        supprimerPays(pays.getNompays());

        PreparedStatement ps = this.connexion.prepareStatement("insert into Pays(nom_pays, medpays_or, medapays_argent, medpays_bronze) values (?, ?, ?, ?)");

        ps.setString(1, pays.getNompays());
        ps.setInt(2, pays.getmedailles_or());
        ps.setInt(3, pays.getmedailles_argent());
        ps.setInt(4, pays.getmedailles_bronze());

        ps.executeUpdate();
    }

    public void ajouterSport(Sport sport) throws SQLException {
        supprimerSport(sport.getNomSport());

        PreparedStatement ps = this.connexion.prepareStatement("insert into Sport(nom_sport, nb_joueur) values (?, ?)");

        ps.setString(1, sport.getNomSport());
        // ps.setInt(2, sport.get);
        ps.executeUpdate();
    }

    public void ajouterJO(JeuxOlympique jo) throws SQLException {
        supprimerJO(jo.getNom());

        PreparedStatement ps = this.connexion.prepareStatement("insert into JeuxOlympique(nomJO, lieu, annee) values (?, ?, ?)");

        ps.setString(1, jo.getNom());
        ps.setString(2, jo.getLieu());
        ps.setInt(3, jo.getAnnee());
        ps.executeUpdate();
    }




    public void supprimerAthlete(int idAthlete) throws SQLException {
        equipeSupprimeAthlete(idAthlete);

        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Athlete where id_Athlete = " + idAthlete);
        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Athlete where id_Athlete = " + idAthlete);
            ps.executeUpdate();
        }
    }

    public void supprimerEquipe(int idEquipe) throws SQLException {
        paysSupprimeEquipe(idEquipe);

        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Equipe where id_Equipe = " + idEquipe);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Equipe where id_Equipe = " + idEquipe);
            ps.executeUpdate();
        }
    }

    public void supprimerEpreuve(int idEpreuve) throws SQLException {
        joSupprimeEpreuve(idEpreuve);

        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Epreuve where id_Epreuve = " + idEpreuve);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Epreuve where id_Epreuve = " + idEpreuve);
            ps.executeUpdate();
        }
    }

    public void supprimerPays(String nomPays) throws SQLException {
        joSupprimePays(nomPays);

        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Pays where nom_pays = " + nomPays);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Pays where nom_pays = " + nomPays);
            ps.executeUpdate();
        }
    }

    public void supprimerSport(String nomSport) throws SQLException {
        epreuveSupprimeSport(nomSport);
        joSupprimeSport(nomSport);
        
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Sport where nom_sport = " + nomSport);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Sport where nom_sport = " + nomSport);
            ps.executeUpdate();
        }
    }

    public void supprimerJO(String nomJO) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from JeuxOlympique where nomJO = " + nomJO);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from JeuxOlympique where nomJO = " + nomJO);
            ps.executeUpdate();
        }
    }



    // public Map<String, Integer> triPaysParOr() throws SQLException {
    //     Map<String, Integer> mapPays = new HashMap<>();
    //     this.st = this.connexion.createStatement();
    //     ResultSet rs = this.st.executeQuery("select nom_pays, medpays_or from Pays order by medpays_or");

    //     while (rs.next()) {
    //         String nomPays = rs.getString(1);
    //         Integer nbOr = rs.getInt(2);
    //         mapPays.put(nomPays, nbOr);
    //     }

    //     return mapPays;
    // }






    public void equipeAjouteAthlete(int idEquipe, int idAthlete) throws SQLException {
        PreparedStatement ps = this.connexion.prepareStatement("insert into ContenirEQ_ATH(id_Athlete, id_Equipe) values (?, ?)");
        ps.setInt(1, idAthlete);
        ps.setInt(2, idEquipe);
        ps.executeUpdate();
    }

    public void joAjouteSport(String nomJO, String nomSport) throws SQLException {
        PreparedStatement ps = this.connexion.prepareStatement("insert into ContenirJO_SP(nomJO, nom_sport) values (?, ?)");
        ps.setString(1, nomJO);
        ps.setString(2, nomSport);
        ps.executeUpdate();
    }

    public void joAjouteEpreuve(String nomJO, int idEpreuve) throws SQLException {
        PreparedStatement ps = this.connexion.prepareStatement("insert into ContenirJO_EP(nomJO, id_Epreuve) values (?, ?)");
        ps.setString(1, nomJO);
        ps.setInt(2, idEpreuve);
        ps.executeUpdate();
    }

    public void joAjoutePays(String nomJO, String nomPays) throws SQLException {
        PreparedStatement ps = this.connexion.prepareStatement("insert into ContenirJO_PAYS(nomJO, nom_pays) values (?, ?)");
        ps.setString(1, nomJO);
        ps.setString(2, nomPays);
        ps.executeUpdate();
    }

    public void paysAjouteEquipe(String nomPays, int idEquipe) throws SQLException {
        PreparedStatement ps = this.connexion.prepareStatement("insert into ContenirPAYS_EQ(id_Equipe, nom_pays) values (?, ?)");
        ps.setInt(1, idEquipe);
        ps.setString(2, nomPays);
        ps.executeUpdate();
    }

    public void epreuveAjouteSport(int idEpreuve, String nomSport) throws SQLException {
        PreparedStatement ps = this.connexion.prepareStatement("insert into ContenirEP_SP(id_Epreuve, nom_sport) values (?, ?)");
        ps.setInt(1, idEpreuve);
        ps.setString(2, nomSport);
        ps.executeUpdate();
    }


    public void equipeSupprimeAthlete(int idAthlete) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from ContenirEQ_ATH where id_Athlete = " + idAthlete);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from ContenirEQ_ATH where id_Athlete = " + idAthlete);
            ps.executeUpdate();
        }
    }

    public void joSupprimeSport(String nomSport) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from ContenirJO_SP where nom_sport = " + nomSport);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from ContenirJO_SP where nom_sport = " + nomSport);
            ps.executeUpdate();
        }
    }

    public void joSupprimeEpreuve(int idEpreuve) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from ContenirJO_EP where id_Epreuve = " + idEpreuve);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from ContenirJO_EP where id_Epreuve = " + idEpreuve);
            ps.executeUpdate();
        }
    }

    public void joSupprimePays(String nomPays) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from ContenirJO_PAYS where nom_pays = " + nomPays);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from ContenirJO_PAYS where nom_pays = " + nomPays);
            ps.executeUpdate();
        }
    }

    public void paysSupprimeEquipe(int idEquipe) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from ContenirPAYS_EQ where id_Equipe = " + idEquipe);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from ContenirPAYS_EQ where id_Equipe = " + idEquipe);
            ps.executeUpdate();
        }
    }

    public void epreuveSupprimeSport(String nomSport) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from ContenirEP_SP where nom_sport = " + nomSport);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from ContenirEP_SP where nom_sport = " + nomSport);
            ps.executeUpdate();
        }
    }
}
