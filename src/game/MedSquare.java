package game;

import core.Framecounter;
import core.GameObject;
import core.Utils;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;

public class MedSquare extends GameObject implements PhysicBody {
    public Vector2D velocity;
    Framecounter framecounter;
    BoxCollider boxCollider;
    int lives;

    public MedSquare() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.velocity = new Vector2D();
        framecounter = new Framecounter((int) (Math.random()*50+15));
        this.boxCollider = new BoxCollider(40, 40);
        lives =2;
    }

    public void shoot() {
        if (framecounter.run()) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position);
            enemyBullet.velocity.set(0.0f, 6.0f);
            GameObject.add(enemyBullet);
            framecounter.reset();
        }
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.shoot();
        this.boxCollider.position.set(this.position.x - this.image.getWidth()/2, this.position.y - this.image.getHeight()/2);

    }

    @Override
    public BoxCollider getBoxcollider() {
        return boxCollider;
    }
}
