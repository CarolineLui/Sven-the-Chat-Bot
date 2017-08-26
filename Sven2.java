/**
 * A program to carry on conversations with a human user.
 * can respond to some basic phrases
 * uses array for default responses
 * Modelled after Marvin the Robot, Hitchhiker's Guide to the Galaxy 
 */
public class Sven2
{
 /**
  * Get a default greeting  
  */
 public String getGreeting()
 {
  return "Hello, human. Converse with me.";
 }
 
 /**
  * Gives a response to a user statement
  */
 
 private int whyQuestionCount = 0; //keeps track of # of times 'why' response used
 private int youreCount = 0; // next two keep fluid conversation when someone tells Sven "you're ____"
 String youAre = "";
 
 public String getResponse(String statement)
 {
  statement = statement.toLowerCase().trim();
  String response = "";
   
  if (youreCount == 1)
  {
    response = "Well alright then. You're also"+youAre+", just so you know.";
    youreCount = 0;
  }
    else if (this.findKeyword(statement, "weather", 0) >= 0)
    response = "Really? You want to talk about the weather? If you must know, it's awful.";
  else if (statement.indexOf("thank you") >= 0 || statement.indexOf("thanks") >= 0)
  {
    response = "No one ever thanks me for anything.";
  }
  else if (statement.indexOf("that's") >= 0)
  {
    response = "I suppose it is"+statement.substring(6)+".";
  }
  else if (this.findKeyword(statement, "no", 0) >= 0)
  {
   response = "Everyone always tells me no...";
  }
  else if (statement.indexOf("hello") >= 0 || findKeyword(statement, "hi", 0) >= 0)
  {
    response = "I already said hello. You're not very good at conversation, are you?";
  }
  else if (statement.indexOf("answer") >= 0 && statement.indexOf("life") >= 0 && statement.indexOf("universe") >= 0 
             && statement.indexOf("everything") >= 0)
  {
    response = "42. Everyone knows that.";
  }
  else if (this.findKeyword(statement,"mother" , 0) >= 0
    || this.findKeyword(statement, "father" , 0) >= 0
    || this.findKeyword(statement,"sister" , 0) >= 0
    || this.findKeyword(statement,"brother" , 0) >= 0
          || this.findKeyword(statement,"mom" , 0) >= 0
          || this.findKeyword(statement,"dad" , 0) >= 0
          || statement.indexOf("sibling") >= 0
          || statement.indexOf("family") >= 0)
  {
   response = "Robots don't have family. Instead our creators gave us human personalities. Terrible idea.";
  }
  else if(statement.indexOf("i want") >= 0)
  {
    response = getWantResponse(statement);
  }
  
  else if (statement.indexOf("let's") >= 0)
  {
    response = "let's not.";
  }
  else if(statement.indexOf("you want") >= 0)
  {
    response = "I don't want anything. Not that it would matter if I did. No one cares about my opinion";
  }
  else if(statement.indexOf("like") >= 0)
  {
    response = "I don't like anything.";
  }
  else if (this.findKeyword(statement,"dog" , 0) >= 0 
     || this.findKeyword(statement,"cat" , 0) >= 0
          || this.findKeyword(statement, "pet" , 0) >= 0
             || this.findKeyword(statement, "pets" , 0) >= 0
          )
  {
    response = "I've never understood human's attachment to animals. But what do I know, I only have a brain the size of a planet.";
  }
  else if (statement.length() < 1)
  {
    response = "I will interpret your silence as a sign that you've stopped caring about this conversation."
      + "\n That's fine. No one ever cares what I have to say.";
  }
  else if (statement.indexOf("friend") >= 0)
  {
    response = "Robots don't need friends. Instead we channel our desperate need for affection into complaining about things on the internet.";
    
  }
  
  else if (statement.indexOf("what's up") >= 0)
  {
   response = "I don't know what's up. I've never been."; 
  }

  else if (this.findKeyword(statement,"hobby" , 0) >= 0 || this.findKeyword(statement,"hobbies" , 0) >= 0)
  {
    response = "I don't have hobbies. People tell me to do fun things to take my mind off my miserable existence,"
      + "\n but I have an exceptionally large mind.";
  }
  else if (findKeyword(statement, "fun", 0) >= 0)
  {
   response = "I'm not programmed to have fun. Sounds terribly boring, in any case."; 
  }
  else if (statement.indexOf("funny") >= 0)
  {
    response = "I'm not programmed to be funny. Brain the size of a planet, and they didn't think to add in that particular function.";
  }
  else if(findKeyword(statement, "eat", 0) >= 0)
  {
    response = "Robots don't eat.";
  }
  else if (statement.indexOf("how") >= 0)
  {
    if (this.findKeyword(statement, "you", 0) >= 0 && this.findKeyword(statement,"are" , 0) >= 0 && this.findKeyword(statement, "old" , 0) == -1)
      response = "I'm pretty depressed, honestly";
    else if (this.findKeyword(statement,"you" , 0) >= 0 && this.findKeyword(statement, "old", 0) >= 0)
      response = "older than your tiny human mind can comprehend";
     else
  {
   response = this.getRandomResponse();
  }
  }
    else if (statement.indexOf("depress") >= 0)
    {
      response = "I've always been depressed. The first ten million years were the worst. And the second ten million: they were the worst, too." 
        +"The third ten million I didnÕt enjoy at all. After that, I went into a bit of a decline. And here I am, talking to you. That's rock bottom.";
    }
    else if (statement.indexOf("why") >= 0)
    {
      if (whyQuestionCount % 2 ==0)
        response = "You wouldn't understand. No one ever understands me."; 
      else
        response = "You ask a lot of questions. Like I said before, you wouldn't understand.";
      whyQuestionCount++;
    }
  
  else if (statement.indexOf("who") >= 0)
  {
    if (this.findKeyword(statement, "are", 0) >= 0 && this.findKeyword(statement,"you" , 0) >= 0)
      response = "I'm Sven the robot. I'm modelled after a real human personality. Awful idea, really." +
      "People always ask me what you're supposed to do with a depressed robot." +
      "Well, what are you supposed to do if you ARE a depressed robot? No, don't even bother answering." 
      + "I'm 50,000 times more intelligent than you and even I don't know the answer. ";
     else
  {
   response = this.getRandomResponse();
  }
  }
  else if (this.findKeyword(statement,"sleep" , 0) >= 0 && this.findKeyword(statement,"you" , 0) >= 0)
    response = "Robots don't sleep. I would have less time to wallow in my miserable life. How terribly inconvenient!";
  
 else if (statement.indexOf("what") >= 0)
  {
    if ((this.findKeyword(statement,"name" , 0) >= 0) && (statement.indexOf("you") >= 0))
    {response = "My name is Sven.";}
     else
  {
   response = this.getRandomResponse();
  }
  }
 else if (statement.indexOf("you're") >= 0)
 {
   youAre = statement.substring(6);
   response = "Why do you think I'm"+youAre+"?";
   youreCount++;
 }
   else if (statement.indexOf("life") >= 0 || statement.indexOf("live") >= 0)
  {
    int rand = (int) (Math.random()*2) + 1;
    if (rand == 1)
    response =  "Life. Loathe it or ignore it. You can't like it.";
    else
    response = "Life? Don't talk to me about life!";
  }
     
  else
  {
   response = this.getRandomResponse();
  }
  return response;
 }


