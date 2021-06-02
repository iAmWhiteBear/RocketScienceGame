package screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import base.BaseScreen;
import math.Rectangle;
import sprite.Background;
import sprite.HKhead;

public class MenuScreen extends BaseScreen {
    private Texture bg,img;
    private Background background;
    private HKhead head;

    @Override
    public void show() {
        super.show();
        bg = new Texture("planet.jpeg");
        img = new Texture("HK.png");
        background = new Background(bg);
        head = new HKhead(img);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ScreenUtils.clear(0.27f, 0.709f, 0.737f, 1);
        batch.begin();
        background.draw(batch);
        head.draw(batch);
        batch.end();
    }


    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        head.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        head.touchUp(touch,pointer,button);
        return false;
    }
}
