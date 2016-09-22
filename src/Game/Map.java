package Game;

import Entities.Ball;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Map extends BasicGame {

    // TODO : Create a sync mechanics
    private Vec2 gravity = new Vec2(0.0f, -10.0f);
    private boolean doSleep = true;
    private World world = new World(gravity, doSleep);
    private Ball ball;

    float timeStep = 1.0f / 60.f;
    int velocityIterations = 6;
    int positionIterations = 2;

    // TODO : Create entities
    private BodyDef bodyDef = new BodyDef();

    public Map(String title) {
        super(title);
        world.setContinuousPhysics(false);

        ball = new Ball(10,0,10,10, BodyType.DYNAMIC, world);

        // Ground
        PolygonShape ps = new PolygonShape();
        ps.setAsBox(600,6);

        FixtureDef fd = new FixtureDef();
        fd.shape = ps;

        BodyDef bd = new BodyDef();
        bd.position= new Vec2(0.0f,-10.0f);

        world.createBody(bd).createFixture(fd);
    }

    @Override
    public void init(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        ball.Update();

        for (int i = 0; i < 60; ++i) {
            world.step(timeStep, velocityIterations, positionIterations);
        }
    }

    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException {
        ball.Render(graphics);
    }
}
