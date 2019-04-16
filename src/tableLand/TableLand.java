package tableLand;

public class TableLand {

    private String nameTableLand;
    //x
    private Integer width;
    //y
    private Integer length;

    public TableLand(String nameTableLand, Integer width, Integer length) {
        this.nameTableLand = nameTableLand;
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
        return nameTableLand;
    }
}
