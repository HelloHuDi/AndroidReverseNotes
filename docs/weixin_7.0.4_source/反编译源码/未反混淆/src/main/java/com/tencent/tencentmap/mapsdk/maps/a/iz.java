package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Handler;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.a;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj;
import com.tencent.tencentmap.mapsdk.a.aj.c;
import com.tencent.tencentmap.mapsdk.a.aj.d;
import com.tencent.tencentmap.mapsdk.a.aj.e;
import com.tencent.tencentmap.mapsdk.a.aj.f;
import com.tencent.tencentmap.mapsdk.a.aj.g;
import com.tencent.tencentmap.mapsdk.a.aj.h;
import com.tencent.tencentmap.mapsdk.a.aj.i;
import com.tencent.tencentmap.mapsdk.a.aj.k;
import com.tencent.tencentmap.mapsdk.a.aj.l;
import com.tencent.tencentmap.mapsdk.a.ak;
import com.tencent.tencentmap.mapsdk.a.ar.b;
import com.tencent.tencentmap.mapsdk.a.as;
import com.tencent.tencentmap.mapsdk.a.aw;
import com.tencent.tencentmap.mapsdk.a.bj;
import com.tencent.tencentmap.mapsdk.a.bo;
import com.tencent.tencentmap.mapsdk.a.cb;
import com.tencent.tencentmap.mapsdk.a.ch;
import com.tencent.tencentmap.mapsdk.a.cl;
import com.tencent.tencentmap.mapsdk.a.cp;
import com.tencent.tencentmap.mapsdk.a.cw;
import com.tencent.tencentmap.mapsdk.a.cz;
import com.tencent.tencentmap.mapsdk.a.db;
import com.tencent.tencentmap.mapsdk.a.dd;
import com.tencent.tencentmap.mapsdk.a.de;
import com.tencent.tencentmap.mapsdk.a.dn;
import com.tencent.tencentmap.mapsdk.a.dp;
import com.tencent.tencentmap.mapsdk.a.dq;
import com.tencent.tencentmap.mapsdk.a.ds;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.t;
import com.tencent.tencentmap.mapsdk.a.v;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class iz extends gd implements c, ip {
    public float A = 0.5f;
    public float B = 0.5f;
    protected boolean C = true;
    protected boolean D = true;
    protected boolean E = true;
    protected boolean F = true;
    protected boolean G = true;
    protected boolean H = true;
    public Handler I = null;
    public volatile boolean J = false;
    public volatile boolean K = false;
    protected int L = 0;
    public db M = null;
    public db N = null;
    public int O = 0;
    public int P = 0;
    public int Q = 0;
    public int R = 0;
    public int S = 0;
    public int T = 0;
    public int U = 0;
    public boolean V = false;
    public hw W = null;
    private String X = "";
    private boolean Y = false;
    private List<hz> Z = new ArrayList();
    private int aA = j.INVALID_ID;
    private int aB = j.INVALID_ID;
    private GeoPoint aC = null;
    private lq aD = null;
    private boolean aE = false;
    private float aF = 100.0f;
    private float aG = 100.0f;
    private boolean aH = true;
    private volatile boolean aI = false;
    private boolean aJ = false;
    private int aK = 10;
    private int aL = 0;
    private int aM = 0;
    private boolean aN = false;
    private int aO = 19;
    private int aP = 3;
    private float aQ = 0.0f;
    private AtomicBoolean aR = new AtomicBoolean(false);
    private boolean aS = true;
    private boolean aT = true;
    private final gf aU;
    private a aV;
    private boolean aW = false;
    private boolean aX = true;
    private jc aY;
    private ak aZ;
    private List<hz> aa = new ArrayList();
    private List<hz> ab = new ArrayList();
    private List<hz> ac = new ArrayList();
    private bo ad;
    private ls ae = null;
    private jr af;
    private List<hz> ag = new ArrayList();
    private lh ah;
    private ch ai = null;
    private li.a aj = null;
    private Map<Class<? extends hz>, cb> ak = new HashMap();
    private List<as> al = null;
    private e am = null;
    private final gt an;
    private com.tencent.map.lib.e ao = new iq(this);
    private final ft ap;
    private b aq = null;
    private fv ar = new it(this);
    private Handler as;
    private bj at;
    private com.tencent.map.lib.a au;
    private Comparator<hz> av = new Comparator<hz>() {
        public /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.i(99914);
            int a = a((hz) obj, (hz) obj2);
            AppMethodBeat.o(99914);
            return a;
        }

        public int a(hz hzVar, hz hzVar2) {
            AppMethodBeat.i(99913);
            int compare = Float.compare(hzVar.D(), hzVar2.D());
            AppMethodBeat.o(99913);
            return compare;
        }
    };
    private Config aw = Config.RGB_565;
    private boolean ax = true;
    private int ay = j.INVALID_ID;
    private int az = j.INVALID_ID;
    public byte[] b = new byte[0];
    private List<hx> ba = new ArrayList();
    private List<MapPoi> bb = new ArrayList();
    public hw c = null;
    public if d = null;
    public if e = null;
    public if f = null;
    public if g = null;
    protected volatile cw h;
    public int i = 22;
    protected lf j;
    protected dp k = null;
    public cl l = null;
    public h m = null;
    public aw.a n = null;
    public List<c> o = new CopyOnWriteArrayList();
    public aj.j p = null;
    public volatile i q = null;
    protected f r;
    public l s = null;
    public g t = null;
    public k u = null;
    protected final Handler v;
    public aj.a w = null;
    public d x = null;
    public float y = 0.5f;
    public float z = 0.5f;

    public iz(gg ggVar, Context context, ak akVar) {
        super(ggVar, context);
        AppMethodBeat.i(99916);
        this.aZ = akVar;
        this.v = new in(this);
        this.ap = new is(this);
        this.ao = new iq(this);
        this.aU = new iv(this);
        this.ar = new it(this);
        this.an = new ir(this);
        this.aD = new lq();
        lq.a(context);
        jp.a(context);
        this.aO = b().c();
        this.aP = b().b();
        ll.a(context);
        this.at = new lt();
        a(this.aU);
        b().a(this.an);
        b().a(this.ar);
        b().a(this.ao);
        b().a(this.ap);
        b().a((com.tencent.map.lib.listener.a) this);
        if (this.I == null) {
            this.I = new Handler();
        }
        WindowManager windowManager = (WindowManager) i().getSystemService("window");
        this.T = windowManager.getDefaultDisplay().getWidth();
        this.U = windowManager.getDefaultDisplay().getHeight();
        this.ai = new ch(this);
        this.ae = new ls(this);
        if (akVar != null) {
            this.aE = akVar.c();
            this.V = akVar.i();
        }
        AppMethodBeat.o(99916);
    }

    public ls o() {
        return this.ae;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(99917);
        if (this.al != null) {
            int size = this.al.size();
            for (int i3 = 0; i3 < size; i3++) {
                as asVar = (as) this.al.get(i3);
                if (asVar != null) {
                    asVar.a(i, i2);
                }
            }
        }
        if (this.b != null) {
            synchronized (this.b) {
                try {
                    if (this.Z != null) {
                        for (hz z : this.Z) {
                            z.z();
                        }
                    }
                } finally {
                    AppMethodBeat.o(99917);
                }
            }
            return;
        }
        AppMethodBeat.o(99917);
    }

    private void b(GL10 gl10) {
        AppMethodBeat.i(99918);
        synchronized (this.b) {
            try {
                int size = this.Z.size();
                int i = 0;
                hz hzVar = null;
                while (i < size) {
                    hz hzVar2;
                    if (this.Z.size() > size) {
                        size = this.Z.size();
                    }
                    if (i < this.Z.size()) {
                        hzVar2 = (hz) this.Z.get(i);
                    } else {
                        hzVar2 = null;
                    }
                    if (hzVar2 != null) {
                        if (TextUtils.equals(hzVar2.A(), this.X)) {
                            if (!(hzVar2.a() || this.aN)) {
                                hzVar2.b();
                                hzVar2 = hzVar;
                            }
                        } else if (hzVar2 instanceof ia) {
                            ((ia) hzVar2).a(b().z(), b().t(), gl10);
                            hzVar2 = hzVar;
                        } else {
                            hzVar2.a(gl10);
                        }
                        i++;
                        hzVar = hzVar2;
                    }
                    hzVar2 = hzVar;
                    i++;
                    hzVar = hzVar2;
                }
                if (hzVar != null) {
                    hzVar.a(gl10);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99918);
            }
        }
    }

    private boolean a(hz hzVar, float f, float f2) {
        AppMethodBeat.i(99919);
        if (hzVar == null || !hzVar.a() || !hzVar.r()) {
            AppMethodBeat.o(99919);
            return false;
        } else if (hzVar.a(f, f2)) {
            cb cbVar = (cb) this.ak.get(hzVar.getClass());
            if (cbVar != null) {
                boolean a = cbVar.a(hzVar, true, b().t().a(new DoublePoint((double) f, (double) f2)));
                AppMethodBeat.o(99919);
                return a;
            }
            AppMethodBeat.o(99919);
            return false;
        } else {
            AppMethodBeat.o(99919);
            return false;
        }
    }

    public void a() {
        AppMethodBeat.i(99920);
        b().l();
        if (this.x != null) {
            this.x.a();
        }
        AppMethodBeat.o(99920);
    }

    public cp p() {
        AppMethodBeat.i(99921);
        com.tencent.map.lib.f b = b();
        GeoPoint f = b.f();
        if (f == null || ((this.o == null || this.o.size() <= 0) && this.aU == null)) {
            AppMethodBeat.o(99921);
            return null;
        }
        db a = ic.a(f);
        float q = b.q();
        if (q < 0.0f) {
            q = (q % 360.0f) + 360.0f;
        }
        cp a2 = cp.a().a((float) (((double) ((float) b.h())) + (Math.log((double) b.k()) / Math.log(2.0d)))).a(a).c(q).b(b.r()).a();
        AppMethodBeat.o(99921);
        return a2;
    }

    public void a(Context context, ak akVar) {
        AppMethodBeat.i(99922);
        a(akVar);
        dq.a(context);
        if (b().g()) {
            b().a(5);
        } else {
            b().a(0);
        }
        if (this.aE) {
            L();
        }
        AppMethodBeat.o(99922);
    }

    public void a(Handler handler, Config config) {
        AppMethodBeat.i(99923);
        this.as = handler;
        this.aw = config;
        b().a();
        AppMethodBeat.o(99923);
    }

    public void a(String str, boolean z) {
        AppMethodBeat.i(99924);
        a(str, z, false);
        AppMethodBeat.o(99924);
    }

    public void a(String str, boolean z, boolean z2) {
        synchronized (this.b) {
            if (!z2) {
                this.X = str;
            }
        }
    }

    public GeoPoint q() {
        AppMethodBeat.i(99925);
        synchronized (this.b) {
            try {
                if (this.X == null || this.X.trim().length() == 0) {
                } else {
                    hz b = b(this.X);
                    if (b == null) {
                        AppMethodBeat.o(99925);
                        return null;
                    }
                    GeoPoint g = ((hx) b).g();
                    AppMethodBeat.o(99925);
                    return g;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99925);
            }
        }
        return null;
    }

    public String r() {
        String str;
        synchronized (this.b) {
            str = this.X;
        }
        return str;
    }

    public de a(String str) {
        de deVar;
        AppMethodBeat.i(99926);
        if (StringUtil.isEmpty(str)) {
            AppMethodBeat.o(99926);
            return null;
        }
        synchronized (this.b) {
            try {
                for (hz hzVar : this.Z) {
                    if (hzVar.A().equals(str) && (hzVar instanceof hx)) {
                        deVar = ((hx) hzVar).y;
                    }
                }
                AppMethodBeat.o(99926);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99926);
            }
        }
        return deVar;
    }

    public boolean a(hz hzVar) {
        AppMethodBeat.i(99927);
        if (hzVar == null) {
            AppMethodBeat.o(99927);
            return false;
        }
        synchronized (this.b) {
            try {
                int size = this.Z.size();
                int i = 0;
                boolean z = false;
                int i2 = size;
                while (i < size) {
                    boolean z2;
                    hz hzVar2 = (hz) this.Z.get(i);
                    if (hzVar2 == null || z || hzVar2.D() < hzVar.D()) {
                        z2 = z;
                    } else {
                        z2 = true;
                        i2 = i;
                    }
                    i++;
                    z = z2;
                }
                this.Z.add(i2, hzVar);
                if (!(hzVar == null || hzVar.B() == null)) {
                    if (this.h != null) {
                        hzVar.a(this.h);
                    }
                    this.ag.add(hzVar);
                }
                if (hzVar instanceof hx) {
                    this.aa.add(hzVar);
                    Collections.sort(this.aa, this.av);
                } else if (hzVar instanceof ib) {
                    this.ab.add(hzVar);
                    Collections.sort(this.ab, this.av);
                } else {
                    this.ac.add(hzVar);
                    Collections.sort(this.ac, this.av);
                }
            } finally {
                AppMethodBeat.o(99927);
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A:{Catch:{ all -> 0x0051 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public hz b(String str, boolean z) {
        AppMethodBeat.i(99928);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(99928);
            return null;
        }
        hz hzVar;
        synchronized (this.b) {
            try {
                Iterator it = this.Z.iterator();
                while (it.hasNext()) {
                    hzVar = (hz) it.next();
                    if (hzVar != null && TextUtils.equals(hzVar.A(), str)) {
                        it.remove();
                        if (z) {
                            hzVar.d();
                        }
                        if (hzVar != null) {
                            this.aa.remove(hzVar);
                            this.ab.remove(hzVar);
                            this.ac.remove(hzVar);
                        }
                    }
                }
                hzVar = null;
                if (hzVar != null) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99928);
            }
        }
        return hzVar;
    }

    public void a(bo boVar) {
        if (boVar != null) {
            synchronized (this.b) {
                this.ad = boVar;
            }
        }
    }

    public void s() {
        AppMethodBeat.i(99929);
        synchronized (this.b) {
            try {
                if (this.ad != null) {
                    this.ad.e();
                    this.ad = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99929);
            }
        }
    }

    public void t() {
        AppMethodBeat.i(99930);
        synchronized (this.b) {
            try {
                if (this.ad != null) {
                    this.ad.f();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99930);
            }
        }
    }

    public boolean u() {
        boolean z;
        synchronized (this.b) {
            z = this.ad != null;
        }
        return z;
    }

    public void a(Class<? extends hz> cls, cb cbVar) {
        AppMethodBeat.i(99931);
        this.ak.put(cls, cbVar);
        AppMethodBeat.o(99931);
    }

    public cb a(Class<? extends hz> cls) {
        AppMethodBeat.i(99932);
        cb cbVar = (cb) this.ak.get(cls);
        AppMethodBeat.o(99932);
        return cbVar;
    }

    public cb b(Class<? extends hz> cls) {
        AppMethodBeat.i(99933);
        cb cbVar = (cb) this.ak.remove(cls);
        AppMethodBeat.o(99933);
        return cbVar;
    }

    public boolean a(float f, float f2) {
        AppMethodBeat.i(99934);
        if (this.n != null) {
            String c = c(f, f2);
            if (!(c == null || c.trim().length() == 0)) {
                this.n.a(c);
                AppMethodBeat.o(99934);
                return true;
            }
        }
        if (this.p != null && this.H) {
            this.p.a(ic.a(b().t().a(new DoublePoint((double) f, (double) f2))));
        }
        AppMethodBeat.o(99934);
        return false;
    }

    public void a(as asVar) {
        AppMethodBeat.i(99935);
        if (asVar == null) {
            AppMethodBeat.o(99935);
            return;
        }
        if (this.al == null) {
            this.al = new ArrayList();
        }
        if (this.al.contains(asVar)) {
            AppMethodBeat.o(99935);
            return;
        }
        this.al.add(asVar);
        AppMethodBeat.o(99935);
    }

    /* JADX WARNING: Missing block: B:67:0x0105, code skipped:
            if (r12.Y == false) goto L_0x0130;
     */
    /* JADX WARNING: Missing block: B:68:0x0107, code skipped:
            r4 = r12.b;
     */
    /* JADX WARNING: Missing block: B:69:0x0109, code skipped:
            monitor-enter(r4);
     */
    /* JADX WARNING: Missing block: B:70:0x010a, code skipped:
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:73:0x0111, code skipped:
            if (r1 >= r12.aa.size()) goto L_0x012f;
     */
    /* JADX WARNING: Missing block: B:74:0x0113, code skipped:
            r0 = (com.tencent.tencentmap.mapsdk.maps.a.hx) r12.aa.get(r1);
     */
    /* JADX WARNING: Missing block: B:75:0x011d, code skipped:
            if (r0.z == null) goto L_0x0125;
     */
    /* JADX WARNING: Missing block: B:76:0x011f, code skipped:
            r0.z.d(false);
     */
    /* JADX WARNING: Missing block: B:77:0x0125, code skipped:
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:83:?, code skipped:
            monitor-exit(r4);
     */
    /* JADX WARNING: Missing block: B:85:0x0134, code skipped:
            if (e(r13, r14) == false) goto L_0x0142;
     */
    /* JADX WARNING: Missing block: B:86:0x0136, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(99936);
     */
    /* JADX WARNING: Missing block: B:90:0x013e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(99936);
     */
    /* JADX WARNING: Missing block: B:91:0x0142, code skipped:
            r0 = r12.m;
     */
    /* JADX WARNING: Missing block: B:92:0x0144, code skipped:
            if (r0 == false) goto L_0x0166;
     */
    /* JADX WARNING: Missing block: B:93:0x0146, code skipped:
            r0 = r12.H;
     */
    /* JADX WARNING: Missing block: B:94:0x0148, code skipped:
            if (r0 == false) goto L_0x0166;
     */
    /* JADX WARNING: Missing block: B:95:0x014a, code skipped:
            r0 = com.tencent.tencentmap.mapsdk.maps.a.ic.a(b().t().a(new com.tencent.map.lib.basemap.data.DoublePoint((double) r13, (double) r14)));
            r12.m.a(r0);
     */
    /* JADX WARNING: Missing block: B:96:0x0166, code skipped:
            r1 = r12.b;
     */
    /* JADX WARNING: Missing block: B:97:0x0168, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:99:?, code skipped:
            t();
     */
    /* JADX WARNING: Missing block: B:100:0x016c, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:101:0x016d, code skipped:
            h();
     */
    /* JADX WARNING: Missing block: B:105:0x0178, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(99936);
     */
    /* JADX WARNING: Missing block: B:136:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99936);
        synchronized (this.b) {
            try {
                de deVar;
                boolean z2;
                hw hwVar;
                hx hxVar = (hx) b(this.X);
                hw hwVar2 = hxVar != null ? hxVar.z : null;
                if (this.X.equals("") || hxVar == null || hwVar2 == null || !hwVar2.j()) {
                    hwVar2 = null;
                    deVar = null;
                    z2 = false;
                } else {
                    z2 = hwVar2.a(f, f2);
                    if (z2) {
                        deVar = hxVar.y;
                    } else {
                        hwVar2 = null;
                        deVar = null;
                    }
                }
                if (!z2) {
                    int size = this.aa.size() - 1;
                    while (size >= 0) {
                        hxVar = (hx) this.aa.get(size);
                        hw hwVar3 = hxVar.z;
                        if (!(hxVar.A().equals(this.X) || hwVar3 == null || !hwVar3.j())) {
                            z2 = hwVar3.a(f, f2);
                            if (z2) {
                                de deVar2 = hxVar.y;
                                hwVar = hwVar3;
                                deVar = deVar2;
                                break;
                            }
                        }
                        size--;
                        z2 = z2;
                    }
                }
                hwVar = hwVar2;
                if (!z2) {
                    int size2;
                    z = false;
                    for (size2 = this.aa.size() - 1; size2 >= 0; size2--) {
                        z = a((hz) this.aa.get(size2), f, f2);
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        AppMethodBeat.o(99936);
                        return z;
                    }
                    for (size2 = this.ab.size() - 1; size2 >= 0; size2--) {
                        z = a((hz) this.ab.get(size2), f, f2);
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        AppMethodBeat.o(99936);
                        return z;
                    }
                    for (size2 = this.ac.size() - 1; size2 >= 0; size2--) {
                        z = a((hz) this.ac.get(size2), f, f2);
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        AppMethodBeat.o(99936);
                        return z;
                    }
                } else if (!(this.t == null || deVar == null || hwVar == null || !deVar.l())) {
                    this.t.a(deVar);
                    this.t.a(hwVar.l, hwVar.m, hwVar.G, hwVar.H);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99936);
            }
        }
        return z;
        return true;
    }

    public void a(boolean z) {
        this.Y = z;
    }

    public void a(String str, float f) {
        AppMethodBeat.i(99937);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(99937);
            return;
        }
        synchronized (this.b) {
            try {
                hz hzVar;
                int size = this.Z.size();
                int i = 0;
                int i2 = -1;
                int i3 = size;
                while (i < size) {
                    int i4;
                    hzVar = (hz) this.Z.get(i);
                    if (hzVar != null) {
                        if (hzVar.D() > f) {
                            i3 = i;
                        }
                        if (TextUtils.equals(hzVar.A(), str)) {
                            i4 = i;
                            i++;
                            i2 = i4;
                        }
                    }
                    i4 = i2;
                    i++;
                    i2 = i4;
                }
                if (i2 == -1 || i2 == i3) {
                } else {
                    if (i3 >= i2) {
                        i3--;
                    }
                    hzVar = (hz) this.Z.remove(i2);
                    if (hzVar == null) {
                        AppMethodBeat.o(99937);
                        return;
                    }
                    this.Z.add(i3, hzVar);
                    AppMethodBeat.o(99937);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99937);
            }
        }
    }

    public hz b(String str) {
        hz hzVar;
        AppMethodBeat.i(99938);
        synchronized (this.b) {
            try {
                int size = this.Z.size();
                hzVar = null;
                for (int i = 0; i < size; i++) {
                    hzVar = (hz) this.Z.get(i);
                    if (hzVar != null) {
                        if (TextUtils.equals(hzVar.A(), str)) {
                            break;
                        }
                        hzVar = null;
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99938);
            }
        }
        return hzVar;
    }

    public void b(boolean z) {
        this.D = z;
    }

    public void c(boolean z) {
        this.C = z;
    }

    public void d(boolean z) {
        this.E = z;
    }

    public void e(boolean z) {
        this.F = z;
    }

    public void f(boolean z) {
        this.G = z;
    }

    public void g(boolean z) {
        this.H = z;
    }

    public void h(boolean z) {
        AppMethodBeat.i(99939);
        this.aH = z;
        b().f(z);
        b().a();
        AppMethodBeat.o(99939);
    }

    public boolean v() {
        return this.aH;
    }

    public boolean w() {
        return this.D;
    }

    public boolean x() {
        return this.E;
    }

    public boolean y() {
        return this.F;
    }

    public boolean z() {
        return this.G;
    }

    public String c(float f, float f2) {
        String A;
        AppMethodBeat.i(99940);
        synchronized (this.b) {
            try {
                for (int size = this.Z.size() - 1; size >= 0; size--) {
                    hz hzVar = (hz) this.Z.get(size);
                    if (hzVar != null && hzVar.a() && (hzVar instanceof hx) && hzVar.a(f, f2)) {
                        A = hzVar.A();
                        break;
                    }
                }
                A = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99940);
            }
        }
        return A;
    }

    public void i(boolean z) {
        AppMethodBeat.i(99941);
        if (!z || U()) {
            b().a(this.an);
            AppMethodBeat.o(99941);
            return;
        }
        b().a(null);
        AppMethodBeat.o(99941);
    }

    private boolean U() {
        AppMethodBeat.i(99942);
        boolean d = lq.d();
        AppMethodBeat.o(99942);
        return d;
    }

    public boolean a(MotionEvent motionEvent) {
        AppMethodBeat.i(99943);
        if (this.n != null) {
            this.n.a(motionEvent);
        }
        boolean a = super.a(motionEvent);
        AppMethodBeat.o(99943);
        return a;
    }

    public void e() {
        AppMethodBeat.i(99944);
        super.e();
        this.L = 0;
        this.K = false;
        X();
        if (this.ai != null) {
            this.ai.b();
        }
        AppMethodBeat.o(99944);
    }

    public void g() {
        AppMethodBeat.i(99945);
        super.g();
        b().a(null);
        dq.a();
        if (this.o != null) {
            this.o.clear();
        }
        if (this.aY != null) {
            this.aY.d();
        }
        if (this.ae != null) {
            this.ae.b();
        }
        this.aJ = true;
        AppMethodBeat.o(99945);
    }

    public void A() {
        AppMethodBeat.i(99946);
        if (this.I != null) {
            this.I.removeCallbacksAndMessages(null);
        }
        if (this.v != null) {
            this.v.removeCallbacksAndMessages(null);
        }
        if (this.as != null) {
            this.as.removeCallbacksAndMessages(null);
        }
        if (this.al != null) {
            this.al.clear();
            this.al = null;
        }
        V();
        if (this.ak != null) {
            this.ak.clear();
        }
        AppMethodBeat.o(99946);
    }

    public void c(Class<? extends hz> cls) {
        AppMethodBeat.i(99947);
        if (cls == null) {
            AppMethodBeat.o(99947);
            return;
        }
        synchronized (this.b) {
            try {
                Iterator it = this.Z.iterator();
                while (it.hasNext()) {
                    hz hzVar = (hz) it.next();
                    if (!(hzVar == null || !cls.isInstance(hzVar) || hzVar.y())) {
                        hzVar.d();
                        it.remove();
                        this.aa.remove(hzVar);
                        this.ab.remove(hzVar);
                        this.ac.remove(hzVar);
                    }
                }
            } finally {
                AppMethodBeat.o(99947);
            }
        }
        b().a();
    }

    public void a(dn dnVar) {
        AppMethodBeat.i(99948);
        if (this.k == null) {
            this.k = new dp();
        }
        this.k.a(dnVar);
        AppMethodBeat.o(99948);
    }

    public void b(dn dnVar) {
        AppMethodBeat.i(99949);
        if (this.k == null) {
            AppMethodBeat.o(99949);
            return;
        }
        this.k.b(dnVar);
        AppMethodBeat.o(99949);
    }

    public void a(int i) {
        AppMethodBeat.i(99950);
        this.aM = i;
        b().e(this.aL + 52, i + 52);
        h();
        AppMethodBeat.o(99950);
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(99951);
        this.aL = i;
        this.aM = i2;
        b().e(i + 52, i2 + 52);
        h();
        AppMethodBeat.o(99951);
    }

    public void a(b bVar) {
        this.aq = bVar;
    }

    public boolean d(float f, float f2) {
        AppMethodBeat.i(99952);
        if (this.H) {
            boolean a = b().a(f, f2);
            AppMethodBeat.o(99952);
            return a;
        }
        AppMethodBeat.o(99952);
        return false;
    }

    public void B() {
        AppMethodBeat.i(99953);
        int h = b().h();
        this.aS = true;
        this.aT = true;
        if (h <= this.aP) {
            this.aT = false;
        } else if (h >= this.aO) {
            this.aS = false;
        }
        if (this.aj != null) {
            li liVar = new li();
            liVar.a = 0;
            liVar.b = this.aS;
            liVar.c = this.aT;
            this.aj.a(liVar);
        }
        AppMethodBeat.o(99953);
    }

    public void C() {
        AppMethodBeat.i(99954);
        if (this.aj != null) {
            li liVar = new li();
            liVar.a = 0;
            liVar.b = this.aS;
            liVar.c = this.aT;
            this.aj.a(liVar);
        }
        AppMethodBeat.o(99954);
    }

    public void a(float f) {
        AppMethodBeat.i(99955);
        if (this.aQ == f) {
            AppMethodBeat.o(99955);
            return;
        }
        this.aQ = f;
        if (this.aj != null) {
            li liVar = new li();
            liVar.a = 1;
            liVar.d = b().h();
            liVar.e = b().t().a(new Point(0, this.U / 2), new Point(this.T, this.U / 2));
            this.aj.a(liVar);
        }
        AppMethodBeat.o(99955);
    }

    public lf D() {
        return this.j;
    }

    public ch E() {
        return this.ai;
    }

    public void c(int i, int i2) {
        AppMethodBeat.i(99956);
        if (i == 0 || i2 == 0) {
            AppMethodBeat.o(99956);
            return;
        }
        if (this.aC == null) {
            GeoPoint f = b().f();
            this.aC = new GeoPoint(f.getLatitudeE6(), f.getLongitudeE6());
        }
        this.aC.setLatitudeE6(i);
        this.aC.setLongitudeE6(i2);
        AppMethodBeat.o(99956);
    }

    public GeoPoint F() {
        AppMethodBeat.i(99957);
        if (this.aC == null) {
            if (this.ay == j.INVALID_ID) {
                this.ay = this.T / 2;
            }
            if (this.az == j.INVALID_ID) {
                this.az = this.U / 2;
            }
            this.aC = b().t().a(new DoublePoint((double) this.ay, (double) this.az));
        }
        GeoPoint geoPoint = this.aC;
        AppMethodBeat.o(99957);
        return geoPoint;
    }

    public int G() {
        return this.aA;
    }

    public int H() {
        return this.aB;
    }

    public int I() {
        return this.ay;
    }

    public int J() {
        return this.az;
    }

    public void d(int i, int i2) {
        this.ay = i;
        this.az = i2;
    }

    public void e(int i, int i2) {
        this.aA = i;
        this.aB = i2;
    }

    public void a(li.a aVar) {
        this.aj = aVar;
    }

    public void a(f fVar) {
        this.r = fVar;
    }

    public boolean e(float f, float f2) {
        AppMethodBeat.i(99958);
        TappedElement b = b().b(f, f2);
        if (b != null) {
            switch (b.type) {
                case 0:
                    AppMethodBeat.o(99958);
                    return false;
                case 1:
                    if (this.u != null) {
                        dd czVar;
                        if (b.itemType == 1) {
                            czVar = new cz();
                            czVar.b = b.buildingName;
                            czVar.a = b.buildingId;
                            czVar.c = b.floorName;
                        } else {
                            czVar = new dd();
                        }
                        czVar.d = b.name;
                        GeoPoint a = com.tencent.map.lib.util.d.a(b.pixelX, b.pixelY);
                        if (a != null) {
                            czVar.e = new db(((double) a.getLatitudeE6()) / 1000000.0d, ((double) a.getLongitudeE6()) / 1000000.0d);
                        }
                        this.u.a(czVar);
                        break;
                    }
                    break;
                case 8:
                    break;
                default:
                    AppMethodBeat.o(99958);
                    return false;
            }
            AppMethodBeat.o(99958);
            return true;
        }
        AppMethodBeat.o(99958);
        return false;
    }

    public void a(k kVar) {
        this.u = kVar;
    }

    public void a(final lh lhVar) {
        AppMethodBeat.i(99959);
        this.ah = lhVar;
        a(new c() {
            public void onCameraChange(cp cpVar) {
            }

            public void onCameraChangeFinished(cp cpVar) {
                AppMethodBeat.i(99915);
                lhVar.h();
                AppMethodBeat.o(99915);
            }
        });
        AppMethodBeat.o(99959);
    }

    public lh K() {
        return this.ah;
    }

    public void a(lf lfVar) {
        this.j = lfVar;
    }

    public void L() {
        AppMethodBeat.i(99960);
        if (this.af == null) {
            this.af = new jr(new jq(this));
            a(this.af);
            new jt(i().getApplicationContext(), this.af).a();
        }
        AppMethodBeat.o(99960);
    }

    public void M() {
        AppMethodBeat.i(99961);
        if (this.af != null) {
            this.af.e();
            this.af = null;
        }
        AppMethodBeat.o(99961);
    }

    public boolean N() {
        return this.af != null;
    }

    public boolean O() {
        return this.aW;
    }

    public void j(boolean z) {
        this.aW = z;
    }

    public void a(c cVar) {
        AppMethodBeat.i(99962);
        if (!(this.o == null || cVar == null)) {
            this.o.add(cVar);
        }
        i(cVar == null);
        AppMethodBeat.o(99962);
    }

    public ak P() {
        return this.aZ;
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(99963);
        super.a(gl10, eGLConfig);
        AppMethodBeat.o(99963);
    }

    public void a(GL10 gl10, int i, int i2) {
        AppMethodBeat.i(99964);
        super.a(gl10, i, i2);
        this.T = i;
        this.U = i2;
        d((int) (((float) this.T) * this.y), (int) (((float) this.U) * this.z));
        e((int) (((float) this.T) * this.A), (int) (((float) this.U) * this.B));
        if (this.aq != null) {
            this.aq.a();
        }
        AppMethodBeat.o(99964);
    }

    public void j() {
        AppMethodBeat.i(99965);
        super.j();
        AppMethodBeat.o(99965);
    }

    public boolean a(GL10 gl10) {
        AppMethodBeat.i(99966);
        b(gl10);
        boolean a = super.a(gl10);
        if (this.as != null && b() != null && b().H() && o() != null && o().c() && n()) {
            if (this.aX) {
                this.aX = false;
                this.ah.k();
                l();
            } else {
                c(gl10);
                this.ah.l();
                this.aX = true;
            }
        }
        AppMethodBeat.o(99966);
        return a;
    }

    private void a(ak akVar) {
        AppMethodBeat.i(99967);
        Context applicationContext = i().getApplicationContext();
        ds.a().a(applicationContext);
        r a = r.a(applicationContext);
        v.a(a.b());
        v.a(a.c());
        String str = null;
        if (!(akVar == null || StringUtil.isEmpty(akVar.h()))) {
            str = akVar.h();
        }
        v.a(a.b(str));
        v.a(a.c(str));
        v.a(a.d());
        if (akVar != null) {
            if (akVar.a() != null) {
                t.a(akVar.a());
            } else if (akVar.b() != null) {
                t.b(akVar.b());
            }
        }
        jn.a(applicationContext, str);
        this.au = new jg(this, str);
        a(this.au, (hf) il.a());
        b().b(hs.a());
        b().c(hs.d());
        AppMethodBeat.o(99967);
    }

    private void c(GL10 gl10) {
        AppMethodBeat.i(99968);
        if (gl10 == null) {
            AppMethodBeat.o(99968);
            return;
        }
        Object createBitmap;
        int i = this.T;
        int i2 = this.U;
        int[] iArr = new int[(i * i2)];
        int[] iArr2 = new int[(i * i2)];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        gl10.glReadPixels(0, 0, i, i2, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, wrap);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = iArr[(i3 * i) + i4];
                iArr2[(((i2 - i3) - 1) * i) + i4] = ((i5 & -16711936) | ((i5 << 16) & 16711680)) | ((i5 >> 16) & 255);
            }
        }
        try {
            createBitmap = Bitmap.createBitmap(iArr2, i, i2, this.aw);
        } catch (OutOfMemoryError e) {
            createBitmap = null;
        }
        if (!(this.a == null || (this.a instanceof iw) || !this.ah.j())) {
            createBitmap = a((Bitmap) createBitmap, this.ah.i());
        }
        this.as.sendMessage(this.as.obtainMessage(0, createBitmap));
        this.as = null;
        AppMethodBeat.o(99968);
    }

    private Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.i(99969);
        if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
            AppMethodBeat.o(99969);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), null);
        canvas.drawBitmap(bitmap2, (float) this.ah.c().left, (float) this.ah.c().top, null);
        AppMethodBeat.o(99969);
        return createBitmap;
    }

    private void V() {
        AppMethodBeat.i(99970);
        synchronized (this.b) {
            try {
                if (this.Z == null) {
                } else {
                    Iterator it = this.Z.iterator();
                    while (it.hasNext()) {
                        hz hzVar = (hz) it.next();
                        if (hzVar != null) {
                            hzVar.d();
                        }
                        it.remove();
                    }
                    this.aa.clear();
                    this.ab.clear();
                    this.ac.clear();
                    AppMethodBeat.o(99970);
                }
            } finally {
                AppMethodBeat.o(99970);
            }
        }
    }

    public a Q() {
        AppMethodBeat.i(99971);
        com.tencent.map.lib.basemap.data.b[] R = R();
        com.tencent.map.lib.basemap.data.b a = fp.a(b().f());
        float h = (float) b().h();
        if (this.aV == null) {
            this.aV = new a(a, R, h);
        } else {
            this.aV.a(a, R, h);
        }
        a aVar = this.aV;
        AppMethodBeat.o(99971);
        return aVar;
    }

    public com.tencent.map.lib.basemap.data.b[] R() {
        AppMethodBeat.i(99972);
        com.tencent.map.lib.basemap.data.b[] bVarArr = new com.tencent.map.lib.basemap.data.b[8];
        DoublePoint[] doublePointArr = new DoublePoint[8];
        float f = (float) this.T;
        float f2 = (float) this.U;
        if (f <= 2.0f || f2 <= 2.0f) {
            AppMethodBeat.o(99972);
            return null;
        }
        doublePointArr[0] = new DoublePoint(0.0d, 0.0d);
        doublePointArr[1] = new DoublePoint((double) (f / 2.0f), 0.0d);
        doublePointArr[2] = new DoublePoint((double) f, 0.0d);
        doublePointArr[3] = new DoublePoint((double) f, (double) (f2 / 2.0f));
        doublePointArr[4] = new DoublePoint((double) f, (double) f2);
        doublePointArr[5] = new DoublePoint((double) (f / 2.0f), (double) f2);
        doublePointArr[6] = new DoublePoint(0.0d, (double) f2);
        doublePointArr[7] = new DoublePoint(0.0d, (double) (f2 / 2.0f));
        for (int i = 0; i < 8; i++) {
            bVarArr[i] = fp.a(b().t().a(doublePointArr[i]));
        }
        AppMethodBeat.o(99972);
        return bVarArr;
    }

    public boolean onIndoorBuildingFocused() {
        return false;
    }

    public boolean onIndoorLevelActivated(cw cwVar) {
        AppMethodBeat.i(99973);
        this.h = cwVar;
        for (hz a : this.ag) {
            a.a(cwVar);
        }
        AppMethodBeat.o(99973);
        return false;
    }

    public boolean onIndoorBuildingDeactivated() {
        AppMethodBeat.i(99974);
        this.h = null;
        for (hz C : this.ag) {
            C.C();
        }
        AppMethodBeat.o(99974);
        return false;
    }

    public void onCameraChange(cp cpVar) {
        AppMethodBeat.i(99975);
        if (this.o != null) {
            for (c cVar : this.o) {
                if (cVar != null) {
                    cVar.onCameraChange(cpVar);
                }
            }
        }
        AppMethodBeat.o(99975);
    }

    public void onCameraChangeFinished(cp cpVar) {
        AppMethodBeat.i(99976);
        if (this.o != null) {
            for (c cVar : this.o) {
                if (cVar != null) {
                    cVar.onCameraChangeFinished(cpVar);
                }
            }
        }
        AppMethodBeat.o(99976);
    }

    public List<hx> S() {
        AppMethodBeat.i(99977);
        this.ba.clear();
        com.tencent.map.lib.basemap.data.b[] W = W();
        for (hz hzVar : this.aa) {
            if (hzVar instanceof hx) {
                hx hxVar = (hx) hzVar;
                if (a(hxVar.y.e(), W)) {
                    this.ba.add(hxVar);
                }
            }
        }
        List list = this.ba;
        AppMethodBeat.o(99977);
        return list;
    }

    public List<MapPoi> T() {
        AppMethodBeat.i(99978);
        this.bb.clear();
        this.bb = b().I();
        List list = this.bb;
        AppMethodBeat.o(99978);
        return list;
    }

    private boolean a(db dbVar, com.tencent.map.lib.basemap.data.b[] bVarArr) {
        AppMethodBeat.i(99979);
        if (dbVar == null) {
            AppMethodBeat.o(99979);
            return false;
        }
        com.tencent.map.lib.basemap.data.b a = fp.a(ic.a(dbVar));
        if (a.b() < bVarArr[0].b() || a.b() > bVarArr[1].b() || a.a() > bVarArr[0].a() || a.a() < bVarArr[1].a()) {
            AppMethodBeat.o(99979);
            return false;
        }
        AppMethodBeat.o(99979);
        return true;
    }

    private com.tencent.map.lib.basemap.data.b[] W() {
        AppMethodBeat.i(99980);
        com.tencent.map.lib.basemap.data.b[] bVarArr = new com.tencent.map.lib.basemap.data.b[2];
        com.tencent.map.lib.basemap.data.b a = fp.a(b().t().a(new DoublePoint(0.0d, 0.0d)));
        com.tencent.map.lib.basemap.data.b a2 = fp.a(b().t().a(new DoublePoint((double) getWidth(), (double) getHeight())));
        bVarArr[0] = a;
        bVarArr[1] = a2;
        AppMethodBeat.o(99980);
        return bVarArr;
    }

    private void X() {
        AppMethodBeat.i(99981);
        if (m()) {
            if (this.a instanceof View) {
                if (this.aY == null) {
                    this.aY = new jc((View) this.a, this);
                    this.aY.b();
                }
                s.a((View) this.a, this.aY);
                AppMethodBeat.o(99981);
                return;
            }
        } else if (this.aY != null) {
            s.a((View) this.a, null);
            this.aY.c();
            this.aY = null;
        }
        AppMethodBeat.o(99981);
    }

    public void a(hx hxVar) {
        AppMethodBeat.i(99982);
        if (!(hxVar == null || !(hxVar instanceof hx) || this.aY == null)) {
            this.aY.a(hxVar);
        }
        AppMethodBeat.o(99982);
    }

    /* Access modifiers changed, original: protected */
    public boolean b(MotionEvent motionEvent) {
        AppMethodBeat.i(99983);
        if (this.aY != null) {
            boolean dispatchHoverEvent = this.aY.dispatchHoverEvent(motionEvent);
            AppMethodBeat.o(99983);
            return dispatchHoverEvent;
        }
        AppMethodBeat.o(99983);
        return false;
    }
}
