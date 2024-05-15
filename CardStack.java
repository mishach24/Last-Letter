public class CardStack
{
    //Deck Instance Variables
    private int count;
    //the number of cards in the deck
    //a deck of cards
    private Card data[] = new Card [50];
    //Constructor - returns a deck of cards
    public CardStack ()
    {
	count = 0;
    }


    //Deck Methods 
    //push - adds a card to the deck
    public void push (Card addMe)
    {
	data [count] = addMe;
	count++;
    }


    //size - returns the number of cards remaining in the deck
    public int size ()
    {
	return count;
    }


    //isFull - returns true if the deck is full
    public boolean isFull ()
    {
	return (count == 50);
    }


    //pop - removes a card from the deck
    public Card pop ()
    {
	count--;
	return data [count];
    }


    //peek - returns the top card in the deck
    public Card peek ()
    {
	return data [count--];
    }


    //isEmpty - returns true if there are no cards left in the deck
    public boolean isEmpty ()
    {
	return count == 0;
    }


    //clear - removes all cards from the deck
    public void clear ()
    {
	count = 0;
    }


    //shuffle - adds all (size) cards to the deck in random order
    public void shuffle ()
    {
	String names[] = {"bear", "cat", "chicken", "cow",
	    "crocodile", "deer", "dog", "duck", "fish",
	    "frog", "koala", "lion", "otter", "panda",
	    "pig",
	    "polarbear", "rabbit", "racoon", "reindeer", "santabear",
	    "skunk", "snowman", "swan", "tiger", "turtle"};
	//Randomize the order of the arrays
	for (int i = 0 ; i < 100 ; i++)
	{
	    int r1 = (int) (Math.random () * names.length);
	    int r2 = (int) (Math.random () * names.length);
	    //swap names array
	    String temp = names [r1];
	    names [r1] = names [r2];
	    names [r2] = temp;
	}
	count = 0;
	//TO DO: push all (now in random order) into the Deck
	for (int i = 0 ; i < names.length ; i++)
	{
	    Card d = new Card (names [i]);
	    push (d);
	}
    }
}
