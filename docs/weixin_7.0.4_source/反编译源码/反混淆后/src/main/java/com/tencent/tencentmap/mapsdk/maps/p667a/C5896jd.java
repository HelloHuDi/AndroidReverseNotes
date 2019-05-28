package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30992l;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jd */
public class C5896jd extends C16285jb {
    /* renamed from: a */
    private C36899hx f1654a;
    /* renamed from: b */
    private C31061iz f1655b;

    public C5896jd(C31061iz c31061iz, C36899hx c36899hx) {
        this.f1655b = c31061iz;
        this.f1654a = c36899hx;
    }

    /* renamed from: a */
    public Rect mo12518a() {
        AppMethodBeat.m2504i(100023);
        if (this.f1654a == null) {
            AppMethodBeat.m2505o(100023);
            return null;
        }
        Rect a = m9161a(this.f1654a.mo58890l());
        AppMethodBeat.m2505o(100023);
        return a;
    }

    /* renamed from: a */
    private Rect m9161a(Rect rect) {
        AppMethodBeat.m2504i(100024);
        if (rect == null) {
            AppMethodBeat.m2505o(100024);
            return null;
        }
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        int i5 = (rect.right + rect.left) / 2;
        int i6 = (rect.top + rect.bottom) / 2;
        int i7 = rect.bottom - rect.top;
        if (((float) (rect.right - rect.left)) < C36520ic.f15414s * 40.0f) {
            i = (int) (((float) i5) - (C36520ic.f15414s * 20.0f));
            i2 = (int) (((float) i5) + (C36520ic.f15414s * 20.0f));
        }
        if (((float) i7) < C36520ic.f15414s * 40.0f) {
            i3 = (int) (((float) i6) - (C36520ic.f15414s * 20.0f));
            i4 = (int) (((float) i6) + (C36520ic.f15414s * 20.0f));
        }
        Rect rect2 = new Rect(i, i3, i2, i4);
        AppMethodBeat.m2505o(100024);
        return rect2;
    }

    /* renamed from: b */
    public String mo12519b() {
        AppMethodBeat.m2504i(100025);
        if (this.f1654a == null) {
            AppMethodBeat.m2505o(100025);
            return null;
        }
        String m = this.f1654a.mo58891m();
        AppMethodBeat.m2505o(100025);
        return m;
    }

    /* renamed from: c */
    public void mo12520c() {
        AppMethodBeat.m2504i(100026);
        if (this.f1655b != null) {
            C30992l c30992l = this.f1655b.f14284s;
            if (!(this.f1654a == null || c30992l == null)) {
                c30992l.mo50171a(this.f1654a.f15581y);
            }
        }
        AppMethodBeat.m2505o(100026);
    }
}
