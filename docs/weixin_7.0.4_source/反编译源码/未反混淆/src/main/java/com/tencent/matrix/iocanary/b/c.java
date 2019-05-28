package com.tencent.matrix.iocanary.b;

public final class c {
    private static final c bWo = new c();
    private static volatile boolean bWp = true;
    private static volatile b bWq = new a();

    public interface b {
    }

    static final class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void setEnabled(boolean z) {
        bWp = z;
    }

    private c() {
    }
}
