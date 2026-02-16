package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * Класс BankService описывает работу с пользователями банка и их счетами
 * * Функционал:
 * * _Добавление пользователя
 * * _Удаление пользователя по паспорту
 * * _Добавление счета пользователю
 * * _Поиск пользователя по паспорту
 * * _Поиск счета по реквизитам
 * * _Перевод денег между счетами
 * *
 * * В качестве хранилища используется Map, где:
 * * _ключ — объект {@link User},
 * * _значение — список его счетов {@link Account}.
 * *
 * * Сравнение пользователей происходит по полю passport,
 * * _так как в классе User переопределены equals() и hashCode().
 * *
 * * @author FSEtoIT
 * * @version 1.0
 */
public class BankService {

    /**
     * Хранилище пользователей банка.
     * Ключ — пользователь.
     * Значение — список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в систему.
     * Если пользователь с таким паспортом уже существует,
     * добавление не выполняется.
     *
     * @param user пользователь банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из системы по номеру паспорта.
     * Если пользователь не найден — операция игнорируется.
     *
     * @param passport номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, null)); //нам не важен юзернейм, поэтому нулл
    }

    /**
     * Добавляет новый счет пользователю.
     * Сначала выполняется поиск пользователя по паспорту.
     * Если пользователь найден и счет с такими реквизитами отсутствует —
     * счет добавляется.
     *
     * @param passport номер паспорта пользователя
     * @param account  добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Выполняет поиск пользователя по номеру паспорта.
     *
     * @param passport номер паспорта
     * @return найденный пользователь или null, если не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Выполняет поиск счета пользователя по реквизитам.
     * <p>
     * Сначала ищется пользователь по паспорту,
     * затем в списке его счетов выполняется поиск счета.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return найденный счет или null, если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Переводит денежные средства с одного счета на другой.
     * <p>
     * Перевод выполняется при выполнении следующих условий:
     * _оба счета существуют
     * _на исходном счете достаточно средств
     *
     * @param sourcePassport       паспорт отправителя
     * @param sourceRequisite      реквизиты счета отправителя
     * @param destinationPassport  паспорт получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount               сумма перевода
     * @return true — если перевод выполнен успешно,
     * false — если перевод невозможен
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {

        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);

        if (source == null || destination == null) {
            return false;
        }

        if (source.getBalance() < amount) {
            return false;
        }

        source.setBalance(source.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);

        return true;
    }

    /**
     * Возвращает список счетов пользователя.
     *
     * @param user пользователь
     * @return список счетов или null, если пользователь отсутствует
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}