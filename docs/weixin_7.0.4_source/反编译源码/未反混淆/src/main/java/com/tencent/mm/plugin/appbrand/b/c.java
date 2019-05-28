package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.d.AnonymousClass7;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;

public final class c {
    final i gPI;
    public final d gWy;
    public final android.support.v4.f.a<a, c> gWz = new android.support.v4.f.a();

    public interface a {
        void a(String str, b bVar);
    }

    public c(i iVar) {
        AppMethodBeat.i(86833);
        this.gPI = iVar;
        this.gWy = new d(iVar) {
            /* Access modifiers changed, original: final */
            public final void awy() {
                AppMethodBeat.i(86831);
                c cVar = c.this;
                if (!cVar.gPI.mFinished) {
                    cVar.gPI.finish();
                }
                AppMethodBeat.o(86831);
            }

            /* Access modifiers changed, original: final */
            public final void a(b bVar) {
                AppMethodBeat.i(86832);
                c cVar = c.this;
                synchronized (cVar.gWz) {
                    try {
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(86832);
                    }
                }
                for (a a : (a[]) cVar.gWz.keySet().toArray(new a[cVar.gWz.size()])) {
                    a.a(cVar.gPI.mAppId, bVar);
                }
            }
        };
        AppMethodBeat.o(86833);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(86834);
        if (aVar == null || b.DESTROYED == this.gWy.awz()) {
            AppMethodBeat.o(86834);
            return;
        }
        synchronized (this.gWz) {
            try {
                this.gWz.put(aVar, this);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86834);
            }
        }
    }

    public final void b(a aVar) {
        AppMethodBeat.i(86835);
        if (aVar == null || b.DESTROYED == this.gWy.awz()) {
            AppMethodBeat.o(86835);
            return;
        }
        synchronized (this.gWz) {
            try {
                this.gWz.remove(aVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86835);
            }
        }
    }

    public final boolean awx() {
        AppMethodBeat.i(86836);
        d dVar = this.gWy;
        switch (AnonymousClass7.gWN[dVar.awz().ordinal()]) {
            case 1:
                AppMethodBeat.o(86836);
                return true;
            case 2:
            case 3:
                AppMethodBeat.o(86836);
                return false;
            case 4:
                boolean booleanValue = ((Boolean) new bj<Boolean>() {
                    /* JADX WARNING: Missing block: B:5:0x001f, code skipped:
            if (r2 != false) goto L_0x0021;
     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final /* synthetic */ Object run() {
                        boolean z = true;
                        AppMethodBeat.i(86841);
                        if (d.this.dpQ() == d.this.gWC) {
                            boolean z2;
                            if ((d.this.gWC.gWW & 1) > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        z = false;
                        Boolean valueOf = Boolean.valueOf(z);
                        AppMethodBeat.o(86841);
                        return valueOf;
                    }
                }.b(new ak(dVar.xCt.getLooper()))).booleanValue();
                AppMethodBeat.o(86836);
                return booleanValue;
            default:
                AppMethodBeat.o(86836);
                return false;
        }
    }
}
