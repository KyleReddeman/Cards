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
public class Card {
    private final String suit;
    private final String name;
    private final int value;
    
    public Card() {
        this.suit = "";
        this.name = "";
        this.value = 0;
    }
    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }
    public String getSuit() {
        return suit;
    }
    
    public String getName() {
        return name;
    }
    
    public int getValue() {
        return value;
    }
    
}
