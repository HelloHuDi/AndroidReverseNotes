package com.tencent.soter.p663a.p664g;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.p663a.C30954a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C46744e;
import com.tencent.soter.p663a.p1107c.C16167a;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C30958e;
import com.tencent.soter.p663a.p1108f.C30958e.C16168a;
import com.tencent.soter.p663a.p1108f.C30958e.C30959b;
import com.tencent.soter.p663a.p1424e.C44465a;
import com.tencent.soter.p663a.p1424e.C44466b.C30957a;

/* renamed from: com.tencent.soter.a.g.l */
public final class C24997l extends C24299c {
    String AvS = null;
    private boolean Axd = false;
    private boolean Axg = false;
    private int gOW = -1;
    C30958e rOc = null;
    private C30958e rOd = null;

    /* renamed from: com.tencent.soter.a.g.l$1 */
    class C249981 implements C16164b<C16165c> {
        C249981() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(10565);
            C16165c c16165c = (C16165c) c46744e;
            C44476d.m80482d("Soter.TaskPrepareAuthKey", "soter: prepare ask end: %s", c16165c.toString());
            if (c16165c.errCode == 0) {
                C24997l.m39164a(C24997l.this);
                AppMethodBeat.m2505o(10565);
                return;
            }
            C24997l.this.mo70642b(c16165c);
            AppMethodBeat.m2505o(10565);
        }
    }

    /* renamed from: com.tencent.soter.a.g.l$3 */
    class C249993 implements C24291b<C30959b> {
        final /* synthetic */ C30972i Axi;

        C249993(C30972i c30972i) {
            this.Axi = c30972i;
        }

        /* renamed from: dd */
        public final /* synthetic */ void mo40382dd(Object obj) {
            AppMethodBeat.m2504i(10568);
            C30959b c30959b = (C30959b) obj;
            C24299c.m37469eQ(C24997l.this.AvS, 0);
            C44476d.m80484i("Soter.TaskPrepareAuthKey", "soter: auth key upload result: %b", Boolean.valueOf(c30959b.Awb));
            if (c30959b.Awb) {
                C24997l.this.mo70642b(new C16165c(this.Axi));
                AppMethodBeat.m2505o(10568);
                return;
            }
            C40997a.m71093cn(C24997l.this.AvS, false);
            C24997l.this.mo70642b(new C16165c(10, String.format("upload auth key: %s failed", new Object[]{C24997l.this.AvS})));
            AppMethodBeat.m2505o(10568);
        }
    }

    /* renamed from: com.tencent.soter.a.g.l$2 */
    class C250002 implements C44465a {
        C250002() {
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(10566);
            C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", C24997l.this.AvS, Integer.valueOf(i), str);
            C24299c.m37469eQ(C24997l.this.AvS, 0);
            C24997l.this.mo70642b(new C16165c(i, str));
            AppMethodBeat.m2505o(10566);
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(10567);
            C44476d.m80484i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
            if (C24997l.this.rOc != null) {
                C24299c.m37469eQ(C24997l.this.AvS, 2);
            } else {
                C24299c.m37469eQ(C24997l.this.AvS, 0);
            }
            C24997l c24997l = C24997l.this;
            C30972i auc = C40997a.auc(c24997l.AvS);
            if (auc == null) {
                C44476d.m80483e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
                C40997a.m71093cn(c24997l.AvS, false);
                c24997l.mo70642b(new C16165c(12, "auth key model is null even after generation."));
                AppMethodBeat.m2505o(10567);
            } else if (c24997l.rOc != null) {
                c24997l.rOc.mo55795bR(new C16168a(auc.signature, auc.Avn));
                c24997l.rOc.mo55794a(new C249993(auc));
                c24997l.rOc.execute();
                AppMethodBeat.m2505o(10567);
            } else {
                C44476d.m80482d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                c24997l.mo70642b(new C16165c("treat as normal because you do not provide the net wrapper", auc));
                AppMethodBeat.m2505o(10567);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m39164a(C24997l c24997l) {
        AppMethodBeat.m2504i(10573);
        c24997l.dRv();
        AppMethodBeat.m2505o(10573);
    }

    public C24997l(int i, C30958e c30958e, C30958e c30958e2, boolean z) {
        this.gOW = i;
        this.rOc = c30958e;
        this.Axd = z;
        this.Axg = true;
        this.rOd = c30958e2;
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"DefaultLocale"})
    public final boolean dRl() {
        AppMethodBeat.m2504i(10569);
        if (!C16167a.dRe().isInit()) {
            C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
            mo70642b(new C16165c(14));
            AppMethodBeat.m2505o(10569);
            return true;
        } else if (C16167a.dRe().dRc()) {
            this.AvS = (String) C16167a.dRe().dRg().get(this.gOW, "");
            if (C24321g.isNullOrNil(this.AvS)) {
                C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                mo70642b(new C16165c(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.gOW)})));
                AppMethodBeat.m2505o(10569);
                return true;
            }
            boolean dQR = C40997a.dQR();
            if (!dQR && C40997a.aua(this.AvS)) {
                C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
                C40997a.m71093cn(this.AvS, false);
            }
            if (!dQR && !this.Axg) {
                C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
                mo70642b(new C16165c(3));
                AppMethodBeat.m2505o(10569);
                return true;
            } else if (C40997a.aua(this.AvS) && !C40997a.aub(this.AvS)) {
                C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
                AppMethodBeat.m2505o(10569);
                return false;
            } else if (!C40997a.aua(this.AvS) || this.Axd) {
                if (this.rOc == null) {
                    C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
                }
                AppMethodBeat.m2505o(10569);
                return false;
            } else {
                C44476d.m80484i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
                mo70642b(new C16165c(C40997a.auc(this.AvS)));
                AppMethodBeat.m2505o(10569);
                return true;
            }
        } else {
            C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
            mo70642b(new C16165c(2));
            AppMethodBeat.m2505o(10569);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dRm() {
        AppMethodBeat.m2504i(10570);
        C44476d.m80486w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", this.AvS);
        C40997a.m71093cn(this.AvS, false);
        AppMethodBeat.m2505o(10570);
    }

    /* Access modifiers changed, original: final */
    public final void execute() {
        AppMethodBeat.m2504i(10571);
        if (C40997a.dQR() || !this.Axg) {
            dRv();
            AppMethodBeat.m2505o(10571);
            return;
        }
        C44476d.m80482d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
        C30954a.m49587a(new C249981(), false, this.rOd);
        AppMethodBeat.m2505o(10571);
    }

    private void dRv() {
        AppMethodBeat.m2504i(10572);
        C24299c.m37469eQ(this.AvS, 1);
        C30957a co = new C30957a().mo50075co(this.AvS, this.Axd);
        co.AvV = new C250002();
        co.dRj().dRi();
        AppMethodBeat.m2505o(10572);
    }
}
