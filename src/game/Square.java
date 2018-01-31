package game;

import core.GameObject;
import core.Utils;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;

public class Square extends GameObject implements PhysicBody {
    public Vector2D velocity;
    private BoxCollider boxCollider;
    int lives;

    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20, 20);
        this.lives =1;
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - this.image.getWidth()/2, this.position.y - this.image.getHeight()/2);
    }

    @Override
    public BoxCollider getBoxcollider() {
        return this.boxCollider;
    }
}
