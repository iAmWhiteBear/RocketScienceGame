package base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public abstract class SpritePool<T extends Sprite> {

    protected final List<T> activeObjects = new ArrayList<>();
    protected final List<T> freeObjects = new ArrayList<>();

    protected abstract  T newObject();

    public T obtain(){
        T object;
        if(freeObjects.isEmpty()){
            object = newObject();
        } else {
            object = freeObjects.remove(freeObjects.size()-1);
        }
        activeObjects.add(object);
        return object;
    }

    public void updateActiveSprites(float delta){
        for (Sprite s: activeObjects){
            if (!s.isDestroyed()){
                s.update(delta);
            }
        }
    }

    public void drawActiveSprites(SpriteBatch batch){
        for (Sprite s: activeObjects){
            if (!s.isDestroyed()){
                s.draw(batch);
            }
        }
    }

    private void free(T object){
        if(activeObjects.remove(object)){
            freeObjects.add(object);
        }
    }

    public void freeAllDestroyed(){
        for (int i = 0; i < activeObjects.size(); i++) {
            T sprite = activeObjects.get(i);
            if (sprite.isDestroyed()){
                free(sprite);
                i--;
                sprite.flushDestroy();
            }
        }
    }


    public void dispose(){
        activeObjects.clear();
        freeObjects.clear();
    }

    public List<T> getActiveObjects() {
        return activeObjects;
    }
}
