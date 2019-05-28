package com.tencent.soter.p663a.p664g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p1351c.C46745e;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1107c.C16167a;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C30958e;
import com.tencent.soter.p663a.p1108f.C30958e.C16168a;
import com.tencent.soter.p663a.p1108f.C30958e.C30959b;
import com.tencent.soter.p663a.p1424e.C44465a;
import com.tencent.soter.p663a.p1424e.C44466b.C30957a;

/* renamed from: com.tencent.soter.a.g.k */
public final class C30962k extends C24299c {
    C30958e Axc = null;
    private boolean Axd = false;

    /* renamed from: com.tencent.soter.a.g.k$2 */
    class C309632 implements C24291b<C30959b> {
        final /* synthetic */ C30972i Axf;

        C309632(C30972i c30972i) {
            this.Axf = c30972i;
        }

        /* renamed from: dd */
        public final /* synthetic */ void mo40382dd(Object obj) {
            AppMethodBeat.m2504i(10561);
            C30959b c30959b = (C30959b) obj;
            C24299c.m37469eQ(C46745e.dQW().Avi, 0);
            C44476d.m80484i("Soter.TaskPrepareAppSecureKey", "soter: ask upload result: %b", Boolean.valueOf(c30959b.Awb));
            if (c30959b.Awb) {
                C30962k.this.mo70642b(new C16165c(this.Axf));
                AppMethodBeat.m2505o(10561);
                return;
            }
            C40997a.dQP();
            C30962k.this.mo70642b(new C16165c(9, "upload app secure key failed"));
            AppMethodBeat.m2505o(10561);
        }
    }

    /* renamed from: com.tencent.soter.a.g.k$1 */
    class C309641 implements C44465a {
        C309641() {
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(10559);
            C44476d.m80486w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", Integer.valueOf(i), str);
            C24299c.m37469eQ(C46745e.dQW().Avi, 0);
            C30962k.this.mo70642b(new C16165c(i, str));
            AppMethodBeat.m2505o(10559);
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(10560);
            C44476d.m80484i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
            if (C30962k.this.Axc != null) {
                C24299c.m37469eQ(C46745e.dQW().Avi, 2);
            } else {
                C24299c.m37469eQ(C46745e.dQW().Avi, 0);
            }
            C30962k c30962k = C30962k.this;
            C30972i dQS = C40997a.dQS();
            if (dQS == null) {
                C44476d.m80483e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
                C40997a.dQP();
                c30962k.mo70642b(new C16165c(3, "ask model is null even after generation."));
                AppMethodBeat.m2505o(10560);
            } else if (c30962k.Axc != null) {
                c30962k.Axc.mo55795bR(new C16168a(dQS.signature, dQS.Avn));
                c30962k.Axc.mo55794a(new C309632(dQS));
                c30962k.Axc.execute();
                AppMethodBeat.m2505o(10560);
            } else {
                C44476d.m80482d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                c30962k.mo70642b(new C16165c("treat as normal because you do not provide the net wrapper", dQS));
                AppMethodBeat.m2505o(10560);
            }
        }
    }

    public C30962k(C30958e c30958e, boolean z) {
        this.Axc = c30958e;
        this.Axd = z;
    }

    /* Access modifiers changed, original: final */
    public final boolean dRl() {
        AppMethodBeat.m2504i(10562);
        if (!C16167a.dRe().isInit()) {
            C44476d.m80486w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
            mo70642b(new C16165c(14));
            AppMethodBeat.m2505o(10562);
            return true;
        } else if (!C16167a.dRe().dRc()) {
            C44476d.m80486w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
            mo70642b(new C16165c(2));
            AppMethodBeat.m2505o(10562);
            return true;
        } else if (!C40997a.dQR() || this.Axd) {
            if (this.Axc == null) {
                C44476d.m80486w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
            }
            AppMethodBeat.m2505o(10562);
            return false;
        } else {
            C44476d.m80484i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
            mo70642b(new C16165c(C40997a.dQS()));
            AppMethodBeat.m2505o(10562);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
        AppMethodBeat.m2504i(10563);
        C44476d.m80486w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
        C40997a.dQP();
        AppMethodBeat.m2505o(10563);
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.m2504i(10564);
        C24299c.m37469eQ(C46745e.dQW().Avi, 1);
        C30957a c30957a = new C30957a();
        boolean z = this.Axd;
        c30957a.AvR |= 1;
        c30957a.AvT = z;
        c30957a.AvV = new C309641();
        c30957a.dRj().dRi();
        AppMethodBeat.m2505o(10564);
    }
}
