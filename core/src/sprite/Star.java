package sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import base.Sprite;
import math.Rectangle;
import math.Rnd;

public class Star extends Sprite {
    private final Vector2 speed;
    private final float starDistance;
    private Rectangle worldBounds;

    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        speed = new Vector2();
        starDistance = (float) Math.random(); //более далёкие звёзды должны двигаться медленнее
        float speedX = Rnd.nextFloat(-0.0003f,0.0003f)*starDistance;
        float speedY = Rnd.nextFloat(- 0.03f, - 0.01f)*starDistance;
        speed.set(speedX,speedY);
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setHeightProportion(0.01f*starDistance);
        float x = Rnd.nextFloat(worldBounds.getLeft(),worldBounds.getRight());
        float y = Rnd.nextFloat(worldBounds.getBottom(),worldBounds.getTop());
        position.set(x,y);
    }

    @Override
    public void update(float deltaTime) {
        position.mulAdd(speed,deltaTime);
        if (getTop() < worldBounds.getBottom()) setBottom(worldBounds.getTop());
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());}
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());}
        System.out.println(position.x);
        super.update(deltaTime);
    }

    public void setCloseSpeed(){

    }


    private void setFarSpeed() {
    }


}
