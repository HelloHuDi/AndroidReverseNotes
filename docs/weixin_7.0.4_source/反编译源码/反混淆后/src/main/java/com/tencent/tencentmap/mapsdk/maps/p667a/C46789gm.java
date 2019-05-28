package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.C41716b;
import com.tencent.map.lib.C45132a;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.map.lib.element.C8886a;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.p822gl.C17851b;
import com.tencent.map.lib.p822gl.JNICallback.C25720d;
import com.tencent.map.lib.p822gl.JNICallback.C25721e;
import com.tencent.map.lib.p822gl.JNICallback.C32209c;
import com.tencent.map.lib.p822gl.JNICallback.C32210j;
import com.tencent.map.lib.p822gl.JNICallback.C32211b;
import com.tencent.map.lib.p822gl.JNICallback.C32212k;
import com.tencent.map.lib.util.C32219c;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gm */
public class C46789gm implements C5876fn, C31043fu {
    /* renamed from: A */
    private String f18149A;
    /* renamed from: B */
    private boolean f18150B = true;
    /* renamed from: C */
    private boolean f18151C = false;
    /* renamed from: D */
    private int f18152D = 0;
    /* renamed from: E */
    private int f18153E = 0;
    /* renamed from: F */
    private Rect f18154F;
    /* renamed from: G */
    private float f18155G = 0.5f;
    /* renamed from: H */
    private float f18156H = 0.5f;
    /* renamed from: I */
    private boolean f18157I = true;
    /* renamed from: J */
    private int f18158J = 18;
    /* renamed from: K */
    private int f18159K = 14;
    /* renamed from: L */
    private boolean f18160L = false;
    /* renamed from: a */
    private C16238gh f18161a;
    /* renamed from: b */
    private C17851b f18162b;
    /* renamed from: c */
    private C36894gk f18163c;
    /* renamed from: d */
    private C44516ha f18164d;
    /* renamed from: e */
    private C41053gl f18165e;
    /* renamed from: f */
    private C16263gj f18166f;
    /* renamed from: g */
    private WeakReference<C41052ge> f18167g;
    /* renamed from: h */
    private C16230fp f18168h;
    /* renamed from: i */
    private Rect f18169i;
    /* renamed from: j */
    private boolean f18170j;
    /* renamed from: k */
    private boolean f18171k;
    /* renamed from: l */
    private Context f18172l;
    /* renamed from: m */
    private C36515gv f18173m;
    /* renamed from: n */
    private C31051d f18174n;
    /* renamed from: o */
    private C24382gs f18175o;
    /* renamed from: p */
    private LinkedBlockingQueue<C46788a> f18176p;
    /* renamed from: q */
    private C36516gx f18177q;
    /* renamed from: r */
    private C45132a f18178r;
    /* renamed from: s */
    private volatile boolean f18179s = false;
    /* renamed from: t */
    private C32219c<Integer, Integer> f18180t;
    /* renamed from: u */
    private boolean f18181u = true;
    /* renamed from: v */
    private C41716b f18182v;
    /* renamed from: w */
    private boolean f18183w = true;
    /* renamed from: x */
    private C44515b f18184x;
    /* renamed from: y */
    private C31050c f18185y;
    /* renamed from: z */
    private C41051gc f18186z;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gm$1 */
    class C162641 implements C46788a {
        /* renamed from: a */
        final /* synthetic */ C46789gm f3337a;

