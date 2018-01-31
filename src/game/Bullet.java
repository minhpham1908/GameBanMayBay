package game;

import core.GameObject;
import core.Utils;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;

public class Bullet extends GameObject implements PhysicBody {
    public Vector2D velocity;
    private BoxCollider boxCollider;
    public  static int diemso =0;

    public Bullet() {
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(13, 10);
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
        this.boxCollider.position.set(this.position.x - this.image.getWidth()/2, this.position.y - this.image.getHeight()/2);

        Square square = GameObject.checkCollider(this.boxCollider, Square.class);
        if (square!= null) {
            square.lives --;
            if (square.lives ==0) {
                square.isAlive= false;
                diemso ++;
            }
            this.isAlive = false;
        }
        MedSquare medSquare = GameObject.checkCollider(this.boxCollider, MedSquare.class);
        if (medSquare != null) {
            medSquare.lives --;
            if (medSquare.lives == 0) {
                medSquare.isAlive = false;
                diemso +=2;
            }
            this.isAlive = false;
        }

        Boss boss = GameObject.checkCollider(this.boxCollider, Boss.class);
        if (boss != null) {
            boss.lives--;
            if (boss.lives == 0) {
                boss.isAlive =false;
                diemso +=100;
            }
            this.isAlive = false;
        }

        this.deactiveIfNeeded();
//        if (!(boss.isAlive))
    }

    @Override
    public BoxCollider getBoxcollider() {
        return boxCollider;
    }

    private void deactiveIfNeeded() {
        if (this.position.y <0)
            this.isAlive = false;
    }
}
