package sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import base.Sprite;
import math.Rectangle;

public class Background extends Sprite {
    public Background(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(1f);
        this.position.set(worldBounds.position);
    }
}