        /* renamed from: a */
        public void mo12454a(GL10 gl10) {
            AppMethodBeat.m2504i(99289);
            if (this.f3337a.f18161a != null) {
                this.f3337a.f18162b.mo33216b(gl10);
            }
            AppMethodBeat.m2505o(99289);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gm$e */
    class C24379e {
        /* renamed from: a */
        private int f4693a;
        /* renamed from: b */
        private C41057gw f4694b;
        /* renamed from: c */
        private C41717j f4695c;
        /* renamed from: d */
        private int f4696d;
        /* renamed from: e */
        private int f4697e;
        /* renamed from: f */
        private Rect f4698f;
        /* renamed from: g */
        private int f4699g;

        /* renamed from: a */
        public synchronized boolean mo40585a() {
            return this.f4699g == 2;
        }

        /* renamed from: b */
        public synchronized void mo40586b() {
            this.f4699g = 2;
            this.f4693a = 0;
        }

        /* renamed from: c */
        public boolean mo40587c() {
            return this.f4699g == 1;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gm$c */
    class C31050c implements MapLanguageChangeListener {
        /* renamed from: b */
        private List<MapRouteSectionWithName> f14147b;
        /* renamed from: c */
        private List<GeoPoint> f14148c;

        public C31050c() {
            AppMethodBeat.m2504i(99294);
            C46789gm.this.mo75422a((MapLanguageChangeListener) this);
            AppMethodBeat.m2505o(99294);
        }

        /* renamed from: a */
        public void mo50374a() {
            AppMethodBeat.m2504i(99295);
            C46789gm.this.mo75435b((MapLanguageChangeListener) this);
            AppMethodBeat.m2505o(99295);
        }

        /* renamed from: a */
        public void mo50375a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
            AppMethodBeat.m2504i(99296);
            this.f14147b = list;
            this.f14148c = list2;
            C46789gm.this.f18161a.mo29344a((List) list, (List) list2);
            AppMethodBeat.m2505o(99296);
        }

        /* renamed from: b */
        public void mo50376b() {
            AppMethodBeat.m2504i(99297);
            C46789gm.this.f18161a.mo29299A();
            this.f14147b = null;
            this.f14148c = null;
            AppMethodBeat.m2505o(99297);
        }

        public void onLanguageChange(MapLanguage mapLanguage) {
            AppMethodBeat.m2504i(99298);
            if (mapLanguage != MapLanguage.LAN_CHINESE) {
                C46789gm.this.f18161a.mo29299A();
            } else if (!(this.f14147b == null || this.f14148c == null)) {
                C46789gm.this.f18161a.mo29344a(this.f14147b, this.f14148c);
                AppMethodBeat.m2505o(99298);
                return;
            }
            AppMethodBeat.m2505o(99298);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gm$d */
    class C31051d {
        /* renamed from: b */
        private final ArrayList<C24379e> f14150b;
        /* renamed from: c */
        private C24379e f14151c;

        /* synthetic */ C31051d(C46789gm c46789gm, C162641 c162641) {
            this();
        }

        private C31051d() {
            AppMethodBeat.m2504i(99299);
            this.f14150b = new ArrayList();
            AppMethodBeat.m2505o(99299);
        }

        /* renamed from: b */
        private C24379e m49912b() {
            AppMethodBeat.m2504i(99300);
            C24379e c24379e = null;
            synchronized (this.f14150b) {
                try {
                    if (this.f14150b.size() > 0) {
                        c24379e = (C24379e) this.f14150b.get(0);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99300);
                }
            }
            return c24379e;
        }

        /* renamed from: a */
        public boolean mo50380a() {
            boolean z;
            AppMethodBeat.m2504i(99301);
            synchronized (this.f14150b) {
                try {
                    z = this.f14150b == null || this.f14150b.isEmpty();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99301);
                }
            }
            return z;
        }

        /* renamed from: a */
        public synchronized C24379e mo50378a(GL10 gl10) {
            C24379e c24379e = null;
            synchronized (this) {
                AppMethodBeat.m2504i(99302);
                this.f14151c = m49912b();
                if (this.f14151c == null) {
                    AppMethodBeat.m2505o(99302);
                } else if (this.f14151c.mo40587c()) {
                    m49911a(this.f14151c);
                    AppMethodBeat.m2505o(99302);
                } else {
                    C46789gm.this.f18163c.mo58841h();
                    Rect c = this.f14151c.f4698f;
                    int d = this.f14151c.f4696d;
                    int e = this.f14151c.f4697e;
                    Rect rect = new Rect();
                    int density = (int) (SystemUtil.getDensity(C46789gm.this.f18172l) * 20.0f);
                    d = ((C46789gm.this.f18169i.width() - d) / 2) + density;
                    rect.right = d;
                    rect.left = d;
                    d = ((C46789gm.this.f18169i.height() - e) / 2) + density;
                    rect.bottom = d;
                    rect.top = d;
                    C46789gm.this.f18163c.mo58819b(c, rect);
                    c24379e = this.f14151c;
                    AppMethodBeat.m2505o(99302);
                }
            }
            return c24379e;
        }

        /* renamed from: a */
        public synchronized void mo50379a(GL10 gl10, C16263gj c16263gj, C24374fw c24374fw) {
            AppMethodBeat.m2504i(99303);
            if (C46789gm.this.f18161a == null) {
                AppMethodBeat.m2505o(99303);
            } else {
                C41717j f = this.f14151c.f4695c;
                if (f != null) {
                    if (f instanceof C8886a) {
                        ((C8886a) f).mo20128a(c16263gj, c24374fw);
                    }
                    f.mo20132b(c16263gj, c24374fw);
                }
                c16263gj.mo29414a();
                AppMethodBeat.m2505o(99303);
            }
        }

        /* renamed from: b */
        public synchronized void mo50381b(GL10 gl10, C16263gj c16263gj, C24374fw c24374fw) {
            AppMethodBeat.m2504i(99304);
            if (!(this.f14151c == null || this.f14151c.mo40587c())) {
                int d = this.f14151c.f4696d;
                int e = this.f14151c.f4697e;
                C41057gw g = this.f14151c.f4694b;
                C41717j f = this.f14151c.f4695c;
                Bitmap a = m49910a(gl10, d, e);
                if (!(g == null || this.f14151c.mo40585a())) {
                    g.mo65149a(a, f);
                }
                m49911a(this.f14151c);
            }
            AppMethodBeat.m2505o(99304);
        }

        /* renamed from: a */
        private void m49911a(C24379e c24379e) {
            AppMethodBeat.m2504i(99305);
            if (c24379e == null || c24379e.mo40585a()) {
                AppMethodBeat.m2505o(99305);
                return;
            }
            c24379e.mo40586b();
            synchronized (this.f14150b) {
                try {
                    this.f14150b.remove(c24379e);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99305);
                }
            }
            C46789gm.this.f18163c.mo58843i();
        }

        /* renamed from: a */
        private Bitmap m49910a(GL10 gl10, int i, int i2) {
            Bitmap createBitmap;
            AppMethodBeat.m2504i(99306);
            int i3 = i * i2;
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            gl10.glReadPixels((C46789gm.this.f18169i.width() - i) / 2, (C46789gm.this.f18169i.height() - i2) / 2, i, i2, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, wrap);
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
            AppMethodBeat.m2505o(99306);
            return createBitmap;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gm$b */
    class C44515b {
        /* renamed from: b */
        private List<MapLanguageChangeListener> f17421b = new CopyOnWriteArrayList();

        public C44515b() {
            AppMethodBeat.m2504i(99290);
            AppMethodBeat.m2505o(99290);
        }

        /* renamed from: a */
        public MapLanguage mo70886a() {
            AppMethodBeat.m2504i(99291);
            MapLanguage mapLanguage;
            if (C46789gm.this.f18161a == null) {
                mapLanguage = MapLanguage.LAN_CHINESE;
                AppMethodBeat.m2505o(99291);
                return mapLanguage;
            } else if (C46789gm.this.f18161a.mo29300B() == 1) {
                mapLanguage = MapLanguage.LAN_ENGLISH;
                AppMethodBeat.m2505o(99291);
                return mapLanguage;
            } else {
                mapLanguage = MapLanguage.LAN_CHINESE;
                AppMethodBeat.m2505o(99291);
                return mapLanguage;
            }
        }

        /* renamed from: a */
        public void mo70887a(MapLanguageChangeListener mapLanguageChangeListener) {
            AppMethodBeat.m2504i(99292);
            if (mapLanguageChangeListener == null) {
                AppMethodBeat.m2505o(99292);
                return;
            }
            synchronized (this.f17421b) {
                try {
                    if (!this.f17421b.contains(mapLanguageChangeListener)) {
                        this.f17421b.add(mapLanguageChangeListener);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99292);
                }
            }
        }

        /* renamed from: b */
        public void mo70888b(MapLanguageChangeListener mapLanguageChangeListener) {
            AppMethodBeat.m2504i(99293);
            if (mapLanguageChangeListener == null) {
                AppMethodBeat.m2505o(99293);
                return;
            }
            synchronized (this.f17421b) {
                try {
                    if (this.f17421b.contains(mapLanguageChangeListener)) {
                        this.f17421b.remove(mapLanguageChangeListener);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(99293);
                }
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gm$a */
    public interface C46788a {
        /* renamed from: a */
        void mo12454a(GL10 gl10);
    }

    /* renamed from: i */
    public C16238gh mo75454i() {
        return this.f18161a;
    }

    public C46789gm(Context context, C41052ge c41052ge) {
        AppMethodBeat.m2504i(99307);
        this.f18172l = context;
        this.f18167g = new WeakReference(c41052ge);
        this.f18161a = new C16238gh(context, this);
        this.f18175o = new C24382gs(this);
        this.f18169i = new Rect();
        this.f18165e = new C41053gl(this);
        this.f18168h = new C16230fp(this.f18175o, this);
        this.f18163c = new C36894gk(this);
        this.f18161a.mo29338a(this.f18163c);
        this.f18174n = new C31051d(this, null);
        this.f18176p = new LinkedBlockingQueue();
        AppMethodBeat.m2505o(99307);
    }

    /* renamed from: a */
    public boolean mo75431a(Context context, C45132a c45132a, C24386hf c24386hf) {
        AppMethodBeat.m2504i(99308);
        this.f18178r = c45132a;
        if (this.f18178r.mo72951d() != null) {
            C1015d.f1210a = this.f18178r.mo72951d().mo52870a();
        }
        C1015d.m2291c("initEngine");
        C36516gx a = c45132a.mo72948a();
        this.f18177q = a;
        this.f18161a.mo29339a(c45132a.mo72949b());
        this.f18162b = new C17851b(100);
        this.f18182v = c45132a.mo72950c();
        this.f18173m = new C36515gv(context, this, a, this.f18182v);
        String c = a.mo57747c();
        String a2 = a.mo57745a();
        String b = a.mo57746b();
        try {
            this.f18173m.mo57739a();
            boolean a3 = this.f18161a.mo29348a(context, this.f18173m, c, a2, b, 2.0f);
            this.f18173m.mo57742b();
            this.f18166f = new C16263gj(this, this.f18162b, this.f18161a);
            if (this.f18164d == null) {
                this.f18164d = new C44516ha(this, c24386hf);
            }
            if (this.f18186z == null) {
                this.f18186z = new C24376ga(this, this.f18178r.mo72949b());
            }
            this.f18161a.mo29401n();
            this.f18161a.mo29381e(true);
            this.f18161a.mo29371d(20);
            this.f18161a.mo29378e(3);
            m88827l(false);
            this.f18163c.mo58805a((C31043fu) this);
            AppMethodBeat.m2505o(99308);
            return a3;
        } catch (Throwable th) {
            this.f18173m.mo57742b();
            AppMethodBeat.m2505o(99308);
        }
    }

    /* renamed from: j */
    public boolean mo75457j() {
        AppMethodBeat.m2504i(99309);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99309);
            return false;
        }
        boolean b = this.f18161a.mo29360b();
        AppMethodBeat.m2505o(99309);
        return b;
    }

    /* renamed from: k */
    public Context mo75458k() {
        return this.f18172l;
    }

    /* renamed from: l */
    public void mo75460l() {
        AppMethodBeat.m2504i(99310);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99310);
            return;
        }
        this.f18179s = true;
        this.f18150B = true;
        if (this.f18181u) {
            this.f18163c.mo58828c();
            this.f18181u = false;
        } else {
            this.f18163c.mo58833d();
        }
        if (!(this.f18167g == null || this.f18167g.get() == null)) {
            ((C41052ge) this.f18167g.get()).mo12502a_();
        }
        if (this.f18170j) {
            this.f18161a.mo29395i();
        }
        if (this.f18171k && this.f18164d != null) {
            this.f18164d.mo70891d();
        }
        if (this.f18186z != null) {
            this.f18186z.mo40580c();
        }
        AppMethodBeat.m2505o(99310);
    }

    /* renamed from: m */
    public void mo75461m() {
        AppMethodBeat.m2504i(99311);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99311);
            return;
        }
        this.f18179s = false;
        this.f18150B = false;
        if (this.f18186z != null) {
            this.f18186z.mo40581d();
        }
        this.f18163c.mo58835e();
        this.f18161a.mo29397j();
        if (this.f18171k && this.f18164d != null) {
            this.f18164d.mo70890c();
        }
        AppMethodBeat.m2505o(99311);
    }

    /* renamed from: n */
    public void mo75462n() {
        AppMethodBeat.m2504i(99312);
        this.f18163c.mo58823b((C31043fu) this);
        if (this.f18185y != null) {
            this.f18185y.mo50374a();
        }
        this.f18163c.mo58837f();
        this.f18181u = true;
        if (this.f18186z != null) {
            this.f18186z.mo40582e();
        }
        if (this.f18164d != null) {
            this.f18164d.mo70893f();
        }
        if (this.f18161a != null) {
            this.f18161a.mo29317a();
        }
        this.f18172l = null;
        AppMethodBeat.m2505o(99312);
    }

    /* renamed from: a */
    public void mo75423a(C46788a c46788a) {
        AppMethodBeat.m2504i(99313);
        try {
            this.f18176p.put(c46788a);
            AppMethodBeat.m2505o(99313);
        } catch (InterruptedException e) {
            AppMethodBeat.m2505o(99313);
        }
    }

    /* renamed from: a */
    public C36894gk mo12440a() {
        return this.f18163c;
    }

    /* renamed from: b */
    public WeakReference<C41052ge> mo12441b() {
        return this.f18167g;
    }

    /* renamed from: e */
    public C24382gs mo12444e() {
        return this.f18175o;
    }

    /* renamed from: c */
    public C41053gl mo12442c() {
        return this.f18165e;
    }

    /* renamed from: f */
    public C16238gh mo12445f() {
        return this.f18161a;
    }

    /* renamed from: d */
    public C24374fw mo12443d() {
        return this.f18168h;
    }

    /* renamed from: g */
    public Rect mo12446g() {
        return this.f18169i;
    }

    /* renamed from: h */
    public float mo12447h() {
        AppMethodBeat.m2504i(99314);
        if (this.f18172l == null) {
            AppMethodBeat.m2505o(99314);
            return 1.0f;
        }
        float density = SystemUtil.getDensity(this.f18172l);
        AppMethodBeat.m2505o(99314);
        return density;
    }

    /* renamed from: o */
    public C36515gv mo75463o() {
        return this.f18173m;
    }

    /* renamed from: a */
    public void mo75428a(GL10 gl10) {
        AppMethodBeat.m2504i(99315);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99315);
            return;
        }
        if (this.f18162b != null) {
            this.f18162b.mo33213a();
        }
        AppMethodBeat.m2505o(99315);
    }

