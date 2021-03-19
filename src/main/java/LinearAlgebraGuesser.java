import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
//multiplying matrices to find the answer to a solution to a linear system by
//guessing

/*read in the parameters of a given problem matrix for example:
how many chickens and cows if there are 10 heads and 30 feet?
answer: 5 chickens and 5 cows. given by heads = 1:Cow and 1:Chicken and
feet = 4:cow and 2:chicken. if we set up in a matrix we get chicken[h=1  f=2]
and cow[h=1 f=4] we also can have Head[chicken=1 cow=1] and 
feet[chicken=2 cow=4]. In order to come to the correct conclusion we need to
narrow our random selection down to the number of total possible animals.
we can do this by saying that since each animal has one head, and there are 10
heads in the sample, then there can be no more than 10 total animals. Next we
ask what is the maximum number of the animal with the largest portion of another
trait, in this case feet. There can be a maximum of 30/4= 7 cows with 28 feet
with the remainder going to one chicken. heads = 8 in this case. here we must
add 2 heads while balancing the feet. this is done by taking the ratio of feet
chicken=2 and cow=4; per animal, or chicken = 1/2 cow and cow = 2 chicken. since
2 more heads are necessary they must come from chickens, but that subtracts one
cow/2 chickens to keep feet in track so we have to add a multiple of 2 chickens
to not have partial animals leading us to our second guess of adding 4 chickens
and subtracting 2 cows, or having 5 each.
create a corresponding matrix to guess the answer to the question of how many
components are in a system in correlation with how many relatable parts of
components in a system are observed.  This is a logical guessing system not
a math solving system, per se*/



public class LinearAlgebraGuesser {
    
    //This is the first step. It creates the primary dictionary. The number
    //parameter is only a building phase input
    public static ConcurrentHashMap Matrix(int number){
        ConcurrentHashMap matrix = new ConcurrentHashMap();
        //ConcurrentHashMap guess = new ConcurrentHashMap();
        for (int i = 0; i< number; i++ ){
        matrix.put(MakeSubjects(), MakeAttributes());
        }
    //guess.putAll(matrix);
    return matrix;
    }
    
    /*public static ConcurrentHashMap RandomGuess(int number){
        ConcurrentHashMap randomGuess = new ConcurrentHashMap();
        randomGuess.keySet(Matrix(number));
        
    return randomGuess;
    }*/
    //
    public static ConcurrentHashMap MakeAttributes(){
        Scanner userInput = new Scanner(System.in);
        String reset = "";
        ConcurrentHashMap attributes = new ConcurrentHashMap();
        while (!reset.equals("done")) {
            System.out.println("Enter an attribute for the subject, type "
                + "\"done\" to finish ");
            String attribute = userInput.next();
            reset = attribute;
            if (reset.equalsIgnoreCase("done")){
            continue;
            }
            attributes.put(attribute, NumberofAttributes());
        }
        return attributes;
    }
    
    public static int NumberofAttributes(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the number of items the subject has, press "
                + "\"Enter\": ");
        int number = userInput.nextInt();
    return number;
    }
    
    public static String MakeSubjects(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a subject or whole object: ");
        String subject = userInput.next();
    return subject;
    }
    
    
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many objects will you create? ");
        int numberofObjects = userInput.nextInt();
        ConcurrentHashMap originalMatrix = Matrix(numberofObjects);
        //ConcurrentHashMap guess = RandomGuess(numberofObjects);
        System.out.println(originalMatrix);
        //System.out.println(guess);
    }
}