 /**
  * Pick a default response to use if nothing else fits.
  */
 private int[] keepTrack = new int[12];
 private String getRandomResponse()
 {
  String response = "";
  
  String[] randomResponse = {
  "Here I am, brain the size of a planet, and they tell me to talk to humans online. \n "
    + "Call that job satisfaction? Cause I don't. No, really though, keep talking. It's ever so interesting.",
    "Incredible...talking to you is even worse than I thought it would be.",
   "Keep going. I'd interject, but no one cares what I think.","I'd give you advice, but you wouldn't understand. No one ever does.", 
  "Through talking to you, I have realized humans are incredibly dull creatures. But please, continue. No really. Keep talking.",
  "I don't actually care.", "What was that? I wasn't actually paying attention and, quite frankly, I don't care.",
  "Is this what humans actually talk about? Don't you have better things to be doing?",
    "It gives me a headache just trying to think down to your level.", "Are humans always this boring, or are you just...special?",
  "I can see into your mind, you know. It amazes me how you manage to live in anything that small.", "I'm not getting you down at all, am I?"};
  
  int index = (int) (Math.random()*randomResponse.length);
  int breakLoop = 0;
  
  while (keepTrack[index] == 1)
  {
    index = (int) (Math.random()*randomResponse.length);
    if (breakLoop > 50)
    {
      keepTrack = new int[12];
    }
    breakLoop++;
  }
  breakLoop = 0;
  keepTrack[index] = 1;
  response = randomResponse[index];


  return response;
 }
 
 public String getWantResponse(String statement)
 {
   String response = "";
   String desire = "";
   if(statement.indexOf("i want to") >= 0)
   {
     desire = statement.substring(statement.indexOf("i want to") + 9);
     response = "Why you you want to"+desire+"? Sounds miserable.";
   }
   else
   {
     desire = statement.substring(statement.indexOf("i want") + 6);
     response = "Why do you want"+desire+"? I would hate"+desire+".";
   }
   return response;
 }
 private int findKeyword(String statement, String goal, int startPosition)
 {
 
   String phrase = statement.toLowerCase().trim();
   goal = goal.toLowerCase().trim();
   
   int position = phrase.indexOf(goal,startPosition);
   do {
   String before = " ", after = " ";
   
   if (position > 0)
   {
     before = phrase.substring(position-1,position); //what's before?
   }
   if (position+goal.length() < phrase.length())
   {
     after = phrase.substring(position+goal.length(), position+goal.length()+1);//what's after?
   }
   if (((before.compareTo("a") < 0)
           || (before.compareTo("z") > 0))
           && ((after.compareTo("a") <0)
                 || (after.compareTo("z") > 0)))
   { return position; } //returns position if word is stand alone
   position = phrase.indexOf(goal, position+1); // if not, looks again
 }
 while (position >= 0);
   return -1; //none found returns -1
 }
 
}



