package Homework;

import java.util.*;

class Account{
    int id;
    String ownerName;
    double balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
    void getAccount(){

    }
}
public class Account_System {
    //acc id owner balance
    //add acc add edit remove show
    //show account information
    // 1 . descending order by account_id
    // 2.  ascending order by account_id
    // 3. descendinder order by balance
    public static void main(String[] args) {
        int option;
        List<Account> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1: Add account");
            System.out.println("2: Remove Account ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Show account information");
            System.out.println("5. Exit ");
            System.out.println("Choose option ( 1 - 5 ) : ");
            System.out.println("============================== Input Your Option ============================");
            System.out.print("Here: ");
            option  = input.nextInt();

            switch (option){
                case  1 :
                    // enter account information
                    // object add list
                    //accountList.add();
                    System.out.println("Enter your account information :");
                    Account acc = new Account();
                    System.out.print("Input ID:");
                    acc.id = input.nextInt();
                    System.out.print("Name:");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print("Balance:");
                    acc.balance = input.nextInt();

                    accountList.add(acc);
                    //Iterator<String> i = accountList.iterator();

                    break;
                case 2 :
                    System.out.println("Remove account by Id");
                    System.out.println("Enter Id for deleted :");
                    int idfordeleted = input.nextInt();
                    System.out.println(idfordeleted);
                    boolean isFound = false;

                    for (int i=0 ; i<accountList.size();i++) {

                        if (accountList.get(i).id== idfordeleted) {
                            accountList.remove(i);
                            isFound = true;
                        }
                    }


                    if (!isFound) {
                        System.out.println("ID is not found!!");
                    }
                    break;
                case 3 :
                    System.out.println("Edit Account ");
                    System.out.println("Enter Id for update :");
                    int idforUpdate = input.nextInt();
                    boolean isCheck = false;
                    if(accountList.size()>0) {
                        for (Account account : accountList) {


                            if (account.id == idforUpdate) {
                                System.out.println("Enter the new Owner :");
                                account.ownerName = input.next();
                                System.out.println("Enter the new Balance :");
                                account.balance = input.nextDouble();
                                isCheck = true;
                            }
                        }
                    }
                    if(!isCheck) System.out.println("There is no data for update!!");
                    break;
                case 4 :
                    int showOption ;
                    System.out.println("Show account information");
                    System.out.println("1. Ascending order (by ID )");
                    System.out.println("2. Descending order (by ID) ");
                    System.out.println("3. Descending order by balance ");

                    System.out.println("Choose show option : ");
                    System.out.println("==========================================================");
                    showOption =  input.nextInt();
                    List<Account> Collection = new ArrayList<>();
                    for (Account sort : accountList) {Collection.add(sort);
                    }
                    switch (showOption){
                        case 1:
                            System.out.println("Sort Ascending by Id");
                            Collections.sort(accountList, new Comparator<Account>() {
                                @Override
                                public int compare(Account acc_first, Account acc_second) {
                                    return (Integer.compare(acc_first.id,acc_second.id));
                                }
                            });
                            for (Account account: accountList
                            ) {
                                System.out.println(account);
                            }


                            break;
                        case 2:
                            System.out.println("Sort Descending by Id");
                            Collections.sort(accountList, new Comparator<Account>(){
                                @Override
                                public int compare(Account acc_first, Account acc_second) {
                                    return (Integer.compare(acc_second.id,acc_first.id));
                                }
                            });
                            for (Account account: accountList
                            ) {
                                System.out.println(account);
                            }
                            break;
                        case 3:
                            System.out.println(" Descending Balance");
                            Collections.sort(accountList, new Comparator<Account>(){
                                @Override
                                public int compare(Account acc_first, Account acc_second) {
                                    return (Integer.compare((int) acc_second.balance,(int)acc_first.balance));
                                }
                            });
                            for (Account account: accountList
                            ) {
                                System.out.println(account);
                            }
                            break;
                    }
                    break;
                case 5 :
                    System.out.println("Exit the program....!")
                    ;break;

            }
        }while(option  !=5);

    }
}