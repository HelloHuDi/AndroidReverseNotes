package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.i;

public final class k extends c {
    e Axc = null;
    private boolean Axd = false;

    /* renamed from: com.tencent.soter.a.g.k$2 */
    class AnonymousClass2 implements b<e.b> {
        final /* synthetic */ i Axf;

        AnonymousClass2(i iVar) {
            this.Axf = iVar;
        }

        public final /* synthetic */ void dd(Object obj) {
            AppMethodBeat.i(10561);
            e.b bVar = (e.b) obj;
            c.eQ(com.tencent.soter.core.c.e.dQW().Avi, 0);
            d.i("Soter.TaskPrepareAppSecureKey", "soter: ask upload result: %b", Boolean.valueOf(bVar.Awb));
            if (bVar.Awb) {
                k.this.b(new c(this.Axf));
                AppMethodBeat.o(10561);
                return;
            }
            a.dQP();
            k.this.b(new c(9, "upload app secure key failed"));
            AppMethodBeat.o(10561);
        }
    }

    public k(e eVar, boolean z) {
        this.Axc = eVar;
        this.Axd = z;
    }

    /* Access modifiers changed, original: final */
    public final boolean dRl() {
        AppMethodBeat.i(10562);
        if (!com.tencent.soter.a.c.a.dRe().isInit()) {
            d.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
            b(new c(14));
            AppMethodBeat.o(10562);
            return true;
        } else if (!com.tencent.soter.a.c.a.dRe().dRc()) {
            d.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
            b(new c(2));
            AppMethodBeat.o(10562);
            return true;
        } else if (!a.dQR() || this.Axd) {
            if (this.Axc == null) {
                d.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
            }
            AppMethodBeat.o(10562);
            return false;
        } else {
            d.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
            b(new c(a.dQS()));
            AppMethodBeat.o(10562);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
        AppMethodBeat.i(10563);
        d.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
        a.dQP();
        AppMethodBeat.o(10563);
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.i(10564);
        c.eQ(com.tencent.soter.core.c.e.dQW().Avi, 1);
        com.tencent.soter.a.e.b.a aVar = new com.tencent.soter.a.e.b.a();
        boolean z = this.Axd;
        aVar.AvR |= 1;
        aVar.AvT = z;
        aVar.AvV = new com.tencent.soter.a.e.a() {
            public final void onError(int i, String str) {
                AppMethodBeat.i(10559);
                d.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", Integer.valueOf(i), str);
                c.eQ(com.tencent.soter.core.c.e.dQW().Avi, 0);
                k.this.b(new c(i, str));
                AppMethodBeat.o(10559);
            }

            public final void onSuccess() {
                AppMethodBeat.i(10560);
                d.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
                if (k.this.Axc != null) {
                    c.eQ(com.tencent.soter.core.c.e.dQW().Avi, 2);
                } else {
                    c.eQ(com.tencent.soter.core.c.e.dQW().Avi, 0);
                }
                k kVar = k.this;
                i dQS = a.dQS();
                if (dQS == null) {
                    d.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
                    a.dQP();
                    kVar.b(new c(3, "ask model is null even after generation."));
                    AppMethodBeat.o(10560);
                } else if (kVar.Axc != null) {
                    kVar.Axc.bR(new e.a(dQS.signature, dQS.Avn));
                    kVar.Axc.a(new AnonymousClass2(dQS));
                    kVar.Axc.execute();
                    AppMethodBeat.o(10560);
                } else {
                    d.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                    kVar.b(new c("treat as normal because you do not provide the net wrapper", dQS));
                    AppMethodBeat.o(10560);
                }
            }
        };
        aVar.dRj().dRi();
        AppMethodBeat.o(10564);
    }
}
