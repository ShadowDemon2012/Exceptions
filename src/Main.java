import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "Shadow";
        String password = "qwe_123";
        String confirmPassword = "qwe_123";
        System.out.println(acceptThreeParameters(login, password, confirmPassword));
    }

    public static boolean acceptThreeParameters(String login, String password, String confirmPassword) {
        boolean checkLogin;
        boolean checkPassword;
        boolean checkLengthPassword;
        boolean checkLoginLength;
        boolean checkPasswordMatch;
        try {
            checkLogin = checkValidationCharacter(login);
            checkPassword = checkValidationCharacter(password);
            checkLoginLength = checkLoginLength(login);
            checkLengthPassword = checkPasswordLength(password);
            checkPasswordMatch = checkPasswordMatch(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return checkLogin
                && checkPassword
                && checkLengthPassword
                && checkLoginLength
                && checkPasswordMatch;
    }

    public static boolean checkValidationCharacter(String checkWord) {
        if (checkWord == null) {
            throw new NullPointerException("Слово является null");
        }
        if (checkWord.matches("\\w+"))
            return true;
        System.out.println("Недопустимые символы в слове " + checkWord);
        return false;
    }

    public static boolean checkLoginLength(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        return true;
    }

    public static boolean checkPasswordLength(String password) {
        if (password.length() > 19) {
            throw new RuntimeException("Cлишком длинный пароль");
        }
        return true;
    }

    public static boolean checkPasswordMatch(String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) {
            return true;
        }
        throw new WrongPasswordException("пароли не совпадают");
    }
}