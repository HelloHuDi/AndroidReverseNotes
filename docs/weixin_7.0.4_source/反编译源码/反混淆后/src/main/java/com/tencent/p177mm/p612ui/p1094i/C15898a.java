package com.tencent.p177mm.p612ui.p1094i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p201az.C6332h;
import com.tencent.p177mm.p201az.C6332h.C6333a;
import com.tencent.p177mm.p612ui.p1094i.C46689b.C44374a;
import com.tencent.p177mm.p612ui.p629f.p630a.C44373f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import org.p1128b.p1129a.C16471a;
import org.p1128b.p1129a.p1432a.C46856c.C31204a;
import org.p1128b.p1130b.C16472a;
import org.p1128b.p1132d.C24599c;
import org.p1128b.p1132d.C41173i;
import org.p1128b.p1132d.C41174j;
import org.p1128b.p1132d.C44625a;
import org.p1128b.p1132d.C46860k;
import org.p1128b.p1134g.C46862d;
import org.p1128b.p1359e.C31207b;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.tencent.mm.ui.i.a */
public final class C15898a implements C44374a {
    Context context = null;
    C7306ak rgT = new C159041();
    C31207b zKT = null;
    public C41173i zKU = null;
    C41173i zKV = null;
    private boolean zKW = false;
    boolean zKX = false;
    public C15907b zKY = null;
    public C15906a zKZ = null;

    /* renamed from: com.tencent.mm.ui.i.a$2 */
    class C158992 implements Runnable {
        C158992() {
        }

        public final void run() {
            Object b;
            AppMethodBeat.m2504i(80341);
            try {
                C15898a.this.zKV = C15898a.this.zKT.enj();
                b = C15898a.this.zKT.mo41410b(C15898a.this.zKV);
            } catch (C16472a e) {
                b = null;
            }
            C15898a.this.rgT.sendMessage(C15898a.this.rgT.obtainMessage(1000, b));
            AppMethodBeat.m2505o(80341);
        }
    }

    /* renamed from: com.tencent.mm.ui.i.a$3 */
    class C159003 implements Runnable {
        C159003() {
        }

        public final void run() {
            AppMethodBeat.m2504i(80342);
            Object obj = C15905c.Finished;
            if (C15898a.this.zKU == null) {
                obj = C15905c.Failed;
            } else {
                C24599c c24599c = new C24599c(C41174j.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
                C15898a.this.zKT.mo41409a(C15898a.this.zKU, c24599c);
                try {
                    if (c24599c.enc().code != 200) {
                        obj = C15905c.Failed;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Twitter", e, "request error.", new Object[0]);
                    obj = C15905c.Failed;
                }
            }
            C15898a.this.rgT.sendMessage(C15898a.this.rgT.obtainMessage(1010, obj));
            AppMethodBeat.m2505o(80342);
        }
    }

    /* renamed from: com.tencent.mm.ui.i.a$1 */
    class C159041 extends C7306ak {
        C159041() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(80340);
            if (message.what == 1000) {
                String str = (String) message.obj;
                if (str != null) {
                    Context context = C15898a.this.context;
                    C15898a c15898a = C15898a.this;
                    if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                        C44373f.m80196L(context, "Error", "Application requires permission to access the Internet");
                    } else {
                        new C46689b(context, str, c15898a).show();
                    }
                } else {
                    C15898a.this.mo28145c(C15905c.Failed);
                }
            }
            if (message.what == 1010) {
                C15905c c15905c = (C15905c) message.obj;
                C15898a c15898a2 = C15898a.this;
                c15898a2.zKX = false;
                if (c15905c == C15905c.Failed) {
                    c15898a2.zKV = null;
                    C15898a.m24216a(null);
                }
                if (c15898a2.zKZ != null) {
                    c15898a2.zKZ.mo28156b(c15905c);
                }
            }
            AppMethodBeat.m2505o(80340);
        }
    }

    /* renamed from: com.tencent.mm.ui.i.a$c */
    public enum C15905c {
        Finished,
        Failed,
        Canceled;

        static {
            AppMethodBeat.m2505o(80349);
        }
    }

    /* renamed from: com.tencent.mm.ui.i.a$a */
    public interface C15906a {
        /* renamed from: b */
        void mo28156b(C15905c c15905c);
    }

    /* renamed from: com.tencent.mm.ui.i.a$b */
    public interface C15907b {
        /* renamed from: a */
        void mo28157a(C15905c c15905c);
    }

