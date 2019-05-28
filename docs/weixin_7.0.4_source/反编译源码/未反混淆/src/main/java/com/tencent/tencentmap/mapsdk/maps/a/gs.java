package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class gs implements Cloneable {
    private int a = -1;
    private a b = new a();
    private Rect c = new Rect();
    private int d;
    private double e;
    private double f;
    private double g = 0.0d;
    private double h = 1.0d;
    private double i = 0.0d;
    private double j = 1.0d;
    private double k = 0.0d;
    private double l = 1.0d;
    private GeoPoint m = new GeoPoint();
    private Rect n;
    private gm o;
    private gh p;
    private Integer q = Integer.valueOf(0);
    private DoublePoint r = new DoublePoint();
    private b s;

    public static class b {
        private float a = 0.0f;
        private float b = 0.0f;

        public b(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public void a(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public float a() {
            return this.a;
        }

        public float b() {
            return this.b;
        }
    }

    public enum c {
        NO_CHANGED,
        SCALE_CHANGED,
        SCALE_LEVEL_CHANGED;

        static {
            AppMethodBeat.o(99454);
        }
    }

    public static class a implements Cloneable {
        private float a = 3.0517578E-5f;
        private float b = 4.0f;
        private int c = 3;
        private int d = 20;
        private float e;
        private int f;

        public void a(float f) {
            this.e = f;
        }

        public void a(int i, float f) {
            this.e = f;
            this.f = i;
        }

        /* Access modifiers changed, original: 0000 */
        public void a(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
        }

        /* Access modifiers changed, original: 0000 */
        public void b(float f) {
            AppMethodBeat.i(99447);
            a aVar = new a();
            this.c = aVar.b();
            this.a = f / aVar.c();
            AppMethodBeat.o(99447);
        }

        /* Access modifiers changed, original: 0000 */
        public float a(int i) {
            return 1.9073486E-6f * ((float) (1 << (i - 1)));
        }

        /* Access modifiers changed, original: 0000 */
        public float a() {
            return this.e;
        }

        /* Access modifiers changed, original: 0000 */
        public int b() {
            return this.f;
        }

        /* Access modifiers changed, original: 0000 */
        public float c() {
            AppMethodBeat.i(99448);
            float a = this.e / a(this.f);
            AppMethodBeat.o(99448);
            return a;
        }

        /* Access modifiers changed, original: 0000 */
        public int d() {
            return this.c;
        }

        /* Access modifiers changed, original: 0000 */
        public int e() {
            return this.d;
        }

        /* Access modifiers changed, original: 0000 */
        public int f() {
            return 20;
        }

        /* Access modifiers changed, original: 0000 */
        public void b(int i) {
            this.d = i;
        }

        /* Access modifiers changed, original: 0000 */
        public float g() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.e == aVar.e && this.f == aVar.f) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            AppMethodBeat.i(99449);
            int hashCode = toString().hashCode();
            AppMethodBeat.o(99449);
            return hashCode;
        }

        public String toString() {
            AppMethodBeat.i(99450);
            String str = "scale:" + this.e + ", scaleLevel:" + this.f;
            AppMethodBeat.o(99450);
            return str;
        }

        public Object clone() {
            AppMethodBeat.i(99451);
            Object clone = super.clone();
            AppMethodBeat.o(99451);
            return clone;
        }
    }

    public gs(gm gmVar) {
        AppMethodBeat.i(99455);
        this.o = gmVar;
        this.p = gmVar.f();
        AppMethodBeat.o(99455);
    }

    public void a(gs gsVar) {
        AppMethodBeat.i(99456);
        this.a = gsVar.a;
        this.b.a(gsVar.b);
        this.c.set(gsVar.c);
        this.d = gsVar.d;
        this.e = gsVar.e;
        this.f = gsVar.f;
        this.g = gsVar.g;
        this.h = gsVar.h;
        this.i = gsVar.i;
        this.j = gsVar.j;
        this.k = gsVar.k;
        this.l = gsVar.l;
        this.m.setGeoPoint(gsVar.m);
        this.r.set(gsVar.r.x, gsVar.r.y);
        this.n = gsVar.n;
        AppMethodBeat.o(99456);
    }

    public void a(Rect rect, int i, int i2, int i3) {
        AppMethodBeat.i(99457);
        this.n = rect;
        this.c = gi.a(2);
        b(i3);
        a(0);
        a(i, i2, false);
        AppMethodBeat.o(99457);
    }

    public void a() {
        AppMethodBeat.i(99458);
        if (this.o == null) {
            AppMethodBeat.o(99458);
            return;
        }
        this.m = this.p.q();
        int s = this.p.s();
        float r = this.p.r();
        if (s != j()) {
            this.o.a().a(c.SCALE_LEVEL_CHANGED);
        } else if (r != i()) {
            this.o.a().a(c.SCALE_CHANGED);
        }
        if (this.b != null) {
            this.b.a(s, r);
        }
        this.a = this.p.y();
        AppMethodBeat.o(99458);
    }

    public boolean a(int i) {
        AppMethodBeat.i(99459);
        if (this.p == null) {
            AppMethodBeat.o(99459);
            return false;
        }
        int y = this.p.y();
        if (y == i) {
            AppMethodBeat.o(99459);
            return false;
        }
        if (y == 11) {
            this.o.c(false);
        }
        if (i == 11) {
            this.o.c(true);
        }
        this.a = i;
        this.p.c(i, b(y, i));
        AppMethodBeat.o(99459);
        return true;
    }

    public int b() {
        AppMethodBeat.i(99460);
        int i;
        if (this.p == null) {
            i = this.a;
            AppMethodBeat.o(99460);
            return i;
        }
        i = this.p.y();
        AppMethodBeat.o(99460);
        return i;
    }

    public float a(float f) {
        AppMethodBeat.i(99461);
        if (this.p.x() == f) {
            AppMethodBeat.o(99461);
            return f;
        }
        float f2 = f % 360.0f;
        double toRadians = Math.toRadians((double) f);
        this.g = Math.sin(toRadians);
        this.h = Math.cos(toRadians);
        if (this.p != null) {
            this.p.a(f2);
        }
        AppMethodBeat.o(99461);
        return f2;
    }

    public float c() {
        AppMethodBeat.i(99462);
        float x = this.p.x();
        AppMethodBeat.o(99462);
        return x;
    }

    public float b(float f) {
        AppMethodBeat.i(99463);
        if (this.p.w() == f) {
            AppMethodBeat.o(99463);
            return f;
        }
        float max = Math.max(0.0f, Math.min(40.0f, f));
        double toRadians = Math.toRadians((double) f);
        this.i = Math.sin(toRadians);
        this.j = Math.cos(toRadians);
        toRadians = 1.5707963267948966d - toRadians;
        this.l = Math.cos(toRadians);
        this.k = Math.sin(toRadians);
        if (this.p != null) {
            this.p.b(max);
        }
        AppMethodBeat.o(99463);
        return max;
    }

    public float d() {
        AppMethodBeat.i(99464);
        float w = this.p.w();
        AppMethodBeat.o(99464);
        return w;
    }

    public c c(float f) {
        float r;
        int s;
        c cVar;
        AppMethodBeat.i(99465);
        c cVar2 = c.NO_CHANGED;
        float a = this.b.a();
        int b = this.b.b();
        if (this.p != null) {
            this.p.a((double) f, false);
            r = this.p.r();
            s = this.p.s();
        } else {
            s = b;
            r = a;
        }
        this.b.a(s, r);
        if (s != b) {
            cVar = c.SCALE_LEVEL_CHANGED;
        } else if (r != a) {
            cVar = c.SCALE_CHANGED;
        } else {
            cVar = cVar2;
        }
        switch (cVar) {
            case SCALE_LEVEL_CHANGED:
                d(this.b.b());
                break;
        }
        DoublePoint a2 = fp.a(this, p());
        this.r.set(a2.x, a2.y);
        AppMethodBeat.o(99465);
        return cVar;
    }

    public void e() {
        AppMethodBeat.i(99466);
        d(this.b.b());
        DoublePoint a = fp.a(this, p());
        this.r.set(a.x, a.y);
        AppMethodBeat.o(99466);
    }

    public c d(float f) {
        AppMethodBeat.i(99467);
        if (this.p != null) {
            this.p.a((double) f);
        }
        this.b.a(f);
        c cVar = c.SCALE_LEVEL_CHANGED;
        AppMethodBeat.o(99467);
        return cVar;
    }

    private void d(int i) {
        double d = (double) ((1 << i) * 256);
        this.d = (int) d;
        this.e = d / 360.0d;
        this.f = d / 6.283185307179586d;
    }

    public boolean b(int i) {
        AppMethodBeat.i(99468);
        if (c(this.b.a(i)) == c.SCALE_LEVEL_CHANGED) {
            AppMethodBeat.o(99468);
            return true;
        }
        AppMethodBeat.o(99468);
        return false;
    }

    public int f() {
        return this.d;
    }

    public double g() {
        return this.e;
    }

    public double h() {
        return this.f;
    }

    public float i() {
        AppMethodBeat.i(99469);
        float a = this.b.a();
        AppMethodBeat.o(99469);
        return a;
    }

    public int j() {
        AppMethodBeat.i(99470);
        int b = this.b.b();
        AppMethodBeat.o(99470);
        return b;
    }

    public float k() {
        AppMethodBeat.i(99471);
        float c = this.b.c();
        AppMethodBeat.o(99471);
        return c;
    }

    public int l() {
        AppMethodBeat.i(99472);
        int d = this.b.d();
        AppMethodBeat.o(99472);
        return d;
    }

    public int m() {
        AppMethodBeat.i(99473);
        int e = this.b.e();
        AppMethodBeat.o(99473);
        return e;
    }

    public int n() {
        AppMethodBeat.i(99474);
        int f = this.b.f();
        AppMethodBeat.o(99474);
        return f;
    }

    public void c(int i) {
        AppMethodBeat.i(99475);
        this.b.b(i);
        AppMethodBeat.o(99475);
    }

    public float o() {
        AppMethodBeat.i(99476);
        float g = this.b.g();
        AppMethodBeat.o(99476);
        return g;
    }

    public void e(float f) {
        AppMethodBeat.i(99477);
        this.b.b(f);
        AppMethodBeat.o(99477);
    }

    public void a(Rect rect) {
        AppMethodBeat.i(99478);
        this.c.set(rect);
        AppMethodBeat.o(99478);
    }

    public boolean a(GeoPoint geoPoint) {
        AppMethodBeat.i(99479);
        boolean a = a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        AppMethodBeat.o(99479);
        return a;
    }

    public boolean a(int i, int i2, boolean z) {
        int i3;
        int width;
        boolean z2 = false;
        AppMethodBeat.i(99480);
        if ((1 << (20 - j())) < 0) {
            i3 = 0;
        } else {
            i3 = 20 - j();
        }
        if (WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT > i3) {
            width = ((this.n.width() * WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) - (this.n.width() * i3)) / 2;
            i3 = ((this.n.height() * WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) - (i3 * this.n.height())) / 2;
        } else {
            i3 = 0;
            width = 0;
        }
        int i4 = this.c.left - width;
        width += this.c.right;
        int i5 = this.c.top - i3;
        i3 += this.c.bottom;
        if (i >= i5) {
            i5 = i;
        }
        if (i5 > i3) {
            i5 = i3;
        }
        if (i2 < i4) {
            i3 = i4;
        } else {
            i3 = i2;
        }
        if (i3 > width) {
            i3 = width;
        }
        if (!(i5 == this.m.getLatitudeE6() && i3 == this.m.getLongitudeE6())) {
            z2 = true;
        }
        this.m.setLatitudeE6(i5);
        this.m.setLongitudeE6(i3);
        DoublePoint a = fp.a(this, this.m);
        a(a.x, a.y);
        this.p.a(this.m, z);
        AppMethodBeat.o(99480);
        return z2;
    }

    public boolean a(int i, int i2) {
        int width;
        int i3;
        AppMethodBeat.i(99481);
        int j = 1 << (20 - j());
        if (WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT > j) {
            width = ((this.n.width() * WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) - (this.n.width() * j)) / 2;
            j = ((this.n.height() * WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) - (j * this.n.height())) / 2;
            i3 = width;
        } else {
            j = 0;
            i3 = 0;
        }
        int i4 = this.c.left - i3;
        width = this.c.right + i3;
        i3 = this.c.top - j;
        j += this.c.bottom;
        if (i >= i3) {
            i3 = i;
        }
        if (i3 > j) {
            i3 = j;
        }
        if (i2 < i4) {
            j = i4;
        } else {
            j = i2;
        }
        if (j > width) {
            j = width;
        }
        this.p.d(new GeoPoint(i3, j));
        AppMethodBeat.o(99481);
        return true;
    }

    public void a(double d, double d2) {
        AppMethodBeat.i(99482);
        this.r.set(d, d2);
        AppMethodBeat.o(99482);
    }

    public GeoPoint p() {
        return this.m;
    }

    public boolean a(float f, float f2, boolean z) {
        AppMethodBeat.i(99483);
        if (this.s == null) {
            this.s = new b(f, f2);
        } else {
            this.s.a(f, f2);
        }
        this.o.a(f, f2, z);
        AppMethodBeat.o(99483);
        return true;
    }

    public b q() {
        return this.s;
    }

    public byte[] r() {
        return null;
    }

    public int hashCode() {
        AppMethodBeat.i(99484);
        int hashCode = toString().hashCode();
        AppMethodBeat.o(99484);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(99485);
        if (obj instanceof gs) {
            gs gsVar = (gs) obj;
            if (!gsVar.m.equals(this.m)) {
                AppMethodBeat.o(99485);
                return false;
            } else if (!gsVar.b.equals(this.b)) {
                AppMethodBeat.o(99485);
                return false;
            } else if (gsVar.a != this.a) {
                AppMethodBeat.o(99485);
                return false;
            } else {
                AppMethodBeat.o(99485);
                return true;
            }
        }
        AppMethodBeat.o(99485);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(99486);
        StringBuilder stringBuilder = new StringBuilder();
        GeoPoint p = p();
        stringBuilder.append("mapParam: ");
        stringBuilder.append("center:" + p.toString() + " ");
        stringBuilder.append("mode:" + this.a + " ");
        stringBuilder.append("mapScale:" + this.b.toString() + " ");
        stringBuilder.append("screenRect:" + this.n.toString() + " ");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(99486);
        return stringBuilder2;
    }

    public Object clone() {
        AppMethodBeat.i(99487);
        gs gsVar = (gs) super.clone();
        gsVar.c = new Rect(this.c);
        gsVar.b = (a) this.b.clone();
        gsVar.m = new GeoPoint(this.m);
        gsVar.r = new DoublePoint(this.r.x, this.r.y);
        AppMethodBeat.o(99487);
        return gsVar;
    }

    private boolean b(int i, int i2) {
        if (i == i2) {
            return true;
        }
        if (i == 11 && i2 != 13) {
            return false;
        }
        if (i == 13 && i2 != 11) {
            return false;
        }
        if (i2 == 11 && i != 13) {
            return false;
        }
        if (i2 != 13 || i == 11) {
            return true;
        }
        return false;
    }
}
