package sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import base.ScaledButton;
import math.Rectangle;
import screen.GameScreen;

public class ButtonPlay extends ScaledButton {

    private final float HEIGHT = 0.25f;
    private final Game game;
    private float padding = 0.95f;

    public ButtonPlay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setRight(worldBounds.getRight()*padding);
        setBottom(worldBounds.getBottom()*padding);

    }

    @Override
    protected void action() {
        game.setScreen(new GameScreen());
    }
}
