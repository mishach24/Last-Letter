public class Card
{ //instance variables
    private String CardName;
    //Construction - generates a card using parameters
    public Card ()
    {
	String names[] = {"bear", "cat", "chicken", "cow",
	    "crocodile", "deer", "dog", "duck", "fish",
	    "frog", "koala", "lion", "otter", "panda",
	    "pig",
	    "polarbear", "rabbit", "racoon", "reindeer", "santabear",
	    "skunk", "snowman", "swan", "tiger", "turtle"};

	int rand = (int) (Math.random () * names.length);
	CardName = names [rand];

    }


    //Default Constructor - generates a random card
    public Card (String a)
    {
	CardName = a;

    }


    //Accessors - can see values on a card using return types
    public String getCardName ()
    {
	return CardName;
    }


    //Mutators - allows changes to a card using parameters
    public void setCardName (String a)
    {
	CardName = a;
    }


    public String toString ()
    {
	return CardName;
    }


    //equals - tests if two cards are equal based on picture name
    public boolean equals (Card two)
    {
	if (two.getCardName ().equals (CardName))
	    return true;
	else
	    return false;
    }


    //compareTo - based on ___ card picture name, returns -1 if parameter is greater, 0 if parameter is equal and 1 if parameter is smaller
    public int compareTo (Card two)
    {
	if (two.equals (this))
	    return 0;
	else if (two.getCardName ().compareTo (CardName) >= 0)
	    return 1;
	else
	    return -1;
    }


    //Accessors - can see values on a card using return types(toString)
    public String getPicName ()
    {
	if (CardName.equals ("bear"))
	    return "Bear";
	else if (CardName.equals ("cat"))
	    return "Cat";
	else if (CardName.equals ("chicken"))
	    return "Chicken";
	else if (CardName.equals ("cow"))
	    return "Cow";
	else if (CardName.equals ("crocodile"))
	    return "Crocodile";
	else if (CardName.equals ("deer"))
	    return "Deer";
	else if (CardName.equals ("dog"))
	    return "Dog";
	else if (CardName.equals ("duck"))
	    return "Duck";
	else if (CardName.equals ("fish"))
	    return "Fish";
	else if (CardName.equals ("frog"))
	    return "Frog";
	else if (CardName.equals ("koala"))
	    return "Koala";
	else if (CardName.equals ("lion"))
	    return "Lion";
	else if (CardName.equals ("otter"))
	    return "Otter";
	else if (CardName.equals ("panda"))
	    return "Panda";
	else if (CardName.equals ("pig"))
	    return "Pig";
	else if (CardName.equals ("polarbear"))
	    return "Polarbear";
	else if (CardName.equals ("rabbit"))
	    return "Rabbit";
	else if (CardName.equals ("racoon"))
	    return "Racoon";
	else if (CardName.equals ("reindeer"))
	    return "Reindeer";
	else if (CardName.equals ("santabear"))
	    return "Santabear";
	else if (CardName.equals ("skunk"))
	    return "Skunk";
	else if (CardName.equals ("snowman"))
	    return "snowman";
	else if (CardName.equals ("swan"))
	    return "Swan";
	else if (CardName.equals ("tiger"))
	    return "Tiger";
	else if (CardName.equals ("turtle"))
	    return "Turtle";
	else
	    return "Bear";
	//etc for all of the rest of the donuts.
    }
}
