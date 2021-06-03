package sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import base.Sprite;
import math.Rectangle;

public class ShipPlayer extends Sprite {

    private final float SCALE = 0.1f;
    private final float marginBot = 0.9f;
    private Rectangle worldBounds;

    private final float SPEED_MOD = 0.015f;
    private Vector2 speed = new Vector2();
    private Vector2 distance = new Vector2();
    private Vector2 nextLocation = new Vector2();


    private final TextureRegion normalShip;
    private final TextureRegion damagedShip;


    public ShipPlayer(TextureRegion region) {
        super(region);
        normalShip = new TextureRegion(region,0,0,region.getRegionWidth()/2,region.getRegionHeight());
        damagedShip = new TextureRegion(region,region.getRegionWidth()/2,0,region.getRegionWidth()/2,region.getRegionHeight());
        regions[0] = normalShip;
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setBottom(worldBounds.getBottom()*marginBot);
        setHeightProportion(SCALE);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        position.add(speed);
        distance.set(nextLocation);
        if (distance.sub(position).len()<SPEED_MOD){
            position.set(nextLocation);
            speed.set(0,0);
        }

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        calculateMoveTo(touch);
        return false;
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        calculateMoveTo(touch);
        return false;
    }

    public void keyDown(int keycode){
        switch (keycode){
            case 19: calculateMoveTo(nextLocation.set(position.x, getTop()+speed.y)); break;
            case 20: calculateMoveTo(nextLocation.set(position.x, getBottom()-speed.y)); break;
            case 21: calculateMoveTo(nextLocation.set(getLeft()-speed.x,position.y)); break;
            case 22: calculateMoveTo(nextLocation.set(getRight()+speed.x,position.y)); break;
        }
    }



    private void calculateMoveTo(Vector2 touch){
        nextLocation.set(touch);
        nextLocation.y = (worldBounds.getBottom()+getHalfHeight())*marginBot;
        if (nextLocation.x > worldBounds.getRight()) nextLocation.x = worldBounds.getRight();
        if (nextLocation.x < worldBounds.getLeft()) nextLocation.x = worldBounds.getLeft();
        distance.set(nextLocation);
        speed.set(distance.sub(position).setLength(SPEED_MOD));
    }


}
