package tableLand;

public class TableLand {

    //x
    private Integer width;
    //y
    private Integer length;

    public TableLand(Integer width, Integer length) {
        this.length = length;
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return getWidth() + " " + getLength();
    }

}
