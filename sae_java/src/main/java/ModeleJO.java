public class ModeleJO {
    private User utilisateur;
    private AppJDBC jdbc;



    ////////////////////////////////////////
    // GESTION DE L'UTILISATEUR

    public void createUser() throws IdentifiantNonValideException, MDPNonValideException, CLENonValideException{
        String resTxtFieldID;
        String resTxtFieldMDP;
        String cleActivation;
        char roleChoisit;


        resTxtFieldID = "nig@gmail.com";
        resTxtFieldMDP = "QuoicouFeur69";
        cleActivation = "123";
        roleChoisit = 'V';

        if(!User.mailConforme(resTxtFieldID)) throw new IdentifiantNonValideException("l'adresse mail n'est pas conforme");
        if(resTxtFieldMDP.length()<6) throw new MDPNonValideException("Le mot de passe doit faire au minimum 6 caractères");

        if(!cleActivation.equals("") && cleActivation!=null && roleChoisit!='v'){
            if(!jdbc.cleExiste(cleActivation)){
                throw new CLENonValideException("Cette clé d'activation n'existe pas, si vous pensez que c'est une erreur merci de nous conctacter");
            }
        }
        String mdp = User.crypteMDP(resTxtFieldMDP);
        utilisateur = new User(resTxtFieldID, mdp, roleChoisit);
        jdbc.newUser(utilisateur);
    }

    public void connexionUser() throws IdentifiantNonValideException, MDPNonValideException{
        String resTxtFieldID;
        String resTxtFieldMDP;

        resTxtFieldID = "nig@gmail.com";
        resTxtFieldMDP = "QuoicouFeur69";

        if(!jdbc.mailExiste()) throw new IdentifiantNonValideException("Cette adresses mail n'existe pas !");
        if(!jdbc.getMDP(resTxtFieldID).equals(resTxtFieldMDP)) throw new MDPNonValideException("Votre mot de passe est incorrect !");

        utilisateur = new User(resTxtFieldID, resTxtFieldMDP, jdbc.getRole(resTxtFieldID));
    }

    public void deconnecter(){
        utilisateur = null;
    }

    public void modifierMDP(String newMDP) throws MDPNonValideException{
        if(newMDP.length()<6) throw new MDPNonValideException("Le mot de passe doit faire au minimum 6 caractères");
        User editedUser = utilisateur;
        editedUser.setMdp(newMDP);
        jdbc.editUser(utilisateur, editedUser);
        utilisateur = editedUser;
    }

    /////////////////



}
