package kalendar.com.kalendar.detail;

/**
 * Created by César on 19/05/2015.
 */
public class Point {
    final String name;
    final int drawableId;

    public Point(String name, int drawableId)
    {
        this.name = name;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public int getDrawableId() {
        return drawableId;
    }
}
