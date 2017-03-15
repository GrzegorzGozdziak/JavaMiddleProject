package pl.sda.model;

public enum StreetPrefix {

    STREET("ul."), AVENIUE("al."), SQUARE("pl.");

    public String getPrefix() {
        return prefix;
    }

    private final String prefix;

    StreetPrefix(String prefix) {
        this.prefix = prefix;
    }
}
