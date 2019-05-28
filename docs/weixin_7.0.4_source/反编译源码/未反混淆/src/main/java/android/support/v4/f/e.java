package android.support.v4.f;

import java.io.Writer;

public final class e extends Writer {
    private StringBuilder mBuilder = new StringBuilder(128);
    private final String mTag;

    public e(String str) {
        this.mTag = str;
    }

    public final void close() {
        flushBuilder();
    }

    public final void flush() {
        flushBuilder();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                flushBuilder();
            } else {
                this.mBuilder.append(c);
            }
        }
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }
}
