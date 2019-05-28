package com.tencent.p177mm.plugin.shake.p1019b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelstat.C18686e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21826a;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21828b;
import com.tencent.p177mm.plugin.shake.p506c.p507a.C43522b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.shake.b.c */
public final class C39688c extends C21828b implements C1202f {
    private Context context;
    float ecs = -85.0f;
    float ect = -1000.0f;
    private C42206a ecy = new C396872();
    C26443d fwu;
    int qfv = 1;
    int qfw = -1000;
    boolean qfz = false;
    boolean qrF = true;
    C46194b qrG;
    C34893a qrH;
    private int qrI = 0;
    C7306ak qrJ = new C7306ak();
    Runnable qrK = new C396891();

    /* renamed from: com.tencent.mm.plugin.shake.b.c$2 */
    class C396872 implements C42206a {
        C396872() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            boolean z2;
            boolean z3;
            AppMethodBeat.m2504i(24418);
            C18686e akf = C18686e.akf();
            if (i == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (C39688c.this.fwu == null) {
                z3 = false;
            } else {
                z3 = C39688c.this.fwu.fBD;
            }
            akf.mo33956a(2002, z2, z3, f, f2, (int) d2);
            C4990ab.m7417i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + C39688c.this.qfz, Float.valueOf(f2), Float.valueOf(f));
            if (z) {
                if (C39688c.this.qrF && C39688c.this.ecs == -85.0f && C39688c.this.ect == -1000.0f) {
                    C39688c.this.qrF = false;
                    C39688c.this.ecs = f2;
                    C39688c.this.ect = f;
                    C39688c.this.qfw = (int) d2;
                    C39688c.this.qfv = i;
                    C39688c.this.qfz = true;
                }
                AppMethodBeat.m2505o(24418);
                return false;
            }
            AppMethodBeat.m2505o(24418);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.b.c$1 */
    class C396891 implements Runnable {
        C396891() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24417);
            if (!(C39688c.this.qrJ == null || C39688c.this.qrK == null)) {
                C39688c.this.qrJ.removeCallbacks(C39688c.this.qrK);
            }
            if (C39688c.this.qrH != null) {
                C9638aw.m17182Rg().mo14547c(C39688c.this.qrH);
            }
            if (!(C39688c.this.qrG == null || C39688c.this.qrG.cQr == null)) {
                C39688c.this.qrH = new C34893a(C39688c.this.qrG.cQr);
            }
            if (C39688c.this.qrH != null) {
                C9638aw.m17182Rg().mo14541a(C39688c.this.qrH, 0);
            }
            AppMethodBeat.m2505o(24417);
        }
    }

    public C39688c(Context context, C21826a c21826a) {
        super(c21826a);
        AppMethodBeat.m2504i(24419);
        this.context = context;
        AppMethodBeat.m2505o(24419);
    }

    public final void init() {
        AppMethodBeat.m2504i(24420);
        C9638aw.m17182Rg().mo14539a(161, (C1202f) this);
        C9638aw.m17182Rg().mo14539a((int) ErrorCode.STARTDOWNLOAD_3, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1251, (C1202f) this);
        cjv();
        AppMethodBeat.m2505o(24420);
    }

    public final void start() {
        AppMethodBeat.m2504i(24421);
        reset();
        init();
        this.qrG = new C46194b(this.ect, this.ecs, this.qfw, this.qfv, "", "");
        C9638aw.m17182Rg().mo14541a(this.qrG, 0);
        if (!this.qfz) {
            if (this.fwu == null) {
                cjv();
            }
            this.fwu.mo44207b(this.ecy, true);
        }
        if (this.qrI <= 0) {
            this.qrI++;
        } else if (this.qrI <= 0 || this.qrI > 10) {
            this.qrI = 0;
        } else {
            this.qrI++;
            AppMethodBeat.m2505o(24421);
            return;
        }
        C4990ab.m7416i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
        C9638aw.m17182Rg().mo14541a(new C43522b(this.ect, this.ecs), 0);
        AppMethodBeat.m2505o(24421);
    }

    private void cjv() {
        AppMethodBeat.m2504i(24422);
        this.fwu = C26443d.agz();
        this.qrF = true;
        this.fwu.mo44204a(this.ecy, true);
        AppMethodBeat.m2505o(24422);
    }

    public final void reset() {
        AppMethodBeat.m2504i(24423);
        if (this.qrG != null) {
            C9638aw.m17182Rg().mo14547c(this.qrG);
        }
        if (this.qrH != null) {
            C9638aw.m17182Rg().mo14547c(this.qrH);
        }
        if (!(this.qrJ == null || this.qrK == null)) {
            this.qrJ.removeCallbacks(this.qrK);
        }
        AppMethodBeat.m2505o(24423);
    }

    public final void cjw() {
        AppMethodBeat.m2504i(24426);
        super.cjw();
        C9638aw.m17182Rg().mo14546b(161, (C1202f) this);
        C9638aw.m17182Rg().mo14546b((int) ErrorCode.STARTDOWNLOAD_3, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1251, (C1202f) this);
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        AppMethodBeat.m2505o(24426);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(24427);
        switch (c1207m.getType()) {
            case 161:
                C46194b c46194b = (C46194b) c1207m;
                if (c46194b.cju() == 3 || c46194b.cju() == 4) {
                    C4990ab.m7418v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
                    AppMethodBeat.m2505o(24427);
                    return;
                } else if (i2 == 0 && i == 0 && c46194b.ret == 0) {
                    this.qrJ.postDelayed(this.qrK, 3000);
                    AppMethodBeat.m2505o(24427);
                    return;
                } else {
                    C4990ab.m7412e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
                    this.qrT.mo25340b(null, 3);
                    AppMethodBeat.m2505o(24427);
                    return;
                }
            case ErrorCode.STARTDOWNLOAD_3 /*162*/:
                C34893a c34893a = (C34893a) c1207m;
                if (i2 == 0 && i == 0 && c34893a.ret == 0) {
                    List list = c34893a.qrD;
                    if (list.size() == 0) {
                        C4990ab.m7416i("MicroMsg.ShakeFriendService", "empty shake get list");
                        this.qrT.mo25340b(null, 3);
                        AppMethodBeat.m2505o(24427);
                        return;
                    }
                    this.qrT.mo25340b(list, 1);
                    AppMethodBeat.m2505o(24427);
                    return;
                }
                this.qrT.mo25340b(null, 3);
                AppMethodBeat.m2505o(24427);
                return;
            case 1251:
                C43522b c43522b = (C43522b) c1207m;
                if (i2 == 0 && i == 0) {
                    if (this.qrT != null) {
                        this.qrT.mo25339a(1251, c43522b.qsm, 1);
                        break;
                    }
                } else if (this.qrT != null) {
                    this.qrT.mo25339a(1251, null, 2);
                    AppMethodBeat.m2505o(24427);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(24427);
    }

    public final void pause() {
        AppMethodBeat.m2504i(24424);
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        AppMethodBeat.m2505o(24424);
    }

    public final void resume() {
        AppMethodBeat.m2504i(24425);
        if (this.fwu != null) {
            this.fwu.mo44204a(this.ecy, true);
        }
        AppMethodBeat.m2505o(24425);
    }
}
