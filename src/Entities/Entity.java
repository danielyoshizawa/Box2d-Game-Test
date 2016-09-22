package Entities;

import Util.CoordinatesConverter;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.Graphics;

public abstract class Entity {

    private float x = 0.0f;
    private float y = 0.0f;
    private float height = 0.0f;
    private float width = 0.0f;
    private BodyDef bodyDef = new BodyDef();
    private World world;
    protected Body body;

    public Entity(float x, float y, float height, float width, BodyType bodyType, World world) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        bodyDef.position.set(CoordinatesConverter.toPosX(x), CoordinatesConverter.toPosY(y));
        bodyDef.type = bodyType;
        this.world = world;
    }

    public abstract void Update();
    public abstract void Render(Graphics graphics);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public BodyDef getBodyDef() {
        return bodyDef;
    }

    public World getWorld() {
        return world;
    }
}
