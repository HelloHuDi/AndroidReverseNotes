package com.tencent.matrix.iocanary.p159b;

/* renamed from: com.tencent.matrix.iocanary.b.c */
public final class C1078c {
    private static final C1078c bWo = new C1078c();
    private static volatile boolean bWp = true;
    private static volatile C1077b bWq = new C1079a();

    /* renamed from: com.tencent.matrix.iocanary.b.c$b */
    public interface C1077b {
    }

    /* renamed from: com.tencent.matrix.iocanary.b.c$a */
    static final class C1079a implements C1077b {
        private C1079a() {
        }

        /* synthetic */ C1079a(byte b) {
            this();
        }
    }

    public static void setEnabled(boolean z) {
        bWp = z;
    }

    private C1078c() {
    }
}