    public C15898a() {
        C41173i c41173i;
        AppMethodBeat.m2504i(80350);
        C16471a c16471a = new C16471a();
        c16471a.BYH = C16471a.m25279bg(C31204a.class);
        String str = "XMr2y8FEVEqZBcZ1TU3gLA";
        C46862d.m89099jn(str, "Invalid Api key");
        c16471a.BYE = str;
        str = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
        C46862d.m89099jn(str, "Invalid Api secret");
        c16471a.BYF = str;
        str = "wechatapp://sign-in-twitter.wechatapp.com/";
        C46862d.m89100r(str, "Callback can't be null");
        c16471a.BYG = str;
        C46862d.m89100r(c16471a.BYH, "You must specify a valid api through the provider() method");
        C46862d.m89099jn(c16471a.BYE, "You must provide an api key");
        C46862d.m89099jn(c16471a.BYF, "You must provide an api secret");
        this.zKT = c16471a.BYH.mo58450a(new C44625a(c16471a.BYE, c16471a.BYF, c16471a.BYG, c16471a.BYI, c16471a.scope, c16471a.BYJ));
        if (C1720g.m3534RN().mo5161QY()) {
            str = (String) C1720g.m3536RP().mo5239Ry().get(69377, null);
            String str2 = (String) C1720g.m3536RP().mo5239Ry().get(69378, null);
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                c41173i = null;
            } else {
                c41173i = new C41173i(str, str2);
            }
        } else {
            C4990ab.m7412e("Twitter", "acchas not ready for restoreTwitterAccessToken");
            c41173i = null;
        }
        this.zKU = c41173i;
        AppMethodBeat.m2505o(80350);
    }

    /* renamed from: a */
    public final void mo28144a(C15907b c15907b, Context context) {
        AppMethodBeat.m2504i(80351);
        if (this.zKW) {
            AppMethodBeat.m2505o(80351);
            return;
        }
        C7060h.pYm.mo8378a(583, 0, 1, false);
        this.zKY = c15907b;
        this.context = context;
        this.zKW = true;
        C7305d.post(new C158992(), "Twitter_doOAuth");
        AppMethodBeat.m2505o(80351);
    }

    public final boolean dKv() {
        return this.zKU != null;
    }

    /* renamed from: a */
    public final void mo28143a(C15906a c15906a) {
        AppMethodBeat.m2504i(80352);
        if (this.zKX) {
            AppMethodBeat.m2505o(80352);
            return;
        }
        this.zKZ = c15906a;
        this.zKX = true;
        C7305d.post(new C159003(), "Twitter_validationAccessToken");
        AppMethodBeat.m2505o(80352);
    }

    /* renamed from: a */
    static void m24216a(C41173i c41173i) {
        AppMethodBeat.m2504i(80353);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
        if (c41173i == null) {
            C1720g.m3536RP().mo5239Ry().set(69377, (Object) "");
            C1720g.m3536RP().mo5239Ry().set(69378, (Object) "");
            AppMethodBeat.m2505o(80353);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(69377, c41173i.token);
        C1720g.m3536RP().mo5239Ry().set(69378, c41173i.wFn);
        AppMethodBeat.m2505o(80353);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo28145c(C15905c c15905c) {
        AppMethodBeat.m2504i(80354);
        this.zKW = false;
        this.zKV = null;
        if (this.zKY != null) {
            this.zKY.mo28157a(c15905c);
        }
        AppMethodBeat.m2505o(80354);
    }

    /* renamed from: p */
    public final void mo28149p(final Bundle bundle) {
        AppMethodBeat.m2504i(80355);
        C1720g.m3539RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.ui.i.a$4$1 */
            class C159021 implements Runnable {
                C159021() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(80343);
                    C15898a.this.mo28145c(C15905c.Finished);
                    C7060h.pYm.mo8378a(583, 1, 1, false);
                    AppMethodBeat.m2505o(80343);
                }
            }

            /* renamed from: com.tencent.mm.ui.i.a$4$2 */
            class C159032 implements Runnable {
                C159032() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(80344);
                    C15898a.this.mo28145c(C15905c.Failed);
                    C7060h.pYm.mo8378a(583, 4, 1, false);
                    AppMethodBeat.m2505o(80344);
                }
            }

            public final void run() {
                C41173i c41173i = null;
                AppMethodBeat.m2504i(80345);
                if (C15898a.this.zKV == null) {
                    AppMethodBeat.m2505o(80345);
                    return;
                }
                C15898a.m24217qT(true);
                String string = bundle.getString("oauth_verifier");
                if (string != null) {
                    try {
                        c41173i = C15898a.this.zKT.mo41408a(C15898a.this.zKV, new C46860k(string));
                    } catch (C16472a e) {
                    }
                }
                if (c41173i != null) {
                    C15898a.this.zKU = c41173i;
                    C15898a.m24216a(C15898a.this.zKU);
                    new C7306ak(Looper.getMainLooper()).post(new C159021());
                    AppMethodBeat.m2505o(80345);
                    return;
                }
                new C7306ak(Looper.getMainLooper()).post(new C159032());
                AppMethodBeat.m2505o(80345);
            }

            public final String toString() {
                AppMethodBeat.m2504i(80346);
                String str = super.toString() + "|onComplete";
                AppMethodBeat.m2505o(80346);
                return str;
            }
        });
        AppMethodBeat.m2505o(80355);
    }

    public final void dKw() {
        AppMethodBeat.m2504i(80356);
        C15898a.m24217qT(false);
        mo28145c(C15905c.Failed);
        C7060h.pYm.mo8378a(583, 2, 1, false);
        AppMethodBeat.m2505o(80356);
    }

    public final void onCancel() {
        AppMethodBeat.m2504i(80357);
        C15898a.m24217qT(false);
        mo28145c(C15905c.Canceled);
        C7060h.pYm.mo8378a(583, 3, 1, false);
        AppMethodBeat.m2505o(80357);
    }

    /* renamed from: qT */
    static void m24217qT(boolean z) {
        AppMethodBeat.m2504i(80358);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C6333a(10251, z ? "1" : "2"));
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6332h(arrayList));
        AppMethodBeat.m2505o(80358);
    }
}
