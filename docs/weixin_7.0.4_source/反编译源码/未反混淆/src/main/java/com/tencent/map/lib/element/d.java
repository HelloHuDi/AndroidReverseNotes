package com.tencent.map.lib.element;

import android.graphics.Rect;
import android.support.v4.widget.j;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.fn;
import com.tencent.tencentmap.mapsdk.maps.a.fw;
import com.tencent.tencentmap.mapsdk.maps.a.gj;
import com.tencent.tencentmap.mapsdk.maps.a.hc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d implements j {
    private fn a;
    private e b;
    private int[] c;
    private int[] d;
    private int e;
    private GeoPoint f;
    private boolean g = true;
    private int h = -1;
    private a i;
    private float j = -1.0f;
    private int k = -1;

    public static class a {
        public int a;
        public int b;
    }

    public d(e eVar) {
        AppMethodBeat.i(97863);
        a(eVar);
        AppMethodBeat.o(97863);
    }

    public synchronized void b(gj gjVar, fw fwVar) {
        AppMethodBeat.i(97864);
        if (gjVar == null) {
            AppMethodBeat.o(97864);
        } else {
            this.a = gjVar.b();
            float d = gjVar.d();
            if (this.j == -1.0f || this.j != d) {
                this.j = d;
                a(gjVar, fwVar);
            }
            gjVar.a(this);
            AppMethodBeat.o(97864);
        }
    }

    public synchronized boolean a(fw fwVar, float f, float f2) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(97865);
            if (this.a == null) {
                AppMethodBeat.o(97865);
            } else {
                TappedElement a = this.a.f().a(f, f2);
                if (a == null || a.itemId != ((long) s())) {
                    AppMethodBeat.o(97865);
                } else {
                    z = true;
                    AppMethodBeat.o(97865);
                }
            }
        }
        return z;
    }

    public Rect a(fw fwVar) {
        int i = j.INVALID_ID;
        AppMethodBeat.i(97866);
        if (this.b == null || this.b.b == null) {
            AppMethodBeat.o(97866);
            return null;
        }
        Iterator it = this.b.b.iterator();
        int i2 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        int i4 = j.INVALID_ID;
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
                AppMethodBeat.o(97866);
                return rect;
            }
        }
    }

    public ArrayList<GeoPoint> a() {
        return this.b.b;
    }

    public int[] b() {
        return this.c;
    }

    public int[] c() {
        return this.d;
    }

    public boolean d() {
        return this.b.h;
    }

    public int[] e() {
        return this.b.e;
    }

    public int[] f() {
        return this.b.f;
    }

    public float g() {
        return this.b.g;
    }

    public void a(int i, GeoPoint geoPoint) {
        this.e = i;
        this.f = geoPoint;
    }

    public GeoPoint h() {
        return this.f;
    }

    public int i() {
        return this.e;
    }

    public boolean j() {
        return this.b.i;
    }

    public boolean k() {
        return this.b.l;
    }

    public boolean l() {
        return this.b.n;
    }

    public int m() {
        AppMethodBeat.i(97867);
        int a = this.b.a();
        AppMethodBeat.o(97867);
        return a;
    }

    public float n() {
        return this.b.j;
    }

    public void a(float f) {
        this.b.j = f;
    }

    public float o() {
        if (this.b == null) {
            return 1.0f;
        }
        return this.b.m;
    }

    public synchronized void a(int i, int i2) {
        AppMethodBeat.i(97868);
        this.i = new a();
        this.i.a = i;
        this.i.b = i2;
        AppMethodBeat.o(97868);
    }

    public synchronized void p() {
        this.i = null;
    }

    public synchronized a q() {
        return this.i;
    }

    public String r() {
        String str;
        AppMethodBeat.i(97869);
        if (this.b.d != null && this.b.d.length > 0) {
            if (this.b.d[0] == 33) {
                str = "color_point_texture.png";
                AppMethodBeat.o(97869);
                return str;
            } else if (this.b.d[0] == 20) {
                str = "color_texture_line_v2.png";
                AppMethodBeat.o(97869);
                return str;
            }
        }
        if (StringUtil.isEmpty(this.b.k)) {
            str = "color_texture_flat_style.png";
            AppMethodBeat.o(97869);
            return str;
        }
        str = this.b.k;
        AppMethodBeat.o(97869);
        return str;
    }

    public final int s() {
        return this.h;
    }

    public final void a(int i) {
        this.h = i;
    }

    public synchronized void a(e eVar) {
        AppMethodBeat.i(97870);
        IllegalArgumentException illegalArgumentException;
        if (eVar == null) {
            illegalArgumentException = new IllegalArgumentException("LineOptions不能为空！");
            AppMethodBeat.o(97870);
            throw illegalArgumentException;
        } else if (eVar.b == null || eVar.b.size() < 2) {
            illegalArgumentException = new IllegalArgumentException("LineOptions中点的个数不能小于2");
            AppMethodBeat.o(97870);
            throw illegalArgumentException;
        } else if (eVar.c == null || eVar.c.length <= 0) {
            illegalArgumentException = new IllegalArgumentException("参数startIndexes不能为空!");
            AppMethodBeat.o(97870);
            throw illegalArgumentException;
        } else if (eVar.d == null || eVar.d.length <= 0) {
            illegalArgumentException = new IllegalArgumentException("参数colors不能为空!");
            AppMethodBeat.o(97870);
            throw illegalArgumentException;
        } else {
            this.b = eVar;
            this.c = eVar.c;
            this.d = eVar.d;
            this.h = -1;
            AppMethodBeat.o(97870);
        }
    }

    public void a(boolean z) {
        this.b.s = z;
    }

    public boolean t() {
        return this.b.s;
    }

    public Rect u() {
        Rect a;
        AppMethodBeat.i(97871);
        ArrayList arrayList = this.b.a;
        if (arrayList != null && !arrayList.isEmpty() && this.e >= 0 && this.e < arrayList.size()) {
            a = a(arrayList.subList(this.e, arrayList.size()));
            if (a != null) {
                this.b.t = a;
            }
        }
        a = this.b.t;
        AppMethodBeat.o(97871);
        return a;
    }

    public int v() {
        return this.b.u;
    }

    public String w() {
        return this.b.v;
    }

    public float x() {
        AppMethodBeat.i(97872);
        float b = this.b.b();
        AppMethodBeat.o(97872);
        return b;
    }

    public int[] y() {
        return new int[]{this.b.x, this.b.y};
    }

    public List<Integer> z() {
        return this.b.z;
    }

    public int A() {
        AppMethodBeat.i(97873);
        int c = this.b.c();
        AppMethodBeat.o(97873);
        return c;
    }

    private Rect a(List<GeoPoint> list) {
        AppMethodBeat.i(97874);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(97874);
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
        AppMethodBeat.o(97874);
        return rect;
    }

    private void a(gj gjVar, fw fwVar) {
        AppMethodBeat.i(97875);
        if (this.b == null) {
            AppMethodBeat.o(97875);
        } else if (this.b.r == 2 || this.b.r == 3) {
            List list = this.b.q;
            if (list == null || list.isEmpty()) {
                AppMethodBeat.o(97875);
                return;
            }
            ArrayList arrayList = this.b.a;
            if (arrayList == null || arrayList.size() < 2) {
                AppMethodBeat.o(97875);
                return;
            }
            int i;
            int size = arrayList.size();
            int[] iArr = new int[(size - 1)];
            for (i = 0; i < size - 1; i++) {
                iArr[i] = 0;
            }
            i = hc.a(arrayList, iArr, fwVar);
            if (i <= 0) {
                AppMethodBeat.o(97875);
                return;
            }
            ArrayList arrayList2 = new ArrayList(i + size);
            int i2;
            GeoPoint geoPoint;
            GeoPoint geoPoint2;
            List a;
            if (this.b.r == 2) {
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
                            a = hc.a(arrayList3, iArr[i2]);
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
                            a = hc.a(arrayList4, iArr[i3]);
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
            if (this.h != -1) {
                gjVar.a(this.h);
            }
            this.b.b = arrayList2;
            AppMethodBeat.o(97875);
        } else {
            AppMethodBeat.o(97875);
        }
    }

    public void B() {
        this.k = -1;
    }
}
