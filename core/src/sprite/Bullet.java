package sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import base.Sprite;
import math.Rectangle;

public class Bullet extends Sprite {

    private Rectangle worldBounds;
    private Vector2 v;
    private int damage;
    private Sprite owner;

    public Bullet(){
        regions = new TextureRegion[1];
        v = new Vector2();
    }

    public void set(Sprite owner,
                    TextureRegion region,
                    Vector2 pos0,
                    Vector2 v0,
                    Rectangle worldBounds,
                    int damage,
                    float height){
        this.owner = owner;
        this.regions[0] = region;
        this.worldBounds = worldBounds;
        this.position.set(pos0);
        this.v.set(v0);
        this.damage = damage;
        setHeightProportion(height);
    }

    @Override
    public void update(float deltaTime) {
        position.mulAdd(v,deltaTime);
        if(isOutside(worldBounds)){
            desroy();
        }
    }

    public int getDamage() {
        return damage;
    }

    public Sprite getOwner() {
        return owner;
    }
}
