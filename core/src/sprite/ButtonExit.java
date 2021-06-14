package sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import base.ScaledButton;
import math.Rectangle;

public class ButtonExit extends ScaledButton {

    private float height = 0.2f;
    private float padding = 0.95f;

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(height);
        setLeft(worldBounds.getLeft()*padding);
        setBottom(worldBounds.getBottom()*padding);

    }

    @Override
    protected void action() {
        Gdx.app.exit();
    }
}
