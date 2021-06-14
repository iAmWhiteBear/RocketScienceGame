package base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import math.MatrixUtils;
import math.Rectangle;

public class BaseScreen implements Screen, InputProcessor {
    protected SpriteBatch batch;
    private Rectangle screenBounds;
    private Rectangle worldBounds;
    private Rectangle glBounds;

    private Matrix4 worldToGl;
    private Matrix3 screenToWorld;


    private Vector2 pointer;

    @Override
    public void show() {
        batch = new SpriteBatch();
        screenBounds = new Rectangle();
        worldBounds = new Rectangle();
        glBounds = new Rectangle(0,0,1f,1f);
        worldToGl = new Matrix4();
        screenToWorld = new Matrix3();
        pointer = new Vector2();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        screenBounds.setSize(width,height);
        screenBounds.setLeft(0);
        screenBounds.setBottom(0);

        float aspect = width/(float) height;
        worldBounds.setHeight(1f);
        worldBounds.setWidth(1f*aspect);
        MatrixUtils.calcTransitionMatrix(worldToGl,worldBounds,glBounds);
        MatrixUtils.calcTransitionMatrix(screenToWorld,screenBounds,worldBounds);
        batch.setProjectionMatrix(worldToGl);
        resize(worldBounds);
    }

    public void resize(Rectangle worldBounds){

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();

    }
    ////// USER INPUT METHODS
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.pointer.set(screenX,screenBounds.getHeight()-screenY).mul(screenToWorld);
        touchDown(this.pointer,pointer,button);
        return false;
    }

    public boolean touchDown(Vector2 touch, int pointer, int button){
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this.pointer.set(screenX,screenBounds.getHeight()-screenY).mul(screenToWorld);
        touchUp(this.pointer,pointer,button);
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button){
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        this.pointer.set(screenX,screenBounds.getHeight()-screenY).mul(screenToWorld);
        touchDragged(this.pointer,pointer);
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer){
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
