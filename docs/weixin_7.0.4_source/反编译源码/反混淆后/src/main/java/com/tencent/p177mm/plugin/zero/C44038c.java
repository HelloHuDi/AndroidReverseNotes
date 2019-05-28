package com.tencent.p177mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.zero.p591a.C46481f;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.zero.c */
public final class C44038c {
    public static volatile C32467c<C46481f> vaf;
    private final C46481f vag;

    public C44038c() {
        AppMethodBeat.m2504i(58772);
        if (vaf != null) {
            this.vag = (C46481f) vaf.get();
            AppMethodBeat.m2505o(58772);
            return;
        }
        this.vag = null;
        AppMethodBeat.m2505o(58772);
    }

    /* renamed from: ca */
    public final void mo69729ca(Object obj) {
        AppMethodBeat.m2504i(58773);
        if (this.vag != null) {
            this.vag.mo24456ca(obj);
        }
        AppMethodBeat.m2505o(58773);
    }

    /* renamed from: a */
    public final boolean mo69728a(C40573tb c40573tb, boolean z) {
        AppMethodBeat.m2504i(58774);
        if (C1720g.m3531RK()) {
            long anU = C5046bo.anU();
            byte[] a = C1946aa.m4150a(c40573tb.wau);
            C4990ab.m7417i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", Long.valueOf(anU), Integer.valueOf(c40573tb.wat), Integer.valueOf(C5046bo.m7541cc(a)), Long.valueOf(Thread.currentThread().getId()));
            if (C5046bo.m7540cb(a)) {
                C4990ab.m7412e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
                AppMethodBeat.m2505o(58774);
                return false;
            }
            try {
                if (this.vag != null) {
                    this.vag.mo24455a(c40573tb, a, z);
                }
                C4990ab.m7417i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", Long.valueOf(anU), Integer.valueOf(c40573tb.wat), Long.valueOf(C5046bo.m7566gb(anU)));
                AppMethodBeat.m2505o(58774);
                return true;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", e, "", new Object[0]);
                AppMethodBeat.m2505o(58774);
                return false;
            }
        }
        C4990ab.m7412e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
        AppMethodBeat.m2505o(58774);
        return false;
    }

    /* renamed from: cc */
    public final void mo69730cc(Object obj) {
        AppMethodBeat.m2504i(58775);
        if (this.vag != null) {
            this.vag.mo24457cc(obj);
        }
        AppMethodBeat.m2505o(58775);
    }

    /* renamed from: cd */
    public final void mo69731cd(Object obj) {
        AppMethodBeat.m2504i(58776);
        if (this.vag != null) {
            this.vag.mo24458cd(obj);
        }
        AppMethodBeat.m2505o(58776);
    }
}
