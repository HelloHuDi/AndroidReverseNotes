package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.map.lib.element.C44680l;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24382gs.C24381c;
import com.tencent.tencentmap.mapsdk.p666a.C16192dk;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ia */
public class C16279ia extends C36519hz implements C41717j, C41050ft {
    /* renamed from: a */
    Polygon2D f3416a;
    /* renamed from: b */
    private List<GeoPoint> f3417b = new ArrayList();
    /* renamed from: c */
    private Rect f3418c;
    /* renamed from: d */
    private C44680l f3419d;
    /* renamed from: e */
    private byte[] f3420e = new byte[0];
    /* renamed from: f */
    private C16281a f3421f = new C16281a();
    /* renamed from: g */
    private String f3422g;
    /* renamed from: h */
    private GeoPoint f3423h = new GeoPoint();
    /* renamed from: i */
    private Rect f3424i = new Rect();
    /* renamed from: j */
    private C8889f f3425j;
    /* renamed from: k */
    private boolean f3426k = false;
    /* renamed from: l */
    private boolean f3427l = false;
    /* renamed from: m */
    private C16192dk f3428m;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ia$a */
    static class C16281a {
        /* renamed from: a */
        private Bitmap f3429a;
        /* renamed from: b */
        private TextPaint f3430b;
        /* renamed from: c */
        private int f3431c;
        /* renamed from: d */
        private int f3432d;
        /* renamed from: e */
        private int f3433e;
        /* renamed from: f */
        private HashMap<String, Integer> f3434f;

        private C16281a() {
            AppMethodBeat.m2504i(99745);
            this.f3429a = null;
            this.f3430b = null;
            this.f3431c = TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR;
            this.f3432d = 180;
            this.f3433e = -1;
            this.f3434f = new HashMap();
            AppMethodBeat.m2505o(99745);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo29508a() {
            AppMethodBeat.m2504i(99746);
            if (!(this.f3429a == null || this.f3429a.isRecycled())) {
                this.f3429a.recycle();
                this.f3429a = null;
            }
            AppMethodBeat.m2505o(99746);
        }
    }

    public C16279ia(C31061iz c31061iz, C16192dk c16192dk) {
        AppMethodBeat.m2504i(99747);
        if (c31061iz == null || c31061iz.mo75386b() == null) {
            AppMethodBeat.m2505o(99747);
            return;
        }
        this.f3416a = new Polygon2D();
        this.f3416a.polygonId = -1;
        this.f3428m = c16192dk;
        this.f3425j = c31061iz.mo75386b();
        if (!(c16192dk == null || StringUtil.isEmpty(c16192dk.mo29155g()))) {
            this.f3425j.mo20174a((C41050ft) this);
        }
        AppMethodBeat.m2505o(99747);
    }

    /* renamed from: a */
    public void mo29504a(List<GeoPoint> list) {
        AppMethodBeat.m2504i(99748);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(99748);
            return;
        }
        if (this.f3417b == null) {
            this.f3417b = new ArrayList();
        } else {
            this.f3417b.clear();
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            GeoPoint geoPoint = (GeoPoint) list.get(i);
            if (geoPoint != null) {
                boolean z;
                for (int i2 = 0; i2 < i; i2++) {
                    if (geoPoint.equals((GeoPoint) list.get(i2))) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (!z) {
                    this.f13966P = true;
                    this.f3417b.add(geoPoint);
                }
            }
        }
        AppMethodBeat.m2505o(99748);
    }

    /* renamed from: a */
    public void mo29501a(C16192dk c16192dk) {
        AppMethodBeat.m2504i(99749);
        if (c16192dk == null) {
            AppMethodBeat.m2505o(99749);
            return;
        }
        mo50178d(c16192dk.mo29151d());
        mo50176c(c16192dk.mo29149c());
        mo50177d(c16192dk.mo29146b());
        mo50175c(c16192dk.mo29153e());
        mo29442a(c16192dk.mo29154f());
        mo50174a_(c16192dk.mo29156h());
        m25035b(c16192dk.mo29144a());
        this.f13966P = true;
        AppMethodBeat.m2505o(99749);
    }

    /* renamed from: e */
    public int mo29505e() {
        return this.f3416a == null ? -1 : this.f3416a.polygonId;
    }