    /* renamed from: a */
    public void mo75412a(int i, int i2) {
        AppMethodBeat.m2504i(99316);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99316);
            return;
        }
        this.f18179s = true;
        this.f18169i.set(0, 0, i, i2);
        m88821a(0, 0, i, i2, false);
        this.f18163c.mo58858v();
        AppMethodBeat.m2505o(99316);
    }

    /* renamed from: a */
    public void mo75415a(Rect rect) {
        AppMethodBeat.m2504i(99317);
        if (this.f18169i == null || rect == null) {
            AppMethodBeat.m2505o(99317);
            return;
        }
        this.f18154F = rect;
        int width = this.f18169i.width();
        int height = this.f18169i.height();
        m88821a(rect.left, rect.bottom, (width - rect.right) - rect.left, (height - rect.bottom) - rect.top, true);
        AppMethodBeat.m2505o(99317);
    }

    /* renamed from: a */
    private void m88821a(int i, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.m2504i(99318);
        this.f18161a.mo29325a(i, i2, i3, i4);
        this.f18152D = i3;
        this.f18153E = i4;
        if (z) {
            mo75410a(this.f18155G, this.f18156H, this.f18157I);
        }
        AppMethodBeat.m2505o(99318);
    }

    /* renamed from: p */
    public Rect mo75464p() {
        return this.f18154F;
    }

    /* renamed from: a */
    public void mo75410a(float f, float f2, boolean z) {
        AppMethodBeat.m2504i(99319);
        this.f18155G = f;
        this.f18156H = f2;
        double d = (double) f;
        double d2 = (double) f2;
        if (this.f18169i != null) {
            if (this.f18153E > 0) {
                d2 = 0.5d - (((0.5d - d2) * ((double) this.f18169i.height())) / ((double) this.f18153E));
            }
            if (this.f18152D > 0) {
                d = 0.5d - (((0.5d - d) * ((double) this.f18169i.width())) / ((double) this.f18152D));
            }
        }
        this.f18161a.mo29352b((float) d, (float) d2, z);
        AppMethodBeat.m2505o(99319);
    }

    /* renamed from: b */
    public void mo75434b(int i, int i2) {
        AppMethodBeat.m2504i(99320);
        if (this.f18169i != null) {
            this.f18169i.set(0, 0, i, i2);
        }
        AppMethodBeat.m2505o(99320);
    }

    /* renamed from: c */
    private void m88824c(GL10 gl10) {
        AppMethodBeat.m2504i(99321);
        if (this.f18176p.size() == 0) {
            AppMethodBeat.m2505o(99321);
            return;
        }
        Object obj = 1;
        while (obj != null) {
            C46788a c46788a = (C46788a) this.f18176p.poll();
            if (c46788a != null) {
                try {
                    c46788a.mo12454a(gl10);
                } catch (Exception e) {
                }
            } else {
                obj = null;
            }
        }
        AppMethodBeat.m2505o(99321);
    }

    /* renamed from: b */
    public boolean mo75439b(GL10 gl10) {
        AppMethodBeat.m2504i(99322);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99322);
            return false;
        }
        boolean z;
        synchronized (this.f18161a) {
            try {
                this.f18163c.mo58780C();
                m88824c(gl10);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(99322);
                }
            }
        }
        this.f18161a.mo29408u();
        if (this.f18161a.mo29409v() || this.f18179s) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C24379e a = this.f18174n.mo50378a(gl10);
            if (a == null) {
                this.f18165e.mo65144a(this.f18166f, this.f18168h);
            } else if (this.f18174n != null && this.f18161a.mo29390g()) {
                this.f18174n.mo50379a(gl10, this.f18166f, this.f18168h);
            }
            synchronized (this.f18161a) {
                try {
                    this.f18161a.mo29368c();
                    this.f18179s = false;
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(99322);
                    }
                }
            }
            if (!(this.f18174n.mo50380a() || a == null)) {
                if (a.mo40587c()) {
                    a.f4693a = 0;
                } else if (this.f18161a.mo29390g() || a.f4693a >= 100) {
                    a.f4693a = 0;
                    this.f18174n.mo50381b(gl10, this.f18166f, this.f18168h);
                } else {
                    a.f4693a = a.f4693a + 1;
                }
            }
            if (this.f18166f != null) {
                this.f18166f.mo29419c();
            }
        }
        if (this.f18166f != null) {
            this.f18166f.mo29414a();
        }
        AppMethodBeat.m2505o(99322);
        return z;
    }

    /* renamed from: q */
    public void mo75465q() {
        this.f18179s = true;
    }

    /* renamed from: r */
    public int mo75466r() {
        AppMethodBeat.m2504i(99323);
        if (this.f18161a != null) {
            int d = this.f18161a.mo29369d();
            AppMethodBeat.m2505o(99323);
            return d;
        }
        AppMethodBeat.m2505o(99323);
        return -1;
    }

    /* renamed from: s */
    public void mo75467s() {
        AppMethodBeat.m2504i(99324);
        if (this.f18161a != null) {
            this.f18161a.mo29377e();
        }
        AppMethodBeat.m2505o(99324);
    }

    /* renamed from: t */
    public void mo75468t() {
        AppMethodBeat.m2504i(99325);
        if (this.f18161a != null) {
            this.f18161a.mo29382f();
        }
        AppMethodBeat.m2505o(99325);
    }

    /* renamed from: u */
    public boolean mo75470u() {
        return this.f18171k;
    }

    /* renamed from: a */
    public void mo75429a(boolean z) {
        AppMethodBeat.m2504i(99326);
        if (this.f18164d != null) {
            this.f18171k = z;
            if (z) {
                m88818J();
                this.f18164d.mo70889b();
                AppMethodBeat.m2505o(99326);
                return;
            }
            m88819K();
            this.f18164d.mo70892e();
        }
        AppMethodBeat.m2505o(99326);
    }

    /* renamed from: a */
    public int mo75406a(Polygon2D polygon2D) {
        AppMethodBeat.m2504i(99327);
        if (this.f18161a == null || polygon2D == null) {
            AppMethodBeat.m2505o(99327);
            return -1;
        }
        polygon2D.borderWidth *= SystemUtil.getDensity(this.f18172l);
        int a = this.f18161a.mo29309a(polygon2D);
        if (this.f18180t == null) {
            this.f18180t = new C32219c();
        }
        this.f18180t.mo52908a(Integer.valueOf(a), Integer.valueOf(polygon2D.borldLineId));
        AppMethodBeat.m2505o(99327);
        return a;
    }

    /* renamed from: b */
    public void mo75436b(Polygon2D polygon2D) {
        AppMethodBeat.m2504i(99328);
        if (this.f18161a == null || polygon2D == null) {
            AppMethodBeat.m2505o(99328);
            return;
        }
        polygon2D.borderWidth *= SystemUtil.getDensity(this.f18172l);
        this.f18161a.mo29357b(polygon2D);
        AppMethodBeat.m2505o(99328);
    }

    /* renamed from: a */
    public int mo75405a(CircleInfo circleInfo) {
        AppMethodBeat.m2504i(99329);
        if (this.f18161a == null || circleInfo == null) {
            AppMethodBeat.m2505o(99329);
            return -1;
        }
        int a = this.f18161a.mo29307a(circleInfo);
        AppMethodBeat.m2505o(99329);
        return a;
    }

    /* renamed from: a */
    public void mo75414a(int i, CircleInfo circleInfo) {
        AppMethodBeat.m2504i(99330);
        if (this.f18161a == null || circleInfo == null) {
            AppMethodBeat.m2505o(99330);
            return;
        }
        this.f18161a.mo29327a(i, circleInfo);
        AppMethodBeat.m2505o(99330);
    }

    /* renamed from: a */
    public void mo75411a(int i) {
        AppMethodBeat.m2504i(99331);
        if (this.f18161a == null || i == -1) {
            AppMethodBeat.m2505o(99331);
            return;
        }
        this.f18161a.mo29322a(i);
        AppMethodBeat.m2505o(99331);
    }

    /* renamed from: a */
    public int mo75403a(int i, int i2, int i3, int i4, int i5, float f) {
        int i6 = 255;
        AppMethodBeat.m2504i(99332);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99332);
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
        if (this.f18169i != null) {
            maskLayer.width = this.f18169i.width();
            maskLayer.height = this.f18169i.height();
        }
        maskLayer.zIndex = f;
        maskLayer.layer = i5;
        i6 = this.f18161a.mo29308a(maskLayer);
        this.f18165e.mo65139a(i6, i5);
        AppMethodBeat.m2505o(99332);
        return i6;
    }

    /* renamed from: c */
    public void mo75441c(int i, int i2) {
        int i3 = 255;
        AppMethodBeat.m2504i(99333);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99333);
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
        this.f18161a.mo29354b(i, i3);
        AppMethodBeat.m2505o(99333);
    }

    /* renamed from: b */
    public void mo75433b(int i) {
        AppMethodBeat.m2504i(99334);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99334);
            return;
        }
        this.f18161a.mo29353b(i);
        AppMethodBeat.m2505o(99334);
    }

    /* renamed from: c */
    public void mo75440c(int i) {
        AppMethodBeat.m2504i(99335);
        if (!(this.f18161a == null || this.f18180t == null)) {
            int intValue;
            if (((Integer) this.f18180t.mo52907a(Integer.valueOf(i))) != null) {
                intValue = ((Integer) this.f18180t.mo52907a(Integer.valueOf(i))).intValue();
            } else {
                intValue = 0;
            }
            this.f18161a.mo29323a(i, intValue);
        }
        AppMethodBeat.m2505o(99335);
    }

    /* renamed from: a */
    public void mo75427a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        AppMethodBeat.m2504i(99336);
        if (this.f18185y == null) {
            this.f18185y = new C31050c();
        }
        this.f18185y.mo50375a(list, list2);
        AppMethodBeat.m2505o(99336);
    }

    /* renamed from: v */
    public void mo75471v() {
        AppMethodBeat.m2504i(99337);
        if (this.f18185y == null) {
            this.f18185y = new C31050c();
        }
        this.f18185y.mo50376b();
        AppMethodBeat.m2505o(99337);
    }

    /* renamed from: a */
    public List<Integer> mo75409a(Rect rect, int i) {
        AppMethodBeat.m2504i(99338);
        List a = this.f18161a.mo29316a(rect, i);
        AppMethodBeat.m2505o(99338);
        return a;
    }

    /* renamed from: a */
    public void mo75426a(List<BlockRouteCityData> list) {
        AppMethodBeat.m2504i(99339);
        this.f18161a.mo29343a((List) list);
        AppMethodBeat.m2505o(99339);
    }

    /* renamed from: b */
    public void mo75438b(boolean z) {
        AppMethodBeat.m2504i(99340);
        this.f18161a.mo29386f(z);
        AppMethodBeat.m2505o(99340);
    }

    /* renamed from: a */
    public String mo75408a(GeoPoint geoPoint) {
        String a;
        AppMethodBeat.m2504i(99341);
        if (!(this.f18178r == null || this.f18182v == null)) {
            a = this.f18182v.mo57765a(geoPoint);
            if (a != null) {
                AppMethodBeat.m2505o(99341);
                return a;
            }
        }
        if (this.f18161a == null) {
            a = "";
            AppMethodBeat.m2505o(99341);
            return a;
        }
        a = this.f18161a.mo29315a(geoPoint);
        AppMethodBeat.m2505o(99341);
        return a;
    }

    /* renamed from: a */
    public void mo75424a(String str) {
        AppMethodBeat.m2504i(99342);
        if (this.f18161a != null) {
            this.f18161a.mo29385f(str);
        }
        AppMethodBeat.m2505o(99342);
    }

    /* renamed from: c */
    public void mo75443c(boolean z) {
        AppMethodBeat.m2504i(99343);
        if (this.f18151C == z) {
            AppMethodBeat.m2505o(99343);
            return;
        }
        this.f18151C = z;
        if (this.f18161a != null) {
            this.f18161a.mo29345a(z);
        }
        AppMethodBeat.m2505o(99343);
    }

    /* renamed from: J */
    private void m88818J() {
        AppMethodBeat.m2504i(99344);
        if (this.f18161a != null) {
            this.f18161a.mo29398k();
        }
        AppMethodBeat.m2505o(99344);
    }

    /* renamed from: K */
    private void m88819K() {
        AppMethodBeat.m2504i(99345);
        if (this.f18161a != null) {
            this.f18161a.mo29399l();
        }
        AppMethodBeat.m2505o(99345);
    }

    /* renamed from: w */
    public void mo75472w() {
        AppMethodBeat.m2504i(99346);
        this.f18163c.mo58862z();
        this.f18179s = true;
        AppMethodBeat.m2505o(99346);
    }

    /* renamed from: d */
    public void mo75446d(boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.m2504i(99347);
        this.f18183w = z;
        if (this.f18160L) {
            if (!(z && this.f18163c.mo58856t())) {
                z2 = false;
            }
            m88827l(z2);
            AppMethodBeat.m2505o(99347);
            return;
        }
        if (z || this.f18163c.mo58856t()) {
            z3 = true;
        }
        m88827l(z3);
        AppMethodBeat.m2505o(99347);
    }

    /* renamed from: e */
    public void mo75449e(boolean z) {
        this.f18160L = z;
    }

    /* renamed from: a */
    public void mo50368a(double d) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(99348);
        boolean z3 = ((double) this.f18163c.mo58852p()) > 1.0E-10d;
        if (this.f18160L) {
            if (!(this.f18183w && z3)) {
                z = false;
            }
            m88827l(z);
        } else {
            if (this.f18183w || z3) {
                z2 = true;
            }
            m88827l(z2);
        }
        if (!C41059hb.m71419a() && this.f18163c.mo58856t()) {
            this.f18161a.mo29401n();
        }
        AppMethodBeat.m2505o(99348);
    }

    /* renamed from: l */
    private void m88827l(boolean z) {
        AppMethodBeat.m2504i(99349);
        if (this.f18161a != null) {
            this.f18161a.mo29359b(z);
        }
        AppMethodBeat.m2505o(99349);
    }

    /* renamed from: f */
    public void mo75451f(boolean z) {
        AppMethodBeat.m2504i(99350);
        if (this.f18161a != null) {
            this.f18161a.mo29376d(z);
        }
        AppMethodBeat.m2505o(99350);
    }

    /* renamed from: d */
    public void mo75444d(int i) {
        AppMethodBeat.m2504i(99351);
        if (this.f18161a != null) {
            this.f18161a.mo29362c(i);
        }
        AppMethodBeat.m2505o(99351);
    }

    /* renamed from: x */
    public String[] mo75473x() {
        AppMethodBeat.m2504i(99352);
        if (this.f18161a != null) {
            String[] p = this.f18161a.mo29403p();
            AppMethodBeat.m2505o(99352);
            return p;
        }
        AppMethodBeat.m2505o(99352);
        return null;
    }

    /* renamed from: b */
    public String mo75432b(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99353);
        if (this.f18161a != null) {
            String c = this.f18161a.mo29361c(geoPoint);
            AppMethodBeat.m2505o(99353);
            return c;
        }
        AppMethodBeat.m2505o(99353);
        return null;
    }

    /* renamed from: a */
    public void mo75430a(String[] strArr) {
        AppMethodBeat.m2504i(99354);
        if (this.f18161a != null) {
            this.f18161a.mo29347a(strArr);
        }
        AppMethodBeat.m2505o(99354);
    }

    /* renamed from: a */
    public void mo75419a(C25721e c25721e) {
        AppMethodBeat.m2504i(99355);
        if (this.f18161a != null) {
            this.f18161a.mo29335a(c25721e);
        }
        AppMethodBeat.m2505o(99355);
    }

    /* renamed from: a */
    public int mo75404a(int i, boolean z) {
        AppMethodBeat.m2504i(99356);
        if (this.f18161a != null) {
            int d = this.f18161a.mo29370d(i, z);
            AppMethodBeat.m2505o(99356);
            return d;
        }
        AppMethodBeat.m2505o(99356);
        return -1;
    }

    /* renamed from: a */
    public void mo75413a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(99357);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99357);
            return;
        }
        this.f18161a.mo29324a(i, i2, i3);
        AppMethodBeat.m2505o(99357);
    }

    /* renamed from: e */
    public void mo75447e(int i) {
        AppMethodBeat.m2504i(99358);
        if (this.f18161a != null) {
            this.f18161a.mo29383f(i);
            this.f18179s = true;
        }
        AppMethodBeat.m2505o(99358);
    }

    /* renamed from: f */
    public void mo75450f(int i) {
        AppMethodBeat.m2504i(99359);
        if (this.f18161a != null) {
            this.f18161a.mo29387g(i);
        }
        AppMethodBeat.m2505o(99359);
    }

    /* renamed from: a */
    public void mo75418a(C25720d c25720d) {
        AppMethodBeat.m2504i(99360);
        if (this.f18161a != null) {
            this.f18161a.mo29334a(c25720d);
        }
        AppMethodBeat.m2505o(99360);
    }

    /* renamed from: a */
    public void mo75420a(C32210j c32210j) {
        AppMethodBeat.m2504i(99361);
        if (this.f18161a != null) {
            this.f18161a.mo29336a(c32210j);
        }
        AppMethodBeat.m2505o(99361);
    }

    /* renamed from: a */
    public void mo75416a(C32211b c32211b) {
        AppMethodBeat.m2504i(99362);
        if (this.f18161a != null) {
            this.f18161a.mo29332a(c32211b);
        }
        AppMethodBeat.m2505o(99362);
    }

    /* renamed from: a */
    public void mo75417a(C32209c c32209c) {
        AppMethodBeat.m2504i(99363);
        if (this.f18161a != null) {
            this.f18161a.mo29333a(c32209c);
        }
        AppMethodBeat.m2505o(99363);
    }

    /* renamed from: a */
    public void mo75421a(C32212k c32212k) {
        AppMethodBeat.m2504i(99364);
        if (this.f18161a != null) {
            this.f18161a.mo29337a(c32212k);
        }
        AppMethodBeat.m2505o(99364);
    }

    /* renamed from: d */
    public void mo75445d(int i, int i2) {
        AppMethodBeat.m2504i(99365);
        if (this.f18161a != null) {
            this.f18161a.mo29372d(i, i2);
        }
        AppMethodBeat.m2505o(99365);
    }

    /* renamed from: g */
    public void mo75452g(boolean z) {
        AppMethodBeat.m2504i(99366);
        this.f18163c.mo58812a(z);
        AppMethodBeat.m2505o(99366);
    }

    /* renamed from: e */
    public void mo75448e(int i, int i2) {
        AppMethodBeat.m2504i(99367);
        if (this.f18161a != null) {
            this.f18161a.mo29363c(i, i2);
        }
        AppMethodBeat.m2505o(99367);
    }

    /* renamed from: b */
    public void mo75437b(String str) {
        AppMethodBeat.m2504i(99368);
        if (this.f18161a != null) {
            this.f18161a.mo29380e(str);
        }
        AppMethodBeat.m2505o(99368);
    }

    /* renamed from: y */
    public MapLanguage mo75474y() {
        AppMethodBeat.m2504i(99369);
        if (this.f18184x == null) {
            this.f18184x = new C44515b();
        }
        MapLanguage a = this.f18184x.mo70886a();
        AppMethodBeat.m2505o(99369);
        return a;
    }

    /* renamed from: a */
    public void mo75422a(MapLanguageChangeListener mapLanguageChangeListener) {
        AppMethodBeat.m2504i(99370);
        if (this.f18184x == null) {
            this.f18184x = new C44515b();
        }
        this.f18184x.mo70887a(mapLanguageChangeListener);
        AppMethodBeat.m2505o(99370);
    }

    /* renamed from: b */
    public void mo75435b(MapLanguageChangeListener mapLanguageChangeListener) {
        AppMethodBeat.m2504i(99371);
        if (this.f18184x == null) {
            this.f18184x = new C44515b();
        }
        this.f18184x.mo70888b(mapLanguageChangeListener);
        AppMethodBeat.m2505o(99371);
    }

    /* renamed from: a */
    public TappedElement mo75407a(float f, float f2) {
        AppMethodBeat.m2504i(99372);
        if (this.f18161a != null) {
            TappedElement a = this.f18161a.mo29314a(f, f2);
            AppMethodBeat.m2505o(99372);
            return a;
        }
        AppMethodBeat.m2505o(99372);
        return null;
    }

    public String toString() {
        AppMethodBeat.m2504i(99373);
        String c24382gs;
        if (this.f18175o != null) {
            c24382gs = this.f18175o.toString();
            AppMethodBeat.m2505o(99373);
            return c24382gs;
        }
        c24382gs = "";
        AppMethodBeat.m2505o(99373);
        return c24382gs;
    }

    /* renamed from: z */
    public C16263gj mo75475z() {
        return this.f18166f;
    }

    /* renamed from: c */
    public void mo75442c(String str) {
        this.f18149A = str;
    }

    /* renamed from: A */
    public String mo75394A() {
        return this.f18149A;
    }

    /* renamed from: h */
    public void mo75453h(boolean z) {
        AppMethodBeat.m2504i(99374);
        if (this.f18178r == null) {
            AppMethodBeat.m2505o(99374);
            return;
        }
        if (this.f18186z == null) {
            this.f18186z = new C24376ga(this, this.f18178r.mo72949b());
        }
        this.f18186z.mo40577a(z);
        AppMethodBeat.m2505o(99374);
    }

    /* renamed from: B */
    public boolean mo75395B() {
        AppMethodBeat.m2504i(99375);
        if (this.f18186z == null) {
            AppMethodBeat.m2505o(99375);
            return false;
        }
        boolean a = this.f18186z.mo40578a();
        AppMethodBeat.m2505o(99375);
        return a;
    }

    /* renamed from: C */
    public void mo75396C() {
        AppMethodBeat.m2504i(99376);
        if (this.f18186z == null || !this.f18186z.mo40578a()) {
            AppMethodBeat.m2505o(99376);
            return;
        }
        this.f18186z.mo40579b();
        AppMethodBeat.m2505o(99376);
    }

    /* renamed from: D */
    public C36516gx mo75397D() {
        return this.f18177q;
    }

    /* renamed from: i */
    public void mo75455i(boolean z) {
        AppMethodBeat.m2504i(99377);
        if (this.f18161a != null) {
            this.f18161a.mo29389g(z);
        }
        AppMethodBeat.m2505o(99377);
    }

    /* renamed from: j */
    public void mo75456j(boolean z) {
        AppMethodBeat.m2504i(99378);
        if (this.f18161a != null) {
            this.f18161a.mo29393h(z);
        }
        AppMethodBeat.m2505o(99378);
    }

    /* renamed from: k */
    public void mo75459k(boolean z) {
        AppMethodBeat.m2504i(99379);
        if (this.f18163c != null) {
            this.f18163c.mo58832c(z);
        }
        AppMethodBeat.m2505o(99379);
    }

    /* renamed from: E */
    public String mo75398E() {
        AppMethodBeat.m2504i(99380);
        String str = null;
        if (this.f18161a != null) {
            str = this.f18161a.mo29301C();
        }
        AppMethodBeat.m2505o(99380);
        return str;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: F */
    public boolean mo75399F() {
        AppMethodBeat.m2504i(99381);
        if (this.f18161a != null) {
            boolean g = this.f18161a.mo29390g();
            AppMethodBeat.m2505o(99381);
            return g;
        }
        AppMethodBeat.m2505o(99381);
        return false;
    }

    /* renamed from: a */
    public void mo75425a(String str, String str2) {
        AppMethodBeat.m2504i(99382);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99382);
            return;
        }
        this.f18161a.mo29341a(str, str2);
        AppMethodBeat.m2505o(99382);
    }

    /* renamed from: G */
    public ArrayList<MapPoi> mo75400G() {
        AppMethodBeat.m2504i(99383);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99383);
            return null;
        }
        ArrayList<MapPoi> E = this.f18161a.mo29303E();
        AppMethodBeat.m2505o(99383);
        return E;
    }

    /* renamed from: H */
    public String mo75401H() {
        AppMethodBeat.m2504i(99384);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99384);
            return null;
        }
        String D = this.f18161a.mo29302D();
        AppMethodBeat.m2505o(99384);
        return D;
    }

    /* renamed from: I */
    public String mo75402I() {
        AppMethodBeat.m2504i(99385);
        if (this.f18161a == null) {
            AppMethodBeat.m2505o(99385);
            return null;
        }
        String F = this.f18161a.mo29304F();
        AppMethodBeat.m2505o(99385);
        return F;
    }
}
