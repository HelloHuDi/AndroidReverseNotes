package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.gl.JNICallback;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.opengles.GL10;

public class gm implements fn, fu {
    private String A;
    private boolean B = true;
    private boolean C = false;
    private int D = 0;
    private int E = 0;
    private Rect F;
    private float G = 0.5f;
    private float H = 0.5f;
    private boolean I = true;
    private int J = 18;
    private int K = 14;
    private boolean L = false;
    private gh a;
    private com.tencent.map.lib.gl.b b;
    private gk c;
    private ha d;
    private gl e;
    private gj f;
    private WeakReference<ge> g;
    private fp h;
    private Rect i;
    private boolean j;
    private boolean k;
    private Context l;
    private gv m;
    private d n;
    private gs o;
    private LinkedBlockingQueue<a> p;
    private gx q;
    private com.tencent.map.lib.a r;
    private volatile boolean s = false;
    private com.tencent.map.lib.util.c<Integer, Integer> t;
    private boolean u = true;
    private com.tencent.map.lib.b v;
    private boolean w = true;
    private b x;
    private c y;
    private gc z;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gm$1 */
    class AnonymousClass1 implements a {
        final /* synthetic */ gm a;

        public void a(GL10 gl10) {
            AppMethodBeat.i(99289);
            if (this.a.a != null) {
                this.a.b.b(gl10);
            }
            AppMethodBeat.o(99289);
        }
    }

    class e {
        private int a;
        private gw b;
        private j c;
        private int d;
        private int e;
        private Rect f;
        private int g;

        public synchronized boolean a() {
            return this.g == 2;
        }

        public synchronized void b() {
            this.g = 2;
            this.a = 0;
        }

        public boolean c() {
            return this.g == 1;
        }
    }

    class c implements MapLanguageChangeListener {
        private List<MapRouteSectionWithName> b;
        private List<GeoPoint> c;

        public c() {
            AppMethodBeat.i(99294);
            gm.this.a((MapLanguageChangeListener) this);
            AppMethodBeat.o(99294);
        }

        public void a() {
            AppMethodBeat.i(99295);
            gm.this.b((MapLanguageChangeListener) this);
            AppMethodBeat.o(99295);
        }

        public void a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
            AppMethodBeat.i(99296);
            this.b = list;
            this.c = list2;
            gm.this.a.a((List) list, (List) list2);
            AppMethodBeat.o(99296);
        }

        public void b() {
            AppMethodBeat.i(99297);
            gm.this.a.A();
            this.b = null;
            this.c = null;
            AppMethodBeat.o(99297);
        }

