package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.d;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.element.c;
import com.tencent.map.lib.gl.JNI;
import com.tencent.map.lib.gl.JNICallback;
import com.tencent.map.lib.gl.JNICallback.a;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.h;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.microedition.khronos.opengles.GL10;

public class gh implements a, e, h, fk, hg {
    private static boolean i = true;
    private JNI a = new JNI();
    private long b;
    private gu c;
    private hh d = new hh();
    private hg e;
    private e f;
    private gm g;
    private long h = 0;
    private int j = 0;
    private float k = 1.0f;
    private String l = null;
    private ReentrantReadWriteLock m = new ReentrantReadWriteLock();

    public gh(Context context, gm gmVar) {
        AppMethodBeat.i(99049);
        this.d.a((hg) this);
        this.g = gmVar;
        this.k = context.getResources().getDisplayMetrics().density;
        if (i) {
            hj.a(context, JNI.LIB_NAME);
        }
        AppMethodBeat.o(99049);
    }

    public void a(gu guVar) {
        this.c = guVar;
    }

    public void a(hf hfVar) {
        AppMethodBeat.i(99050);
        this.d.a(hfVar);
        AppMethodBeat.o(99050);
    }

    public void a(e eVar) {
        this.f = eVar;
    }

    public void a() {
        AppMethodBeat.i(99051);
        try {
            I();
            this.d.a();
            if (this.d != null) {
                this.d.a(null);
            }
            if (this.b != 0) {
                synchronized (this) {
                    this.a.nativeDestroyEngine(this.b);
                    this.b = 0;
                }
            }
            J();
            AppMethodBeat.o(99051);
        } catch (Throwable th) {
            J();
            AppMethodBeat.o(99051);
        }
    }

    public boolean a(Context context, gv gvVar, String str, String str2, String str3, float f) {
        AppMethodBeat.i(99052);
        boolean a = gn.a();
        int[] iArr = new int[1];
        try {
            I();
            this.b = this.a.nativeInitEngine(str, str2, str3, SystemUtil.getDensity(context), 256, SystemUtil.getDensity(context), iArr, a, MapLanguage.LAN_CHINESE.ordinal());
            if (iArr[0] != 0) {
                d.a("init engine fail:" + iArr[0]);
                this.b = 0;
                J();
                AppMethodBeat.o(99052);
                return false;
            }
            J();
            try {
                G();
                if (this.b != 0) {
                    this.a.initCallback(gvVar, this, this, this, this.g.a(), this, this.b);
                    this.a.nativeSetTrafficColor(this.b, -14803236, -15611905, -11088785, -16777063);
                }
                H();
                AppMethodBeat.o(99052);
                return true;
            } catch (Throwable th) {
                H();
                AppMethodBeat.o(99052);
            }
        } catch (Throwable th2) {
            J();
            AppMethodBeat.o(99052);
        }
    }

