package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.qqmail.p486b.C28730ab.C12882e;
import com.tencent.p177mm.plugin.qqmail.p486b.C28730ab.C12883f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.qqmail.b.z */
public final class C12892z {
    ArrayList<C12879aa> puX = new ArrayList();
    C28730ab puY = C12884ac.ccD();
    C46151y puZ = null;
    boolean pva = false;
    C12883f pvb = new C128931();
    C12882e pvc = new C128942();

    /* renamed from: com.tencent.mm.plugin.qqmail.b.z$1 */
    class C128931 implements C12883f {
        C128931() {
        }

        /* renamed from: ad */
        public final void mo24912ad(String str, int i, int i2) {
            AppMethodBeat.m2504i(68031);
            if (i == i2) {
                C4990ab.m7417i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", Integer.valueOf(C12892z.this.puX.size()));
                if (C12892z.this.puZ != null) {
                    C12892z.this.puZ.mo74103Vl(str);
                }
                if (C12892z.this.puX.size() > 0) {
                    C4990ab.m7416i("MicroMsg.ShareMailQueue", "continue to send next mail");
                    C12892z.this.mo24919b((C12879aa) C12892z.this.puX.remove(0));
                    C12892z.this.puY.mo46888a((C12883f) this, C12892z.this.pvc);
                    AppMethodBeat.m2505o(68031);
                    return;
                }
                C4990ab.m7416i("MicroMsg.ShareMailQueue", "finished sent all mails");
                C12892z.this.pva = false;
            }
            AppMethodBeat.m2505o(68031);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.z$2 */
    class C128942 implements C12882e {
        C128942() {
        }

        /* renamed from: Vn */
        public final void mo24911Vn(String str) {
            AppMethodBeat.m2504i(68032);
            if (C12892z.this.puZ != null) {
                C46151y c46151y = C12892z.this.puZ;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7420w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
                } else {
                    C46151y.m86146Vm(str);
                    c46151y.mo74103Vl(str);
                }
            }
            if (C12892z.this.puX.size() > 0) {
                C4990ab.m7416i("MicroMsg.ShareMailQueue", "continue to send next mail");
                C12892z.this.mo24919b((C12879aa) C12892z.this.puX.remove(0));
                C12892z.this.puY.mo46888a(C12892z.this.pvb, (C12882e) this);
                AppMethodBeat.m2505o(68032);
                return;
            }
            C4990ab.m7416i("MicroMsg.ShareMailQueue", "final job fail");
            C12892z.this.pva = false;
            AppMethodBeat.m2505o(68032);
        }
    }

    public C12892z() {
        AppMethodBeat.m2504i(68033);
        AppMethodBeat.m2505o(68033);
    }

    /* renamed from: a */
    public final void mo24918a(C12879aa c12879aa) {
        AppMethodBeat.m2504i(68034);
        if (C1720g.m3534RN().mo5161QY()) {
            if (this.puZ == null) {
                this.puZ = new C46151y();
            }
            C46151y c46151y = this.puZ;
            String str = c12879aa.ptN;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
            } else {
                C46150w c46150w = new C46150w();
                c46150w.ptN = str;
                c46151y.puW.oof.add(c46150w);
                c46151y.save();
            }
            this.puX.add(c12879aa);
            C4990ab.m7411d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", Integer.valueOf(this.puX.size()));
            if (!this.pva) {
                C4990ab.m7410d("MicroMsg.ShareMailQueue", "start execute");
                if (this.puX.size() > 0) {
                    this.pva = true;
                    mo24919b((C12879aa) this.puX.remove(0));
                    this.puY.mo46888a(this.pvb, this.pvc);
                }
            }
            AppMethodBeat.m2505o(68034);
            return;
        }
        AppMethodBeat.m2505o(68034);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo24919b(C12879aa c12879aa) {
        AppMethodBeat.m2504i(68035);
        this.puY.clearData();
        this.puY.cEV = c12879aa.cEV;
        this.puY.ptN = c12879aa.ptN;
        this.puY.pur = c12879aa.pur;
        this.puY.pus = c12879aa.pus;
        this.puY.pve = c12879aa.pve;
        this.puY.mo46885X(c12879aa.pvf);
        this.puY.mo46886Y(c12879aa.pvg);
        this.puY.mo46887Z(c12879aa.pvh);
        AppMethodBeat.m2505o(68035);
    }
}
