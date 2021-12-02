package dev.gerardo.behaviourals.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BankAccount {
  private int balance;
  private int overdraftLimit = -500;

  public void deposit(int amount) {
    balance += amount;
    System.out.println("Deposited " + amount + ", balance is now " + balance);
  }

  public boolean withDraw(int amount) {
    if (balance - amount >= overdraftLimit) {
      balance -= amount;
      System.out.println("Withdrew " + amount + ", balance is now " + balance);
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "BankAccount [balance=" + balance + "]";
  }
}

interface Command {
  void call();
  void undo();
}

class BankAccountCommand implements Command {
  private BankAccount account;
  private boolean succeeded;

  public enum Action {
    DEPOSIT, WITHDRAW;
  } 

  private Action action;
  private int amount;

  public BankAccountCommand(BankAccount account, Action action, int amount) {
    this.account = account;
    this.action = action;
    this.amount = amount;
  }

  @Override
  public void call() {
    switch(action) {
      case DEPOSIT:
        succeeded = true;
        account.deposit(amount);
        break;
      case WITHDRAW:
        succeeded = account.withDraw(amount);
        break;
    }    
  }

  @Override
  public void undo() {
    if (!succeeded) return;

    switch(action) {
      case DEPOSIT:
        succeeded = account.withDraw(amount);
        break;
      case WITHDRAW:
        account.deposit(amount);
        break;
    }  
  }

}

public class CommandDemo {
  public static void main(String[] args) {
    BankAccount bankAccount = new BankAccount();
    System.out.println(bankAccount);

    List<BankAccountCommand> commands = List.of(
      new BankAccountCommand(bankAccount, BankAccountCommand.Action.DEPOSIT, 1000),
      new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, 100)
    );

    for (Command c : commands) {
      c.call();
      System.out.println(bankAccount);      
    }

    Collections.reverse(commands);

    for (Command c : commands) {
      c.undo();
      System.out.println(bankAccount);
    }

  }
}
