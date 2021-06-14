package math;

import com.badlogic.gdx.math.Vector2;

public class Rectangle {

    public final Vector2 position = new Vector2();
    protected float halfHeight;
    protected float halfWidth;

    public Rectangle(){
    }

    public Rectangle (float x, float y, float halfHeight, float halfWidth){
        this.position.set(x,y);
        this.halfHeight = halfHeight;
        this.halfWidth = halfWidth;
    }

    public Rectangle(Rectangle from){
        this(from.position.x,from.position.y,from.halfHeight,from.halfWidth);
    }

    public float getLeft(){return position.x-halfWidth;}
    public float getRight(){return position.x+halfWidth;}
    public float getTop(){return position.y+halfHeight;}
    public float getBottom(){return position.y-halfHeight;}

    public float getHalfHeight(){return halfHeight;}
    public float getHalfWidth(){return halfWidth;}
    public float getHeight(){return halfHeight*2f;}
    public float getWidth(){return halfWidth*2f;}

    public void set(Rectangle from) {
        this.position.set(from.position);
        this.halfHeight = from.halfHeight;
        this.halfWidth = from.halfWidth;
    }

    public void setLeft(float left){position.x = left+halfWidth;}
    public void setRight(float right){position.x = right-halfWidth;}
    public void setTop(float top){position.y = top-halfHeight;}
    public void setBottom(float bottom){position.y = bottom+halfHeight;}

    public void setHeight(float height){this.halfHeight = height/2f;}
    public void setWidth(float width){this.halfWidth = width/2f;}
    public void setSize(float width, float height){
        setHeight(height);
        setWidth(width);
    }

    public boolean isMe(Vector2 touch) {
        return touch.x >= getLeft() && touch.x <= getRight() && touch.y <= getTop() && touch.y >= getBottom();
    }

    public boolean isOutside(Rectangle other) {
        return getLeft() > other.getRight() ||
                getRight() < other.getLeft() ||
                getBottom()> other.getTop() ||
                getTop() > other.getBottom();
    }













}