        public void onLanguageChange(MapLanguage mapLanguage) {
            AppMethodBeat.i(99298);
            if (mapLanguage != MapLanguage.LAN_CHINESE) {
                gm.this.a.A();
            } else if (!(this.b == null || this.c == null)) {
                gm.this.a.a(this.b, this.c);
                AppMethodBeat.o(99298);
                return;
            }
            AppMethodBeat.o(99298);
        }
    }

    class d {
        private final ArrayList<e> b;
        private e c;

        /* synthetic */ d(gm gmVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        private d() {
            AppMethodBeat.i(99299);
            this.b = new ArrayList();
            AppMethodBeat.o(99299);
        }

        private e b() {
            AppMethodBeat.i(99300);
            e eVar = null;
            synchronized (this.b) {
                try {
                    if (this.b.size() > 0) {
                        eVar = (e) this.b.get(0);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99300);
                }
            }
            return eVar;
        }

        public boolean a() {
            boolean z;
            AppMethodBeat.i(99301);
            synchronized (this.b) {
                try {
                    z = this.b == null || this.b.isEmpty();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99301);
                }
            }
            return z;
        }

        public synchronized e a(GL10 gl10) {
            e eVar = null;
            synchronized (this) {
                AppMethodBeat.i(99302);
                this.c = b();
                if (this.c == null) {
                    AppMethodBeat.o(99302);
                } else if (this.c.c()) {
                    a(this.c);
                    AppMethodBeat.o(99302);
                } else {
                    gm.this.c.h();
                    Rect c = this.c.f;
                    int d = this.c.d;
                    int e = this.c.e;
                    Rect rect = new Rect();
                    int density = (int) (SystemUtil.getDensity(gm.this.l) * 20.0f);
                    d = ((gm.this.i.width() - d) / 2) + density;
                    rect.right = d;
                    rect.left = d;
                    d = ((gm.this.i.height() - e) / 2) + density;
                    rect.bottom = d;
                    rect.top = d;
                    gm.this.c.b(c, rect);
                    eVar = this.c;
                    AppMethodBeat.o(99302);
                }
            }
            return eVar;
        }

        public synchronized void a(GL10 gl10, gj gjVar, fw fwVar) {
            AppMethodBeat.i(99303);
            if (gm.this.a == null) {
                AppMethodBeat.o(99303);
            } else {
                j f = this.c.c;
                if (f != null) {
                    if (f instanceof com.tencent.map.lib.element.a) {
                        ((com.tencent.map.lib.element.a) f).a(gjVar, fwVar);
                    }
                    f.b(gjVar, fwVar);
                }
                gjVar.a();
                AppMethodBeat.o(99303);
            }
        }

        public synchronized void b(GL10 gl10, gj gjVar, fw fwVar) {
            AppMethodBeat.i(99304);
            if (!(this.c == null || this.c.c())) {
                int d = this.c.d;
                int e = this.c.e;
                gw g = this.c.b;
                j f = this.c.c;
                Bitmap a = a(gl10, d, e);
                if (!(g == null || this.c.a())) {
                    g.a(a, f);
                }
                a(this.c);
            }
            AppMethodBeat.o(99304);
        }

        private void a(e eVar) {
            AppMethodBeat.i(99305);
            if (eVar == null || eVar.a()) {
                AppMethodBeat.o(99305);
                return;
            }
            eVar.b();
            synchronized (this.b) {
                try {
                    this.b.remove(eVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99305);
                }
            }
            gm.this.c.i();
        }

        private Bitmap a(GL10 gl10, int i, int i2) {
            Bitmap createBitmap;
            AppMethodBeat.i(99306);
            int i3 = i * i2;
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            gl10.glReadPixels((gm.this.i.width() - i) / 2, (gm.this.i.height() - i2) / 2, i, i2, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, wrap);
            for (i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = iArr[(i3 * i) + i4];
                    iArr2[(((i2 - i3) - 1) * i) + i4] = ((i5 & -16711936) | ((i5 << 16) & 16711680)) | ((i5 >> 16) & 255);
                }
            }
            try {
                createBitmap = Bitmap.createBitmap(iArr2, i, i2, Config.RGB_565);
            } catch (OutOfMemoryError e) {
                createBitmap = Bitmap.createBitmap(iArr2, i, i2, Config.RGB_565);
            }
            AppMethodBeat.o(99306);
            return createBitmap;
        }
    }

    class b {
        private List<MapLanguageChangeListener> b = new CopyOnWriteArrayList();

        public b() {
            AppMethodBeat.i(99290);
            AppMethodBeat.o(99290);
        }

        public MapLanguage a() {
            AppMethodBeat.i(99291);
            MapLanguage mapLanguage;
            if (gm.this.a == null) {
                mapLanguage = MapLanguage.LAN_CHINESE;
                AppMethodBeat.o(99291);
                return mapLanguage;
            } else if (gm.this.a.B() == 1) {
                mapLanguage = MapLanguage.LAN_ENGLISH;
                AppMethodBeat.o(99291);
                return mapLanguage;
            } else {
                mapLanguage = MapLanguage.LAN_CHINESE;
                AppMethodBeat.o(99291);
                return mapLanguage;
            }
        }

        public void a(MapLanguageChangeListener mapLanguageChangeListener) {
            AppMethodBeat.i(99292);
            if (mapLanguageChangeListener == null) {
                AppMethodBeat.o(99292);
                return;
            }
            synchronized (this.b) {
                try {
                    if (!this.b.contains(mapLanguageChangeListener)) {
                        this.b.add(mapLanguageChangeListener);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99292);
                }
            }
        }

        public void b(MapLanguageChangeListener mapLanguageChangeListener) {
            AppMethodBeat.i(99293);
            if (mapLanguageChangeListener == null) {
                AppMethodBeat.o(99293);
                return;
            }
            synchronized (this.b) {
                try {
                    if (this.b.contains(mapLanguageChangeListener)) {
                        this.b.remove(mapLanguageChangeListener);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99293);
                }
            }
        }
    }

    public interface a {
        void a(GL10 gl10);
    }

    public gh i() {
        return this.a;
    }

    public gm(Context context, ge geVar) {
        AppMethodBeat.i(99307);
        this.l = context;
        this.g = new WeakReference(geVar);
        this.a = new gh(context, this);
        this.o = new gs(this);
        this.i = new Rect();
        this.e = new gl(this);
        this.h = new fp(this.o, this);
        this.c = new gk(this);
        this.a.a(this.c);
        this.n = new d(this, null);
        this.p = new LinkedBlockingQueue();
        AppMethodBeat.o(99307);
    }

    public boolean a(Context context, com.tencent.map.lib.a aVar, hf hfVar) {
        AppMethodBeat.i(99308);
        this.r = aVar;
        if (this.r.d() != null) {
            com.tencent.map.lib.d.a = this.r.d().a();
        }
        com.tencent.map.lib.d.c("initEngine");
        gx a = aVar.a();
        this.q = a;
        this.a.a(aVar.b());
        this.b = new com.tencent.map.lib.gl.b(100);
        this.v = aVar.c();
        this.m = new gv(context, this, a, this.v);
        String c = a.c();
        String a2 = a.a();
        String b = a.b();
        try {
            this.m.a();
            boolean a3 = this.a.a(context, this.m, c, a2, b, 2.0f);
            this.m.b();
            this.f = new gj(this, this.b, this.a);
            if (this.d == null) {
                this.d = new ha(this, hfVar);
            }
            if (this.z == null) {
                this.z = new ga(this, this.r.b());
            }
            this.a.n();
            this.a.e(true);
            this.a.d(20);
            this.a.e(3);
            l(false);
            this.c.a((fu) this);
            AppMethodBeat.o(99308);
            return a3;
        } catch (Throwable th) {
            this.m.b();
            AppMethodBeat.o(99308);
        }
    }

    public boolean j() {
        AppMethodBeat.i(99309);
        if (this.a == null) {
            AppMethodBeat.o(99309);
            return false;
        }
        boolean b = this.a.b();
        AppMethodBeat.o(99309);
        return b;
    }

    public Context k() {
        return this.l;
    }

    public void l() {
        AppMethodBeat.i(99310);
        if (this.a == null) {
            AppMethodBeat.o(99310);
            return;
        }
        this.s = true;
        this.B = true;
        if (this.u) {
            this.c.c();
            this.u = false;
        } else {
            this.c.d();
        }
        if (!(this.g == null || this.g.get() == null)) {
            ((ge) this.g.get()).a_();
        }
        if (this.j) {
            this.a.i();
        }
        if (this.k && this.d != null) {
            this.d.d();
        }
        if (this.z != null) {
            this.z.c();
        }
        AppMethodBeat.o(99310);
    }

    public void m() {
        AppMethodBeat.i(99311);
        if (this.a == null) {
            AppMethodBeat.o(99311);
            return;
        }
        this.s = false;
        this.B = false;
        if (this.z != null) {
            this.z.d();
        }
        this.c.e();
        this.a.j();
        if (this.k && this.d != null) {
            this.d.c();
        }
        AppMethodBeat.o(99311);
    }

    public void n() {
        AppMethodBeat.i(99312);
        this.c.b((fu) this);
        if (this.y != null) {
            this.y.a();
        }
        this.c.f();
        this.u = true;
        if (this.z != null) {
            this.z.e();
        }
        if (this.d != null) {
            this.d.f();
        }
        if (this.a != null) {
            this.a.a();
        }
        this.l = null;
        AppMethodBeat.o(99312);
    }

    public void a(a aVar) {
        AppMethodBeat.i(99313);
        try {
            this.p.put(aVar);
            AppMethodBeat.o(99313);
        } catch (InterruptedException e) {
            AppMethodBeat.o(99313);
        }
    }

    public gk a() {
        return this.c;
    }

    public WeakReference<ge> b() {
        return this.g;
    }

    public gs e() {
        return this.o;
    }

    public gl c() {
        return this.e;
    }

    public gh f() {
        return this.a;
    }

    public fw d() {
        return this.h;
    }

    public Rect g() {
        return this.i;
    }

    public float h() {
        AppMethodBeat.i(99314);
        if (this.l == null) {
            AppMethodBeat.o(99314);
            return 1.0f;
        }
        float density = SystemUtil.getDensity(this.l);
        AppMethodBeat.o(99314);
        return density;
    }

    public gv o() {
        return this.m;
    }

    public void a(GL10 gl10) {
        AppMethodBeat.i(99315);
        if (this.a == null) {
            AppMethodBeat.o(99315);
            return;
        }
        if (this.b != null) {
            this.b.a();
        }
        AppMethodBeat.o(99315);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(99316);
        if (this.a == null) {
            AppMethodBeat.o(99316);
            return;
        }
        this.s = true;
        this.i.set(0, 0, i, i2);
        a(0, 0, i, i2, false);
        this.c.v();
        AppMethodBeat.o(99316);
    }

    public void a(Rect rect) {
        AppMethodBeat.i(99317);
        if (this.i == null || rect == null) {
            AppMethodBeat.o(99317);
            return;
        }
        this.F = rect;
        int width = this.i.width();
        int height = this.i.height();
        a(rect.left, rect.bottom, (width - rect.right) - rect.left, (height - rect.bottom) - rect.top, true);
        AppMethodBeat.o(99317);
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(99318);
        this.a.a(i, i2, i3, i4);
        this.D = i3;
        this.E = i4;
        if (z) {
            a(this.G, this.H, this.I);
        }
        AppMethodBeat.o(99318);
    }

    public Rect p() {
        return this.F;
    }

    public void a(float f, float f2, boolean z) {
        AppMethodBeat.i(99319);
        this.G = f;
        this.H = f2;
        double d = (double) f;
        double d2 = (double) f2;
        if (this.i != null) {
            if (this.E > 0) {
                d2 = 0.5d - (((0.5d - d2) * ((double) this.i.height())) / ((double) this.E));
            }
            if (this.D > 0) {
                d = 0.5d - (((0.5d - d) * ((double) this.i.width())) / ((double) this.D));
            }
        }
        this.a.b((float) d, (float) d2, z);
        AppMethodBeat.o(99319);
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(99320);
        if (this.i != null) {
            this.i.set(0, 0, i, i2);
        }
        AppMethodBeat.o(99320);
    }

    private void c(GL10 gl10) {
        AppMethodBeat.i(99321);
        if (this.p.size() == 0) {
            AppMethodBeat.o(99321);
            return;
        }
        Object obj = 1;
        while (obj != null) {
            a aVar = (a) this.p.poll();
            if (aVar != null) {
                try {
                    aVar.a(gl10);
                } catch (Exception e) {
                }
            } else {
                obj = null;
            }
        }
        AppMethodBeat.o(99321);
    }

    public boolean b(GL10 gl10) {
        AppMethodBeat.i(99322);
        if (this.a == null) {
            AppMethodBeat.o(99322);
            return false;
        }
        boolean z;
        synchronized (this.a) {
            try {
                this.c.C();
                c(gl10);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(99322);
                }
            }
        }
        this.a.u();
        if (this.a.v() || this.s) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            e a = this.n.a(gl10);
            if (a == null) {
                this.e.a(this.f, this.h);
            } else if (this.n != null && this.a.g()) {
                this.n.a(gl10, this.f, this.h);
            }
            synchronized (this.a) {
                try {
                    this.a.c();
                    this.s = false;
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(99322);
                    }
                }
            }
            if (!(this.n.a() || a == null)) {
                if (a.c()) {
                    a.a = 0;
                } else if (this.a.g() || a.a >= 100) {
                    a.a = 0;
                    this.n.b(gl10, this.f, this.h);
                } else {
                    a.a = a.a + 1;
                }
            }
            if (this.f != null) {
                this.f.c();
            }
        }
        if (this.f != null) {
            this.f.a();
        }
        AppMethodBeat.o(99322);
        return z;
    }

    public void q() {
        this.s = true;
    }

    public int r() {
        AppMethodBeat.i(99323);
        if (this.a != null) {
            int d = this.a.d();
            AppMethodBeat.o(99323);
            return d;
        }
        AppMethodBeat.o(99323);
        return -1;
    }

    public void s() {
        AppMethodBeat.i(99324);
        if (this.a != null) {
            this.a.e();
        }
        AppMethodBeat.o(99324);
    }

    public void t() {
        AppMethodBeat.i(99325);
        if (this.a != null) {
            this.a.f();
        }
        AppMethodBeat.o(99325);
    }

    public boolean u() {
        return this.k;
    }

    public void a(boolean z) {
        AppMethodBeat.i(99326);
        if (this.d != null) {
            this.k = z;
            if (z) {
                J();
                this.d.b();
                AppMethodBeat.o(99326);
                return;
            }
            K();
            this.d.e();
        }
        AppMethodBeat.o(99326);
    }

    public int a(Polygon2D polygon2D) {
        AppMethodBeat.i(99327);
        if (this.a == null || polygon2D == null) {
            AppMethodBeat.o(99327);
            return -1;
        }
        polygon2D.borderWidth *= SystemUtil.getDensity(this.l);
        int a = this.a.a(polygon2D);
        if (this.t == null) {
            this.t = new com.tencent.map.lib.util.c();
        }
        this.t.a(Integer.valueOf(a), Integer.valueOf(polygon2D.borldLineId));
        AppMethodBeat.o(99327);
        return a;
    }

    public void b(Polygon2D polygon2D) {
        AppMethodBeat.i(99328);
        if (this.a == null || polygon2D == null) {
            AppMethodBeat.o(99328);
            return;
        }
        polygon2D.borderWidth *= SystemUtil.getDensity(this.l);
        this.a.b(polygon2D);
        AppMethodBeat.o(99328);
    }

    public int a(CircleInfo circleInfo) {
        AppMethodBeat.i(99329);
        if (this.a == null || circleInfo == null) {
            AppMethodBeat.o(99329);
            return -1;
        }
        int a = this.a.a(circleInfo);
        AppMethodBeat.o(99329);
        return a;
    }

    public void a(int i, CircleInfo circleInfo) {
        AppMethodBeat.i(99330);
        if (this.a == null || circleInfo == null) {
            AppMethodBeat.o(99330);
            return;
        }
        this.a.a(i, circleInfo);
        AppMethodBeat.o(99330);
    }

    public void a(int i) {
        AppMethodBeat.i(99331);
        if (this.a == null || i == -1) {
            AppMethodBeat.o(99331);
            return;
        }
        this.a.a(i);
        AppMethodBeat.o(99331);
    }

    public int a(int i, int i2, int i3, int i4, int i5, float f) {
        int i6 = 255;
        AppMethodBeat.i(99332);
        if (this.a == null) {
            AppMethodBeat.o(99332);
            return -1;
        }
        int i7;
        int i8;
        int i9;
        int i10;
        if (i < 0) {
            i7 = 0;
        } else {
            i7 = i;
        }
        if (i7 > 255) {
            i8 = 255;
        } else {
            i8 = i7;
        }
        if (i2 < 0) {
            i7 = 0;
        } else {
            i7 = i2;
        }
        if (i7 > 255) {
            i9 = 255;
        } else {
            i9 = i7;
        }
        if (i3 < 0) {
            i7 = 0;
        } else {
            i7 = i3;
        }
        if (i7 > 255) {
            i10 = 255;
        } else {
            i10 = i7;
        }
        if (i4 < 0) {
            i7 = 0;
        } else {
            i7 = i4;
        }
        if (i7 <= 255) {
            i6 = i7;
        }
        MaskLayer maskLayer = new MaskLayer();
        maskLayer.color = new int[]{i8, i9, i10, 255 - i6};
        if (this.i != null) {
            maskLayer.width = this.i.width();
            maskLayer.height = this.i.height();
        }
        maskLayer.zIndex = f;
        maskLayer.layer = i5;
        i6 = this.a.a(maskLayer);
        this.e.a(i6, i5);
        AppMethodBeat.o(99332);
        return i6;
    }

    public void c(int i, int i2) {
        int i3 = 255;
        AppMethodBeat.i(99333);
        if (this.a == null) {
            AppMethodBeat.o(99333);
            return;
        }
        int i4;
        if (i2 < 0) {
            i4 = 0;
        } else {
            i4 = i2;
        }
        if (i4 <= 255) {
            i3 = i4;
        }
        i3 = 255 - i3;
        if (i3 == 0) {
            i3 = 1;
        }
        this.a.b(i, i3);
        AppMethodBeat.o(99333);
    }

    public void b(int i) {
        AppMethodBeat.i(99334);
        if (this.a == null) {
            AppMethodBeat.o(99334);
            return;
        }
        this.a.b(i);
        AppMethodBeat.o(99334);
    }

    public void c(int i) {
        AppMethodBeat.i(99335);
        if (!(this.a == null || this.t == null)) {
            int intValue;
            if (((Integer) this.t.a(Integer.valueOf(i))) != null) {
                intValue = ((Integer) this.t.a(Integer.valueOf(i))).intValue();
            } else {
                intValue = 0;
            }
            this.a.a(i, intValue);
        }
        AppMethodBeat.o(99335);
    }

    public void a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        AppMethodBeat.i(99336);
        if (this.y == null) {
            this.y = new c();
        }
        this.y.a(list, list2);
        AppMethodBeat.o(99336);
    }

    public void v() {
        AppMethodBeat.i(99337);
        if (this.y == null) {
            this.y = new c();
        }
        this.y.b();
        AppMethodBeat.o(99337);
    }

    public List<Integer> a(Rect rect, int i) {
        AppMethodBeat.i(99338);
        List a = this.a.a(rect, i);
        AppMethodBeat.o(99338);
        return a;
    }

    public void a(List<BlockRouteCityData> list) {
        AppMethodBeat.i(99339);
        this.a.a((List) list);
        AppMethodBeat.o(99339);
    }

    public void b(boolean z) {
        AppMethodBeat.i(99340);
        this.a.f(z);
        AppMethodBeat.o(99340);
    }

    public String a(GeoPoint geoPoint) {
        String a;
        AppMethodBeat.i(99341);
        if (!(this.r == null || this.v == null)) {
            a = this.v.a(geoPoint);
            if (a != null) {
                AppMethodBeat.o(99341);
                return a;
            }
        }
        if (this.a == null) {
            a = "";
            AppMethodBeat.o(99341);
            return a;
        }
        a = this.a.a(geoPoint);
        AppMethodBeat.o(99341);
        return a;
    }

    public void a(String str) {
        AppMethodBeat.i(99342);
        if (this.a != null) {
            this.a.f(str);
        }
        AppMethodBeat.o(99342);
    }

    public void c(boolean z) {
        AppMethodBeat.i(99343);
        if (this.C == z) {
            AppMethodBeat.o(99343);
            return;
        }
        this.C = z;
        if (this.a != null) {
            this.a.a(z);
        }
        AppMethodBeat.o(99343);
    }

    private void J() {
        AppMethodBeat.i(99344);
        if (this.a != null) {
            this.a.k();
        }
        AppMethodBeat.o(99344);
    }

    private void K() {
        AppMethodBeat.i(99345);
        if (this.a != null) {
            this.a.l();
        }
        AppMethodBeat.o(99345);
    }

    public void w() {
        AppMethodBeat.i(99346);
        this.c.z();
        this.s = true;
        AppMethodBeat.o(99346);
    }

    public void d(boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(99347);
        this.w = z;
        if (this.L) {
            if (!(z && this.c.t())) {
                z2 = false;
            }
            l(z2);
            AppMethodBeat.o(99347);
            return;
        }
        if (z || this.c.t()) {
            z3 = true;
        }
        l(z3);
        AppMethodBeat.o(99347);
    }

    public void e(boolean z) {
        this.L = z;
    }

    public void a(double d) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(99348);
        boolean z3 = ((double) this.c.p()) > 1.0E-10d;
        if (this.L) {
            if (!(this.w && z3)) {
                z = false;
            }
            l(z);
        } else {
            if (this.w || z3) {
                z2 = true;
            }
            l(z2);
        }
        if (!hb.a() && this.c.t()) {
            this.a.n();
        }
        AppMethodBeat.o(99348);
    }

    private void l(boolean z) {
        AppMethodBeat.i(99349);
        if (this.a != null) {
            this.a.b(z);
        }
        AppMethodBeat.o(99349);
    }

    public void f(boolean z) {
        AppMethodBeat.i(99350);
        if (this.a != null) {
            this.a.d(z);
        }
        AppMethodBeat.o(99350);
    }

    public void d(int i) {
        AppMethodBeat.i(99351);
        if (this.a != null) {
            this.a.c(i);
        }
        AppMethodBeat.o(99351);
    }

    public String[] x() {
        AppMethodBeat.i(99352);
        if (this.a != null) {
            String[] p = this.a.p();
            AppMethodBeat.o(99352);
            return p;
        }
        AppMethodBeat.o(99352);
        return null;
    }

    public String b(GeoPoint geoPoint) {
        AppMethodBeat.i(99353);
        if (this.a != null) {
            String c = this.a.c(geoPoint);
            AppMethodBeat.o(99353);
            return c;
        }
        AppMethodBeat.o(99353);
        return null;
    }

    public void a(String[] strArr) {
        AppMethodBeat.i(99354);
        if (this.a != null) {
            this.a.a(strArr);
        }
        AppMethodBeat.o(99354);
    }

    public void a(com.tencent.map.lib.gl.JNICallback.e eVar) {
        AppMethodBeat.i(99355);
        if (this.a != null) {
            this.a.a(eVar);
        }
        AppMethodBeat.o(99355);
    }

    public int a(int i, boolean z) {
        AppMethodBeat.i(99356);
        if (this.a != null) {
            int d = this.a.d(i, z);
            AppMethodBeat.o(99356);
            return d;
        }
        AppMethodBeat.o(99356);
        return -1;
    }

    public void a(int i, int i2, int i3) {
        AppMethodBeat.i(99357);
        if (this.a == null) {
            AppMethodBeat.o(99357);
            return;
        }
        this.a.a(i, i2, i3);
        AppMethodBeat.o(99357);
    }

    public void e(int i) {
        AppMethodBeat.i(99358);
        if (this.a != null) {
            this.a.f(i);
            this.s = true;
        }
        AppMethodBeat.o(99358);
    }

    public void f(int i) {
        AppMethodBeat.i(99359);
        if (this.a != null) {
            this.a.g(i);
        }
        AppMethodBeat.o(99359);
    }

    public void a(com.tencent.map.lib.gl.JNICallback.d dVar) {
        AppMethodBeat.i(99360);
        if (this.a != null) {
            this.a.a(dVar);
        }
        AppMethodBeat.o(99360);
    }

    public void a(JNICallback.j jVar) {
        AppMethodBeat.i(99361);
        if (this.a != null) {
            this.a.a(jVar);
        }
        AppMethodBeat.o(99361);
    }

    public void a(com.tencent.map.lib.gl.JNICallback.b bVar) {
        AppMethodBeat.i(99362);
        if (this.a != null) {
            this.a.a(bVar);
        }
        AppMethodBeat.o(99362);
    }

    public void a(com.tencent.map.lib.gl.JNICallback.c cVar) {
        AppMethodBeat.i(99363);
        if (this.a != null) {
            this.a.a(cVar);
        }
        AppMethodBeat.o(99363);
    }

    public void a(k kVar) {
        AppMethodBeat.i(99364);
        if (this.a != null) {
            this.a.a(kVar);
        }
        AppMethodBeat.o(99364);
    }

    public void d(int i, int i2) {
        AppMethodBeat.i(99365);
        if (this.a != null) {
            this.a.d(i, i2);
        }
        AppMethodBeat.o(99365);
    }

    public void g(boolean z) {
        AppMethodBeat.i(99366);
        this.c.a(z);
        AppMethodBeat.o(99366);
    }

    public void e(int i, int i2) {
        AppMethodBeat.i(99367);
        if (this.a != null) {
            this.a.c(i, i2);
        }
        AppMethodBeat.o(99367);
    }

    public void b(String str) {
        AppMethodBeat.i(99368);
        if (this.a != null) {
            this.a.e(str);
        }
        AppMethodBeat.o(99368);
    }

    public MapLanguage y() {
        AppMethodBeat.i(99369);
        if (this.x == null) {
            this.x = new b();
        }
        MapLanguage a = this.x.a();
        AppMethodBeat.o(99369);
        return a;
    }

    public void a(MapLanguageChangeListener mapLanguageChangeListener) {
        AppMethodBeat.i(99370);
        if (this.x == null) {
            this.x = new b();
        }
        this.x.a(mapLanguageChangeListener);
        AppMethodBeat.o(99370);
    }

    public void b(MapLanguageChangeListener mapLanguageChangeListener) {
        AppMethodBeat.i(99371);
        if (this.x == null) {
            this.x = new b();
        }
        this.x.b(mapLanguageChangeListener);
        AppMethodBeat.o(99371);
    }

    public TappedElement a(float f, float f2) {
        AppMethodBeat.i(99372);
        if (this.a != null) {
            TappedElement a = this.a.a(f, f2);
            AppMethodBeat.o(99372);
            return a;
        }
        AppMethodBeat.o(99372);
        return null;
    }

    public String toString() {
        AppMethodBeat.i(99373);
        String gsVar;
        if (this.o != null) {
            gsVar = this.o.toString();
            AppMethodBeat.o(99373);
            return gsVar;
        }
        gsVar = "";
        AppMethodBeat.o(99373);
        return gsVar;
    }

    public gj z() {
        return this.f;
    }

    public void c(String str) {
        this.A = str;
    }

    public String A() {
        return this.A;
    }

    public void h(boolean z) {
        AppMethodBeat.i(99374);
        if (this.r == null) {
            AppMethodBeat.o(99374);
            return;
        }
        if (this.z == null) {
            this.z = new ga(this, this.r.b());
        }
        this.z.a(z);
        AppMethodBeat.o(99374);
    }

    public boolean B() {
        AppMethodBeat.i(99375);
        if (this.z == null) {
            AppMethodBeat.o(99375);
            return false;
        }
        boolean a = this.z.a();
        AppMethodBeat.o(99375);
        return a;
    }

    public void C() {
        AppMethodBeat.i(99376);
        if (this.z == null || !this.z.a()) {
            AppMethodBeat.o(99376);
            return;
        }
        this.z.b();
        AppMethodBeat.o(99376);
    }

    public gx D() {
        return this.q;
    }

    public void i(boolean z) {
        AppMethodBeat.i(99377);
        if (this.a != null) {
            this.a.g(z);
        }
        AppMethodBeat.o(99377);
    }

    public void j(boolean z) {
        AppMethodBeat.i(99378);
        if (this.a != null) {
            this.a.h(z);
        }
        AppMethodBeat.o(99378);
    }

    public void k(boolean z) {
        AppMethodBeat.i(99379);
        if (this.c != null) {
            this.c.c(z);
        }
        AppMethodBeat.o(99379);
    }

    public String E() {
        AppMethodBeat.i(99380);
        String str = null;
        if (this.a != null) {
            str = this.a.C();
        }
        AppMethodBeat.o(99380);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public boolean F() {
        AppMethodBeat.i(99381);
        if (this.a != null) {
            boolean g = this.a.g();
            AppMethodBeat.o(99381);
            return g;
        }
        AppMethodBeat.o(99381);
        return false;
    }

    public void a(String str, String str2) {
        AppMethodBeat.i(99382);
        if (this.a == null) {
            AppMethodBeat.o(99382);
            return;
        }
        this.a.a(str, str2);
        AppMethodBeat.o(99382);
    }

    public ArrayList<MapPoi> G() {
        AppMethodBeat.i(99383);
        if (this.a == null) {
            AppMethodBeat.o(99383);
            return null;
        }
        ArrayList<MapPoi> E = this.a.E();
        AppMethodBeat.o(99383);
        return E;
    }

    public String H() {
        AppMethodBeat.i(99384);
        if (this.a == null) {
            AppMethodBeat.o(99384);
            return null;
        }
        String D = this.a.D();
        AppMethodBeat.o(99384);
        return D;
    }

    public String I() {
        AppMethodBeat.i(99385);
        if (this.a == null) {
            AppMethodBeat.o(99385);
            return null;
        }
        String F = this.a.F();
        AppMethodBeat.o(99385);
        return F;
    }
}
