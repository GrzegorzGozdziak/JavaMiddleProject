package pl.sda.model;

public enum StreetPrefix {

    STREET("ul."), AVENIUE("al."), SQUARE("pl.");

    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }






    StreetPrefix(String prefix) {
        this.prefix = prefix;
    }
}
