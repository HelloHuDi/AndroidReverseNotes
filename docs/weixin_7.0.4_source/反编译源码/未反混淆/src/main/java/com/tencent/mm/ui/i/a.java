package com.tencent.mm.ui.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.f.a.f;
import java.util.ArrayList;
import org.b.d.i;
import org.b.d.j;
import org.b.d.k;
import org.b.g.d;

@SuppressLint({"HandlerLeak"})
public final class a implements com.tencent.mm.ui.i.b.a {
    Context context = null;
    ak rgT = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(80340);
            if (message.what == 1000) {
                String str = (String) message.obj;
                if (str != null) {
                    Context context = a.this.context;
                    a aVar = a.this;
                    if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                        f.L(context, "Error", "Application requires permission to access the Internet");
                    } else {
                        new b(context, str, aVar).show();
                    }
                } else {
                    a.this.c(c.Failed);
                }
            }
            if (message.what == 1010) {
                c cVar = (c) message.obj;
                a aVar2 = a.this;
                aVar2.zKX = false;
                if (cVar == c.Failed) {
                    aVar2.zKV = null;
                    a.a(null);
                }
                if (aVar2.zKZ != null) {
                    aVar2.zKZ.b(cVar);
                }
            }
            AppMethodBeat.o(80340);
        }
    };
    org.b.e.b zKT = null;
    public i zKU = null;
    i zKV = null;
    private boolean zKW = false;
    boolean zKX = false;
    public b zKY = null;
    public a zKZ = null;

    public enum c {
        Finished,
        Failed,
        Canceled;

        static {
            AppMethodBeat.o(80349);
        }
    }

    public interface a {
        void b(c cVar);
    }

    public interface b {
        void a(c cVar);
    }

    public a() {
        i iVar;
        AppMethodBeat.i(80350);
        org.b.a.a aVar = new org.b.a.a();
        aVar.BYH = org.b.a.a.bg(org.b.a.a.c.a.class);
        String str = "XMr2y8FEVEqZBcZ1TU3gLA";
        d.jn(str, "Invalid Api key");
        aVar.BYE = str;
        str = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
        d.jn(str, "Invalid Api secret");
        aVar.BYF = str;
        str = "wechatapp://sign-in-twitter.wechatapp.com/";
        d.r(str, "Callback can't be null");
        aVar.BYG = str;
        d.r(aVar.BYH, "You must specify a valid api through the provider() method");
        d.jn(aVar.BYE, "You must provide an api key");
        d.jn(aVar.BYF, "You must provide an api secret");
        this.zKT = aVar.BYH.a(new org.b.d.a(aVar.BYE, aVar.BYF, aVar.BYG, aVar.BYI, aVar.scope, aVar.BYJ));
        if (g.RN().QY()) {
            str = (String) g.RP().Ry().get(69377, null);
            String str2 = (String) g.RP().Ry().get(69378, null);
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                iVar = null;
            } else {
                iVar = new i(str, str2);
            }
        } else {
            ab.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
            iVar = null;
        }
        this.zKU = iVar;
        AppMethodBeat.o(80350);
    }

    public final void a(b bVar, Context context) {
        AppMethodBeat.i(80351);
        if (this.zKW) {
            AppMethodBeat.o(80351);
            return;
        }
        h.pYm.a(583, 0, 1, false);
        this.zKY = bVar;
        this.context = context;
        this.zKW = true;
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                Object b;
                AppMethodBeat.i(80341);
                try {
                    a.this.zKV = a.this.zKT.enj();
                    b = a.this.zKT.b(a.this.zKV);
                } catch (org.b.b.a e) {
                    b = null;
                }
                a.this.rgT.sendMessage(a.this.rgT.obtainMessage(1000, b));
                AppMethodBeat.o(80341);
            }
        }, "Twitter_doOAuth");
        AppMethodBeat.o(80351);
    }

    public final boolean dKv() {
        return this.zKU != null;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(80352);
        if (this.zKX) {
            AppMethodBeat.o(80352);
            return;
        }
        this.zKZ = aVar;
        this.zKX = true;
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(80342);
                Object obj = c.Finished;
                if (a.this.zKU == null) {
                    obj = c.Failed;
                } else {
                    org.b.d.c cVar = new org.b.d.c(j.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
                    a.this.zKT.a(a.this.zKU, cVar);
                    try {
                        if (cVar.enc().code != 200) {
                            obj = c.Failed;
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.Twitter", e, "request error.", new Object[0]);
                        obj = c.Failed;
                    }
                }
                a.this.rgT.sendMessage(a.this.rgT.obtainMessage(1010, obj));
                AppMethodBeat.o(80342);
            }
        }, "Twitter_validationAccessToken");
        AppMethodBeat.o(80352);
    }

    static void a(i iVar) {
        AppMethodBeat.i(80353);
        ah.getContext().getSharedPreferences(ah.doA(), 0);
        if (iVar == null) {
            g.RP().Ry().set(69377, (Object) "");
            g.RP().Ry().set(69378, (Object) "");
            AppMethodBeat.o(80353);
            return;
        }
        g.RP().Ry().set(69377, iVar.token);
        g.RP().Ry().set(69378, iVar.wFn);
        AppMethodBeat.o(80353);
    }

    /* Access modifiers changed, original: final */
    public final void c(c cVar) {
        AppMethodBeat.i(80354);
        this.zKW = false;
        this.zKV = null;
        if (this.zKY != null) {
            this.zKY.a(cVar);
        }
        AppMethodBeat.o(80354);
    }

    public final void p(final Bundle bundle) {
        AppMethodBeat.i(80355);
        g.RS().aa(new Runnable() {
            public final void run() {
                i iVar = null;
                AppMethodBeat.i(80345);
                if (a.this.zKV == null) {
                    AppMethodBeat.o(80345);
                    return;
                }
                a.qT(true);
                String string = bundle.getString("oauth_verifier");
                if (string != null) {
                    try {
                        iVar = a.this.zKT.a(a.this.zKV, new k(string));
                    } catch (org.b.b.a e) {
                    }
                }
                if (iVar != null) {
                    a.this.zKU = iVar;
                    a.a(a.this.zKU);
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(80343);
                            a.this.c(c.Finished);
                            h.pYm.a(583, 1, 1, false);
                            AppMethodBeat.o(80343);
                        }
                    });
                    AppMethodBeat.o(80345);
                    return;
                }
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(80344);
                        a.this.c(c.Failed);
                        h.pYm.a(583, 4, 1, false);
                        AppMethodBeat.o(80344);
                    }
                });
                AppMethodBeat.o(80345);
            }

            public final String toString() {
                AppMethodBeat.i(80346);
                String str = super.toString() + "|onComplete";
                AppMethodBeat.o(80346);
                return str;
            }
        });
        AppMethodBeat.o(80355);
    }

    public final void dKw() {
        AppMethodBeat.i(80356);
        qT(false);
        c(c.Failed);
        h.pYm.a(583, 2, 1, false);
        AppMethodBeat.o(80356);
    }

    public final void onCancel() {
        AppMethodBeat.i(80357);
        qT(false);
        c(c.Canceled);
        h.pYm.a(583, 3, 1, false);
        AppMethodBeat.o(80357);
    }

    static void qT(boolean z) {
        AppMethodBeat.i(80358);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.az.h.a(10251, z ? "1" : "2"));
        ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(new com.tencent.mm.az.h(arrayList));
        AppMethodBeat.o(80358);
    }
}
