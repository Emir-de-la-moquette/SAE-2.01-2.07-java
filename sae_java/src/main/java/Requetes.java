import java.sql.*;

public class Requetes {
    private ConnexionMySql connexion;
    private Statement st;

    public Requetes() throws ClassNotFoundException, SQLException {
        this.connexion = new ConnexionMySql();
    }

    public void ajouterAthlete(Athlete athlete) throws SQLException {
        //supprimerAthlete(athlete.getID());
        
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
}
