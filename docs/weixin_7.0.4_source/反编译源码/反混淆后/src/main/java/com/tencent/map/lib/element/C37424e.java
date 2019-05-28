package com.tencent.map.lib.element;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24347di;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.map.lib.element.e */
public class C37424e {
    /* renamed from: A */
    int f16076A = -7829368;
    /* renamed from: B */
    private int f16077B = C24347di.f4623c;
    /* renamed from: a */
    ArrayList<GeoPoint> f16078a;
    /* renamed from: b */
    ArrayList<GeoPoint> f16079b;
    /* renamed from: c */
    int[] f16080c;
    /* renamed from: d */
    int[] f16081d;
    /* renamed from: e */
    int[] f16082e;
    /* renamed from: f */
    int[] f16083f;
    /* renamed from: g */
    float f16084g;
    /* renamed from: h */
    boolean f16085h;
    /* renamed from: i */
    boolean f16086i;
    /* renamed from: j */
    float f16087j = 9.0f;
    /* renamed from: k */
    String f16088k = "";
    /* renamed from: l */
    boolean f16089l = true;
    /* renamed from: m */
    float f16090m = 1.0f;
    /* renamed from: n */
    boolean f16091n = true;
    /* renamed from: o */
    int f16092o = 0;
    /* renamed from: p */
    boolean f16093p = false;
    /* renamed from: q */
    List<GeoPoint> f16094q;
    /* renamed from: r */
    int f16095r = 0;
    /* renamed from: s */
    boolean f16096s = false;
    /* renamed from: t */
    Rect f16097t = new Rect();
    /* renamed from: u */
    int f16098u = 0;
    /* renamed from: v */
    String f16099v = "";
    /* renamed from: w */
    float f16100w = -1.0f;
    /* renamed from: x */
    int f16101x = -1;
    /* renamed from: y */
    int f16102y = -15248742;
    /* renamed from: z */
    List<Integer> f16103z = null;

    /* renamed from: com.tencent.map.lib.element.e$a */
    class C37425a {
        /* renamed from: a */
        public int f16104a;
        /* renamed from: b */
        public int f16105b;

        public C37425a(int i, int i2) {
            this.f16105b = i;
            this.f16104a = i2;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            C37425a c37425a = (C37425a) obj;
            if (c37425a.f16104a == this.f16104a && c37425a.f16105b == this.f16105b) {
                return true;
            }
            return false;
        }
    }

    public C37424e() {
        AppMethodBeat.m2504i(97876);
        AppMethodBeat.m2505o(97876);
    }

    /* renamed from: a */
    public C37424e mo60266a(List<GeoPoint> list) {
        AppMethodBeat.m2504i(97877);
        IllegalArgumentException illegalArgumentException;
        if (list == null || list.size() < 2) {
            illegalArgumentException = new IllegalArgumentException("参数points不能小于2!");
            AppMethodBeat.m2505o(97877);
            throw illegalArgumentException;
        }
        this.f16079b = new ArrayList(list.size());
        for (GeoPoint geoPoint : list) {
            if (geoPoint != null) {
                this.f16079b.add(geoPoint);
            }
        }
        if (this.f16079b.size() < 2) {
            illegalArgumentException = new IllegalArgumentException("参数points存在null值");
            AppMethodBeat.m2505o(97877);
            throw illegalArgumentException;
        }
        this.f16078a = new ArrayList(list.size());
        this.f16078a.addAll(this.f16079b);
        AppMethodBeat.m2505o(97877);
        return this;
    }

    /* renamed from: a */
    public C37424e mo60267a(int[] iArr) {
        AppMethodBeat.m2504i(97878);
        if (iArr == null || iArr.length <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("参数startIndexes不能为空!");
            AppMethodBeat.m2505o(97878);
            throw illegalArgumentException;
        }
        this.f16080c = iArr;
        AppMethodBeat.m2505o(97878);
        return this;
    }

    /* renamed from: a */
    public C37424e mo60263a(int i) {
        this.f16076A = i;
        return this;
    }

