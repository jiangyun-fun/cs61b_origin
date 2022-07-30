package byog.Core;

public class Coordinate {
    /**
     * @param x x coordinate;
     * @param y y coordinate;
     */
    private int x;
    private int y;
    private int xLen;
    private int yLen;

    Coordinate(int inputX, int inputY) {
        this.x = inputX;
        this.y = inputY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int xOffset(int xLen) {
        return xLen + x;
    }

    public int yOffset(int yLen) {
        return yLen + y;
    }

    public int xOffset() {
        return xLen + x;
    }

    public int yOffset() {
        return yLen + y;
    }



    public void setxLen(int xLen) {
        this.xLen = xLen;
    }

    public void setyLen(int yLen) {
        this.yLen = yLen;
    }

    public int getxLen() {
        return xLen;
    }

    public int getyLen() {
        return yLen;
    }
}
