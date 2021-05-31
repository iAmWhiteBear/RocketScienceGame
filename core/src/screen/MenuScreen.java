package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture img;
    private TextureRegion region;
    private Vector2 pos;
    private Vector2 distance;
    private Vector2 speed;

    @Override
    public void show() {
        super.show();
        img = new Texture("HK.png");
        region = new TextureRegion(img,0,0,256,256);
        distance = new Vector2();
        speed = new Vector2();
        pos = new Vector2(50,50);



    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ScreenUtils.clear(0.27f, 0.709f, 0.737f, 1);
        move();
        batch.begin();
        batch.draw(region, pos.x, pos.y,126,126);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        float inversY = Gdx.graphics.getHeight() - screenY;
        distance = new Vector2(screenX,inversY);
        speed.set(distance.cpy().sub(pos).setLength(1));
        return super.touchUp(screenX, screenY, pointer, button);

    }

    private void move() {
        pos.add(speed);
        if (distance.cpy().sub(pos).len()<1){
            speed.set(0,0);
        }
    }
}
