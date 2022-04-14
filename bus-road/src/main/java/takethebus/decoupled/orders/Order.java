package takethebus.decoupled.orders;

public record Order(String id, long quantity, String type) {
    public boolean isCsv() {
        return type.equals("csv");
    }

    public boolean isExcel() {
        return type.equals("xls");
    }
}
