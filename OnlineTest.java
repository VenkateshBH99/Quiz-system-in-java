import java.awt. *;
import java.awt. event.*;
import javax.swing.*;

class QuestionSeries{
static String info ="Java Online Test Week  \n \nINSTRUCTIONS:\nThere are 25 questions in this test and 10 minutes to complete them all.\nThe finish button is highlighted in green when you reach the end of the test. \nClicking the finish button will display the results with the correct answers marked in light red.  \n \nThe timecounter  begins when you click on the 'start' button \n \nBest of luck!\n";

static String []question ={"Question 1:\nWhich 2 months have EQUINOX?",
"Question 2:\nCONDENSATION is the reverse process of?",
"Question 3: \nWhich country ranks second in terms of largest land area?",
"Question 4:\nWhich river carries maximum amount of water in the sea?",
"Question 5:\nWhere is the permanent secretariat of SAARC located?",
"Question 6:\nWhen is the WORLD ENVIRONMENT DAY celebrated?",
"Question 7:\nIn which year was UNO formed?",
"Question 8:\nWho is the author of Harry Potter?",
"Question 9:\nIn which ocean is Hawaii situated?",
"Question 10:\nHow many legs does a butterfly has?",
"Question 11:\nWhich is the most common element on earth?",
"Question 12:\nHow many tentacles does an octopus have?",
"Question 13:\nWhich planet has rings around it?",
"Question 14:\nWhat is the main use of Quinine?",
"Question 15:\nHow many is a Baker's dozen?",
"Question 16:\nWhich one of the following is not a primary colour?",
"Question 17:\nIn which country did Sherpa's originate?",
"Question 18:\nWhich is the largest gland in human body?",
"Question 19:\nWhich is the fastest mammal on earth?",
"Question 20:\nWhich sport is called the Sport of Kings?",
"Question 21:\nHow many years you have been married for a diamond anniversary?",
"Question 22:\nSumo Wrestling originated in which country?",
"Question 23:\nWhich element's chemical symbol is Pb?",

"Question 24:\nHow many years are there in a millenium?",
"Question 25:\nWhich is the largest coffee growing country in the world?"
};


static String [][]answers ={{"JUNE\n","MARCH\n","SEPTEMBER\n","OCTOBER\n"},{"Melting\n"," \nEvaporation","Freezing\n"," \nSolidifying\n"},{" \nChina\n","India\n","Canada\n","Russia\n"},{" \nAmazon","Nile\n"," \nGanga\n"," \nThames\n"},{" \nKathmandu\n"," \nWashington\n"," \nToronto\n"," \nLondon\n"},{" \n5 july\n"," \n5 may\n"," \n4 may\n","5 june\n"},{" \n1944\n"," \n1946\n"," \n1947\n"," \n1945\n"},{" \nCharles Dickens\n"," \nEnid Blyton\n"," \nJ.K Rowling\n"," \nJane Austen\n"},{" \nIndian\n"," \nArctic\n"," \nAntarctic\n"," \nPacific\n"},{" \n8\n"," \n10\n"," \n6\n"," \n4\n"},{" \nOxygen\n"," \nMagnesium\n"," \nSilicon\n"," \nHydrogen\n"},{" \n8\n"," \n10\n"," \n12\n"," \n14\n"},{" \nSaturn\n"," \nNeptune\n"," \nUranus\n"," \nJupiter\n"},{"prevent fever\n"," \nprevent small pox\n"," \nprevent malaria\n"," \nprevent chicken pox\n"},{" \n11\n"," \n12\n"," \n10\n"," \n13\n"},{" \nred\n"," \nblue\n"," \nyellow\n"," \ngreen\n"},{" \nchina\n"," \nnepal\n"," \nbhutan\n"," \nIndia\n"},{" \nThyroid Gland\n"," \nKidney\n"," \nPituitary\n"," \nLiver\n"},{" \nElephant\n"," \nTiger\n"," \nCheetah\n"," \nHumans\n"},{" \nPolo\n"," \nHorse Racing\n"," \nCricket\n"," \nIce Hockey\n"},{" \n50\n"," \n60\n"," \n75\n"," \n100\n"},{"Argentina\n"," \nThailand\n"," \nJapan\n"," \nChina\n"},{" Iron\n"," Zinc\n"," Lead\n"," Potassium\n"},{" \n100\n"," \n1000\n"," \n10,000\n"," \n10\n"},{"Brazil\n","Sri Lanka\n","Zambia\n"," \nIndia\n"} };

static int []n = {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
static String []choice= {"23","2","3","1","1","4","4","3","4","3","4","1","1","3","4","4","2","4","3","2","2","3","3","2","1"};
static int tally = choice.length;
static String testtitle="Java Programming Online Test";
static int timeLimit =10;
static int passMark = 33;
}

/* OnlineTest class */

public class OnlineTest extends JFrame{
    static String studentname ="";
    static int TOTAL=0;

