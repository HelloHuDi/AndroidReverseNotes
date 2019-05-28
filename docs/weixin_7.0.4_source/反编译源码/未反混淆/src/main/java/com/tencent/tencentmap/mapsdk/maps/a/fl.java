package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.gs.b;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class fl implements fw {
    private gs a;
    private gh b;
    private gm c;

    public interface a {
        void a(float f, GeoPoint geoPoint, double d);
    }

    static /* synthetic */ boolean c(fl flVar) {
        AppMethodBeat.i(98936);
        boolean b = flVar.b();
        AppMethodBeat.o(98936);
        return b;
    }

    public fl(fn fnVar) {
        AppMethodBeat.i(98919);
        this.c = (gm) fnVar;
        this.a = fnVar.a().j();
        this.b = fnVar.f();
        AppMethodBeat.o(98919);
    }

    public void a(float f) {
        AppMethodBeat.i(98920);
        this.a.d(f);
        AppMethodBeat.o(98920);
    }

    public void a(GeoPoint geoPoint) {
        AppMethodBeat.i(98921);
        this.a.a(geoPoint);
        AppMethodBeat.o(98921);
    }

    public void a(List<j> list, Rect rect, a aVar) {
        AppMethodBeat.i(98922);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(98922);
            return;
        }
        Rect rect2 = new Rect(this.c.g());
        if (rect != null) {
            rect2.left += rect.left;
            rect2.right -= rect.right;
            rect2.top += rect.top;
            rect2.bottom -= rect.bottom;
        }
        final int width = rect2.width();
        final int height = rect2.height();
        final fz g = this.c.a().g();
        final int f = g.f();
        final List<j> list2 = list;
        final Rect rect3 = rect;
        final a aVar2 = aVar;
        this.c.a(new com.tencent.tencentmap.mapsdk.maps.a.gm.a() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x00c5  */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x00da A:{SYNTHETIC, Splitter:B:15:0x00da} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(GL10 gl10) {
                AppMethodBeat.i(98917);
                GeoPoint p = fl.this.a.p();
                float i = fl.this.a.i();
                GeoPoint geoPoint = null;
                float f = 4.0f;
                float o = fl.this.a.o();
                while (f >= o) {
                    fl.this.a(f);
                    Rect a = fl.a(fl.this, list2, fl.this);
                    geoPoint = new GeoPoint(a.centerY(), a.centerX());
                    fl.this.a(geoPoint);
                    GeoPoint geoPoint2 = new GeoPoint(a.top, a.left);
                    GeoPoint geoPoint3 = new GeoPoint(a.bottom, a.right);
                    DoublePoint b = fl.this.b(geoPoint2);
                    DoublePoint b2 = fl.this.b(geoPoint3);
                    Rect rect = new Rect();
                    rect.left = (int) Math.min(b.x, b2.x);
                    rect.right = (int) Math.max(b.x, b2.x);
                    rect.top = (int) Math.min(b.y, b2.y);
                    rect.bottom = (int) Math.max(b.y, b2.y);
                    if (width < rect.width() || height < rect.height()) {
                        f /= 1.01f;
                    } else {
                        if (!fl.b(fl.this)) {
                            geoPoint = fl.a(fl.this, geoPoint, rect3);
                        } else if (fl.c(fl.this)) {
                            b q = fl.this.a.q();
                            if (q != null) {
                                geoPoint = fl.a(fl.this, geoPoint, q);
                            }
                        }
                        f = Math.max(o, f);
                        if (f != 60) {
                            g.a(f);
                        }
                        fl.this.a(p);
                        fl.this.a(i);
                        if (aVar2 != null) {
                            try {
                                aVar2.a(f, geoPoint, -1.0d);
                                AppMethodBeat.o(98917);
                                return;
                            } catch (Exception e) {
                            }
                        }
                        AppMethodBeat.o(98917);
                    }
                }
                f = Math.max(o, f);
                if (f != 60) {
                }
                fl.this.a(p);
                fl.this.a(i);
                if (aVar2 != null) {
                }
                AppMethodBeat.o(98917);
            }
        });
        if (f != 60) {
            g.e();
            g.g();
        }
        AppMethodBeat.o(98922);
    }

    public void a(List<j> list, List<GeoPoint> list2, Rect rect, a aVar) {
        AppMethodBeat.i(98923);
        if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            AppMethodBeat.o(98923);
            return;
        }
        Rect rect2 = new Rect(this.c.g());
        if (rect != null) {
            rect2.left += rect.left;
            rect2.right -= rect.right;
            rect2.top += rect.top;
            rect2.bottom -= rect.bottom;
        }
        final int width = rect2.width();
        final int height = rect2.height();
        final fz g = this.c.a().g();
        final int f = g.f();
        final List<j> list3 = list;
        final List<GeoPoint> list4 = list2;
        final Rect rect3 = rect;
        final a aVar2 = aVar;
        this.c.a(new com.tencent.tencentmap.mapsdk.maps.a.gm.a() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x00c7  */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x00dc A:{SYNTHETIC, Splitter:B:15:0x00dc} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(GL10 gl10) {
                AppMethodBeat.i(98918);
                GeoPoint p = fl.this.a.p();
                float i = fl.this.a.i();
                GeoPoint geoPoint = null;
                float f = 4.0f;
                float o = fl.this.a.o();
                while (f >= o) {
                    fl.this.a(f);
                    Rect a = fl.a(fl.this, list3, list4, fl.this);
                    geoPoint = new GeoPoint(a.centerY(), a.centerX());
                    fl.this.a(geoPoint);
                    GeoPoint geoPoint2 = new GeoPoint(a.top, a.left);
                    GeoPoint geoPoint3 = new GeoPoint(a.bottom, a.right);
                    DoublePoint b = fl.this.b(geoPoint2);
                    DoublePoint b2 = fl.this.b(geoPoint3);
                    Rect rect = new Rect();
                    rect.left = (int) Math.min(b.x, b2.x);
                    rect.right = (int) Math.max(b.x, b2.x);
                    rect.top = (int) Math.min(b.y, b2.y);
                    rect.bottom = (int) Math.max(b.y, b2.y);
                    if (width < rect.width() || height < rect.height()) {
                        f /= 1.01f;
                    } else {
                        if (!fl.b(fl.this)) {
                            geoPoint = fl.a(fl.this, geoPoint, rect3);
                        } else if (fl.c(fl.this)) {
                            b q = fl.this.a.q();
                            if (q != null) {
                                geoPoint = fl.a(fl.this, geoPoint, q);
                            }
                        }
                        f = Math.max(o, f);
                        if (f != 60) {
                            g.a(f);
                        }
                        fl.this.a(p);
                        fl.this.a(i);
                        if (aVar2 != null) {
                            try {
                                aVar2.a(f, geoPoint, -1.0d);
                                AppMethodBeat.o(98918);
                                return;
                            } catch (Exception e) {
                            }
                        }
                        AppMethodBeat.o(98918);
                    }
                }
                f = Math.max(o, f);
                if (f != 60) {
                }
                fl.this.a(p);
                fl.this.a(i);
                if (aVar2 != null) {
                }
                AppMethodBeat.o(98918);
            }
        });
        if (f != 60) {
            g.e();
            g.g();
        }
        AppMethodBeat.o(98923);
    }

    public GeoPoint a(DoublePoint doublePoint) {
        AppMethodBeat.i(98924);
        GeoPoint a = this.b.a(this.a.r(), (float) doublePoint.x, (float) doublePoint.y);
        AppMethodBeat.o(98924);
        return a;
    }

    public DoublePoint b(GeoPoint geoPoint) {
        AppMethodBeat.i(98925);
        double latitudeE6 = ((double) geoPoint.getLatitudeE6()) / 1000000.0d;
        double longitudeE6 = ((double) geoPoint.getLongitudeE6()) / 1000000.0d;
        PointF a = this.b.a(this.a.r(), latitudeE6, longitudeE6);
        DoublePoint doublePoint = new DoublePoint((double) a.x, (double) a.y);
        AppMethodBeat.o(98925);
        return doublePoint;
    }

    public double a(double d) {
        AppMethodBeat.i(98926);
        double pow = (4.0076E7d / (Math.pow(2.0d, (double) ((float) (((double) ((float) this.a.j())) + (Math.log((double) this.a.k()) / Math.log(2.0d))))) * 256.0d)) * Math.cos((3.141592653589793d * d) / 180.0d);
        AppMethodBeat.o(98926);
        return pow;
    }

    public double a(Point point, Point point2) {
        return 0.0d;
    }

    private Rect a(List<j> list, fw fwVar) {
        AppMethodBeat.i(98927);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(98927);
            return null;
        }
        Rect a;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (j a2 : list) {
            a = a2.a(fwVar);
            if (a != null) {
                int i5;
                if (i4 == 0) {
                    i4 = a.left;
                }
                if (i3 == 0) {
                    i3 = a.right;
                }
                if (i2 == 0) {
                    i2 = a.top;
                }
                if (i == 0) {
                    i = a.bottom;
                }
                if (a.left < i4) {
                    i4 = a.left;
                }
                if (a.right > i3) {
                    i3 = a.right;
                }
                if (a.top < i2) {
                    i2 = a.top;
                }
                if (a.bottom > i) {
                    i5 = a.bottom;
                } else {
                    i5 = i;
                }
                i = i5;
            }
        }
        a = new Rect(i4, i2, i3, i);
        AppMethodBeat.o(98927);
        return a;
    }

    private Rect a(List<j> list, List<GeoPoint> list2, fw fwVar) {
        int i;
        int i2;
        int i3;
        int i4;
        Rect a;
        int i5;
        AppMethodBeat.i(98928);
        if (list != null) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            for (j jVar : list) {
                if (jVar != null) {
                    a = jVar.a(fwVar);
                    if (a != null) {
                        if (i4 == 0) {
                            i4 = a.left;
                        }
                        if (i3 == 0) {
                            i3 = a.right;
                        }
                        if (i2 == 0) {
                            i2 = a.top;
                        }
                        if (i == 0) {
                            i = a.bottom;
                        }
                        if (a.left < i4) {
                            i4 = a.left;
                        }
                        if (a.right > i3) {
                            i3 = a.right;
                        }
                        if (a.top > i2) {
                            i2 = a.top;
                        }
                        if (a.bottom < i) {
                            i5 = a.bottom;
                        } else {
                            i5 = i;
                        }
                        i = i5;
                    }
                }
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        if (list2 != null) {
            for (GeoPoint geoPoint : list2) {
                if (geoPoint != null) {
                    if (i4 == 0) {
                        i4 = geoPoint.getLongitudeE6();
                    }
                    if (i3 == 0) {
                        i3 = geoPoint.getLongitudeE6();
                    }
                    if (i2 == 0) {
                        i2 = geoPoint.getLatitudeE6();
                    }
                    if (i == 0) {
                        i = geoPoint.getLatitudeE6();
                    }
                    if (geoPoint.getLongitudeE6() < i4) {
                        i4 = geoPoint.getLongitudeE6();
                    }
                    if (geoPoint.getLongitudeE6() > i3) {
                        i3 = geoPoint.getLongitudeE6();
                    }
                    if (geoPoint.getLatitudeE6() > i2) {
                        i2 = geoPoint.getLatitudeE6();
                    }
                    if (geoPoint.getLatitudeE6() < i) {
                        i5 = geoPoint.getLatitudeE6();
                    } else {
                        i5 = i;
                    }
                    i = i5;
                }
            }
        }
        a = new Rect(i4, i2, i3, i);
        AppMethodBeat.o(98928);
        return a;
    }

    private boolean a() {
        AppMethodBeat.i(98929);
        b q = this.a.q();
        if (q == null) {
            AppMethodBeat.o(98929);
            return false;
        } else if (q.a() == 0.0f && q.b() == 0.0f) {
            AppMethodBeat.o(98929);
            return false;
        } else {
            AppMethodBeat.o(98929);
            return true;
        }
    }

    private boolean b() {
        AppMethodBeat.i(98930);
        b q = this.a.q();
        if (q == null) {
            AppMethodBeat.o(98930);
            return false;
        } else if (((double) Math.abs(q.a())) > 0.25d || ((double) Math.abs(q.b())) > 0.25d) {
            AppMethodBeat.o(98930);
            return true;
        } else {
            AppMethodBeat.o(98930);
            return false;
        }
    }

    private GeoPoint a(GeoPoint geoPoint, Rect rect) {
        AppMethodBeat.i(98931);
        if (geoPoint == null) {
            AppMethodBeat.o(98931);
            return null;
        }
        DoublePoint b = b(geoPoint);
        if (b == null || rect == null) {
            AppMethodBeat.o(98931);
            return null;
        }
        GeoPoint a = a(new DoublePoint(b.x - (((double) (rect.left - rect.right)) * 0.5d), b.y - (((double) (rect.top - rect.bottom)) * 0.5d)));
        AppMethodBeat.o(98931);
        return a;
    }

    private GeoPoint a(GeoPoint geoPoint, b bVar) {
        AppMethodBeat.i(98932);
        if (geoPoint == null) {
            AppMethodBeat.o(98932);
            return null;
        }
        DoublePoint b = b(geoPoint);
        if (b == null || bVar == null) {
            AppMethodBeat.o(98932);
            return null;
        }
        double d = b.x;
        double d2 = b.y;
        Rect rect = new Rect(this.c.g());
        int width = rect.width();
        int height = rect.height();
        float a = bVar.a() + 0.5f;
        float b2 = bVar.b() + 0.5f;
        if (((double) a) < 0.25d) {
            d += (0.25d - ((double) a)) * ((double) width);
        } else if (((double) a) > 0.75d) {
            d -= (((double) a) - 0.75d) * ((double) width);
        }
        if (((double) b2) < 0.25d) {
            d2 += ((double) height) * (0.25d - ((double) b2));
        } else if (((double) b2) > 0.75d) {
            d2 -= ((double) height) * (((double) b2) - 0.75d);
        }
        GeoPoint a2 = a(new DoublePoint(d, d2));
        AppMethodBeat.o(98932);
        return a2;
    }
}
