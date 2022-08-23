package sealed.model;

public final class SquareFinal implements Shape {

    private final int width;

    public SquareFinal(int width){
        this.width = width;
        if(width < 0){
            throw new IllegalArgumentException();
        }
    }
    @Override
    public int surface() {
        return width^2;
    }
}
