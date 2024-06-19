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
        
        PreparedStatement ps2 = this.connexion.prepareStatement("insert into Athlete(id_Athlete, NomAt, PrenomAT, SexeAT, stats_Force, stats_Endurance, stats_agilite) values (?, ?, ?, ?, ?, ?, ?)");
        ps2.setInt(1, athlete.getID());
        ps2.setString(2, athlete.getNomA());
        ps2.setString(3, athlete.getPrenomA());
        ps2.setString(4, String.valueOf(athlete.getSexeA()));
        ps2.setInt(5, athlete.getForce());
        ps2.setInt(6, athlete.getEndurance());
        ps2.setInt(7, athlete.getAgilite());

        ps2.executeUpdate();
    }

    public void ajouteEquipe(Equipe equipe) throws SQLException {
        supprimerEquipe(equipe.getID());

        PreparedStatement ps2 = this.connexion.prepareStatement("insert into Equipe(id_Equipe, taille_equipe, medEquipe_or, medEquipe_arent, medEquipe_bronze, sexe_equipe) values (?, ?, ?, ?, ?, ?)");
        ps2.setInt(1, equipe.getID());
        ps2.setInt(2, equipe.getTaille());
        ps2.setInt(3, equipe.getNbMedailleOr());
        ps2.setInt(4, equipe.getNbMedailleArgent());
        ps2.setInt(5, equipe.getNbMedailleBronze());
        ps2.setString(6, String.valueOf(equipe.getSexeEquipe()));

        ps2.executeUpdate();
    }

    public void ajouteEpreuve(Epreuve epreuve) throws SQLException {
        supprimerEpreuve(epreuve.getID());

        PreparedStatement ps2 = this.connexion.prepareStatement("insert into Epreuve(id_Epreuve, nom_sport, nomEpreuve, categorieEpreuve, typeEpreuve, sexEpreuve, coefForce, coefEndurance, coefAgilite) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps2.setInt(1, epreuve.getID());
        ps2.setString(2, epreuve.getLeSports().getNomSport());
        ps2.setString(3, epreuve.getNomEpreuve());
        ps2.setString(4, epreuve.getCategorieEpreuve());
        ps2.setString(5, epreuve.getTypeEpreuve());
        ps2.setString(6, String.valueOf(epreuve.getSexeEpreuve()));
        ps2.setFloat(7, epreuve.getValeurForce().floatValue());
        ps2.setFloat(8, epreuve.getValeurEndurance().floatValue());
        ps2.setFloat(9, epreuve.getValeurAgilite().floatValue());
        
        ps2.executeUpdate();
    }

    public void ajoutePays(Pays pays) throws SQLException {
        supprimerPays(pays.getNompays());

        PreparedStatement ps2 = this.connexion.prepareStatement("insert into Pays(nom_pays, medpays_or, medapays_argent, medpays_bronze) values (?, ?, ?, ?)");

        ps2.setString(1, pays.getNompays());
        ps2.setInt(2, pays.getmedailles_or());
        ps2.setInt(3, pays.getmedailles_argent());
        ps2.setInt(4, pays.getmedailles_bronze());

        ps2.executeUpdate();
    }

    public void ajouteSport(Sport sport) throws SQLException {
        supprimerSport(sport.getNomSport());

        PreparedStatement ps2 = this.connexion.prepareStatement("insert into Sport(nom_sport, nb_joueur) values (?, ?)");

        ps2.setString(1, sport.getNomSport());
        // ps2.setInt(2, sport.get);
        ps2.executeUpdate();
    }



    
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
}