    public boolean b() {
        AppMethodBeat.i(99053);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99053);
                return false;
            }
            boolean nativeGenerateTextures = this.a.nativeGenerateTextures(this.b);
            return nativeGenerateTextures;
        } finally {
            H();
            AppMethodBeat.o(99053);
        }
    }

    public boolean c() {
        AppMethodBeat.i(99054);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99054);
                return false;
            }
            this.a.nativeDrawFrame(this.b);
            H();
            AppMethodBeat.o(99054);
            return true;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99054);
        }
    }

    public int d() {
        AppMethodBeat.i(99055);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99055);
                return -1;
            }
            int nativeClearCache = this.a.nativeClearCache(this.b);
            return nativeClearCache;
        } finally {
            H();
            AppMethodBeat.o(99055);
        }
    }

    public void e() {
        AppMethodBeat.i(99056);
        try {
            G();
            if (this.b != 0) {
                this.a.nativeLockEngine(this.b);
                H();
                AppMethodBeat.o(99056);
            }
        } finally {
            H();
            AppMethodBeat.o(99056);
        }
    }

    public void f() {
        AppMethodBeat.i(99057);
        try {
            G();
            if (this.b != 0) {
                this.a.nativeUnlockEngine(this.b);
                H();
                AppMethodBeat.o(99057);
            }
        } finally {
            H();
            AppMethodBeat.o(99057);
        }
    }

    public boolean g() {
        AppMethodBeat.i(99058);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99058);
                return true;
            }
            boolean nativeIsMapDrawFinished;
            synchronized (this) {
                nativeIsMapDrawFinished = this.a.nativeIsMapDrawFinished(this.b);
            }
            H();
            AppMethodBeat.o(99058);
            return nativeIsMapDrawFinished;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99058);
        }
    }

    public int a(byte[] bArr, int i, boolean z, boolean z2) {
        AppMethodBeat.i(99059);
        try {
            G();
            synchronized (this) {
                if (this.b == 0) {
                    H();
                    AppMethodBeat.o(99059);
                    return -1;
                }
                int nativeRefreshTrafficData = this.a.nativeRefreshTrafficData(this.b, bArr, i, z, z2);
                H();
                AppMethodBeat.o(99059);
                return nativeRefreshTrafficData;
            }
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99059);
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(99060);
        try {
            G();
            if (this.b != 0) {
                synchronized (this) {
                    this.a.nativeCheckTrafficBlockCache(this.b, i, i2, i3, i4, i5);
                }
            }
            H();
            AppMethodBeat.o(99060);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99060);
        }
    }

    public TrafficRequestItem[] h() {
        TrafficRequestItem[] trafficRequestItemArr = null;
        AppMethodBeat.i(99061);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99061);
            } else {
                synchronized (this) {
                    int[] nativeFetchLackedTrafficBlocks = this.a.nativeFetchLackedTrafficBlocks(this.b);
                    if (nativeFetchLackedTrafficBlocks == null || nativeFetchLackedTrafficBlocks.length == 0) {
                        H();
                        AppMethodBeat.o(99061);
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
                        H();
                        AppMethodBeat.o(99061);
                    }
                }
            }
            return trafficRequestItemArr;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99061);
        }
    }

    public int a(Polygon2D polygon2D) {
        AppMethodBeat.i(99062);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99062);
                return 0;
            }
            int nativeAddPolygon;
            synchronized (this) {
                nativeAddPolygon = this.a.nativeAddPolygon(this.b, polygon2D);
            }
            H();
            AppMethodBeat.o(99062);
            return nativeAddPolygon;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99062);
        }
    }

    public int a(CircleInfo circleInfo) {
        AppMethodBeat.i(99063);
        if (this.b == 0) {
            AppMethodBeat.o(99063);
            return 0;
        }
        int nativeAddCircle;
        synchronized (this) {
            try {
                nativeAddCircle = this.a.nativeAddCircle(this.b, circleInfo);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99063);
            }
        }
        return nativeAddCircle;
    }

    public void a(int i, CircleInfo circleInfo) {
        AppMethodBeat.i(99064);
        if (this.b == 0) {
            AppMethodBeat.o(99064);
            return;
        }
        synchronized (this) {
            try {
                this.a.nativeUpdateCircle(this.b, i, circleInfo);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99064);
            }
        }
    }

    public void a(final int i) {
        AppMethodBeat.i(99065);
        if (this.b == 0 || i < 0 || this.g == null) {
            AppMethodBeat.o(99065);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99016);
                gh.this.a.nativeDeleteCircle(gh.this.b, i);
                AppMethodBeat.o(99016);
            }
        });
        AppMethodBeat.o(99065);
    }

    public void b(Polygon2D polygon2D) {
        AppMethodBeat.i(99066);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99066);
                return;
            }
            synchronized (this) {
                this.a.nativeUpdatePolygon(this.b, polygon2D.polygonId, polygon2D.borldLineId, polygon2D);
            }
            H();
            AppMethodBeat.o(99066);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99066);
        }
    }

    public void a(final int i, final int i2) {
        AppMethodBeat.i(99067);
        try {
            G();
            if (this.b == 0 || i < 0 || this.g == null) {
                H();
                AppMethodBeat.o(99067);
                return;
            }
            this.g.a(new gm.a() {
                public void a(GL10 gl10) {
                    AppMethodBeat.i(99048);
                    gh.this.a.nativeDeletePolygon(gh.this.b, i, i2);
                    AppMethodBeat.o(99048);
                }
            });
            H();
            AppMethodBeat.o(99067);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99067);
        }
    }

    public int a(MaskLayer maskLayer) {
        AppMethodBeat.i(99068);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99068);
                return 0;
            }
            int nativeAddMaskLayer = this.a.nativeAddMaskLayer(this.b, maskLayer);
            return nativeAddMaskLayer;
        } finally {
            H();
            AppMethodBeat.o(99068);
        }
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(99069);
        try {
            G();
            if (this.b != 0) {
                this.a.nativeUpdateMaskLayer(this.b, i, i2);
                H();
                AppMethodBeat.o(99069);
            }
        } finally {
            H();
            AppMethodBeat.o(99069);
        }
    }

    public void b(int i) {
        AppMethodBeat.i(99070);
        try {
            G();
            if (this.b != 0) {
                this.a.nativeRemoveMaskLayer(this.b, i);
                H();
                AppMethodBeat.o(99070);
            }
        } finally {
            H();
            AppMethodBeat.o(99070);
        }
    }

    public GeoPoint a(byte[] bArr, float f, float f2) {
        AppMethodBeat.i(99071);
        try {
            GeoPoint geoPoint;
            G();
            if (this.b == 0) {
                geoPoint = new GeoPoint();
                H();
                AppMethodBeat.o(99071);
            } else {
                synchronized (this) {
                    double[] dArr = new double[2];
                    this.a.nativeFromScreenLocation(this.b, bArr, f, f2, dArr);
                    geoPoint = new GeoPoint((int) (dArr[1] * 1000000.0d), (int) (dArr[0] * 1000000.0d));
                }
                H();
                AppMethodBeat.o(99071);
            }
            return geoPoint;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99071);
        }
    }

    public PointF a(byte[] bArr, double d, double d2) {
        AppMethodBeat.i(99072);
        try {
            PointF pointF;
            G();
            if (this.b == 0) {
                pointF = new PointF();
                H();
                AppMethodBeat.o(99072);
            } else {
                synchronized (this) {
                    float[] fArr = new float[2];
                    this.a.nativeToScreenLocation(this.b, bArr, d, d2, fArr);
                    pointF = new PointF(fArr[0], fArr[1]);
                }
                H();
                AppMethodBeat.o(99072);
            }
            return pointF;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99072);
        }
    }

    public void i() {
        AppMethodBeat.i(99073);
        try {
            G();
            if (this.b != 0) {
                this.g.a(new gm.a() {
                    public void a(GL10 gl10) {
                        AppMethodBeat.i(99021);
                        gh.this.a.nativeShowStreetRoad(gh.this.b);
                        AppMethodBeat.o(99021);
                    }
                });
                H();
                AppMethodBeat.o(99073);
            }
        } finally {
            H();
            AppMethodBeat.o(99073);
        }
    }

    public void j() {
        AppMethodBeat.i(99074);
        try {
            G();
            if (this.b != 0) {
                synchronized (this) {
                    this.a.nativeHideStreetRoad(this.b);
                }
            }
            H();
            AppMethodBeat.o(99074);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99074);
        }
    }

    public void a(final boolean z) {
        AppMethodBeat.i(99075);
        try {
            G();
            if (this.b != 0) {
                this.g.a(new gm.a() {
                    public void a(GL10 gl10) {
                        AppMethodBeat.i(99030);
                        gh.this.a.nativeSetSatelliteEnabled(gh.this.b, z);
                        AppMethodBeat.o(99030);
                    }
                });
                H();
                AppMethodBeat.o(99075);
            }
        } finally {
            H();
            AppMethodBeat.o(99075);
        }
    }

    public void k() {
        AppMethodBeat.i(99076);
        try {
            G();
            if (this.b != 0) {
                this.g.a(new gm.a() {
                    public void a(GL10 gl10) {
                        AppMethodBeat.i(99039);
                        gh.this.a.nativeShowTraffic(gh.this.b);
                        AppMethodBeat.o(99039);
                    }
                });
                H();
                AppMethodBeat.o(99076);
            }
        } finally {
            H();
            AppMethodBeat.o(99076);
        }
    }

    public void l() {
        AppMethodBeat.i(99077);
        try {
            G();
            if (this.b != 0) {
                this.g.a(new gm.a() {
                    public void a(GL10 gl10) {
                        AppMethodBeat.i(99040);
                        gh.this.a.nativeHideTraffic(gh.this.b);
                        AppMethodBeat.o(99040);
                    }
                });
                H();
                AppMethodBeat.o(99077);
            }
        } finally {
            H();
            AppMethodBeat.o(99077);
        }
    }

    public String a(GeoPoint geoPoint) {
        AppMethodBeat.i(99078);
        try {
            G();
            String str;
            if (this.b == 0) {
                str = "";
                return str;
            }
            byte[] nativeGetCityName = this.a.nativeGetCityName(this.b, geoPoint);
            if (nativeGetCityName != null) {
                try {
                    str = new String(nativeGetCityName, "GBK").trim();
                    H();
                    AppMethodBeat.o(99078);
                    return str;
                } catch (UnsupportedEncodingException e) {
                }
            }
            str = "";
            H();
            AppMethodBeat.o(99078);
            return str;
        } finally {
            H();
            AppMethodBeat.o(99078);
        }
    }

    public void b(final String str) {
        AppMethodBeat.i(99079);
        try {
            G();
            if (this.b != 0) {
                this.g.a(new gm.a() {
                    public void a(GL10 gl10) {
                        AppMethodBeat.i(99041);
                        gh.this.a.nativeUpdateMapResource(gh.this.b, str);
                        AppMethodBeat.o(99041);
                    }
                });
                H();
                AppMethodBeat.o(99079);
            }
        } finally {
            H();
            AppMethodBeat.o(99079);
        }
    }

    public int a(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99080);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99080);
                return -1;
            }
            int i;
            H();
            int m = dVar.m();
            boolean z = false;
            if (m == 3) {
                m = 0;
                z = true;
            }
            boolean z2 = false;
            int[] c = dVar.c();
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
            if (dVar.z() != null) {
                iArr = new int[dVar.z().size()];
                m = 0;
                while (true) {
                    int i2 = m;
                    if (i2 >= dVar.z().size()) {
                        break;
                    }
                    iArr[i2] = ((Integer) dVar.z().get(i2)).intValue();
                    m = i2 + 1;
                }
            }
            int[] iArr2 = new int[0];
            if (dVar.f() != null) {
                iArr2 = new int[dVar.f().length];
                for (m = 0; m < dVar.f().length; m++) {
                    iArr2[m] = dVar.f()[m];
                }
            }
            long j2;
            try {
                G();
                j2 = this.b;
                if (j2 == j) {
                    H();
                    AppMethodBeat.o(99080);
                    return -1;
                }
                synchronized (this) {
                    m = this.a.nativeCreateLine(this.b, dVar.c(), dVar.b(), (GeoPoint[]) dVar.a().toArray(new GeoPoint[0]), dVar.r(), dVar.n(), i, z, z2, dVar.l(), dVar.j(), dVar.v(), dVar.d(), dVar.e(), iArr2, dVar.g(), iArr, dVar.o(), dVar.A());
                }
                return m;
            } catch (Throwable th) {
                j2 = th;
                H();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99080);
            }
        } finally {
            H();
            AppMethodBeat.o(99080);
        }
    }

    public void a(int i, boolean z) {
        AppMethodBeat.i(99081);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99081);
            } else if (i == -1) {
                H();
                AppMethodBeat.o(99081);
            } else {
                synchronized (this) {
                    this.a.nativeDeleteLine(this.b, (long) i, z);
                }
                H();
                AppMethodBeat.o(99081);
            }
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99081);
        }
    }

    public void b(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99082);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99082);
                return;
            }
            int s = dVar.s();
            if (s == -1) {
                H();
                AppMethodBeat.o(99082);
                return;
            }
            synchronized (this) {
                com.tencent.map.lib.element.d.a q = dVar.q();
                if (q == null) {
                    H();
                    AppMethodBeat.o(99082);
                    return;
                }
                this.a.nativeSetTurnArrow(this.b, (long) s, q.a, q.b);
                H();
                AppMethodBeat.o(99082);
            }
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99082);
        }
    }

    public void c(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99083);
        try {
            G();
            if (this.b != 0) {
                final int s = dVar.s();
                if (s == -1) {
                    H();
                    AppMethodBeat.o(99083);
                    return;
                }
                final int[] y = dVar.y();
                this.g.a(new gm.a() {
                    public void a(GL10 gl10) {
                        AppMethodBeat.i(99042);
                        gh.this.a.nativeSetTurnArrowStyle(gh.this.b, (long) s, y[0], y[1]);
                        AppMethodBeat.o(99042);
                    }
                });
                H();
                AppMethodBeat.o(99083);
            }
        } finally {
            H();
            AppMethodBeat.o(99083);
        }
    }

    public void d(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99084);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99084);
                return;
            }
            int s = dVar.s();
            if (s == -1) {
                H();
                AppMethodBeat.o(99084);
                return;
            }
            synchronized (this) {
                this.a.nativeSetLineDrawArrow(this.b, (long) s, dVar.j());
            }
            H();
            AppMethodBeat.o(99084);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99084);
        }
    }

    public void e(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99085);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99085);
                return;
            }
            int s = dVar.s();
            if (s == -1) {
                H();
                AppMethodBeat.o(99085);
                return;
            }
            synchronized (this) {
                this.a.nativeSetLineDirectionArrowTextureName(this.b, (long) s, dVar.w());
            }
            H();
            AppMethodBeat.o(99085);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99085);
        }
    }

    public void f(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99086);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99086);
                return;
            }
            int s = dVar.s();
            if (s == -1) {
                H();
                AppMethodBeat.o(99086);
                return;
            }
            synchronized (this) {
                this.a.nativeSetDrawCap(this.b, (long) s, dVar.k());
            }
            H();
            AppMethodBeat.o(99086);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99086);
        }
    }

    public void g(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99087);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99087);
                return;
            }
            int s = dVar.s();
            if (s == -1) {
                H();
                AppMethodBeat.o(99087);
                return;
            }
            synchronized (this) {
                GeoPoint h = dVar.h();
                if (h == null) {
                    H();
                    AppMethodBeat.o(99087);
                    return;
                }
                this.a.nativeLineInsertPoint(this.b, (long) s, h, dVar.i());
                H();
                AppMethodBeat.o(99087);
            }
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99087);
        }
    }

    public void h(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99088);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99088);
                return;
            }
            int s = dVar.s();
            if (s == -1) {
                H();
                AppMethodBeat.o(99088);
                return;
            }
            synchronized (this) {
                GeoPoint h = dVar.h();
                if (h == null) {
                    H();
                    AppMethodBeat.o(99088);
                    return;
                }
                this.a.nativeLineClearPoint(this.b, (long) s, h, dVar.i());
                H();
                AppMethodBeat.o(99088);
            }
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99088);
        }
    }

    public TappedElement a(float f, float f2) {
        TappedElement tappedElement = null;
        AppMethodBeat.i(99089);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99089);
            } else {
                synchronized (this) {
                    byte[] nativeOnTap = this.a.nativeOnTap(this.b, f, f2);
                    if (nativeOnTap == null) {
                        H();
                        AppMethodBeat.o(99089);
                    } else {
                        try {
                            tappedElement = TappedElement.fromBytes(nativeOnTap);
                            H();
                            AppMethodBeat.o(99089);
                        } catch (Exception e) {
                            H();
                            AppMethodBeat.o(99089);
                        }
                    }
                }
            }
            return tappedElement;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99089);
        }
    }

    public void b(boolean z) {
        AppMethodBeat.i(99090);
        try {
            G();
            if (0 != this.b) {
                synchronized (this) {
                    this.a.nativeSetBuilding3DEffect(this.b, z);
                }
            }
            H();
            AppMethodBeat.o(99090);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99090);
        }
    }

    public void m() {
        AppMethodBeat.i(99091);
        if (this.b != 0) {
            this.g.a(new gm.a() {
                public void a(GL10 gl10) {
                    AppMethodBeat.i(99027);
                    if (gh.this.b != 0) {
                        gh.this.a.nativeClearDownloadURLCache(gh.this.b);
                    }
                    AppMethodBeat.o(99027);
                }
            });
        }
        AppMethodBeat.o(99091);
    }

    public void a(final String str, final byte[] bArr) {
        AppMethodBeat.i(99092);
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99038);
                if (gh.this.b != 0) {
                    gh.this.a.nativeWriteMapDataBlock(gh.this.b, str, bArr);
                }
                AppMethodBeat.o(99038);
            }
        });
        if (this.e != null) {
            this.e.a(str, bArr);
        }
        AppMethodBeat.o(99092);
    }

    public void c(final String str) {
        AppMethodBeat.i(99093);
        this.j++;
        if (this.j >= 30) {
            m();
            this.j = 0;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99043);
                if (gh.this.b != 0) {
                    gh.this.a.nativeWriteMapDataBlock(gh.this.b, str, null);
                }
                AppMethodBeat.o(99043);
            }
        });
        if (this.e != null) {
            this.e.c(str);
        }
        AppMethodBeat.o(99093);
    }

    public void d(String str) {
        AppMethodBeat.i(99094);
        this.d.a(str);
        AppMethodBeat.o(99094);
    }

    public void n() {
        AppMethodBeat.i(99095);
        if (0 == this.b) {
            AppMethodBeat.o(99095);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99044);
                if (gh.this.b != 0) {
                    gh.this.a.nativeHideCompass(gh.this.b);
                }
                AppMethodBeat.o(99044);
            }
        });
        AppMethodBeat.o(99095);
    }

    public int a(String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2) {
        AppMethodBeat.i(99096);
        int i3;
        try {
            G();
            i3 = (0 > this.b ? 1 : (0 == this.b ? 0 : -1));
            if (i3 == 0) {
                H();
            } else {
                synchronized (this) {
                    i3 = this.a.nativeAddMarker(this.b, str, d, d2, f, f2, f3, f4, f5, f6, z, z2, z3, z4, i, i2);
                }
                H();
            }
            return i3;
        } catch (Throwable th) {
            i3 = th;
            H();
        } finally {
            while (true) {
            }
            AppMethodBeat.o(99096);
        }
    }

    public void a(int i, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3) {
        AppMethodBeat.i(99097);
        if (0 == this.b) {
            AppMethodBeat.o(99097);
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
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99045);
                if (gh.this.b != 0) {
                    gh.this.a.nativeUpdateMarkerInfo(gh.this.b, i4, str2, d3, d4, f7, f8, f9, f10, f11, f12, z5, z6, z7, z8, i5, i6);
                }
                AppMethodBeat.o(99045);
            }
        });
        AppMethodBeat.o(99097);
    }

    public void a(int[] iArr, int i) {
        AppMethodBeat.i(99098);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99098);
                return;
            }
            synchronized (this) {
                this.a.nativeDeleteIcons(this.b, iArr, i);
            }
            H();
            AppMethodBeat.o(99098);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99098);
        }
    }

    public void c(final boolean z) {
        AppMethodBeat.i(99099);
        if (0 == this.b) {
            AppMethodBeat.o(99099);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99046);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetCompassVisible(gh.this.b, z);
                }
                AppMethodBeat.o(99046);
            }
        });
        AppMethodBeat.o(99099);
    }

    public void c(final int i, final int i2) {
        AppMethodBeat.i(99100);
        if (0 == this.b) {
            AppMethodBeat.o(99100);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99047);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetCompassPosition(gh.this.b, i, i2);
                }
                AppMethodBeat.o(99047);
            }
        });
        AppMethodBeat.o(99100);
    }

    public double a(Rect rect, Rect rect2) {
        AppMethodBeat.i(99101);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99101);
                return 1.0d;
            }
            double nativeGetTargetScale;
            synchronized (this) {
                nativeGetTargetScale = this.a.nativeGetTargetScale(this.b, rect, rect2);
            }
            H();
            AppMethodBeat.o(99101);
            return nativeGetTargetScale;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99101);
        }
    }

    public void a(final Rect rect, final Rect rect2, final boolean z) {
        AppMethodBeat.i(99102);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99102);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99017);
                if (gh.this.b != 0) {
                    gh.this.a.nativeZoomToSpan(gh.this.b, rect, rect2, z);
                }
                AppMethodBeat.o(99017);
            }
        });
        AppMethodBeat.o(99102);
    }

    public void d(final boolean z) {
        AppMethodBeat.i(99103);
        if (this.b == 0 || this.g == null) {
            AppMethodBeat.o(99103);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99018);
                if (gh.this.b != 0) {
                    gh.this.a.nativeIndoorBuildingEnabled(gh.this.b, z);
                }
                AppMethodBeat.o(99018);
            }
        });
        AppMethodBeat.o(99103);
    }

    public void c(final int i) {
        AppMethodBeat.i(99104);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99104);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99019);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetIndoorFloor(gh.this.b, i);
                }
                AppMethodBeat.o(99019);
            }
        });
        AppMethodBeat.o(99104);
    }

    public int o() {
        AppMethodBeat.i(99105);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99105);
                return -1;
            }
            int nativeGetIndoorCurrentFloorId;
            synchronized (this) {
                nativeGetIndoorCurrentFloorId = this.a.nativeGetIndoorCurrentFloorId(this.b);
            }
            H();
            AppMethodBeat.o(99105);
            return nativeGetIndoorCurrentFloorId;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99105);
        }
    }

    public String[] p() {
        AppMethodBeat.i(99106);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99106);
                return null;
            }
            String[] nativeGetIndoorFloorNames;
            synchronized (this) {
                nativeGetIndoorFloorNames = this.a.nativeGetIndoorFloorNames(this.b);
            }
            H();
            AppMethodBeat.o(99106);
            return nativeGetIndoorFloorNames;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99106);
        }
    }

    public c b(GeoPoint geoPoint) {
        AppMethodBeat.i(99107);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99107);
                return null;
            }
            c cVar;
            if (geoPoint == null) {
                geoPoint = new GeoPoint();
            }
            synchronized (this) {
                cVar = new c(this.a.nativeGetActiveIndoorBuildingGUID(this.b), this.a.nativeGetCurIndoorName(this.b, geoPoint), this.a.nativeGetIndoorFloorNames(this.b), this.a.nativeGetIndoorCurrentFloorId(this.b));
            }
            H();
            AppMethodBeat.o(99107);
            return cVar;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99107);
        }
    }

    public String c(GeoPoint geoPoint) {
        AppMethodBeat.i(99108);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99108);
                return null;
            }
            String nativeGetCurIndoorName;
            synchronized (this) {
                nativeGetCurIndoorName = this.a.nativeGetCurIndoorName(this.b, geoPoint);
            }
            H();
            AppMethodBeat.o(99108);
            return nativeGetCurIndoorName;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99108);
        }
    }

    public void a(final String[] strArr) {
        AppMethodBeat.i(99109);
        if (this.b == 0) {
            AppMethodBeat.o(99109);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99020);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetShowIndoorBuildingWhiteList(gh.this.b, strArr);
                }
                AppMethodBeat.o(99020);
            }
        });
        AppMethodBeat.o(99109);
    }

    public void e(final boolean z) {
        AppMethodBeat.i(99110);
        if (0 == this.b) {
            AppMethodBeat.o(99110);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99022);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetCompassMarkerHidden(gh.this.b, z);
                }
                AppMethodBeat.o(99022);
            }
        });
        AppMethodBeat.o(99110);
    }

    public void a(final float f, final float f2, final boolean z) {
        AppMethodBeat.i(99111);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99111);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99023);
                if (gh.this.b != 0) {
                    gh.this.a.nativeMoveBy(gh.this.b, f, f2, z);
                }
                AppMethodBeat.o(99023);
            }
        });
        AppMethodBeat.o(99111);
    }

    public void a(final GeoPoint geoPoint, final boolean z) {
        AppMethodBeat.i(99112);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99112);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99024);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetCenter(gh.this.b, geoPoint, z);
                }
                AppMethodBeat.o(99024);
            }
        });
        AppMethodBeat.o(99112);
    }

    public void d(GeoPoint geoPoint) {
        AppMethodBeat.i(99113);
        try {
            G();
            if (0 == this.b || this.g == null) {
                H();
                AppMethodBeat.o(99113);
                return;
            }
            this.a.nativeSetCenter(this.b, geoPoint, false);
            H();
            AppMethodBeat.o(99113);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99113);
        }
    }

    public GeoPoint q() {
        AppMethodBeat.i(99114);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99114);
                return null;
            }
            GeoPoint geoPoint;
            synchronized (this) {
                geoPoint = new GeoPoint();
                this.a.nativeGetCenterMapPoint(this.b, geoPoint);
            }
            H();
            AppMethodBeat.o(99114);
            return geoPoint;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99114);
        }
    }

    public void a(final double d, final boolean z) {
        AppMethodBeat.i(99115);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99115);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99025);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetScale(gh.this.b, d, z);
                }
                AppMethodBeat.o(99025);
            }
        });
        AppMethodBeat.o(99115);
    }

    public void a(double d) {
        AppMethodBeat.i(99116);
        try {
            G();
            if (0 == this.b || this.g == null) {
                H();
                AppMethodBeat.o(99116);
                return;
            }
            this.a.nativeSetScale(this.b, d, false);
            H();
            AppMethodBeat.o(99116);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99116);
        }
    }

    public float r() {
        AppMethodBeat.i(99117);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99117);
                return 1.0f;
            }
            float nativeGetScale;
            synchronized (this) {
                nativeGetScale = (float) this.a.nativeGetScale(this.b);
            }
            H();
            AppMethodBeat.o(99117);
            return nativeGetScale;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99117);
        }
    }

    public void b(final int i, final boolean z) {
        AppMethodBeat.i(99118);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99118);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99026);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetScaleLevel(gh.this.b, i, z);
                }
                AppMethodBeat.o(99026);
            }
        });
        AppMethodBeat.o(99118);
    }

    public int s() {
        AppMethodBeat.i(99119);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99119);
                return 20;
            }
            int nativeGetScaleLevel;
            synchronized (this) {
                nativeGetScaleLevel = this.a.nativeGetScaleLevel(this.b);
            }
            H();
            AppMethodBeat.o(99119);
            return nativeGetScaleLevel;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99119);
        }
    }

    public void b(final float f, final float f2) {
        AppMethodBeat.i(99120);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99120);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99028);
                if (gh.this.b != 0) {
                    gh.this.a.nativeZoomIn(gh.this.b, f, f2);
                }
                AppMethodBeat.o(99028);
            }
        });
        AppMethodBeat.o(99120);
    }

    public void t() {
        AppMethodBeat.i(99121);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99121);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99029);
                if (gh.this.b != 0) {
                    gh.this.a.nativeZoomOut(gh.this.b);
                }
                AppMethodBeat.o(99029);
            }
        });
        AppMethodBeat.o(99121);
    }

    public void b(final float f, final float f2, final boolean z) {
        AppMethodBeat.i(99122);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99122);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99031);
                if (gh.this.b == 0) {
                    AppMethodBeat.o(99031);
                } else if (z) {
                    gh.this.a.nativeSetScreenCenterOffset(gh.this.b, f, f2, true);
                    AppMethodBeat.o(99031);
                } else {
                    fw d = gh.this.g.d();
                    DoublePoint b = d.b(gh.this.q());
                    gh.this.a.nativeSetScreenCenterOffset(gh.this.b, f, f2, false);
                    DoublePoint b2 = d.b(gh.this.q());
                    gh.this.a.nativeSetCenter(gh.this.b, d.a(new DoublePoint((b2.x - b.x) + b2.x, (b2.y - b.y) + b2.y)), false);
                    AppMethodBeat.o(99031);
                }
            }
        });
        AppMethodBeat.o(99122);
    }

    public void a(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(99123);
        if (0 == this.b || this.g == null) {
            AppMethodBeat.o(99123);
            return;
        }
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99032);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetViewport(gh.this.b, i5, i6, i7, i8);
                }
                AppMethodBeat.o(99032);
            }
        });
        AppMethodBeat.o(99123);
    }

    public void u() {
        AppMethodBeat.i(99124);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99124);
                return;
            }
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.h == 0) {
                    this.a.nativeUpdateFrame(this.b, 0.0d);
                } else {
                    this.a.nativeUpdateFrame(this.b, (double) (currentTimeMillis - this.h));
                }
                this.h = currentTimeMillis;
            }
            H();
            AppMethodBeat.o(99124);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99124);
        }
    }

    public boolean v() {
        AppMethodBeat.i(99125);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99125);
                return false;
            }
            boolean nativeNeedDispaly;
            synchronized (this) {
                nativeNeedDispaly = this.a.nativeNeedDispaly(this.b);
            }
            H();
            AppMethodBeat.o(99125);
            return nativeNeedDispaly;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99125);
        }
    }

    public void d(int i) {
        AppMethodBeat.i(99126);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99126);
                return;
            }
            synchronized (this) {
                this.a.nativeSetMaxScaleLevel(this.b, i);
            }
            H();
            AppMethodBeat.o(99126);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99126);
        }
    }

    public void e(int i) {
        AppMethodBeat.i(99127);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99127);
                return;
            }
            synchronized (this) {
                this.a.nativeSetMinScaleLevel(this.b, i);
            }
            H();
            AppMethodBeat.o(99127);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99127);
        }
    }

    public void a(float f) {
        AppMethodBeat.i(99128);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99128);
                return;
            }
            synchronized (this) {
                this.a.nativeSetRotate(this.b, f, false);
            }
            H();
            AppMethodBeat.o(99128);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99128);
        }
    }

    public void b(float f) {
        AppMethodBeat.i(99129);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99129);
                return;
            }
            synchronized (this) {
                this.a.nativeSetSkew(this.b, f, false);
            }
            H();
            AppMethodBeat.o(99129);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99129);
        }
    }

    public void c(final int i, final boolean z) {
        AppMethodBeat.i(99130);
        if (0 == this.b) {
            AppMethodBeat.o(99130);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99033);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetMapMode(gh.this.b, i, z);
                }
                AppMethodBeat.o(99033);
            }
        });
        AppMethodBeat.o(99130);
    }

    public float w() {
        AppMethodBeat.i(99131);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99131);
                return 0.0f;
            }
            float nativeGetSkew = this.a.nativeGetSkew(this.b);
            return nativeGetSkew;
        } finally {
            H();
            AppMethodBeat.o(99131);
        }
    }

    public float x() {
        AppMethodBeat.i(99132);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99132);
                return 0.0f;
            }
            float nativeGetRotate = this.a.nativeGetRotate(this.b);
            return nativeGetRotate;
        } finally {
            H();
            AppMethodBeat.o(99132);
        }
    }

    public int y() {
        AppMethodBeat.i(99133);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99133);
                return 1;
            }
            int nativeGetMapMode;
            synchronized (this) {
                nativeGetMapMode = this.a.nativeGetMapMode(this.b);
            }
            H();
            AppMethodBeat.o(99133);
            return nativeGetMapMode;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99133);
        }
    }

    public int d(int i, boolean z) {
        AppMethodBeat.i(99134);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99134);
                return -1;
            }
            int nativeAddHeatTileOverlay;
            synchronized (this) {
                nativeAddHeatTileOverlay = this.a.nativeAddHeatTileOverlay(this.b, i, z);
            }
            H();
            AppMethodBeat.o(99134);
            return nativeAddHeatTileOverlay;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99134);
        }
    }

    public void a(final int i, final int i2, final int i3) {
        AppMethodBeat.i(99135);
        if (this.b == 0 || this.g == null) {
            AppMethodBeat.o(99135);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99034);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetTileOverlayDataLevelRange(gh.this.b, i, i2, i3);
                }
                AppMethodBeat.o(99034);
            }
        });
        AppMethodBeat.o(99135);
    }

    public void f(final int i) {
        AppMethodBeat.i(99136);
        if (this.b == 0 || this.g == null) {
            AppMethodBeat.o(99136);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99035);
                if (gh.this.b != 0) {
                    gh.this.a.nativeRemoveHeatTileOverlay(gh.this.b, i);
                }
                AppMethodBeat.o(99035);
            }
        });
        AppMethodBeat.o(99136);
    }

    public void g(final int i) {
        AppMethodBeat.i(99137);
        if (this.b == 0 || this.g == null) {
            AppMethodBeat.o(99137);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99036);
                if (gh.this.b != 0) {
                    gh.this.a.nativeReloadHeatTileOverlay(gh.this.b, i);
                }
                AppMethodBeat.o(99036);
            }
        });
        AppMethodBeat.o(99137);
    }

    public void h(int i) {
        AppMethodBeat.i(99138);
        if (this.g != null) {
            gs e = this.g.e();
            if (e != null) {
                e.a();
            }
        }
        AppMethodBeat.o(99138);
    }

    public void z() {
        AppMethodBeat.i(99139);
        if (this.f != null) {
            this.f.z();
        }
        AppMethodBeat.o(99139);
    }

    public void a(JNICallback.d dVar) {
        AppMethodBeat.i(99140);
        this.a.setHeatTileLoadCallback(dVar);
        AppMethodBeat.o(99140);
    }

    public void a(j jVar) {
        AppMethodBeat.i(99141);
        this.a.setWorldTileLoadCallback(jVar);
        AppMethodBeat.o(99141);
    }

    public void a(b bVar) {
        AppMethodBeat.i(99142);
        this.a.setHandDrawTileLoadCallback(bVar);
        AppMethodBeat.o(99142);
    }

    public void a(JNICallback.c cVar) {
        AppMethodBeat.i(99143);
        this.a.setHandDrawTileWriteCallback(cVar);
        AppMethodBeat.o(99143);
    }

    public void a(k kVar) {
        AppMethodBeat.i(99144);
        this.a.setTileWriteCallback(kVar);
        AppMethodBeat.o(99144);
    }

    public void d(int i, int i2) {
        AppMethodBeat.i(99145);
        try {
            G();
            if (this.b != 0) {
                this.a.nativeBringElementAbove(this.b, i, i2);
                H();
                AppMethodBeat.o(99145);
            }
        } finally {
            H();
            AppMethodBeat.o(99145);
        }
    }

    public void a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        AppMethodBeat.i(99146);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99146);
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
                        this.a.nativeAddRouteNameSegments(this.b, bArr, size, (GeoPoint[]) list2.toArray(new GeoPoint[size2]), size2);
                    }
                }
            }
            H();
            AppMethodBeat.o(99146);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99146);
        }
    }

    public void A() {
        AppMethodBeat.i(99147);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99147);
                return;
            }
            synchronized (this) {
                this.a.nativeClearRouteNameSegments(this.b);
            }
            H();
            AppMethodBeat.o(99147);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99147);
        }
    }

    public List<Integer> a(Rect rect, int i) {
        List<Integer> list = null;
        AppMethodBeat.i(99148);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99148);
            } else {
                synchronized (this) {
                    int[] iArr = new int[100];
                    int nativeQueryCityCodeList = this.a.nativeQueryCityCodeList(this.b, rect, i, iArr, 100);
                    if (nativeQueryCityCodeList > 0) {
                        list = new ArrayList(nativeQueryCityCodeList);
                        for (int i2 = 0; i2 < nativeQueryCityCodeList; i2++) {
                            list.add(Integer.valueOf(iArr[i2]));
                        }
                        H();
                        AppMethodBeat.o(99148);
                    } else {
                        H();
                        AppMethodBeat.o(99148);
                    }
                }
            }
            return list;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99148);
        }
    }

    public void e(String str) {
        AppMethodBeat.i(99149);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99149);
                return;
            }
            synchronized (this) {
                this.a.nativeMapLoadKMLFile(this.b, str);
            }
            H();
            AppMethodBeat.o(99149);
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99149);
        }
    }

    /* JADX WARNING: Missing block: B:13:0x0022, code skipped:
            H();
            com.tencent.matrix.trace.core.AppMethodBeat.o(99150);
     */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(List<BlockRouteCityData> list) {
        AppMethodBeat.i(99150);
        try {
            G();
            if (0 == this.b) {
                H();
                AppMethodBeat.o(99150);
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
                        this.a.nativeLoadBlockRouteCityList(this.b, iArr, iArr2, size);
                        H();
                        AppMethodBeat.o(99150);
                    }
                }
            }
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99150);
        }
    }

    public void f(boolean z) {
        AppMethodBeat.i(99151);
        try {
            G();
            if (0 != this.b) {
                H();
                AppMethodBeat.o(99151);
            }
        } finally {
            H();
            AppMethodBeat.o(99151);
        }
    }

    public int B() {
        AppMethodBeat.i(99152);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99152);
                return 0;
            }
            int nativeGetLanguage;
            synchronized (this) {
                nativeGetLanguage = this.a.nativeGetLanguage(this.b);
            }
            H();
            AppMethodBeat.o(99152);
            return nativeGetLanguage;
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99152);
        }
    }

    public void i(com.tencent.map.lib.element.d dVar) {
        AppMethodBeat.i(99153);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99153);
                return;
            }
            int s = dVar.s();
            if (s == -1) {
                H();
                AppMethodBeat.o(99153);
            } else if (dVar.x() < 0.0f) {
                H();
                AppMethodBeat.o(99153);
            } else {
                int m = dVar.m();
                if (m == 3 || m == 0) {
                    synchronized (this) {
                        this.a.nativeSetLineArrowSpacing(this.b, s, dVar.x());
                    }
                } else {
                    synchronized (this) {
                        this.a.nativeSetLineFootPrintSpacing(this.b, s, dVar.x());
                    }
                }
                H();
                AppMethodBeat.o(99153);
            }
        } catch (Throwable th) {
            H();
            AppMethodBeat.o(99153);
        }
    }

    public void f(final String str) {
        AppMethodBeat.i(99154);
        if (this.b == 0) {
            AppMethodBeat.o(99154);
            return;
        }
        this.g.a(new gm.a() {
            public void a(GL10 gl10) {
                AppMethodBeat.i(99037);
                if (gh.this.b != 0) {
                    gh.this.a.nativeSetServerHost(gh.this.b, str);
                }
                AppMethodBeat.o(99037);
            }
        });
        AppMethodBeat.o(99154);
    }

    public void g(boolean z) {
        AppMethodBeat.i(99155);
        try {
            G();
            if (this.b != 0) {
                this.a.nativeEnablePOI(this.b, z);
                H();
                AppMethodBeat.o(99155);
            }
        } finally {
            H();
            AppMethodBeat.o(99155);
        }
    }

    public void h(boolean z) {
        AppMethodBeat.i(99156);
        try {
            G();
            if (this.b != 0) {
                this.a.nativeEnableVectorMap(this.b, z);
                H();
                AppMethodBeat.o(99156);
            }
        } finally {
            H();
            AppMethodBeat.o(99156);
        }
    }

    public String C() {
        AppMethodBeat.i(99157);
        try {
            String str;
            G();
            if (this.b == 0) {
                str = "";
            } else {
                str = this.a.nativeGetDataEngineVersion(this.b);
                H();
                AppMethodBeat.o(99157);
            }
            return str;
        } finally {
            H();
            AppMethodBeat.o(99157);
        }
    }

    public void a(String str, String str2) {
        AppMethodBeat.i(99158);
        try {
            G();
            if (this.b != 0) {
                this.a.nativeSetBuildingToSpecificFloor(this.b, str, str2);
                if (this.f != null) {
                    this.f.z();
                }
                H();
                AppMethodBeat.o(99158);
            }
        } finally {
            H();
            AppMethodBeat.o(99158);
        }
    }

    public String D() {
        AppMethodBeat.i(99159);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99159);
                return null;
            }
            String mapEngineRenderStatus = this.a.getMapEngineRenderStatus(this.b);
            return mapEngineRenderStatus;
        } finally {
            H();
            AppMethodBeat.o(99159);
        }
    }

    public ArrayList<MapPoi> E() {
        AppMethodBeat.i(99160);
        try {
            G();
            if (this.b == 0) {
                H();
                AppMethodBeat.o(99160);
                return null;
            }
            ArrayList<MapPoi> nativeGetPoisInScreen = this.a.nativeGetPoisInScreen(this.b);
            return nativeGetPoisInScreen;
        } finally {
            H();
            AppMethodBeat.o(99160);
        }
    }

    private void G() {
        AppMethodBeat.i(99161);
        this.m.readLock().lock();
        AppMethodBeat.o(99161);
    }

    private void H() {
        AppMethodBeat.i(99162);
        this.m.readLock().unlock();
        AppMethodBeat.o(99162);
    }

    private void I() {
        AppMethodBeat.i(99163);
        this.m.writeLock().lock();
        AppMethodBeat.o(99163);
    }

    private void J() {
        AppMethodBeat.i(99164);
        this.m.writeLock().unlock();
        AppMethodBeat.o(99164);
    }

    public void a(String str) {
        this.l = str;
    }

    public String F() {
        String str = this.l;
        this.l = null;
        return str;
    }
}
