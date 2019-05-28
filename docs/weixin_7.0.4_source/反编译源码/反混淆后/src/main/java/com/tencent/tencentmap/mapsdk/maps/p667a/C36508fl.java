package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24382gs.C24380b;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46789gm.C46788a;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fl */
public class C36508fl implements C24374fw {
    /* renamed from: a */
    private C24382gs f15367a;
    /* renamed from: b */
    private C16238gh f15368b;
    /* renamed from: c */
    private C46789gm f15369c;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fl$a */
    public interface C36509a {
        /* renamed from: a */
        void mo41913a(float f, GeoPoint geoPoint, double d);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m60407c(C36508fl c36508fl) {
        AppMethodBeat.m2504i(98936);
        boolean b = c36508fl.m60405b();
        AppMethodBeat.m2505o(98936);
        return b;
    }

    public C36508fl(C5876fn c5876fn) {
        AppMethodBeat.m2504i(98919);
        this.f15369c = (C46789gm) c5876fn;
        this.f15367a = c5876fn.mo12440a().mo58845j();
        this.f15368b = c5876fn.mo12445f();
        AppMethodBeat.m2505o(98919);
    }

    /* renamed from: a */
    public void mo57732a(float f) {
        AppMethodBeat.m2504i(98920);
        this.f15367a.mo40610d(f);
        AppMethodBeat.m2505o(98920);
    }

    /* renamed from: a */
    public void mo57733a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(98921);
        this.f15367a.mo40601a(geoPoint);
        AppMethodBeat.m2505o(98921);
    }

