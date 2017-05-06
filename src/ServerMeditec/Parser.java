package ServerMeditec;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Parser {
      HashMap<Integer, Account> accounts = new HashMap<Integer,
Account>();
      public Parser() {
            Account anAccount = new Account(123,"savings", "xml",110.0);
            accounts.put(123, anAccount);
      }
      public List<Account> getAccounts() {
            List<Account> accountslist = new Vector<Account>();
            accountslist.addAll(accounts.values());
            return accountslist;
      }
      public Account get(int id) {
            return (Account) accounts.get(id);
      }
}