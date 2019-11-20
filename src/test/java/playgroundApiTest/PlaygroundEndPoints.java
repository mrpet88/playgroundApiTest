package playgroundApiTest;

public enum PlaygroundEndPoints {
    PRODUCTS("http://localhost:3030/products/");
    private final String url;

    PlaygroundEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    }