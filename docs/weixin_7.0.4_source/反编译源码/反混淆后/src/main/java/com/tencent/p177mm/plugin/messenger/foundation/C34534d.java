package com.tencent.p177mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p201az.C37500n;
import com.tencent.p177mm.p201az.C9062a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3454c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3455d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3462i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6974e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6975f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6976g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6978k;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6979l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6980m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6981n;
import com.tencent.p177mm.storage.C15433al;
import com.tencent.p177mm.storage.C23513cb;
import com.tencent.p177mm.storage.C35997bc;
import com.tencent.p177mm.storage.C35998bg;
import com.tencent.p177mm.storage.C40624aj;
import com.tencent.p177mm.storage.C46621ao;
import com.tencent.p177mm.storage.C46622bu;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7572bj;
import com.tencent.p177mm.storage.C7573br;
import com.tencent.p177mm.storage.C7579x;
import com.tencent.p177mm.storage.C7618aw;
import com.tencent.p177mm.storage.C7619ay;
import com.tencent.p177mm.storage.C7621bw;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.d */
public final class C34534d implements C9562c, C6982j {
    C40624aj oqb;
    C7621bw oqc;
    C7572bj oqd;
    C15433al oqe;
    C37500n oqf;
    C9062a oqg;
    C7573br oqh;
    C46621ao oqi;
    C7619ay oqj;
    C7618aw oqk;
    C35998bg oql;
    C46622bu oqm;
    C23513cb oqn;
    C7579x oqo;
    C35997bc oqp;

    public final C6976g bOl() {
        AppMethodBeat.m2504i(1028);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C9062a c9062a = this.oqg;
        AppMethodBeat.m2505o(1028);
        return c9062a;
    }

    public final C6973b bOm() {
        AppMethodBeat.m2504i(1029);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7579x c7579x = this.oqo;
        AppMethodBeat.m2505o(1029);
        return c7579x;
    }

    public final void onAccountInitialized(C1705c c1705c) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(1030);
        if (this.oqb != null) {
            C40624aj c40624aj = this.oqb;
            c40624aj.xXl.clear();
            c40624aj.xXm.clear();
        }
        if (this.oqf != null) {
            C1202f c1202f = this.oqf;
            c1202f.fBy = new HashMap();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(681, c1202f);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(806, c1202f);
        }
        AppMethodBeat.m2505o(1030);
    }

    public final /* bridge */ /* synthetic */ C6981n ahV() {
        return this.oqp;
    }

    public final /* synthetic */ C6979l bOn() {
        AppMethodBeat.m2504i(1031);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C46622bu c46622bu = this.oqm;
        AppMethodBeat.m2505o(1031);
        return c46622bu;
    }

    public final /* synthetic */ C6975f bOo() {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_SHAKA_ADD_13);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C35998bg c35998bg = this.oql;
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_SHAKA_ADD_13);
        return c35998bg;
    }

    public final /* synthetic */ C3455d bOp() {
        AppMethodBeat.m2504i(1033);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7618aw c7618aw = this.oqk;
        AppMethodBeat.m2505o(1033);
        return c7618aw;
    }

    public final /* synthetic */ C6974e bOq() {
        AppMethodBeat.m2504i(1034);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7619ay c7619ay = this.oqj;
        AppMethodBeat.m2505o(1034);
        return c7619ay;
    }

    /* renamed from: Yo */
    public final /* synthetic */ C3454c mo15373Yo() {
        AppMethodBeat.m2504i(1035);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C46621ao c46621ao = this.oqi;
        AppMethodBeat.m2505o(1035);
        return c46621ao;
    }

    /* renamed from: XU */
    public final /* synthetic */ C6978k mo15372XU() {
        AppMethodBeat.m2504i(1036);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7573br c7573br = this.oqh;
        AppMethodBeat.m2505o(1036);
        return c7573br;
    }

    /* renamed from: XR */
    public final /* synthetic */ C7310be mo15371XR() {
        AppMethodBeat.m2504i(FilterEnum4Shaka.MIC_SHAKA_ADD2_2);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C15433al c15433al = this.oqe;
        AppMethodBeat.m2505o(FilterEnum4Shaka.MIC_SHAKA_ADD2_2);
        return c15433al;
    }

    public final /* synthetic */ C6977h bOr() {
        AppMethodBeat.m2504i(1038);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7572bj c7572bj = this.oqd;
        AppMethodBeat.m2505o(1038);
        return c7572bj;
    }

    /* renamed from: XN */
    public final /* synthetic */ C6980m mo15370XN() {
        AppMethodBeat.m2504i(1039);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7621bw c7621bw = this.oqc;
        AppMethodBeat.m2505o(1039);
        return c7621bw;
    }

    /* renamed from: XM */
    public final /* synthetic */ C7309bd mo15369XM() {
        AppMethodBeat.m2504i(1040);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C40624aj c40624aj = this.oqb;
        AppMethodBeat.m2505o(1040);
        return c40624aj;
    }

    /* renamed from: XL */
    public final /* synthetic */ C3462i mo15368XL() {
        AppMethodBeat.m2504i(1041);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C37500n c37500n = this.oqf;
        AppMethodBeat.m2505o(1041);
        return c37500n;
    }
}
