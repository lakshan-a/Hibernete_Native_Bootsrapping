package Hibernete.Boostrapping.NativeBoostRaping.embedded;

public class MobileNo {

    private String type;
    private String mobileLine;

    public MobileNo (){

    }

    public MobileNo(String type, String mobileLine) {
        this.type = type;
        this.mobileLine = mobileLine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobileLine() {
        return mobileLine;
    }

    public void setMobileLine(String mobileLine) {
        this.mobileLine = mobileLine;
    }

    @Override
    public String toString() {
        return "MobileNo{" +
                "type='" + type + '\'' +
                ", mobileLine='" + mobileLine + '\'' +
                '}';
    }
}
