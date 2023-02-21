import javax.swing.*;

class NumberG{

 public static void main(String [] arg){

    int CNumber=(int)(Math.random()*100+1);
    int userAns=0;
    int count =1;

    try{
         while(userAns!= CNumber){

         String response =JOptionPane.showInputDialog(null,"Enter the Number for guess between 1 and 100");
         userAns=Integer.parseInt(response);
         JOptionPane.showMessageDialog(null,""+determineGuess(userAns,CNumber,count));
         count++;
          }
       }catch(Exception e){

     }
 }

   public static String determineGuess(int userAns,int CNumber, int count)
   {
      if(userAns<=0 || userAns>100){
        return "Your Guess is invalid..";
      }else if(userAns==CNumber){
         return "correct! \n Total Guesses:"+count;
      }else if(userAns >CNumber){
         return "Your guess is higher , plz try again \n Try Number:"+count;
      }else if(userAns < CNumber){
         return "Your guess is lower , plz try again \n Try Number:"+count;
      }else {
         return "Sorry! your guess is incorrect! \n Try Number:"+count;
      }
  }

}