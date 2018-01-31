package game;

import core.Framecounter;
import core.GameObject;
import core.Utils;
import physic.BoxCollider;
import physic.PhysicBody;

public class Player extends GameObject implements PhysicBody{


    Framecounter framecounter;
    BoxCollider boxCollider;

    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");
        framecounter = new Framecounter(5);
        boxCollider = new BoxCollider(20, 20);
    }

    private void shoot() {
        if (framecounter.run()) {
            Bullet bullet = new Bullet();
            bullet.position.set(this.position);
            bullet.velocity.set(0.0f, 5.0f);
            GameObject.add(bullet);
            framecounter.reset();
        }
    }

    @Override
    public void run() {
        super.run();
        this.shoot();
        this.boxCollider.position.set(this.position.x - this.image.getWidth()/2, this.position.y - this.image.getHeight()/2);
        MedSquare medSquare = GameObject.checkCollider(this.boxCollider, MedSquare.class);
        if (medSquare != null) {
            medSquare.isAlive = false;
            this.isAlive = false;
        }
        EnemyBullet enemyBullet = GameObject.checkCollider(this.boxCollider, EnemyBullet.class);
        if (enemyBullet != null) {
            enemyBullet.isAlive = false;
            this.isAlive = false;
        }
        Square square = GameObject.checkCollider(this.boxCollider, Square.class);
        if (square!= null) {
            square.isAlive= false;
            this.isAlive = false;
        }

        Boss boss = GameObject.checkCollider(this.boxCollider, Boss.class);
        if (boss!= null) {
            boss.isAlive= false;
            this.isAlive = false;
        }
    }


    @Override
    public BoxCollider getBoxcollider() {
        return boxCollider;
    }
}
