package pool;

import base.SpritePool;
import sprite.Bullet;

public class BulletPool extends SpritePool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
