package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bg;
import com.tencent.tencentmap.mapsdk.a.cs;
import com.tencent.tencentmap.mapsdk.a.ct;
import com.tencent.tencentmap.mapsdk.a.cu;
import com.tencent.tencentmap.mapsdk.a.cu.b;
import com.tencent.tencentmap.mapsdk.a.cu.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.opengles.GL10;

public class jx extends hz implements d, fq, fr, ft {
    public static int a = 1;
    private static final TimeUnit d = TimeUnit.SECONDS;
    ArrayList<ka> b = new ArrayList();
    ArrayList<ka> c = new ArrayList();
    private int e;
    private final int f = 80;
    private float[] g;
    private com.tencent.tencentmap.mapsdk.a.cu.a h;
    private iz i;
    private jy j;
    private c k;
    private b l;
    private lb m;
    private final BlockingQueue<Runnable> n = new LinkedBlockingQueue();
    private ThreadPoolExecutor o;
    private final BlockingQueue<Runnable> p = new LinkedBlockingQueue();
    private ThreadPoolExecutor q;
    private int r = -1;
    private bg s;

    class a implements Runnable {
        private List<cs> b;

        public a(List<cs> list) {
            this.b = list;
        }

        public void run() {
            AppMethodBeat.i(100137);
            jx.a(jx.this, jx.this.b);
            jx.a(jx.this, jx.this.c);
            jx.this.m.a(this.b);
            if (jx.this.k != null) {
                jx.this.k.a();
            }
            jx.this.i.b().j(jx.this.r);
            AppMethodBeat.o(100137);
        }
    }

    public jx(iz izVar, cu cuVar) {
        AppMethodBeat.i(100138);
        this.h = cuVar.e();
        this.k = cuVar.b();
        this.e = cuVar.c();
        this.l = cuVar.d();
        if (this.l == null) {
            this.l = new kc();
        }
        a(izVar);
        a(cuVar.a());
        this.s = new bg();
        this.i.b().a((d) this);
        this.r = this.i.b().B();
        AppMethodBeat.o(100138);
    }

