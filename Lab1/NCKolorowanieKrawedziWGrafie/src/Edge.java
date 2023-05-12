class Edge {
    private int start;
    private int end;
    private int color;

    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean intersect(Edge other) {
        return (start == other.start || start == other.end
                || end == other.start || end == other.end);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}