    /* renamed from: a */
    public C37424e mo60265a(String str) {
        this.f16088k = str;
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public void mo60270a(boolean z) {
        this.f16089l = z;
    }

    @Deprecated
    /* renamed from: a */
    public void mo60269a(float f) {
        this.f16090m = f;
    }

    /* renamed from: b */
    public C37424e mo60277b(int[] iArr) {
        int i = 0;
        AppMethodBeat.m2504i(97879);
        if (iArr == null || iArr.length <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("参数colors不能为空!");
            AppMethodBeat.m2505o(97879);
            throw illegalArgumentException;
        }
        if (this.f16085h) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(this.f16076A));
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (!arrayList.contains(Integer.valueOf(iArr[i2]))) {
                    arrayList.add(Integer.valueOf(iArr[i2]));
                }
                iArr[i2] = arrayList.indexOf(Integer.valueOf(iArr[i2]));
            }
            this.f16081d = iArr;
            int size = arrayList.size();
            this.f16082e = new int[size];
            while (i < size) {
                this.f16082e[i] = ((Integer) arrayList.get(i)).intValue();
                i++;
            }
            AppMethodBeat.m2505o(97879);
        } else {
            this.f16081d = iArr;
            AppMethodBeat.m2505o(97879);
        }
        return this;
    }

    /* renamed from: a */
    public C37424e mo60268a(int[] iArr, int[] iArr2) {
        int i = 0;
        AppMethodBeat.m2504i(97880);
        if (iArr == null || iArr.length <= 0 || iArr2 == null || iArr2.length <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("参数colors 、borderColors为空，或者两者长度不同");
            AppMethodBeat.m2505o(97880);
            throw illegalArgumentException;
        }
        if (this.f16085h) {
            int i2;
            if (iArr2.length < iArr.length) {
                int[] iArr3 = new int[iArr.length];
                for (i2 = 0; i2 < iArr.length; i2++) {
                    if (i2 < iArr2.length) {
                        iArr3[i2] = iArr2[i2];
                    } else {
                        iArr3[i2] = iArr2[iArr2.length - 1];
                    }
                }
                iArr2 = iArr3;
            }
            ArrayList arrayList = new ArrayList();
            this.f16081d = new int[iArr.length];
            for (i2 = 0; i2 < iArr.length; i2++) {
                C37425a c37425a = new C37425a(iArr[i2], iArr2[i2]);
                if (!arrayList.contains(c37425a)) {
                    arrayList.add(c37425a);
                }
                this.f16081d[i2] = arrayList.indexOf(c37425a);
            }
            int size = arrayList.size();
            this.f16082e = new int[size];
            this.f16083f = new int[size];
            while (i < size) {
                this.f16082e[i] = ((C37425a) arrayList.get(i)).f16105b;
                this.f16083f[i] = ((C37425a) arrayList.get(i)).f16104a;
                i++;
            }
            AppMethodBeat.m2505o(97880);
        } else {
            this.f16081d = iArr;
            AppMethodBeat.m2505o(97880);
        }
        return this;
    }

    /* renamed from: b */
    public C37424e mo60276b(boolean z) {
        this.f16085h = z;
        return this;
    }

    /* renamed from: c */
    public C37424e mo60281c(boolean z) {
        this.f16086i = z;
        return this;
    }

    /* renamed from: b */
    public C37424e mo60272b(float f) {
        this.f16087j = f;
        return this;
    }

    /* renamed from: c */
    public C37424e mo60279c(float f) {
        this.f16084g = f;
        return this;
    }

    /* renamed from: d */
    public C37424e mo60283d(boolean z) {
        this.f16091n = z;
        return this;
    }

    /* renamed from: b */
    public C37424e mo60273b(int i) {
        this.f16092o = i;
        return this;
    }

    /* renamed from: a */
    public int mo60262a() {
        return this.f16092o;
    }

    /* renamed from: a */
    public C37424e mo60264a(int i, List<GeoPoint> list) {
        AppMethodBeat.m2504i(97881);
        IllegalArgumentException illegalArgumentException;
        if (i != 1 && i != 2 && i != 3) {
            illegalArgumentException = new IllegalArgumentException("bezier曲线阶数为1，2，3");
            AppMethodBeat.m2505o(97881);
            throw illegalArgumentException;
        } else if (i == 1 && list != null && (list == null || list.size() != 0)) {
            illegalArgumentException = new IllegalArgumentException("bezier曲线控制点数目错误");
            AppMethodBeat.m2505o(97881);
            throw illegalArgumentException;
        } else if (i == 2 && (list == null || (list != null && list.size() != 1))) {
            illegalArgumentException = new IllegalArgumentException("bezier曲线控制点数目错误");
            AppMethodBeat.m2505o(97881);
            throw illegalArgumentException;
        } else if (i != 3 || (list != null && (list == null || list.size() == 2))) {
            this.f16095r = i;
            this.f16094q = list;
            AppMethodBeat.m2505o(97881);
            return this;
        } else {
            illegalArgumentException = new IllegalArgumentException("bezier曲线控制点数目错误");
            AppMethodBeat.m2505o(97881);
            throw illegalArgumentException;
        }
    }

    /* renamed from: e */
    public C37424e mo60285e(boolean z) {
        this.f16093p = z;
        return this;
    }

    /* renamed from: f */
    public C37424e mo60286f(boolean z) {
        this.f16096s = z;
        return this;
    }

    /* renamed from: c */
    public C37424e mo60280c(int i) {
        this.f16098u = i;
        return this;
    }

    /* renamed from: b */
    public C37424e mo60274b(String str) {
        this.f16099v = str;
        return this;
    }

    /* renamed from: d */
    public C37424e mo60282d(float f) {
        this.f16100w = f;
        return this;
    }

    /* renamed from: b */
    public C37424e mo60275b(List<Integer> list) {
        AppMethodBeat.m2504i(97882);
        if (!(list == null || list.size() % 2 == 0)) {
            list.add(list.get(list.size() - 1));
        }
        this.f16103z = list;
        AppMethodBeat.m2505o(97882);
        return this;
    }

    /* renamed from: b */
    public float mo60271b() {
        return this.f16100w;
    }

    /* renamed from: d */
    public void mo60284d(int i) {
        this.f16077B = i;
    }

    /* renamed from: c */
    public int mo60278c() {
        return this.f16077B;
    }
}
