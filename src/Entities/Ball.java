package Entities;

import Util.CoordinatesConverter;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

public class Ball extends Entity {

    private CircleShape circleShape = new CircleShape();
    private Circle circle;

    public Ball(float x, float y, float height, float width, BodyType bodyType, World world) {
        super(x, y, height, width, bodyType, world);
        circle = new Circle(getX(),getY(),10);
        circleShape.m_radius = 10.0f;
        // TODO : Move to entity
        FixtureDef fd = new FixtureDef();
        fd.shape = circleShape;
        fd.density = 0.5f;
        fd.friction = 0.3f;
        fd.restitution = 0.5f;

        body =  getWorld().createBody(getBodyDef());
        body.createFixture(fd);
    }

    @Override
    public void Update() {
        Vec2 position = body.getPosition();
        float angle = body.getAngle();
        //System.out.printf("%4.2f %4.2f %4.2f\n", position.x, position.y, angle);
        System.out.printf("%4.2f %4.2f %4.2f\n", CoordinatesConverter.toPixelPosX(position.x), CoordinatesConverter.toPixelPosY(position.y), angle);
        circle.setX(CoordinatesConverter.toPixelPosX(position.x));
        circle.setY(CoordinatesConverter.toPixelPosY(position.y));
    }

    @Override
    public void Render(Graphics graphics) {
        graphics.draw(circle);
    }
}
