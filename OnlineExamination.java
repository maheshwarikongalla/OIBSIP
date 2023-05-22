import java.io.*;
import java.util.*;
class OnlineExamination{
    String Full_Name;
    String Gender;
    String UserName;
    String Password;
    String Phone_Number;
    int count=0;
    int score=0;
    int attempt=0;
    Scanner input=new Scanner(System.in);
    HashMap<String,String> data=new HashMap<String,String>();
    public void Register(){
        System.out.println("...Registration...");
        System.out.print("Enter Full Name: ");
        this.Full_Name=input.nextLine();
        System.out.print("Enter Gender(M/F): ");
        this.Gender=input.nextLine();
        String Gender1="M";
        String Gender2="m";
        String Gender3="F";
        String Gender4="f";
        while(!((((this.Gender).equals(Gender1)) || ((this.Gender).equals(Gender2))) || (((this.Gender).equals(Gender3)) || ((this.Gender).equals(Gender4))))){
            System.out.print("Invalid...Please enter correct Gender(M/F): ");
            this.Gender=input.nextLine();
        }
        if(this.Gender.equals(Gender1) || this.Gender.equals(Gender2)){
            this.Gender="Male";
        }
        else{
            this.Gender="Female";
        }
        System.out.print("Enter Username: ");
        this.UserName=input.nextLine();
        System.out.print("Enter Password: ");
        this.Password=input.nextLine();
        data.put(this.UserName,this.Password);
        System.out.print("Enter Phone Number: ");
        this.Phone_Number=input.nextLine();
        while((Phone_Number.length())!=10){
            System.out.print("!!! Please Enter Valid 10 Digit Mobile Number: ");
            this.Phone_Number=input.nextLine();
        }
        System.out.println("Your are Successfully Registered...");
        System.out.println("Please Login to Take Online Exam");
    }
    public boolean Login(){
        boolean log=false;
        System.out.print("Enter your User name: ");
        String Username;
        Username=input.nextLine();
	if(data.containsKey(Username)){
            System.out.print("Enter your Password: ");
            String Pass_Word;
            Pass_Word=input.nextLine();
            if(data.containsKey(Username) && data.containsValue(Pass_Word)){
                System.out.println("Login Successful...");
                log=true;
            }
            else{
                System.out.println("You have Entered Wrong Password...");
            }
	}
	else{
	    System.out.println("User doesn't Exists Please Register first");
	}
        return log;
    }
    public void View_Profile(){
        System.out.println("Your Profile: ");
        System.out.println("Full Name: "+this.Full_Name);
        System.out.println("Gender: "+this.Gender);
        System.out.println("User Name: "+this.UserName);
        System.out.println("Password(Don't Share with any one) :"+this.Password);
        System.out.println("Phone Number: "+this.Phone_Number);
    }
    public void Update_Profile(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter Username: ");
        String Username;
        Username=input.nextLine();
        if(Username.equals(this.UserName)){
            System.out.println("Select: \n1.To change Username\n2.To change Password");
            int ch;
            System.out.print("Your Option: ");
            ch=input.nextInt();
            switch(ch){
                case 1:Update_Username();
                       break;
                case 2:Update_PassWord();
                       break;
                default :System.out.println("Invalid option...");
            }
        }
        else{
            System.out.println("User Does not Exit Please Register First\n");
        }
    }
    public void Update_Username(){
        Scanner input=new Scanner(System.in);
        String User;
        String User1;
        System.out.print("Enter New User Name to Update: ");
        User=input.nextLine();
        if(!(User.equals(this.UserName))){
            System.out.print("Conform New User Name to Update: ");
            User1=input.nextLine();
            if(User.equals(User1)){
                System.out.println("Username Updated Successfully...");
                this.UserName=User1;
                return;
            }
            else{
                System.out.println("You must type the same Username...");
                Update_Username();
            }
        }
        else{
            System.out.println("New Username and Present Username cannot not be same...");
            Update_Username();
        }
    }
    public void Update_PassWord(){
        Scanner input=new Scanner(System.in);
        String Pass;
        String Pass1;
        System.out.print("Enter New Password to Update: ");
        Pass=input.nextLine();
        if(!(Pass.equals(this.Password))){
            System.out.print("Conform New Password to Update: ");
            Pass1=input.nextLine();
            if(Pass.equals(Pass1)){
                System.out.println("Password Updated Successfully...");
                this.Password=Pass1;
                return;
            }
            else{
                System.out.println("You must type the same Password...");
                Update_PassWord();
            }
        }
        else{
            System.out.println("New Password and Present Password cannot not be same...");
            Update_PassWord();
        }
    }
    public void Take_exam(){
        long examtime=System.currentTimeMillis();
        long endtime=examtime+45*1000;
        int ans;
        int ch;
        System.out.println("Select Subject to take exam: ");
        System.out.println("1.Mathematics\n2.Java Programming\n3.C-Programming Language");
	System.out.print("Your choice: ");
        ch=input.nextInt();
        if(ch==1){
            System.out.println("Welcome to Mathematics Exam: ");
            System.out.println("Each Question carries 10 marks"+" "+" -5 for wrong answers");
            System.out.println("You have 45 seconds to answer 5 questions");
            attempt=0;
            while(System.currentTimeMillis()<endtime){
		count=0;
                System.out.println("Question 1. 32^32= ?");
                System.out.println("Option 1. 64\nOption 2. 1024\nOption 3. 3232\nOption 4.324 \n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==2){
                    count++;
                }
                System.out.println("Question 2. 10/4 = ?");
                System.out.println("Option 1. 0.25\nOption 2. 2.5\nOption 3. 2\nOption 4. 25\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 3. 2*3+5*0-3/1= ?");
                System.out.println("Option 1. 3\nOption 2. 8\nOption 3. -3\nOption 4. 0\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==1){
                    count++;
                }
                System.out.println("Question 4. 0/1569 = ?");
                System.out.println("Option 1. 0\nOption 2. infinite\nOption 3. not possible\nOption 4. 1569\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==1){
                    count++;
                }
                System.out.println("Question 5. 0/0 = ?");
                System.out.println("Option 1. 0\nOption 2. undefine\nOption 3. not possible\nOption 4. None of the above\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==2){
                    count++;
                }
                
                attempt++;
                break;
            }
        }
        else if(ch==2){
            System.out.println("Welcome to Java Programming Exam: ");
            System.out.println("Each Question carries 10 marks"+" "+" -5 for wrong answers");
            System.out.println("You have 45 seconds to answer 5 questions");
            attempt=0;
            while(System.currentTimeMillis()<endtime){
		count=0;
                System.out.println("Question 1. Java is developed by : ");
                System.out.println("Option 1. Dennis Ritchie\nOption 2. James Gosling\nOption 3. Sundar Pichai\nOption 4. Satya Nadella\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==2){
                    count++;
                }
                System.out.println("Question 2. Arrays  in java are: ");
                System.out.println("Option 1. Object references\nOption 2. Objects\nOption 3.Data type\nOption 4. None\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==2){
                    count++;
                }
                System.out.println("Question 3.Total  constuctor string class have: ");
                System.out.println("Option 1. 3\nOption 2. 7\nOption 3. 13\nOption 4. 20\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 4. Identify the output of the following program.\nString str = “Hellow”;\nSystem.out.println(str.indexOf(‘t)); ");
                System.out.println("Option 1. 0\nOption 2. 1\nOption 3. true\nOption 4. -1\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==4){
                    count++;
                }
                System.out.println("Question 5. Where is System class defined :");
                System.out.println("Opption 1. java.lang.package\nOption 2. java.util.package\nOption 3. java.io.package\nOption 4.None\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==1){
                    count++;
                }
                attempt++;
                break;
            }
        }
        else if(ch==3){
            System.out.println("Welcome to C-Programming Language Exam: ");
            System.out.println("Each Question carries 10 marks"+" "+" -5 for wrong answers");
            System.out.println("You have 45 seconds to answer 5 questions");
            attempt=0;
            while(System.currentTimeMillis()<endtime){
		count=0;
                System.out.println("Question 1. C is developed by : ");
                System.out.println("Option 1. James Gosling\nOption 2. Sundar Pichai\nOption 3. Dennis Ritchie\nOption 4. Mark Zukenburg\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 2. What is required in each C program ?");
                System.out.println("Option 1. The program must have at least one function\nOption 2. The program does not require any function\nOption 3. Input data\nOption 4. Output data\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==1){
                    count++;
                }
                System.out.println("Question 3. In the C language ,the constant is  defined_________");
                System.out.println("Option 1. Before main\nOption 2. After main\nOption 3. Anywhere,but starting on a new line\nOption 4. None of the these\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==3){
                    count++;
                }
                System.out.println("Question 4.Which one of the following is a loop construct that will always be executed once?");
                System.out.println("Option 1. for\nOption 2. While\nOption 3. switch\nOption 4. do while\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==4){
                    count++;
                }
                System.out.println("Question 5. Which of the  following cannot be a variable name in c ");
                System.out.println("Option 1.volatile\nOption 2. true\nOption 3. friend\nOption 4. export\n");
                System.out.print("Enter Your Answer: ");
                ans=input.nextInt();
                if(ans==1){
                    count++;
                }
                attempt++;
                break;
            }
        }
        else{
            System.out.println("Invalid option...Please Try Again...");
            Take_exam();
        }
    }
    public void View_Marks(){
	int score=((10*count)-((5-count)*5));
	if(score==50){
	    System.out.println("Congratulations....");
	}
	else if(score<50 && score>=35){
	    System.out.println("Well Done...");
	}
	else if(score<35 && score>=20){
	    System.out.println("Well Tried...");
	}
	else if(score<20 && score>=10){
	    System.out.println("Good...");
	}
	else{
	    System.out.println("Ok! Try Again...");
	}
        if(attempt==1){
            System.out.println("Your Score: "+score+"/50");
        }
        else{
            System.out.println("You haven't Written any exam...");
        }
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.println("-------WELCOME TO ONLINE EXAMINATION-------");
        System.out.println("Please Register first to write the exam...");
        System.out.println("1.Register(New Users should Register First)\n2.Exit");
        System.out.print("Your choice:");
        int choice;
        choice=input.nextInt();
        if(choice==1){
            OnlineExamination exam=new OnlineExamination();
            exam.Register();
            while(choice==1){
                System.out.println("\n Select any one option: ");
                System.out.println("1.Login(If already Registered)\n2.Exit");
                System.out.print("Your option :");
                int option=input.nextInt();
                if (option==1){
                    if(exam.Login()){
                        while(true){
                            System.out.println("\n\nWelcome to Online Examination");
                            System.out.println("1.View Profile\n2.Update Profile and Password\n3.Take Exam\n4.View Marks\n5.Logout");
                            System.out.print("Enter your option :");
                            int select; 
                            select=input.nextInt();
                            switch(select){
                                case 1 : exam.View_Profile();
                                         break;
                                case 2 : exam.Update_Profile();
                                         break;
                                case 3 : exam.Take_exam();
                                         break;
                                case 4 : exam.View_Marks();
                                         break;
                                case 5 : System.out.println("\nLogged out Successfully..."); 
                                         System.exit(0);
                                         break;
                                default: System.out.println("Invalid option!...Enter Valid option...");
                            }
                        }
                    }
                }
                else{
                    System.out.println("\nThank you...Visit Again...:)"); 
                    System.exit(0);
                }
            }
        }
        else {
            System.out.println("\nThank you...Visit Again...:)"); 
        	System.exit(0);
        }
    }
}