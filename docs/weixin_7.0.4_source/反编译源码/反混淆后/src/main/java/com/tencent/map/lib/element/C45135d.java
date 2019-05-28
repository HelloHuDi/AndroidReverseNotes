package com.tencent.map.lib.element;

import android.graphics.Rect;
import android.support.p057v4.widget.C8415j;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16263gj;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24374fw;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31053hc;
import com.tencent.tencentmap.mapsdk.maps.p667a.C5876fn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.map.lib.element.d */
public class C45135d implements C41717j {
    /* renamed from: a */
    private C5876fn f17853a;
    /* renamed from: b */
    private C37424e f17854b;
    /* renamed from: c */
    private int[] f17855c;
    /* renamed from: d */
    private int[] f17856d;
    /* renamed from: e */
    private int f17857e;
    /* renamed from: f */
    private GeoPoint f17858f;
    /* renamed from: g */
    private boolean f17859g = true;
    /* renamed from: h */
    private int f17860h = -1;
    /* renamed from: i */
    private C25719a f17861i;
    /* renamed from: j */
    private float f17862j = -1.0f;
    /* renamed from: k */
    private int f17863k = -1;

    /* renamed from: com.tencent.map.lib.element.d$a */
    public static class C25719a {
        /* renamed from: a */
        public int f5426a;
        /* renamed from: b */
        public int f5427b;
    }

    public C45135d(C37424e c37424e) {
        AppMethodBeat.m2504i(97863);
        mo72969a(c37424e);
        AppMethodBeat.m2505o(97863);
    }

    /* renamed from: b */
    public synchronized void mo20132b(C16263gj c16263gj, C24374fw c24374fw) {
        AppMethodBeat.m2504i(97864);
        if (c16263gj == null) {
            AppMethodBeat.m2505o(97864);
        } else {
            this.f17853a = c16263gj.mo29418b();
            float d = c16263gj.mo29420d();
            if (this.f17862j == -1.0f || this.f17862j != d) {
                this.f17862j = d;
                m82964a(c16263gj, c24374fw);
            }
            c16263gj.mo29417a(this);
            AppMethodBeat.m2505o(97864);
        }
    }

