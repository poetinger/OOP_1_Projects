package cardGame.game;

import cardGame.model.AbstractDeck;
import cardGame.model.CompleteDeck;
import cardGame.model.Card;
import cardGame.model.DiscardPile;

import java.util.Observable;
import java.util.Observer;

/**
 * Represents a silly 'game' (if you can even call it that) that draws cards
 * until the deck is empty, then shuffles them all back in.
 */
public class Draw extends Observable implements Observer {

    private AbstractDeck deck;
    
    /**
     * Create a deck with all cards in Card
     */
    private static AbstractDeck makeDeck() {
        AbstractDeck deck = new CompleteDeck();
        deck.shuffle();
        return deck;
    }

    
    /**
     * Create a new Draw with 12 cards, 6 pairs
     */
    public Draw() {
        deck = makeDeck();
    }
    
    /**
     * Getter for deck so it may be looked at without being changed
     */
    public AbstractDeck getDeck() {
        return deck;
    }
    
    
    /**
     * Put all cards back into the deck and shuffle it
     */
    public void reset() {
        deck = makeDeck();
        setChanged();
        notifyObservers();
    }
    
    /** 
     * If the movable card updates this updates too
     */
    @Override
    public void update(Observable observable, Object message) {
        setChanged();
        notifyObservers();
    }

}
