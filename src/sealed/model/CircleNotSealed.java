package sealed.model;

public non-sealed class CircleNotSealed implements Shape{

    @Override
    public int surface() {
        return 0;
    }
}
