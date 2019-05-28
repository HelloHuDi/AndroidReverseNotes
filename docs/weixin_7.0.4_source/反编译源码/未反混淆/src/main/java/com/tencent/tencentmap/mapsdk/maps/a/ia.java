package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.f;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import com.tencent.tencentmap.mapsdk.a.db;
import com.tencent.tencentmap.mapsdk.a.dk;
import com.tencent.tencentmap.mapsdk.maps.a.gs.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class ia extends hz implements j, ft {
    Polygon2D a;
    private List<GeoPoint> b = new ArrayList();
    private Rect c;
    private l d;
    private byte[] e = new byte[0];
    private a f = new a();
    private String g;
    private GeoPoint h = new GeoPoint();
    private Rect i = new Rect();
    private f j;
    private boolean k = false;
    private boolean l = false;
    private dk m;

    static class a {
        private Bitmap a;
        private TextPaint b;
        private int c;
        private int d;
        private int e;
        private HashMap<String, Integer> f;

        private a() {
            AppMethodBeat.i(99745);
            this.a = null;
            this.b = null;
            this.c = TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR;
            this.d = 180;
            this.e = -1;
            this.f = new HashMap();
            AppMethodBeat.o(99745);
        }

        /* Access modifiers changed, original: 0000 */
        public void a() {
            AppMethodBeat.i(99746);
            if (!(this.a == null || this.a.isRecycled())) {
                this.a.recycle();
                this.a = null;
            }
            AppMethodBeat.o(99746);
        }
    }

    public ia(iz izVar, dk dkVar) {
        AppMethodBeat.i(99747);
        if (izVar == null || izVar.b() == null) {
            AppMethodBeat.o(99747);
            return;
        }
        this.a = new Polygon2D();
        this.a.polygonId = -1;
        this.m = dkVar;
        this.j = izVar.b();
        if (!(dkVar == null || StringUtil.isEmpty(dkVar.g()))) {
            this.j.a((ft) this);
        }
        AppMethodBeat.o(99747);
    }

    public void a(List<GeoPoint> list) {
        AppMethodBeat.i(99748);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(99748);
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList();
        } else {
            this.b.clear();
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
                    this.P = true;
                    this.b.add(geoPoint);
                }
            }
        }
        AppMethodBeat.o(99748);
    }

    public void a(dk dkVar) {
        AppMethodBeat.i(99749);
        if (dkVar == null) {
            AppMethodBeat.o(99749);
            return;
        }
        d(dkVar.d());
        c(dkVar.c());
        d(dkVar.b());
        c(dkVar.e());
        a(dkVar.f());
        a_(dkVar.h());
        b(dkVar.a());
        this.P = true;
        AppMethodBeat.o(99749);
    }

    public int e() {
        return this.a == null ? -1 : this.a.polygonId;
    }

    private void b(List<db> list) {
        AppMethodBeat.i(99750);
        if (list == null) {
            AppMethodBeat.o(99750);
            return;
        }
        int size = list.size();
        if (size <= 0) {
            AppMethodBeat.o(99750);
            return;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            db dbVar = (db) list.get(i);
            if (dbVar != null) {
                GeoPoint a = ic.a(dbVar);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        a(arrayList);
        AppMethodBeat.o(99750);
    }

    public void a(GL10 gl10) {
        AppMethodBeat.i(99751);
        if (this.j == null) {
            AppMethodBeat.o(99751);
        } else if (a()) {
            c();
            AppMethodBeat.o(99751);
        } else {
            this.j.c(this.a.polygonId);
            this.a.polygonId = -1;
            AppMethodBeat.o(99751);
        }
    }

    public boolean a(float f, float f2) {
        return false;
    }

    public boolean a() {
        return this.O;
    }

    public void a(boolean z) {
        AppMethodBeat.i(99752);
        if (this.j == null) {
            AppMethodBeat.o(99752);
            return;
        }
        this.O = z;
        this.j.a();
        AppMethodBeat.o(99752);
    }

    public void b() {
    }

    public void c() {
        AppMethodBeat.i(99753);
        g();
        AppMethodBeat.o(99753);
    }

    private int[] b(int i) {
        AppMethodBeat.i(99754);
        int[] iArr = new int[]{Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i)};
        AppMethodBeat.o(99754);
        return iArr;
    }

    private void g() {
        AppMethodBeat.i(99755);
        if (this.j == null) {
            AppMethodBeat.o(99755);
        } else if (this.a.polygonId >= 0 && !this.P) {
            AppMethodBeat.o(99755);
        } else if (this.b == null || this.b.size() <= 2) {
            AppMethodBeat.o(99755);
        } else {
            this.a.color = b(this.L);
            this.a.borderColor = b(this.M);
            this.a.borderWidth = this.K;
            this.a.polygonMode = 1;
            this.a.zIndex = D();
            this.a.level = E();
            int size = this.b.size();
            this.a.points = new Point[size];
            for (int i = 0; i < size; i++) {
                GeoPoint geoPoint = (GeoPoint) this.b.get(i);
                this.a.points[i] = new Point(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
            }
            if (-1 == this.a.polygonId) {
                this.a.polygonId = this.j.a(this.a);
            } else if (this.P) {
                this.j.b(this.a);
            }
            this.j.a();
            this.P = false;
            AppMethodBeat.o(99755);
        }
    }

    public void z() {
        AppMethodBeat.i(99756);
        super.z();
        AppMethodBeat.o(99756);
    }

    public void d() {
        AppMethodBeat.i(99757);
        if (this.j == null) {
            AppMethodBeat.o(99757);
            return;
        }
        this.j.b((ft) this);
        if (this.a != null) {
            this.j.c(this.a.polygonId);
        }
        if (this.b != null) {
            this.b.clear();
            this.b = null;
        }
        synchronized (this.e) {
            try {
                if (this.f != null) {
                    this.f.a();
                    this.f = null;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(99757);
                }
            }
        }
        if (this.d != null) {
            this.j.b(this.d);
            this.d = null;
        }
        this.k = false;
        AppMethodBeat.o(99757);
    }

    public Rect f() {
        AppMethodBeat.i(99758);
        Rect rect;
        if (this.c != null) {
            rect = this.c;
            AppMethodBeat.o(99758);
            return rect;
        } else if (this.b == null || this.b.isEmpty()) {
            AppMethodBeat.o(99758);
            return null;
        } else {
            GeoPoint geoPoint = (GeoPoint) this.b.get(0);
            int latitudeE6 = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            int size = this.b.size();
            int i = 1;
            int i2 = latitudeE6;
            int i3 = latitudeE6;
            int i4 = longitudeE6;
            int i5 = longitudeE6;
            while (i < size) {
                geoPoint = (GeoPoint) this.b.get(i);
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
            this.c = new Rect(i5, i3, i4, i2);
            rect = this.c;
            AppMethodBeat.o(99758);
            return rect;
        }
    }

    public void b(gj gjVar, fw fwVar) {
    }

    public synchronized void a(gj gjVar, fw fwVar, GL10 gl10) {
        AppMethodBeat.i(99759);
        if (this.j == null) {
            AppMethodBeat.o(99759);
        } else if (!a()) {
            this.j.c(this.a.polygonId);
            this.a.polygonId = -1;
            AppMethodBeat.o(99759);
        } else if (StringUtil.isEmpty(this.m.g())) {
            c();
            AppMethodBeat.o(99759);
        } else if (b(fwVar)) {
            a(gl10);
            if (this.d != null) {
                this.d.b(gjVar, fwVar);
                this.g = this.d.f();
                if (!this.l) {
                    this.j.d(this.d.f(), e());
                    this.l = true;
                }
            }
            AppMethodBeat.o(99759);
        } else {
            AppMethodBeat.o(99759);
        }
    }

    public boolean a(fw fwVar, float f, float f2) {
        return false;
    }

    public Rect a(fw fwVar) {
        AppMethodBeat.i(99760);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        if (this.a != null) {
            rect = f();
        }
        if (this.d != null) {
            rect2 = this.d.a(fwVar);
            rect.left = Math.min(rect.left, rect2.left);
            rect.top = Math.min(rect.top, rect2.top);
            rect.right = Math.max(rect.right, rect2.right);
            rect.bottom = Math.max(rect.bottom, rect2.bottom);
        }
        AppMethodBeat.o(99760);
        return rect;
    }

    public void a(c cVar) {
        AppMethodBeat.i(99761);
        if (cVar == c.NO_CHANGED) {
            AppMethodBeat.o(99761);
            return;
        }
        if (this.j != null) {
            c(this.j.t());
        }
        AppMethodBeat.o(99761);
    }

    private boolean b(fw fwVar) {
        AppMethodBeat.i(99762);
        if (this.a == null) {
            AppMethodBeat.o(99762);
            return false;
        }
        Rect f = f();
        GeoPoint geoPoint = new GeoPoint(f.top, f.left);
        GeoPoint geoPoint2 = new GeoPoint(f.bottom, f.right);
        GeoPoint geoPoint3 = new GeoPoint(f.bottom, f.left);
        GeoPoint geoPoint4 = new GeoPoint(f.top, f.right);
        DoublePoint b = fwVar.b(geoPoint);
        DoublePoint b2 = fwVar.b(geoPoint2);
        DoublePoint b3 = fwVar.b(geoPoint3);
        DoublePoint b4 = fwVar.b(geoPoint4);
        DoublePoint[] a = a(new DoublePoint[]{b, b4, b2, b3});
        Rect rect = new Rect((int) a[0].x, (int) a[0].y, (int) a[1].x, (int) a[1].y);
        if (Math.abs(rect.width()) <= 5 || Math.abs(rect.height()) <= 5) {
            AppMethodBeat.o(99762);
            return false;
        }
        AppMethodBeat.o(99762);
        return true;
    }

    private void c(fw fwVar) {
        AppMethodBeat.i(99763);
        if (this.j == null) {
            AppMethodBeat.o(99763);
            return;
        }
        String g = this.m.g();
        if (StringUtil.isEmpty(g)) {
            AppMethodBeat.o(99763);
            return;
        }
        synchronized (this.e) {
            try {
                if (this.f == null) {
                    this.f = new a();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99763);
            }
        }
        a(g, fwVar);
    }

    private DoublePoint[] a(DoublePoint[] doublePointArr) {
        AppMethodBeat.i(99764);
        int length = doublePointArr.length;
        double d = doublePointArr[0].x;
        double d2 = doublePointArr[0].y;
        double d3 = doublePointArr[0].x;
        double d4 = doublePointArr[0].y;
        int i = 1;
        while (i < length) {
            double d5 = doublePointArr[i].x;
            double d6 = doublePointArr[i].y;
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
        AppMethodBeat.o(99764);
        return doublePointArr2;
    }

    private int a(String str, fw fwVar) {
        AppMethodBeat.i(99765);
        GeoPoint geoPoint = new GeoPoint(this.i.top, this.i.left);
        GeoPoint geoPoint2 = new GeoPoint(this.i.top, this.i.right);
        GeoPoint geoPoint3 = new GeoPoint(this.i.bottom, this.i.right);
        GeoPoint geoPoint4 = new GeoPoint(this.i.bottom, this.i.left);
        DoublePoint b = fwVar.b(geoPoint);
        DoublePoint b2 = fwVar.b(geoPoint2);
        DoublePoint b3 = fwVar.b(geoPoint3);
        DoublePoint b4 = fwVar.b(geoPoint4);
        DoublePoint[] a = a(new DoublePoint[]{b, b2, b3, b4});
        int a2 = a(new Rect((int) a[0].x, (int) a[0].y, (int) a[1].x, (int) a[1].y), str);
        AppMethodBeat.o(99765);
        return a2;
    }

    private int a(Rect rect, String str) {
        return 1;
    }
}
