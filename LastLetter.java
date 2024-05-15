import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
import java.applet.Applet;
import javax.swing.event.*;
import java.io.*;

public class ChaudhryMahroshLastLetter extends Applet implements ActionListener
{
    Panel p_card; //to hold all of the cards
    Panel card1, card2, card3, card4; //the four screens
    CardLayout cdLayout = new CardLayout ();
    //CardStack file
    CardStack box = new CardStack ();
    //Textfield to get users answers.
    JTextField blank;
    //Used to guide users through cards and game.
    JLabel word;
    //error message if anser incorrect.
    String answer;
    //last letter of animal
    char end;
    //used in reset method
    int num = 0;
    //score 1
    int count = 0;
    //score 2
    int count2 = 0;
    //cards
    JLabel picture;
    //name of cards
    JLabel toString;
    //displays player 1 score
    JButton score1;
    //displays player 2 score
    JButton score2;
    //tells whose turn it is
    int turn = 1;
    Card temp;
    //track score
    int scoreTrack[] = new int [25];
    //array
    int cardNum = -1;
    //date
    Date now = new Date ();
    DateFormat df = DateFormat.getDateInstance ();
    String s = df.format (now);
    //sound
    AudioClip soundFile;
    //the input below is being called here
    //the "AudioClip" part plays the song when it is run


    public void init ()
    {
	resize (500, 720);
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	//make the 4 screens
	initOpening ();
	initRules ();
	initGame ();
	initend ();
	setLayout (new BorderLayout ());
	initMenu ();
	JOptionPane.showMessageDialog (null, s, "Date", JOptionPane.ERROR_MESSAGE);
	soundFile = getAudioClip (getDocumentBase (), "jinglebell.snd");
	//this attaches the sound file "letitrock"
	soundFile.loop ();
	//put the sound on repeat
	add ("Center", p_card);

    }


    public void initMenu ()
    {
	JMenuBar menuBar = new JMenuBar ();
	JMenu menu;
	JMenuItem menuItem;

	menu = new JMenu ("File");
	menuBar.add (menu);

	menuItem = new JMenuItem ("Close");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("Close");
	menu.add (menuItem);

	menu = new JMenu ("Navigate");
	menuBar.add (menu);

	menuItem = new JMenuItem ("Opening");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("1");
	menu.add (menuItem);

	menuItem = new JMenuItem ("Rules");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("2");
	menu.add (menuItem);

	menuItem = new JMenuItem ("Play Game");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("3");
	menu.add (menuItem);

	menuItem = new JMenuItem ("Ending Screen");
	menuItem.addActionListener (this);
	menuItem.setActionCommand ("4");
	menu.add (menuItem);
	add ("North", menuBar);
    }


    //welcome screen. first card
    public void initOpening ()
    { //Pre: p_card is a cdLayout, card1 is declared
	//Post: initializes opening screen's widgets.
	card1 = new Panel ();
	card1.setBackground (new Color (215, 180, 243));
	JButton next = new JButton (createImageIcon ("opening.png"));
	next.setActionCommand ("2");
	next.addActionListener (this);
	next.setPreferredSize (new Dimension (500, 720));
	card1.add (next);
	p_card.add ("1", card1);
    }


    //instructions screen. second card
    public void initRules ()
    { //Pre: p_card is a cdLayout, card1 is declared
	//Post: initializes opening screen's widgets.
	card2 = new Panel ();
	card2.setBackground (new Color (215, 180, 243));
	JButton next = new JButton (createImageIcon ("instructions.png"));
	next.setActionCommand ("3");
	next.addActionListener (this);
	card2.add (next);
	p_card.add ("2", card2);
    }


