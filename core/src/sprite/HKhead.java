package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import base.Sprite;
import math.Rectangle;

public class HKhead extends Sprite {
    private final float SPEEDMOD = 0.004f;
    private Vector2 distance;
    private Vector2 delta;
    private Vector2 speed;

    public HKhead(Texture texture) {
        super(new TextureRegion(texture));
        distance = new Vector2();
        delta = new Vector2();
        speed = new Vector2();
    }

    @Override
    public void draw(SpriteBatch batch) {
        move();
        super.draw(batch);
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.15f);
        this.position.set(new Vector2(0f,-0.5f+this.halfHeight));
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        distance = new Vector2(touch);
        delta.set(distance);
        speed.set(delta.sub(position).setLength(SPEEDMOD));
        return true;
    }

    private void move() {
        position.add(speed);
        delta.set(distance);
        if (delta.sub(position).len()<SPEEDMOD){
            position.set(distance);
            speed.set(0,0);
        }
    }
}
