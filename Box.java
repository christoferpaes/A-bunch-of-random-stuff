import java.lang.Math;


class Box extends Space3D {
    private double width;
    private double length;
    Box( double _length, double _width, int size, double _height) {
        super(size, _height);
        width = _width;
        length = _length;
        
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }



    public double getVolume() {
        double Volume;
        Volume = getHeight()* getLength() *getWidth();
        return Volume;
    }

    @Override
    public String toString(){

        return  "width" + width + "length" +length; 
    }
}
