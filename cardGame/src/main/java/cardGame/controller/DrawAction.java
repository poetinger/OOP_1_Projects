package cardGame.controller;

import cardGame.game.Draw;
import cardGame.game.MovableCard;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import java.util.Observer;
import java.util.Observable;

/**
 * Represents an action made to draw a card.
 */
public class DrawAction extends AbstractAction implements Observer {

    private Draw draw;

    /**
     * Makes sure the availability of the action reflects the availability of
     * the resource it acts on, namely, draw.
     */
    private void fixEnabled() {
        if(draw.getDeck().isEmpty())
            setEnabled(false);
        else
            setEnabled(true);
    }

    /**
     * Creates a new action to draw a card.
     */
    public DrawAction(Draw draw) {
        super("Start Timer!");
        this.draw = draw;
        draw.addObserver(this);
        fixEnabled();
    }

    /**
     * Draws a card
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implement card flip logic
    }
    
    /**
     * Since availability of this action depends on the state of the 
     * resources it itself depends on, this action verifies
     * after every update of draw if it can still be performed.
     */
    @Override
    public void update(Observable observed, Object message) {
        fixEnabled();
    }
    
}