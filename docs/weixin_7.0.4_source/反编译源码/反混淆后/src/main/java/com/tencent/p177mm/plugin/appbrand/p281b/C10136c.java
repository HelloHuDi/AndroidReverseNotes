package com.tencent.p177mm.plugin.appbrand.p281b;

import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.p281b.C26788d.C101395;
import com.tencent.p177mm.plugin.appbrand.p281b.C26788d.C267907;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.appbrand.b.c */
public final class C10136c {
    final C6750i gPI;
    public final C26788d gWy;
    public final C6197a<C10137a, C10136c> gWz = new C6197a();

    /* renamed from: com.tencent.mm.plugin.appbrand.b.c$a */
    public interface C10137a {
        /* renamed from: a */
        void mo6006a(String str, C45524b c45524b);
    }

    public C10136c(C6750i c6750i) {
        AppMethodBeat.m2504i(86833);
        this.gPI = c6750i;
        this.gWy = new C26788d(c6750i) {
            /* Access modifiers changed, original: final */
            public final void awy() {
                AppMethodBeat.m2504i(86831);
                C10136c c10136c = C10136c.this;
                if (!c10136c.gPI.mFinished) {
                    c10136c.gPI.finish();
                }
                AppMethodBeat.m2505o(86831);
            }

            /* Access modifiers changed, original: final */
            /* renamed from: a */
            public final void mo21489a(C45524b c45524b) {
                AppMethodBeat.m2504i(86832);
                C10136c c10136c = C10136c.this;
                synchronized (c10136c.gWz) {
                    try {
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(86832);
                    }
                }
                for (C10137a a : (C10137a[]) c10136c.gWz.keySet().toArray(new C10137a[c10136c.gWz.size()])) {
                    a.mo6006a(c10136c.gPI.mAppId, c45524b);
                }
            }
        };
        AppMethodBeat.m2505o(86833);
    }

    /* renamed from: a */
    public final void mo21486a(C10137a c10137a) {
        AppMethodBeat.m2504i(86834);
        if (c10137a == null || C45524b.DESTROYED == this.gWy.awz()) {
            AppMethodBeat.m2505o(86834);
            return;
        }
        synchronized (this.gWz) {
            try {
                this.gWz.put(c10137a, this);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86834);
            }
        }
    }

    /* renamed from: b */
    public final void mo21488b(C10137a c10137a) {
        AppMethodBeat.m2504i(86835);
        if (c10137a == null || C45524b.DESTROYED == this.gWy.awz()) {
            AppMethodBeat.m2505o(86835);
            return;
        }
        synchronized (this.gWz) {
            try {
                this.gWz.remove(c10137a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86835);
            }
        }
    }

    public final boolean awx() {
        AppMethodBeat.m2504i(86836);
        C26788d c26788d = this.gWy;
        switch (C267907.gWN[c26788d.awz().ordinal()]) {
            case 1:
                AppMethodBeat.m2505o(86836);
                return true;
            case 2:
            case 3:
                AppMethodBeat.m2505o(86836);
                return false;
            case 4:
                boolean booleanValue = ((Boolean) new C101395().mo10372b(new C7306ak(c26788d.xCt.getLooper()))).booleanValue();
                AppMethodBeat.m2505o(86836);
                return booleanValue;
            default:
                AppMethodBeat.m2505o(86836);
                return false;
        }
    }
}
