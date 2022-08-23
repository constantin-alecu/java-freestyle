package sealed.model;

public /*final by default*/ record RectangleRecord(int width, int height) implements Shape {

    public RectangleRecord {
        if(width < 0 || height < 0){
            throw new IllegalArgumentException();
        }
    }
    @Override
    public int surface() {
        return width * height;
    }
}
