package com.p081b.p082a.p083a;

import android.content.Context;
import android.os.Handler;
import com.p081b.p082a.p083a.C37157x.C17509a;
import com.p081b.p082a.p083a.C8482d.C8483a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.b.a.a.w */
final class C44977w extends C31911n {
    private static C44977w bIs;
    private boolean bIt;
    private int bIu;
    private long bIv;
    private long bIw;

    /* renamed from: wC */
    static C44977w m82353wC() {
        AppMethodBeat.m2504i(55606);
        if (bIs == null) {
            bIs = new C44977w();
        }
        C44977w c44977w = bIs;
        AppMethodBeat.m2505o(55606);
        return c44977w;
    }

    C44977w() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo18557a(Context context, Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55607);
        if (this.bIt) {
            if (C8487k.m15084wc().bCM) {
                C8487k.m15084wc().mo18565vY();
            }
        } else if (!C8487k.m15084wc().bCM) {
            try {
                C8487k.m15084wc().mo18558a(context, this);
            } catch (Exception e) {
            }
        }
        super.mo18557a(context, handler, c8483a);
        AppMethodBeat.m2505o(55607);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo18559a(Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55608);
        this.bIt = false;
        super.mo18559a(handler, c8483a);
        AppMethodBeat.m2505o(55608);
    }

    /* renamed from: a */
    public final void mo2178a(C31914p c31914p) {
        Object obj;
        AppMethodBeat.m2504i(55609);
        long j = c31914p.bFC;
        if (!this.bIt || j - this.bIw <= this.bIv) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(55609);
            return;
        }
        super.mo2178a(c31914p);
        AppMethodBeat.m2505o(55609);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42413a(int i, String str, long j, long j2) {
        AppMethodBeat.m2504i(55611);
        if (this.bIt) {
            stop();
        }
        super.mo42413a(i, str, j, j2);
        AppMethodBeat.m2505o(55611);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42416a(C37157x c37157x, long j, long j2) {
        Object obj;
        AppMethodBeat.m2504i(55610);
        if (c37157x.bIB == null) {
            c37157x.bIB = new C17509a();
        }
        float f = c37157x.bIB.bIE;
        if (!this.bIt || f < ((float) this.bIu)) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(55610);
            return;
        }
        super.mo42416a(c37157x, j, j2);
        AppMethodBeat.m2505o(55610);
    }
}