    //third card. game screen
    public void initGame ()
    {
	card3 = new Panel ();
	card3.setBackground (new Color (215, 180, 243));
	//reset button
	JButton reset = new JButton ("Reset");
	reset.setBackground (new Color (154, 127, 174));
	reset.setForeground (Color.white);
	reset.addActionListener (this);
	reset.setActionCommand ("reset");
	//next card button
	JButton push = new JButton ("Push");
	push.setBackground (new Color (154, 127, 174));
	push.setForeground (Color.white);
	push.addActionListener (this);
	push.setActionCommand ("push");
	//previous card button
	JButton pop = new JButton ("Pop");
	pop.addActionListener (this);
	pop.setBackground (new Color (154, 127, 174));
	pop.setForeground (Color.white);
	pop.setActionCommand ("pop");
	//shuffles deck of card button
	JButton shuffle = new JButton ("Shuffle");
	shuffle.addActionListener (this);
	shuffle.setBackground (new Color (154, 127, 174));
	shuffle.setForeground (Color.white);
	shuffle.setActionCommand ("shuffle");
	//instructions button
	JButton ins = new JButton ("Instructions");
	ins.setBackground (new Color (154, 127, 174));
	ins.setForeground (Color.white);
	ins.addActionListener (this);
	ins.setActionCommand ("ins");
	picture = new JLabel (createImageIcon ("base.png"));
	toString = new JLabel ("Welcome");
	Panel py = new Panel ();
	word = new JLabel ("Player 1: Please enter the name of the animal                        ");
	blank = new JTextField (12);
	//button to check answer and end.
	JButton enter = new JButton (" Done ");
	enter.setBackground (new Color (154, 127, 174));
	enter.setForeground (Color.white);
	enter.setActionCommand ("done");
	enter.addActionListener (this);
	//keeps track of player 1 score
	score1 = new JButton ("Player 1: 000");
	score1.addActionListener (this);
	score1.setActionCommand ("score1");
	score1.setBackground (new Color (154, 127, 174));
	score1.setForeground (Color.white);
	//keeps track of player 2 score
	score2 = new JButton ("Player 2: 000");
	score2.addActionListener (this);
	score2.setBackground (new Color (154, 127, 174));
	score2.setForeground (Color.white);
	score2.setActionCommand ("score2");
	py.add (reset);
	py.add (push);
	py.add (pop);
	py.add (shuffle);
	card3.add (py);
	card3.add (ins);
	Panel pr = new Panel (new GridLayout (1, 1));
	pr.add (score1);
	pr.add (score2);
	card3.add (pr);
	card3.add (picture);
	card3.add (word);
	card3.add (blank);
	card3.add (enter);
	Panel p0 = new Panel (new GridLayout (4, 10));
	p0.add (toString);
	card3.add (p0);
	p_card.add ("3", card3);
    }


    //last card. closes screen
    public void initend ()
    { //Pre: p_card is a cdLayout, card1 is declared
	//Post: initializes opening screen's widgets.
	card4 = new Panel ();
	card4.setBackground (new Color (215, 180, 243));
	JButton next = new JButton (createImageIcon ("ending.png"));
	next.setActionCommand ("Close");
	next.addActionListener (this);
	card4.add (next);
	p_card.add ("4", card4);
    }


