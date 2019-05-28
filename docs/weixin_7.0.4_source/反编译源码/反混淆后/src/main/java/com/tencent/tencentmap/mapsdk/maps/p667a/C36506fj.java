package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fj */
public class C36506fj extends C46782ey {
    /* renamed from: b */
    private static ThreadLocal<Object> f15342b = new ThreadLocal();
    /* renamed from: h */
    private static final ThreadLocal<ArrayList<C36506fj>> f15343h = new C365041();
    /* renamed from: i */
    private static final ThreadLocal<ArrayList<C36506fj>> f15344i = new C365052();
    /* renamed from: j */
    private static final ThreadLocal<ArrayList<C36506fj>> f15345j = new C162263();
    /* renamed from: k */
    private static final ThreadLocal<ArrayList<C36506fj>> f15346k = new C58754();
    /* renamed from: l */
    private static final ThreadLocal<ArrayList<C36506fj>> f15347l = new C162275();
    /* renamed from: m */
    private static final Interpolator f15348m = new LinearInterpolator();
    /* renamed from: v */
    private static long f15349v = 10;
    /* renamed from: c */
    long f15350c = -1;
    /* renamed from: d */
    int f15351d = 0;
    /* renamed from: e */
    C5872fg[] f15352e;
    /* renamed from: f */
    HashMap<Integer, C5872fg> f15353f;
    /* renamed from: g */
    protected C41047ex f15354g;
    /* renamed from: n */
    private boolean f15355n = false;
    /* renamed from: o */
    private int f15356o = 0;
    /* renamed from: p */
    private float f15357p = 0.0f;
    /* renamed from: q */
    private boolean f15358q = false;
    /* renamed from: r */
    private boolean f15359r = false;
    /* renamed from: s */
    private boolean f15360s = false;
    /* renamed from: t */
    private long f15361t = 300;
    /* renamed from: u */
    private long f15362u = 0;
    /* renamed from: w */
    private int f15363w = 0;
    /* renamed from: x */
    private int f15364x = 1;
    /* renamed from: y */
    private Interpolator f15365y = f15348m;
    /* renamed from: z */
    private ArrayList<Object> f15366z = null;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fj$4 */
    static class C58754 extends ThreadLocal<ArrayList<C36506fj>> {
        C58754() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.m2504i(98906);
            ArrayList a = mo12438a();
            AppMethodBeat.m2505o(98906);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final ArrayList<C36506fj> mo12438a() {
            AppMethodBeat.m2504i(98905);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(98905);
            return arrayList;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fj$3 */
    static class C162263 extends ThreadLocal<ArrayList<C36506fj>> {
        C162263() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.m2504i(98904);
            ArrayList a = mo29290a();
            AppMethodBeat.m2505o(98904);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final ArrayList<C36506fj> mo29290a() {
            AppMethodBeat.m2504i(98903);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(98903);
            return arrayList;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fj$5 */
    static class C162275 extends ThreadLocal<ArrayList<C36506fj>> {
        C162275() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.m2504i(98908);
            ArrayList a = mo29292a();
            AppMethodBeat.m2505o(98908);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final ArrayList<C36506fj> mo29292a() {
            AppMethodBeat.m2504i(98907);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(98907);
            return arrayList;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fj$1 */
    static class C365041 extends ThreadLocal<ArrayList<C36506fj>> {
        C365041() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.m2504i(98900);
            ArrayList a = mo57726a();
            AppMethodBeat.m2505o(98900);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final ArrayList<C36506fj> mo57726a() {
            AppMethodBeat.m2504i(98899);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(98899);
            return arrayList;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fj$2 */
    static class C365052 extends ThreadLocal<ArrayList<C36506fj>> {
        C365052() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.m2504i(98902);
            ArrayList a = mo57728a();
            AppMethodBeat.m2505o(98902);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final ArrayList<C36506fj> mo57728a() {
            AppMethodBeat.m2504i(98901);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(98901);
            return arrayList;
        }
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(98915);
        C46782ey a = mo29283a();
        AppMethodBeat.m2505o(98915);
        return a;
    }

    static {
        AppMethodBeat.m2504i(98916);
        AppMethodBeat.m2505o(98916);
    }

    public C36506fj(C41047ex c41047ex) {
        this.f15354g = c41047ex;
    }

    /* renamed from: a */
    public void mo29285a(double... dArr) {
        AppMethodBeat.m2504i(98909);
        if (dArr == null || dArr.length == 0) {
            AppMethodBeat.m2505o(98909);
        } else if (this.f15352e == null || this.f15352e.length == 0) {
            mo57731a(C5872fg.m9059a(0, dArr));
            AppMethodBeat.m2505o(98909);
        } else {
            this.f15352e[0].mo12432a(dArr);
            AppMethodBeat.m2505o(98909);
        }
    }

    /* renamed from: a */
    public void mo29286a(Object... objArr) {
        AppMethodBeat.m2504i(98910);
        if (objArr == null || objArr.length == 0) {
            AppMethodBeat.m2505o(98910);
        } else if (this.f15352e == null || this.f15352e.length == 0) {
            mo57731a(C5872fg.m9058a(0, null, objArr));
            AppMethodBeat.m2505o(98910);
        } else {
            this.f15352e[0].mo12433a(objArr);
            AppMethodBeat.m2505o(98910);
        }
    }

    /* renamed from: a */
    public void mo57731a(C5872fg... c5872fgArr) {
        AppMethodBeat.m2504i(98911);
        this.f15352e = c5872fgArr;
        this.f15353f = new HashMap(r1);
        for (C5872fg c5872fg : c5872fgArr) {
            this.f15353f.put(Integer.valueOf(c5872fg.mo12434b()), c5872fg);
        }
        AppMethodBeat.m2505o(98911);
    }

    /* renamed from: a */
    public static void m60388a(long j) {
        f15349v = j;
    }

    /* renamed from: a */
    public void mo57730a(C36503fi<?> c36503fi) {
        AppMethodBeat.m2504i(98912);
        if (!(c36503fi == null || this.f15352e == null || this.f15352e.length <= 0)) {
            this.f15352e[0].mo12431a((C36503fi) c36503fi);
        }
        AppMethodBeat.m2505o(98912);
    }

    /* renamed from: a */
    public C46782ey mo29283a() {
        int i = 0;
        AppMethodBeat.m2504i(98913);
        C36506fj c36506fj = (C36506fj) super.clone();
        if (this.f15366z != null) {
            ArrayList arrayList = this.f15366z;
            c36506fj.f15366z = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                c36506fj.f15366z.add(arrayList.get(i2));
            }
        }
        c36506fj.f15350c = -1;
        c36506fj.f15355n = false;
        c36506fj.f15356o = 0;
        c36506fj.f15351d = 0;
        c36506fj.f15358q = false;
        C5872fg[] c5872fgArr = this.f15352e;
        if (c5872fgArr != null) {
            int length = c5872fgArr.length;
            c36506fj.f15352e = new C5872fg[length];
            c36506fj.f15353f = new HashMap(length);
            while (i < length) {
                C5872fg a = c5872fgArr[i].mo12430a();
                c36506fj.f15352e[i] = a;
                c36506fj.f15353f.put(Integer.valueOf(a.mo12434b()), a);
                i++;
            }
        }
        AppMethodBeat.m2505o(98913);
        return c36506fj;
    }

    public String toString() {
        AppMethodBeat.m2504i(98914);
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f15352e != null) {
            for (C5872fg c5872fg : this.f15352e) {
                str = str + "\n    " + c5872fg.toString();
            }
        }
        AppMethodBeat.m2505o(98914);
        return str;
    }
}