	static {
	try{
	TOTAL = QuestionSeries.tally;		
	/* 	The input window */
	studentname = JOptionPane.showInputDialog("Enter your name: ");
	if(studentname.length() < 1) studentname = "Anonymous   ";
	else studentname = studentname.trim() + " ";
	}catch(NullPointerException e){ System.exit(0); }
	}	

    	int seconds, minutes;
    	int quesnum, itemCheck, mark; 
	final String TESTTITLE = QuestionSeries.testtitle;
    	final int TIMELIMIT = QuestionSeries.timeLimit;
    	final int PASS = QuestionSeries.passMark;
    	String []answers = new String[TOTAL];
	JButton []choice_button = new JButton[6];
	JTextArea answerboxes[] = new JTextArea[4];
	JCheckBox []boxes = new JCheckBox[4];
    	JTextPane pane = new JTextPane();
	JLabel student, choose, message, timecounter, testresult;
    	boolean start_test, check_answer, allowRestart, finishtest;
	Northwindow panelNorth = new Northwindow();
	Southwindow panelSouth = new Southwindow();
	Centerwindow panelCenter = new Centerwindow();

/*  OnlineTest Constructor */
	protected OnlineTest(){
        for (int i=0; i<TOTAL; i++) answers[i] ="";
		getContentPane().setLayout(new BorderLayout() );
		getContentPane().add("North", panelNorth);
		getContentPane().add("South", panelSouth);
		getContentPane().add("Center", panelCenter);
		int width = 0, height=0; 
	        if(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()<799){width=		640; 		height=460; }
	        else {width=720; height=540; }
		setSize(width,height);
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width-width)/2, (dim.height-height)/2);
	}

/**
**  Northwindow class
**/

class Northwindow extends JPanel{

/**
**  Northwindow constructor 
**/
    public Northwindow(){
		setLayout(new GridLayout(2,2));
		setBackground(new Color(230, 230, 255));
		student = new JLabel("\t Welcome : "+studentname+" to the Online Java Test");
		student.setFont(new Font("",Font.BOLD,16) );
		message = new JLabel();
		message.setForeground(Color.blue);
		add(student);
		add(message);
		add(new JLabel("               ") );
		add(new JLabel("               ") );
        setBorder(BorderFactory.createEtchedBorder() );
	}
}

/**
**  Southwindow class
**/
class Southwindow extends JPanel{
	public Southwindow(){
		String []key = {"","start:","next:","finish:","check next:","check previous:"};
			for(int i=0; i<choice_button.length; i++)
                   {
				choice_button[i] = new JButton(key[i]);
				choice_button[i].addActionListener(new ActionHandler() );
				if(i !=0)add(choice_button[i]);
			  }
        setBorder(BorderFactory.createEtchedBorder() );
	}
}

/**
**  Centerwindow class 
**/
class Centerwindow extends JPanel{

	public Centerwindow(){
		setLayout(new GridLayout(1,2) );
		JScrollPane west = new JScrollPane(pane);       
		pane.setForeground(Color.red);	       
   		pane.setFont(new Font ("monospaced",0,12) );
		pane.setText(QuestionSeries.info);
		pane.setEditable(false);
		JPanel east = new JPanel();
		east.setLayout(new BorderLayout() );	
		JPanel northEast = new JPanel();
		northEast.setBackground(new Color(230, 230, 255) ); 
		east.add("North", northEast);
		JPanel westEast = new JPanel();
		westEast.setLayout(new GridLayout(6,1) );
		east.add("West", westEast);
		JPanel centerEast = new JPanel();
		centerEast.setLayout(new GridLayout(6,1) );
		centerEast.setBackground(new Color(255,255,200));
		east.add("Center", centerEast);       
			timecounter = new JLabel("     There are "+TOTAL+" questions in total");
			timecounter.setFont(new Font ("Arial",Font.BOLD,16) );
			timecounter.setForeground(new Color(0,90,20) );
			northEast.add(timecounter);
			westEast.add(new JLabel(" "));
        String []boxs = {" A ", " B ", " C ", " D "};
			for(int i=0; i<boxes.length; i++) { 
				boxes[i] = new JCheckBox(boxs[i]);
				boxes[i].addItemListener(new ItemHandler() );
				westEast.add(boxes[i]);
			}
        westEast.add(new JLabel() );
		choose = new JLabel("    CHOOSE CORRECT ANSWERS");
		choose.setBorder(BorderFactory.createEtchedBorder() );
		centerEast.add(choose);
        JScrollPane panes[] = new JScrollPane[4];
			for(int i=0; i<answerboxes.length; i++){
				answerboxes[i] = new JTextArea();
			    answerboxes[i].setBorder(BorderFactory.createEtchedBorder() );
				answerboxes[i].setEditable(false);
				answerboxes[i].setBackground(Color.white);
				answerboxes[i].setFont(new Font("",0,12) );
	            answerboxes[i].setLineWrap(true);      
                answerboxes[i].setWrapStyleWord(true);
                panes[i] = new JScrollPane(answerboxes[i]);
			    centerEast.add(panes[i]);
			}
		if(TIMELIMIT >0)testresult = new JLabel(studentname+",   You have only : "+TIMELIMIT+" minutes to complete.");   
		else testresult = new JLabel("     There is no time limit for this test");
		testresult.setBorder(BorderFactory.createEtchedBorder() );
		centerEast.add(testresult);
	add(west);
	add(east);
	}
}

