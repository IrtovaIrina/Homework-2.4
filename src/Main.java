public class Main {
    public static void main(String[] args) {
        doUser("sdfiu5624396","gdsfil6","gdsfil6");

    }
    public static boolean doUser( String login,String password,String confirmPassword){
        try{
            checkLogin(login);
            checkConfirmPasswordAndPassword(password,confirmPassword);
            return true;
        }
        catch (WrongLoginException e){
            System.out.println("Ошибка в вводе логина");
            return false;
        }
        catch (WrongPasswordException e){
            System.out.println("Ошибка в вводе пароля");
            return false;
        }
    }
    public static void checkLogin(String login) throws WrongLoginException{
        if (!checkAlphabet(login) || login.length() > 20) {
            throw new WrongLoginException();
        }
    }

    public static void checkConfirmPasswordAndPassword (String login, String confirmPassword) throws WrongPasswordException{
        if (((!checkAlphabet(login)) || login.length() >= 20 || !login.equals(confirmPassword))) {
            throw new WrongPasswordException();
        }
    }
    public static boolean checkAlphabet(String string){
        char[] stringArray = string.toCharArray();
        String alphabet = "123456789qwertyuiopasdfghjklzxcvbnm_";
        boolean bool;
        for (char ch : stringArray){
            bool = alphabet.indexOf(ch) == -1 ?  false : true;
            if (bool == false) return false;
        }
        return true;
    }
}