public class ModeleJO {
    private User utilisateur;
    private AppJDBC jdbc;





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
    }
}