    /* renamed from: b */
    private void m25035b(List<C24343db> list) {
        AppMethodBeat.m2504i(99750);
        if (list == null) {
            AppMethodBeat.m2505o(99750);
            return;
        }
        int size = list.size();
        if (size <= 0) {
            AppMethodBeat.m2505o(99750);
            return;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            C24343db c24343db = (C24343db) list.get(i);
            if (c24343db != null) {
                GeoPoint a = C36520ic.m60470a(c24343db);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        mo29504a(arrayList);
        AppMethodBeat.m2505o(99750);
    }

    /* renamed from: a */
    public void mo29441a(GL10 gl10) {
        AppMethodBeat.m2504i(99751);
        if (this.f3425j == null) {
            AppMethodBeat.m2505o(99751);
        } else if (mo29443a()) {
            mo29449c();
            AppMethodBeat.m2505o(99751);
        } else {
            this.f3425j.mo20206c(this.f3416a.polygonId);
            this.f3416a.polygonId = -1;
            AppMethodBeat.m2505o(99751);
        }
    }

    /* renamed from: a */
    public boolean mo29444a(float f, float f2) {
        return false;
    }

    /* renamed from: a */
    public boolean mo29443a() {
        return this.f13965O;
    }

    /* renamed from: a */
    public void mo29442a(boolean z) {
        AppMethodBeat.m2504i(99752);
        if (this.f3425j == null) {
            AppMethodBeat.m2505o(99752);
            return;
        }
        this.f13965O = z;
        this.f3425j.mo20154a();
        AppMethodBeat.m2505o(99752);
    }

    /* renamed from: b */
    public void mo29445b() {
    }

    /* renamed from: c */
    public void mo29449c() {
        AppMethodBeat.m2504i(99753);
        m25039g();
        AppMethodBeat.m2505o(99753);
    }

    /* renamed from: b */
    private int[] m25037b(int i) {
        AppMethodBeat.m2504i(99754);
        int[] iArr = new int[]{Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i)};
        AppMethodBeat.m2505o(99754);
        return iArr;
    }

    /* renamed from: g */
    private void m25039g() {
        AppMethodBeat.m2504i(99755);
        if (this.f3425j == null) {
            AppMethodBeat.m2505o(99755);
        } else if (this.f3416a.polygonId >= 0 && !this.f13966P) {
            AppMethodBeat.m2505o(99755);
        } else if (this.f3417b == null || this.f3417b.size() <= 2) {
            AppMethodBeat.m2505o(99755);
        } else {
            this.f3416a.color = m25037b(this.f13962L);
            this.f3416a.borderColor = m25037b(this.f13963M);
            this.f3416a.borderWidth = this.f13961K;
            this.f3416a.polygonMode = 1;
            this.f3416a.zIndex = mo50172D();
            this.f3416a.level = mo50173E();
            int size = this.f3417b.size();
            this.f3416a.points = new Point[size];
            for (int i = 0; i < size; i++) {
                GeoPoint geoPoint = (GeoPoint) this.f3417b.get(i);
                this.f3416a.points[i] = new Point(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
            }
            if (-1 == this.f3416a.polygonId) {
                this.f3416a.polygonId = this.f3425j.mo20152a(this.f3416a);
            } else if (this.f13966P) {
                this.f3425j.mo20195b(this.f3416a);
            }
            this.f3425j.mo20154a();
            this.f13966P = false;
            AppMethodBeat.m2505o(99755);
        }
    }

    /* renamed from: z */
    public void mo29507z() {
        AppMethodBeat.m2504i(99756);
        super.mo29507z();
        AppMethodBeat.m2505o(99756);
    }

    /* renamed from: d */
    public void mo29450d() {
        AppMethodBeat.m2504i(99757);
        if (this.f3425j == null) {
            AppMethodBeat.m2505o(99757);
            return;
        }
        this.f3425j.mo20197b((C41050ft) this);
        if (this.f3416a != null) {
            this.f3425j.mo20206c(this.f3416a.polygonId);
        }
        if (this.f3417b != null) {
            this.f3417b.clear();
            this.f3417b = null;
        }
        synchronized (this.f3420e) {
            try {
                if (this.f3421f != null) {
                    this.f3421f.mo29508a();
                    this.f3421f = null;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(99757);
                }
            }
        }
        if (this.f3419d != null) {
            this.f3425j.mo20194b(this.f3419d);
            this.f3419d = null;
        }
        this.f3426k = false;
        AppMethodBeat.m2505o(99757);
    }

    /* renamed from: f */
    public Rect mo29506f() {
        AppMethodBeat.m2504i(99758);
        Rect rect;
        if (this.f3418c != null) {
            rect = this.f3418c;
            AppMethodBeat.m2505o(99758);
            return rect;
        } else if (this.f3417b == null || this.f3417b.isEmpty()) {
            AppMethodBeat.m2505o(99758);
            return null;
        } else {
            GeoPoint geoPoint = (GeoPoint) this.f3417b.get(0);
            int latitudeE6 = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            int size = this.f3417b.size();
            int i = 1;
            int i2 = latitudeE6;
            int i3 = latitudeE6;
            int i4 = longitudeE6;
            int i5 = longitudeE6;
            while (i < size) {
                geoPoint = (GeoPoint) this.f3417b.get(i);
                int latitudeE62 = geoPoint.getLatitudeE6();
                int longitudeE62 = geoPoint.getLongitudeE6();
                longitudeE6 = Math.min(i5, longitudeE62);
                i4 = Math.max(i4, longitudeE62);
                latitudeE6 = Math.max(i3, latitudeE62);
                i2 = Math.min(i2, latitudeE62);
                i++;
                i3 = latitudeE6;
                i5 = longitudeE6;
            }
            this.f3418c = new Rect(i5, i3, i4, i2);
            rect = this.f3418c;
            AppMethodBeat.m2505o(99758);
            return rect;
        }
    }

    /* renamed from: b */
    public void mo20132b(C16263gj c16263gj, C24374fw c24374fw) {
    }

    /* renamed from: a */
    public synchronized void mo29502a(C16263gj c16263gj, C24374fw c24374fw, GL10 gl10) {
        AppMethodBeat.m2504i(99759);
        if (this.f3425j == null) {
            AppMethodBeat.m2505o(99759);
        } else if (!mo29443a()) {
            this.f3425j.mo20206c(this.f3416a.polygonId);
            this.f3416a.polygonId = -1;
            AppMethodBeat.m2505o(99759);
        } else if (StringUtil.isEmpty(this.f3428m.mo29155g())) {
            mo29449c();
            AppMethodBeat.m2505o(99759);
        } else if (m25036b(c24374fw)) {
            mo29441a(gl10);
            if (this.f3419d != null) {
                this.f3419d.mo20132b(c16263gj, c24374fw);
                this.f3422g = this.f3419d.mo71723f();
                if (!this.f3427l) {
                    this.f3425j.mo20213d(this.f3419d.mo71723f(), mo29505e());
                    this.f3427l = true;
                }
            }
            AppMethodBeat.m2505o(99759);
        } else {
            AppMethodBeat.m2505o(99759);
        }
    }

    /* renamed from: a */
    public boolean mo20130a(C24374fw c24374fw, float f, float f2) {
        return false;
    }

    /* renamed from: a */
    public Rect mo20125a(C24374fw c24374fw) {
        AppMethodBeat.m2504i(99760);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        if (this.f3416a != null) {
            rect = mo29506f();
        }
        if (this.f3419d != null) {
            rect2 = this.f3419d.mo20125a(c24374fw);
            rect.left = Math.min(rect.left, rect2.left);
            rect.top = Math.min(rect.top, rect2.top);
            rect.right = Math.max(rect.right, rect2.right);
            rect.bottom = Math.max(rect.bottom, rect2.bottom);
        }
        AppMethodBeat.m2505o(99760);
        return rect;
    }

    /* renamed from: a */
    public void mo29503a(C24381c c24381c) {
        AppMethodBeat.m2504i(99761);
        if (c24381c == C24381c.NO_CHANGED) {
            AppMethodBeat.m2505o(99761);
            return;
        }
        if (this.f3425j != null) {
            m25038c(this.f3425j.mo20244t());
        }
        AppMethodBeat.m2505o(99761);
    }

    /* renamed from: b */
    private boolean m25036b(C24374fw c24374fw) {
        AppMethodBeat.m2504i(99762);
        if (this.f3416a == null) {
            AppMethodBeat.m2505o(99762);
            return false;
        }
        Rect f = mo29506f();
        GeoPoint geoPoint = new GeoPoint(f.top, f.left);
        GeoPoint geoPoint2 = new GeoPoint(f.bottom, f.right);
        GeoPoint geoPoint3 = new GeoPoint(f.bottom, f.left);
        GeoPoint geoPoint4 = new GeoPoint(f.top, f.right);
        DoublePoint b = c24374fw.mo29298b(geoPoint);
        DoublePoint b2 = c24374fw.mo29298b(geoPoint2);
        DoublePoint b3 = c24374fw.mo29298b(geoPoint3);
        DoublePoint b4 = c24374fw.mo29298b(geoPoint4);
        DoublePoint[] a = m25034a(new DoublePoint[]{b, b4, b2, b3});
        Rect rect = new Rect((int) a[0].f2800x, (int) a[0].f2801y, (int) a[1].f2800x, (int) a[1].f2801y);
        if (Math.abs(rect.width()) <= 5 || Math.abs(rect.height()) <= 5) {
            AppMethodBeat.m2505o(99762);
            return false;
        }
        AppMethodBeat.m2505o(99762);
        return true;
    }

    /* renamed from: c */
    private void m25038c(C24374fw c24374fw) {
        AppMethodBeat.m2504i(99763);
        if (this.f3425j == null) {
            AppMethodBeat.m2505o(99763);
            return;
        }
        String g = this.f3428m.mo29155g();
        if (StringUtil.isEmpty(g)) {
            AppMethodBeat.m2505o(99763);
            return;
        }
        synchronized (this.f3420e) {
            try {
                if (this.f3421f == null) {
                    this.f3421f = new C16281a();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99763);
            }
        }
        m25033a(g, c24374fw);
    }

    /* renamed from: a */
    private DoublePoint[] m25034a(DoublePoint[] doublePointArr) {
        AppMethodBeat.m2504i(99764);
        int length = doublePointArr.length;
        double d = doublePointArr[0].f2800x;
        double d2 = doublePointArr[0].f2801y;
        double d3 = doublePointArr[0].f2800x;
        double d4 = doublePointArr[0].f2801y;
        int i = 1;
        while (i < length) {
            double d5 = doublePointArr[i].f2800x;
            double d6 = doublePointArr[i].f2801y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 <= d3) {
                d5 = d3;
            }
            if (d6 < d2) {
                d2 = d6;
            }
            if (d6 <= d4) {
                d6 = d4;
            }
            i++;
            d4 = d6;
            d3 = d5;
        }
        DoublePoint doublePoint = new DoublePoint(d, d2);
        DoublePoint doublePoint2 = new DoublePoint(d3, d4);
        DoublePoint[] doublePointArr2 = new DoublePoint[]{doublePoint, doublePoint2};
        AppMethodBeat.m2505o(99764);
        return doublePointArr2;
    }

    /* renamed from: a */
    private int m25033a(String str, C24374fw c24374fw) {
        AppMethodBeat.m2504i(99765);
        GeoPoint geoPoint = new GeoPoint(this.f3424i.top, this.f3424i.left);
        GeoPoint geoPoint2 = new GeoPoint(this.f3424i.top, this.f3424i.right);
        GeoPoint geoPoint3 = new GeoPoint(this.f3424i.bottom, this.f3424i.right);
        GeoPoint geoPoint4 = new GeoPoint(this.f3424i.bottom, this.f3424i.left);
        DoublePoint b = c24374fw.mo29298b(geoPoint);
        DoublePoint b2 = c24374fw.mo29298b(geoPoint2);
        DoublePoint b3 = c24374fw.mo29298b(geoPoint3);
        DoublePoint b4 = c24374fw.mo29298b(geoPoint4);
        DoublePoint[] a = m25034a(new DoublePoint[]{b, b2, b3, b4});
        int a2 = m25032a(new Rect((int) a[0].f2800x, (int) a[0].f2801y, (int) a[1].f2800x, (int) a[1].f2801y), str);
        AppMethodBeat.m2505o(99765);
        return a2;
    }

    /* renamed from: a */
    private int m25032a(Rect rect, String str) {
        return 1;
    }
}