    /* renamed from: a */
    public void mo57734a(List<C41717j> list, Rect rect, C36509a c36509a) {
        AppMethodBeat.m2504i(98922);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(98922);
            return;
        }
        Rect rect2 = new Rect(this.f15369c.mo12446g());
        if (rect != null) {
            rect2.left += rect.left;
            rect2.right -= rect.right;
            rect2.top += rect.top;
            rect2.bottom -= rect.bottom;
        }
        final int width = rect2.width();
        final int height = rect2.height();
        final C46786fz g = this.f15369c.mo12440a().mo58839g();
        final int f = g.mo75377f();
        final List<C41717j> list2 = list;
        final Rect rect3 = rect;
        final C36509a c36509a2 = c36509a;
        this.f15369c.mo75423a(new C46788a() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x00c5  */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x00da A:{SYNTHETIC, Splitter:B:15:0x00da} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(98917);
                GeoPoint p = C36508fl.this.f15367a.mo40625p();
                float i = C36508fl.this.f15367a.mo40618i();
                GeoPoint geoPoint = null;
                float f = 4.0f;
                float o = C36508fl.this.f15367a.mo40624o();
                while (f >= o) {
                    C36508fl.this.mo57732a(f);
                    Rect a = C36508fl.m60395a(C36508fl.this, list2, C36508fl.this);
                    geoPoint = new GeoPoint(a.centerY(), a.centerX());
                    C36508fl.this.mo57733a(geoPoint);
                    GeoPoint geoPoint2 = new GeoPoint(a.top, a.left);
                    GeoPoint geoPoint3 = new GeoPoint(a.bottom, a.right);
                    DoublePoint b = C36508fl.this.mo29298b(geoPoint2);
                    DoublePoint b2 = C36508fl.this.mo29298b(geoPoint3);
                    Rect rect = new Rect();
                    rect.left = (int) Math.min(b.f2800x, b2.f2800x);
                    rect.right = (int) Math.max(b.f2800x, b2.f2800x);
                    rect.top = (int) Math.min(b.f2801y, b2.f2801y);
                    rect.bottom = (int) Math.max(b.f2801y, b2.f2801y);
                    if (width < rect.width() || height < rect.height()) {
                        f /= 1.01f;
                    } else {
                        if (!C36508fl.m60406b(C36508fl.this)) {
                            geoPoint = C36508fl.m60401a(C36508fl.this, geoPoint, rect3);
                        } else if (C36508fl.m60407c(C36508fl.this)) {
                            C24380b q = C36508fl.this.f15367a.mo40626q();
                            if (q != null) {
                                geoPoint = C36508fl.m60402a(C36508fl.this, geoPoint, q);
                            }
                        }
                        f = Math.max(o, f);
                        if (f != 60) {
                            g.mo75370a(f);
                        }
                        C36508fl.this.mo57733a(p);
                        C36508fl.this.mo57732a(i);
                        if (c36509a2 != null) {
                            try {
                                c36509a2.mo41913a(f, geoPoint, -1.0d);
                                AppMethodBeat.m2505o(98917);
                                return;
                            } catch (Exception e) {
                            }
                        }
                        AppMethodBeat.m2505o(98917);
                    }
                }
                f = Math.max(o, f);
                if (f != 60) {
                }
                C36508fl.this.mo57733a(p);
                C36508fl.this.mo57732a(i);
                if (c36509a2 != null) {
                }
                AppMethodBeat.m2505o(98917);
            }
        });
        if (f != 60) {
            g.mo75376e();
            g.mo75378g();
        }
        AppMethodBeat.m2505o(98922);
    }

    /* renamed from: a */
    public void mo57735a(List<C41717j> list, List<GeoPoint> list2, Rect rect, C36509a c36509a) {
        AppMethodBeat.m2504i(98923);
        if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            AppMethodBeat.m2505o(98923);
            return;
        }
        Rect rect2 = new Rect(this.f15369c.mo12446g());
        if (rect != null) {
            rect2.left += rect.left;
            rect2.right -= rect.right;
            rect2.top += rect.top;
            rect2.bottom -= rect.bottom;
        }
        final int width = rect2.width();
        final int height = rect2.height();
        final C46786fz g = this.f15369c.mo12440a().mo58839g();
        final int f = g.mo75377f();
        final List<C41717j> list3 = list;
        final List<GeoPoint> list4 = list2;
        final Rect rect3 = rect;
        final C36509a c36509a2 = c36509a;
        this.f15369c.mo75423a(new C46788a() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x00c7  */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x00dc A:{SYNTHETIC, Splitter:B:15:0x00dc} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public void mo12454a(GL10 gl10) {
                AppMethodBeat.m2504i(98918);
                GeoPoint p = C36508fl.this.f15367a.mo40625p();
                float i = C36508fl.this.f15367a.mo40618i();
                GeoPoint geoPoint = null;
                float f = 4.0f;
                float o = C36508fl.this.f15367a.mo40624o();
                while (f >= o) {
                    C36508fl.this.mo57732a(f);
                    Rect a = C36508fl.m60396a(C36508fl.this, list3, list4, C36508fl.this);
                    geoPoint = new GeoPoint(a.centerY(), a.centerX());
                    C36508fl.this.mo57733a(geoPoint);
                    GeoPoint geoPoint2 = new GeoPoint(a.top, a.left);
                    GeoPoint geoPoint3 = new GeoPoint(a.bottom, a.right);
                    DoublePoint b = C36508fl.this.mo29298b(geoPoint2);
                    DoublePoint b2 = C36508fl.this.mo29298b(geoPoint3);
                    Rect rect = new Rect();
                    rect.left = (int) Math.min(b.f2800x, b2.f2800x);
                    rect.right = (int) Math.max(b.f2800x, b2.f2800x);
                    rect.top = (int) Math.min(b.f2801y, b2.f2801y);
                    rect.bottom = (int) Math.max(b.f2801y, b2.f2801y);
                    if (width < rect.width() || height < rect.height()) {
                        f /= 1.01f;
                    } else {
                        if (!C36508fl.m60406b(C36508fl.this)) {
                            geoPoint = C36508fl.m60401a(C36508fl.this, geoPoint, rect3);
                        } else if (C36508fl.m60407c(C36508fl.this)) {
                            C24380b q = C36508fl.this.f15367a.mo40626q();
                            if (q != null) {
                                geoPoint = C36508fl.m60402a(C36508fl.this, geoPoint, q);
                            }
                        }
                        f = Math.max(o, f);
                        if (f != 60) {
                            g.mo75370a(f);
                        }
                        C36508fl.this.mo57733a(p);
                        C36508fl.this.mo57732a(i);
                        if (c36509a2 != null) {
                            try {
                                c36509a2.mo41913a(f, geoPoint, -1.0d);
                                AppMethodBeat.m2505o(98918);
                                return;
                            } catch (Exception e) {
                            }
                        }
                        AppMethodBeat.m2505o(98918);
                    }
                }
                f = Math.max(o, f);
                if (f != 60) {
                }
                C36508fl.this.mo57733a(p);
                C36508fl.this.mo57732a(i);
                if (c36509a2 != null) {
                }
                AppMethodBeat.m2505o(98918);
            }
        });
        if (f != 60) {
            g.mo75376e();
            g.mo75378g();
        }
        AppMethodBeat.m2505o(98923);
    }

    /* renamed from: a */
    public GeoPoint mo29297a(DoublePoint doublePoint) {
        AppMethodBeat.m2504i(98924);
        GeoPoint a = this.f15368b.mo29313a(this.f15367a.mo40627r(), (float) doublePoint.f2800x, (float) doublePoint.f2801y);
        AppMethodBeat.m2505o(98924);
        return a;
    }

    /* renamed from: b */
    public DoublePoint mo29298b(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(98925);
        double latitudeE6 = ((double) geoPoint.getLatitudeE6()) / 1000000.0d;
        double longitudeE6 = ((double) geoPoint.getLongitudeE6()) / 1000000.0d;
        PointF a = this.f15368b.mo29312a(this.f15367a.mo40627r(), latitudeE6, longitudeE6);
        DoublePoint doublePoint = new DoublePoint((double) a.x, (double) a.y);
        AppMethodBeat.m2505o(98925);
        return doublePoint;
    }

    /* renamed from: a */
    public double mo29295a(double d) {
        AppMethodBeat.m2504i(98926);
        double pow = (4.0076E7d / (Math.pow(2.0d, (double) ((float) (((double) ((float) this.f15367a.mo40619j())) + (Math.log((double) this.f15367a.mo40620k()) / Math.log(2.0d))))) * 256.0d)) * Math.cos((3.141592653589793d * d) / 180.0d);
        AppMethodBeat.m2505o(98926);
        return pow;
    }

    /* renamed from: a */
    public double mo29296a(Point point, Point point2) {
        return 0.0d;
    }

    /* renamed from: a */
    private Rect m60397a(List<C41717j> list, C24374fw c24374fw) {
        AppMethodBeat.m2504i(98927);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(98927);
            return null;
        }
        Rect a;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (C41717j a2 : list) {
            a = a2.mo20125a(c24374fw);
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
        AppMethodBeat.m2505o(98927);
        return a;
    }

    /* renamed from: a */
    private Rect m60398a(List<C41717j> list, List<GeoPoint> list2, C24374fw c24374fw) {
        int i;
        int i2;
        int i3;
        int i4;
        Rect a;
        int i5;
        AppMethodBeat.m2504i(98928);
        if (list != null) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            for (C41717j c41717j : list) {
                if (c41717j != null) {
                    a = c41717j.mo20125a(c24374fw);
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
        AppMethodBeat.m2505o(98928);
        return a;
    }

    /* renamed from: a */
    private boolean m60404a() {
        AppMethodBeat.m2504i(98929);
        C24380b q = this.f15367a.mo40626q();
        if (q == null) {
            AppMethodBeat.m2505o(98929);
            return false;
        } else if (q.mo40588a() == 0.0f && q.mo40590b() == 0.0f) {
            AppMethodBeat.m2505o(98929);
            return false;
        } else {
            AppMethodBeat.m2505o(98929);
            return true;
        }
    }

    /* renamed from: b */
    private boolean m60405b() {
        AppMethodBeat.m2504i(98930);
        C24380b q = this.f15367a.mo40626q();
        if (q == null) {
            AppMethodBeat.m2505o(98930);
            return false;
        } else if (((double) Math.abs(q.mo40588a())) > 0.25d || ((double) Math.abs(q.mo40590b())) > 0.25d) {
            AppMethodBeat.m2505o(98930);
            return true;
        } else {
            AppMethodBeat.m2505o(98930);
            return false;
        }
    }

    /* renamed from: a */
    private GeoPoint m60399a(GeoPoint geoPoint, Rect rect) {
        AppMethodBeat.m2504i(98931);
        if (geoPoint == null) {
            AppMethodBeat.m2505o(98931);
            return null;
        }
        DoublePoint b = mo29298b(geoPoint);
        if (b == null || rect == null) {
            AppMethodBeat.m2505o(98931);
            return null;
        }
        GeoPoint a = mo29297a(new DoublePoint(b.f2800x - (((double) (rect.left - rect.right)) * 0.5d), b.f2801y - (((double) (rect.top - rect.bottom)) * 0.5d)));
        AppMethodBeat.m2505o(98931);
        return a;
    }

    /* renamed from: a */
    private GeoPoint m60400a(GeoPoint geoPoint, C24380b c24380b) {
        AppMethodBeat.m2504i(98932);
        if (geoPoint == null) {
            AppMethodBeat.m2505o(98932);
            return null;
        }
        DoublePoint b = mo29298b(geoPoint);
        if (b == null || c24380b == null) {
            AppMethodBeat.m2505o(98932);
            return null;
        }
        double d = b.f2800x;
        double d2 = b.f2801y;
        Rect rect = new Rect(this.f15369c.mo12446g());
        int width = rect.width();
        int height = rect.height();
        float a = c24380b.mo40588a() + 0.5f;
        float b2 = c24380b.mo40590b() + 0.5f;
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
        GeoPoint a2 = mo29297a(new DoublePoint(d, d2));
        AppMethodBeat.m2505o(98932);
        return a2;
    }
}
