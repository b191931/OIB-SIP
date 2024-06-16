public class ATM {
    private Account[] accounts;
    private Account currentAccount;

    public ATM() {
        accounts = new Account[1];
        accounts[0] = new Account("user1", "1234", 1000.0);
    }

    public boolean authenticateUser(String userId, String userPin) {
        for (Account account : accounts) {
            if (account.getUserId().equals(userId) && account.validatePin(userPin)) {
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    public void showTransactionHistory() {
        currentAccount.printTransactionHistory();
    }

    public void withdraw(double amount) {
        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        currentAccount.deposit(amount);
        System.out.println("Deposit successful.");
    }

    public void transfer(String recipientId, double amount) {
        Account recipientAccount = findAccountById(recipientId);
        if (recipientAccount != null) {
            if (currentAccount.withdraw(amount)) {
                recipientAccount.deposit(amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Recipient account not found.");
        }
    }

    private Account findAccountById(String userId) {
        for (Account account : accounts) {
            if (account.getUserId().equals(userId)) {
                return account;
            }
        }
        return null;
    }
}