package components;

public class PingCom {
    private Paddle paddle;
    private double target; // target y

    public PingCom(Paddle out){
        paddle = out;
    }

    public void update(int height ){
        if (paddle.gety() == target) {
            paddle.pdlRelease();
        }
        else if (paddle.gety() > target) {
            paddle.pdlUp();
        }
        else {
            paddle.pdlDown();
        }
        paddle.update(height);
    }

    public void setTarget(double x, double y, double dx, double dy){
        target = (-1*(dy*x)/dx) + y - 50;
        //System.out.println(x + " " + y + " " + dx + " " + dy + " \n" + target);
    }
}
