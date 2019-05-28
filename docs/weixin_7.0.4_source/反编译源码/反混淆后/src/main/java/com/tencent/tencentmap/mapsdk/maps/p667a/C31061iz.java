package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Handler;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.map.lib.C1016e;
import com.tencent.map.lib.C45132a;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.basemap.data.C45133b;
import com.tencent.map.lib.basemap.data.C8885a;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.listener.C41721a;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.C37428d;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31076li.C31077a;
import com.tencent.tencentmap.mapsdk.p666a.C16191cz;
import com.tencent.tencentmap.mapsdk.p666a.C24333as;
import com.tencent.tencentmap.mapsdk.p666a.C24339ch;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;
import com.tencent.tencentmap.mapsdk.p666a.C24346dd;
import com.tencent.tencentmap.mapsdk.p666a.C25001ar.C25006b;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C16179d;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C24326f;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30981g;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30983e;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30985h;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30986j;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30987k;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30988a;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30990c;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30991i;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30992l;
import com.tencent.tencentmap.mapsdk.p666a.C31000cw;
import com.tencent.tencentmap.mapsdk.p666a.C31006ds;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import com.tencent.tencentmap.mapsdk.p666a.C36464bj;
import com.tencent.tencentmap.mapsdk.p666a.C36466cl;
import com.tencent.tencentmap.mapsdk.p666a.C41020dp;
import com.tencent.tencentmap.mapsdk.p666a.C44480ak;
import com.tencent.tencentmap.mapsdk.p666a.C44490de;
import com.tencent.tencentmap.mapsdk.p666a.C44494dn;
import com.tencent.tencentmap.mapsdk.p666a.C46754bo;
import com.tencent.tencentmap.mapsdk.p666a.C46756cb;
import com.tencent.tencentmap.mapsdk.p666a.C46760dq;
import com.tencent.tencentmap.mapsdk.p666a.C46765r;
import com.tencent.tencentmap.mapsdk.p666a.C46766t;
import com.tencent.tencentmap.mapsdk.p666a.C46940aw.C41010a;
import com.tencent.tencentmap.mapsdk.p666a.C5841cp;
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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.iz */
public class C31061iz extends C46787gd implements C30990c, C25012ip {
    /* renamed from: A */
    public float f14187A = 0.5f;
    /* renamed from: B */
    public float f14188B = 0.5f;
    /* renamed from: C */
    protected boolean f14189C = true;
    /* renamed from: D */
    protected boolean f14190D = true;
    /* renamed from: E */
    protected boolean f14191E = true;
    /* renamed from: F */
    protected boolean f14192F = true;
    /* renamed from: G */
    protected boolean f14193G = true;
    /* renamed from: H */
    protected boolean f14194H = true;
    /* renamed from: I */
    public Handler f14195I = null;
    /* renamed from: J */
    public volatile boolean f14196J = false;
    /* renamed from: K */
    public volatile boolean f14197K = false;
    /* renamed from: L */
    protected int f14198L = 0;
    /* renamed from: M */
    public C24343db f14199M = null;
    /* renamed from: N */
    public C24343db f14200N = null;
    /* renamed from: O */
    public int f14201O = 0;
    /* renamed from: P */
    public int f14202P = 0;
    /* renamed from: Q */
    public int f14203Q = 0;
    /* renamed from: R */
    public int f14204R = 0;
    /* renamed from: S */
    public int f14205S = 0;
    /* renamed from: T */
    public int f14206T = 0;
    /* renamed from: U */
    public int f14207U = 0;
    /* renamed from: V */
    public boolean f14208V = false;
    /* renamed from: W */
    public C5885hw f14209W = null;
    /* renamed from: X */
    private String f14210X = "";
    /* renamed from: Y */
    private boolean f14211Y = false;
    /* renamed from: Z */
    private List<C36519hz> f14212Z = new ArrayList();
    /* renamed from: aA */
    private int f14213aA = C8415j.INVALID_ID;
    /* renamed from: aB */
    private int f14214aB = C8415j.INVALID_ID;
    /* renamed from: aC */
    private GeoPoint f14215aC = null;
    /* renamed from: aD */
    private C24414lq f14216aD = null;
    /* renamed from: aE */
    private boolean f14217aE = false;
    /* renamed from: aF */
    private float f14218aF = 100.0f;
    /* renamed from: aG */
    private float f14219aG = 100.0f;
    /* renamed from: aH */
    private boolean f14220aH = true;
    /* renamed from: aI */
    private volatile boolean f14221aI = false;
    /* renamed from: aJ */
    private boolean f14222aJ = false;
    /* renamed from: aK */
    private int f14223aK = 10;
    /* renamed from: aL */
    private int f14224aL = 0;
    /* renamed from: aM */
    private int f14225aM = 0;
    /* renamed from: aN */
    private boolean f14226aN = false;
    /* renamed from: aO */
    private int f14227aO = 19;
    /* renamed from: aP */
    private int f14228aP = 3;
    /* renamed from: aQ */
    private float f14229aQ = 0.0f;
    /* renamed from: aR */
    private AtomicBoolean f14230aR = new AtomicBoolean(false);
    /* renamed from: aS */
    private boolean f14231aS = true;
    /* renamed from: aT */
    private boolean f14232aT = true;
    /* renamed from: aU */
    private final C44513gf f14233aU;
    /* renamed from: aV */
    private C8885a f14234aV;
    /* renamed from: aW */
    private boolean f14235aW = false;
    /* renamed from: aX */
    private boolean f14236aX = true;
    /* renamed from: aY */
    private C17083jc f14237aY;
    /* renamed from: aZ */
    private C44480ak f14238aZ;
    /* renamed from: aa */
    private List<C36519hz> f14239aa = new ArrayList();
    /* renamed from: ab */
    private List<C36519hz> f14240ab = new ArrayList();
    /* renamed from: ac */
    private List<C36519hz> f14241ac = new ArrayList();
    /* renamed from: ad */
    private C46754bo f14242ad;
    /* renamed from: ae */
    private C24415ls f14243ae = null;
    /* renamed from: af */
    private C31063jr f14244af;
    /* renamed from: ag */
    private List<C36519hz> f14245ag = new ArrayList();
    /* renamed from: ah */
    private C24406lh f14246ah;
    /* renamed from: ai */
    private C24339ch f14247ai = null;
    /* renamed from: aj */
    private C31077a f14248aj = null;
    /* renamed from: ak */
    private Map<Class<? extends C36519hz>, C46756cb> f14249ak = new HashMap();
    /* renamed from: al */
    private List<C24333as> f14250al = null;
    /* renamed from: am */
    private C30983e f14251am = null;
    /* renamed from: an */
    private final C5884gt f14252an;
    /* renamed from: ao */
    private C1016e f14253ao = new C24391iq(this);
    /* renamed from: ap */
    private final C41050ft f14254ap;
    /* renamed from: aq */
    private C25006b f14255aq = null;
    /* renamed from: ar */
    private C31044fv f14256ar = new C44526it(this);
    /* renamed from: as */
    private Handler f14257as;
    /* renamed from: at */
    private C36464bj f14258at;
    /* renamed from: au */
    private C45132a f14259au;
    /* renamed from: av */
    private Comparator<C36519hz> f14260av = new C162841();
    /* renamed from: aw */
    private Config f14261aw = Config.RGB_565;
    /* renamed from: ax */
    private boolean f14262ax = true;
    /* renamed from: ay */
    private int f14263ay = C8415j.INVALID_ID;
    /* renamed from: az */
    private int f14264az = C8415j.INVALID_ID;
    /* renamed from: b */
    public byte[] f14265b = new byte[0];
    /* renamed from: ba */
    private List<C36899hx> f14266ba = new ArrayList();
    /* renamed from: bb */
    private List<MapPoi> f14267bb = new ArrayList();
    /* renamed from: c */
    public C5885hw f14268c = null;
    /* renamed from: d */
    public C31056if f14269d = null;
    /* renamed from: e */
    public C31056if f14270e = null;
    /* renamed from: f */
    public C31056if f14271f = null;
    /* renamed from: g */
    public C31056if f14272g = null;
    /* renamed from: h */
    protected volatile C31000cw f14273h;
    /* renamed from: i */
    public int f14274i = 22;
    /* renamed from: j */
    protected C44829lf f14275j;
    /* renamed from: k */
    protected C41020dp f14276k = null;
    /* renamed from: l */
    public C36466cl f14277l = null;
    /* renamed from: m */
    public C30985h f14278m = null;
    /* renamed from: n */
    public C41010a f14279n = null;
    /* renamed from: o */
    public List<C30990c> f14280o = new CopyOnWriteArrayList();
    /* renamed from: p */
    public C30986j f14281p = null;
    /* renamed from: q */
    public volatile C30991i f14282q = null;
    /* renamed from: r */
    protected C24326f f14283r;
    /* renamed from: s */
    public C30992l f14284s = null;
    /* renamed from: t */
    public C30981g f14285t = null;
    /* renamed from: u */
    public C30987k f14286u = null;
    /* renamed from: v */
    protected final Handler f14287v;
    /* renamed from: w */
    public C30988a f14288w = null;
    /* renamed from: x */
    public C16179d f14289x = null;
    /* renamed from: y */
    public float f14290y = 0.5f;
    /* renamed from: z */
    public float f14291z = 0.5f;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.iz$1 */
    class C162841 implements Comparator<C36519hz> {
        C162841() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(99914);
            int a = mo29522a((C36519hz) obj, (C36519hz) obj2);
            AppMethodBeat.m2505o(99914);
            return a;
        }

