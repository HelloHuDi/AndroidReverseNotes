package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.p822gl.JNICallback.C25720d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24382gs.C24381c;
import com.tencent.tencentmap.mapsdk.p666a.C36459bg;
import com.tencent.tencentmap.mapsdk.p666a.C36467cs;
import com.tencent.tencentmap.mapsdk.p666a.C36470cu;
import com.tencent.tencentmap.mapsdk.p666a.C36470cu.C36468b;
import com.tencent.tencentmap.mapsdk.p666a.C36470cu.C36469c;
import com.tencent.tencentmap.mapsdk.p666a.C36470cu.C36471a;
import com.tencent.tencentmap.mapsdk.p666a.C41019ct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jx */
public class C44527jx extends C36519hz implements C25720d, C46785fq, C41049fr, C41050ft {
    /* renamed from: a */
    public static int f17448a = 1;
    /* renamed from: d */
    private static final TimeUnit f17449d = TimeUnit.SECONDS;
    /* renamed from: b */
    ArrayList<C46798ka> f17450b = new ArrayList();
    /* renamed from: c */
    ArrayList<C46798ka> f17451c = new ArrayList();
    /* renamed from: e */
    private int f17452e;
    /* renamed from: f */
    private final int f17453f = 80;
    /* renamed from: g */
    private float[] f17454g;
    /* renamed from: h */
    private C36471a f17455h;
    /* renamed from: i */
    private C31061iz f17456i;
    /* renamed from: j */
    private C44528jy f17457j;
    /* renamed from: k */
    private C36469c f17458k;
    /* renamed from: l */
    private C36468b f17459l;
    /* renamed from: m */
    private C31075lb f17460m;
    /* renamed from: n */
    private final BlockingQueue<Runnable> f17461n = new LinkedBlockingQueue();
    /* renamed from: o */
    private ThreadPoolExecutor f17462o;
    /* renamed from: p */
    private final BlockingQueue<Runnable> f17463p = new LinkedBlockingQueue();
    /* renamed from: q */
    private ThreadPoolExecutor f17464q;
    /* renamed from: r */
    private int f17465r = -1;
    /* renamed from: s */
    private C36459bg f17466s;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jx$a */
    class C16292a implements Runnable {
        /* renamed from: b */
        private List<C36467cs> f3460b;

        public C16292a(List<C36467cs> list) {
            this.f3460b = list;
        }

