package core;

import game.Square;
import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {

    private static ArrayList<GameObject> list = new ArrayList<>();
    private static ArrayList<GameObject> newList = new ArrayList<>();

    public BufferedImage image;
    public Vector2D position;
    public boolean isAlive;

    public GameObject() {
        this.position = new Vector2D();
        this.isAlive = true;
    }

    public void run() {

    }

    public void render(Graphics2D graphics2D) {
        if( image != null)
        graphics2D.drawImage(this.image, (int) this.position.x - this.image.getWidth()/2, (int) this.position.y-this.image.getHeight()/2, null);

    }

    public static void add(GameObject gameObject) {
        newList.add(gameObject);
    }

    public static void renderAll(Graphics2D graphics2D) {
        for (GameObject gameObject: list) {
            if (gameObject.isAlive)
            gameObject.render(graphics2D);
        }
    }

    public static void runAll() {
        for (GameObject gameObject: list) {
            if (gameObject.isAlive)
                gameObject.run();
        }
        list.addAll(newList);
        newList.clear();
    }

    public static <T extends GameObject> T checkCollider(BoxCollider other, Class<T> cls) {
        for (GameObject gameObject: list) {
            if (!(gameObject.isAlive)) continue;
            if (!(cls.isInstance(gameObject))) continue;
            if (!(gameObject instanceof PhysicBody)) continue;
            BoxCollider boxCollider = ((PhysicBody) gameObject).getBoxcollider();
            if (boxCollider.checkBoxcollider(other)) {
                return (T) gameObject;
            }
        }
        return null;
    }

    public static void clear() {
        list.clear();
    }
}
