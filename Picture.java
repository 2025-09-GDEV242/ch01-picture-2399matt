/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Matthew Witham
 * @version 09.08.2025
 */
public class Picture
{
    private Circle pacMan;
    private Square background;
    private Triangle pacMouth;
    private Person leg1;
    private Person leg2;
    private Circle food1;
    private Circle food2;
    private Circle food3;
    private Circle ghost;
    private Circle ghostEye1;
    private Circle ghostEye2;
    private Circle ghostPupil1;
    private Circle ghostPupil2;
    private boolean drawn;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        leg1 = new Person();
        leg2 = new Person();
        background = new Square();
        pacMan = new Circle();
        pacMouth = new Triangle();
        food1 = new Circle();
        food2 = new Circle();
        food3 = new Circle();
        ghost = new Circle();
        ghostEye1 = new Circle();
        ghostEye2 = new Circle();
        ghostPupil1 = new Circle();
        ghostPupil2 = new Circle();
        drawn = false;
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        if(!drawn) {
            background.changeColor("black");
            background.changeSize(500);
            background.moveVertical(-200);
            background.moveHorizontal(-300);
            background.makeVisible();
            
            pacMan.changeSize(120);
            pacMan.changeColor("yellow");
            pacMan.moveHorizontal(-50);
            pacMan.makeVisible();
            
            pacMouth.changeColor("black");
            pacMouth.changeSize(55, 125);
            pacMouth.moveHorizontal(82);
            pacMouth.moveVertical(-20);
            pacMouth.makeVisible();
    
            food1.changeColor("orange");
            food1.changeSize(20);
            food1.moveHorizontal(80);
            food1.moveVertical(50);
            food1.makeVisible();
            
            food2.changeColor("orange");
            food2.changeSize(20);
            food2.moveHorizontal(125);
            food2.moveVertical(50);
            food2.makeVisible();
            
            food3.changeColor("orange");
            food3.changeSize(20);
            food3.moveHorizontal(170);
            food3.moveVertical(50);
            food3.makeVisible();
            
            leg1.moveHorizontal(-190);
            leg1.moveVertical(-30);
            leg1.changeColor("blue");
            leg1.changeSize(40,30);
            leg1.makeVisible();
            
            leg2.moveHorizontal(-170);
            leg2.moveVertical(-30);
            leg2.changeColor("blue");
            leg2.changeSize(40,30);
            leg2.makeVisible();
            
            ghost.changeColor("blue");
            ghost.changeSize(90);
            ghost.moveHorizontal(-180);
            ghost.makeVisible();
            
            ghostEye1.changeColor("white");
            ghostEye1.changeSize(25);
            ghostEye1.moveHorizontal(-120);
            ghostEye1.moveVertical(30);
            ghostEye1.makeVisible();
            
            ghostEye2.changeColor("white");
            ghostEye2.changeSize(25);
            ghostEye2.moveHorizontal(-160);
            ghostEye2.moveVertical(30);
            ghostEye2.makeVisible();
            
            ghostPupil1.changeColor("blue");
            ghostPupil1.changeSize(12);
            ghostPupil1.moveHorizontal(-111);
            ghostPupil1.moveVertical(40);
            ghostPupil1.makeVisible();
            
            ghostPupil2.changeColor("blue");
            ghostPupil2.changeSize(12);
            ghostPupil2.moveHorizontal(-150);
            ghostPupil2.moveVertical(40);
            ghostPupil2.makeVisible();
    
            drawn = true;
        }
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        background.changeColor("white");
        pacMan.changeColor("black");
        // layering issue
        pacMouth.changeColor("white");
        food1.changeColor("black");
        food2.changeColor("black");
        food3.changeColor("black");
        leg1.changeColor("black");
        leg2.changeColor("black");
        ghost.changeColor("black");
        ghostEye1.changeColor("white");
        ghostEye2.changeColor("white");
        ghostPupil1.changeColor("black");
        ghostPupil2.changeColor("black");
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        background.changeColor("black");
        pacMan.changeColor("yellow");
        pacMouth.changeColor("black");
        food1.changeColor("orange");
        food2.changeColor("orange");
        food3.changeColor("orange");
        leg1.changeColor("blue");
        leg2.changeColor("blue");
        ghost.changeColor("blue");
        ghostEye1.changeColor("white");
        ghostEye2.changeColor("white");
        ghostPupil1.changeColor("blue");
        ghostPupil2.changeColor("blue");
    }
    /**
     * Set pac-man in motion to eat the pac-dots and travel off screen. WIP
     */
    public void eatPacDots(){
        final int LOOP_COUNT = 8;
        final int STEP_COUNT = 45;
        for(int i = 1; i <= LOOP_COUNT; i++){
            
            // Choppy no matter what, could sync the draws with canvas?
            for(int j = 0; j < STEP_COUNT; j++){
                pacMan.moveHorizontal(1);
                pacMouth.moveHorizontal(1);
            }
     //       Thread thread1 = new Thread( () -> pacMan.slowMoveHorizontal(45));
     //       Thread thread2 = new Thread( () -> pacMouth.slowMoveHorizontal(45));
     //       thread1.start();
     //       thread2.start();
     //       try{
     //           thread1.join();
     //           thread2.join();
     //       }catch(Exception e){
     //           System.out.println("Pac dead: " + e.getMessage());
     //       }
            if(i == 1){
                food1.makeInvisible();
            }else if(i == 2){
                food2.makeInvisible();
            }else if(i == 3) {
                food3.makeInvisible();
            }else{
                // let him travel off the canvas.
                continue;
            }
        }
    }
}
