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

    // public void ajouterMatch(Match match) throws SQLException {
    //     supprimerMatch(match.getID());
    // }




    public void supprimerAthlete(int idAthlete) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Athlete where id_Athlete = " + idAthlete);
        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Athlete where id_Athlete = " + idAthlete);
            ps.executeUpdate();
        }
    }

    public void supprimerEquipe(int idEquipe) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Equipe where id_Equipe = " + idEquipe);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Equipe where id_Equipe = " + idEquipe);
            ps.executeUpdate();
        }
    }

    public void supprimerEpreuve(int idEpreuve) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Epreuve where id_Epreuve = " + idEpreuve);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Epreuve where id_Epreuve = " + idEpreuve);
            ps.executeUpdate();
        }
    }

    public void supprimerPays(String nomPays) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Pays where nom_pays = " + nomPays);

        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Pays where nom_pays = " + nomPays);
            ps.executeUpdate();
        }
    }

    public void supprimerSport(String nomSport) throws SQLException {
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
            PreparedStatement ps = this.connexion.prepareStatement("delete from JeuxOlympique = " + nomJO);
            ps.executeUpdate();
        }
    }

    // public void supprimerMatch(String nomMatch) throws SQLException {
    //     this.st = this.connexion.createStatement();
    //     ResultSet rs = this.st.executeQuery("select * from Matchs where nom_Match = " + nomMatch);

    //     if (rs.next()) {
    //         PreparedStatement ps = this.connexion.prepareStatement("delete from Matchs where nom_Match = " + nomMatch);
    //         ps.executeUpdate();
    //     }
    // }
}