    //All buttons performance and answer plus end check
    public void actionPerformed (ActionEvent e)
    {
	if (e.getActionCommand ().equals ("4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("Close"))
	    System.exit (0);
	else if (e.getActionCommand ().equals ("reset"))
	{
	    //set num to 0
	    num = 0;
	    //clear box
	    box.clear ();
	    //call drawblank
	    drawblank ();
	    blank.setText (" ");
	    score1.setText ("Player 1: 000");
	    score2.setText ("Player 2: 000");
	}
	else if (e.getActionCommand ().equals ("push"))
	{
	    cardNum++;
	    //make a new random card
	    //if the box isn't full
	    if (!box.isFull ())
	    {
		temp = new Card ();
		//Push d onto the box
		box.push (temp);
		//add one to num
		num += 1;
		//Call showCard, pass in d
		showCard (temp);
		//blank.setText (" ");
		showStatus (temp.getCardName ());

	    }
	}
	else if (e.getActionCommand ().equals ("pop"))
	{
	    if (!box.isEmpty ())
	    { //pop a donut from the box, save it
		temp = box.pop ();
		//subtract one from num
		num += -1;
		//call showDonut, pass in d
		showCard (temp);
	    }
	    else
	    {
		//set num to 0
		num = 0;
		//at the bottom, call drawblank
		drawblank ();
	    }
	}
	else if (e.getActionCommand ().equals ("shuffle"))
	{
	    //clear box
	    box.clear ();
	    //call shuffle
	    box.shuffle ();
	    //set num to size of the box
	    num = box.size ();
	    //pop a donut, store it in a variable
	    temp = box.pop ();
	    //call showDonut, pass in the variable
	    showCard (temp);

	}
	//player 1
	else if (e.getActionCommand ().equals ("score1"))
	{
	    score1.setText ("Player 1: " + count);
	    JOptionPane.showMessageDialog (null, "Player currently has "
		    + count + " points \n"
		    + "Please continue to game once score is viewed", "Instructions", JOptionPane.QUESTION_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("ins"))
	{
	    //instructions for game screen
	    JOptionPane.showMessageDialog (null, "* * * I N S T R U C T I O N S *    * * \n \n"
		    + "Step1 : Player 1 will write the name of the animal on the card. If the animal is incorrect they will write the name again.  Press 'done'when finished typing.\n"
		    + "Step 2 : If the name of the animal is correct. Player 2 will then be asked to write the last letter of the prior animal. Press 'done' when finished typing. \n"
		    + "Step 3: Based on Player 2's answer, if the word starts with the last letter of the prior animal, Player 2 will earn a point. If not player 1 will earn a point. \n\n"
		    + "For example: The name of the following animal is 'fish'. So Player 1 will type 'fish' in the textfield\n"
		    + "Because 'fish' ends with the alphabet 'h' Player 2 will be asked to write a letter that ends with 'h'. Such as 'hair'. Any word is permissible.\n"
		    + "Enjoy!!", "Instructions", JOptionPane.QUESTION_MESSAGE);
	}

	//player 2
	else if (e.getActionCommand ().equals ("score2"))
	{
	    score2.setText ("Player 2: " + count2);
	    JOptionPane.showMessageDialog (null, "Player currently has "
		    + count2 + " points \n"
		    + "Please continue to game once score is viewed", "Instructions", JOptionPane.QUESTION_MESSAGE);
	}

	//checks end and answer
	else if (e.getActionCommand ().equals ("done"))
	{
	    if (turn == 1) //player 1
	    {
		showStatus (blank.getText ());

		answer = blank.getText ();
		blank.setText ("");
		if (answer.equalsIgnoreCase (temp.getCardName ()))
		{
		    end = findEnd (answer);
		    word.setText ("Good. Player 2 please write a word that starts with " + end);
		    turn = 2;
		}
		else
		{
		    word.setText ("No. Try Again. That's not right");

		}
		score1.setText ("Player 1: 00" + count);
		score2.setText ("Player 2: 00" + count2);

	    }
	    else //player 2
	    {
		answer = blank.getText ();
		blank.setText ("");
		if (answer.charAt (0) == end)
		{
		    word.setText ("Good job! player 2 earned a point");
		    count2++;
		    arrayUpdate2 (count2);
		}
		else
		{
		    word.setText ("Does not start with " + end + "Player 1 wins a point");
		    count++;
		    arrayUpdate (count);
		}
		turn = 1;
		score1.setText ("Player 1: 00" + count);
		score2.setText ("Player 2: 00" + count2);

	    }
	    saveToFile ();
	}
    }

    //1d array
    public void arrayUpdate (int a)
    {
	scoreTrack [cardNum] = 1;
    }

    //1d array
    public void arrayUpdate2 (int a)
    {
	scoreTrack [cardNum] = 2;
    }

    //find end
    public char findEnd (String s)
    {
	char c = s.charAt (s.length () - 1);
	return c;
    }

    //saves scores per round to a file named "highscore"
    public void saveToFile ()
    {
	PrintWriter out;
	try
	{
	    out = new PrintWriter (new FileWriter ("highscore.txt"));
	    for (int l = 0 ; l < (cardNum + 1) ; l++)
		out.println ("Round " + (l + 1) + ": " + scoreTrack [l]);
	    out.close ();
	}
	catch (IOException e)
	{
	    System.out.println ("Error opening file " + e);
	}
    }



    public void drawblank ()
    {
	picture.setIcon (createImageIcon ("base.png"));
	toString.setText ("Welcome");
    }


    public void showCard (Card two)
    {
	picture.setIcon (createImageIcon (two.getPicName () + ".png"));
	toString.setText (two.toString ());

    }


    //images
    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = ChaudhryMahroshLastLetter.class.getResource (path);
	if (imgURL != null)
	    return new ImageIcon (imgURL);
	else
	    return null;
    }
}


