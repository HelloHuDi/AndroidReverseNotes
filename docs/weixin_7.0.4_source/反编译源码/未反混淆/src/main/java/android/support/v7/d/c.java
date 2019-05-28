package android.support.v7.d;

public final class c {
    public static final c XW;
    public static final c XX;
    public static final c XY;
    public static final c XZ;
    public static final c Ya;
    public static final c Yb;
    public final float[] Yc = new float[3];
    public final float[] Yd = new float[3];
    public final float[] Ye = new float[3];
    public boolean Yf = true;

    static {
        c cVar = new c();
        XW = cVar;
        c(cVar);
        d(XW);
        cVar = new c();
        XX = cVar;
        b(cVar);
        d(XX);
        cVar = new c();
        XY = cVar;
        a(cVar);
        d(XY);
        cVar = new c();
        XZ = cVar;
        c(cVar);
        e(XZ);
        cVar = new c();
        Ya = cVar;
        b(cVar);
        e(Ya);
        cVar = new c();
        Yb = cVar;
        a(cVar);
        e(Yb);
    }

    c() {
        e(this.Yc);
        e(this.Yd);
        this.Ye[0] = 0.24f;
        this.Ye[1] = 0.52f;
        this.Ye[2] = 0.24f;
    }

    private static void e(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private static void a(c cVar) {
        cVar.Yd[1] = 0.26f;
        cVar.Yd[2] = 0.45f;
    }

    private static void b(c cVar) {
        cVar.Yd[0] = 0.3f;
        cVar.Yd[1] = 0.5f;
        cVar.Yd[2] = 0.7f;
    }

    private static void c(c cVar) {
        cVar.Yd[0] = 0.55f;
        cVar.Yd[1] = 0.74f;
    }

    private static void d(c cVar) {
        cVar.Yc[0] = 0.35f;
        cVar.Yc[1] = 1.0f;
    }

    private static void e(c cVar) {
        cVar.Yc[1] = 0.3f;
        cVar.Yc[2] = 0.4f;
    }
}
