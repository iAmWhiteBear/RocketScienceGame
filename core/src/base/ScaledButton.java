package base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class ScaledButton extends Sprite{

    private static final float SCALE = 0.9f;

    private boolean isPressed;
    private int pointer;

    public ScaledButton(TextureRegion region) {
        super(region);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (!isPressed && isMe(touch)){
            this.pointer = pointer;
            this.scale = SCALE;
            isPressed = true;
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        if (this.pointer!=pointer || !isPressed){
            return false;
        }
        if (isMe(touch)){
            action();
        }
        isPressed=false;
        scale = 1f;
        return false;
    }

    protected abstract void action();
}