/**
**  ActionHandler class to handle all the action events from the buttons. 
**/

class ActionHandler implements ActionListener{

/* actionPerformed method */
	public void actionPerformed(ActionEvent evt){
	  String source = evt.getActionCommand();
		if(source.equals("start:")){
			choice_button[1].setVisible(false);
			start_test=true;
			allowRestart=true;
            if(TIMELIMIT >0)new Timer(); // inner Timer class 
			panelSouth.remove(choice_button[1]); //start
            displayquestion();            
        }
	if(start_test){
		if(source.equals("previous:"))  {            			
			recordanswer();
			quesnum--;
    		if(quesnum ==  -1) quesnum=TOTAL-1;
			checkteststatus();
            displayquestion(); 
		}
		if(source.equals("next:")) {
			recordanswer();
			quesnum++;            
			if(quesnum ==  TOTAL-1) finishtest=true;
			if(quesnum ==  TOTAL) quesnum=0;
            checkteststatus();
            displayquestion(); 
		}
		if(source.equals("finish:")) {
			if (finishtest){
				recordanswer();
				quesnum = 0;

				choice_button[4].setBackground(Color.lightGray);
				timecounter.setForeground(Color.blue);
				timecounter.setFont(new Font ("Arial",0,14) );
				start_test=false; 
				check_answer=true;
				panelSouth.add(choice_button[0]);
				mark_ques();
				displayquestion();
				checkteststatus();
				calculateResult();
			}
			else  JOptionPane.showMessageDialog(null,"Cycle through all questions before pressing finish",
																 "User Message",JOptionPane.INFORMATION_MESSAGE);
		}
	} 

	if (check_answer){
		if(source.equals("check next:")) {
			quesnum++;
			if(quesnum ==  TOTAL) quesnum=0;
			mark_ques();
			displayquestion();
			checkteststatus();
		}
		if(source.equals("check previous:")) {
			quesnum--;
			if(quesnum ==  -1) quesnum=TOTAL-1;
			mark_ques();
			displayquestion();
			checkteststatus();
		}
	}
	validate();        
	}

/* Timer class */

class Timer extends Thread implements Runnable{
	public Timer(){
		new Thread(this).start();
	}

    public void run() {
		while(start_test){
            try {
               Thread.sleep(1000);
               seconds++;
				if(seconds % 60 == 0 && seconds != 0){
                    seconds -= 60;
                    minutes++;
				}
				timecounter.setText("    Time Counter:  "+minutes+" mins : "+seconds+" secs ");
				if(minutes==TIMELIMIT){
					start_test=false;
					endTest();
                }
		    }
            catch(InterruptedException ex)  { System.out.print(ex); }
		}
    }
}

/* checkteststatus method */

		public void checkteststatus(){
		if((quesnum ==  TOTAL-1)&&(start_test))choice_button[3].setBackground(Color.green);
		else choice_button[4].setBackground(Color.lightGray);
      	  if(answers[quesnum].length() >0){ 
			for(int i=0; i<answers[quesnum].length(); i++)
			boxes[Integer.parseInt(answers[quesnum].substring(i,i+1) )-1].setSelected			(true);
		}
		else for(int i=0; i<boxes.length; i++)boxes[i].setSelected(false);
		}

/* displayquestion method */

