
import java.sql.*;
import java.util.ArrayList;

public class Requetes {
    private ConnexionMySql connexion;
    private Statement st;

    public Requetes( ConnexionMySql co) throws ClassNotFoundException, SQLException {
        this.connexion = co;
    }
    public int getIdMax(){
        // requete select max(id_Athlete) from Athlete; 
        
        return 1;
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

    public void ajouterEquipe(Equipe equipe) throws SQLException {

        PreparedStatement ps = this.connexion.prepareStatement("insert into Equipe(id_Equipe, taille_equipe, medEquipe_or, medEquipe_arent, medEquipe_bronze, sexe_equipe) values (?, ?, ?, ?, ?, ?)");
        ps.setInt(1, equipe.getID());
        ps.setInt(2, equipe.getTaille());
        ps.setInt(3, equipe.getNbMedailleOr());
        ps.setInt(4, equipe.getNbMedailleArgent());
        ps.setInt(5, equipe.getNbMedailleBronze());
        ps.setString(6, String.valueOf(equipe.getSexeEquipe()));

        ps.executeUpdate();
    }

}
