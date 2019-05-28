package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46786fz.C36510a;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fx */
public class C31045fx {
    /* renamed from: g */
    public static final C31045fx f14121g = new C31045fx(1, null);
    /* renamed from: h */
    public static final C31045fx f14122h = new C31045fx(2, null, true);
    /* renamed from: i */
    public static final C31045fx f14123i = new C31045fx(104, null);
    /* renamed from: a */
    public int f14124a;
    /* renamed from: b */
    public double[] f14125b;
    /* renamed from: c */
    public long f14126c;
    /* renamed from: d */
    public boolean f14127d;
    /* renamed from: e */
    public boolean f14128e;
    /* renamed from: f */
    public Runnable f14129f;
    /* renamed from: j */
    private C24375fy f14130j;

    static {
        AppMethodBeat.m2504i(98949);
        AppMethodBeat.m2505o(98949);
    }

    public C31045fx() {
        this.f14126c = -1;
        this.f14127d = false;
    }

    public C31045fx(int i, double[] dArr) {
        this(i, dArr, false);
    }

    public C31045fx(int i, double[] dArr, boolean z) {
        this.f14126c = -1;
        this.f14127d = false;
        this.f14124a = i;
        this.f14125b = dArr;
        this.f14128e = z;
    }

    public C31045fx(Runnable runnable) {
        this.f14126c = -1;
        this.f14127d = false;
        this.f14124a = 6;
        this.f14129f = runnable;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo29421a() {
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public boolean mo50369a(C36510a c36510a) {
        AppMethodBeat.m2504i(98946);
        if (this.f14130j != null) {
            this.f14130j.mo40574a();
        }
        boolean a = mo29421a();
        c36510a.mo57736a(this);
        AppMethodBeat.m2505o(98946);
        return a;
    }

    /* renamed from: b */
    public void mo29422b() {
        AppMethodBeat.m2504i(98947);
        if (this.f14130j != null) {
            this.f14130j.mo40575b();
        }
        AppMethodBeat.m2505o(98947);
    }

    /* renamed from: c */
    public void mo50370c() {
        AppMethodBeat.m2504i(98948);
        if (this.f14130j != null) {
            this.f14130j.mo40576c();
        }
        AppMethodBeat.m2505o(98948);
    }
}
