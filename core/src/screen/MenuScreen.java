package screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import base.BaseScreen;
import math.Rectangle;
import sprite.*;

public class MenuScreen extends BaseScreen {

    private final Game game;

    private static final int MENU_STARS = 256;

    private Texture bg;
    private TextureAtlas atlas;
    private Background background;
    private Star[] stars;
    private ButtonExit exitBtn;
    private ButtonPlay playBtn;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        background = new Background(bg);
        stars = new Star[MENU_STARS];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        exitBtn = new ButtonExit(atlas);
        playBtn = new ButtonPlay(atlas,game);


    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }


    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star s:stars) {
            s.resize(worldBounds);
        }
        exitBtn.resize(worldBounds);
        playBtn.resize(worldBounds);

    }

    public void draw(){
        ScreenUtils.clear(0.27f, 0.709f, 0.737f, 1);
        batch.begin();
        background.draw(batch);
        for (Star s:stars) {
            s.draw(batch);
        }
        exitBtn.draw(batch);
        playBtn.draw(batch);
        batch.end();


    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        exitBtn.touchDown(touch,pointer,button);
        playBtn.touchDown(touch,pointer,button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        exitBtn.touchUp(touch,pointer,button);
        playBtn.touchUp(touch,pointer,button);
        return false;
    }

    public void update(float delta){
        for (Star s:stars) {
            s.update(delta);
        }
    }


}
