package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C37423c;
import com.tencent.map.lib.element.C45135d;
import com.tencent.map.lib.element.C45135d.C25719a;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import com.tencent.map.lib.p822gl.JNI;
import com.tencent.map.lib.p822gl.JNICallback.C17849h;
import com.tencent.map.lib.p822gl.JNICallback.C25720d;
import com.tencent.map.lib.p822gl.JNICallback.C25721e;
import com.tencent.map.lib.p822gl.JNICallback.C32208a;
import com.tencent.map.lib.p822gl.JNICallback.C32209c;
import com.tencent.map.lib.p822gl.JNICallback.C32210j;
import com.tencent.map.lib.p822gl.JNICallback.C32211b;
import com.tencent.map.lib.p822gl.JNICallback.C32212k;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46789gm.C46788a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gh */
public class C16238gh implements C32208a, C25721e, C17849h, C36507fk, C44517hg {
    /* renamed from: i */
    private static boolean f3244i = true;
    /* renamed from: a */
    private JNI f3245a = new JNI();
    /* renamed from: b */
    private long f3246b;
    /* renamed from: c */
    private C36514gu f3247c;
    /* renamed from: d */
    private C44519hh f3248d = new C44519hh();
    /* renamed from: e */
    private C44517hg f3249e;
    /* renamed from: f */
    private C25721e f3250f;
    /* renamed from: g */
    private C46789gm f3251g;
    /* renamed from: h */
    private long f3252h = 0;
    /* renamed from: j */
    private int f3253j = 0;
    /* renamed from: k */
    private float f3254k = 1.0f;
    /* renamed from: l */
    private String f3255l = null;
    /* renamed from: m */
    private ReentrantReadWriteLock f3256m = new ReentrantReadWriteLock();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gh$2 */
    class C58792 implements C46788a {
        C58792() {
        }

