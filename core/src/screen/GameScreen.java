package screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import base.BaseScreen;
import math.Rectangle;
import pool.BulletPool;
import sprite.Background;
import sprite.Bullet;
import sprite.ShipPlayer;
import sprite.Star;

public class GameScreen extends BaseScreen {

    private final int GAME_STARS = 64;

    private Texture bg;
    private TextureAtlas atlas;
    private Background background;
    private Star[] stars;

    private BulletPool bulletPool;
    private ShipPlayer shipPlayer;


    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        background = new Background(bg);
        stars = new Star[GAME_STARS];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }

        bulletPool = new BulletPool();
        shipPlayer = new ShipPlayer(atlas,bulletPool);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        freeAllDestroyed();
        draw();
    }

    public void update(float delta){
        for (Star s:stars) {
            s.update(delta);
        }
        shipPlayer.update(delta);
        bulletPool.updateActiveSprites(delta);
    }

    public void draw(){
        ScreenUtils.clear(0.27f, 0.709f, 0.737f, 1);
        batch.begin();
        background.draw(batch);
        for (Star s:stars) {
            s.draw(batch);
        }
        shipPlayer.draw(batch);
        bulletPool.drawActiveSprites(batch);
        batch.end();
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star s:stars) {
            s.resize(worldBounds);
        }
        shipPlayer.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        atlas.dispose();
        bg.dispose();
        bulletPool.dispose();
    }

    private void freeAllDestroyed(){
        bulletPool.freeAllDestroyed();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        shipPlayer.touchDown(touch,pointer,button);
        return false;
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        shipPlayer.touchDragged(touch,pointer);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        shipPlayer.keyDown(keycode);
        return false;
    }
}
