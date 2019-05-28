package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.i;

public final class l extends c {
    String AvS = null;
    private boolean Axd = false;
    private boolean Axg = false;
    private int gOW = -1;
    e rOc = null;
    private e rOd = null;

    /* renamed from: com.tencent.soter.a.g.l$3 */
    class AnonymousClass3 implements b<e.b> {
        final /* synthetic */ i Axi;

        AnonymousClass3(i iVar) {
            this.Axi = iVar;
        }

        public final /* synthetic */ void dd(Object obj) {
            AppMethodBeat.i(10568);
            e.b bVar = (e.b) obj;
            c.eQ(l.this.AvS, 0);
            d.i("Soter.TaskPrepareAuthKey", "soter: auth key upload result: %b", Boolean.valueOf(bVar.Awb));
            if (bVar.Awb) {
                l.this.b(new c(this.Axi));
                AppMethodBeat.o(10568);
                return;
            }
            a.cn(l.this.AvS, false);
            l.this.b(new c(10, String.format("upload auth key: %s failed", new Object[]{l.this.AvS})));
            AppMethodBeat.o(10568);
        }
    }

    static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(10573);
        lVar.dRv();
        AppMethodBeat.o(10573);
    }

    public l(int i, e eVar, e eVar2, boolean z) {
        this.gOW = i;
        this.rOc = eVar;
        this.Axd = z;
        this.Axg = true;
        this.rOd = eVar2;
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"DefaultLocale"})
    public final boolean dRl() {
        AppMethodBeat.i(10569);
        if (!com.tencent.soter.a.c.a.dRe().isInit()) {
            d.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
            b(new c(14));
            AppMethodBeat.o(10569);
            return true;
        } else if (com.tencent.soter.a.c.a.dRe().dRc()) {
            this.AvS = (String) com.tencent.soter.a.c.a.dRe().dRg().get(this.gOW, "");
            if (g.isNullOrNil(this.AvS)) {
                d.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new c(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.o(10569);
                return true;
            }
            boolean dQR = a.dQR();
            if (!dQR && a.aua(this.AvS)) {
                d.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
                a.cn(this.AvS, false);
            }
            if (!dQR && !this.Axg) {
                d.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
                b(new c(3));
                AppMethodBeat.o(10569);
                return true;
            } else if (a.aua(this.AvS) && !a.aub(this.AvS)) {
                d.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
                AppMethodBeat.o(10569);
                return false;
            } else if (!a.aua(this.AvS) || this.Axd) {
                if (this.rOc == null) {
                    d.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
                }
                AppMethodBeat.o(10569);
                return false;
            } else {
                d.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
                b(new c(a.auc(this.AvS)));
                AppMethodBeat.o(10569);
                return true;
            }
        } else {
            d.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
            b(new c(2));
            AppMethodBeat.o(10569);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
        AppMethodBeat.i(10570);
        d.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", this.AvS);
        a.cn(this.AvS, false);
        AppMethodBeat.o(10570);
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.i(10571);
        if (a.dQR() || !this.Axg) {
            dRv();
            AppMethodBeat.o(10571);
            return;
        }
        d.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
        com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<c>() {
            public final /* synthetic */ void a(com.tencent.soter.a.b.e eVar) {
                AppMethodBeat.i(10565);
                c cVar = (c) eVar;
                d.d("Soter.TaskPrepareAuthKey", "soter: prepare ask end: %s", cVar.toString());
                if (cVar.errCode == 0) {
                    l.a(l.this);
                    AppMethodBeat.o(10565);
                    return;
                }
                l.this.b(cVar);
                AppMethodBeat.o(10565);
            }
        }, false, this.rOd);
        AppMethodBeat.o(10571);
    }

    private void dRv() {
        AppMethodBeat.i(10572);
        c.eQ(this.AvS, 1);
        com.tencent.soter.a.e.b.a co = new com.tencent.soter.a.e.b.a().co(this.AvS, this.Axd);
        co.AvV = new com.tencent.soter.a.e.a() {
            public final void onError(int i, String str) {
                AppMethodBeat.i(10566);
                d.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", l.this.AvS, Integer.valueOf(i), str);
                c.eQ(l.this.AvS, 0);
                l.this.b(new c(i, str));
                AppMethodBeat.o(10566);
            }

            public final void onSuccess() {
                AppMethodBeat.i(10567);
                d.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
                if (l.this.rOc != null) {
                    c.eQ(l.this.AvS, 2);
                } else {
                    c.eQ(l.this.AvS, 0);
                }
                l lVar = l.this;
                i auc = a.auc(lVar.AvS);
                if (auc == null) {
                    d.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
                    a.cn(lVar.AvS, false);
                    lVar.b(new c(12, "auth key model is null even after generation."));
                    AppMethodBeat.o(10567);
                } else if (lVar.rOc != null) {
                    lVar.rOc.bR(new e.a(auc.signature, auc.Avn));
                    lVar.rOc.a(new AnonymousClass3(auc));
                    lVar.rOc.execute();
                    AppMethodBeat.o(10567);
                } else {
                    d.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                    lVar.b(new c("treat as normal because you do not provide the net wrapper", auc));
                    AppMethodBeat.o(10567);
                }
            }
        };
        co.dRj().dRi();
        AppMethodBeat.o(10572);
    }
}