        /* renamed from: a */
        public void mo12454a(GL10 gl10) {
            AppMethodBeat.m2504i(99027);
            if (C16238gh.this.f3246b != 0) {
                C16238gh.this.f3245a.nativeClearDownloadURLCache(C16238gh.this.f3246b);
            }
            AppMethodBeat.m2505o(99027);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gh$21 */
    class C1623421 implements C46788a {
        C1623421() {
        }

        /* renamed from: a */
        public void mo12454a(GL10 gl10) {
            AppMethodBeat.m2504i(99029);
            if (C16238gh.this.f3246b != 0) {
                C16238gh.this.f3245a.nativeZoomOut(C16238gh.this.f3246b);
            }
            AppMethodBeat.m2505o(99029);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gh$14 */
    class C1623914 implements C46788a {
        C1623914() {
        }

        /* renamed from: a */
        public void mo12454a(GL10 gl10) {
            AppMethodBeat.m2504i(99021);
            C16238gh.this.f3245a.nativeShowStreetRoad(C16238gh.this.f3246b);
            AppMethodBeat.m2505o(99021);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gh$31 */
    class C1624631 implements C46788a {
        C1624631() {
        }

        /* renamed from: a */
        public void mo12454a(GL10 gl10) {
            AppMethodBeat.m2504i(99040);
            C16238gh.this.f3245a.nativeHideTraffic(C16238gh.this.f3246b);
            AppMethodBeat.m2505o(99040);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gh$5 */
    class C162535 implements C46788a {
        C162535() {
        }

        /* renamed from: a */
        public void mo12454a(GL10 gl10) {
            AppMethodBeat.m2504i(99044);
            if (C16238gh.this.f3246b != 0) {
                C16238gh.this.f3245a.nativeHideCompass(C16238gh.this.f3246b);
            }
            AppMethodBeat.m2505o(99044);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gh$30 */
    class C1626130 implements C46788a {
        C1626130() {
        }

        /* renamed from: a */
        public void mo12454a(GL10 gl10) {
            AppMethodBeat.m2504i(99039);
            C16238gh.this.f3245a.nativeShowTraffic(C16238gh.this.f3246b);
            AppMethodBeat.m2505o(99039);
        }
    }

    public C16238gh(Context context, C46789gm c46789gm) {
        AppMethodBeat.m2504i(99049);
        this.f3248d.mo70897a((C44517hg) this);
        this.f3251g = c46789gm;
        this.f3254k = context.getResources().getDisplayMetrics().density;
        if (f3244i) {
            C44521hj.m80786a(context, JNI.LIB_NAME);
        }
        AppMethodBeat.m2505o(99049);
    }

    /* renamed from: a */
    public void mo29338a(C36514gu c36514gu) {
        this.f3247c = c36514gu;
    }

    /* renamed from: a */
    public void mo29339a(C24386hf c24386hf) {
        AppMethodBeat.m2504i(99050);
        this.f3248d.mo70896a(c24386hf);
        AppMethodBeat.m2505o(99050);
    }

    /* renamed from: a */
    public void mo29335a(C25721e c25721e) {
        this.f3250f = c25721e;
    }

    /* renamed from: a */
    public void mo29317a() {
        AppMethodBeat.m2504i(99051);
        try {
            m24775I();
            this.f3248d.mo70895a();
            if (this.f3248d != null) {
                this.f3248d.mo70897a(null);
            }
            if (this.f3246b != 0) {
                synchronized (this) {
                    this.f3245a.nativeDestroyEngine(this.f3246b);
                    this.f3246b = 0;
                }
            }
            m24776J();
            AppMethodBeat.m2505o(99051);
        } catch (Throwable th) {
            m24776J();
            AppMethodBeat.m2505o(99051);
        }
    }

    /* renamed from: a */
    public boolean mo29348a(Context context, C36515gv c36515gv, String str, String str2, String str3, float f) {
        AppMethodBeat.m2504i(99052);
        boolean a = C36512gn.m60419a();
        int[] iArr = new int[1];
        try {
            m24775I();
            this.f3246b = this.f3245a.nativeInitEngine(str, str2, str3, SystemUtil.getDensity(context), 256, SystemUtil.getDensity(context), iArr, a, MapLanguage.LAN_CHINESE.ordinal());
            if (iArr[0] != 0) {
                C1015d.m2288a("init engine fail:" + iArr[0]);
                this.f3246b = 0;
                m24776J();
                AppMethodBeat.m2505o(99052);
                return false;
            }
            m24776J();
            try {
                m24773G();
                if (this.f3246b != 0) {
                    this.f3245a.initCallback(c36515gv, this, this, this, this.f3251g.mo12440a(), this, this.f3246b);
                    this.f3245a.nativeSetTrafficColor(this.f3246b, -14803236, -15611905, -11088785, -16777063);
                }
                m24774H();
                AppMethodBeat.m2505o(99052);
                return true;
            } catch (Throwable th) {
                m24774H();
                AppMethodBeat.m2505o(99052);
            }
        } catch (Throwable th2) {
            m24776J();
            AppMethodBeat.m2505o(99052);
        }
    }

    /* renamed from: b */
    public boolean mo29360b() {
        AppMethodBeat.m2504i(99053);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99053);
                return false;
            }
            boolean nativeGenerateTextures = this.f3245a.nativeGenerateTextures(this.f3246b);
            return nativeGenerateTextures;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99053);
        }
    }

    /* renamed from: c */
    public boolean mo29368c() {
        AppMethodBeat.m2504i(99054);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99054);
                return false;
            }
            this.f3245a.nativeDrawFrame(this.f3246b);
            m24774H();
            AppMethodBeat.m2505o(99054);
            return true;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99054);
        }
    }

    /* renamed from: d */
    public int mo29369d() {
        AppMethodBeat.m2504i(99055);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99055);
                return -1;
            }
            int nativeClearCache = this.f3245a.nativeClearCache(this.f3246b);
            return nativeClearCache;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99055);
        }
    }

    /* renamed from: e */
    public void mo29377e() {
        AppMethodBeat.m2504i(99056);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3245a.nativeLockEngine(this.f3246b);
                m24774H();
                AppMethodBeat.m2505o(99056);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99056);
        }
    }

    /* renamed from: f */
    public void mo29382f() {
        AppMethodBeat.m2504i(99057);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3245a.nativeUnlockEngine(this.f3246b);
                m24774H();
                AppMethodBeat.m2505o(99057);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99057);
        }
    }

    /* renamed from: g */
    public boolean mo29390g() {
        AppMethodBeat.m2504i(99058);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99058);
                return true;
            }
            boolean nativeIsMapDrawFinished;
            synchronized (this) {
                nativeIsMapDrawFinished = this.f3245a.nativeIsMapDrawFinished(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99058);
            return nativeIsMapDrawFinished;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99058);
        }
    }

    /* renamed from: a */
    public int mo29311a(byte[] bArr, int i, boolean z, boolean z2) {
        AppMethodBeat.m2504i(99059);
        try {
            m24773G();
            synchronized (this) {
                if (this.f3246b == 0) {
                    m24774H();
                    AppMethodBeat.m2505o(99059);
                    return -1;
                }
                int nativeRefreshTrafficData = this.f3245a.nativeRefreshTrafficData(this.f3246b, bArr, i, z, z2);
                m24774H();
                AppMethodBeat.m2505o(99059);
                return nativeRefreshTrafficData;
            }
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99059);
        }
    }

    /* renamed from: a */
    public void mo29326a(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(99060);
        try {
            m24773G();
            if (this.f3246b != 0) {
                synchronized (this) {
                    this.f3245a.nativeCheckTrafficBlockCache(this.f3246b, i, i2, i3, i4, i5);
                }
            }
            m24774H();
            AppMethodBeat.m2505o(99060);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99060);
        }
    }

    /* renamed from: h */
    public TrafficRequestItem[] mo29394h() {
        TrafficRequestItem[] trafficRequestItemArr = null;
        AppMethodBeat.m2504i(99061);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99061);
            } else {
                synchronized (this) {
                    int[] nativeFetchLackedTrafficBlocks = this.f3245a.nativeFetchLackedTrafficBlocks(this.f3246b);
                    if (nativeFetchLackedTrafficBlocks == null || nativeFetchLackedTrafficBlocks.length == 0) {
                        m24774H();
                        AppMethodBeat.m2505o(99061);
                    } else {
                        trafficRequestItemArr = new TrafficRequestItem[(nativeFetchLackedTrafficBlocks.length / 7)];
                        for (int i = 0; i < nativeFetchLackedTrafficBlocks.length / 7; i++) {
                            trafficRequestItemArr[i] = new TrafficRequestItem();
                            trafficRequestItemArr[i].level = nativeFetchLackedTrafficBlocks[i * 7];
                            trafficRequestItemArr[i].blockNo = nativeFetchLackedTrafficBlocks[(i * 7) + 1];
                            trafficRequestItemArr[i].left = nativeFetchLackedTrafficBlocks[(i * 7) + 2];
                            trafficRequestItemArr[i].top = nativeFetchLackedTrafficBlocks[(i * 7) + 3];
                            trafficRequestItemArr[i].right = nativeFetchLackedTrafficBlocks[(i * 7) + 4];
                            trafficRequestItemArr[i].bottom = nativeFetchLackedTrafficBlocks[(i * 7) + 5];
                            trafficRequestItemArr[i].timestamp = nativeFetchLackedTrafficBlocks[(i * 7) + 6];
                        }
                        m24774H();
                        AppMethodBeat.m2505o(99061);
                    }
                }
            }
            return trafficRequestItemArr;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99061);
        }
    }

    /* renamed from: a */
    public int mo29309a(Polygon2D polygon2D) {
        AppMethodBeat.m2504i(99062);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99062);
                return 0;
            }
            int nativeAddPolygon;
            synchronized (this) {
                nativeAddPolygon = this.f3245a.nativeAddPolygon(this.f3246b, polygon2D);
            }
            m24774H();
            AppMethodBeat.m2505o(99062);
            return nativeAddPolygon;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99062);
        }
    }

    /* renamed from: a */
    public int mo29307a(CircleInfo circleInfo) {
        AppMethodBeat.m2504i(99063);
        if (this.f3246b == 0) {
            AppMethodBeat.m2505o(99063);
            return 0;
        }
        int nativeAddCircle;
        synchronized (this) {
            try {
                nativeAddCircle = this.f3245a.nativeAddCircle(this.f3246b, circleInfo);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99063);
            }
        }
        return nativeAddCircle;
    }

    /* renamed from: a */
    public void mo29327a(int i, CircleInfo circleInfo) {
        AppMethodBeat.m2504i(99064);
        if (this.f3246b == 0) {
            AppMethodBeat.m2505o(99064);
            return;
        }
        synchronized (this) {
            try {
                this.f3245a.nativeUpdateCircle(this.f3246b, i, circleInfo);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99064);
            }
        }
    }

    /* renamed from: a */
    public void mo29322a(final int i) {
        AppMethodBeat.m2504i(99065);
        if (this.f3246b == 0 || i < 0 || this.f3251g == null) {
            AppMethodBeat.m2505o(99065);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99016);
                C16238gh.this.f3245a.nativeDeleteCircle(C16238gh.this.f3246b, i);
                AppMethodBeat.m2505o(99016);
            }
        });
        AppMethodBeat.m2505o(99065);
    }

    /* renamed from: b */
    public void mo29357b(Polygon2D polygon2D) {
        AppMethodBeat.m2504i(99066);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99066);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeUpdatePolygon(this.f3246b, polygon2D.polygonId, polygon2D.borldLineId, polygon2D);
            }
            m24774H();
            AppMethodBeat.m2505o(99066);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99066);
        }
    }

    /* renamed from: a */
    public void mo29323a(final int i, final int i2) {
        AppMethodBeat.m2504i(99067);
        try {
            m24773G();
            if (this.f3246b == 0 || i < 0 || this.f3251g == null) {
                m24774H();
                AppMethodBeat.m2505o(99067);
                return;
            }
            this.f3251g.mo75423a(new C46788a() {
                /* renamed from: a */
                public void mo12454a(GL10 gl10) {
                    AppMethodBeat.m2504i(99048);
                    C16238gh.this.f3245a.nativeDeletePolygon(C16238gh.this.f3246b, i, i2);
                    AppMethodBeat.m2505o(99048);
                }
            });
            m24774H();
            AppMethodBeat.m2505o(99067);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99067);
        }
    }

    /* renamed from: a */
    public int mo29308a(MaskLayer maskLayer) {
        AppMethodBeat.m2504i(99068);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99068);
                return 0;
            }
            int nativeAddMaskLayer = this.f3245a.nativeAddMaskLayer(this.f3246b, maskLayer);
            return nativeAddMaskLayer;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99068);
        }
    }

    /* renamed from: b */
    public void mo29354b(int i, int i2) {
        AppMethodBeat.m2504i(99069);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3245a.nativeUpdateMaskLayer(this.f3246b, i, i2);
                m24774H();
                AppMethodBeat.m2505o(99069);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99069);
        }
    }

    /* renamed from: b */
    public void mo29353b(int i) {
        AppMethodBeat.m2504i(99070);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3245a.nativeRemoveMaskLayer(this.f3246b, i);
                m24774H();
                AppMethodBeat.m2505o(99070);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99070);
        }
    }

    /* renamed from: a */
    public GeoPoint mo29313a(byte[] bArr, float f, float f2) {
        AppMethodBeat.m2504i(99071);
        try {
            GeoPoint geoPoint;
            m24773G();
            if (this.f3246b == 0) {
                geoPoint = new GeoPoint();
                m24774H();
                AppMethodBeat.m2505o(99071);
            } else {
                synchronized (this) {
                    double[] dArr = new double[2];
                    this.f3245a.nativeFromScreenLocation(this.f3246b, bArr, f, f2, dArr);
                    geoPoint = new GeoPoint((int) (dArr[1] * 1000000.0d), (int) (dArr[0] * 1000000.0d));
                }
                m24774H();
                AppMethodBeat.m2505o(99071);
            }
            return geoPoint;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99071);
        }
    }

    /* renamed from: a */
    public PointF mo29312a(byte[] bArr, double d, double d2) {
        AppMethodBeat.m2504i(99072);
        try {
            PointF pointF;
            m24773G();
            if (this.f3246b == 0) {
                pointF = new PointF();
                m24774H();
                AppMethodBeat.m2505o(99072);
            } else {
                synchronized (this) {
                    float[] fArr = new float[2];
                    this.f3245a.nativeToScreenLocation(this.f3246b, bArr, d, d2, fArr);
                    pointF = new PointF(fArr[0], fArr[1]);
                }
                m24774H();
                AppMethodBeat.m2505o(99072);
            }
            return pointF;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99072);
        }
    }

    /* renamed from: i */
    public void mo29395i() {
        AppMethodBeat.m2504i(99073);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3251g.mo75423a(new C1623914());
                m24774H();
                AppMethodBeat.m2505o(99073);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99073);
        }
    }

    /* renamed from: j */
    public void mo29397j() {
        AppMethodBeat.m2504i(99074);
        try {
            m24773G();
            if (this.f3246b != 0) {
                synchronized (this) {
                    this.f3245a.nativeHideStreetRoad(this.f3246b);
                }
            }
            m24774H();
            AppMethodBeat.m2505o(99074);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99074);
        }
    }

    /* renamed from: a */
    public void mo29345a(final boolean z) {
        AppMethodBeat.m2504i(99075);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3251g.mo75423a(new C46788a() {
                    /* renamed from: a */
                    public void mo12454a(GL10 gl10) {
                        AppMethodBeat.m2504i(99030);
                        C16238gh.this.f3245a.nativeSetSatelliteEnabled(C16238gh.this.f3246b, z);
                        AppMethodBeat.m2505o(99030);
                    }
                });
                m24774H();
                AppMethodBeat.m2505o(99075);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99075);
        }
    }

    /* renamed from: k */
    public void mo29398k() {
        AppMethodBeat.m2504i(99076);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3251g.mo75423a(new C1626130());
                m24774H();
                AppMethodBeat.m2505o(99076);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99076);
        }
    }

    /* renamed from: l */
    public void mo29399l() {
        AppMethodBeat.m2504i(99077);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3251g.mo75423a(new C1624631());
                m24774H();
                AppMethodBeat.m2505o(99077);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99077);
        }
    }

    /* renamed from: a */
    public String mo29315a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99078);
        try {
            m24773G();
            String str;
            if (this.f3246b == 0) {
                str = "";
                return str;
            }
            byte[] nativeGetCityName = this.f3245a.nativeGetCityName(this.f3246b, geoPoint);
            if (nativeGetCityName != null) {
                try {
                    str = new String(nativeGetCityName, "GBK").trim();
                    m24774H();
                    AppMethodBeat.m2505o(99078);
                    return str;
                } catch (UnsupportedEncodingException e) {
                }
            }
            str = "";
            m24774H();
            AppMethodBeat.m2505o(99078);
            return str;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99078);
        }
    }

    /* renamed from: b */
    public void mo29358b(final String str) {
        AppMethodBeat.m2504i(99079);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3251g.mo75423a(new C46788a() {
                    /* renamed from: a */
                    public void mo12454a(GL10 gl10) {
                        AppMethodBeat.m2504i(99041);
                        C16238gh.this.f3245a.nativeUpdateMapResource(C16238gh.this.f3246b, str);
                        AppMethodBeat.m2505o(99041);
                    }
                });
                m24774H();
                AppMethodBeat.m2505o(99079);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99079);
        }
    }

    /* renamed from: a */
    public int mo29306a(C45135d c45135d) {
        AppMethodBeat.m2504i(99080);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99080);
                return -1;
            }
            int i;
            m24774H();
            int m = c45135d.mo72982m();
            boolean z = false;
            if (m == 3) {
                m = 0;
                z = true;
            }
            boolean z2 = false;
            int[] c = c45135d.mo72972c();
            long j = c[0];
            if (j == 33) {
                i = 2;
            } else {
                j = 20;
                if (c[0] == 20) {
                    z2 = true;
                    i = m;
                } else {
                    i = m;
                }
            }
            int[] iArr = new int[0];
            if (c45135d.mo72995z() != null) {
                iArr = new int[c45135d.mo72995z().size()];
                m = 0;
                while (true) {
                    int i2 = m;
                    if (i2 >= c45135d.mo72995z().size()) {
                        break;
                    }
                    iArr[i2] = ((Integer) c45135d.mo72995z().get(i2)).intValue();
                    m = i2 + 1;
                }
            }
            int[] iArr2 = new int[0];
            if (c45135d.mo72975f() != null) {
                iArr2 = new int[c45135d.mo72975f().length];
                for (m = 0; m < c45135d.mo72975f().length; m++) {
                    iArr2[m] = c45135d.mo72975f()[m];
                }
            }
            long j2;
            try {
                m24773G();
                j2 = this.f3246b;
                if (j2 == j) {
                    m24774H();
                    AppMethodBeat.m2505o(99080);
                    return -1;
                }
                synchronized (this) {
                    m = this.f3245a.nativeCreateLine(this.f3246b, c45135d.mo72972c(), c45135d.mo72971b(), (GeoPoint[]) c45135d.mo72964a().toArray(new GeoPoint[0]), c45135d.mo72987r(), c45135d.mo72983n(), i, z, z2, c45135d.mo72981l(), c45135d.mo72979j(), c45135d.mo72991v(), c45135d.mo72973d(), c45135d.mo72974e(), iArr2, c45135d.mo72976g(), iArr, c45135d.mo72984o(), c45135d.mo72962A());
                }
                return m;
            } catch (Throwable th) {
                j2 = th;
                m24774H();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99080);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99080);
        }
    }

    /* renamed from: a */
    public void mo29329a(int i, boolean z) {
        AppMethodBeat.m2504i(99081);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99081);
            } else if (i == -1) {
                m24774H();
                AppMethodBeat.m2505o(99081);
            } else {
                synchronized (this) {
                    this.f3245a.nativeDeleteLine(this.f3246b, (long) i, z);
                }
                m24774H();
                AppMethodBeat.m2505o(99081);
            }
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99081);
        }
    }

    /* renamed from: b */
    public void mo29356b(C45135d c45135d) {
        AppMethodBeat.m2504i(99082);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99082);
                return;
            }
            int s = c45135d.mo72988s();
            if (s == -1) {
                m24774H();
                AppMethodBeat.m2505o(99082);
                return;
            }
            synchronized (this) {
                C25719a q = c45135d.mo72986q();
                if (q == null) {
                    m24774H();
                    AppMethodBeat.m2505o(99082);
                    return;
                }
                this.f3245a.nativeSetTurnArrow(this.f3246b, (long) s, q.f5426a, q.f5427b);
                m24774H();
                AppMethodBeat.m2505o(99082);
            }
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99082);
        }
    }

    /* renamed from: c */
    public void mo29365c(C45135d c45135d) {
        AppMethodBeat.m2504i(99083);
        try {
            m24773G();
            if (this.f3246b != 0) {
                final int s = c45135d.mo72988s();
                if (s == -1) {
                    m24774H();
                    AppMethodBeat.m2505o(99083);
                    return;
                }
                final int[] y = c45135d.mo72994y();
                this.f3251g.mo75423a(new C46788a() {
                    /* renamed from: a */
                    public void mo12454a(GL10 gl10) {
                        AppMethodBeat.m2504i(99042);
                        C16238gh.this.f3245a.nativeSetTurnArrowStyle(C16238gh.this.f3246b, (long) s, y[0], y[1]);
                        AppMethodBeat.m2505o(99042);
                    }
                });
                m24774H();
                AppMethodBeat.m2505o(99083);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99083);
        }
    }

    /* renamed from: d */
    public void mo29374d(C45135d c45135d) {
        AppMethodBeat.m2504i(99084);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99084);
                return;
            }
            int s = c45135d.mo72988s();
            if (s == -1) {
                m24774H();
                AppMethodBeat.m2505o(99084);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeSetLineDrawArrow(this.f3246b, (long) s, c45135d.mo72979j());
            }
            m24774H();
            AppMethodBeat.m2505o(99084);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99084);
        }
    }

    /* renamed from: e */
    public void mo29379e(C45135d c45135d) {
        AppMethodBeat.m2504i(99085);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99085);
                return;
            }
            int s = c45135d.mo72988s();
            if (s == -1) {
                m24774H();
                AppMethodBeat.m2505o(99085);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeSetLineDirectionArrowTextureName(this.f3246b, (long) s, c45135d.mo72992w());
            }
            m24774H();
            AppMethodBeat.m2505o(99085);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99085);
        }
    }

    /* renamed from: f */
    public void mo29384f(C45135d c45135d) {
        AppMethodBeat.m2504i(99086);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99086);
                return;
            }
            int s = c45135d.mo72988s();
            if (s == -1) {
                m24774H();
                AppMethodBeat.m2505o(99086);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeSetDrawCap(this.f3246b, (long) s, c45135d.mo72980k());
            }
            m24774H();
            AppMethodBeat.m2505o(99086);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99086);
        }
    }

    /* renamed from: g */
    public void mo29388g(C45135d c45135d) {
        AppMethodBeat.m2504i(99087);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99087);
                return;
            }
            int s = c45135d.mo72988s();
            if (s == -1) {
                m24774H();
                AppMethodBeat.m2505o(99087);
                return;
            }
            synchronized (this) {
                GeoPoint h = c45135d.mo72977h();
                if (h == null) {
                    m24774H();
                    AppMethodBeat.m2505o(99087);
                    return;
                }
                this.f3245a.nativeLineInsertPoint(this.f3246b, (long) s, h, c45135d.mo72978i());
                m24774H();
                AppMethodBeat.m2505o(99087);
            }
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99087);
        }
    }

    /* renamed from: h */
    public void mo29392h(C45135d c45135d) {
        AppMethodBeat.m2504i(99088);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99088);
                return;
            }
            int s = c45135d.mo72988s();
            if (s == -1) {
                m24774H();
                AppMethodBeat.m2505o(99088);
                return;
            }
            synchronized (this) {
                GeoPoint h = c45135d.mo72977h();
                if (h == null) {
                    m24774H();
                    AppMethodBeat.m2505o(99088);
                    return;
                }
                this.f3245a.nativeLineClearPoint(this.f3246b, (long) s, h, c45135d.mo72978i());
                m24774H();
                AppMethodBeat.m2505o(99088);
            }
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99088);
        }
    }

    /* renamed from: a */
    public TappedElement mo29314a(float f, float f2) {
        TappedElement tappedElement = null;
        AppMethodBeat.m2504i(99089);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99089);
            } else {
                synchronized (this) {
                    byte[] nativeOnTap = this.f3245a.nativeOnTap(this.f3246b, f, f2);
                    if (nativeOnTap == null) {
                        m24774H();
                        AppMethodBeat.m2505o(99089);
                    } else {
                        try {
                            tappedElement = TappedElement.fromBytes(nativeOnTap);
                            m24774H();
                            AppMethodBeat.m2505o(99089);
                        } catch (Exception e) {
                            m24774H();
                            AppMethodBeat.m2505o(99089);
                        }
                    }
                }
            }
            return tappedElement;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99089);
        }
    }

    /* renamed from: b */
    public void mo29359b(boolean z) {
        AppMethodBeat.m2504i(99090);
        try {
            m24773G();
            if (0 != this.f3246b) {
                synchronized (this) {
                    this.f3245a.nativeSetBuilding3DEffect(this.f3246b, z);
                }
            }
            m24774H();
            AppMethodBeat.m2505o(99090);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99090);
        }
    }

    /* renamed from: m */
    public void mo29400m() {
        AppMethodBeat.m2504i(99091);
        if (this.f3246b != 0) {
            this.f3251g.mo75423a(new C58792());
        }
        AppMethodBeat.m2505o(99091);
    }

    /* renamed from: a */
    public void mo29342a(final String str, final byte[] bArr) {
        AppMethodBeat.m2504i(99092);
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99038);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeWriteMapDataBlock(C16238gh.this.f3246b, str, bArr);
                }
                AppMethodBeat.m2505o(99038);
            }
        });
        if (this.f3249e != null) {
            this.f3249e.mo29342a(str, bArr);
        }
        AppMethodBeat.m2505o(99092);
    }

    /* renamed from: c */
    public void mo29366c(final String str) {
        AppMethodBeat.m2504i(99093);
        this.f3253j++;
        if (this.f3253j >= 30) {
            mo29400m();
            this.f3253j = 0;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99043);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeWriteMapDataBlock(C16238gh.this.f3246b, str, null);
                }
                AppMethodBeat.m2505o(99043);
            }
        });
        if (this.f3249e != null) {
            this.f3249e.mo29366c(str);
        }
        AppMethodBeat.m2505o(99093);
    }

    /* renamed from: d */
    public void mo29375d(String str) {
        AppMethodBeat.m2504i(99094);
        this.f3248d.mo70899a(str);
        AppMethodBeat.m2505o(99094);
    }

    /* renamed from: n */
    public void mo29401n() {
        AppMethodBeat.m2504i(99095);
        if (0 == this.f3246b) {
            AppMethodBeat.m2505o(99095);
            return;
        }
        this.f3251g.mo75423a(new C162535());
        AppMethodBeat.m2505o(99095);
    }

    /* renamed from: a */
    public int mo29310a(String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2) {
        AppMethodBeat.m2504i(99096);
        int i3;
        try {
            m24773G();
            i3 = (0 > this.f3246b ? 1 : (0 == this.f3246b ? 0 : -1));
            if (i3 == 0) {
                m24774H();
            } else {
                synchronized (this) {
                    i3 = this.f3245a.nativeAddMarker(this.f3246b, str, d, d2, f, f2, f3, f4, f5, f6, z, z2, z3, z4, i, i2);
                }
                m24774H();
            }
            return i3;
        } catch (Throwable th) {
            i3 = th;
            m24774H();
        } finally {
            while (true) {
            }
            AppMethodBeat.m2505o(99096);
        }
    }

    /* renamed from: a */
    public void mo29328a(int i, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3) {
        AppMethodBeat.m2504i(99097);
        if (0 == this.f3246b) {
            AppMethodBeat.m2505o(99097);
            return;
        }
        final int i4 = i;
        final String str2 = str;
        final double d3 = d;
        final double d4 = d2;
        final float f7 = f;
        final float f8 = f2;
        final float f9 = f3;
        final float f10 = f4;
        final float f11 = f5;
        final float f12 = f6;
        final boolean z5 = z;
        final boolean z6 = z2;
        final boolean z7 = z3;
        final boolean z8 = z4;
        final int i5 = i2;
        final int i6 = i3;
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99045);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeUpdateMarkerInfo(C16238gh.this.f3246b, i4, str2, d3, d4, f7, f8, f9, f10, f11, f12, z5, z6, z7, z8, i5, i6);
                }
                AppMethodBeat.m2505o(99045);
            }
        });
        AppMethodBeat.m2505o(99097);
    }

    /* renamed from: a */
    public void mo29346a(int[] iArr, int i) {
        AppMethodBeat.m2504i(99098);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99098);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeDeleteIcons(this.f3246b, iArr, i);
            }
            m24774H();
            AppMethodBeat.m2505o(99098);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99098);
        }
    }

    /* renamed from: c */
    public void mo29367c(final boolean z) {
        AppMethodBeat.m2504i(99099);
        if (0 == this.f3246b) {
            AppMethodBeat.m2505o(99099);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99046);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetCompassVisible(C16238gh.this.f3246b, z);
                }
                AppMethodBeat.m2505o(99046);
            }
        });
        AppMethodBeat.m2505o(99099);
    }

    /* renamed from: c */
    public void mo29363c(final int i, final int i2) {
        AppMethodBeat.m2504i(99100);
        if (0 == this.f3246b) {
            AppMethodBeat.m2505o(99100);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99047);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetCompassPosition(C16238gh.this.f3246b, i, i2);
                }
                AppMethodBeat.m2505o(99047);
            }
        });
        AppMethodBeat.m2505o(99100);
    }

    /* renamed from: a */
    public double mo29305a(Rect rect, Rect rect2) {
        AppMethodBeat.m2504i(99101);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99101);
                return 1.0d;
            }
            double nativeGetTargetScale;
            synchronized (this) {
                nativeGetTargetScale = this.f3245a.nativeGetTargetScale(this.f3246b, rect, rect2);
            }
            m24774H();
            AppMethodBeat.m2505o(99101);
            return nativeGetTargetScale;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99101);
        }
    }

    /* renamed from: a */
    public void mo29330a(final Rect rect, final Rect rect2, final boolean z) {
        AppMethodBeat.m2504i(99102);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99102);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99017);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeZoomToSpan(C16238gh.this.f3246b, rect, rect2, z);
                }
                AppMethodBeat.m2505o(99017);
            }
        });
        AppMethodBeat.m2505o(99102);
    }

    /* renamed from: d */
    public void mo29376d(final boolean z) {
        AppMethodBeat.m2504i(99103);
        if (this.f3246b == 0 || this.f3251g == null) {
            AppMethodBeat.m2505o(99103);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99018);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeIndoorBuildingEnabled(C16238gh.this.f3246b, z);
                }
                AppMethodBeat.m2505o(99018);
            }
        });
        AppMethodBeat.m2505o(99103);
    }

    /* renamed from: c */
    public void mo29362c(final int i) {
        AppMethodBeat.m2504i(99104);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99104);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99019);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetIndoorFloor(C16238gh.this.f3246b, i);
                }
                AppMethodBeat.m2505o(99019);
            }
        });
        AppMethodBeat.m2505o(99104);
    }

    /* renamed from: o */
    public int mo29402o() {
        AppMethodBeat.m2504i(99105);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99105);
                return -1;
            }
            int nativeGetIndoorCurrentFloorId;
            synchronized (this) {
                nativeGetIndoorCurrentFloorId = this.f3245a.nativeGetIndoorCurrentFloorId(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99105);
            return nativeGetIndoorCurrentFloorId;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99105);
        }
    }

    /* renamed from: p */
    public String[] mo29403p() {
        AppMethodBeat.m2504i(99106);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99106);
                return null;
            }
            String[] nativeGetIndoorFloorNames;
            synchronized (this) {
                nativeGetIndoorFloorNames = this.f3245a.nativeGetIndoorFloorNames(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99106);
            return nativeGetIndoorFloorNames;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99106);
        }
    }

    /* renamed from: b */
    public C37423c mo29349b(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99107);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99107);
                return null;
            }
            C37423c c37423c;
            if (geoPoint == null) {
                geoPoint = new GeoPoint();
            }
            synchronized (this) {
                c37423c = new C37423c(this.f3245a.nativeGetActiveIndoorBuildingGUID(this.f3246b), this.f3245a.nativeGetCurIndoorName(this.f3246b, geoPoint), this.f3245a.nativeGetIndoorFloorNames(this.f3246b), this.f3245a.nativeGetIndoorCurrentFloorId(this.f3246b));
            }
            m24774H();
            AppMethodBeat.m2505o(99107);
            return c37423c;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99107);
        }
    }

    /* renamed from: c */
    public String mo29361c(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99108);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99108);
                return null;
            }
            String nativeGetCurIndoorName;
            synchronized (this) {
                nativeGetCurIndoorName = this.f3245a.nativeGetCurIndoorName(this.f3246b, geoPoint);
            }
            m24774H();
            AppMethodBeat.m2505o(99108);
            return nativeGetCurIndoorName;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99108);
        }
    }

    /* renamed from: a */
    public void mo29347a(final String[] strArr) {
        AppMethodBeat.m2504i(99109);
        if (this.f3246b == 0) {
            AppMethodBeat.m2505o(99109);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99020);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetShowIndoorBuildingWhiteList(C16238gh.this.f3246b, strArr);
                }
                AppMethodBeat.m2505o(99020);
            }
        });
        AppMethodBeat.m2505o(99109);
    }

    /* renamed from: e */
    public void mo29381e(final boolean z) {
        AppMethodBeat.m2504i(99110);
        if (0 == this.f3246b) {
            AppMethodBeat.m2505o(99110);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99022);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetCompassMarkerHidden(C16238gh.this.f3246b, z);
                }
                AppMethodBeat.m2505o(99022);
            }
        });
        AppMethodBeat.m2505o(99110);
    }

    /* renamed from: a */
    public void mo29321a(final float f, final float f2, final boolean z) {
        AppMethodBeat.m2504i(99111);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99111);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99023);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeMoveBy(C16238gh.this.f3246b, f, f2, z);
                }
                AppMethodBeat.m2505o(99023);
            }
        });
        AppMethodBeat.m2505o(99111);
    }

    /* renamed from: a */
    public void mo29331a(final GeoPoint geoPoint, final boolean z) {
        AppMethodBeat.m2504i(99112);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99112);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99024);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetCenter(C16238gh.this.f3246b, geoPoint, z);
                }
                AppMethodBeat.m2505o(99024);
            }
        });
        AppMethodBeat.m2505o(99112);
    }

    /* renamed from: d */
    public void mo29373d(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99113);
        try {
            m24773G();
            if (0 == this.f3246b || this.f3251g == null) {
                m24774H();
                AppMethodBeat.m2505o(99113);
                return;
            }
            this.f3245a.nativeSetCenter(this.f3246b, geoPoint, false);
            m24774H();
            AppMethodBeat.m2505o(99113);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99113);
        }
    }

    /* renamed from: q */
    public GeoPoint mo29404q() {
        AppMethodBeat.m2504i(99114);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99114);
                return null;
            }
            GeoPoint geoPoint;
            synchronized (this) {
                geoPoint = new GeoPoint();
                this.f3245a.nativeGetCenterMapPoint(this.f3246b, geoPoint);
            }
            m24774H();
            AppMethodBeat.m2505o(99114);
            return geoPoint;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99114);
        }
    }

    /* renamed from: a */
    public void mo29319a(final double d, final boolean z) {
        AppMethodBeat.m2504i(99115);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99115);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99025);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetScale(C16238gh.this.f3246b, d, z);
                }
                AppMethodBeat.m2505o(99025);
            }
        });
        AppMethodBeat.m2505o(99115);
    }

    /* renamed from: a */
    public void mo29318a(double d) {
        AppMethodBeat.m2504i(99116);
        try {
            m24773G();
            if (0 == this.f3246b || this.f3251g == null) {
                m24774H();
                AppMethodBeat.m2505o(99116);
                return;
            }
            this.f3245a.nativeSetScale(this.f3246b, d, false);
            m24774H();
            AppMethodBeat.m2505o(99116);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99116);
        }
    }

    /* renamed from: r */
    public float mo29405r() {
        AppMethodBeat.m2504i(99117);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99117);
                return 1.0f;
            }
            float nativeGetScale;
            synchronized (this) {
                nativeGetScale = (float) this.f3245a.nativeGetScale(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99117);
            return nativeGetScale;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99117);
        }
    }

    /* renamed from: b */
    public void mo29355b(final int i, final boolean z) {
        AppMethodBeat.m2504i(99118);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99118);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99026);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetScaleLevel(C16238gh.this.f3246b, i, z);
                }
                AppMethodBeat.m2505o(99026);
            }
        });
        AppMethodBeat.m2505o(99118);
    }

    /* renamed from: s */
    public int mo29406s() {
        AppMethodBeat.m2504i(99119);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99119);
                return 20;
            }
            int nativeGetScaleLevel;
            synchronized (this) {
                nativeGetScaleLevel = this.f3245a.nativeGetScaleLevel(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99119);
            return nativeGetScaleLevel;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99119);
        }
    }

    /* renamed from: b */
    public void mo29351b(final float f, final float f2) {
        AppMethodBeat.m2504i(99120);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99120);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99028);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeZoomIn(C16238gh.this.f3246b, f, f2);
                }
                AppMethodBeat.m2505o(99028);
            }
        });
        AppMethodBeat.m2505o(99120);
    }

    /* renamed from: t */
    public void mo29407t() {
        AppMethodBeat.m2504i(99121);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99121);
            return;
        }
        this.f3251g.mo75423a(new C1623421());
        AppMethodBeat.m2505o(99121);
    }

    /* renamed from: b */
    public void mo29352b(final float f, final float f2, final boolean z) {
        AppMethodBeat.m2504i(99122);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99122);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99031);
                if (C16238gh.this.f3246b == 0) {
                    AppMethodBeat.m2505o(99031);
                } else if (z) {
                    C16238gh.this.f3245a.nativeSetScreenCenterOffset(C16238gh.this.f3246b, f, f2, true);
                    AppMethodBeat.m2505o(99031);
                } else {
                    C24374fw d = C16238gh.this.f3251g.mo12443d();
                    DoublePoint b = d.mo29298b(C16238gh.this.mo29404q());
                    C16238gh.this.f3245a.nativeSetScreenCenterOffset(C16238gh.this.f3246b, f, f2, false);
                    DoublePoint b2 = d.mo29298b(C16238gh.this.mo29404q());
                    C16238gh.this.f3245a.nativeSetCenter(C16238gh.this.f3246b, d.mo29297a(new DoublePoint((b2.f2800x - b.f2800x) + b2.f2800x, (b2.f2801y - b.f2801y) + b2.f2801y)), false);
                    AppMethodBeat.m2505o(99031);
                }
            }
        });
        AppMethodBeat.m2505o(99122);
    }

    /* renamed from: a */
    public void mo29325a(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(99123);
        if (0 == this.f3246b || this.f3251g == null) {
            AppMethodBeat.m2505o(99123);
            return;
        }
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99032);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetViewport(C16238gh.this.f3246b, i5, i6, i7, i8);
                }
                AppMethodBeat.m2505o(99032);
            }
        });
        AppMethodBeat.m2505o(99123);
    }

    /* renamed from: u */
    public void mo29408u() {
        AppMethodBeat.m2504i(99124);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99124);
                return;
            }
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f3252h == 0) {
                    this.f3245a.nativeUpdateFrame(this.f3246b, 0.0d);
                } else {
                    this.f3245a.nativeUpdateFrame(this.f3246b, (double) (currentTimeMillis - this.f3252h));
                }
                this.f3252h = currentTimeMillis;
            }
            m24774H();
            AppMethodBeat.m2505o(99124);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99124);
        }
    }

    /* renamed from: v */
    public boolean mo29409v() {
        AppMethodBeat.m2504i(99125);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99125);
                return false;
            }
            boolean nativeNeedDispaly;
            synchronized (this) {
                nativeNeedDispaly = this.f3245a.nativeNeedDispaly(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99125);
            return nativeNeedDispaly;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99125);
        }
    }

    /* renamed from: d */
    public void mo29371d(int i) {
        AppMethodBeat.m2504i(99126);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99126);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeSetMaxScaleLevel(this.f3246b, i);
            }
            m24774H();
            AppMethodBeat.m2505o(99126);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99126);
        }
    }

    /* renamed from: e */
    public void mo29378e(int i) {
        AppMethodBeat.m2504i(99127);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99127);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeSetMinScaleLevel(this.f3246b, i);
            }
            m24774H();
            AppMethodBeat.m2505o(99127);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99127);
        }
    }

    /* renamed from: a */
    public void mo29320a(float f) {
        AppMethodBeat.m2504i(99128);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99128);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeSetRotate(this.f3246b, f, false);
            }
            m24774H();
            AppMethodBeat.m2505o(99128);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99128);
        }
    }

    /* renamed from: b */
    public void mo29350b(float f) {
        AppMethodBeat.m2504i(99129);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99129);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeSetSkew(this.f3246b, f, false);
            }
            m24774H();
            AppMethodBeat.m2505o(99129);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99129);
        }
    }

    /* renamed from: c */
    public void mo29364c(final int i, final boolean z) {
        AppMethodBeat.m2504i(99130);
        if (0 == this.f3246b) {
            AppMethodBeat.m2505o(99130);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99033);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetMapMode(C16238gh.this.f3246b, i, z);
                }
                AppMethodBeat.m2505o(99033);
            }
        });
        AppMethodBeat.m2505o(99130);
    }

    /* renamed from: w */
    public float mo29410w() {
        AppMethodBeat.m2504i(99131);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99131);
                return 0.0f;
            }
            float nativeGetSkew = this.f3245a.nativeGetSkew(this.f3246b);
            return nativeGetSkew;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99131);
        }
    }

    /* renamed from: x */
    public float mo29411x() {
        AppMethodBeat.m2504i(99132);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99132);
                return 0.0f;
            }
            float nativeGetRotate = this.f3245a.nativeGetRotate(this.f3246b);
            return nativeGetRotate;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99132);
        }
    }

    /* renamed from: y */
    public int mo29412y() {
        AppMethodBeat.m2504i(99133);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99133);
                return 1;
            }
            int nativeGetMapMode;
            synchronized (this) {
                nativeGetMapMode = this.f3245a.nativeGetMapMode(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99133);
            return nativeGetMapMode;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99133);
        }
    }

    /* renamed from: d */
    public int mo29370d(int i, boolean z) {
        AppMethodBeat.m2504i(99134);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99134);
                return -1;
            }
            int nativeAddHeatTileOverlay;
            synchronized (this) {
                nativeAddHeatTileOverlay = this.f3245a.nativeAddHeatTileOverlay(this.f3246b, i, z);
            }
            m24774H();
            AppMethodBeat.m2505o(99134);
            return nativeAddHeatTileOverlay;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99134);
        }
    }

    /* renamed from: a */
    public void mo29324a(final int i, final int i2, final int i3) {
        AppMethodBeat.m2504i(99135);
        if (this.f3246b == 0 || this.f3251g == null) {
            AppMethodBeat.m2505o(99135);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99034);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetTileOverlayDataLevelRange(C16238gh.this.f3246b, i, i2, i3);
                }
                AppMethodBeat.m2505o(99034);
            }
        });
        AppMethodBeat.m2505o(99135);
    }

    /* renamed from: f */
    public void mo29383f(final int i) {
        AppMethodBeat.m2504i(99136);
        if (this.f3246b == 0 || this.f3251g == null) {
            AppMethodBeat.m2505o(99136);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99035);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeRemoveHeatTileOverlay(C16238gh.this.f3246b, i);
                }
                AppMethodBeat.m2505o(99035);
            }
        });
        AppMethodBeat.m2505o(99136);
    }

    /* renamed from: g */
    public void mo29387g(final int i) {
        AppMethodBeat.m2504i(99137);
        if (this.f3246b == 0 || this.f3251g == null) {
            AppMethodBeat.m2505o(99137);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99036);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeReloadHeatTileOverlay(C16238gh.this.f3246b, i);
                }
                AppMethodBeat.m2505o(99036);
            }
        });
        AppMethodBeat.m2505o(99137);
    }

    /* renamed from: h */
    public void mo29391h(int i) {
        AppMethodBeat.m2504i(99138);
        if (this.f3251g != null) {
            C24382gs e = this.f3251g.mo12444e();
            if (e != null) {
                e.mo40592a();
            }
        }
        AppMethodBeat.m2505o(99138);
    }

    /* renamed from: z */
    public void mo29413z() {
        AppMethodBeat.m2504i(99139);
        if (this.f3250f != null) {
            this.f3250f.mo29413z();
        }
        AppMethodBeat.m2505o(99139);
    }

    /* renamed from: a */
    public void mo29334a(C25720d c25720d) {
        AppMethodBeat.m2504i(99140);
        this.f3245a.setHeatTileLoadCallback(c25720d);
        AppMethodBeat.m2505o(99140);
    }

    /* renamed from: a */
    public void mo29336a(C32210j c32210j) {
        AppMethodBeat.m2504i(99141);
        this.f3245a.setWorldTileLoadCallback(c32210j);
        AppMethodBeat.m2505o(99141);
    }

    /* renamed from: a */
    public void mo29332a(C32211b c32211b) {
        AppMethodBeat.m2504i(99142);
        this.f3245a.setHandDrawTileLoadCallback(c32211b);
        AppMethodBeat.m2505o(99142);
    }

    /* renamed from: a */
    public void mo29333a(C32209c c32209c) {
        AppMethodBeat.m2504i(99143);
        this.f3245a.setHandDrawTileWriteCallback(c32209c);
        AppMethodBeat.m2505o(99143);
    }

    /* renamed from: a */
    public void mo29337a(C32212k c32212k) {
        AppMethodBeat.m2504i(99144);
        this.f3245a.setTileWriteCallback(c32212k);
        AppMethodBeat.m2505o(99144);
    }

    /* renamed from: d */
    public void mo29372d(int i, int i2) {
        AppMethodBeat.m2504i(99145);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3245a.nativeBringElementAbove(this.f3246b, i, i2);
                m24774H();
                AppMethodBeat.m2505o(99145);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99145);
        }
    }

    /* renamed from: a */
    public void mo29344a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        AppMethodBeat.m2504i(99146);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99146);
                return;
            }
            synchronized (this) {
                if (list != null) {
                    if (!(list.isEmpty() || list2 == null || list2.isEmpty())) {
                        int size = list.size();
                        byte[][] bArr = new byte[size][];
                        for (int i = 0; i < size; i++) {
                            MapRouteSectionWithName mapRouteSectionWithName = (MapRouteSectionWithName) list.get(i);
                            if (mapRouteSectionWithName != null) {
                                bArr[i] = mapRouteSectionWithName.toBytes();
                            }
                        }
                        int size2 = list2.size();
                        this.f3245a.nativeAddRouteNameSegments(this.f3246b, bArr, size, (GeoPoint[]) list2.toArray(new GeoPoint[size2]), size2);
                    }
                }
            }
            m24774H();
            AppMethodBeat.m2505o(99146);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99146);
        }
    }

    /* renamed from: A */
    public void mo29299A() {
        AppMethodBeat.m2504i(99147);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99147);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeClearRouteNameSegments(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99147);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99147);
        }
    }

    /* renamed from: a */
    public List<Integer> mo29316a(Rect rect, int i) {
        List<Integer> list = null;
        AppMethodBeat.m2504i(99148);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99148);
            } else {
                synchronized (this) {
                    int[] iArr = new int[100];
                    int nativeQueryCityCodeList = this.f3245a.nativeQueryCityCodeList(this.f3246b, rect, i, iArr, 100);
                    if (nativeQueryCityCodeList > 0) {
                        list = new ArrayList(nativeQueryCityCodeList);
                        for (int i2 = 0; i2 < nativeQueryCityCodeList; i2++) {
                            list.add(Integer.valueOf(iArr[i2]));
                        }
                        m24774H();
                        AppMethodBeat.m2505o(99148);
                    } else {
                        m24774H();
                        AppMethodBeat.m2505o(99148);
                    }
                }
            }
            return list;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99148);
        }
    }

    /* renamed from: e */
    public void mo29380e(String str) {
        AppMethodBeat.m2504i(99149);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99149);
                return;
            }
            synchronized (this) {
                this.f3245a.nativeMapLoadKMLFile(this.f3246b, str);
            }
            m24774H();
            AppMethodBeat.m2505o(99149);
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99149);
        }
    }

    /* JADX WARNING: Missing block: B:13:0x0022, code skipped:
            m24774H();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(99150);
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo29343a(List<BlockRouteCityData> list) {
        AppMethodBeat.m2504i(99150);
        try {
            m24773G();
            if (0 == this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99150);
                return;
            }
            synchronized (this) {
                if (list != null) {
                    if (!list.isEmpty()) {
                        int size = list.size();
                        int[] iArr = new int[size];
                        int[] iArr2 = new int[size];
                        for (int i = 0; i < size; i++) {
                            BlockRouteCityData blockRouteCityData = (BlockRouteCityData) list.get(i);
                            if (blockRouteCityData != null) {
                                iArr[i] = blockRouteCityData.cityCode;
                                iArr2[i] = blockRouteCityData.version;
                            }
                        }
                        this.f3245a.nativeLoadBlockRouteCityList(this.f3246b, iArr, iArr2, size);
                        m24774H();
                        AppMethodBeat.m2505o(99150);
                    }
                }
            }
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99150);
        }
    }

    /* renamed from: f */
    public void mo29386f(boolean z) {
        AppMethodBeat.m2504i(99151);
        try {
            m24773G();
            if (0 != this.f3246b) {
                m24774H();
                AppMethodBeat.m2505o(99151);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99151);
        }
    }

    /* renamed from: B */
    public int mo29300B() {
        AppMethodBeat.m2504i(99152);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99152);
                return 0;
            }
            int nativeGetLanguage;
            synchronized (this) {
                nativeGetLanguage = this.f3245a.nativeGetLanguage(this.f3246b);
            }
            m24774H();
            AppMethodBeat.m2505o(99152);
            return nativeGetLanguage;
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99152);
        }
    }

    /* renamed from: i */
    public void mo29396i(C45135d c45135d) {
        AppMethodBeat.m2504i(99153);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99153);
                return;
            }
            int s = c45135d.mo72988s();
            if (s == -1) {
                m24774H();
                AppMethodBeat.m2505o(99153);
            } else if (c45135d.mo72993x() < 0.0f) {
                m24774H();
                AppMethodBeat.m2505o(99153);
            } else {
                int m = c45135d.mo72982m();
                if (m == 3 || m == 0) {
                    synchronized (this) {
                        this.f3245a.nativeSetLineArrowSpacing(this.f3246b, s, c45135d.mo72993x());
                    }
                } else {
                    synchronized (this) {
                        this.f3245a.nativeSetLineFootPrintSpacing(this.f3246b, s, c45135d.mo72993x());
                    }
                }
                m24774H();
                AppMethodBeat.m2505o(99153);
            }
        } catch (Throwable th) {
            m24774H();
            AppMethodBeat.m2505o(99153);
        }
    }

    /* renamed from: f */
    public void mo29385f(final String str) {
        AppMethodBeat.m2504i(99154);
        if (this.f3246b == 0) {
            AppMethodBeat.m2505o(99154);
            return;
        }
        this.f3251g.mo75423a(new C46788a() {
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(99037);
                if (C16238gh.this.f3246b != 0) {
                    C16238gh.this.f3245a.nativeSetServerHost(C16238gh.this.f3246b, str);
                }
                AppMethodBeat.m2505o(99037);
            }
        });
        AppMethodBeat.m2505o(99154);
    }

    /* renamed from: g */
    public void mo29389g(boolean z) {
        AppMethodBeat.m2504i(99155);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3245a.nativeEnablePOI(this.f3246b, z);
                m24774H();
                AppMethodBeat.m2505o(99155);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99155);
        }
    }

    /* renamed from: h */
    public void mo29393h(boolean z) {
        AppMethodBeat.m2504i(99156);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3245a.nativeEnableVectorMap(this.f3246b, z);
                m24774H();
                AppMethodBeat.m2505o(99156);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99156);
        }
    }

    /* renamed from: C */
    public String mo29301C() {
        AppMethodBeat.m2504i(99157);
        try {
            String str;
            m24773G();
            if (this.f3246b == 0) {
                str = "";
            } else {
                str = this.f3245a.nativeGetDataEngineVersion(this.f3246b);
                m24774H();
                AppMethodBeat.m2505o(99157);
            }
            return str;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99157);
        }
    }

    /* renamed from: a */
    public void mo29341a(String str, String str2) {
        AppMethodBeat.m2504i(99158);
        try {
            m24773G();
            if (this.f3246b != 0) {
                this.f3245a.nativeSetBuildingToSpecificFloor(this.f3246b, str, str2);
                if (this.f3250f != null) {
                    this.f3250f.mo29413z();
                }
                m24774H();
                AppMethodBeat.m2505o(99158);
            }
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99158);
        }
    }

    /* renamed from: D */
    public String mo29302D() {
        AppMethodBeat.m2504i(99159);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99159);
                return null;
            }
            String mapEngineRenderStatus = this.f3245a.getMapEngineRenderStatus(this.f3246b);
            return mapEngineRenderStatus;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99159);
        }
    }

    /* renamed from: E */
    public ArrayList<MapPoi> mo29303E() {
        AppMethodBeat.m2504i(99160);
        try {
            m24773G();
            if (this.f3246b == 0) {
                m24774H();
                AppMethodBeat.m2505o(99160);
                return null;
            }
            ArrayList<MapPoi> nativeGetPoisInScreen = this.f3245a.nativeGetPoisInScreen(this.f3246b);
            return nativeGetPoisInScreen;
        } finally {
            m24774H();
            AppMethodBeat.m2505o(99160);
        }
    }

    /* renamed from: G */
    private void m24773G() {
        AppMethodBeat.m2504i(99161);
        this.f3256m.readLock().lock();
        AppMethodBeat.m2505o(99161);
    }

    /* renamed from: H */
    private void m24774H() {
        AppMethodBeat.m2504i(99162);
        this.f3256m.readLock().unlock();
        AppMethodBeat.m2505o(99162);
    }

    /* renamed from: I */
    private void m24775I() {
        AppMethodBeat.m2504i(99163);
        this.f3256m.writeLock().lock();
        AppMethodBeat.m2505o(99163);
    }

    /* renamed from: J */
    private void m24776J() {
        AppMethodBeat.m2504i(99164);
        this.f3256m.writeLock().unlock();
        AppMethodBeat.m2505o(99164);
    }

    /* renamed from: a */
    public void mo29340a(String str) {
        this.f3255l = str;
    }

    /* renamed from: F */
    public String mo29304F() {
        String str = this.f3255l;
        this.f3255l = null;
        return str;
    }
}
