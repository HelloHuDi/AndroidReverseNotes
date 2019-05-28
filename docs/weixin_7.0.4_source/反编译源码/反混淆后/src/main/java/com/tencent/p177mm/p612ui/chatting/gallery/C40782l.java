package com.tencent.p177mm.p612ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashSet;

/* renamed from: com.tencent.mm.ui.chatting.gallery.l */
public final class C40782l implements C9017a {
    private static C40782l yXL;
    HashSet<Long> yXM = new HashSet();
    C9017a yXN;

    private C40782l() {
        AppMethodBeat.m2504i(32399);
        AppMethodBeat.m2505o(32399);
    }

    public static C40782l dGI() {
        AppMethodBeat.m2504i(32400);
        if (yXL == null) {
            yXL = new C40782l();
        }
        C40782l c40782l = yXL;
        AppMethodBeat.m2505o(32400);
        return c40782l;
    }

    /* renamed from: nr */
    public final boolean mo64339nr(long j) {
        AppMethodBeat.m2504i(32401);
        boolean contains = this.yXM.contains(Long.valueOf(j));
        AppMethodBeat.m2505o(32401);
        return contains;
    }

    /* renamed from: a */
    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
        AppMethodBeat.m2504i(32402);
        if (this.yXN != null) {
            this.yXN.mo20450a(j, j2, i, i2, obj, i3, i4, c1207m);
        }
        AppMethodBeat.m2505o(32402);
    }

    /* renamed from: a */
    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(32403);
        if (this.yXN != null) {
            this.yXN.mo20451a(j, j2, i, i2, obj, i3, i4, str, c1207m);
        } else {
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] hdImg end at background, msgLocalId:%d", Long.valueOf(C18628c.m29080XO().mo15340jf(j2).field_msgId));
            C40775c.m70563b(C4996ah.getContext(), r2, false);
        }
        this.yXM.remove(Long.valueOf(j2));
        AppMethodBeat.m2505o(32403);
    }

    /* renamed from: a */
    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(32404);
        if (this.yXN != null) {
            this.yXN.mo20449a(j, j2, i, i2, obj);
        }
        this.yXM.remove(Long.valueOf(j2));
        AppMethodBeat.m2505o(32404);
    }
}