	public void displayquestion(){
        int j = quesnum+1;
		pane.setText(QuestionSeries.question[quesnum]);
		if(start_test)message.setText("Question "+j+" out of "+TOTAL);
        for (int i=0; i<4; i++)answerboxes[i].setText(QuestionSeries.answers[quesnum][i]);
		if(start_test){
            String temp="";
			if(QuestionSeries.n[quesnum]==1) temp="<html>&nbsp;&nbsp;&nbsp;Choose only 		<b>ONE</b>  Option</html>";
			else if(QuestionSeries.n[quesnum]==2) temp="<html>&nbsp;&nbsp;Choose <b>TWO		</b> Options</html>";
		else if(QuestionSeries.n[quesnum]==3) temp="<html>&nbsp;&nbsp;Choose <b>THREE</b> 		Options</html>";
            else temp="<html>&nbsp;&nbsp;<b>ALL are true</b> true</html>";
		choose.setText(temp);
		}
		else {
		timecounter.setText("    Your choices are shown in the boxes");
            choose.setText("    Correct answers are marked in light red.");
		}
	}

/* record answer method */

	public void recordanswer(){
		String tmp = "";
		for(int i=0; i<boxes.length; i++) if(boxes[i].isSelected() ) tmp +=i+1;
        answers[quesnum] = tmp;
    }

/* endTest method */ 

	public void endTest(){
		message.setText("TIME OVER: please press 'finish'");
        choice_button[2].setEnabled(false); 
        choice_button[3].setEnabled(false); 
        choice_button[4].setEnabled(true); 
	}

/* mark_ques() method to highlight correct answers */

	public void mark_ques(){
		for(int i=0; i<answerboxes.length; i++) answerboxes[i].setBackground(Color.white);
		for(int i=0; i<QuestionSeries.choice[quesnum].length(); i++)
			answerboxes[Integer.parseInt(QuestionSeries.choice[quesnum].substring(i,i+1))-1].setBackground(Color.red);
		if(QuestionSeries.choice[quesnum].equals(answers[quesnum])) message.setText("Answer correct, well done!");
		else message.setText("Sorry, you got this one wrong.");
	}


	public void calculateResult(){
		mark=0;
		double temp=0.0;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.#");
		for(int i=0; i<TOTAL; i++)if(QuestionSeries.choice[i].equals(answers[i]))mark++;
		temp=(double)mark;
		if(temp/TOTAL*100 >=PASS) testresult.setText("  Well done "+studentname.substring(0,studentname.indexOf(' ') )+", you passed");
		else testresult.setText("  Better luck next time "+studentname.substring(0,studentname.indexOf(' ') ) );
		student.setText(" Final score for "+studentname+":  "+mark+" out of "+TOTAL+":  "+df.format(temp/TOTAL*100)+"%");
		new Resultwindow().show();
	}
}

/* Resultwindow class */

class Resultwindow extends JFrame{
		Resultwindow() {
      	super( studentname+" results: " +(mark*100/TOTAL >=PASS?"PASS":"FAIL") );
  		Container cont = getContentPane();
		cont.setLayout(new GridLayout(TOTAL/2+3,5,2,5) );
		cont.setBackground(new Color(255,220,255) );
		cont.add(new JLabel("  "+"Marks:    "+mark+"/"+TOTAL+": "+"Percentage:  "+(mark*100/TOTAL)+"%") );
           for(int i=0; i<3; i++)cont.add(new JLabel() );
      	  String temp[] = new String[TOTAL];
			for(int i=0; i<TOTAL; i++){
				if(QuestionSeries.choice[i].equals(answers[i])) temp[i]="correct";
				else temp[i]="wrong";
			}
			for(int i=0; i<TOTAL; i++) cont.add(new JLabel("  Question "+(i+1)+":  "+temp		[i]) );
		pack();
		setLocation(200,200);
	}
}

/* ItemHandler class */

class ItemHandler implements ItemListener{
	public void itemStateChanged(ItemEvent evt){
	  if(start_test){
		for(int i=0; i<boxes.length; i++) if(boxes[i].isSelected() ) itemCheck++; 
		if(itemCheck > QuestionSeries.n[quesnum]){
			java.awt.Toolkit.getDefaultToolkit().beep();
            if(QuestionSeries.n[quesnum]==1)	JOptionPane.showMessageDialog(null,"<html><font 		size='4' color='00308a'><center>"+
      	"There is only "+QuestionSeries.n[quesnum]+" possible<br> answer to question "+(quesnum+1)+
                    "<html>","User Information Message",JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(null,"<html><font size='4' color='00308a'><center>"+
                    "There are only "+QuestionSeries.n[quesnum]+" possible<br> answers to question "+(quesnum+1)+
                    "<html>","User Information Message",JOptionPane.INFORMATION_MESSAGE);
		}
		itemCheck=0;
	  }	  
	}
}

/*  main method */

	public static void main(String [] args){
		OnlineTest frame = new OnlineTest();
		frame.setTitle("    "+QuestionSeries.testtitle);
		frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
		frame.setVisible(true);
    }
}