    /* renamed from: a */
    public synchronized boolean mo20130a(C24374fw c24374fw, float f, float f2) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(97865);
            if (this.f17853a == null) {
                AppMethodBeat.m2505o(97865);
            } else {
                TappedElement a = this.f17853a.mo12445f().mo29314a(f, f2);
                if (a == null || a.itemId != ((long) mo72988s())) {
                    AppMethodBeat.m2505o(97865);
                } else {
                    z = true;
                    AppMethodBeat.m2505o(97865);
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public Rect mo20125a(C24374fw c24374fw) {
        int i = C8415j.INVALID_ID;
        AppMethodBeat.m2504i(97866);
        if (this.f17854b == null || this.f17854b.f16079b == null) {
            AppMethodBeat.m2505o(97866);
            return null;
        }
        Iterator it = this.f17854b.f16079b.iterator();
        int i2 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i4 = C8415j.INVALID_ID;
        while (true) {
            int i5 = i;
            if (it.hasNext()) {
                GeoPoint geoPoint = (GeoPoint) it.next();
                int latitudeE6 = geoPoint.getLatitudeE6();
                int longitudeE6 = geoPoint.getLongitudeE6();
                if (latitudeE6 > i5) {
                    i = latitudeE6;
                } else {
                    i = i5;
                }
                if (latitudeE6 < i3) {
                    i3 = latitudeE6;
                }
                if (longitudeE6 > i4) {
                    i4 = longitudeE6;
                }
                if (longitudeE6 >= i2) {
                    longitudeE6 = i2;
                }
                i2 = longitudeE6;
            } else {
                Rect rect = new Rect(i2, i5, i4, i3);
                AppMethodBeat.m2505o(97866);
                return rect;
            }
        }
    }

    /* renamed from: a */
    public ArrayList<GeoPoint> mo72964a() {
        return this.f17854b.f16079b;
    }

    /* renamed from: b */
    public int[] mo72971b() {
        return this.f17855c;
    }

    /* renamed from: c */
    public int[] mo72972c() {
        return this.f17856d;
    }

    /* renamed from: d */
    public boolean mo72973d() {
        return this.f17854b.f16085h;
    }

    /* renamed from: e */
    public int[] mo72974e() {
        return this.f17854b.f16082e;
    }

    /* renamed from: f */
    public int[] mo72975f() {
        return this.f17854b.f16083f;
    }

    /* renamed from: g */
    public float mo72976g() {
        return this.f17854b.f16084g;
    }

    /* renamed from: a */
    public void mo72968a(int i, GeoPoint geoPoint) {
        this.f17857e = i;
        this.f17858f = geoPoint;
    }

    /* renamed from: h */
    public GeoPoint mo72977h() {
        return this.f17858f;
    }

    /* renamed from: i */
    public int mo72978i() {
        return this.f17857e;
    }

    /* renamed from: j */
    public boolean mo72979j() {
        return this.f17854b.f16086i;
    }

    /* renamed from: k */
    public boolean mo72980k() {
        return this.f17854b.f16089l;
    }

    /* renamed from: l */
    public boolean mo72981l() {
        return this.f17854b.f16091n;
    }

    /* renamed from: m */
    public int mo72982m() {
        AppMethodBeat.m2504i(97867);
        int a = this.f17854b.mo60262a();
        AppMethodBeat.m2505o(97867);
        return a;
    }

    /* renamed from: n */
    public float mo72983n() {
        return this.f17854b.f16087j;
    }

    /* renamed from: a */
    public void mo72965a(float f) {
        this.f17854b.f16087j = f;
    }

    /* renamed from: o */
    public float mo72984o() {
        if (this.f17854b == null) {
            return 1.0f;
        }
        return this.f17854b.f16090m;
    }

    /* renamed from: a */
    public synchronized void mo72967a(int i, int i2) {
        AppMethodBeat.m2504i(97868);
        this.f17861i = new C25719a();
        this.f17861i.f5426a = i;
        this.f17861i.f5427b = i2;
        AppMethodBeat.m2505o(97868);
    }

    /* renamed from: p */
    public synchronized void mo72985p() {
        this.f17861i = null;
    }

    /* renamed from: q */
    public synchronized C25719a mo72986q() {
        return this.f17861i;
    }

    /* renamed from: r */
    public String mo72987r() {
        String str;
        AppMethodBeat.m2504i(97869);
        if (this.f17854b.f16081d != null && this.f17854b.f16081d.length > 0) {
            if (this.f17854b.f16081d[0] == 33) {
                str = "color_point_texture.png";
                AppMethodBeat.m2505o(97869);
                return str;
            } else if (this.f17854b.f16081d[0] == 20) {
                str = "color_texture_line_v2.png";
                AppMethodBeat.m2505o(97869);
                return str;
            }
        }
        if (StringUtil.isEmpty(this.f17854b.f16088k)) {
            str = "color_texture_flat_style.png";
            AppMethodBeat.m2505o(97869);
            return str;
        }
        str = this.f17854b.f16088k;
        AppMethodBeat.m2505o(97869);
        return str;
    }

    /* renamed from: s */
    public final int mo72988s() {
        return this.f17860h;
    }

    /* renamed from: a */
    public final void mo72966a(int i) {
        this.f17860h = i;
    }

    /* renamed from: a */
    public synchronized void mo72969a(C37424e c37424e) {
        AppMethodBeat.m2504i(97870);
        IllegalArgumentException illegalArgumentException;
        if (c37424e == null) {
            illegalArgumentException = new IllegalArgumentException("LineOptions不能为空！");
            AppMethodBeat.m2505o(97870);
            throw illegalArgumentException;
        } else if (c37424e.f16079b == null || c37424e.f16079b.size() < 2) {
            illegalArgumentException = new IllegalArgumentException("LineOptions中点的个数不能小于2");
            AppMethodBeat.m2505o(97870);
            throw illegalArgumentException;
        } else if (c37424e.f16080c == null || c37424e.f16080c.length <= 0) {
            illegalArgumentException = new IllegalArgumentException("参数startIndexes不能为空!");
            AppMethodBeat.m2505o(97870);
            throw illegalArgumentException;
        } else if (c37424e.f16081d == null || c37424e.f16081d.length <= 0) {
            illegalArgumentException = new IllegalArgumentException("参数colors不能为空!");
            AppMethodBeat.m2505o(97870);
            throw illegalArgumentException;
        } else {
            this.f17854b = c37424e;
            this.f17855c = c37424e.f16080c;
            this.f17856d = c37424e.f16081d;
            this.f17860h = -1;
            AppMethodBeat.m2505o(97870);
        }
    }

    /* renamed from: a */
    public void mo72970a(boolean z) {
        this.f17854b.f16096s = z;
    }

    /* renamed from: t */
    public boolean mo72989t() {
        return this.f17854b.f16096s;
    }

    /* renamed from: u */
    public Rect mo72990u() {
        Rect a;
        AppMethodBeat.m2504i(97871);
        ArrayList arrayList = this.f17854b.f16078a;
        if (arrayList != null && !arrayList.isEmpty() && this.f17857e >= 0 && this.f17857e < arrayList.size()) {
            a = m82963a(arrayList.subList(this.f17857e, arrayList.size()));
            if (a != null) {
                this.f17854b.f16097t = a;
            }
        }
        a = this.f17854b.f16097t;
        AppMethodBeat.m2505o(97871);
        return a;
    }

    /* renamed from: v */
    public int mo72991v() {
        return this.f17854b.f16098u;
    }

    /* renamed from: w */
    public String mo72992w() {
        return this.f17854b.f16099v;
    }

    /* renamed from: x */
    public float mo72993x() {
        AppMethodBeat.m2504i(97872);
        float b = this.f17854b.mo60271b();
        AppMethodBeat.m2505o(97872);
        return b;
    }

    /* renamed from: y */
    public int[] mo72994y() {
        return new int[]{this.f17854b.f16101x, this.f17854b.f16102y};
    }

    /* renamed from: z */
    public List<Integer> mo72995z() {
        return this.f17854b.f16103z;
    }

    /* renamed from: A */
    public int mo72962A() {
        AppMethodBeat.m2504i(97873);
        int c = this.f17854b.mo60278c();
        AppMethodBeat.m2505o(97873);
        return c;
    }

    /* renamed from: a */
    private Rect m82963a(List<GeoPoint> list) {
        AppMethodBeat.m2504i(97874);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(97874);
            return null;
        }
        GeoPoint geoPoint = (GeoPoint) list.get(0);
        int longitudeE6 = geoPoint.getLongitudeE6();
        int longitudeE62 = geoPoint.getLongitudeE6();
        int latitudeE6 = geoPoint.getLatitudeE6();
        int latitudeE62 = geoPoint.getLatitudeE6();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int longitudeE63;
            geoPoint = (GeoPoint) list.get(i);
            if (geoPoint != null) {
                int latitudeE63 = geoPoint.getLatitudeE6();
                longitudeE63 = geoPoint.getLongitudeE6();
                if (longitudeE63 < longitudeE6) {
                    longitudeE6 = longitudeE63;
                } else if (longitudeE63 > longitudeE62) {
                    longitudeE62 = longitudeE63;
                }
                if (latitudeE63 < latitudeE62) {
                    longitudeE63 = latitudeE63;
                } else if (latitudeE63 > latitudeE6) {
                    longitudeE63 = latitudeE62;
                    latitudeE6 = latitudeE63;
                }
                i++;
                latitudeE62 = longitudeE63;
            }
            longitudeE63 = latitudeE62;
            i++;
            latitudeE62 = longitudeE63;
        }
        Rect rect = new Rect(longitudeE6, latitudeE6, longitudeE62, latitudeE62);
        AppMethodBeat.m2505o(97874);
        return rect;
    }

