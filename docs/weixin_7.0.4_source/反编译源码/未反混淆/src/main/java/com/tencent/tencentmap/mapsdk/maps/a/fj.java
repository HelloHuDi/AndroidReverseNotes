package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

public class fj extends ey {
    private static ThreadLocal<Object> b = new ThreadLocal();
    private static final ThreadLocal<ArrayList<fj>> h = new ThreadLocal<ArrayList<fj>>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.i(98900);
            ArrayList a = a();
            AppMethodBeat.o(98900);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        public final ArrayList<fj> a() {
            AppMethodBeat.i(98899);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(98899);
            return arrayList;
        }
    };
    private static final ThreadLocal<ArrayList<fj>> i = new ThreadLocal<ArrayList<fj>>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.i(98902);
            ArrayList a = a();
            AppMethodBeat.o(98902);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        public final ArrayList<fj> a() {
            AppMethodBeat.i(98901);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(98901);
            return arrayList;
        }
    };
    private static final ThreadLocal<ArrayList<fj>> j = new ThreadLocal<ArrayList<fj>>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.i(98904);
            ArrayList a = a();
            AppMethodBeat.o(98904);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        public final ArrayList<fj> a() {
            AppMethodBeat.i(98903);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(98903);
            return arrayList;
        }
    };
    private static final ThreadLocal<ArrayList<fj>> k = new ThreadLocal<ArrayList<fj>>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.i(98906);
            ArrayList a = a();
            AppMethodBeat.o(98906);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        public final ArrayList<fj> a() {
            AppMethodBeat.i(98905);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(98905);
            return arrayList;
        }
    };
    private static final ThreadLocal<ArrayList<fj>> l = new ThreadLocal<ArrayList<fj>>() {
        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object initialValue() {
            AppMethodBeat.i(98908);
            ArrayList a = a();
            AppMethodBeat.o(98908);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        public final ArrayList<fj> a() {
            AppMethodBeat.i(98907);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(98907);
            return arrayList;
        }
    };
    private static final Interpolator m = new LinearInterpolator();
    private static long v = 10;
    long c = -1;
    int d = 0;
    fg[] e;
    HashMap<Integer, fg> f;
    protected ex g;
    private boolean n = false;
    private int o = 0;
    private float p = 0.0f;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private long t = 300;
    private long u = 0;
    private int w = 0;
    private int x = 1;
    private Interpolator y = m;
    private ArrayList<Object> z = null;

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(98915);
        ey a = a();
        AppMethodBeat.o(98915);
        return a;
    }

    static {
        AppMethodBeat.i(98916);
        AppMethodBeat.o(98916);
    }

    public fj(ex exVar) {
        this.g = exVar;
    }

    public void a(double... dArr) {
        AppMethodBeat.i(98909);
        if (dArr == null || dArr.length == 0) {
            AppMethodBeat.o(98909);
        } else if (this.e == null || this.e.length == 0) {
            a(fg.a(0, dArr));
            AppMethodBeat.o(98909);
        } else {
            this.e[0].a(dArr);
            AppMethodBeat.o(98909);
        }
    }

    public void a(Object... objArr) {
        AppMethodBeat.i(98910);
        if (objArr == null || objArr.length == 0) {
            AppMethodBeat.o(98910);
        } else if (this.e == null || this.e.length == 0) {
            a(fg.a(0, null, objArr));
            AppMethodBeat.o(98910);
        } else {
            this.e[0].a(objArr);
            AppMethodBeat.o(98910);
        }
    }

    public void a(fg... fgVarArr) {
        AppMethodBeat.i(98911);
        this.e = fgVarArr;
        this.f = new HashMap(r1);
        for (fg fgVar : fgVarArr) {
            this.f.put(Integer.valueOf(fgVar.b()), fgVar);
        }
        AppMethodBeat.o(98911);
    }

    public static void a(long j) {
        v = j;
    }

    public void a(fi<?> fiVar) {
        AppMethodBeat.i(98912);
        if (!(fiVar == null || this.e == null || this.e.length <= 0)) {
            this.e[0].a((fi) fiVar);
        }
        AppMethodBeat.o(98912);
    }

    public ey a() {
        int i = 0;
        AppMethodBeat.i(98913);
        fj fjVar = (fj) super.clone();
        if (this.z != null) {
            ArrayList arrayList = this.z;
            fjVar.z = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                fjVar.z.add(arrayList.get(i2));
            }
        }
        fjVar.c = -1;
        fjVar.n = false;
        fjVar.o = 0;
        fjVar.d = 0;
        fjVar.q = false;
        fg[] fgVarArr = this.e;
        if (fgVarArr != null) {
            int length = fgVarArr.length;
            fjVar.e = new fg[length];
            fjVar.f = new HashMap(length);
            while (i < length) {
                fg a = fgVarArr[i].a();
                fjVar.e[i] = a;
                fjVar.f.put(Integer.valueOf(a.b()), a);
                i++;
            }
        }
        AppMethodBeat.o(98913);
        return fjVar;
    }

    public String toString() {
        AppMethodBeat.i(98914);
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.e != null) {
            for (fg fgVar : this.e) {
                str = str + "\n    " + fgVar.toString();
            }
        }
        AppMethodBeat.o(98914);
        return str;
    }
}