        public void run() {
            AppMethodBeat.m2504i(100137);
            C44527jx.m80795a(C44527jx.this, C44527jx.this.f17450b);
            C44527jx.m80795a(C44527jx.this, C44527jx.this.f17451c);
            C44527jx.this.f17460m.mo40689a(this.f3460b);
            if (C44527jx.this.f17458k != null) {
                C44527jx.this.f17458k.mo57695a();
            }
            C44527jx.this.f17456i.mo75386b().mo20232j(C44527jx.this.f17465r);
            AppMethodBeat.m2505o(100137);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jx$1 */
    class C365251 implements ThreadFactory {
        C365251() {
        }

        public Thread newThread(Runnable runnable) {
            AppMethodBeat.m2504i(100136);
            Thread thread = new Thread(runnable);
            thread.setPriority(3);
            AppMethodBeat.m2505o(100136);
            return thread;
        }
    }

    public C44527jx(C31061iz c31061iz, C36470cu c36470cu) {
        AppMethodBeat.m2504i(100138);
        this.f17455h = c36470cu.mo57700e();
        this.f17458k = c36470cu.mo57697b();
        this.f17452e = c36470cu.mo57698c();
        this.f17459l = c36470cu.mo57699d();
        if (this.f17459l == null) {
            this.f17459l = new C46799kc();
        }
        m80794a(c31061iz);
        mo70905a(c36470cu.mo57696a());
        this.f17466s = new C36459bg();
        this.f17456i.mo75386b().mo20167a((C25720d) this);
        this.f17465r = this.f17456i.mo75386b().mo20139B();
        AppMethodBeat.m2505o(100138);
    }

    /* renamed from: a */
    private void m80794a(C31061iz c31061iz) {
        AppMethodBeat.m2504i(100139);
        this.f17456i = c31061iz;
        this.f17457j = new C44528jy(this.f17456i);
        this.f17460m = new C24400lc(this);
        this.f17462o = new ThreadPoolExecutor(1, 1, 30, f17449d, this.f17461n, new C365251());
        this.f17464q = new ThreadPoolExecutor(1, 1, 30, f17449d, this.f17463p);
        if (this.f17455h != null) {
            this.f17454g = this.f17455h.mo57701a(this.f17452e);
            if (this.f17454g == null || this.f17454g.length < (this.f17452e * 4) * this.f17452e) {
                System.err.println("Invalid fade out matrix, fail to default.");
            }
            this.f17456i.mo75386b().mo20172a((C46785fq) this);
            this.f17456i.mo75386b().mo20174a((C41050ft) this);
            this.f17456i.mo75386b().mo20173a((C41049fr) this);
            AppMethodBeat.m2505o(100139);
        }
        this.f17454g = m80801f();
        this.f17456i.mo75386b().mo20172a((C46785fq) this);
        this.f17456i.mo75386b().mo20174a((C41050ft) this);
        this.f17456i.mo75386b().mo20173a((C41049fr) this);
        AppMethodBeat.m2505o(100139);
    }

    /* renamed from: a */
    public void mo70905a(List<C36467cs> list) {
        AppMethodBeat.m2504i(100140);
        try {
            this.f17464q.execute(new C16292a(list));
            AppMethodBeat.m2505o(100140);
        } catch (Exception e) {
            AppMethodBeat.m2505o(100140);
        }
    }

    /* renamed from: f */
    private float[] m80801f() {
        AppMethodBeat.m2504i(100141);
        float[] fArr = new float[(((this.f17452e * 2) * 2) * this.f17452e)];
        for (int i = 0; i < this.f17452e * 2; i++) {
            for (int i2 = 0; i2 < this.f17452e * 2; i2++) {
                float sqrt = (float) Math.sqrt((double) (((i - this.f17452e) * (i - this.f17452e)) + ((i2 - this.f17452e) * (i2 - this.f17452e))));
                if (1.0f - (sqrt / ((float) this.f17452e)) < 0.0f) {
                    sqrt = 0.0f;
                } else {
                    sqrt = (float) ((Math.exp(((double) (-sqrt)) / 10.0d) - Math.exp(((double) (-this.f17452e)) / 10.0d)) / Math.exp(0.0d));
                }
                fArr[((i2 * 2) * this.f17452e) + i] = sqrt;
            }
        }
        AppMethodBeat.m2505o(100141);
        return fArr;
    }

    /* renamed from: a */
    public void mo29441a(GL10 gl10) {
    }

    /* renamed from: a */
    public boolean mo29444a(float f, float f2) {
        return false;
    }

    /* renamed from: a */
    public boolean mo29443a() {
        return false;
    }

    /* renamed from: b */
    public void mo29445b() {
        AppMethodBeat.m2504i(100142);
        this.f17456i.mo75386b().mo20196b((C46785fq) this);
        this.f17456i.mo75386b().mo20197b((C41050ft) this);
        if (this.f17461n != null) {
            this.f17461n.clear();
        }
        if (this.f17462o != null) {
            this.f17462o.shutdownNow();
        }
        if (this.f17463p != null) {
            this.f17463p.clear();
        }
        if (this.f17464q != null) {
            this.f17464q.shutdownNow();
        }
        m80796a(this.f17450b);
        m80796a(this.f17451c);
        System.gc();
        AppMethodBeat.m2505o(100142);
    }

    /* renamed from: a */
    private void m80796a(ArrayList<C46798ka> arrayList) {
        AppMethodBeat.m2504i(100143);
        if (arrayList == null) {
            AppMethodBeat.m2505o(100143);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C46798ka) it.next()).mo75505a();
        }
        arrayList.clear();
        AppMethodBeat.m2505o(100143);
    }

    /* renamed from: d */
    public void mo29450d() {
        AppMethodBeat.m2504i(100144);
        this.f17456i.mo75386b().mo20167a(null);
        this.f17456i.mo75386b().mo20229i(this.f17465r);
        this.f17465r = -1;
        this.f17466s = null;
        mo29445b();
        AppMethodBeat.m2505o(100144);
    }

    /* renamed from: a */
    public Bitmap mo43566a(byte[] bArr) {
        AppMethodBeat.m2504i(100145);
        if (this.f17465r == -1) {
            AppMethodBeat.m2505o(100145);
            return null;
        }
        this.f17466s.mo57660a(bArr);
        this.f17457j.mo70910a().mo40611e();
        C46798ka c46798ka = new C46798ka(this.f17466s.mo57659a(), this.f17466s.mo57661b(), this.f17466s.mo57662c());
        DoublePoint doublePoint = new DoublePoint((double) ((this.f17466s.mo57659a() * 256) << (20 - this.f17466s.mo57662c())), (double) ((this.f17466s.mo57661b() * 256) << (20 - this.f17466s.mo57662c())));
        DoublePoint doublePoint2 = new DoublePoint((double) (((this.f17466s.mo57659a() + 1) * 256) << (20 - this.f17466s.mo57662c())), (double) (((this.f17466s.mo57661b() + 1) * 256) << (20 - this.f17466s.mo57662c())));
        c46798ka.mo75508a(doublePoint);
        c46798ka.mo75510b(doublePoint2);
        Bitmap a = m80792a(c46798ka);
        AppMethodBeat.m2505o(100145);
        return a;
    }

