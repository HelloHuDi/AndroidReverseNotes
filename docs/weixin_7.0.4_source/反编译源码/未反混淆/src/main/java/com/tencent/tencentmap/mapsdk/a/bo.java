package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.element.k;
import com.tencent.map.lib.element.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.fw;
import com.tencent.tencentmap.mapsdk.maps.a.gj;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class bo extends k {
    private static int c = 0;
    private CopyOnWriteArrayList<a> a;
    private Context b;

    class a {
        final /* synthetic */ bo a;
        private co b;
        private l c;
        private Bitmap[] d;

        public boolean a() {
            AppMethodBeat.i(100843);
            boolean h = this.b.h();
            AppMethodBeat.o(100843);
            return h;
        }

        public int b() {
            AppMethodBeat.i(100844);
            if (this.b == null) {
                AppMethodBeat.o(100844);
                return 0;
            }
            int g = this.b.g();
            AppMethodBeat.o(100844);
            return g;
        }

        public l c() {
            return this.c;
        }

        public l a(fw fwVar, b bVar) {
            AppMethodBeat.i(100845);
            de a = this.b.a();
            db f = this.b.f();
            if (f == null) {
                f = a.e();
            }
            if (f == null) {
                AppMethodBeat.o(100845);
                return null;
            }
            int a2;
            int b;
            int i;
            float q;
            float r;
            double d;
            double d2;
            DoublePoint b2 = fwVar.b(bo.a(this.a, f));
            if (a != null) {
                a2 = a.a(this.a.b);
                b = a.b(this.a.b);
                i = a2;
            } else {
                a2 = this.b.b();
                b = this.b.c();
                i = a2;
            }
            if (a != null) {
                q = a.q();
                r = a.r();
            } else {
                q = this.b.d();
                r = this.b.e();
            }
            if (q >= 0.0f && q <= 1.0f) {
                b2.x -= (((double) q) - 0.5d) * ((double) i);
            }
            if (r >= 0.0f && r <= 1.0f) {
                b2.y -= (((double) r) - 0.5d) * ((double) b);
            }
            Bitmap bitmap = this.d[bVar.ordinal()];
            int width = bitmap.getWidth() / 2;
            a2 = (bitmap.getHeight() / 2) + (b / 2);
            if (bVar == b.LEFT_TOP) {
                d = b2.x - ((double) width);
                d2 = b2.y - ((double) a2);
            } else if (bVar == b.RIGHT_TOP) {
                d = b2.x + ((double) width);
                d2 = b2.y - ((double) a2);
            } else if (bVar == b.RIGHT_BOTTOM) {
                d = b2.x + ((double) width);
                d2 = ((double) a2) + b2.y;
            } else {
                d = b2.x - ((double) width);
                d2 = ((double) a2) + b2.y;
            }
            this.c.a(fwVar.a(new DoublePoint(d, d2)));
            this.c.a(a(bVar), bitmap);
            l lVar = this.c;
            AppMethodBeat.o(100845);
            return lVar;
        }

        private String a(b bVar) {
            AppMethodBeat.i(100846);
            String obj = toString();
            if (bVar == b.LEFT_TOP) {
                obj = "b_lt_".concat(String.valueOf(obj));
                AppMethodBeat.o(100846);
                return obj;
            } else if (bVar == b.RIGHT_TOP) {
                obj = "b_rt_".concat(String.valueOf(obj));
                AppMethodBeat.o(100846);
                return obj;
            } else if (bVar == b.RIGHT_BOTTOM) {
                obj = "b_rb_".concat(String.valueOf(obj));
                AppMethodBeat.o(100846);
                return obj;
            } else {
                obj = "b_lb_".concat(String.valueOf(obj));
                AppMethodBeat.o(100846);
                return obj;
            }
        }
    }

    public enum b {
        LEFT_TOP,
        RIGHT_TOP,
        RIGHT_BOTTOM,
        LEFT_BOTTOM;

        static {
            AppMethodBeat.o(100849);
        }
    }

    static /* synthetic */ GeoPoint a(bo boVar, db dbVar) {
        AppMethodBeat.i(100857);
        GeoPoint a = boVar.a(dbVar);
        AppMethodBeat.o(100857);
        return a;
    }

    public synchronized void e() {
        AppMethodBeat.i(100850);
        this.a.clear();
        d();
        AppMethodBeat.o(100850);
    }

    public synchronized void f() {
        AppMethodBeat.i(100851);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null && aVar.a()) {
                this.a.remove(aVar);
                b(aVar.c());
            }
        }
        AppMethodBeat.o(100851);
    }

    public synchronized void b(gj gjVar, fw fwVar) {
        AppMethodBeat.i(100852);
        b(fwVar);
        super.b(gjVar, fwVar);
        AppMethodBeat.o(100852);
    }

    public synchronized boolean a(fw fwVar, float f, float f2) {
        boolean z;
        AppMethodBeat.i(100853);
        int c = c();
        int i = 0;
        while (i < c) {
            l lVar = (l) a(i);
            if (lVar.a(fwVar, f, f2)) {
                if (i < c - 1 && b(lVar)) {
                    a((j) lVar);
                }
                z = true;
                AppMethodBeat.o(100853);
            } else {
                i++;
            }
        }
        AppMethodBeat.o(100853);
        z = false;
        return z;
    }

    private void b(fw fwVar) {
        AppMethodBeat.i(100854);
        if (this.a == null || this.a.isEmpty()) {
            AppMethodBeat.o(100854);
            return;
        }
        int size = this.a.size();
        int ordinal = b.LEFT_BOTTOM.ordinal();
        b[] bVarArr = new b[size];
        for (int i = 0; i < size; i++) {
            bVarArr[i] = b.LEFT_TOP;
        }
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.a.get(i2);
            l c = aVar.c();
            aVar.a(fwVar, bVarArr[i2]);
            for (int i3 = i2 + 1; i3 < size; i3++) {
                a aVar2 = (a) this.a.get(i3);
                l c2 = aVar2.c();
                aVar2.a(fwVar, bVarArr[i3]);
                int ordinal2;
                b b;
                if (aVar.b() > aVar2.b()) {
                    for (ordinal2 = bVarArr[i2].ordinal() - 1; ordinal2 < ordinal; ordinal2++) {
                        b = b(ordinal2);
                        aVar2.a(fwVar, b);
                        bVarArr[i2] = b;
                        if (!a(fwVar, c, c2)) {
                            break;
                        }
                    }
                } else {
                    for (ordinal2 = bVarArr[i3].ordinal(); ordinal2 <= ordinal; ordinal2++) {
                        b = b(ordinal2);
                        aVar2.a(fwVar, b);
                        bVarArr[i3] = b;
                        if (!a(fwVar, c, c2)) {
                            break;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(100854);
    }

    private boolean a(fw fwVar, l lVar, l lVar2) {
        AppMethodBeat.i(100855);
        Rect a = lVar.a(fwVar);
        Rect a2 = lVar2.a(fwVar);
        if (a == null || a2 == null) {
            AppMethodBeat.o(100855);
            return false;
        }
        boolean intersects = Rect.intersects(a, a2);
        AppMethodBeat.o(100855);
        return intersects;
    }

    private b b(int i) {
        switch (i) {
            case 0:
                return b.LEFT_TOP;
            case 1:
                return b.RIGHT_TOP;
            case 2:
                return b.RIGHT_BOTTOM;
            default:
                return b.LEFT_BOTTOM;
        }
    }

    private GeoPoint a(db dbVar) {
        AppMethodBeat.i(100856);
        if (dbVar == null) {
            AppMethodBeat.o(100856);
            return null;
        }
        GeoPoint geoPoint = new GeoPoint((int) (dbVar.a * 1000000.0d), (int) (dbVar.b * 1000000.0d));
        AppMethodBeat.o(100856);
        return geoPoint;
    }
}