    /* renamed from: a */
    private void m82964a(C16263gj c16263gj, C24374fw c24374fw) {
        AppMethodBeat.m2504i(97875);
        if (this.f17854b == null) {
            AppMethodBeat.m2505o(97875);
        } else if (this.f17854b.f16095r == 2 || this.f17854b.f16095r == 3) {
            List list = this.f17854b.f16094q;
            if (list == null || list.isEmpty()) {
                AppMethodBeat.m2505o(97875);
                return;
            }
            ArrayList arrayList = this.f17854b.f16078a;
            if (arrayList == null || arrayList.size() < 2) {
                AppMethodBeat.m2505o(97875);
                return;
            }
            int i;
            int size = arrayList.size();
            int[] iArr = new int[(size - 1)];
            for (i = 0; i < size - 1; i++) {
                iArr[i] = 0;
            }
            i = C31053hc.m49925a(arrayList, iArr, c24374fw);
            if (i <= 0) {
                AppMethodBeat.m2505o(97875);
                return;
            }
            ArrayList arrayList2 = new ArrayList(i + size);
            int i2;
            GeoPoint geoPoint;
            GeoPoint geoPoint2;
            List a;
            if (this.f17854b.f16095r == 2) {
                List arrayList3 = new ArrayList(3);
                i = 0;
                int size2 = list.size();
                while (true) {
                    i2 = i;
                    if (i2 >= size - 1 || i2 >= size2) {
                        arrayList2.add(arrayList.get(size - 1));
                    } else {
                        GeoPoint geoPoint3 = new GeoPoint((GeoPoint) arrayList.get(i2));
                        geoPoint = new GeoPoint((GeoPoint) list.get(i2));
                        geoPoint2 = new GeoPoint((GeoPoint) arrayList.get(i2 + 1));
                        arrayList2.add(arrayList.get(i2));
                        arrayList3.clear();
                        arrayList3.add(geoPoint3);
                        arrayList3.add(geoPoint);
                        arrayList3.add(geoPoint2);
                        if (iArr[i2] > 0) {
                            a = C31053hc.m49927a(arrayList3, iArr[i2]);
                            if (!(a == null || a.isEmpty())) {
                                arrayList2.addAll(a);
                            }
                        }
                        i = i2 + 1;
                    }
                }
                arrayList2.add(arrayList.get(size - 1));
            } else {
                List arrayList4 = new ArrayList(4);
                int i3 = 0;
                i = 0;
                int size3 = list.size();
                while (true) {
                    i2 = i;
                    if (i3 >= size - 1 || i2 >= size3) {
                        arrayList2.add(arrayList.get(size - 1));
                    } else {
                        geoPoint = new GeoPoint((GeoPoint) arrayList.get(i3));
                        geoPoint2 = new GeoPoint((GeoPoint) list.get(i2));
                        GeoPoint geoPoint4 = new GeoPoint((GeoPoint) list.get(i2 + 1));
                        GeoPoint geoPoint5 = new GeoPoint((GeoPoint) arrayList.get(i3 + 1));
                        arrayList2.add(arrayList.get(i3));
                        arrayList4.clear();
                        arrayList4.add(geoPoint);
                        arrayList4.add(geoPoint2);
                        arrayList4.add(geoPoint4);
                        arrayList4.add(geoPoint5);
                        if (iArr[i3] > 0) {
                            a = C31053hc.m49927a(arrayList4, iArr[i3]);
                            if (!(a == null || a.isEmpty())) {
                                arrayList2.addAll(a);
                            }
                        }
                        i3++;
                        i = i2 + 2;
                    }
                }
                arrayList2.add(arrayList.get(size - 1));
            }
            if (this.f17860h != -1) {
                c16263gj.mo29415a(this.f17860h);
            }
            this.f17854b.f16079b = arrayList2;
            AppMethodBeat.m2505o(97875);
        } else {
            AppMethodBeat.m2505o(97875);
        }
    }

    /* renamed from: B */
    public void mo72963B() {
        this.f17863k = -1;
    }
}
