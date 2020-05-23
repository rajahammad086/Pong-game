// Raja Hammad Mehmood
// Creating a class of Pong Table.
import java.awt.*;
public class PongTable {

    PongBall ball_; // making a ball object
    PongPaddle paddle1_; //making the first paddle
    PongPaddle paddle2_; // making the second paddle
    private int width_; // width of the table
    private int height_;// height of the table
    /**
     * A constructor for the Pong Table
    *@param1 is the width
    *@param2 is the height
    */
    public PongTable(int width, int height) {
        // initializing the instance variables accordingly
        width_=width;
        height_=height;
        paddle1_=new PongPaddle(0,100,10,50,Color.RED);
        paddle2_=new PongPaddle(300,100,10,50,Color.RED);
        ball_=new PongBall(150,100,4,2,2,Color.BLUE);

    }
    /**
     * method for moving the ball and handling the collision with walls or paddle
    */
    public void  doAnimateStep() {
        ball_.move();
        if (Bouncer.getPaddleSideHit(paddle1_,ball_)==Bouncer.RIGHT || Bouncer.getPaddleSideHit(paddle2_,ball_)==Bouncer.LEFT ) {
            ball_.bounceX();

        } else if(Bouncer.getWallHit(0,300,0,200,ball_)==Bouncer.LEFT || Bouncer.getWallHit(0,300,0,200,ball_)==Bouncer.RIGHT) {
            ball_.setPosition(150, (int)(Math.random()*201));
        } else if (Bouncer.getWallHit(0,300,0,200,ball_)==Bouncer.TOP || Bouncer.getWallHit(0,300,0,200,ball_)==Bouncer.BOTTOM) {
            ball_.bounceY();
        }

        // painting everything
        ball_.paint();
        paddle1_.paint();
        paddle2_.paint();

    }
    /**
     * method for handling the character
    *@param1 is the character
    */

    public void handleChar(char character) {
        if(character=='a') {
            if(paddle1_.getTop()>=2) {
                paddle1_.moveUp(2);
            }
        } else if(character=='z') {
            if(paddle1_.getBottom()<=198) {
                paddle1_.moveDown(2);
            }
        } else if(character=='k') {
            if(paddle2_.getTop()>=2) {
                paddle2_.moveUp(2);
            }
        } else if(character=='m') {
            if  (paddle2_.getBottom()<=198) {
                paddle2_.moveDown(2);
            }
        }
    }
}