        /* renamed from: a */
        public int mo29522a(C36519hz c36519hz, C36519hz c36519hz2) {
            AppMethodBeat.m2504i(99913);
            int compare = Float.compare(c36519hz.mo50172D(), c36519hz2.mo50172D());
            AppMethodBeat.m2505o(99913);
            return compare;
        }
    }

    public C31061iz(C44514gg c44514gg, Context context, C44480ak c44480ak) {
        super(c44514gg, context);
        AppMethodBeat.m2504i(99916);
        this.f14238aZ = c44480ak;
        this.f14287v = new C41065in(this);
        this.f14254ap = new C44525is(this);
        this.f14253ao = new C24391iq(this);
        this.f14233aU = new C46794iv(this);
        this.f14256ar = new C44526it(this);
        this.f14252an = new C24392ir(this);
        this.f14216aD = new C24414lq();
        C24414lq.m37989a(context);
        C46796jp.m88980a(context);
        this.f14227aO = mo75386b().mo20203c();
        this.f14228aP = mo75386b().mo20187b();
        C41073ll.m71458a(context);
        this.f14258at = new C5907lt();
        mo65136a(this.f14233aU);
        mo75386b().mo20178a(this.f14252an);
        mo75386b().mo20175a(this.f14256ar);
        mo75386b().mo20163a(this.f14253ao);
        mo75386b().mo20174a(this.f14254ap);
        mo75386b().mo20171a((C41721a) this);
        if (this.f14195I == null) {
            this.f14195I = new Handler();
        }
        WindowManager windowManager = (WindowManager) mo65138i().getSystemService("window");
        this.f14206T = windowManager.getDefaultDisplay().getWidth();
        this.f14207U = windowManager.getDefaultDisplay().getHeight();
        this.f14247ai = new C24339ch(this);
        this.f14243ae = new C24415ls(this);
        if (c44480ak != null) {
            this.f14217aE = c44480ak.mo70662c();
            this.f14208V = c44480ak.mo70668i();
        }
        AppMethodBeat.m2505o(99916);
    }

    /* renamed from: o */
    public C24415ls mo50478o() {
        return this.f14243ae;
    }

    /* renamed from: a */
    public void mo50433a(int i, int i2) {
        AppMethodBeat.m2504i(99917);
        if (this.f14250al != null) {
            int size = this.f14250al.size();
            for (int i3 = 0; i3 < size; i3++) {
                C24333as c24333as = (C24333as) this.f14250al.get(i3);
                if (c24333as != null) {
                    c24333as.mo40422a(i, i2);
                }
            }
        }
        if (this.f14265b != null) {
            synchronized (this.f14265b) {
                try {
                    if (this.f14212Z != null) {
                        for (C36519hz z : this.f14212Z) {
                            z.mo29507z();
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(99917);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(99917);
    }

    /* renamed from: b */
    private void m49975b(GL10 gl10) {
        AppMethodBeat.m2504i(99918);
        synchronized (this.f14265b) {
            try {
                int size = this.f14212Z.size();
                int i = 0;
                C36519hz c36519hz = null;
                while (i < size) {
                    C36519hz c36519hz2;
                    if (this.f14212Z.size() > size) {
                        size = this.f14212Z.size();
                    }
                    if (i < this.f14212Z.size()) {
                        c36519hz2 = (C36519hz) this.f14212Z.get(i);
                    } else {
                        c36519hz2 = null;
                    }
                    if (c36519hz2 != null) {
                        if (TextUtils.equals(c36519hz2.mo57757A(), this.f14210X)) {
                            if (!(c36519hz2.mo29443a() || this.f14226aN)) {
                                c36519hz2.mo29445b();
                                c36519hz2 = c36519hz;
                            }
                        } else if (c36519hz2 instanceof C16279ia) {
                            ((C16279ia) c36519hz2).mo29502a(mo75386b().mo20250z(), mo75386b().mo20244t(), gl10);
                            c36519hz2 = c36519hz;
                        } else {
                            c36519hz2.mo29441a(gl10);
                        }
                        i++;
                        c36519hz = c36519hz2;
                    }
                    c36519hz2 = c36519hz;
                    i++;
                    c36519hz = c36519hz2;
                }
                if (c36519hz != null) {
                    c36519hz.mo29441a(gl10);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99918);
            }
        }
    }

    /* renamed from: a */
    private boolean m49974a(C36519hz c36519hz, float f, float f2) {
        AppMethodBeat.m2504i(99919);
        if (c36519hz == null || !c36519hz.mo29443a() || !c36519hz.mo57761r()) {
            AppMethodBeat.m2505o(99919);
            return false;
        } else if (c36519hz.mo29444a(f, f2)) {
            C46756cb c46756cb = (C46756cb) this.f14249ak.get(c36519hz.getClass());
            if (c46756cb != null) {
                boolean a = c46756cb.mo29097a(c36519hz, true, mo75386b().mo20244t().mo29297a(new DoublePoint((double) f, (double) f2)));
                AppMethodBeat.m2505o(99919);
                return a;
            }
            AppMethodBeat.m2505o(99919);
            return false;
        } else {
            AppMethodBeat.m2505o(99919);
            return false;
        }
    }

    /* renamed from: a */
    public void mo50430a() {
        AppMethodBeat.m2504i(99920);
        mo75386b().mo20236l();
        if (this.f14289x != null) {
            this.f14289x.mo29055a();
        }
        AppMethodBeat.m2505o(99920);
    }

    /* renamed from: p */
    public C5841cp mo50479p() {
        AppMethodBeat.m2504i(99921);
        C8889f b = mo75386b();
        GeoPoint f = b.mo20219f();
        if (f == null || ((this.f14280o == null || this.f14280o.size() <= 0) && this.f14233aU == null)) {
            AppMethodBeat.m2505o(99921);
            return null;
        }
        C24343db a = C36520ic.m60471a(f);
        float q = b.mo20241q();
        if (q < 0.0f) {
            q = (q % 360.0f) + 360.0f;
        }
        C5841cp a2 = C5841cp.m8926a().mo12325a((float) (((double) ((float) b.mo20225h())) + (Math.log((double) b.mo20234k()) / Math.log(2.0d)))).mo12326a(a).mo12329c(q).mo12328b(b.mo20242r()).mo12327a();
        AppMethodBeat.m2505o(99921);
        return a2;
    }

    /* renamed from: a */
    public void mo50434a(Context context, C44480ak c44480ak) {
        AppMethodBeat.m2504i(99922);
        m49972a(c44480ak);
        C46760dq.m88657a(context);
        if (mo75386b().mo20224g()) {
            mo75386b().mo20159a(5);
        } else {
            mo75386b().mo20159a(0);
        }
        if (this.f14217aE) {
            mo50419L();
        }
        AppMethodBeat.m2505o(99922);
    }

    /* renamed from: a */
    public void mo50435a(Handler handler, Config config) {
        AppMethodBeat.m2504i(99923);
        this.f14257as = handler;
        this.f14261aw = config;
        mo75386b().mo20154a();
        AppMethodBeat.m2505o(99923);
    }

    /* renamed from: a */
    public void mo50449a(String str, boolean z) {
        AppMethodBeat.m2504i(99924);
        mo50450a(str, z, false);
        AppMethodBeat.m2505o(99924);
    }

    /* renamed from: a */
    public void mo50450a(String str, boolean z, boolean z2) {
        synchronized (this.f14265b) {
            if (!z2) {
                this.f14210X = str;
            }
        }
    }

    /* renamed from: q */
    public GeoPoint mo50480q() {
        AppMethodBeat.m2504i(99925);
        synchronized (this.f14265b) {
            try {
                if (this.f14210X == null || this.f14210X.trim().length() == 0) {
                } else {
                    C36519hz b = mo50456b(this.f14210X);
                    if (b == null) {
                        AppMethodBeat.m2505o(99925);
                        return null;
                    }
                    GeoPoint g = ((C36899hx) b).mo58885g();
                    AppMethodBeat.m2505o(99925);
                    return g;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99925);
            }
        }
        return null;
    }

    /* renamed from: r */
    public String mo50481r() {
        String str;
        synchronized (this.f14265b) {
            str = this.f14210X;
        }
        return str;
    }

    /* renamed from: a */
    public C44490de mo50429a(String str) {
        C44490de c44490de;
        AppMethodBeat.m2504i(99926);
        if (StringUtil.isEmpty(str)) {
            AppMethodBeat.m2505o(99926);
            return null;
        }
        synchronized (this.f14265b) {
            try {
                for (C36519hz c36519hz : this.f14212Z) {
                    if (c36519hz.mo57757A().equals(str) && (c36519hz instanceof C36899hx)) {
                        c44490de = ((C36899hx) c36519hz).f15581y;
                    }
                }
                AppMethodBeat.m2505o(99926);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99926);
            }
        }
        return c44490de;
    }

    /* renamed from: a */
    public boolean mo50454a(C36519hz c36519hz) {
        AppMethodBeat.m2504i(99927);
        if (c36519hz == null) {
            AppMethodBeat.m2505o(99927);
            return false;
        }
        synchronized (this.f14265b) {
            try {
                int size = this.f14212Z.size();
                int i = 0;
                boolean z = false;
                int i2 = size;
                while (i < size) {
                    boolean z2;
                    C36519hz c36519hz2 = (C36519hz) this.f14212Z.get(i);
                    if (c36519hz2 == null || z || c36519hz2.mo50172D() < c36519hz.mo50172D()) {
                        z2 = z;
                    } else {
                        z2 = true;
                        i2 = i;
                    }
                    i++;
                    z = z2;
                }
                this.f14212Z.add(i2, c36519hz);
                if (!(c36519hz == null || c36519hz.mo57758B() == null)) {
                    if (this.f14273h != null) {
                        c36519hz.mo57760a(this.f14273h);
                    }
                    this.f14245ag.add(c36519hz);
                }
                if (c36519hz instanceof C36899hx) {
                    this.f14239aa.add(c36519hz);
                    Collections.sort(this.f14239aa, this.f14260av);
                } else if (c36519hz instanceof C36901ib) {
                    this.f14240ab.add(c36519hz);
                    Collections.sort(this.f14240ab, this.f14260av);
                } else {
                    this.f14241ac.add(c36519hz);
                    Collections.sort(this.f14241ac, this.f14260av);
                }
            } finally {
                AppMethodBeat.m2505o(99927);
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A:{Catch:{ all -> 0x0051 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public C36519hz mo50457b(String str, boolean z) {
        AppMethodBeat.m2504i(99928);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(99928);
            return null;
        }
        C36519hz c36519hz;
        synchronized (this.f14265b) {
            try {
                Iterator it = this.f14212Z.iterator();
                while (it.hasNext()) {
                    c36519hz = (C36519hz) it.next();
                    if (c36519hz != null && TextUtils.equals(c36519hz.mo57757A(), str)) {
                        it.remove();
                        if (z) {
                            c36519hz.mo29450d();
                        }
                        if (c36519hz != null) {
                            this.f14239aa.remove(c36519hz);
                            this.f14240ab.remove(c36519hz);
                            this.f14241ac.remove(c36519hz);
                        }
                    }
                }
                c36519hz = null;
                if (c36519hz != null) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99928);
            }
        }
        return c36519hz;
    }

    /* renamed from: a */
    public void mo50441a(C46754bo c46754bo) {
        if (c46754bo != null) {
            synchronized (this.f14265b) {
                this.f14242ad = c46754bo;
            }
        }
    }

    /* renamed from: s */
    public void mo50482s() {
        AppMethodBeat.m2504i(99929);
        synchronized (this.f14265b) {
            try {
                if (this.f14242ad != null) {
                    this.f14242ad.mo75307e();
                    this.f14242ad = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99929);
            }
        }
    }

    /* renamed from: t */
    public void mo50483t() {
        AppMethodBeat.m2504i(99930);
        synchronized (this.f14265b) {
            try {
                if (this.f14242ad != null) {
                    this.f14242ad.mo75308f();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99930);
            }
        }
    }

    /* renamed from: u */
    public boolean mo50484u() {
        boolean z;
        synchronized (this.f14265b) {
            z = this.f14242ad != null;
        }
        return z;
    }

    /* renamed from: a */
    public void mo50447a(Class<? extends C36519hz> cls, C46756cb c46756cb) {
        AppMethodBeat.m2504i(99931);
        this.f14249ak.put(cls, c46756cb);
        AppMethodBeat.m2505o(99931);
    }

    /* renamed from: a */
    public C46756cb mo50428a(Class<? extends C36519hz> cls) {
        AppMethodBeat.m2504i(99932);
        C46756cb c46756cb = (C46756cb) this.f14249ak.get(cls);
        AppMethodBeat.m2505o(99932);
        return c46756cb;
    }

    /* renamed from: b */
    public C46756cb mo50455b(Class<? extends C36519hz> cls) {
        AppMethodBeat.m2504i(99933);
        C46756cb c46756cb = (C46756cb) this.f14249ak.remove(cls);
        AppMethodBeat.m2505o(99933);
        return c46756cb;
    }

    /* renamed from: a */
    public boolean mo50452a(float f, float f2) {
        AppMethodBeat.m2504i(99934);
        if (this.f14279n != null) {
            String c = mo50463c(f, f2);
            if (!(c == null || c.trim().length() == 0)) {
                this.f14279n.mo40425a(c);
                AppMethodBeat.m2505o(99934);
                return true;
            }
        }
        if (this.f14281p != null && this.f14194H) {
            this.f14281p.mo50165a(C36520ic.m60471a(mo75386b().mo20244t().mo29297a(new DoublePoint((double) f, (double) f2))));
        }
        AppMethodBeat.m2505o(99934);
        return false;
    }

    /* renamed from: a */
    public void mo50440a(C24333as c24333as) {
        AppMethodBeat.m2504i(99935);
        if (c24333as == null) {
            AppMethodBeat.m2505o(99935);
            return;
        }
        if (this.f14250al == null) {
            this.f14250al = new ArrayList();
        }
        if (this.f14250al.contains(c24333as)) {
            AppMethodBeat.m2505o(99935);
            return;
        }
        this.f14250al.add(c24333as);
        AppMethodBeat.m2505o(99935);
    }

    /* JADX WARNING: Missing block: B:67:0x0105, code skipped:
            if (r12.f14211Y == false) goto L_0x0130;
     */
    /* JADX WARNING: Missing block: B:68:0x0107, code skipped:
            r4 = r12.f14265b;
     */
    /* JADX WARNING: Missing block: B:69:0x0109, code skipped:
            monitor-enter(r4);
     */
    /* JADX WARNING: Missing block: B:70:0x010a, code skipped:
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:73:0x0111, code skipped:
            if (r1 >= r12.f14239aa.size()) goto L_0x012f;
     */
    /* JADX WARNING: Missing block: B:74:0x0113, code skipped:
            r0 = (com.tencent.tencentmap.mapsdk.maps.p667a.C36899hx) r12.f14239aa.get(r1);
     */
    /* JADX WARNING: Missing block: B:75:0x011d, code skipped:
            if (r0.f15582z == null) goto L_0x0125;
     */
    /* JADX WARNING: Missing block: B:76:0x011f, code skipped:
            r0.f15582z.mo12486d(false);
     */
    /* JADX WARNING: Missing block: B:77:0x0125, code skipped:
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:83:?, code skipped:
            monitor-exit(r4);
     */
    /* JADX WARNING: Missing block: B:85:0x0134, code skipped:
            if (mo50472e(r13, r14) == false) goto L_0x0142;
     */
    /* JADX WARNING: Missing block: B:86:0x0136, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(99936);
     */
    /* JADX WARNING: Missing block: B:90:0x013e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(99936);
     */
    /* JADX WARNING: Missing block: B:91:0x0142, code skipped:
            r0 = r12.f14278m;
     */
    /* JADX WARNING: Missing block: B:92:0x0144, code skipped:
            if (r0 == false) goto L_0x0166;
     */
    /* JADX WARNING: Missing block: B:93:0x0146, code skipped:
            r0 = r12.f14194H;
     */
    /* JADX WARNING: Missing block: B:94:0x0148, code skipped:
            if (r0 == false) goto L_0x0166;
     */
    /* JADX WARNING: Missing block: B:95:0x014a, code skipped:
            r0 = com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic.m60471a(mo75386b().mo20244t().mo29297a(new com.tencent.map.lib.basemap.data.DoublePoint((double) r13, (double) r14)));
            r12.f14278m.mo50164a(r0);
     */
    /* JADX WARNING: Missing block: B:96:0x0166, code skipped:
            r1 = r12.f14265b;
     */
    /* JADX WARNING: Missing block: B:97:0x0168, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:99:?, code skipped:
            mo50483t();
     */
    /* JADX WARNING: Missing block: B:100:0x016c, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:101:0x016d, code skipped:
            mo75389h();
     */
    /* JADX WARNING: Missing block: B:105:0x0178, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(99936);
     */
    /* JADX WARNING: Missing block: B:136:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public boolean mo50461b(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99936);
        synchronized (this.f14265b) {
            try {
                C44490de c44490de;
                boolean z2;
                C5885hw c5885hw;
                C36899hx c36899hx = (C36899hx) mo50456b(this.f14210X);
                C5885hw c5885hw2 = c36899hx != null ? c36899hx.f15582z : null;
                if (this.f14210X.equals("") || c36899hx == null || c5885hw2 == null || !c5885hw2.mo12491j()) {
                    c5885hw2 = null;
                    c44490de = null;
                    z2 = false;
                } else {
                    z2 = c5885hw2.mo29444a(f, f2);
                    if (z2) {
                        c44490de = c36899hx.f15581y;
                    } else {
                        c5885hw2 = null;
                        c44490de = null;
                    }
                }
                if (!z2) {
                    int size = this.f14239aa.size() - 1;
                    while (size >= 0) {
                        c36899hx = (C36899hx) this.f14239aa.get(size);
                        C5885hw c5885hw3 = c36899hx.f15582z;
                        if (!(c36899hx.mo57757A().equals(this.f14210X) || c5885hw3 == null || !c5885hw3.mo12491j())) {
                            z2 = c5885hw3.mo29444a(f, f2);
                            if (z2) {
                                C44490de c44490de2 = c36899hx.f15581y;
                                c5885hw = c5885hw3;
                                c44490de = c44490de2;
                                break;
                            }
                        }
                        size--;
                        z2 = z2;
                    }
                }
                c5885hw = c5885hw2;
                if (!z2) {
                    int size2;
                    z = false;
                    for (size2 = this.f14239aa.size() - 1; size2 >= 0; size2--) {
                        z = m49974a((C36519hz) this.f14239aa.get(size2), f, f2);
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        AppMethodBeat.m2505o(99936);
                        return z;
                    }
                    for (size2 = this.f14240ab.size() - 1; size2 >= 0; size2--) {
                        z = m49974a((C36519hz) this.f14240ab.get(size2), f, f2);
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        AppMethodBeat.m2505o(99936);
                        return z;
                    }
                    for (size2 = this.f14241ac.size() - 1; size2 >= 0; size2--) {
                        z = m49974a((C36519hz) this.f14241ac.get(size2), f, f2);
                        if (z) {
                            break;
                        }
                    }
                    if (z) {
                        AppMethodBeat.m2505o(99936);
                        return z;
                    }
                } else if (!(this.f14285t == null || c44490de == null || c5885hw == null || !c44490de.mo70754l())) {
                    this.f14285t.mo29182a(c44490de);
                    this.f14285t.mo29181a(c5885hw.f3395l, c5885hw.f3396m, c5885hw.f3377G, c5885hw.f3378H);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99936);
            }
        }
        return z;
        return true;
    }

    /* renamed from: a */
    public void mo50451a(boolean z) {
        this.f14211Y = z;
    }

    /* renamed from: a */
    public void mo50448a(String str, float f) {
        AppMethodBeat.m2504i(99937);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(99937);
            return;
        }
        synchronized (this.f14265b) {
            try {
                C36519hz c36519hz;
                int size = this.f14212Z.size();
                int i = 0;
                int i2 = -1;
                int i3 = size;
                while (i < size) {
                    int i4;
                    c36519hz = (C36519hz) this.f14212Z.get(i);
                    if (c36519hz != null) {
                        if (c36519hz.mo50172D() > f) {
                            i3 = i;
                        }
                        if (TextUtils.equals(c36519hz.mo57757A(), str)) {
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
                    c36519hz = (C36519hz) this.f14212Z.remove(i2);
                    if (c36519hz == null) {
                        AppMethodBeat.m2505o(99937);
                        return;
                    }
                    this.f14212Z.add(i3, c36519hz);
                    AppMethodBeat.m2505o(99937);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99937);
            }
        }
    }

    /* renamed from: b */
    public C36519hz mo50456b(String str) {
        C36519hz c36519hz;
        AppMethodBeat.m2504i(99938);
        synchronized (this.f14265b) {
            try {
                int size = this.f14212Z.size();
                c36519hz = null;
                for (int i = 0; i < size; i++) {
                    c36519hz = (C36519hz) this.f14212Z.get(i);
                    if (c36519hz != null) {
                        if (TextUtils.equals(c36519hz.mo57757A(), str)) {
                            break;
                        }
                        c36519hz = null;
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99938);
            }
        }
        return c36519hz;
    }

    /* renamed from: b */
    public void mo50460b(boolean z) {
        this.f14190D = z;
    }

    /* renamed from: c */
    public void mo50466c(boolean z) {
        this.f14189C = z;
    }

    /* renamed from: d */
    public void mo50468d(boolean z) {
        this.f14191E = z;
    }

    /* renamed from: e */
    public void mo50471e(boolean z) {
        this.f14192F = z;
    }

    /* renamed from: f */
    public void mo50473f(boolean z) {
        this.f14193G = z;
    }

    /* renamed from: g */
    public void mo50474g(boolean z) {
        this.f14194H = z;
    }

    /* renamed from: h */
    public void mo50475h(boolean z) {
        AppMethodBeat.m2504i(99939);
        this.f14220aH = z;
        mo75386b().mo20221f(z);
        mo75386b().mo20154a();
        AppMethodBeat.m2505o(99939);
    }

    /* renamed from: v */
    public boolean mo50485v() {
        return this.f14220aH;
    }

    /* renamed from: w */
    public boolean mo50486w() {
        return this.f14190D;
    }

    /* renamed from: x */
    public boolean mo50487x() {
        return this.f14191E;
    }

    /* renamed from: y */
    public boolean mo50488y() {
        return this.f14192F;
    }

    /* renamed from: z */
    public boolean mo50489z() {
        return this.f14193G;
    }

    /* renamed from: c */
    public String mo50463c(float f, float f2) {
        String A;
        AppMethodBeat.m2504i(99940);
        synchronized (this.f14265b) {
            try {
                for (int size = this.f14212Z.size() - 1; size >= 0; size--) {
                    C36519hz c36519hz = (C36519hz) this.f14212Z.get(size);
                    if (c36519hz != null && c36519hz.mo29443a() && (c36519hz instanceof C36899hx) && c36519hz.mo29444a(f, f2)) {
                        A = c36519hz.mo57757A();
                        break;
                    }
                }
                A = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99940);
            }
        }
        return A;
    }

    /* renamed from: i */
    public void mo50476i(boolean z) {
        AppMethodBeat.m2504i(99941);
        if (!z || m49967U()) {
            mo75386b().mo20178a(this.f14252an);
            AppMethodBeat.m2505o(99941);
            return;
        }
        mo75386b().mo20178a(null);
        AppMethodBeat.m2505o(99941);
    }

    /* renamed from: U */
    private boolean m49967U() {
        AppMethodBeat.m2504i(99942);
        boolean d = C24414lq.m37993d();
        AppMethodBeat.m2505o(99942);
        return d;
    }

    /* renamed from: a */
    public boolean mo50453a(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99943);
        if (this.f14279n != null) {
            this.f14279n.mo40424a(motionEvent);
        }
        boolean a = super.mo50453a(motionEvent);
        AppMethodBeat.m2505o(99943);
        return a;
    }

    /* renamed from: e */
    public void mo12505e() {
        AppMethodBeat.m2504i(99944);
        super.mo12505e();
        this.f14198L = 0;
        this.f14197K = false;
        m49970X();
        if (this.f14247ai != null) {
            this.f14247ai.mo40471b();
        }
        AppMethodBeat.m2505o(99944);
    }

    /* renamed from: g */
    public void mo12507g() {
        AppMethodBeat.m2504i(99945);
        super.mo12507g();
        mo75386b().mo20171a(null);
        C46760dq.m88656a();
        if (this.f14280o != null) {
            this.f14280o.clear();
        }
        if (this.f14237aY != null) {
            this.f14237aY.mo31153d();
        }
        if (this.f14243ae != null) {
            this.f14243ae.mo40742b();
        }
        this.f14222aJ = true;
        AppMethodBeat.m2505o(99945);
    }

    /* renamed from: A */
    public void mo50408A() {
        AppMethodBeat.m2504i(99946);
        if (this.f14195I != null) {
            this.f14195I.removeCallbacksAndMessages(null);
        }
        if (this.f14287v != null) {
            this.f14287v.removeCallbacksAndMessages(null);
        }
        if (this.f14257as != null) {
            this.f14257as.removeCallbacksAndMessages(null);
        }
        if (this.f14250al != null) {
            this.f14250al.clear();
            this.f14250al = null;
        }
        m49968V();
        if (this.f14249ak != null) {
            this.f14249ak.clear();
        }
        AppMethodBeat.m2505o(99946);
    }

    /* renamed from: c */
    public void mo50465c(Class<? extends C36519hz> cls) {
        AppMethodBeat.m2504i(99947);
        if (cls == null) {
            AppMethodBeat.m2505o(99947);
            return;
        }
        synchronized (this.f14265b) {
            try {
                Iterator it = this.f14212Z.iterator();
                while (it.hasNext()) {
                    C36519hz c36519hz = (C36519hz) it.next();
                    if (!(c36519hz == null || !cls.isInstance(c36519hz) || c36519hz.mo57762y())) {
                        c36519hz.mo29450d();
                        it.remove();
                        this.f14239aa.remove(c36519hz);
                        this.f14240ab.remove(c36519hz);
                        this.f14241ac.remove(c36519hz);
                    }
                }
            } finally {
                AppMethodBeat.m2505o(99947);
            }
        }
        mo75386b().mo20154a();
    }

    /* renamed from: a */
    public void mo50442a(C44494dn c44494dn) {
        AppMethodBeat.m2504i(99948);
        if (this.f14276k == null) {
            this.f14276k = new C41020dp();
        }
        this.f14276k.mo65069a(c44494dn);
        AppMethodBeat.m2505o(99948);
    }

    /* renamed from: b */
    public void mo50459b(C44494dn c44494dn) {
        AppMethodBeat.m2504i(99949);
        if (this.f14276k == null) {
            AppMethodBeat.m2505o(99949);
            return;
        }
        this.f14276k.mo65070b(c44494dn);
        AppMethodBeat.m2505o(99949);
    }

    /* renamed from: a */
    public void mo50432a(int i) {
        AppMethodBeat.m2504i(99950);
        this.f14225aM = i;
        mo75386b().mo20218e(this.f14224aL + 52, i + 52);
        mo75389h();
        AppMethodBeat.m2505o(99950);
    }

    /* renamed from: b */
    public void mo50458b(int i, int i2) {
        AppMethodBeat.m2504i(99951);
        this.f14224aL = i;
        this.f14225aM = i2;
        mo75386b().mo20218e(i + 52, i2 + 52);
        mo75389h();
        AppMethodBeat.m2505o(99951);
    }

    /* renamed from: a */
    public void mo50439a(C25006b c25006b) {
        this.f14255aq = c25006b;
    }

    /* renamed from: d */
    public boolean mo50469d(float f, float f2) {
        AppMethodBeat.m2504i(99952);
        if (this.f14194H) {
            boolean a = mo75386b().mo20185a(f, f2);
            AppMethodBeat.m2505o(99952);
            return a;
        }
        AppMethodBeat.m2505o(99952);
        return false;
    }

    /* renamed from: B */
    public void mo50409B() {
        AppMethodBeat.m2504i(99953);
        int h = mo75386b().mo20225h();
        this.f14231aS = true;
        this.f14232aT = true;
        if (h <= this.f14228aP) {
            this.f14232aT = false;
        } else if (h >= this.f14227aO) {
            this.f14231aS = false;
        }
        if (this.f14248aj != null) {
            C31076li c31076li = new C31076li();
            c31076li.f14311a = 0;
            c31076li.f14312b = this.f14231aS;
            c31076li.f14313c = this.f14232aT;
            this.f14248aj.mo50529a(c31076li);
        }
        AppMethodBeat.m2505o(99953);
    }

    /* renamed from: C */
    public void mo50410C() {
        AppMethodBeat.m2504i(99954);
        if (this.f14248aj != null) {
            C31076li c31076li = new C31076li();
            c31076li.f14311a = 0;
            c31076li.f14312b = this.f14231aS;
            c31076li.f14313c = this.f14232aT;
            this.f14248aj.mo50529a(c31076li);
        }
        AppMethodBeat.m2505o(99954);
    }

    /* renamed from: a */
    public void mo50431a(float f) {
        AppMethodBeat.m2504i(99955);
        if (this.f14229aQ == f) {
            AppMethodBeat.m2505o(99955);
            return;
        }
        this.f14229aQ = f;
        if (this.f14248aj != null) {
            C31076li c31076li = new C31076li();
            c31076li.f14311a = 1;
            c31076li.f14314d = mo75386b().mo20225h();
            c31076li.f14315e = mo75386b().mo20244t().mo29296a(new Point(0, this.f14207U / 2), new Point(this.f14206T, this.f14207U / 2));
            this.f14248aj.mo50529a(c31076li);
        }
        AppMethodBeat.m2505o(99955);
    }

    /* renamed from: D */
    public C44829lf mo50411D() {
        return this.f14275j;
    }

    /* renamed from: E */
    public C24339ch mo50412E() {
        return this.f14247ai;
    }

    /* renamed from: c */
    public void mo50464c(int i, int i2) {
        AppMethodBeat.m2504i(99956);
        if (i == 0 || i2 == 0) {
            AppMethodBeat.m2505o(99956);
            return;
        }
        if (this.f14215aC == null) {
            GeoPoint f = mo75386b().mo20219f();
            this.f14215aC = new GeoPoint(f.getLatitudeE6(), f.getLongitudeE6());
        }
        this.f14215aC.setLatitudeE6(i);
        this.f14215aC.setLongitudeE6(i2);
        AppMethodBeat.m2505o(99956);
    }

    /* renamed from: F */
    public GeoPoint mo50413F() {
        AppMethodBeat.m2504i(99957);
        if (this.f14215aC == null) {
            if (this.f14263ay == C8415j.INVALID_ID) {
                this.f14263ay = this.f14206T / 2;
            }
            if (this.f14264az == C8415j.INVALID_ID) {
                this.f14264az = this.f14207U / 2;
            }
            this.f14215aC = mo75386b().mo20244t().mo29297a(new DoublePoint((double) this.f14263ay, (double) this.f14264az));
        }
        GeoPoint geoPoint = this.f14215aC;
        AppMethodBeat.m2505o(99957);
        return geoPoint;
    }

    /* renamed from: G */
    public int mo50414G() {
        return this.f14213aA;
    }

    /* renamed from: H */
    public int mo50415H() {
        return this.f14214aB;
    }

    /* renamed from: I */
    public int mo50416I() {
        return this.f14263ay;
    }

    /* renamed from: J */
    public int mo50417J() {
        return this.f14264az;
    }

    /* renamed from: d */
    public void mo50467d(int i, int i2) {
        this.f14263ay = i;
        this.f14264az = i2;
    }

    /* renamed from: e */
    public void mo50470e(int i, int i2) {
        this.f14213aA = i;
        this.f14214aB = i2;
    }

    /* renamed from: a */
    public void mo50446a(C31077a c31077a) {
        this.f14248aj = c31077a;
    }

    /* renamed from: a */
    public void mo50437a(C24326f c24326f) {
        this.f14283r = c24326f;
    }

    /* renamed from: e */
    public boolean mo50472e(float f, float f2) {
        AppMethodBeat.m2504i(99958);
        TappedElement b = mo75386b().mo20188b(f, f2);
        if (b != null) {
            switch (b.type) {
                case 0:
                    AppMethodBeat.m2505o(99958);
                    return false;
                case 1:
                    if (this.f14286u != null) {
                        C24346dd c16191cz;
                        if (b.itemType == 1) {
                            c16191cz = new C16191cz();
                            c16191cz.f3080b = b.buildingName;
                            c16191cz.f3079a = b.buildingId;
                            c16191cz.f3081c = b.floorName;
                        } else {
                            c16191cz = new C24346dd();
                        }
                        c16191cz.f4619d = b.name;
                        GeoPoint a = C37428d.m63087a(b.pixelX, b.pixelY);
                        if (a != null) {
                            c16191cz.f4620e = new C24343db(((double) a.getLatitudeE6()) / 1000000.0d, ((double) a.getLongitudeE6()) / 1000000.0d);
                        }
                        this.f14286u.mo29183a(c16191cz);
                        break;
                    }
                    break;
                case 8:
                    break;
                default:
                    AppMethodBeat.m2505o(99958);
                    return false;
            }
            AppMethodBeat.m2505o(99958);
            return true;
        }
        AppMethodBeat.m2505o(99958);
        return false;
    }

    /* renamed from: a */
    public void mo50438a(C30987k c30987k) {
        this.f14286u = c30987k;
    }

    /* renamed from: a */
    public void mo50445a(final C24406lh c24406lh) {
        AppMethodBeat.m2504i(99959);
        this.f14246ah = c24406lh;
        mo50436a(new C30990c() {
            public void onCameraChange(C5841cp c5841cp) {
            }

            public void onCameraChangeFinished(C5841cp c5841cp) {
                AppMethodBeat.m2504i(99915);
                c24406lh.mo40719h();
                AppMethodBeat.m2505o(99915);
            }
        });
        AppMethodBeat.m2505o(99959);
    }

    /* renamed from: K */
    public C24406lh mo50418K() {
        return this.f14246ah;
    }

    /* renamed from: a */
    public void mo50444a(C44829lf c44829lf) {
        this.f14275j = c44829lf;
    }

    /* renamed from: L */
    public void mo50419L() {
        AppMethodBeat.m2504i(99960);
        if (this.f14244af == null) {
            this.f14244af = new C31063jr(new C41356jq(this));
            mo50454a(this.f14244af);
            new C31066jt(mo65138i().getApplicationContext(), this.f14244af).mo50495a();
        }
        AppMethodBeat.m2505o(99960);
    }

    /* renamed from: M */
    public void mo50420M() {
        AppMethodBeat.m2504i(99961);
        if (this.f14244af != null) {
            this.f14244af.mo50491e();
            this.f14244af = null;
        }
        AppMethodBeat.m2505o(99961);
    }

    /* renamed from: N */
    public boolean mo50421N() {
        return this.f14244af != null;
    }

    /* renamed from: O */
    public boolean mo50422O() {
        return this.f14235aW;
    }

    /* renamed from: j */
    public void mo50477j(boolean z) {
        this.f14235aW = z;
    }

    /* renamed from: a */
    public void mo50436a(C30990c c30990c) {
        AppMethodBeat.m2504i(99962);
        if (!(this.f14280o == null || c30990c == null)) {
            this.f14280o.add(c30990c);
        }
        mo50476i(c30990c == null);
        AppMethodBeat.m2505o(99962);
    }

    /* renamed from: P */
    public C44480ak mo50423P() {
        return this.f14238aZ;
    }

    /* renamed from: a */
    public void mo12500a(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.m2504i(99963);
        super.mo12500a(gl10, eGLConfig);
        AppMethodBeat.m2505o(99963);
    }

    /* renamed from: a */
    public void mo12499a(GL10 gl10, int i, int i2) {
        AppMethodBeat.m2504i(99964);
        super.mo12499a(gl10, i, i2);
        this.f14206T = i;
        this.f14207U = i2;
        mo50467d((int) (((float) this.f14206T) * this.f14290y), (int) (((float) this.f14207U) * this.f14291z));
        mo50470e((int) (((float) this.f14206T) * this.f14187A), (int) (((float) this.f14207U) * this.f14188B));
        if (this.f14255aq != null) {
            this.f14255aq.mo41915a();
        }
        AppMethodBeat.m2505o(99964);
    }

    /* renamed from: j */
    public void mo12510j() {
        AppMethodBeat.m2504i(99965);
        super.mo12510j();
        AppMethodBeat.m2505o(99965);
    }

    /* renamed from: a */
    public boolean mo12501a(GL10 gl10) {
        AppMethodBeat.m2504i(99966);
        m49975b(gl10);
        boolean a = super.mo12501a(gl10);
        if (this.f14257as != null && mo75386b() != null && mo75386b().mo20145H() && mo50478o() != null && mo50478o().mo40743c() && mo75393n()) {
            if (this.f14236aX) {
                this.f14236aX = false;
                this.f14246ah.mo40722k();
                mo75391l();
            } else {
                m49976c(gl10);
                this.f14246ah.mo40723l();
                this.f14236aX = true;
            }
        }
        AppMethodBeat.m2505o(99966);
        return a;
    }

    /* renamed from: a */
    private void m49972a(C44480ak c44480ak) {
        AppMethodBeat.m2504i(99967);
        Context applicationContext = mo65138i().getApplicationContext();
        C31006ds.m49791a().mo50284a(applicationContext);
        C46765r a = C46765r.m88663a(applicationContext);
        C31015v.m49802a(a.mo75315b());
        C31015v.m49802a(a.mo75317c());
        String str = null;
        if (!(c44480ak == null || StringUtil.isEmpty(c44480ak.mo70667h()))) {
            str = c44480ak.mo70667h();
        }
        C31015v.m49802a(a.mo75316b(str));
        C31015v.m49802a(a.mo75318c(str));
        C31015v.m49802a(a.mo75319d());
        if (c44480ak != null) {
            if (c44480ak.mo70656a() != null) {
                C46766t.m88678a(c44480ak.mo70656a());
            } else if (c44480ak.mo70660b() != null) {
                C46766t.m88682b(c44480ak.mo70660b());
            }
        }
        C46795jn.m88977a(applicationContext, str);
        this.f14259au = new C46942jg(this, str);
        mo75384a(this.f14259au, (C24386hf) C41064il.m71422a());
        mo75386b().mo20200b(C46790hs.m88918a());
        mo75386b().mo20208c(C46790hs.m88922d());
        AppMethodBeat.m2505o(99967);
    }

    /* renamed from: c */
    private void m49976c(GL10 gl10) {
        AppMethodBeat.m2504i(99968);
        if (gl10 == null) {
            AppMethodBeat.m2505o(99968);
            return;
        }
        Object createBitmap;
        int i = this.f14206T;
        int i2 = this.f14207U;
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
            createBitmap = Bitmap.createBitmap(iArr2, i, i2, this.f14261aw);
        } catch (OutOfMemoryError e) {
            createBitmap = null;
        }
        if (!(this.f18140a == null || (this.f18140a instanceof C24393iw) || !this.f14246ah.mo40721j())) {
            createBitmap = m49971a((Bitmap) createBitmap, this.f14246ah.mo40720i());
        }
        this.f14257as.sendMessage(this.f14257as.obtainMessage(0, createBitmap));
        this.f14257as = null;
        AppMethodBeat.m2505o(99968);
    }

    /* renamed from: a */
    private Bitmap m49971a(Bitmap bitmap, Bitmap bitmap2) {
        AppMethodBeat.m2504i(99969);
        if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
            AppMethodBeat.m2505o(99969);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), null);
        canvas.drawBitmap(bitmap2, (float) this.f14246ah.mo40713c().left, (float) this.f14246ah.mo40713c().top, null);
        AppMethodBeat.m2505o(99969);
        return createBitmap;
    }

    /* renamed from: V */
    private void m49968V() {
        AppMethodBeat.m2504i(99970);
        synchronized (this.f14265b) {
            try {
                if (this.f14212Z == null) {
                } else {
                    Iterator it = this.f14212Z.iterator();
                    while (it.hasNext()) {
                        C36519hz c36519hz = (C36519hz) it.next();
                        if (c36519hz != null) {
                            c36519hz.mo29450d();
                        }
                        it.remove();
                    }
                    this.f14239aa.clear();
                    this.f14240ab.clear();
                    this.f14241ac.clear();
                    AppMethodBeat.m2505o(99970);
                }
            } finally {
                AppMethodBeat.m2505o(99970);
            }
        }
    }

    /* renamed from: Q */
    public C8885a mo50424Q() {
        AppMethodBeat.m2504i(99971);
        C45133b[] R = mo50425R();
        C45133b a = C16230fp.m24762a(mo75386b().mo20219f());
        float h = (float) mo75386b().mo20225h();
        if (this.f14234aV == null) {
            this.f14234aV = new C8885a(a, R, h);
        } else {
            this.f14234aV.mo20121a(a, R, h);
        }
        C8885a c8885a = this.f14234aV;
        AppMethodBeat.m2505o(99971);
        return c8885a;
    }

    /* renamed from: R */
    public C45133b[] mo50425R() {
        AppMethodBeat.m2504i(99972);
        C45133b[] c45133bArr = new C45133b[8];
        DoublePoint[] doublePointArr = new DoublePoint[8];
        float f = (float) this.f14206T;
        float f2 = (float) this.f14207U;
        if (f <= 2.0f || f2 <= 2.0f) {
            AppMethodBeat.m2505o(99972);
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
            c45133bArr[i] = C16230fp.m24762a(mo75386b().mo20244t().mo29297a(doublePointArr[i]));
        }
        AppMethodBeat.m2505o(99972);
        return c45133bArr;
    }

    public boolean onIndoorBuildingFocused() {
        return false;
    }

    public boolean onIndoorLevelActivated(C31000cw c31000cw) {
        AppMethodBeat.m2504i(99973);
        this.f14273h = c31000cw;
        for (C36519hz a : this.f14245ag) {
            a.mo57760a(c31000cw);
        }
        AppMethodBeat.m2505o(99973);
        return false;
    }

    public boolean onIndoorBuildingDeactivated() {
        AppMethodBeat.m2504i(99974);
        this.f14273h = null;
        for (C36519hz C : this.f14245ag) {
            C.mo57759C();
        }
        AppMethodBeat.m2505o(99974);
        return false;
    }

    public void onCameraChange(C5841cp c5841cp) {
        AppMethodBeat.m2504i(99975);
        if (this.f14280o != null) {
            for (C30990c c30990c : this.f14280o) {
                if (c30990c != null) {
                    c30990c.onCameraChange(c5841cp);
                }
            }
        }
        AppMethodBeat.m2505o(99975);
    }

    public void onCameraChangeFinished(C5841cp c5841cp) {
        AppMethodBeat.m2504i(99976);
        if (this.f14280o != null) {
            for (C30990c c30990c : this.f14280o) {
                if (c30990c != null) {
                    c30990c.onCameraChangeFinished(c5841cp);
                }
            }
        }
        AppMethodBeat.m2505o(99976);
    }

    /* renamed from: S */
    public List<C36899hx> mo50426S() {
        AppMethodBeat.m2504i(99977);
        this.f14266ba.clear();
        C45133b[] W = m49969W();
        for (C36519hz c36519hz : this.f14239aa) {
            if (c36519hz instanceof C36899hx) {
                C36899hx c36899hx = (C36899hx) c36519hz;
                if (m49973a(c36899hx.f15581y.mo70745e(), W)) {
                    this.f14266ba.add(c36899hx);
                }
            }
        }
        List list = this.f14266ba;
        AppMethodBeat.m2505o(99977);
        return list;
    }

    /* renamed from: T */
    public List<MapPoi> mo50427T() {
        AppMethodBeat.m2504i(99978);
        this.f14267bb.clear();
        this.f14267bb = mo75386b().mo20146I();
        List list = this.f14267bb;
        AppMethodBeat.m2505o(99978);
        return list;
    }

    /* renamed from: a */
    private boolean m49973a(C24343db c24343db, C45133b[] c45133bArr) {
        AppMethodBeat.m2504i(99979);
        if (c24343db == null) {
            AppMethodBeat.m2505o(99979);
            return false;
        }
        C45133b a = C16230fp.m24762a(C36520ic.m60470a(c24343db));
        if (a.mo72954b() < c45133bArr[0].mo72954b() || a.mo72954b() > c45133bArr[1].mo72954b() || a.mo72952a() > c45133bArr[0].mo72952a() || a.mo72952a() < c45133bArr[1].mo72952a()) {
            AppMethodBeat.m2505o(99979);
            return false;
        }
        AppMethodBeat.m2505o(99979);
        return true;
    }

    /* renamed from: W */
    private C45133b[] m49969W() {
        AppMethodBeat.m2504i(99980);
        C45133b[] c45133bArr = new C45133b[2];
        C45133b a = C16230fp.m24762a(mo75386b().mo20244t().mo29297a(new DoublePoint(0.0d, 0.0d)));
        C45133b a2 = C16230fp.m24762a(mo75386b().mo20244t().mo29297a(new DoublePoint((double) getWidth(), (double) getHeight())));
        c45133bArr[0] = a;
        c45133bArr[1] = a2;
        AppMethodBeat.m2505o(99980);
        return c45133bArr;
    }

    /* renamed from: X */
    private void m49970X() {
        AppMethodBeat.m2504i(99981);
        if (mo75392m()) {
            if (this.f18140a instanceof View) {
                if (this.f14237aY == null) {
                    this.f14237aY = new C17083jc((View) this.f18140a, this);
                    this.f14237aY.mo31151b();
                }
                C0477s.m905a((View) this.f18140a, this.f14237aY);
                AppMethodBeat.m2505o(99981);
                return;
            }
        } else if (this.f14237aY != null) {
            C0477s.m905a((View) this.f18140a, null);
            this.f14237aY.mo31152c();
            this.f14237aY = null;
        }
        AppMethodBeat.m2505o(99981);
    }

    /* renamed from: a */
    public void mo50443a(C36899hx c36899hx) {
        AppMethodBeat.m2504i(99982);
        if (!(c36899hx == null || !(c36899hx instanceof C36899hx) || this.f14237aY == null)) {
            this.f14237aY.mo31149a(c36899hx);
        }
        AppMethodBeat.m2505o(99982);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo50462b(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99983);
        if (this.f14237aY != null) {
            boolean dispatchHoverEvent = this.f14237aY.dispatchHoverEvent(motionEvent);
            AppMethodBeat.m2505o(99983);
            return dispatchHoverEvent;
        }
        AppMethodBeat.m2505o(99983);
        return false;
    }
}
