import java.sql.*;

public class Requetes {
    private ConnexionMySQL connexion;
    private Statement st;

    public Requetes() throws ClassNotFoundException, SQLException {
        this.connexion = new ConnexionMySQL();
        this.connexion.connecter();
    }

    public void ajouterAthlete(Athlete athlete) throws SQLException {
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Athlete where id_Athlete = " + athlete.getID());
        if (rs.next()) {
            PreparedStatement ps = this.connexion.prepareStatement("delete from Athlete where id_Athlete = " + athlete.getID());
            ps.execute();
        }
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
        this.st = this.connexion.createStatement();
        ResultSet rs = this.st.executeQuery("select * from Equipe where id_Equipe = " + equipe.getID());

        PreparedStatement ps = this.connexion.prepareStatement("insert into Equipe(id_Equipe, nom_sport, taille_equipe, medEquipe_or, medEquipe_arent, medEquipe_bronze, sexe_equipe) values (?, ?, ?, ?, ?, ?)");
        ps.setInt(1, equipe.getID());
        ps.setInt(2, equipe.getTaille());
        ps.setInt(3, equipe.getNbMedailleOr());
        ps.setInt(4, equipe.getNbMedailleArgent());
        ps.setInt(5, equipe.getNbMedailleBronze());
        ps.setString(6, String.valueOf(equipe.getSexeEquipe()));

        ps.executeUpdate();
    }

    // public void 
}
