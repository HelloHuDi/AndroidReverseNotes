package com.tencent.p177mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18352nz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.extaccessories.b */
public final class C45908b implements C1816at {
    String eJM;
    private C43018a lRE;

    /* renamed from: com.tencent.mm.plugin.extaccessories.b$1 */
    class C340901 implements Runnable {
        C340901() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20463);
            if (!C9638aw.m17179RK()) {
                AppMethodBeat.m2505o(20463);
            } else if (C5046bo.isNullOrNil(C45908b.this.eJM)) {
                AppMethodBeat.m2505o(20463);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                C5046bo.m7583o(C45908b.this.eJM + "image/spen/", "spen_", 259200000);
                C4990ab.m7411d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(20463);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.extaccessories.b$a */
    public static class C43018a extends C4884c<C18352nz> {
        public C43018a() {
            AppMethodBeat.m2504i(20465);
            this.xxI = C18352nz.class.getName().hashCode();
            AppMethodBeat.m2505o(20465);
        }

        /* renamed from: a */
        private boolean m76408a(C18352nz c18352nz) {
            AppMethodBeat.m2504i(20466);
            if (c18352nz instanceof C18352nz) {
                C4990ab.m7410d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
                if (!(c18352nz.cKo == null || c18352nz.cKo.cKq == null || c18352nz.cKo.cKp == null)) {
                    try {
                        new SlookWritingBuddy(c18352nz.cKo.cKq).setImageWritingListener(new SubCoreExtAccessories$RegistSpenBuddyEventListener$1(this, c18352nz));
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", e.getMessage());
                    }
                }
                AppMethodBeat.m2505o(20466);
                return true;
            }
            C4990ab.m7414f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
            AppMethodBeat.m2505o(20466);
            return false;
        }
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(20468);
        C9638aw.m17190ZK();
        this.eJM = C18628c.getAccPath();
        File file = new File(this.eJM);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.eJM + "image/spen/");
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(20468);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(20469);
        C4990ab.m7410d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
        if (this.lRE == null) {
            this.lRE = new C43018a();
        }
        C4879a.xxA.mo10052c(this.lRE);
        C9638aw.m17180RS().mo10310m(new C340901(), 5000);
        AppMethodBeat.m2505o(20469);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(20470);
        C4990ab.m7410d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
        if (this.lRE != null) {
            C4879a.xxA.mo10053d(this.lRE);
        }
        AppMethodBeat.m2505o(20470);
    }
}
