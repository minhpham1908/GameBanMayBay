package game;

import core.Framecounter;
import core.GameObject;
import core.Utils;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;

public class Boss extends GameObject implements PhysicBody {
    public Vector2D velocity;
    private BoxCollider boxCollider;
    int lives;
    Framecounter framecounter;

    public Boss() {
        this.image = Utils.loadImage("resources/square/enemy_square_large.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(80, 80);
        this.lives = 100;
        framecounter = new Framecounter(50);
    }

    public void shoot() {
        if (framecounter.run()) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position);
            enemyBullet.velocity.set(0.0f, 3.0f);
            GameObject.add(enemyBullet);
            EnemyBullet enemyBullet2 = new EnemyBullet();
            enemyBullet2.position.set(this.position);
            enemyBullet2.velocity.set(-1.2f, 3.0f);
            GameObject.add(enemyBullet2);
            EnemyBullet enemyBullet3 = new EnemyBullet();
            enemyBullet3.position.set(this.position);
            enemyBullet3.velocity.set(1.2f, 3.0f);
            GameObject.add(enemyBullet3);
            framecounter.reset();
        }
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.shoot();
        if (this.position.y >= 150) {
            this.position.y = 150;
            this.velocity.set(0.0f, 0.0f);
        }
        this.boxCollider.position.set(this.position.x - this.image.getWidth()/2, this.position.y - this.image.getHeight()/2);
    }

    @Override
    public BoxCollider getBoxcollider() {
        return boxCollider;
    }
}
