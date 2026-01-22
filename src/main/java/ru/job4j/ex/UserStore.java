package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login)
            throws UserNotFoundException {

        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException(
                "User with login '" + login + "' not found"
        );
    }

    public static boolean validate(User user)
            throws UserInvalidException {

        if (!user.isValid()) {
            throw new UserInvalidException(
                    "User is not valid"
            );
        }

        if (user.getUsername().length() < 3) {
            throw new UserInvalidException(
                    "User length must be >3 symbols"
            );
        }
        return true;
    }

    public static void main(String[] args) {

        User[] users = {
                new User("Petr Arsentev", true)
        };

        try {
            User user = findUser(users, "Petr Arsentev");
            validate(user);
            System.out.println("Пользователь валидный");
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный");
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден");
        }
    }
}