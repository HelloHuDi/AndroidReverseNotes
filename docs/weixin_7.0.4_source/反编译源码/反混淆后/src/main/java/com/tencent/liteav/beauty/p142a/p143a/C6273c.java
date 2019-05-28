package com.tencent.liteav.beauty.p142a.p143a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.a.a.c */
public class C6273c extends C0956b {
    /* renamed from: b */
    private Surface f1963b;
    /* renamed from: c */
    private boolean f1964c;

    public C6273c(C0955a c0955a, int i, int i2, boolean z) {
        super(c0955a);
        AppMethodBeat.m2504i(66844);
        mo3837a(i, i2);
        this.f1964c = z;
        AppMethodBeat.m2505o(66844);
    }

    /* renamed from: c */
    public void mo14502c() {
        AppMethodBeat.m2504i(66845);
        mo3836a();
        if (this.f1963b != null) {
            if (this.f1964c) {
                this.f1963b.release();
            }
            this.f1963b = null;
        }
        AppMethodBeat.m2505o(66845);
    }
}
