 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twentyone;

/**
 *
 * @author Kyle'sPC
 */
import java.util.*;

public class Deck {
    private Stack<Card> cards;
    private Card[] cardsArray = new Card[52];
    public Deck() {
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        cards = new Stack<Card>();
        for(int i = 0; i < 52; i++) {
            cards.push(new Card(suits[i / 13], getName(i), getValue(i))); 
        }
    } 
    
    public void shuffle() {
        shuffleHelper();
        shuffleHelper();
        shuffleHelper();
    }
    
    public String toString() {
        String s = "";
        if(!cards.isEmpty()) {
            Card temp;       
            temp = cards.pop();
            s += temp.getName() +" of " + temp.getSuit();
            Stack<Card> cardsTemp = new Stack<Card>();
            cardsTemp.push(temp);
            while(!cards.isEmpty()) {
                temp = cards.pop();
                s += "\n" + temp.getName() + " of " + temp.getSuit();
                cardsTemp.push(temp);
            }
            while(!cardsTemp.isEmpty()) {
                cards.push(cardsTemp.pop());
            }
        }
        return s;
    }
    
    private void shuffleHelper() {
        Stack[] stacks = new Stack[10];
        Random random = new Random();
        for(int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<Card>();
        }
        while(!cards.isEmpty()) {
            stacks[random.nextInt(stacks.length)].push(cards.pop());
        }
        for(Stack<Card> s : stacks) {
            while(!s.isEmpty()) {
                cards.push(s.pop());
            }
        }
        
    }
    
    private String getName(int i) {
        String name = null;
        switch((i % 13) + 1) {
            case 1: name = "Ace";
                break;
            case 2: name = "Two";
                break;
            case 3: name = "Three";
                break;
            case 4: name = "Four";
                break;
            case 5: name = "Five";
                break;
            case 6: name = "Six";
                break;
            case 7: name = "Seven";
                break;
            case 8: name = "Eight";
                break;
            case 9: name = "Nine";
                break;
            case 10: name = "Ten";
                break;
            case 11: name = "Jack";
                break;
            case 12: name = "Queen";
                break;
            case 13: name = "King";
                break;
        }
        return name;
    }
    
    private int getValue(int i) {
        int value = 0;
        value = (i % 13) + 1;
        if(value > 10)
            return 10;
        return value;
    }
}
