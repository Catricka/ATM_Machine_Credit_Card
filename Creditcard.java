import java.util.Scanner;

public class Creditcard {
//input members
	private String Cardowner;
	private String Cardnumber;
	private double CashLimit;
	private static double Accountbalance;
	private static int Cardpassword;
	
	//constructors
	public Creditcard(String name,String card)
	{
		Cardowner=name;
	    Cardnumber=card;
	    CashLimit=2000000; //200000 Toman
	    Accountbalance=10000000;
	}
	//functions for returning card information
	public String Getname()
	{ 
	return Cardowner;
	}
	public String Getcreditcardnumber()
	{
		return Cardnumber;
	}
	public double GetcashLimit()
	{
		return CashLimit;
	}
	public double Getbalance()
	{
		return Accountbalance;
	}
	
	public int Getpassword()
	{
		return Cardpassword;
	}
	public int Setpassword(int password)
	{
		Cardpassword=password;
		return Cardpassword;
	}
	public int SetNewpassword(int password)
	{
		
		return password;
	}
	
	//checking methods
	public boolean CardValidation(String c)
	{
		if(c.length()==16)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	
	}
	
	public boolean PasswordValidation(int p)
	{
		int intLength= (int)(Math.log10(p)+1);
		if(intLength==4)
		{
			Cardpassword=intLength;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean Purchase(double cost)
	{
		if(cost<Accountbalance)
		{
			Accountbalance=(Accountbalance-cost);
			 return true;
			
		}
		
		else {
			return false;
		}
		
	}
	public void IncreaseCashLimit()
	{
		CashLimit=CashLimit+500000; 
		 //adds 50000 Toman everytime called
		
	}
	
	public boolean ChangePassword(int New)
	{
		int NewPassword= (int)(Math.log10(New)+1);
	
			if(NewPassword==4 && reEnterPassword(New))
			{
			return true;
			}
		
		else 
		{
			System.out.println("Invalid password. it should contain 4 digits.");
			return false;
		}
		
	}
	
	public boolean reEnterPassword(int password)
	{
		System.out.println("reEnter your password");
		Scanner rnpw=new Scanner(System.in);
		int renewpw=rnpw.nextInt();
		
		if(password==renewpw)
		{
			
			Setpassword(password);
			System.out.println("Your Password is changed.");
		return true;
		}
		
		else {
			System.out.println("They don't match.try again!");
			return false;
		}
		
	}
	
	public  void IncreaseAccountbalance(double IncreaseAmount)
	{
		Accountbalance=(Accountbalance+IncreaseAmount); 
		 //adds money to account
		
	}
	
	public void SMSTax()
	{
		Accountbalance=Accountbalance-50000; //decreases 5000 Toman
	}
	
	public boolean PayBill(double Bill)
	{
		if(Bill<Accountbalance)
		{
			Accountbalance=(Accountbalance-Bill);
			 return true;
			
		}
		
		else {
			return false;
		}
		
	}

	public boolean GettingCash(double cash)
	{
		if(cash<Accountbalance && cash<CashLimit)
		{
			Accountbalance=(Accountbalance-cash);
			 return true;
			
		}
		
		else {
			return false;
		}
		
	}
	
	
	public static void main(String[] args)
	{
		
		System.out.println("Insert your name");
		Scanner s=new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("Insert your CardNumber");
		Scanner cn=new Scanner(System.in);
		String cardnum=cn.nextLine();
		 Creditcard cc = new Creditcard(name,cardnum);
		 if( !cc.CardValidation(cardnum) )
 	    { 
        	System.out.println("invalid card" );
        	for (int j=0;j<3;j++)
        	{
        		if(j==2)
          		{
          		System.out.println("access denied.");
        		System.exit(1);
        		}
        		System.out.println("reEnter CardNumber");
        		Scanner cn3=new Scanner(System.in);
        		String cardnum3=cn3.nextLine();
        	
        		if (cc.CardValidation(cardnum3))
        		{
        			break;
        		}
        	}// end of for
       
        	
        	} //end of if
       
    	System.out.println("Insert your password");
		Scanner pw=new Scanner(System.in);
		int password=pw.nextInt();
	cc.Setpassword(password);
		
      if (!cc.PasswordValidation(password) )
      {  	
    	  System.out.println("invalid password" );
    	  for(int i=0;i<3;i++)
    	  {
    		  if(i==2)
        		{
        		System.out.println("access denied.");
      		System.exit(1);
      		}
      		System.out.println("reEnter password");
      		Scanner pw2=new Scanner(System.in);
      		int password2=pw2.nextInt();
      		
      		
      		if(cc.PasswordValidation(password2))
      		{
      			break;
      		}
      		
    	  }//end of for
    	  
      		
      	}//end of if
      	
    
        System.out.println("welcome "+name+ "! " );
    	cc.Getname();
		cc.Getcreditcardnumber();
		cc.GetcashLimit();
		cc.Getbalance();
		cc.Getpassword();
        
     while(true)  { 
       System.out.println("This is the menu of what you can do: "
       		+ "\n"
       		+ "Enter 1 for making purchases/Transfering money to another Account"
       		+ "\n"
       		+ "Enter 2 for paying bills"
       		+ "\n"
       		+ "Enter 3 for Increasing cash limit (everytime increases 500000 Rial)"
       		+ "\n"
       		+ "Enter 4 for adding money to your account"
       		+ "\n"
       		+ "Enter 5 for getting cash money"
       		+ "\n"
       		+ "Enter 6 for changing your password"
       		+ "\n"
       		+ "Enter 7 for getting your receipt"
       		+ "\n"
       		+ "Enter 8 for exitting");
       Scanner ch=new Scanner(System.in);
		int choice=ch.nextInt();
		switch(choice)
		{
		case 1:
		{	System.out.println("Enter destination card number");
			Scanner cn2=new Scanner(System.in);
			String cardnum2=cn2.nextLine();
			if(!cc.CardValidation(cardnum2))
			{ System.out.println("Invalid Destination Card");
			}
			else {
				
			System.out.println("Enter money amount ");
			Scanner co=new Scanner(System.in);
			double cost=co.nextDouble();
			
			System.out.println("Is your Destination Card number " + cardnum2 + " ? Y/N");
			Scanner qu=new Scanner(System.in);
			String ques=qu.nextLine();
			switch(ques)
			{
			case "N":
			case "n":
				
				
				System.out.println("reEnter? Y/N");
				Scanner qu2=new Scanner(System.in);
				String ques2=qu2.nextLine();
				switch(ques2)
				{
				case "N":
				case "n":
					break;
				
				case "Y":
				case "y":
					System.out.println("Enter destination card number");
					Scanner cn4=new Scanner(System.in);
					String cardnum4=cn4.nextLine();
					if(!cc.CardValidation(cardnum4))
					{ System.out.println("Invalid Destination Card");
					}
					else {
						
					System.out.println("Enter money amount ");
					Scanner co1=new Scanner(System.in);
					double cost1=co.nextDouble();
					if( cc.Purchase(cost1) )
					{
						System.out.println("successfully transfered ");
						
				}
					else
					{
						System.out.println("you don't have enough money to this action ");
					}
					}
					break;
				default :
					System.out.println("Invalid choice"); 
					break;
				
			}// end of switch
				break;
			case "Y":
			case "y":
				
			if( cc.Purchase(cost) )
			{
				System.out.println("successfully transfered ");
				
		}
		
			else
			{
				System.out.println("you don't have enough money to this action ");
			}
		
		
		break;
			
		default :
			System.out.println("Invalid choice"); 
		}  
		} 
			break;
		}
		
		case 2:
		{	
				
			System.out.println("Enter bill amount ");
			Scanner bi=new Scanner(System.in);
			double bill=bi.nextDouble();
			
			System.out.println("Is your bill amount " + bill + " ? Y/N");
			Scanner qu3=new Scanner(System.in);
			String ques3=qu3.nextLine();
			switch(ques3)
			{
			case "N":
			case "n":
				
				
				System.out.println("reEnter? Y/N");
				Scanner qu4=new Scanner(System.in);
				String ques4=qu4.nextLine();
				switch(ques4)
				{
				case "N":
				case "n":
					break;
				
				case "Y":
				case "y":
						
					System.out.println("Enter money amount ");
					Scanner bi1=new Scanner(System.in);
					double bill1=bi1.nextDouble();
					if( cc.PayBill(bill1) )
					{
						System.out.println("successfully paid Bill");
						
				}
					else
					{
						System.out.println("you don't have enough money to this action ");
					}
					
					break;
				default :
					System.out.println("Invalid choice"); 
					break;
				
			}// end of switch ques4
				break;
			case "Y":
			case "y":
				
			if( cc.PayBill(bill) )
			{
				System.out.println("successfully paid Bill ");
				
		}
		
			else
			{
				System.out.println("you don't have enough money to this action ");
			}
		
		
		break;
			
		default :
			System.out.println("Invalid choice"); 
			break;
		} //end of switch ques3  
			break;
		} //end case 2
		case 3:
		{
		cc.IncreaseCashLimit();
		System.out.println("you can now get " + cc.GetcashLimit() + " Rial cash at most ");
		
		}
		break;
		case 4:
		{
			System.out.println("Enter the amount you want to add ");
			Scanner ia=new Scanner(System.in);
			double IncAmount=ia.nextDouble();
			System.out.println("do you want to add " + IncAmount + " Rial to your account ? Y/N");
			Scanner qu6=new Scanner(System.in);
			String ques6=qu6.nextLine();
			switch(ques6)
			{
			case "Y":
			case "y":
				cc.IncreaseAccountbalance(IncAmount);
				System.out.println("Successfully added ");
				break;
			case "n":
			case "N":
				System.out.println("returning to menu");
				break;
				default:
					System.out.println("wrong choice");
			}
			
		}
		break;
		
		case 5:
			
		{
			System.out.println("Enter the money amount you want ");
			Scanner ca=new Scanner(System.in);
			double cash=ca.nextDouble();
			
			
				System.out.println("are you sure? Y/N");
				Scanner qu5=new Scanner(System.in);
				String ques5=qu5.nextLine();
				switch (ques5)
				{ 
				case "y":
				case "Y":
					if( cc.GettingCash(cash) )
					{
					System.out.println("pick up your money ");
					}
					else 
					{
						System.out.println("you don't have enough money to this action or you entered the amount out of your cash limit");
					}
					break;
				case "n":
				case "N":
					System.out.println("returning to menu");
					break;
					default:
						System.out.println("wrong choice");
				}
				
				
		
		} // end of case 5
		break;
		
		case 6:
		{
			System.out.println("Enter old password");
			Scanner opw=new Scanner(System.in);
			int oldpw=opw.nextInt();
			if(oldpw==cc.Setpassword(password))
				
			{
				System.out.println("Enter new password");
				Scanner npw=new Scanner(System.in);
				int newpw=npw.nextInt();
				if(cc.ChangePassword(newpw))
				{
					password=newpw;
				}
			}
			
			else{
				System.out.println("Your Password is not correct.");
			}
		}
		break;
		case 7:
		{
			System.out.println("your account balance is now "+ cc.Getbalance() + "Rial"); 
		}
		 break;
		case 8:
		{ System.out.println("Have a nice time!");
				System.exit(1);
			break;}
		
		default :
			System.out.println("Invalid choice"); 
		

		
		} //end of switch
		
		
		} // end of for (i=0.... ) loop
	

} //end of main
}// end of class
