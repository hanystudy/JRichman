package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/11/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Size {

    private int width;
    private int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
