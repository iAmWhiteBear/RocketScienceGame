package base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import math.Rectangle;

public class Sprite extends Rectangle {

    protected float angle;
    protected float scale = 1;
    protected TextureRegion[] regions;
    protected int frame;

    public Sprite(TextureRegion region) {
        this.regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void draw(SpriteBatch batch){
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(),getHeight(),
                scale, scale,
                angle
        );
    }

    public void resize(Rectangle worldBounds){

    }

    /**
     * логика работы спрайта
     * @param deltaTime - время отрисовки фрейма
     */
    public void update(float deltaTime){

    }

    public boolean touchDown(Vector2 touch, int pointer, int button){
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button){
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer){
        return false;
    }

    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
