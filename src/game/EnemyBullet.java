package game;

import core.GameObject;
import core.Utils;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;

public class EnemyBullet extends GameObject implements PhysicBody {
    public Vector2D velocity;
    BoxCollider boxCollider;

    public EnemyBullet() {
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10, 10);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - this.image.getWidth()/2, this.position.y - this.image.getHeight()/2);
        this.deactiveIfNeeded();
    }

    @Override
    public BoxCollider getBoxcollider() {
        return boxCollider;
    }

    private void deactiveIfNeeded() {
        if (this.position.y >600)
            this.isAlive = false;
        if (this.position.x <0)
            this.isAlive = false;
        if (this.position.x >400)
            this.isAlive = false;
    }
}