    private void a(iz izVar) {
        AppMethodBeat.i(100139);
        this.i = izVar;
        this.j = new jy(this.i);
        this.m = new lc(this);
        this.o = new ThreadPoolExecutor(1, 1, 30, d, this.n, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                AppMethodBeat.i(100136);
                Thread thread = new Thread(runnable);
                thread.setPriority(3);
                AppMethodBeat.o(100136);
                return thread;
            }
        });
        this.q = new ThreadPoolExecutor(1, 1, 30, d, this.p);
        if (this.h != null) {
            this.g = this.h.a(this.e);
            if (this.g == null || this.g.length < (this.e * 4) * this.e) {
                System.err.println("Invalid fade out matrix, fail to default.");
            }
            this.i.b().a((fq) this);
            this.i.b().a((ft) this);
            this.i.b().a((fr) this);
            AppMethodBeat.o(100139);
        }
        this.g = f();
        this.i.b().a((fq) this);
        this.i.b().a((ft) this);
        this.i.b().a((fr) this);
        AppMethodBeat.o(100139);
    }

    public void a(List<cs> list) {
        AppMethodBeat.i(100140);
        try {
            this.q.execute(new a(list));
            AppMethodBeat.o(100140);
        } catch (Exception e) {
            AppMethodBeat.o(100140);
        }
    }

    private float[] f() {
        AppMethodBeat.i(100141);
        float[] fArr = new float[(((this.e * 2) * 2) * this.e)];
        for (int i = 0; i < this.e * 2; i++) {
            for (int i2 = 0; i2 < this.e * 2; i2++) {
                float sqrt = (float) Math.sqrt((double) (((i - this.e) * (i - this.e)) + ((i2 - this.e) * (i2 - this.e))));
                if (1.0f - (sqrt / ((float) this.e)) < 0.0f) {
                    sqrt = 0.0f;
                } else {
                    sqrt = (float) ((Math.exp(((double) (-sqrt)) / 10.0d) - Math.exp(((double) (-this.e)) / 10.0d)) / Math.exp(0.0d));
                }
                fArr[((i2 * 2) * this.e) + i] = sqrt;
            }
        }
        AppMethodBeat.o(100141);
        return fArr;
    }

    public void a(GL10 gl10) {
    }

    public boolean a(float f, float f2) {
        return false;
    }

    public boolean a() {
        return false;
    }

    public void b() {
        AppMethodBeat.i(100142);
        this.i.b().b((fq) this);
        this.i.b().b((ft) this);
        if (this.n != null) {
            this.n.clear();
        }
        if (this.o != null) {
            this.o.shutdownNow();
        }
        if (this.p != null) {
            this.p.clear();
        }
        if (this.q != null) {
            this.q.shutdownNow();
        }
        a(this.b);
        a(this.c);
        System.gc();
        AppMethodBeat.o(100142);
    }

    private void a(ArrayList<ka> arrayList) {
        AppMethodBeat.i(100143);
        if (arrayList == null) {
            AppMethodBeat.o(100143);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ka) it.next()).a();
        }
        arrayList.clear();
        AppMethodBeat.o(100143);
    }

    public void d() {
        AppMethodBeat.i(100144);
        this.i.b().a(null);
        this.i.b().i(this.r);
        this.r = -1;
        this.s = null;
        b();
        AppMethodBeat.o(100144);
    }

    public Bitmap a(byte[] bArr) {
        AppMethodBeat.i(100145);
        if (this.r == -1) {
            AppMethodBeat.o(100145);
            return null;
        }
        this.s.a(bArr);
        this.j.a().e();
        ka kaVar = new ka(this.s.a(), this.s.b(), this.s.c());
        DoublePoint doublePoint = new DoublePoint((double) ((this.s.a() * 256) << (20 - this.s.c())), (double) ((this.s.b() * 256) << (20 - this.s.c())));
        DoublePoint doublePoint2 = new DoublePoint((double) (((this.s.a() + 1) * 256) << (20 - this.s.c())), (double) (((this.s.b() + 1) * 256) << (20 - this.s.c())));
        kaVar.a(doublePoint);
        kaVar.b(doublePoint2);
        Bitmap a = a(kaVar);
        AppMethodBeat.o(100145);
        return a;
    }

    public void c() {
    }

    private Bitmap a(ka kaVar) {
        int[] a;
        AppMethodBeat.i(100146);
        int i = 256 / a;
        int i2 = 256 / a;
        DoublePoint c = kaVar.c();
        DoublePoint d = kaVar.d();
        double pow = 1.0d / Math.pow(2.0d, (double) (20 - kaVar.b()));
        List<kb> a2 = this.m.a(new DoublePoint(c.x - (((double) this.e) / pow), c.y - (((double) this.e) / pow)), new DoublePoint(d.x + (((double) this.e) / pow), d.y + (((double) this.e) / pow)), pow);
        ArrayList arrayList = new ArrayList();
        for (kb kbVar : a2) {
            DoublePoint a3 = kbVar.a();
            double b = kbVar.b();
            pow = a3.x - c.x;
            double d2 = a3.y - c.y;
            double a4 = this.j.a(kaVar.b());
            arrayList.add(new ct(pow * a4, a4 * d2, b));
        }
        if (this.h != null) {
            a = this.h.a(arrayList, this.g, this.e, 256, this.l);
            if (a == null || a.length != 65536) {
                a = a(arrayList, this.g, (float) this.e, 256, this.l);
            }
        } else {
            a = a(arrayList, this.g, (float) this.e, 256, this.l);
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(a, i2, i, Config.ARGB_8888);
            kaVar.a(createBitmap);
            AppMethodBeat.o(100146);
            return createBitmap;
        } catch (Exception | OutOfMemoryError e) {
            AppMethodBeat.o(100146);
            return null;
        }
    }

    private int[] a(List<ct> list, float[] fArr, float f, int i, b bVar) {
        AppMethodBeat.i(100147);
        float[] fArr2 = new float[(i * i)];
        int[] iArr = new int[(i * i)];
        if (!(list == null || list.isEmpty())) {
            int i2;
            for (ct ctVar : list) {
                double c = ctVar.c();
                double a = ctVar.a();
                double b = ctVar.b();
                if (c > 0.0d) {
                    i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (((float) i3) >= 2.0f * f) {
                            break;
                        }
                        for (i2 = 0; ((float) i2) < 2.0f * f; i2++) {
                            int i4 = (int) ((a - ((double) f)) + ((double) i3));
                            int i5 = (int) ((b - ((double) f)) + ((double) i2));
                            if (i5 >= 0 && i4 >= 0 && i5 < i && i4 < i) {
                                i4 += i5 * i;
                                fArr2[i4] = (float) (((double) fArr2[i4]) + (((double) fArr[((i2 * 2) * this.e) + i3]) * c));
                            }
                        }
                        i2 = i3 + 1;
                    }
                }
            }
            for (i2 = 0; i2 < i * i; i2++) {
                if (fArr2[i2] > 0.0f) {
                    iArr[i2] = bVar.colorForValue((double) fArr2[i2]);
                }
            }
        }
        AppMethodBeat.o(100147);
        return iArr;
    }

    public void c_() {
        AppMethodBeat.i(100148);
        c();
        AppMethodBeat.o(100148);
    }

    public void a(gs.c cVar) {
        AppMethodBeat.i(100149);
        if (cVar != gs.c.NO_CHANGED) {
            c();
        }
        AppMethodBeat.o(100149);
    }

    public void a(double d) {
        AppMethodBeat.i(100150);
        if (d > 1.0d || d < -1.0d) {
            c();
        }
        AppMethodBeat.o(100150);
    }

    public jy e() {
        return this.j;
    }
}
