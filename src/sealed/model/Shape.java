package sealed.model;

public sealed interface Shape permits CircleNotSealed, RectangleRecord, SquareFinal {

    int surface();
}
