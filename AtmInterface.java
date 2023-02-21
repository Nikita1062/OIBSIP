import java.util.Scanner;

class BankAccount {

      String name;
      String UName;
	String pass;
 	String accountNo;
      
      float balance =100000f;
      int transaction =0;
      String transactionHis="";

     public void Register(){
  
       Scanner sc = new Scanner(System.in);
       System.out.println(" Enter your name: ");
       this.name=sc.nextLine();
       System.out.println(" Enter your userName: ");
       this.UName=sc.nextLine();
	 System.out.println(" Enter your password: ");
       this.pass=sc.nextLine(); 
       System.out.println("Enter your Account Number: ");
       this.accountNo=sc.nextLine(); 
       
       System.out.println("...................................");
       System.out.println("Registration completed ...kindly login");
       System.out.println("...................................");
    }

    public boolean login(){
     
   		boolean isLogin=false;
            Scanner sc = new Scanner(System.in);
            while(!isLogin){
            System.out.println(" Enter your username : ");
            String username=sc.nextLine();
            if(username.equals(UName)){
              while(!isLogin){
                  System.out.println("Enter your password");
                  String Password = sc.nextLine();
                   if(Password.equals(pass)){
				System.out.println("Login Successful!!");
                        isLogin=true;
                    }
			 else{
                         System.out.println("Incorrect password..");
                    }
                }

            }
            else{
			 System.out.println("Username not found");
              }
           }
           return isLogin;         
    }

   
    public void withdraw(){
    
	System.out.println("Enter amount to withdraw :");
      Scanner sc= new Scanner(System.in);
      float amount=sc.nextFloat();
      try{

		if(balance >= amount){
			transaction++;
			balance-=amount;
			System.out.println("\n withdraw Successfully");
             	String str=amount+" Rs Withdrawed\n";
			transactionHis=transactionHis.concat(str);
             }
		 else{
           		 System.out.println("Insufficient Balance..");
              }

        }    
 	  catch(Exception e){
        }
      
     }

   public void Deposite(){

        System.out.println("Enter amount to deposite:");
        Scanner sc =new Scanner(System.in);
        float amount =sc.nextFloat();

         try{
		   if(amount<=100000f){
			transaction++;
                  balance+=amount;
                  System.out.println("\nSucessfully Deposited..");
                  String str=amount+"Rs deposited";
                  transactionHis=transactionHis.concat(str);

               }
               else{
			System.out.println("Sorry...limit is 100000.00");
                }
            }
          catch(Exception e){
          }
  
      }


   public void transfer(){

     		Scanner sc= new Scanner(System.in);
   	      System.out.println("Enetr Receipent's Name:");
            String recepient=sc.nextLine();
            System.out.println("Enter amount to transfer:");
            float amount=sc.nextFloat();

          try{
		    if(balance>=amount){
                   if (amount<=50000f){
                      transaction++;
                      balance-=amount;
                      System.out.println("Sucessfully transfered to -"+recepient);
                      String str=amount +"Rs transfered to"+recepient+"\n";
			    transactionHis=transactionHis.concat(str);

                      }
                      else{
			            System.out.println("Sorry...limit is 50000.00");
                          } 
                     }
                    else{
           		 System.out.println("Insufficient Balance..");
              }
          }
          catch(Exception e){
          }
  
   }

  public void checkBalance(){
	 System.out.println("Balance :"+balance+"Rs");
   } 

  public void transHistory(){
 
    if(transaction==0){
      System.out.println("Empty");
    }
    else{
       System.out.println(transactionHis);
     }

  }

}


class AtmInterface{

	public static int takeIntegerInput(int limit){
	 int input=0;
       boolean flag=false;
 
       while(!flag){
		
			Scanner sc=new Scanner(System.in);
  			input=sc.nextInt();
 			flag=true;
 
                  if(flag && input >limit || input < 1){
			  System.out.println("choose the number between 1 to "+limit);
			  flag=false;
                   }
             
         };
        return input; 
  }

  public static void main (String []arg){

    System.out.println("<<<<<<<<<<<<<<<< WELCOME TO SBI ATM SYSTEM >>>>>>>>>>>>>>>>>>>>");
    System.out.println("1.Register \t 2.Exit");
    System.out.println("Enter ur choice:");

    int choice =takeIntegerInput(2);

     if(choice==1){
       BankAccount b=new BankAccount();
       b.Register();

       while(true){
           System.out.println("1.login \t 2.Exit");
           System.out.println("Enter ur choice:");

            int ch =takeIntegerInput(2);
            if(ch==1){
              if(b.login()){
			System.out.println("<<<<<<<<<<< WELCOME BACK"+ b.name +">>>>>>>>>>>>>>");
			boolean isFinished=false;
			while(!isFinished){

			  System.out.println("1.Withdraw \n2.Deposite \n3.Transfer \n4.Check Balance \n5.Transaction history \n6.Exit ");
			  System.out.println("Enter ur choice :");
                    int c =takeIntegerInput(6);
                    switch(c){

       		      case 1:
				b.withdraw();
				break;
				case 2:

				b.Deposite();
				break;
                        case 3:
				b.transfer();
				break;
				case 4:
				b.checkBalance();
				break;
				case 5:
				b.transHistory();
				break;
				case 6:
				isFinished=true;
				break;
			     }

                    }

                 }

               }
               else{
                 System.exit(0);
                } 
            } 

        }
 	  else{
               System.exit(0);
              } 
     }
}
  

