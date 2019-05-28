package org.b.b;

public class b extends RuntimeException {
    public b(String str, Exception exception) {
        super(str, exception);
    }

    public b(String str) {
        super(str, null);
    }
}