    /* renamed from: c */
    public void mo29449c() {
    }

    /* renamed from: a */
    private Bitmap m80792a(C46798ka c46798ka) {
        int[] a;
        AppMethodBeat.m2504i(100146);
        int i = 256 / f17448a;
        int i2 = 256 / f17448a;
        DoublePoint c = c46798ka.mo75511c();
        DoublePoint d = c46798ka.mo75512d();
        double pow = 1.0d / Math.pow(2.0d, (double) (20 - c46798ka.mo75509b()));
        List<C41069kb> a2 = this.f17460m.mo40688a(new DoublePoint(c.f2800x - (((double) this.f17452e) / pow), c.f2801y - (((double) this.f17452e) / pow)), new DoublePoint(d.f2800x + (((double) this.f17452e) / pow), d.f2801y + (((double) this.f17452e) / pow)), pow);
        ArrayList arrayList = new ArrayList();
        for (C41069kb c41069kb : a2) {
            DoublePoint a3 = c41069kb.mo65154a();
            double b = c41069kb.mo65156b();
            pow = a3.f2800x - c.f2800x;
            double d2 = a3.f2801y - c.f2801y;
            double a4 = this.f17457j.mo70908a(c46798ka.mo75509b());
            arrayList.add(new C41019ct(pow * a4, a4 * d2, b));
        }
        if (this.f17455h != null) {
            a = this.f17455h.mo57702a(arrayList, this.f17454g, this.f17452e, 256, this.f17459l);
            if (a == null || a.length != 65536) {
                a = m80797a(arrayList, this.f17454g, (float) this.f17452e, 256, this.f17459l);
            }
        } else {
            a = m80797a(arrayList, this.f17454g, (float) this.f17452e, 256, this.f17459l);
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(a, i2, i, Config.ARGB_8888);
            c46798ka.mo75507a(createBitmap);
            AppMethodBeat.m2505o(100146);
            return createBitmap;
        } catch (Exception | OutOfMemoryError e) {
            AppMethodBeat.m2505o(100146);
            return null;
        }
    }

    /* renamed from: a */
    private int[] m80797a(List<C41019ct> list, float[] fArr, float f, int i, C36468b c36468b) {
        AppMethodBeat.m2504i(100147);
        float[] fArr2 = new float[(i * i)];
        int[] iArr = new int[(i * i)];
        if (!(list == null || list.isEmpty())) {
            int i2;
            for (C41019ct c41019ct : list) {
                double c = c41019ct.mo65068c();
                double a = c41019ct.mo65066a();
                double b = c41019ct.mo65067b();
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
                                fArr2[i4] = (float) (((double) fArr2[i4]) + (((double) fArr[((i2 * 2) * this.f17452e) + i3]) * c));
                            }
                        }
                        i2 = i3 + 1;
                    }
                }
            }
            for (i2 = 0; i2 < i * i; i2++) {
                if (fArr2[i2] > 0.0f) {
                    iArr[i2] = c36468b.colorForValue((double) fArr2[i2]);
                }
            }
        }
        AppMethodBeat.m2505o(100147);
        return iArr;
    }

    /* renamed from: c_ */
    public void mo70906c_() {
        AppMethodBeat.m2504i(100148);
        mo29449c();
        AppMethodBeat.m2505o(100148);
    }

    /* renamed from: a */
    public void mo29503a(C24381c c24381c) {
        AppMethodBeat.m2504i(100149);
        if (c24381c != C24381c.NO_CHANGED) {
            mo29449c();
        }
        AppMethodBeat.m2505o(100149);
    }

    /* renamed from: a */
    public void mo65135a(double d) {
        AppMethodBeat.m2504i(100150);
        if (d > 1.0d || d < -1.0d) {
            mo29449c();
        }
        AppMethodBeat.m2505o(100150);
    }

    /* renamed from: e */
    public C44528jy mo70907e() {
        return this.f17457j;
    }
}
