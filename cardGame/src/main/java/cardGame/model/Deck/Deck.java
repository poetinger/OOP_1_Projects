package cardGame.model.Deck;

import cardGame.model.Card.Card;
import cardGame.model.Card.FlippableCard;

/**
 * A deck that has all possible cards
 */
public class Deck extends AbstractDeck {

    /**
     * Add all possible cards
     */

    FlippableCard fp;
    protected void addCards() {
        for(Card card : Card.values()) {
            fp = new FlippableCard(card);
            //Make sure we add only FlippableCards to the deck
            addOnTop(fp);
        }
    }
}
